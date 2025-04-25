package java.Java2.GUI;
import java.sql.*;
import java.util.*;
class Order {
    private int id;
    private Customer customer;
    private List<OrderItem> items = new ArrayList<>();

    public Order(Customer customer) {
        this.customer = customer;
    }

    public void setId(int id) { this.id = id; }
    public int getId() { return id; }
    public Customer getCustomer() { return customer; }
    public List<OrderItem> getItems() { return items; }

    public void addItem(OrderItem item) { items.add(item); }

    public double getTotal() {
        return items.stream().mapToDouble(OrderItem::getSubtotal).sum();
    }
}
class OrderItem {
    private Product product;
    private int quantity;

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }
    public double getSubtotal() { return quantity * product.getPrice(); }
}
public class OrderDAO {
    public void addOrder(Order order) {
        try (Connection conn = DBUtil.getConnection()) {
            conn.setAutoCommit(false);

            PreparedStatement ps = conn.prepareStatement("INSERT INTO orders(customer_id) VALUES(?)", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, order.getCustomer().getId());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int orderId = rs.getInt(1);
                order.setId(orderId);

                PreparedStatement psItem = conn.prepareStatement("INSERT INTO order_items(order_id, product_id, quantity) VALUES(?, ?, ?)");
                for (OrderItem item : order.getItems()) {
                    psItem.setInt(1, orderId);
                    psItem.setInt(2, item.getProduct().getId());
                    psItem.setInt(3, item.getQuantity());
                    psItem.addBatch();
                }
                psItem.executeBatch();
            }
            conn.commit();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public List<Order> getOrdersByCustomer(Customer customer) {
        List<Order> orders = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM orders WHERE customer_id = ?");
            ps.setInt(1, customer.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Order order = new Order(customer);
                order.setId(rs.getInt("id"));

                PreparedStatement psItems = conn.prepareStatement("SELECT * FROM order_items JOIN products ON order_items.product_id = products.id WHERE order_id = ?");
                psItems.setInt(1, order.getId());
                ResultSet itemRs = psItems.executeQuery();
                while (itemRs.next()) {
                    Product product = new Product(itemRs.getInt("product_id"), itemRs.getString("name"), itemRs.getDouble("price"));
                    OrderItem item = new OrderItem(product, itemRs.getInt("quantity"));
                    order.addItem(item);
                }
                orders.add(order);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return orders;
    }
}
