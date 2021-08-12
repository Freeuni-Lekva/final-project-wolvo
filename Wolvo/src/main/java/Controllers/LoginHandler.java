package Controllers;

import Models.Courier;
import Models.DAO.CourierDAO;
import Models.DAO.OrderDAO;
import Models.User;
import Models.DAO.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class LoginHandler extends HttpServlet {
    private String hexToString(byte[] bytes) {
        StringBuffer buff = new StringBuffer();
        for (int aByte : bytes) {
            int val = aByte;
            val = val & 0xff;  // remove higher bits, sign
            if (val < 16) buff.append('0'); // leading 0
            buff.append(Integer.toString(val, 16));
        }
        return buff.toString();
    }

    private String hashedPassword(String password) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        assert messageDigest != null;
        messageDigest.update(password.getBytes());
        return hexToString(messageDigest.digest());
    }

    private void logInCustomer(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String email = httpServletRequest.getParameter("email");
        String password = httpServletRequest.getParameter("password");
        UserDAO userDAO = (UserDAO) getServletContext().getAttribute("users");

        User currentUser = userDAO.getByEmail(email);
        if (currentUser == null) {
            return; // User not found
        }
        if (!currentUser.getPassword().equals(hashedPassword(password))) {
            return; // illegal password
        }
        httpServletRequest.getSession().setAttribute("name",currentUser.getFirstName());
        httpServletRequest.getSession().setAttribute("surname",currentUser.getLastName());
        httpServletRequest.getSession().setAttribute("customer",currentUser);
        httpServletRequest.getSession().setAttribute("userType",currentUser.getUserStatus().getStatus());
        System.out.println("WEB-INF/Views/" + currentUser.getUserStatus().getStatus() + "Page.jsp");
        httpServletRequest.getRequestDispatcher("WEB-INF/Views/" + currentUser.getUserStatus().getStatus() + "Page.jsp")
                .forward(httpServletRequest,httpServletResponse);

    }

    private void logInCourier(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String email = httpServletRequest.getParameter("email");
        String password = httpServletRequest.getParameter("password");
        CourierDAO courierDAO = (CourierDAO) getServletContext().getAttribute("couriers");

        Courier currentCourier = courierDAO.getCourierByEmail(email);
        if (currentCourier == null) {
            return; // User not found
        }
        if (!currentCourier.getPassword().equals(hashedPassword(password))) {
            return; // illegal password
        }
        httpServletRequest.getSession().setAttribute("name",currentCourier.getFirstName());
        httpServletRequest.getSession().setAttribute("surname",currentCourier.getLastName());
        httpServletRequest.getSession().setAttribute("courier",currentCourier);
        httpServletRequest.getSession().setAttribute("userType","Courier");
        httpServletRequest.getRequestDispatcher("WEB-INF/Views/CourierPage.jsp")
                .forward(httpServletRequest,httpServletResponse);
    }


    private void logInManager(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) {

    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        if (httpServletRequest.getParameter("userTLog").equals("Customer")) {
            logInCustomer(httpServletRequest,httpServletResponse);
        }
        if (httpServletRequest.getParameter("userTLog").equals("Courier")) {
            logInCourier(httpServletRequest,httpServletResponse);
        }
        if (httpServletRequest.getParameter("userTLog").equals("Manager")) {
            logInManager(httpServletRequest,httpServletResponse);
        }
    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        if (httpServletRequest.getSession().getAttribute("userType").equals("Courier")) {
            httpServletRequest.getRequestDispatcher("WEB-INF/Views/CourierPage.jsp")
                    .forward(httpServletRequest,httpServletResponse);
        }
    }
}
