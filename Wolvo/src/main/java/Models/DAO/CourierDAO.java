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

    /**
     *
     * @return List of all the currently registered couriers
     */
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

    /**
     *
     * @param email of courier (submitted during registration)
     * @return Courier with that particular email address
     */

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

    /**
     *
     * @param district
     * @return List of all the couriers working in that particular district
     */

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

    /**
     *
     * @param email
     * @param firstName
     * @param lastName
     * @param district
     * @param password
     * @param phoneNumber
     * Inserts new courier in the database with data received as a parameters
     */
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

    /**
     *
     * @param courier
     * approves registration of the particular courier (will be called by Admin)
     */
    public void approveCourier(Courier courier){
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE restaurants set is_added = ? where user_id = ?;");
            Status status = new RequestStatus();
            status.setStatus(APPROVED);
            statement.setString(1, status.getStatus());
            statement.setInt(2, courier.getId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    /**
     *
     * @param courier
     * marks that the particular courier is no longer free (i.e. working on the order)
     */

    public void acceptOrder(Courier courier) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE couriers set is_free = ? where user_id = ?;");
            Status status = new CourierStatus();
            status.setStatus(OCCUPIED);
            statement.setString(1, status.getStatus());
            statement.setInt(2, courier.getId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     *
     * @param courier
     * @param rate
     * updates the rating of the particular courier with the new value (called when user rates courier after the delivery)
     */
    public void updateCourier(Courier courier, int rate){
        int rated = 0;
        if (rate >= 0) rated = 1;
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE couriers set rating = ?, raters_number = ?, completed_orders = ?, is_free = ? where user_id = ?;");
            statement.setFloat(1, (courier.getRating() * courier.getRaters() + (float)rate) / (courier.getRaters() + rated));
            statement.setInt(2, courier.getRaters() + rated);
            statement.setInt(3, courier.getCompletedOrders() + 1);
            Status status = new CourierStatus();
            status.setStatus(FREE);
            statement.setString(4, status.getStatus());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     *
     * @return the list of couriers whose registration is pending admin approval
     */

    public List<Courier> getPendingCouriers(){
        List<Courier> couriers = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from couriers where is_added = ?");
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

    /**
     *
     * @param id courier_id
     * @return the courier with that particular courier_id
     */
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

    /**
     *
     * @param rs
     * @return Courier object created with the data taken from the database
     * i.e. it takes a resultset of query and converts it to Courier object
     * @throws SQLException
     */
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
        c.setAdded(rs.getString("is_added"));
        c.setFree(rs.getString("is_free"));
        return c;
    }
}
