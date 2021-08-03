package Models;

import java.util.List;

public class Friends {
    private List<User> friends;
    private User usr;

    public User getUser() {
        return usr;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    public void setUser(User usr) {
        this.usr = usr;
    }

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