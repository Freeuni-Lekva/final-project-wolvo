package Controllers;

import Models.DAO.DishDAO;
import Models.DAO.OrderDAO;
import Models.DAO.RestaurantDAO;
import Models.Dish;
import Models.Restaurant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrderDishHandler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        if (!httpServletRequest.getSession().getAttribute("userType").equals("Customer")) {
            return;
        }
        Dish dish = ((DishDAO) getServletContext().getAttribute("dishes")).
                getDishById((Integer.parseInt(httpServletRequest.getParameter("id"))));
        httpServletRequest.setAttribute("current_dish",dish);
        httpServletRequest.getRequestDispatcher("WEB-INF/Views/OrderDish.jsp").forward(httpServletRequest,httpServletResponse);

    }
}
