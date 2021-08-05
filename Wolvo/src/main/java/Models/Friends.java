package Models;

import java.util.List;

/**
 * this class is for user's friends
 */
public class Friends {
    private List<User> friends;
    private User usr;

    /**
     * constructor. does nothing.
     */
    public Friends() {

    }

    /**
     * gets nothing, returns user.
     * @return User type.
     */
    public User getUser() {
        return usr;
    }

    /**
     * gets nothing, returns List of friends (usr's friends).
     * @return List<User> type.
     */
    public List<User> getFriends() {
        return friends;
    }

    /**
     * gets list of friends and sets it to private variable.
     * returns nothing.
     * @param friends List of Users.
     */
    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    /**
     * gets user and sets it to private variable.
     * returns nothing.
     * @param usr User type.
     */
    public void setUser(User usr) {
        this.usr = usr;
    }

    /**
     * turns information of this class to string.
     * format is user + list of user's friends.
     * @return String which contains class information.
     */
    public String toString() {
        String s = usr.getId() + " (first name \"" + usr.getFirstName() +
                "\" last name \"" + usr.getLastName() + "\") Friends are ";
        for (User fr : friends) {
            s = s + fr.getId() + " (first name \"" + fr.getFirstName() +
                    "\" last name \"" + fr.getLastName() + "\"), ";
        }
        return s;
    }
}