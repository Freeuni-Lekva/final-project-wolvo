/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2021-08-06 15:19:57 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.Views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class SignUpPage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <link rel = \"stylesheet\" href = \"../../Resources/style.css\" />\r\n");
      out.write("    <title>Sign Up on Wolvo</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<h1>Welcome to Wolvo</h1>\r\n");
      out.write("<form action=\"register\" method=\"post\">\r\n");
      out.write("    <label for=\"emailReg\">Email: </label>\r\n");
      out.write("    <input type = \"email\" id = \"emailReg\" required=\"required\" name = \"emailNew\" /> <br> <br>\r\n");
      out.write("    <label for = \"passwordReg\">Password: </label>\r\n");
      out.write("    <input type = \"password\" id = \"passwordReg\" required=\"required\" name = \"passwordNew\" /><br> <br>\r\n");
      out.write("    <label for = \"passwordRegConf\">Confirm Password: </label>\r\n");
      out.write("    <input type = \"password\" id = \"passwordRegConf\" required=\"required\" name = \"passwordNewConf\" /><br> <br>\r\n");
      out.write("    <label>Choose your user type: </label> <br>\r\n");
      out.write("    <input type = \"radio\" id = \"customer\" name = \"userT\" value=\"Customer\" required>\r\n");
      out.write("    <label for = \"customer\">Customer</label> <br>\r\n");
      out.write("    <input type = \"radio\" id = \"courier\" name = \"userT\" value=\"Courier\">\r\n");
      out.write("    <label for = \"courier\">Courier</label> <br>\r\n");
      out.write("    <input type = \"radio\" id = \"manager\" name = \"userT\" value=\"Manager\">\r\n");
      out.write("    <label for = \"manager\">Restaurant Manager</label> <br> <br>\r\n");
      out.write("    <label for = \"fnamereg\">First Name: </label>\r\n");
      out.write("    <input type = \"text\" id = \"fnamereg\" required=\"required\" name = \"fnameNew\"/> <br> <br>\r\n");
      out.write("    <label for = \"lnamereg\">Last Name: </label>\r\n");
      out.write("    <input type = \"text\" id = \"lnamereg\" required=\"required\" name = \"lnameNew\"/> <br> <br>\r\n");
      out.write("    <label for = \"district\">Choose your district: </label>\r\n");
      out.write("    <select id=\"district\" name=\"districts\">\r\n");
      out.write("        <option value=\"Didube\">Didube</option>\r\n");
      out.write("        <option value=\"Gldani\">Gldani</option>\r\n");
      out.write("        <option value=\"Saburtalo\">Saburtalo</option>\r\n");
      out.write("        <option value=\"Vake\">Vake</option>\r\n");
      out.write("    </select> <br> <br>\r\n");
      out.write("    <label for = \"address\">Enter your living address: </label>\r\n");
      out.write("    <input type = \"text\" id = \"address\" required=\"required\" name = \"Address\"/> <br> <br>\r\n");
      out.write("    <label>Please specify your privacy settings: </label> <br>\r\n");
      out.write("    <input type = \"radio\" id = \"firstT\" name = \"privacyT\" value=\"Private\" required>\r\n");
      out.write("    <label for = \"firstT\">No one can see my order history</label> <br>\r\n");
      out.write("    <input type = \"radio\" id = \"secondT\" name = \"privacyT\" value=\"Friends\">\r\n");
      out.write("    <label for = \"secondT\">Only my friends can see my order history</label> <br>\r\n");
      out.write("    <input type = \"radio\" id = \"thirdT\" name = \"privacyT\" value=\"Public\">\r\n");
      out.write("    <label for = \"thirdT\">Anyone can see my order history</label> <br> <br>\r\n");
      out.write("    <Label for = \"phonenumber\">Enter your phone number: </Label>\r\n");
      out.write("    <input type = \"number\" id = \"phonenumber\" required=\"required\" name = \"phone\"> <br> <br>\r\n");
      out.write("    <button>Sign Up</button>\r\n");
      out.write("</form>\r\n");
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
