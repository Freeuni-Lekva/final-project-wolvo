package Models;

import java.util.Objects;

public class Restaurant{
    private int rest_id;
    private int manager_id;
    private String name;
    private String district;
    private String address;
    private float rating;

    public Restaurant(){}

    public void setId(int id) {
        rest_id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setManager_id(int id){
        manager_id = id;
    }
    public void setRating(float rating){
        this.rating = rating;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getId(){
        return rest_id;
    }
    public int getManager_id(){
        return manager_id;
    }
    public String getDistrict(){
        return district;
    }
    public String getAddress(){
        return address;
    }

    public float getRating(){
        return rating;
    }

    public String getName(){
        return name;
    }

    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Restaurant o = (Restaurant) obj;
        return rest_id == o.getId() && manager_id == o.getManager_id() && rating == o.getRating() &&
                address.equals(o.getAddress()) && district.equals(o.getDistrict()) && name.equals(o.getName());
    }
    public String toString(){
        return "Id: "+ rest_id + "n/ name: "+name+ "/n manager id: " + manager_id +"/n district: "+
                district+ "/n address: " + address + "n/ rating: " + rating;
    }
}