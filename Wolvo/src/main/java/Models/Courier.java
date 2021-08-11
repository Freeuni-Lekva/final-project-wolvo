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
    private Status isAdded;
    private Status isFree;
    private int currOrder;

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

    public void setAdded(Status isAdded){
        this.isAdded = isAdded;
    }

    public void setFree(Status isFree){
        this.isFree = isFree;
    }

    public void setCurrOrder(int currOrder) {
        this.currOrder = currOrder;
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

    public Status getAdded(){
        return isAdded;
    }

    public Status getFree(){
        return isFree;
    }

    public int getCurrOrder() {
        return currOrder;
    }

    public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Courier o = (Courier) obj;
            return id == o.getId() && email.equals(o.getEmail()) && firstName.equals(o.getFirstName())
                    && lastName.equals(o.getLastName()) && password.equals(o.getPassword()) &&
                     district.equals(o.getDistrict()) && phoneNumber.equals(o.getPhoneNumber()) &&
                     rating == o.getRating() && raters == getRaters() && completedOrders == o.getCompletedOrders()
                     && isAdded.equals(o.isAdded) && isFree.equals(o.isFree);
        }

    public String toString(){
        return id + " " + email + " " + firstName + " " + lastName + " "+ password + " " + " "+ district
        + " "+ phoneNumber + " " + rating + " " + raters + " " +completedOrders + " " + currOrder + " "+ isAdded.getStatus() + " " + isFree.getStatus();
    }
}

