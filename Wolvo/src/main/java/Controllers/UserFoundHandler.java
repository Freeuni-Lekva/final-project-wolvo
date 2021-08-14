package Controllers;

import Models.DAO.DishDAO;
import Models.DAO.FriendsDAO;
import Models.DAO.FriendsRequestDAO;
import Models.DAO.UserDAO;
import Models.Dish;
import Models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserFoundHandler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        if (!httpServletRequest.getSession().getAttribute("userType").equals("Admin") &&
                !httpServletRequest.getSession().getAttribute("userType").equals("Customer")) {
            return;
        }
        User user = ((UserDAO) getServletContext().getAttribute("users")).
                getByID(Integer.parseInt(httpServletRequest.getParameter("id")));
        httpServletRequest.setAttribute("foundUser",user);
        if (httpServletRequest.getSession().getAttribute("userType").equals("Admin")) {
            httpServletRequest.getRequestDispatcher("WEB-INF/Views/UserPOVAdmin.jsp").forward(httpServletRequest, httpServletResponse);
        }   else {
            FriendsDAO friendsDAO = (FriendsDAO) ((getServletContext().getAttribute("friends")));
            FriendsRequestDAO friendsRequestDAO = (FriendsRequestDAO) (getServletContext().getAttribute("friend_requests"));
            if (friendsDAO.getFriends((User) httpServletRequest.getSession().getAttribute("customer")).contains(user)) {
                httpServletRequest.setAttribute("arefriends", 1);
            }   else {
                httpServletRequest.setAttribute("arefriends",0);
            }
            if (friendsRequestDAO.receivedRequets((User) httpServletRequest.getSession().getAttribute("customer")).contains(user)) {
                httpServletRequest.setAttribute("hasRequest",1);
            }   else {
                httpServletRequest.setAttribute("hasRequest",0);
            }
            httpServletRequest.getRequestDispatcher("WEB-INF/Views/UserPOVUser.jsp").forward(httpServletRequest,httpServletResponse);
        }
    }
}
