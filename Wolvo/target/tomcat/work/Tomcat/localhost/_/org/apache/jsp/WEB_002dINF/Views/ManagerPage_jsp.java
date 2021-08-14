/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2021-08-13 19:51:53 UTC
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

public final class ManagerPage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<div class = \"managerInfo\">\r\n");
      out.write("    <label>Hello, ");
      out.print( session.getAttribute("name"));
      out.write("!</label> <br>\r\n");
      out.write("    <label>Lets have a look at your profile!</label> <br>\r\n");
      out.write("    <label>Your contact info: </label> <br>\r\n");
      out.write("    <label>First Name: ");
      out.print( session.getAttribute("name"));
      out.write("</label> <br>\r\n");
      out.write("    <label>Last Name: ");
      out.print( session.getAttribute("surname"));
      out.write("</label> <br>\r\n");
      out.write("    <label>User type: ");
      out.print(session.getAttribute("userType"));
      out.write("</label> <br>\r\n");
      out.write("    <label>Email: ");
      out.print( ((Manager) session.getAttribute("manager")).getEmail());
      out.write("</label> <br>\r\n");
      out.write("    <label>Phone Number: ");
      out.print( ((Manager) session.getAttribute("manager")).getPhoneNumber());
      out.write(" </label>\r\n");
      out.write("</div>\r\n");
      out.write("<div class = \"managerRests\">\r\n");
      out.write("    <label>Let's see your restaurant basic info!</label> <br>\r\n");
      out.write("    ");
 Restaurant restaurant = ((RestaurantDAO) application.getAttribute("restaurants")).
            getRestaurantById(((Manager) session.getAttribute("manager")).getRest_id());
        if (restaurant == null) {
    
      out.write("\r\n");
      out.write("    <label>You don't have any restaurants.</label>\r\n");
      out.write("    ");
 }
    else { 
      out.write("\r\n");
      out.write("    <label>Restaurant Name: ");
      out.print( ((Restaurant) restaurant).getName() );
      out.write(" <br> </label>\r\n");
      out.write("    <label>Restaurant District: ");
      out.print( ((Restaurant) restaurant).getDistrict() );
      out.write(" <br> </label>\r\n");
      out.write("    <label>Restaurant Address: ");
      out.print( ((Restaurant) restaurant).getAddress() );
      out.write(" <br> </label>\r\n");
      out.write("    <label>Restaurant Rating: ");
      out.print( ((Restaurant) restaurant).getRating() );
      out.write(" <br> </label>\r\n");
      out.write("    <label>Restaurant Number of Raters: ");
      out.print( ((Restaurant) restaurant).getRaters() );
      out.write(" <br> </label>\r\n");
      out.write("    ");
}
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<div class = \"managerRestDishes\">\r\n");
      out.write("    <label>Let's see your restaurant Dishes!</label> <br>\r\n");
      out.write("    ");
 List<Dish> dishes = ((DishDAO) application.getAttribute("dishes")).
            getRestaurantDishes(((RestaurantDAO) application.getAttribute("restaurants")).getRestaurantById(((Manager) session.getAttribute("manager")).getRest_id()));
        if (dishes.isEmpty()) {
    
      out.write("\r\n");
      out.write("            <label>Your restaurant doesn't have any dish.</label>\r\n");
      out.write("        ");
 }
    else { 
      out.write("\r\n");
      out.write("    <label> Your Dishes: <br> </label>\r\n");
      out.write("            ");
 for (Dish d : dishes) { 
      out.write("\r\n");
      out.write("            <label> Dish Name: ");
      out.print( ((Dish) d).getName() );
      out.write("</label>\r\n");
      out.write("            <label><a href=\"removeDish?id=");
      out.print( ((Dish) d).getDish_id());
      out.write("\">Remove</a> <br> </label>\r\n");
      out.write("            <label> Dish Price: ");
      out.print( ((Dish) d).getPrice() );
      out.write(" <br> </label>\r\n");
      out.write("            <label> Dish Category: ");
      out.print( ((Dish) d).getCategory() );
      out.write(" <br> </label>\r\n");
      out.write("            <label> Dish Rating: ");
      out.print( ((Dish) d).getRating() );
      out.write(" <br> </label>\r\n");
      out.write("            <label> Dish Number of Raters: ");
      out.print( ((Dish) d).getRaters() );
      out.write(" <br> </label>\r\n");
      out.write("            <label> Dish Status: ");
      out.print( ((Status) ((Dish) d).getAdded()).getStatus() );
      out.write(" <br> </label>\r\n");
      out.write("        ");
 } 
      out.write("\r\n");
      out.write("    ");
 } 
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<div class = \"addNewDish\">\r\n");
      out.write("    <form action=\"dishRequest\" method=\"get\">\r\n");
      out.write("        <input type=\"hidden\" id=\"id\" name=\"restaurant\" value=");
      out.print(((Manager) session.getAttribute("manager")).getRest_id());
      out.write(">\r\n");
      out.write("        <p1> Send Request For New Dish </p1> <br> <br>\r\n");
      out.write("        <label for=\"dishName\"> Dish Name:        </label>\r\n");
      out.write("        <input type = \"text\" id = \"dishName\" required=\"required\" name = \"name\"/> <br> <br>\r\n");
      out.write("        <label for=\"dishCategory\"> Dish Category:  </label>\r\n");
      out.write("        <input type = \"text\" id = \"dishCategory\" required=\"required\" name = \"category\"/> <br> <br>\r\n");
      out.write("        <label for=\"dishPrice\"> Dish Price:         </label>\r\n");
      out.write("        <input type = \"number\" id = \"dishPrice\" required=\"required\" name=\"price\" placeholder=\"5.99\" step=\"0.01\" min=\"0\"> <br> <br>\r\n");
      out.write("        <input type = \"submit\" value = \"Submit Dish\" id = \"dishSubmit\" name=\"dishSubmit\"> <br> <br>\r\n");
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
