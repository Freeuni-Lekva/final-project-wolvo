package Models;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.BeforeClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

public class TestUserDAO extends TestCase {
    private int[] id = {1,2,3};
    private String[] email = {"tbabu19@freeuni.edu.ge","tarus19@freeuni.edu.ge","achuk19@freeuni.edu.ge"};
    private String[] firstNames = {"Tsotne","Temur","Akaki"};
    private String[] lastNames = {"Babunashvili","Arustashvili","Chukhua"};
    private String[] passwords = {"c80adfeea5a0af6d3ab04a8dba3a8769064f0d90","5ed092a75b55d250d7cf19448ff66601d254d356",
                                            "db0d9ba0b474fc1a9ce19a389f4ed37df6350b3a"};
    private String[] types = {"Admin","Admin","Admin"};
    private int[] privacyTypes = {0,0,0};
    private String[] districts = {"Didube","Saburtalo","Gldani"};
    private String[] addresses = {"Dighmis Masivi V kvartali 1a","Fanjikidze str 22a/26","3 MD Naneishvili str 20/8"};
    private String[] phoneNumbers = {"555685305","595055777","555725362"};
    private Connection connection;

    public void setUp() {
        if (connection != null) return;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        }
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/wolvo_db?user=root&password=inmess10nante");
        } catch (SQLException throwables) {
        }
    }

    private List<User> convertToUserList() {
        List<User> set = new ArrayList<>();
        for (int i=0;i<3;i++) {
            User user = new User();
            user.setId(id[i]);
            user.setEmail(email[i]);
            user.setFirstName(firstNames[i]);
            user.setLastName(lastNames[i]);
            user.setPassword(passwords[i]);
            user.setUserType(types[i]);
            user.setPrivacyType(privacyTypes[i]);
            user.setDistrict(districts[i]);
            user.setAddress(addresses[i]);
            user.setPhoneNumber(phoneNumbers[i]);
            set.add(user);
        }
        return set;
    }

    public void testgetAll() {
        assertNotNull(connection); // Connected to DB

        UserDAO userDAO = new UserDAO(connection);

        List<User> usersAnswer = convertToUserList();

        for (User user : userDAO.getAll()) {
            assert(usersAnswer.contains(user));
            usersAnswer.remove(user);
        }

        assert(usersAnswer.isEmpty());
    }

    private User convertToUser(int ind) {
        User newUser = new User();
        newUser.setId(id[ind]);
        newUser.setUserType(types[ind]);
        newUser.setPrivacyType(privacyTypes[ind]);
        newUser.setAddress(addresses[ind]);
        newUser.setDistrict(districts[ind]);
        newUser.setPhoneNumber(phoneNumbers[ind]);
        newUser.setPassword(passwords[ind]);
        newUser.setFirstName(firstNames[ind]);
        newUser.setLastName(lastNames[ind]);
        newUser.setEmail(email[ind]);
        return newUser;
    }


    public void testGetByEmail() {
        UserDAO userDAO = new UserDAO(connection);
        User firstUser = userDAO.getByEmail(email[0]);
        assertNotNull(firstUser);
        assertEquals(convertToUser(0),firstUser);

        User secondUser = userDAO.getByEmail(email[1]);
        assertNotNull(secondUser);
        assertEquals(convertToUser(1),secondUser);

        User thirdUser = userDAO.getByEmail(email[2]);
        assertNotNull(secondUser);
        assertEquals(convertToUser(2),thirdUser);
    }

    public void testNoSuchEntry() {
        UserDAO userDAO = new UserDAO(connection);

        User user = userDAO.getByEmail("randomString");
        assertNull(user);

        user = userDAO.getByEmail("tbabu18@freeuni.edu.ge");
        assertNull(user);

        user = userDAO.getByEmail("tbab19@freeuni.edu.ge");
        assertNull(user);
    }

    public void testAddEntry() {
        UserDAO userDAO = new UserDAO(connection);

        User newUser = new User();

        newUser.setEmail("test@subject.com");
        newUser.setFirstName("test 1");
        newUser.setLastName("test 2");
        newUser.setPassword("test123");
        newUser.setUserType("Customer");
        newUser.setPrivacyType(0);
        newUser.setDistrict("TestDistrict");
        newUser.setAddress("TestAddress");
        newUser.setPhoneNumber("3241234");
        assertNull(userDAO.getByEmail(newUser.getEmail()));
        int rowsAffected = userDAO.addUser(newUser.getEmail(),newUser.getFirstName(),newUser.getLastName(),newUser.getPassword(),
                newUser.getUserType(),newUser.getPrivacyType(), newUser.getDistrict(),newUser.getAddress(),newUser.getPhoneNumber());
        assertEquals(1,rowsAffected);

        User usercmp = userDAO.getByEmail(newUser.getEmail());
        assertEquals(newUser,usercmp);

        int removed = userDAO.removeUser(newUser.getEmail());
        assertEquals(1,removed);

        assertNull(userDAO.getByEmail(newUser.getEmail()));
    }
}
