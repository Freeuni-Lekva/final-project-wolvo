package Models.DAO;

import Models.*;

import java.sql.*;
import java.util.*;

import static Models.Constants.*;

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
            statement.setString(1, email);
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

    public boolean addCourier(String email, String firstName, String lastName, String district, String password, String phoneNumber){
        boolean added = false;
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "insert into couriers (email, first_name, last_name, district, password, phone_number, rating, raters, completed_orders, curr_status, add_status) " +
                            "values (?,?,?,?,?,?,?,?,?,?,?);");
            statement.setString(1, email);
            statement.setString(2,firstName);
            statement.setString(3,lastName);
            statement.setString(4,district);
            statement.setString(5,password);
            statement.setString(6,phoneNumber);
            statement.setFloat(7, 0F);
            statement.setInt(8, 0);
            statement.setInt(9, 0);
            statement.setString(10, FREE);
            statement.setString(11, PENDING);
            int i = statement.executeUpdate();
            if (i != 0) added = true;
        } catch (SQLException throwables) {}
        return added;
    }

    public void approveCourier(Courier courier){
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE couriers set add_status = ? where courier_id = ?;");
            Status status = new RequestStatus();
            status.setStatus(APPROVED);
            statement.setString(1, status.getStatus());
            statement.setInt(2, courier.getId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void acceptOrder(Courier courier) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE couriers set curr_status = ? where courier_id = ?;");
            Status status = new CourierStatus();
            status.setStatus(OCCUPIED);
            statement.setString(1, status.getStatus());
            statement.setInt(2, courier.getId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateCourier(Courier courier, int rate){
        int rated = 0;
        if (rate >= 0) rated = 1;
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE couriers set rating = ?, raters = ?, completed_orders = ?, curr_status = ? where courier_id = ?;");
            float nRating = courier.getRaters() + rated == 0 ? 0F :
                    (courier.getRating() * courier.getRaters() + (float)rate * rated) / (courier.getRaters() + rated);
            statement.setFloat(1, nRating);
            statement.setInt(2, courier.getRaters() + rated);
            statement.setInt(3, courier.getCompletedOrders() + 1);
            Status status = new CourierStatus();
            status.setStatus(FREE);
            statement.setString(4, status.getStatus());
            statement.setInt(5, courier.getId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Courier> getPendingCouriers(){
        List<Courier> couriers = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from couriers where add_status = ?");
            Status status = new RequestStatus();
            status.setStatus(PENDING);
            statement.setString(1, status.getStatus());
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
            PreparedStatement statement = connection.prepareStatement("select * from couriers where courier_id = ?");
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
        c.setId(rs.getInt("courier_id"));
        c.setEmail(rs.getString("email"));
        c.setFirstName(rs.getString("first_name"));
        c.setLastName(rs.getString("last_name"));
        c.setPassword(rs.getString("password"));
        c.setDistrict(rs.getString("district"));
        c.setPhoneNumber(rs.getString("phone_number"));
        c.setRating(rs.getFloat("rating"));
        c.setCompletedOrders(rs.getInt("completed_orders"));
        c.setRaters(rs.getInt("raters"));
        Status add = new RequestStatus();
        add.setStatus(rs.getString("add_status"));
        c.setAdded(add);
        Status free = new CourierStatus();
        free.setStatus(rs.getString("curr_status"));
        c.setFree(free);
        c.setCurrOrder(rs.getInt("curr_order"));
        return c;
    }
}
