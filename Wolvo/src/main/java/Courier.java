package Models;

import java.util.Objects;

public class Courier{
    private int id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String phoneNumber;
    private String district;
    private float rating;
    private int raters;
    private int completedOrders;
    private boolean isAdded;
    private boolean isFree;

    public Courier(){}

    public void setId(int id){
        this.id = id;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public void setDistrict(String district){
        this.district = district;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public void setRating(float rating){
        this.rating = rating;
    }

    public void setRaters(int raters){
        this.raters = raters;
    }

    public void setCompletedOrders(int completedOrders){
        this.completedOrders = completedOrders;
    }

    public void setAdded(boolean isAdded){
        this.isAdded = isAdded;
    }

    public void setFree(boolean isFree){
        this.isFree = isFree;
    }

    public int getId(){
        return id;
    }

    public String getEmail(){
        return email;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getDistrict(){
        return district;
    }

    public String getLastName(){
        return lastName;
    }

    public String getPassword(){
        return password;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }
    public float getRating(){
        return rating;
    }

    public int getRaters(){
        return raters;
    }

    public int getCompletedOrders(){
        return completedOrders;
    }

    public boolean isAdded(){
        return isAdded;
    }

    public boolean isFree(){
        return isFree;
    }
    public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Courier o = (Courier) obj;
            return id == o.getId() && email.equals(o.getEmail()) && firstName.equals(o.getFirstName())
                    && lastName.equals(o.getLastName()) && password.equals(o.getPassword()) &&
                     district.equals(o.getDistrict()) && phoneNumber.equals(o.getPhoneNumber()) &&
                     rating == o.getRating() && raters == getRaters() && completedOrders == o.getCompletedOrders()
                     && isAdded == o.isAdded() && o.isFree() == isFree;
        }
        public String toString(){
            return id + " " + email + " " + firstName + " " + lastName + " "+ password + " " + " "+ district
            + " "+ phoneNumber + " " + rating + " " + raters + " " +completedOrders + " " + isAdded + " " + isFree;
        }
}

