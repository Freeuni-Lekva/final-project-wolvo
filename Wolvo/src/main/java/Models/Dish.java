package Models;

import java.util.Objects;

public class Dish {
    private int dish_id;
    private String name;
    private int rest_id;
    private String category;
    private Status added;
    private int raters;
    private float price;
    private float rating;

    public Dish(){}

    public float getPrice() {
        return price;
    }

    public int getDish_id() {
        return dish_id;
    }

    public String getCategory() {
        return category;
    }

    public float getRating() {
        return rating;
    }

    public int getRest_id() {
        return rest_id;
    }

    public String getName() {
        return name;
    }

    public Status getAdded() {
        return added;
    }

    public int getRaters() {
        return raters;
    }

    public void setDish_id(int dish_id) {
        this.dish_id = dish_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setRest_id(int rest_id) {
        this.rest_id = rest_id;
    }

    public void setAdded(Status s) {
        this.added = s;
    }

    public void setRaters(int raters) {
        this.raters = raters;
    }

    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Dish d = (Dish) obj;
        return dish_id == d.getDish_id() && rest_id == d.getRest_id() && name.equals(d.getName()) &&
                price == d.getPrice() && rating == d.getRating() && category.equals(d.getCategory());
    }

    public String toString(){
        String s =  "Id: " + dish_id + "\n name: " + name + "\n restaurant id: " + rest_id +
                "\n price: " + price + "\n rating: " + rating + "\nCategory: " + category;
        return s;
    }
}