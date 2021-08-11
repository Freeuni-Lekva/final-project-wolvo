package Models;

import java.util.Objects;

public class Review{
    private int review_id;
    private int user;
    private int dish;
    private int courier;
    private int dishRating;
    private int courierRating;
    private String text;

    public Review(){}

    /**
     * sets review_id
     * @param review_id
     */

    public void setReview_id(int review_id) {this.review_id = review_id; }
    /**
     * sets id of the user who made this review
     * @param user
     */
    public void setUser(int user){
        this.user = user;
    }

    /**
     * sets id of the dish in the order user rated
     * @param dish
     */
    public void setDish(int dish){
        this.dish = dish;
    }

    /**
     * sets id of the courier in the order user rated
     * @param courier
     */
    public void setCourier(int courier){
        this.courier = courier;
    }

    /**
     * sets rating of the dish in the order made by user
     * USER MAY NOT HAVE RATED THE DISH
     * @param dishRating
     */
    public void setDishRating(int dishRating){
        this.dishRating = dishRating;
    }

    /**
     * sets rating of the courier who made the delivery of the order made by user
     * USER MAY NOT HAVE RATED THE COURIER
     * @param courierRating
     */
    public void setCourierRating(int courierRating){
        this.courierRating = courierRating;
    }

    /**
     * sets the comment user named about the order
     * MAY BE NULL
     * @param text
     */
    public void setText(String text){
        this.text = text;
    }

    /**
     *
     * @return id of review
     */
    public int getReview_id() {return review_id; }
    /**
     *
     * @return ID Of the courier who delivered the order user reviewed
     * MAY BE NULL
     */
    public int getCourier() {
        return courier;
    }

    /**
     *
     * @return rating of the dish in the order user reviewed
     * MAY BE NULL
     */

    public int getDishRating() {
        return dishRating;
    }

    /**
     *
     * @returnrating of the courier in the order user reviewed
     * MAY BE NULL
     */
    public int getCourierRating() {
        return courierRating;
    }

    /**
     * @return ID of the dish in the order user reviewed
     */
    public int getDish() {
        return dish;
    }

    /**
     *
     * @return id of the user who reviewed the order
     */
    public int getUser() {
        return user;
    }

    /**
     *
     * @return the comment user made about the order
     * MAY BE NULL
     */
    public String getText() {
        return text;
    }

    /**
     *
     * @param obj
     * @return true if the object received as a parameter is equal to this review
     */
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Review o = (Review)obj;
        return courier == o.getCourier() && dishRating == o.getDishRating() && courierRating == o.getCourierRating()
                && dish == o.getDish() && user == o.getUser() && text.equals(o.getText());
    }

    /**
     *
     * @return review converted to string
     */
    public String toString(){
        return review_id + " " + user + " " + dish + " " + courier + " " + dishRating + " "+ courierRating + " " +text;
    }
}

