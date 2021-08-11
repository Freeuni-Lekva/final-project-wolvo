package Models;

import java.util.Objects;

public class Review{
    private int user;
    private int dish;
    private int courier;
    private int dishRating;
    private int courierRating;
    private String text;

    public Review(){}

    public void setUser(int user){
        this.user = user;
    }

    public void setDish(int dish){
        this.dish = dish;
    }

    public void setCourier(int courier){
        this.courier = courier;
    }

    public void setDishRating(int dishRating){
        this.dishRating = dishRating;
    }

    public void setCourierRating(int courierRating){
        this.courierRating = courierRating;
    }

    public void setText(String text){
        this.text = text;
    }

    public int getCourier() {
        return courier;
    }

    public int getDishRating() {
        return dishRating;
    }

    public int getCourierRating() {
        return courierRating;
    }

    public int getDish() {
        return dish;
    }

    public int getUser() {
        return user;
    }

    public String getText() {
        return text;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Review o = (Review)obj;
        return courier == o.getCourier() && dishRating == o.getDishRating() && courierRating == o.getCourierRating()
                && dish == o.getDish() && user == o.getUser() && text.equals(o.getText());
    }

    public String toString(){
        return user + " " + dish + " " + courier + " " + dishRating + " "+ courierRating + " " +text;
    }
}

