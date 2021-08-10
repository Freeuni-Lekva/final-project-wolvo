package Models;

import static Models.Constants.*;

public class CourierStatus implements Status {

    private String status;

    public CourierStatus() {
        this.status = FREE;
    }

    /**
     *
     * @return Courier Status
     * Free - if courier is not working on any order in the moment, otherwise - occupied
     */
    @Override
    public String getStatus() {
        return status;
    }

    /**
     * sets new Status for courier (Free or Occupied)
     * @param status
     * @return true if new Status is valid (i.e. one of the two specified above)
     */
    @Override
    public boolean setStatus(String status) {
        if (status.equals(FREE) || status.equals(OCCUPIED)) {
            this.status = status;
            return true;
        }
        return false;
    }


    /**
     *
     * @param obj
     * @return true if object received as a parameter is equal to this particular CourierStatus
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof CourierStatus)) return false;
        else return ((CourierStatus) obj).getStatus().equals(status);
    }
}
