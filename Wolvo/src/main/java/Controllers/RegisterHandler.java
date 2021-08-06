package Controllers;

import Models.DAO.UserDAO;
import Models.UserStatus;

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
        if (httpServletRequest.getParameter("custReg") != null) {
            httpServletRequest.getRequestDispatcher("WEB-INF/Views/CustomerSignUp.jsp").forward(httpServletRequest,httpServletResponse);
        }
        if (httpServletRequest.getParameter("manReg") != null) {
            httpServletRequest.getRequestDispatcher("WEB-INF/Views/ManagerSignUp.jsp").forward(httpServletRequest,httpServletResponse);
        }
        if (httpServletRequest.getParameter("courReg") != null) {
            httpServletRequest.getRequestDispatcher("WEB-INF/Views/CourierSignUp.jsp").forward(httpServletRequest,httpServletResponse);
        }
    }

    protected void addUser(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String email = httpServletRequest.getParameter("emailNewCust");
        UserDAO userDAO = (UserDAO) getServletContext().getAttribute("users");
        if (userDAO.getByEmail(email) != null) {
            return; // User Already Exists
        }
        String password = httpServletRequest.getParameter("passwordNewCust");
        String passwordConf = httpServletRequest.getParameter("passwordNewConfCust");
        if (!password.equals(passwordConf)) {
            return; // passwords doesn't match
        }
        String firstName = httpServletRequest.getParameter("fnameNewCust");
        String lastName = httpServletRequest.getParameter("lnameNewCust");
        String district = httpServletRequest.getParameter("districtsCust");
        String address = httpServletRequest.getParameter("AddressCust");
        String privacyType = httpServletRequest.getParameter("privacyTCust");
        String phonenum = httpServletRequest.getParameter("phoneCust");
        int rowsAffected = userDAO.addUser(email,firstName,lastName,hashedPassword(password),"Customer",privacyType,district,
                address,phonenum);
        if (rowsAffected == 1) {
            HttpSession session = httpServletRequest.getSession();
            session.setAttribute("userType","Customer");
            session.setAttribute("name",firstName);
            httpServletRequest.getRequestDispatcher("WEB-INF/Views/successfulSignUp.jsp").forward(httpServletRequest,httpServletResponse);
        }   else {
            //Unexpected error
        }

    }

    protected void addCourier(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("WEB-INF/Views/successfulSignUpApproval.jsp").forward(httpServletRequest,httpServletResponse);
    }

    protected void addManager(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("WEB-INF/Views/successfulSignUpApproval.jsp").forward(httpServletRequest,httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        if (httpServletRequest.getParameter("signUpCustPressed") != null) {
            addUser(httpServletRequest,httpServletResponse);
        }
        if (httpServletRequest.getParameter("signUpCourPressed") != null) {
            addCourier(httpServletRequest,httpServletResponse);
        }
        if (httpServletRequest.getParameter("signUpManPressed") != null) {
            addManager(httpServletRequest,httpServletResponse);
        }
    }
}
