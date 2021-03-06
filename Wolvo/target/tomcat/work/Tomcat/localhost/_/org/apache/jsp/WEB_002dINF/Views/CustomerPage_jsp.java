/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2021-08-18 19:57:15 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.Views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import Models.DAO.*;
import Models.*;

public final class CustomerPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <link rel = \"stylesheet\" href = \"../../Resources/style.css\" />\r\n");
      out.write("    <title>Wolvo</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class = \"customerInfo\">\r\n");
      out.write("    <label>Hello, ");
      out.print(((User) session.getAttribute("customer")).getFirstName());
      out.write("!</label> <br>\r\n");
      out.write("    <label>Let's have a look at your profile!</label> <br>\r\n");
      out.write("    <label>First Name: ");
      out.print(((User) session.getAttribute("customer")).getFirstName());
      out.write("</label> <br>\r\n");
      out.write("    <label>Last Name: ");
      out.print(((User) session.getAttribute("customer")).getLastName());
      out.write("</label> <br>\r\n");
      out.write("    <label>Email: ");
      out.print(((User) session.getAttribute("customer")).getEmail());
      out.write("</label> <br>\r\n");
      out.write("    <label>Phone Number: ");
      out.print(((User) session.getAttribute("customer")).getPhoneNumber());
      out.write("</label> <br>\r\n");
      out.write("    <label>District: ");
      out.print(((User) session.getAttribute("customer")).getDistrict());
      out.write("</label> <br>\r\n");
      out.write("    <label>Living address: ");
      out.print(((User) session.getAttribute("customer")).getAddress());
      out.write("</label> <br>\r\n");
      out.write("    <label>User Status: ");
      out.print(((User) session.getAttribute("customer")).getUserStatus().getStatus());
      out.write("</label> <br>\r\n");
      out.write("    <label>Privacy Status: ");
      out.print(((User) session.getAttribute("customer")).getPrivacyStatus().getStatus());
      out.write("</label> <br>\r\n");
      out.write("</div>\r\n");
      out.write("<div class = \"customerFriends\">\r\n");
      out.write("    <label>List of your friends: </label> <br>\r\n");
      out.write("    ");
 List<User> userFriends = ((FriendsDAO) application.getAttribute("friends")).getFriends((User) session.getAttribute("customer"));
        if (userFriends.isEmpty()) { 
      out.write("\r\n");
      out.write("    <label>You don't have any friends yet.</label>\r\n");
      out.write("    ");
 }
    else {
        for (User user : userFriends) { 
      out.write("\r\n");
      out.write("    <a href=\"userFound?id=");
      out.print(user.getId());
      out.write('"');
      out.write('>');
      out.write(' ');
      out.print(user.getFirstName());
      out.write(' ');
      out.print(user.getLastName());
      out.write(" </a> <br>\r\n");
      out.write("    ");
 }
    }  
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<div class = \"customerFriendRequests\">\r\n");
      out.write("    <label>Your friend Requests</label> <br>\r\n");
      out.write("    ");
 List<User> userRequests = ((FriendsRequestDAO) application.getAttribute("friend_requests")).
            receivedRequets((User) session.getAttribute("customer"));
        if (userRequests.isEmpty()) { 
      out.write("\r\n");
      out.write("    <label>You don't have any friend requests yet.</label>\r\n");
      out.write("    ");
 }
    else {
        for (User user : userRequests) { 
      out.write("\r\n");
      out.write("    <label>");
      out.print(user.getFirstName());
      out.write(' ');
      out.print(user.getLastName());
      out.write("</label> <br>\r\n");
      out.write("    <a href=\"userFound?id=");
      out.print(user.getId());
      out.write("\">See Profile</a>\r\n");
      out.write("    <a href=\"confirmRequest?id=");
      out.print(user.getId());
      out.write("\"> Accept </a>\r\n");
      out.write("    <a href=\"rejectRequest?id=");
      out.print(user.getId());
      out.write("\"> Reject </a> <br>\r\n");
      out.write("    ");
 }
    }  
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"OrderHistory\">\r\n");
      out.write("    <label>Your order History:</label> <br>\r\n");
      out.write("    ");
 List<Order> userOrds = ((OrderDAO) application.getAttribute("orders")).
            getUserOrders(((User) session.getAttribute("customer")).getId());
        if (userOrds.isEmpty()) { 
      out.write("\r\n");
      out.write("    <label>You don't have any orders yet.</label> <br>\r\n");
      out.write("    ");
   }
    else {
        for (Order ord : userOrds) {
            Dish dish = ((DishDAO) application.getAttribute("dishes")).getDishById(ord.getDish());
            if (dish != null) {
            Restaurant rest = ((RestaurantDAO) application.getAttribute("restaurants")).getRestaurantById(dish.getRest_id());
            Courier courier = ((CourierDAO) application.getAttribute("couriers")).getCourierById(ord.getCourier()); 
      out.write("\r\n");
      out.write("    <label>Dish name: ");
      out.print(dish.getName());
      out.write("</label> <br>\r\n");
      out.write("    <label>Category: ");
      out.print(dish.getCategory());
      out.write("</label><br>\r\n");
      out.write("    <label>Restaurant name: ");
      out.print(rest.getName());
      out.write("</label><br>\r\n");
      out.write("    <label>Price: ");
      out.print(dish.getPrice());
      out.write("</label><br>\r\n");
      out.write("    <label>Courier: ");
      out.print(courier.getFirstName());
      out.write(' ');
      out.print(courier.getLastName());
      out.write("</label><br>\r\n");
      out.write("    <label>Order Date: ");
      out.print(ord.getOrderDate());
      out.write("</label><br>\r\n");
      out.write("    <label>Order status: ");
      out.print(ord.getOrderStatus().getStatus());
      out.write("</label><br>\r\n");
      out.write("    ");

        if (ord.getOrderStatus().getStatus().equals(Constants.DELIVERED)) {
    
      out.write("\r\n");
      out.write("    <label>Receive date: ");
      out.print(ord.getReceiveDate());
      out.write("</label> <br>\r\n");
      out.write("    ");

        Review currRev = ((ReviewDAO) application.getAttribute("reviews")).getByID(ord.getId());
        if (currRev == null) {
      out.write("\r\n");
      out.write("    <a href=\"reviewOrd?id=");
      out.print(ord.getId());
      out.write("\">Rate order</a><br>\r\n");
      out.write("    ");
 } else {
        if (currRev.getCourierRating() != -1) { 
      out.write("\r\n");
      out.write("    <label>You gave a courier ");
      out.print(currRev.getCourierRating());
      out.write(" out of 5!</label> <br>\r\n");
      out.write("    ");
    }
        if (currRev.getDishRating() != -1) { 
      out.write("\r\n");
      out.write("    <label>You gave a dish ");
      out.print(currRev.getDishRating());
      out.write(" out of 5!</label> <br>\r\n");
      out.write("    ");
    } 
      out.write("\r\n");
      out.write("    ");
 if (!currRev.getCourierText().equals("")) {  
      out.write("\r\n");
      out.write("    <label>You made a comment about courier: ");
      out.print(currRev.getCourierText());
      out.write("</label>\r\n");
      out.write("    ");
 }
        if (!currRev.getDishText().equals("")) { 
      out.write("\r\n");
      out.write("    <label>You also made a comment about dish: ");
      out.print(currRev.getDishText());
      out.write(" </label> <br>\r\n");
      out.write("    ");

         }
        }
      out.write("\r\n");
      out.write("    ");
 } 
      out.write("\r\n");
      out.write("    ");
 }
      out.write("\r\n");
      out.write("    ");
   } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("    ");
 } 
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"newOrder\">\r\n");
      out.write("    <label>Make new Order!</label> <br>\r\n");
      out.write("    <label>You can order from these restaurants: </label> <br>\r\n");
      out.write("    ");

        List<Restaurant> restaurants = ((RestaurantDAO) application.getAttribute("restaurants")).getRestaurants();
        if (restaurants.isEmpty()) { 
      out.write("\r\n");
      out.write("    <label>Unfortunately, there are no restaurants working right now</label>\r\n");
      out.write("    ");
 }
    else {
        for (Restaurant res : restaurants) { 
      out.write("\r\n");
      out.write("    <a href = \"orderFromRestaurant?id=");
      out.print(res.getId());
      out.write('"');
      out.write('>');
      out.print(res.getName());
      out.write("</a> <br>\r\n");
      out.write("    ");
   }
    }
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<div class = \"userSearchBar\">\r\n");
      out.write("    <form action = \"userSearch\" method = \"get\">\r\n");
      out.write("        <input type = \"text\" id = \"searchUser\" name = \"search\" placeholder=\"Look for users by full name\"/> <br> <br>\r\n");
      out.write("    </form>\r\n");
      out.write("</div>\r\n");
      out.write("<div class = \"logout\">\r\n");
      out.write("    <form action = \"SignOut\" method = \"post\">\r\n");
      out.write("        <input type=\"submit\" value=\"Sign Out\" id = \"SignOut\" name = \"SignOut\"/>\r\n");
      out.write("    </form>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
