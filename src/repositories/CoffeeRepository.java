package repositories;

import data.interfaces.IDB;
import repositories.interfaces.ICoffeeRepository;

import java.sql.*;



public class CoffeeRepository implements ICoffeeRepository {
    private final IDB db;

    public CoffeeRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createCoffee(double price, String description) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO coffee(price, description) VALUES (?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setDouble(1, price);
            st.setString(2, description);
            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean getOrder(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,price, description FROM coffee WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                System.out.println(rs.getInt("id") + " | " + rs.getFloat("price") + " | " + rs.getString("description"));
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean getAllOrders() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,price, description FROM coffee";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " + rs.getFloat("price") + " | " + rs.getString("description"));
            }
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }
}
