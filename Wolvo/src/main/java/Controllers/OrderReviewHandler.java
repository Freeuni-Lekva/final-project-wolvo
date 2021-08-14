package Controllers;

import Models.DAO.DishDAO;
import Models.DAO.OrderDAO;
import Models.Dish;
import Models.Order;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrderReviewHandler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        if (!httpServletRequest.getSession().getAttribute("userType").equals("Customer")) {
            return;
        }
        Order order = ((OrderDAO) getServletContext().getAttribute("orders")).
                getByID((Integer.parseInt(httpServletRequest.getParameter("id"))));
        httpServletRequest.setAttribute("current_order",order);
        httpServletRequest.getRequestDispatcher("WEB-INF/Views/ReviewOrder.jsp").forward(httpServletRequest,httpServletResponse);

    }
}
