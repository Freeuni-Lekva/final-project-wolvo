package Models.DAO;

import Models.PrivacyStatus;
import Models.User;
import Models.UserStatus;

import javax.xml.transform.Result;
import java.math.BigDecimal;
import java.sql.*;
import java.util.*;

public class UserDAO {
    private Connection connection;

    /**
     *
     * @param resultSet
     * @return User object created with the data taken from the database
     * i.e. it takes a resultset of query and converts it to User object
     */
    private User convertToUser(ResultSet resultSet) {
        User user = new User();
        try {
            user.setPassword(resultSet.getString("password"));
            user.setAddress(resultSet.getString("building_address"));
            user.setDistrict(resultSet.getString("district"));
            user.setEmail(resultSet.getString("email"));
            user.setFirstName(resultSet.getString("first_name"));
            user.setLastName(resultSet.getString("last_name"));
            user.setId(resultSet.getInt("user_id"));
            UserStatus newUserStatus = new UserStatus();
            newUserStatus.setStatus(resultSet.getString("user_type"));
            user.setUserStatus(newUserStatus);
            PrivacyStatus newPrivacyStatus = new PrivacyStatus();
            newPrivacyStatus.setStatus(resultSet.getString("privacy"));
            user.setPrivacyStatus(newPrivacyStatus);
            user.setPhoneNumber(resultSet.getString("phone_number"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    /**
     *
     * @param users
     * inserts all of the currently registered users in the set (taken as a parameter)
     */
    private void fetchUsers(Set<User> users) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users;");
            while (resultSet.next()) {
                users.add(convertToUser(resultSet));
            }
        } catch (SQLException throwables) {
        }

    }

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     *
     * @param email
     * @return User with that particular email address
     */
    public User getByEmail(String email) {
        try {
            PreparedStatement statement = connection.prepareStatement("select * from users where " +
                    "email = ?");
            statement.setString(1,email);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                return null;
            }
            return convertToUser(resultSet);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @return list of all the currently registered users (only admins and customers)
     */
    public Set<User> getAll() {
        Set<User> userList = new HashSet<>();
        fetchUsers(userList);
        return userList;
    }

    /**
     *
     * @param email
     * @param firstName
     * @param lastName
     * @param password
     * @param userType
     * @param privacyType
     * @param district
     * @param address
     * @param phoneNumber
     * inserts new user in the database with the data taken as parameters
     * @return number of rows affected; (if everything goes well, returned value should be 1)
     */
    public int addUser(String email, String firstName, String lastName, String password, String userType, String privacyType,
                                String district, String address, String phoneNumber) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "insert into users (email,first_name,last_name,password,user_type," +
                            "privacy,district,building_address,phone_number) values (?,?,?,?,?,?,?,?,?);");
            statement.setString(1,email);
            statement.setString(2,firstName);
            statement.setString(3,lastName);
            statement.setString(4,password);
            statement.setString(5,userType);
            statement.setString(6,privacyType);
            statement.setString(7,district);
            statement.setString(8,address);
            statement.setString(9,phoneNumber);
            return statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    /**
     *
     * @param email
     * removes user with that particular email address
     * @return number of rows affected (should be 1 if everything goes well)
     */

    public int removeUser(String email) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "delete * from users where email = ?;");
            statement.setString(1,email);
            return statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    /**
     *
     * @param name (First name and last name concatenated)
     * @return User with that particular name and surname
     */
    public User getByName(String name) {
        StringTokenizer tok = new StringTokenizer(name," ");
        String firstName,lastName;
        if (!tok.hasMoreTokens()) return null;
        firstName = tok.nextToken();
        if (!tok.hasMoreTokens()) return null;
        lastName = tok.nextToken();
        if (tok.hasMoreTokens()) return null;
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "select * from users where first_name = ? and last_name = ?;");
            statement.setString(1,firstName);
            statement.setString(2,lastName);
            return convertToUser(statement.executeQuery());
        } catch (SQLException throwables) {
        }
        return null;
    }

}
