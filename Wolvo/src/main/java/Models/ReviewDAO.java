package Models.DAO;

import Models.Review;
import java.sql.*;
import java.util.*;

public class ReviewDAO{
    private Connection connection;

    public ReviewDAO(Connection connection){
        this.connection = connection;
    }

    public List<Review> getDishReviews(int dish){
        List<Review> reviews = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from reviews where dish_id = ?");
            statement.setInt(1, dish);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                reviews.add(convertToReview(resultSet));
            }
        } catch (SQLException throwables) {}
        return reviews;
    }

    public void addReview(int user, int dish, int courier, int dishRating, int courierRating, String text){
        CourierDAO cDao = new CourierDAO(connection);
        cDao.updateCourier(courier, courierRating);
        DishDAO dDao = new DishDAO(connection);
        dDao.updateDish(dish, dishRating);
        try{
            PreparedStatement statement = connection.prepareStatement(
                    "insert into reviews (user_id, dish_id, courier_id, rating, courier_rating, review) values (?,?,?,?,?,?);");
            statement.setInt(1, user);
            statement.setInt(2,dish);
            statement.setInt(3, courier);
            statement.setInt(4, dishRating);
            statement.setInt(5, courierRating);
            statement.setString(6, text);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private Review convertToReview(ResultSet rs) throws SQLException{
        Review r = new Review();
        r.setUser(rs.getInt("user_id"));
        r.setDish(rs.getInt("dish_id"));
        r.setCourier(rs.getInt("courier_id"));
        r.setDishRating(rs.getInt("rating"));
        r.setCourierRating(rs.getInt("courier_rating"));
        r.setText(rs.getString("review"));
        return r;
    }
}
