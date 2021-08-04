package Models;

import java.util.Objects;

public class User {
    private int id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String userType;
    private String privacyType;
    private String district;
    private String address;
    private String phoneNumber;

    public User(){
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPrivacyType(String privacyType) {
        this.privacyType = privacyType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public int getId() {
        return id;
    }

    public String getPrivacyType() {
        return privacyType;
    }

    public String getUserType() {
        return userType;
    }

    public String getAddress() {
        return address;
    }

    public String getDistrict() {
        return district;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User that = (User) obj;
        return Objects.equals(firstName, that.firstName)
                && Objects.equals(lastName, that.lastName) && Objects.equals(email,that.email)
                    && Objects.equals(password,that.password) && Objects.equals(district,that.district)
                        && Objects.equals(address,that.address) && Objects.equals(phoneNumber,that.phoneNumber)
                            && Objects.equals(userType,that.userType) && Objects.equals(privacyType,that.privacyType);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", " + id + ", " + email + ", " + phoneNumber
                + id + " " + district + " " + address + " " + userType + " " + privacyType;
    }
}