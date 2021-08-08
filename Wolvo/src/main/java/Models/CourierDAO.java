package Models.DAO;

import Models.Courier;
import java.sql.*;
import java.util.*;

public class CourierDAO {
    private Connection connection;
    public CourierDAO(Connection connection){
        this.connection = connection;
    }
    public List<Courier> getCouriers(){
        List<Courier> couriers = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from couriers;");
            while (resultSet.next()) {
                couriers.add(convertToCourier(resultSet));
            }
        } catch (SQLException throwables) {}
        return couriers;
    }

    public Courier getCourierByEmail(String email){
        try {
            PreparedStatement statement = connection.prepareStatement("select * from couriers where email = ?");
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return convertToCourier(resultSet);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public List<Courier> getDistrictCouriers(String district){
        List<Courier> couriers = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from couriers where district = ?");
            statement.setString(1, district);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                couriers.add(convertToCourier(resultSet));
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return couriers;
    }
    public void addCourier(String email, String firstName, String lastName, String district, String password, String phoneNumber){
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "insert into couriers (email, first_name, last_name, district, password, phone_number) values (?,?,?,?,?,?);");
            statement.setString(1, email);
            statement.setString(2,firstName);
            statement.setString(3,lastName);
            statement.setString(4,district);
            statement.setString(5,password);
            statement.setString(6,phoneNumber);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void approveCourier(int id){
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE restaurants set is_added = ? where user_id = ?;");
            statement.setBoolean(1, true);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void acceptOrder(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE couriers set is_free = ? where user_id = ?;");
            statement.setBoolean(1, false);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateCourier(int id, int rate){
        int rated = 0;
        if(rate != 0)rated = 1;
        Courier c = getCourierById(id);
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE couriers set rating = ?, raters_number = ?, completed_orders = ?, is_free = ? where user_id = ?;");
            statement.setFloat(1, (c.getRating()*c.getRaters() + 1.0*rate)/(1.0*(c.getRaters() + rated)));
            statement.setInt(2, c.getRaters() + rated);
            statement.setInt(3, c.getCompletedOrders() + 1);
            statement.setBoolean(4, true);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Courier> getPendingCouriers(){
        List<Courier> couriers = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from couriers where is_added = ?");
            statement.setBoolean(1, true);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                couriers.add(convertToCourier(resultSet));
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return couriers;
    }

    public Courier getCourierById(int id){
        try {
            PreparedStatement statement = connection.prepareStatement("select * from couriers where user_id = ?");
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return convertToCourier(resultSet);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    private Courier convertToCourier(ResultSet rs) throws SQLException{
        Courier c = new Courier();
        c.setId(rs.getInt("user_id"));
        c.setEmail(rs.getString("email"));
        c.setFirstName(rs.getString("first_name"));
        c.setLastName(rs.getString("last_name"));
        c.setPassword(rs.getString("password"));
        c.setDistrict(rs.getString("district"));
        c.setPhoneNumber(rs.getString("phone_number"));
        c.setRating(rs.getFloat("rating"));
        c.setCompletedOrders(rs.getInt("completed_orders"));
        c.setRaters(rs.getInt("raters_number"));
        c.setAdded(rs.getBoolean("is_added"));
        c.setFree(rs.getBoolean("is_free"));
        return c;
    }
}
