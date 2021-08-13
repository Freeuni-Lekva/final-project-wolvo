package Controllers;

import Models.DAO.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserSearchHandler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        if (!httpServletRequest.getSession().getAttribute("userType").equals("Admin") &&
                !httpServletRequest.getSession().getAttribute("userType").equals("Customer")) {
            return;
        }
        UserDAO users = (UserDAO) getServletContext().getAttribute("users");
        httpServletRequest.setAttribute("userList",users.getByName(httpServletRequest.getParameter("search")));
        httpServletRequest.getRequestDispatcher("WEB-INF/Views/UsersList.jsp").forward(httpServletRequest,httpServletResponse);
    }
}
