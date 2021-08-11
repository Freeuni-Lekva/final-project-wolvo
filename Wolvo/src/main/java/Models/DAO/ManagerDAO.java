package Models.DAO;

import java.sql.Connection;

import static Models.Constants.*;

/**
 * this class is for connection to 'managers' table
 */
public class ManagerDAO {
    private Connection connection;

    /**
     * constructor, which initializes connection.
     * @param connection type of Connection
     */
    public ManagerDAO(Connection connection) {
        this.connection = connection;
    }

//    private Manager convertToManager() {
//
//    }

    public void getManagers() {

    }
}
