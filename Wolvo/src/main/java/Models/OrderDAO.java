package Models.DAO;

import Models.Order;
import java.sql.*;
import java.util.*;

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
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                orders.add(convertToRestaurant(resultSet));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return orders;
    }

    public String addOrder(int user, int dish, String district, String address){
        CourierDAO cDao = new CourierDAO(connection);
        int courier = -1;
        for(Courier c : cDao.getCouriers()){
            if(c.isAdded() && c.isFree() && c.getDistrict().equals(district))courier = c.getId();
        }
        if(courier == -1)return "None of the couriers are available";
        Date date = new Date();
        Timestamp ts=new Timestamp(date.getTime());
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "insert into orders (user_id, dish_id, order_date, district, courier_id, location) values (?,?,?,?,?,?);");
            statement.setInt(1, user);
            statement.setInt(2,dish);
            statement.setTimestamp(3,ts);
            statement.setString(4,district);
            statement.setInt(5,courier);
            statement.setString(6,address);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "accepted";
    }
    private Order convertToOrder(ResultSet rs) throws SQLException{
        Order o = new Order();
        o.setId(rs.getInt("order_id"));
        o.setUser(rs.getInt("user_id"));
        o.setDish(rs.getInt("dish_id"));
        o.setOrderDate(rs.getTimestamp("order_date"));
        o.setDistrict(rs.getString("district"));
        o.setCourier(rs.getInt("courier_id"));
        o.setAddress(rs.getString("location"));
        return o;
    }
}
