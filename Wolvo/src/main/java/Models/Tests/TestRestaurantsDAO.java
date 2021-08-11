package Models.Tests;

import Models.DAO.RestaurantDAO;
import Models.RequestStatus;
import Models.Restaurant;
import Models.Status;
import junit.framework.TestCase;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Models.Constants.*;

public class TestRestaurantsDAO extends TestCase {

    private Connection connection;
    private int[] rest_id = {1001, 1002, 1003, 1004, 1005};
    private int[] manager_id = {501, 502, 503, 504, 505};
    private String[] name = {"HB", "Machakhela", "Weihenstephan", "Bernard", "Nikora"};
    private String[] district = {"Saburtalo", "Didube", "Saburtalo", "Gldani", "Digomi"};
    private String[] address = {"Vazha-pshavela street", "Some Adress2", "Vazha-pshavela Str",
            "Gldanis misamarti rame", "FU-s win"};
    private float[] rating = {4.3F, 3.2F, 4.9F, 3.8F, 4.2F};
    private int[] raters = {875, 2001, 459, 1502, 20400};
    private String[] status = {APPROVED, REJECTED, APPROVED, PENDING, APPROVED};
    private Restaurant[] restaurants;

    /**
     * sets up restaurants.
     * @throws Exception
     */
    @Override
    protected void setUp() throws Exception {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/wolvo_db?user=root&password=root");
        restaurants = new Restaurant[5];
        for (int i = 0; i < 5; i++) {
            restaurants[i] = new Restaurant();
            restaurants[i].setId(rest_id[i]);
            restaurants[i].setManager_id(manager_id[i]);
            restaurants[i].setName(name[i]);
            restaurants[i].setDistrict(district[i]);
            restaurants[i].setAddress(address[i]);
            restaurants[i].setRating(rating[i]);
            restaurants[i].setRaters(raters[i]);
            Status rs = new RequestStatus();
            rs.setStatus(status[i]);
            restaurants[i].setAdded(rs);
        }
    }

    /**
     * tests getRestaurants.
     */
    public void testGetRestaurants() {
        RestaurantDAO RDAO = new RestaurantDAO(connection);
        List<Restaurant> actual = Arrays.asList(restaurants);
        List<Restaurant> l = RDAO.getRestaurants();
        assertTrue(actual.containsAll(l));
        assertTrue(l.containsAll(actual));
    }

    /**
     * tests getRestaurantById.
     */
    public void testGetRestaurantById() {
        RestaurantDAO RDAO = new RestaurantDAO(connection);
        for (int i = 0; i < 5; i++) {
            Restaurant r = RDAO.getRestaurantById(rest_id[i]);
            assertTrue(r.equals(restaurants[i]));
        }
    }

    /**
     * tests addRestaurant.
     */
    public void testAddRestaurant() throws SQLException {
        RestaurantDAO RDAO = new RestaurantDAO(connection);
        Restaurant r = new Restaurant();
        r.setId(1006);
        r.setName("n");
        r.setDistrict("d");
        r.setManager_id(504);
        r.setRating(0F);
        r.setRaters(0);
        Status rs = new RequestStatus();
        rs.setStatus(PENDING);
        r.setAdded(rs);
        r.setAddress("a");
        List<Restaurant> l = RDAO.getRestaurants();
        assertFalse(l.contains(r));
        RDAO.addRestaurant("n", 504, "d", "a");
        l = RDAO.getRestaurants();
        assertTrue(l.contains(r));
        PreparedStatement statement = connection.prepareStatement("delete from restaurants where rest_id = 1006");
        assertEquals(1, statement.executeUpdate());
    }

    /**
     * tests getPendingRestaurants.
     */
    public void testGetPendingRestaurants() {
        RestaurantDAO RDAO = new RestaurantDAO(connection);
        List<Restaurant> l = RDAO.getPendingRestaurants();
        List<Restaurant> actual = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            if (status[i].equals(PENDING))
                actual.add(restaurants[i]);
        }
        assertTrue(l.containsAll(actual));
        assertTrue(actual.containsAll(l));
    }

    /**
     * tests updateRestaurant.
     */
    public void testUpdateRestaurant() throws SQLException {
        RestaurantDAO RDAO = new RestaurantDAO(connection);
        for (int i = 0; i < 5; i++) {
            RDAO.updateRestaurant(restaurants[i], 5);
            Restaurant r = RDAO.getRestaurantById(rest_id[i]);
            assertTrue(r.getRaters() == raters[i] + 1);
            float nr = (float)(rating[i] * raters[i] + 1.0 * 5)/(raters[i] + 1);
            assertEquals(r.getRating(), nr);
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE restaurants set rating = ?, raters_number = ? where res_id = ?;");
            statement.setFloat(1, rating[i]);
            statement.setInt(2, raters[i]);
            statement.setInt(3, rest_id[i]);
        }
    }

    /**
     * tests approveRestaurant.
     */
    public void testApproveRestaurant() throws SQLException {
        RestaurantDAO RDAO = new RestaurantDAO(connection);
        for (int i = 0; i < 5; i++) {
            RDAO.approveRestaurant(restaurants[i]);
            Restaurant r = RDAO.getRestaurantById(rest_id[i]);
            assertEquals(r.getAdded().getStatus(), APPROVED);
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE restaurants set add_status = ? where rest_id = ?;");
            statement.setString(1, status[i]);
            statement.setInt(2, rest_id[i]);
            statement.executeUpdate();
            r = RDAO.getRestaurantById(rest_id[i]);
            assertEquals(r.getAdded().getStatus(), status[i]);
        }
    }
}