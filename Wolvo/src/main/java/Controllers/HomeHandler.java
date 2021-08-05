package Controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class HomeHandler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String userType = (String) httpServletRequest.getSession().getAttribute("userType");
        HashMap<String,String> respectivePages = new HashMap<>();
        respectivePages.put("Admin","WEB-INF/Views/AdminPage.jsp");
        respectivePages.put("Customer","WEB-INF/Views/CustomerPage.jsp");
        respectivePages.put("Manager","WEB-INF/Views/ManagerPage.jsp");
        respectivePages.put("Courier","WEB-INF/Views/CourierPage.jsp");
        httpServletRequest.getRequestDispatcher(respectivePages.get(userType)).
                forward(httpServletRequest,httpServletResponse);
    }
}
