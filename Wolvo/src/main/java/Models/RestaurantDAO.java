package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RestaurantDAO {
    private Connection connection;

    public RestaurantDAO(Connection connection){
        this.connection = connection;
    }

    public List<Restaurant> getRestaurants(){
        List<Restaurant> restaurants = new ArrayList<>();

        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select * from restaurants;");
            while(result.next()){
                restaurants.add(convertToRestaurant(result));
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return restaurants;
    }

    public Restaurant getRestaurantById(int resId){
        try{
            PreparedStatement st = connection.prepareStatement("select * restaurants where res_id = ?;");
            statement.setInt(1, resId);
            ResultSet result = st.executeQuery();
            while(result.next()){
                return convertToRestaurant(result);
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    private Restaurant convertToRestaurant(ResultSet resultSet) throws SQLException{
        Restaurant restaurant = new Restaurant();
        restaurant.setId(resultSet.getInt("res_id"));
        restaurant.setAddress(resultSet.getString("address"));
        restaurant.setManager_id(resultSet.getInt("manager_id"));
        restaurant.setRating(resultSet.getFloat("rating"));
        restaurant.setDistrict(resultSet.getString("district"));
        restaurant.setName(resultSet.getString("name"));
        return restaurant;
    }
}