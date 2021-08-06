package Models;

import Models.DAO.FriendsDAO;
import Models.DAO.FriendsRequestDAO;
import Models.DAO.UserDAO;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Initializer implements ServletContextListener, HttpSessionListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        }
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/test_db?user=root&password=");
        } catch (SQLException throwables) {
        }
        UserDAO userDAO = new UserDAO(connection);
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute("users",userDAO);
        FriendsRequestDAO friendsRequestDAO = new FriendsRequestDAO(connection);
        servletContext.setAttribute("friend_requests",friendsRequestDAO);
        FriendsDAO friendsDAO = new FriendsDAO(connection);
        servletContext.setAttribute("friends",friendsDAO);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }
}
