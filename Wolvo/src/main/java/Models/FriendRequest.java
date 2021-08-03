package Models;

public class FriendRequest {
    private User From;
    private User To;

    public User getFrom() {
        return From;
    }

    public User getTo() {
        return To;
    }

    public void setFrom(User From) {
        this.From = From;
    }

    public void setTo(User To) {
        this.To = To;
    }

    public String toString() {
        String s = "Request is sent from " + From.getId() + " (first name \"" + From.getFirstName() +
                "\" last name \"" + From.getLastName() + "\") to " + To.getId() +
                "(first name \"" + To.getFirstName() +
                "\" last name \"" + To.getLastName() +"\")";
        return s;
    }
}