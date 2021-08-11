package Models.Tests;

import Models.Review;
import junit.framework.TestCase;

import static org.junit.Assert.assertNotEquals;

public class TestReview extends TestCase {

    public void testReviewSetters0() {
        Review review = new Review();
        review.setReview_id(1);
        review.setCourier(2);
        review.setDish(4);
        review.setUser(2);
        assertNotNull(review);
        assertEquals(1,review.getReview_id());
        assertEquals(2,review.getCourier());
        assertEquals(4,review.getDish());
        assertEquals(2,review.getUser());
    }

    public void testReviewSetters1() {
        Review review = new Review();
        review.setReview_id(1);
        review.setUser(2);
        review.setCourier(3);
        review.setDish(4);
        review.setCourierRating(3);
        review.setDishRating(2);
        review.setText("Good");
        assertNotNull(review);
        assertEquals(1,review.getReview_id());
        assertEquals(2,review.getUser());
        assertEquals(3,review.getCourier());
        assertEquals(4,review.getDish());
        assertEquals(3,review.getCourierRating());
        assertEquals(2,review.getDishRating());
    }

    public void testNotSet() {
        Review review = new Review();
        review.setReview_id(1);
        review.setCourier(2);
        review.setUser(3);
        review.setDish(4);
        assertNotNull(review);
        assertEquals(0,review.getDishRating());
        assertEquals(0,review.getCourierRating());
        assertNull(review.getText());
    }

    public void testEquals() {
        Review review = new Review();
        review.setReview_id(1);
        review.setDish(2);
        review.setCourier(3);
        review.setUser(4);
        review.setDishRating(3);
        review.setCourierRating(3);
        review.setText("");
        Review reviewcmp = new Review();
        reviewcmp.setReview_id(1);
        reviewcmp.setDish(2);
        reviewcmp.setCourier(3);
        reviewcmp.setUser(4);
        reviewcmp.setDishRating(3);
        reviewcmp.setCourierRating(3);
        reviewcmp.setText("");
        assertEquals(reviewcmp,review);
        reviewcmp.setText("Pretty cool");
        assertNotEquals(reviewcmp, review);
        reviewcmp.setText("");
        assertEquals(reviewcmp,review);
        reviewcmp.setDishRating(4);
        assertNotEquals(reviewcmp,review);
    }

    public void testToString() {
        Review review = new Review();
        review.setText("");
        assertEquals("0 0 0 0 0 0 ",review.toString());
        review.setText("Cool");
        assertEquals("0 0 0 0 0 0 Cool",review.toString());
        review.setReview_id(1);
        assertEquals("1 0 0 0 0 0 Cool",review.toString());
        review.setDishRating(3);
        assertEquals("1 0 0 0 3 0 Cool",review.toString());
        review.setCourierRating(2);
        assertEquals("1 0 0 0 3 2 Cool",review.toString());
        review.setUser(4);
        assertEquals("1 4 0 0 3 2 Cool",review.toString());
        review.setCourier(5);
        assertEquals("1 4 0 5 3 2 Cool",review.toString());
        review.setDish(6);
        assertEquals("1 4 6 5 3 2 Cool",review.toString());
    }

}
