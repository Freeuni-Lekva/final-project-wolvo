package Models.Tests;

import Models.Review;
import junit.framework.TestCase;
import static Models.Constants.*;

public class TestReview extends TestCase {

    private int[] user = {2, 4, 5};
    private int[] dish = {1, 3, 6};
    private int[] courier = {8, 9, 5};
    private int[] dishRating = {2, 5, 2};
    private int[] courierRating = {10, 2, 5};
    private String[] text = {"kaia", "bravo", "sashinelebaa"};
    private Review[] review;

    /**
     * sets up review and tests constructor.
     * @throws Exception
     */
    @Override
    protected void setUp() throws Exception {
        review = new Review[3];
        for (int i = 0; i < 3; i++) {
            review[i] = new Review();
            review[i].setUser(user[i]);
            review[i].setDish(dish[i]);
            review[i].setCourier(courier[i]);
            review[i].setDishRating(dishRating[i]);
            review[i].setCourierRating(courierRating[i]);
            review[i].setText(text[i]);
        }
    }

    /**
     * tests basic methods of Review class
     */
    public void testReview() {
        for (int i = 0; i < 3; i++) {
            assertEquals(user[i], review[i].getUser());
            assertEquals(dish[i], review[i].getDish());
            assertEquals(courier[i], review[i].getCourier());
            assertEquals(dishRating[i], review[i].getDishRating());
            assertEquals(courierRating[i], review[i].getCourierRating());
            assertEquals(text[i], review[i].getText());
        }
    }

    public void testEquals() {
        Review[] EQ = new Review[3];
        for (int i = 0; i < 3; i++) {
            EQ[i] = new Review();
            EQ[i].setUser(user[i]);
            EQ[i].setDish(dish[i]);
            EQ[i].setCourier(courier[i]);
            EQ[i].setDishRating(dishRating[i]);
            EQ[i].setCourierRating(courierRating[i]);
            EQ[i].setText(text[i]);
        }

        for (int i = 0; i < 3; i++) {
            assertTrue(review[i].equals(review[i]));
            assertTrue(review[i].equals(EQ[i]));
            assertFalse(review[i].equals(null));
            assertFalse(review[i].equals(EQ[(i + 1) % 3]));
            assertFalse(review[i].equals("review[i]"));
        }
    }

    public void testToString() {
        for (int i = 0; i < 3; i++) {
            String s = review[i].getUser() + " " + review[i].getDish() + " " + review[i].getCourier() + " " +
                    review[i].getDishRating() + " "+ review[i].getCourierRating() + " " +review[i].getText();
            assertEquals(s, review[i].toString());
        }
    }
}
