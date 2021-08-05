package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * this class is for connection to 'friends_request' table
 */
public class FriendsRequestDAO {
    Connection connection;

    /**
     * constructor, initializes connection.
     * @param connection Connection is for sql statement.
     */
    public FriendsRequestDAO(Connection connection){
        this.connection = connection;
    }

    /**
     * Converts given resultset ro User by id.
     * @param resultSet Resultset executed by sql statement.
     * @param id is user Id we want to convert into user.
     * @return User we are looking for.
     * @throws SQLException may be thrown while executing sql statement.
     */
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

    /**
     * gets User and returns list of requests received.
     * @param usr User type we want to get list of requests.
     * @return list of users.
     */
    public List<User> recievedRequsets(User usr) {
        List<User> recieved = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select from_id from friend_requests where to_id = ?;");
            statement.setInt(1, usr.getId());
            ResultSet result = statement.executeQuery();
            while(result.next()){
                recieved.add(convertToUser(result, result.getInt("from_id")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return recieved;
    }

    /**
     * gets User and returns sent requests.
     * @param usr User which we want to get sent requests.
     * @return list of users requests are sent.
     */
    public List<User> sentRequests(User usr) {
        List<User> recieved = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select to_id from friend_requests where from_id = ?;");
            statement.setInt(1, usr.getId());
            ResultSet result = statement.executeQuery();
            while(result.next()){
                recieved.add(convertToUser(result, result.getInt("to_id")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return recieved;
    }
}