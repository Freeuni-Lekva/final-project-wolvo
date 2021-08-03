package Models;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class UserDAO {
    private Connection connection;
    private Map<String,User> users;

    private User convertToUser(ResultSet resultSet) {
        User user = new User();
        try {
            user.setPassword(resultSet.getString("password"));
            user.setCity(resultSet.getString("city"));
            user.setAddress(resultSet.getString("building_address"));
            user.setDistrict(resultSet.getString("district"));
            user.setEmail(resultSet.getString("email"));
            user.setFirstName(resultSet.getString("first_name"));
            user.setLastName(resultSet.getString("last_name"));
            user.setId(resultSet.getInt("user_id"));
            user.setUserType(resultSet.getInt("user_type"));
            user.setPrivacyType(resultSet.getInt("privacy"));
            user.setPhoneNumber(resultSet.getBigDecimal("phone_number").toPlainString());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    private void fetchUsers() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users;");
            while (resultSet.next()) {
                users.put(resultSet.getString("email"),convertToUser(resultSet));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public UserDAO(Connection connection) {
        this.connection = connection;
        users = new HashMap<>();
        fetchUsers();
    }

    public User getByEmail(String email) {
        if (!users.containsKey(email)) {
            return null;
        }

        return users.get(email);
    }

    public Set<User> getAll() {
        Set<User> userList = new HashSet<>(users.values());
        return userList;
    }
}
