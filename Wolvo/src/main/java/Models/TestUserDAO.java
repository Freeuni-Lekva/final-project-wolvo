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
    private String[] privacyTypes = {"Private","Private","Private"};
    private String[] cities = {"Tbilisi","Tbilisi","Tbilisi"};
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
                    "jdbc:mysql://localhost/wolvo_db?user=root&password=root");
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
            UserStatus us = new UserStatus();
            us.setStatus(types[i]);
            user.setUserType(us);
            PrivacyStatus ps = new PrivacyStatus();
            ps.setStatus(privacyTypes[i]);
            user.setPrivacyType(ps);
            user.setCity(cities[i]);
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

        Set<User> usersFromDAO = userDAO.getAll();
        List<User> usersAnswer = convertToUserList();


        System.out.println(usersFromDAO);
        System.out.println(usersAnswer);

        for (User user : userDAO.getAll()) {
            System.out.println(usersAnswer.contains(user));
            assert(usersAnswer.contains(user));
            usersAnswer.remove(user);
        }

        assert(usersAnswer.isEmpty());
    }

    private User convertToUser(int ind) {
        User newUser = new User();
        newUser.setId(id[ind]);
        UserStatus us = new UserStatus();
        us.setStatus(types[ind]);
        newUser.setUserType(us);
        PrivacyStatus ps = new PrivacyStatus();
        ps.setStatus(privacyTypes[ind]);
        newUser.setPrivacyType(ps);
        newUser.setAddress(addresses[ind]);
        newUser.setDistrict(districts[ind]);
        newUser.setCity(cities[ind]);
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

}
