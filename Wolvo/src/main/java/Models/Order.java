package Models;

import java.util.List;
import java.util.Objects;
import java.sql.Timestamp;

public class Order {
    private int id;
    private int userId;
    private int dishId;
    private Timestamp orderDate;
    private String district;
    private String address;
    private int courierID;

    public Order(){}

    /**
     *
     * @return id of the user who made this order
     */
    public int getUserID() {
        return userId;
    }

    /**
     *
     * @return id of the dish in this order
     */
    public int getDish() {
        return dishId;
    }

    /**
     *
     * @return district in which this order is made in
     */

    public String getDistrict() {
        return district;
    }

    /**
     *
     * @return order id
     */

    public int getId() {
        return id;
    }

    /**
     *
     * @return id of the courier delivering this order
     */
    public int getCourierID() {
        return courierID;
    }

    /**
     *
     * @return address of user who made this order
     */

    public String getAddress() {
        return address;
    }

    /**
     *
     * @return exact time the order was made
     */

    public Timestamp getOrderDate() {
        return orderDate;
    }

    /**
     *
     * @param id
     * sets id for order
     */

    public void setId(int id) {
        this.id = id;
    }


    /**
     *
     * @param dish
     * sets list of dishes ordered
     */

    public void setDish(int dishId) {
        this.dishId = dishId;
    }


    /**
     * sets id of user who made this order
     * @param user
     */
    public void setUser(int user) {
        this.userId = user;
    }

    /**
     * sets address of this order
     * @param address
     */

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * sets district of this order
     * @param district
     */
    public void setDistrict(String district) {
        this.district = district;
    }


    /**
     * assigns courier for this order
     * @param courier
     */
    public void setCourier(int courier) {
        this.courierID = courier;
    }

    /**
     * sets time of the order
     * @param orderDate
     */
    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }


    /**
     *
     * @param obj
     * @return true if the object received as a parameter is equal to this order
     */

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Order o = (Order) obj;
        return id == o.getId() && userId == o.getUserID() && dishId == getDish()
                && courierID == o.getCourierID() && address.equals(o.getAddress()) && district.equals(o.getDistrict()) && orderDate.equals(o.getOrderDate());
    }

    /**
     *
     * @return order converted to String
     */
    public String toString(){
        return id + " " + userId + " " + dishId + " " + courierID + " "+ address + " " + " "+ district + " "+ orderDate.toString();
    }
}

