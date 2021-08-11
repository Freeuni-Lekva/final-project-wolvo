package Models.DAO;

import Models.CourierStatus;
import Models.Dish;
import Models.Restaurant;
import Models.Status;

import java.sql.*;
import java.util.*;

public class DishDAO{
    private Connection connection;

    public DishDAO(Connection connection){
        this.connection = connection;
    }

    public List<Dish> getDishes(){
        List<Dish> dishes = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from dishes;");
            while (resultSet.next()) {
                dishes.add(convertToDish(resultSet));
            }
        } catch (SQLException throwables) {}
        return dishes;
    }

    public Dish getDishById(int id){
        try {
            PreparedStatement statement = connection.prepareStatement("select * from dishes where dish_id = ?");
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return convertToDish(resultSet);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public List<Dish> getRestaurantDishes(Restaurant restaurant){
        List<Dish> dishes = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from dishes where rest_id = ?");
            statement.setInt(1, restaurant.getId());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                dishes.add(convertToDish(resultSet));
            }
        } catch (SQLException throwables) {}
        return dishes;
    }

    public void addDish(String name, int restaurant, String category, float price){
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "insert into dishes (name, rest_id, category) values (?,?,?,?);");
            statement.setString(1, name);
            statement.setInt(2, restaurant);
            statement.setString(3,category);
            statement.setFloat(4, price);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Dish> getPendingDishes(){
        List<Dish> dishes = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from dishes where is_added = ?");
            statement.setBoolean(1, false);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                dishes.add(convertToDish(resultSet));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return dishes;
    }

    public void updateDish(Dish d, int rate){
        if(rate == 0)return;
        DishDAO DDAO = new DishDAO(connection);
        DDAO.updateDish(d, rate);
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE dishes set rating = ?, raters_number = ? where dish_id = ?;");
            statement.setFloat(1, (float) (d.getRating() * d.getRaters() + 1.0*rate) / (d.getRaters() + 1));
            statement.setInt(2, d.getRaters() + 1);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void approveDish(int id){
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE dishes set is_added = ? where dish_id = ?;");
            statement.setBoolean(1, true);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private Dish convertToDish(ResultSet rs) throws SQLException {
        Dish d = new Dish();
        d.setDish_id(rs.getInt("dish_id"));
        d.setRest_id(rs.getInt("rest_id"));
        d.setName(rs.getString("name"));
        d.setRating(rs.getFloat("rating"));
        d.setCategory(rs.getString("category"));
        d.setPrice(rs.getFloat("price"));
        Status status = new CourierStatus();
        status.setStatus(rs.getString("is_added"));
        d.setAdded(status);
        d.setRaters(rs.getInt("raters_number"));
        return d;
    }
}
