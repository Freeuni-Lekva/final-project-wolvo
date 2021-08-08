package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DishDAO{
    private Connection connection;

    public DishDAO(Connection connection){
        this.connection = connection;
    }

    public List<Dish> getDishes{
        List<Dish> dishes = new ArrayList<>();

        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select * from dishes;");
            while(result.next()){
                dishes.add(convertToDish(result));
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return dishes;
    }

    public Dish getDishByIt(int id){
        try{
            PreparedStatement st = connection.prepareStatement("select * from dishes where dish_id = ?;");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                return convertToDish(rs);
            }
            catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            return null;
        }
    }

    private Dish convertToDish(ResultSet rs)throws SQLException{
        Dish dish = new Dish();
        dish.setDish_id(rs.getInt("dish_id"));
        dish.setName(rs.getString("name"));
        dish.setRest_id(rs.getInt("rest_id"));
        dish.setPrice(rs.getFloat("price"));
        dish.setCategory(rs.getString("category"));
        dish.setRating(rs.get("rating"));
    }
}