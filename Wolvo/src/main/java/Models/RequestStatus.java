package Models;

/**
 * this class is to represent status of request.
 */
public class RequestStatus implements Status {
    String Status;

    /**
     * constructor, default value of request status is notResponded.
     */
    public RequestStatus() {
        Status = "notResponded";
    }

    /**
     * sets given status active.
     * @param Status is string, it is set to private variable.
     * @return if status been successfully set.
     */
    @Override
    public boolean setStatus(String Status) {
        if (Status.equals("Accepted") || Status.equals("Rejected") || Status.equals("NotResponded")) {
           this.Status = Status;
           return true;
        }
        return false;
    }

    /**
     * gets nothing, returns request status.
     * @return String represents request status.
     */
    public String getStatus() {
        return Status;
    }

}
