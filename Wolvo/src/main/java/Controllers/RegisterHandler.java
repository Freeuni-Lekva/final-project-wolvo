package Controllers;

import Models.DAO.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class RegisterHandler extends HttpServlet {

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
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("WEB-INF/Views/SignUpPage.jsp").forward(httpServletRequest,httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String email = httpServletRequest.getParameter("emailNew");
        UserDAO userDAO = (UserDAO) getServletContext().getAttribute("users");
        if (userDAO.getByEmail(email) != null) {
            return; // User Already Exists
        }
        String password = httpServletRequest.getParameter("passwordNew");
        String passwordConf = httpServletRequest.getParameter("passwordNewConf");
        if (!password.equals(passwordConf)) {
            return; // passwords doesn't match
        }
        String userType = httpServletRequest.getParameter("userT");
        String firstName = httpServletRequest.getParameter("fnameNew");
        String lastName = httpServletRequest.getParameter("lnameNew");
        String district = httpServletRequest.getParameter("districts");
        String address = httpServletRequest.getParameter("Address");
        String privacyType = httpServletRequest.getParameter("privacyT");
        String phonenum = httpServletRequest.getParameter("phone");
        int rowsAffected = userDAO.addUser(email,firstName,lastName,hashedPassword(password),userType,privacyType,district,
                                address,phonenum);
        if (rowsAffected == 1) {
            HttpSession session = httpServletRequest.getSession();
            session.setAttribute("userType",userType);
            session.setAttribute("name",firstName);
            httpServletRequest.getRequestDispatcher("WEB-INF/Views/successfulSignUp.jsp").forward(httpServletRequest,httpServletResponse);
        }   else {
            //Unexpected error
        }
    }
}
