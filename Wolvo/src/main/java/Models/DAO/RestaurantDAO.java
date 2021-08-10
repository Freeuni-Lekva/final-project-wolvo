package Models.DAO;

import Models.CourierStatus;
import Models.Restaurant;
import Models.Status;

import java.sql.*;
import java.util.*;

public class RestaurantDAO{
    private Connection connection;

    public RestaurantDAO(Connection connection){
        this.connection = connection;
    }

    /**
     *
     * @return list of all the restaurants currently registered in the database
     */

    public List<Restaurant> getRestaurants(){
        List<Restaurant> restaurants = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from restaurants;");
            while (resultSet.next()) {
                restaurants.add(convertToRestaurant(resultSet));
            }
        } catch (SQLException throwables) {}
        return restaurants;
    }

    /**
     *
     * @param id restaurant_id
     * @return Restaurant object with that particular ID
     */

    public Restaurant getRestaurantById(int id){
        try {
            PreparedStatement statement = connection.prepareStatement("select * from restaurants where res_id = ?");
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return convertToRestaurant(resultSet);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param name
     * @param manager
     * @param district
     * @param address
     * Inserts new restaurant in the database with data received as a parameters
     */

    public void addRestaurant(String name, int manager, String district, String address){
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "insert into restaurants (manager_id, name, district, address) values (?,?,?,?);");
            statement.setInt(1, manager);
            statement.setString(2,name);
            statement.setString(3,district);
            statement.setString(4,address);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     *
     * @return the list of all the restaurants pending admin approval (every change made by managers must be approved by admin)
     */
    public List<Restaurant> getPendingRestaurants(){
        List<Restaurant> restaurants = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from restaurants where is_added = ?");
            statement.setBoolean(1, false);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                restaurants.add(convertToRestaurant(resultSet));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return restaurants;
    }

    /**
     * @param restaurant
     * @param rate
     * updates the rating of the particular restaurant with the new value (called when user rates restaurant after the delivery)
     */

    public void updateRestaurant(Restaurant restaurant, int rate){
        if (rate == 0) return;
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE restaurants set rating = ?, raters_number = ? where res_id = ?;");
            statement.setFloat(1, (float)(restaurant.getRating() * restaurant.getRaters() + 1.0 * rate)/(restaurant.getRaters() + 1));
            statement.setInt(2, restaurant.getRaters() + 1);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     *
     * @param id restaurant_id
     * approves addition of the particular restaurant (will be called by Admin)
     */
    public void approveRestaurant(int id){
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE restaurants set is_added = ? where res_id = ?;");
            statement.setBoolean(1, true);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     *
     * @param rs
     * @return Restaurant object created with the data taken from the database
     * i.e. it takes a resultset of query and converts it to Restaurant object
     * @throws SQLException
     */
    private Restaurant convertToRestaurant(ResultSet rs) throws SQLException {
        Restaurant r = new Restaurant();
        r.setId(rs.getInt("res_id"));
        r.setManager_id(rs.getInt("manager_id"));
        r.setName(rs.getString("name"));
        r.setRating(rs.getFloat("rating"));
        r.setDistrict(rs.getString("district"));
        r.setAddress(rs.getString("address"));
        Status status = new CourierStatus();
        status.setStatus(rs.getString("is_added"));
        r.setAdded(status);
        r.setRaters(rs.getInt("raters_number"));
        return r;
    }
}