package Controllers;

import Models.DAO.FriendsDAO;
import Models.DAO.FriendsRequestDAO;
import Models.DAO.UserDAO;
import Models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RejectRequestHandler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        if (!httpServletRequest.getSession().getAttribute("userType").equals("Customer")) {
            return;
        }
        User usrTo = (User) httpServletRequest.getSession().getAttribute("customer");
        User userFrom = ((UserDAO) getServletContext().getAttribute("users")).
                getByID(Integer.parseInt(httpServletRequest.getParameter("id")));
        FriendsRequestDAO friendsRequestDAO = (FriendsRequestDAO) getServletContext().getAttribute("friend_requests");
        if (!friendsRequestDAO.receivedRequets(usrTo).contains(userFrom)) {
            return;
        }
        FriendsDAO friendsDAO = (FriendsDAO) getServletContext().getAttribute("friends");
        friendsRequestDAO.removeFriendsRequest(userFrom,usrTo);
        httpServletRequest.getRequestDispatcher("WEB-INF/Views/RequestRejected.jsp").forward(httpServletRequest,httpServletResponse);
    }
}
