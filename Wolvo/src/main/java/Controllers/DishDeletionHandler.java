package Controllers;

import Models.*;
import Models.DAO.DishDAO;
import Models.DAO.OrderDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DishDeletionHandler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        DishDAO dishDAO = (DishDAO) getServletContext().getAttribute("dishes");
        dishDAO.removeDish(Integer.valueOf(httpServletRequest.getParameter("id")));
        httpServletRequest.getRequestDispatcher("WEB-INF/Views/RemoveDish.jsp").forward(httpServletRequest,httpServletResponse);
    }
}
