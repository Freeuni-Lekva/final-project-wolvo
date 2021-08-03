package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FriendsRequestDAO() {
    Connection connection;

    public FriendsRequestDAO(Connection connection){
        this.connection = connection;
    }

    private User convertToUser(ResultSet resultSet, int id) throws SQLException {
        User usr = new User();
        usr.setId(id);
        PreparedStatement statement = connection.prepareStatement("select * from users where user_id = ?;");
        statement.setInt(1, usr.getId());
        ResultSet result = statement.executeQuery();
        if(result.next()){
            usr.setAddress(result.getString("adress"));
            usr.setCity(result.getString("city"));
            usr.setDistrict(result.getString("district"));
            usr.setEmail(result.getString("email"));
            usr.setFirstName(result.getString("first_name"));
            usr.setLastName(result.getString("last_name"));
            usr.setPassword(result.getString("password"));
            usr.setAddress(result.getString("building_adress"));
            usr.setUserType(result.getInt("usert_type"));
            usr.setPhoneNumber(result.getString("phone_number"));
            usr.setPrivacyType(result.getInt("privacy"));
        }
        return usr;
    }

    public List<User> recievedRequsets(User usr) {
        List<User> recieved = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select from_id from friend_requests where to_id = ?;");
            statement.setInt(1, usr.getId());
            ResultSet result = statement.executeQuery();
            while(result.next()){
                recieved.add(convertToUser(result, result.getInt("from_id"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return recieved;
    }

    public List<User> sentRequests(User usr) {
        List<User> recieved = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select to_id from friend_requests where from_id = ?;");
            statement.setInt(1, usr.getId());
            ResultSet result = statement.executeQuery();
            while(result.next()){
                recieved.add(convertToUser(result, result.getInt("to_id"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return recieved;
    }
}