package Controllers;

import Models.DAO.DishDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DishAdditionHandler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String name = httpServletRequest.getParameter("name");
        int restaurant = Integer.valueOf(httpServletRequest.getParameter("restaurant"));
        String category = httpServletRequest.getParameter("category");
        float price = Float.valueOf(httpServletRequest.getParameter("price"));
        DishDAO dishDAO = (DishDAO) getServletContext().getAttribute("dishes");
        dishDAO.addDish(name, restaurant, category, price);
        httpServletRequest.getRequestDispatcher("WEB-INF/Views/DishAdd.jsp").forward(httpServletRequest,httpServletResponse);
    }
}
