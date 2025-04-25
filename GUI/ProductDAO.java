package java.Java2.GUI;
import java.sql.*;
import java.util.*;
 class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return name + " - " + price + "đ";
    }
}
public class ProductDAO {
    public List<Product> getAll() {
        List<Product> list = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection()) {
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM products");
            while (rs.next()) {
                list.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price")));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }
}