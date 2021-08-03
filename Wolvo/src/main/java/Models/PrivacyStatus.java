package Models;

/**
 * this status is for privacy status.
 */
public class PrivacyStatus implements Status {
    private String Status;

    /**
     * constructor. default privacy status is Public.
     */
    public PrivacyStatus() {
        this.Status = "Public";
    }

    /**
     * gets nothing, returns current active privacy status.
     * @return String representing active privacy status.
     */
    @Override
    public String getStatus() {
        return this.Status;
    }

    /**
     * gets Status and sets to active. status is set to private variable.
     * @param Status String representing status.
     * @return if status been set successfully.
     */
    @Override
    public boolean setStatus(String Status) {
        if (Status.equals("Public") || Status.equals("Private") || Status.equals("Friends")) {
            this.Status = Status;
            return true;
        }
        return false;
    }
}
