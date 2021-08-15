/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2021-08-15 20:06:28 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.Views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Models.User;
import java.util.List;
import Models.Order;
import Models.DAO.OrderDAO;
import Models.DAO.UserDAO;
import Models.DAO.DishDAO;
import Models.Dish;
import Models.DAO.RestaurantDAO;
import Models.Restaurant;

public final class UserPOVAdmin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\r\n");
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
      out.write("<div class = \"userFF\">\r\n");
      out.write("    <label>First Name: ");
      out.print( ((User) request.getAttribute("foundUser")).getFirstName());
      out.write("</label> <br>\r\n");
      out.write("    <label>Last Name: ");
      out.print( ((User) request.getAttribute("foundUser")).getLastName());
      out.write("</label> <br>\r\n");
      out.write("    <label>Email: ");
      out.print( ((User) request.getAttribute("foundUser")).getEmail());
      out.write("</label> <br>\r\n");
      out.write("    <label>Phone Number: ");
      out.print( ((User) request.getAttribute("foundUser")).getPhoneNumber());
      out.write(" </label> <br>\r\n");
      out.write("    <label>District: ");
      out.print( ((User) request.getAttribute("foundUser")).getDistrict());
      out.write("</label> <br>\r\n");
      out.write("    <label>Address: ");
      out.print( ((User) request.getAttribute("foundUser")).getAddress());
      out.write("</label> <br>\r\n");
      out.write("    <a href=\"makeAdmin?id=");
      out.print(((User) request.getAttribute("foundUser")).getId());
      out.write("\">Change user status to Administrator</a>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div class = \"userFOrders\">\r\n");
      out.write("    <label>Order History</label> <br>\r\n");
      out.write("    ");
 List<Order> courOrds = ((OrderDAO) application.getAttribute("orders")).
            getUserOrders(((User) request.getAttribute("foundUser")).getId());
        if (courOrds.isEmpty()) {
    
      out.write("\r\n");
      out.write("    <label>User doesn't have any orders.</label>\r\n");
      out.write("    ");
 }
    else { 
      out.write("\r\n");
      out.write("    ");
 for (Order ord : courOrds) {
       Dish currDish = ((DishDAO) application.getAttribute("dishes")).getDishById(ord.getDish());
       Restaurant currRest = ((RestaurantDAO) application.getAttribute("restaurants")).getRestaurantById(currDish.getRest_id());
    
      out.write("\r\n");
      out.write("   <li>\r\n");
      out.write("    <label>Dish: ");
      out.print(currDish.getName());
      out.write(" <br>\r\n");
      out.write("    <label>Price: ");
      out.print(currDish.getPrice());
      out.write("</label>\r\n");
      out.write("    <label>Restaurant: ");
      out.print(currRest.getName());
      out.write("</label> <br>\r\n");
      out.write("    <label>Restaurant address: ");
      out.print(currRest.getDistrict());
      out.write(',');
      out.write(' ');
      out.print(currRest.getAddress());
      out.write("</label> <br>\r\n");
      out.write("   </li>\r\n");
      out.write("    ");
 } 
      out.write("\r\n");
      out.write("    ");

        }
    
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<a href=\"login\">Go Back to My Page</a>\r\n");
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
