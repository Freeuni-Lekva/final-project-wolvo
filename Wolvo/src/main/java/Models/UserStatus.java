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
        Status = "Customer";
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
        if (Status.equals("Admin") || Status.equals("Customer")
                || Status.equals("Courier") || Status.equals("Manager")) {
          this.Status = Status;
          return true;
        }
        return false;
    }

    /**
     * compares object to UserStatus object.
     * @param obj Object type which is compared to this class type.
     * @return boolean representing if both are equal UserStatus.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof UserStatus)) return false;
        return ((UserStatus) obj).getStatus().equals(Status);
    }
}
