package Controllers;

import Models.User;
import Models.UserDAO;

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

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
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
        HashMap<String,String> respectivePages = new HashMap<>();
        respectivePages.put("Admin","WEB-INF/Views/AdminPage.jsp");
        respectivePages.put("Customer","WEB-INF/Views/CustomerPage.jsp");
        respectivePages.put("Manager","WEB-INF/Views/ManagerPage.jsp");
        respectivePages.put("Courier","WEB-INF/Views/CourierPage.jsp");

        httpServletRequest.getSession().setAttribute("userType",currentUser.getUserStatus().getStatus());
        httpServletRequest.getRequestDispatcher(respectivePages.get(currentUser.getUserStatus().getStatus())).forward(httpServletRequest,httpServletResponse);
    }
}
