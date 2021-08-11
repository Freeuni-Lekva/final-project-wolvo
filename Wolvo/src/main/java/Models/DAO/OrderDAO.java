package Models.DAO;

import Models.*;

import java.sql.*;
import java.util.*;
import java.util.Date;
import static Models.Constants.*;

public class OrderDAO {
    private Connection connection;

    public OrderDAO(Connection connection){
        this.connection = connection;
    }

    public List<Order> getOrders(){
        List<Order> orders = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from orders;");
            while (resultSet.next()) {
                orders.add(convertToOrder(resultSet));
            }
        } catch (SQLException throwables) {}
        return orders;
    }

    public List<Order> getUserOrders(int id){
        List<Order> orders = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from orders where user_id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                orders.add(convertToOrder(resultSet));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return orders;
    }

    public boolean addOrder(int user, int dish, String district, String address, int courier, int quantity){
        CourierDAO cDao = new CourierDAO(connection);
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        boolean b = false;
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "insert into orders (user_id, dish_id, order_date, district, courier_id, location, order_status, quantity) values (?,?,?,?,?,?,?,?);");
            statement.setInt(1, user);
            statement.setInt(2,dish);
            statement.setTimestamp(3,ts);
            statement.setString(4,district);
            statement.setInt(5,courier);
            statement.setString(6,address);
            statement.setString(7, ONWAY);
            statement.setInt(8, quantity);
            int i = statement.executeUpdate();
            if (i != 0) b = true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return b;
    }

    private Order convertToOrder(ResultSet rs) throws SQLException{
        Order o = new Order();
        o.setId(rs.getInt("order_id"));
        o.setUser(rs.getInt("user_id"));
        o.setDish(rs.getInt("dish_id"));
        o.setOrderDate(rs.getTimestamp("order_date"));
        o.setReceiveDate(rs.getTimestamp("receive_date"));
        Status os = new OrderStatus();
        os.setStatus(rs.getString("order_status"));
        o.setOrderStatus(os);
        o.setDistrict(rs.getString("district"));
        o.setCourier(rs.getInt("courier_id"));
        o.setAddress(rs.getString("location"));
        o.setQuantity(rs.getInt("quantity"));
        return o;
    }
}
