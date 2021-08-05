package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * This class is for connection to 'friends' table
 */
public class FriendsDAO {
    private Connection connection;

    /**
     * constructor, which initializes connection
     * @param connection type of Connection
     */
    public FriendsDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * Converts given resultset to User
     * id is value of user we're looking friends of.
     * @param resultSet executed by sql statement.
     * @param id user's id we want to get list of friends.
     * @return User - which is friend of user whose id is equal to id given.
     * @throws SQLException may be thrown while executing sql statement.
     */
    private User convertToUser(ResultSet resultSet, int id) throws SQLException {
        int id1 = resultSet.getInt("first_id");
        int id2 = resultSet.getInt("second_id");
        int curr = id1;
        if (id2 != id) curr = id2;
        User usr = new User();
        usr.setId(curr);
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
     * gets user as parameter and returns its friends.
     * @param usr User type.
     * @return List<User> list of users.
     */
    public List<User> getFriends(User usr) {
        List<User> friends = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from Friends where first_id = ? or second_id = ?;");
            statement.setInt(1, usr.getId());
            statement.setInt(2, usr.getId());
            ResultSet result = statement.executeQuery();
            while(result.next()){
                friends.add(convertToUser(result, usr.getId()));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return friends;
    }

    /**
     * checks if two users are friends.
     * @param usr1 User type.
     * @param usr2 User type.
     * @return boolean, true if usr1 and usr2 are friends. false otherwise.
     */
    public boolean friendship(User usr1, User usr2) {
        User usrLess = usr1;
        User usrGreater = usr2;
        boolean answer = false;
        if (usr1.getId() > usr2.getId()) {
            usrLess = usr2;
            usrGreater = usr1;
        }
        try {
            PreparedStatement statement = connection.prepareStatement("select * from Friends where first_id = ? and second_id = ?;");
            statement.setInt(1, usrLess.getId());
            statement.setInt(2, usrGreater.getId());
            ResultSet result = statement.executeQuery();
            if (!result.next()) answer = false;
            else answer = true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return answer;
    }
}