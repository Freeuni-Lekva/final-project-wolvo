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

    public Set<User> getAll() {
        Set<User> userList = new HashSet<>();
        fetchUsers(userList);
        return userList;
    }

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

    public int removeUser(String email) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "delete from users where email = ?;");
            statement.setString(1,email);
            return statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
}
