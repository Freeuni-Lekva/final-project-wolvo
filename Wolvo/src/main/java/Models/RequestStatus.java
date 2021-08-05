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
        Status = "NotResponded";
    }

    /**
     * sets given status active.
     * @param Status is string, it is set to private variable.
     * @return if status been successfully set.
     */
    @Override
    public boolean setStatus(String Status) {
        if (Status.equals("Accepted") || Status.equals("Rejected")
                || Status.equals("NotResponded") || Status.equals("NotSent")) {
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

    /**
     * compares object to RequestStatus object.
     * @param obj Object type which is compared to this class type.
     * @return boolean representing if both are equal RequestStatus.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof RequestStatus)) return false;
        return ((RequestStatus) obj).getStatus().equals(Status);
    }
}
