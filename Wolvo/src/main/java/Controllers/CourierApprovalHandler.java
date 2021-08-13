package Controllers;

import Models.Courier;
import Models.DAO.CourierDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CourierApprovalHandler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        if (!httpServletRequest.getSession().getAttribute("userType").equals("Admin")) {
            return;
        }
        Courier curr = ((CourierDAO) getServletContext().getAttribute("couriers")).
                getCourierById(Integer.parseInt(httpServletRequest.getParameter("id")));
        httpServletRequest.setAttribute("courierToApprove",curr);
        httpServletRequest.getRequestDispatcher("WEB-INF/Views/ApproveCourier.jsp").forward(httpServletRequest,httpServletResponse);
    }
}
