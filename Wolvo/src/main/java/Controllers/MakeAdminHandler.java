package Controllers;

import Models.DAO.ManagerDAO;
import Models.DAO.UserDAO;
import Models.Manager;
import Models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MakeAdminHandler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        if (!httpServletRequest.getSession().getAttribute("userType").equals("Admin")) {
            return;
        }
        UserDAO usr = (UserDAO) getServletContext().getAttribute("users");
        usr.makeAdmin(Integer.parseInt(httpServletRequest.getParameter("id")));
        httpServletRequest.getRequestDispatcher("WEB-INF/Views/MadeAdmin.jsp").forward(httpServletRequest,httpServletResponse);
    }
}
