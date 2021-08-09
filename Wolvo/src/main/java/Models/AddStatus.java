package Models;

import static Models.Constants.*;

public class AddStatus implements Status {

    private String status;

    public AddStatus() {
        this.status = FREE;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public boolean setStatus(String status) {
        if (status.equals(FREE) || status.equals(OCCUPIED)) {
            this.status = status;
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof AddStatus)) return false;
        else return ((AddStatus) obj).getStatus().equals(status);
    }
}
