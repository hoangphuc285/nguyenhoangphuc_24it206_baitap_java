package java.Java2.GUI;
import java.sql.*;
import java.util.*;

class Customer {
    private int id;
    private String name;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return name;
    }
}

public class CustomerDAO {
    public List<Customer> getAll() {
        List<Customer> list = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection()) {
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM customers");
            while (rs.next()) {
                list.add(new Customer(rs.getInt("id"), rs.getString("name")));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }
}
