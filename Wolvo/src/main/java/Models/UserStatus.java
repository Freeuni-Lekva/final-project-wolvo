package Models;

/**
 * this class is for user's status
 */
public class UserStatus implements Status {
    private String Status;

    /**
     * constructor. default user status is Normal user.
     */
    public UserStatus() {
        Status = "NormalUser";
    }

    /**
     * gets nothing and returns string representing user's status.
     * @return String which represents user status.
     */
    @Override
    public String getStatus() {
        return Status;
    }

    /**
     * gets user status and sets it to private variable.
     * @param Status String representing user status.
     * @return if status been successfully set.
     */
    @Override
    public boolean setStatus(String Status) {
        if (Status.equals("Admin") || Status.equals("NormalUser")
                || Status.equals("Courier") || Status.equals("Manager")) {
          this.Status = Status;
          return true;
        }
        return false;
    }
}
