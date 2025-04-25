package java.Java2.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class OrderManagementUI extends JFrame {
    private JComboBox<Customer> customerBox = new JComboBox<>();
    private JList<Product> productList = new JList<>();
    private JTextArea output = new JTextArea(10, 30);

    private CustomerDAO customerDAO = new CustomerDAO();
    private ProductDAO productDAO = new ProductDAO();
    private OrderDAO orderDAO = new OrderDAO();

    public OrderManagementUI() {
        setTitle("Quản lý đơn hàng");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        customerDAO.getAll().forEach(customerBox::addItem);
        productList.setListData(productDAO.getAll().toArray(new Product[0]));
        productList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        JButton btnAddOrder = new JButton("Thêm đơn hàng");
        JButton btnHistory = new JButton("Xem lịch sử đơn hàng");

        add(new JLabel("Chọn khách hàng:"));
        add(customerBox);
        add(new JLabel("Chọn sản phẩm:"));
        add(new JScrollPane(productList));
        add(btnAddOrder);
        add(btnHistory);
        add(new JScrollPane(output));

        btnAddOrder.addActionListener(e -> addOrder());
        btnHistory.addActionListener(e -> showHistory());

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addOrder() {
        Customer customer = (Customer) customerBox.getSelectedItem();
        List<Product> selected = productList.getSelectedValuesList();
        if (customer == null || selected.isEmpty()) return;

        Order order = new Order(customer);
        for (Product p : selected) order.addItem(new OrderItem(p, 1));
        orderDAO.addOrder(order);
        output.setText("Thêm đơn hàng thành công! Tổng tiền: " + order.getTotal() + "đ\n");
    }

    private void showHistory() {
        Customer customer = (Customer) customerBox.getSelectedItem();
        if (customer == null) return;

        List<Order> orders = orderDAO.getOrdersByCustomer(customer);
        StringBuilder sb = new StringBuilder("Lịch sử đơn hàng:\n");
        for (Order o : orders) {
            sb.append("Đơn #").append(o.getId()).append(" - Tổng: ").append(o.getTotal()).append("đ\n");
        }
        output.setText(sb.toString());
    }
}
