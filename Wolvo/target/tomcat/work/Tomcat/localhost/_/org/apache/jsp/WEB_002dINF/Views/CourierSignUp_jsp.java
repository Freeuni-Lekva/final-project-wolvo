/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2021-08-08 15:04:53 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.Views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class CourierSignUp_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<div class = \"courSignUp\">\r\n");
      out.write("    <h1>Courier Registration</h1>\r\n");
      out.write("    <form action=\"register\" method=\"post\">\r\n");
      out.write("        <label for=\"emailRegCour\">Email:                      </label>\r\n");
      out.write("        <input type = \"email\" id = \"emailRegCour\" required=\"required\" name = \"emailNewCour\" /> <br> <br>\r\n");
      out.write("        <label for = \"passwordRegCour\">Password:                </label>\r\n");
      out.write("        <input type = \"password\" id = \"passwordRegCour\" required=\"required\" name = \"passwordNewCour\" /><br> <br>\r\n");
      out.write("        <label for = \"passwordRegConfCour\">Confirm Password: </label>\r\n");
      out.write("        <input type = \"password\" id = \"passwordRegConfCour\" required=\"required\" name = \"passwordNewConfCour\" /><br> <br>\r\n");
      out.write("        <label for = \"fnameregCour\">First Name:             </label>\r\n");
      out.write("        <input type = \"text\" id = \"fnameregCour\" required=\"required\" name = \"fnameNewCour\"/> <br> <br>\r\n");
      out.write("        <label for = \"lnameregCour\">Last Name:              </label>\r\n");
      out.write("        <input type = \"text\" id = \"lnameregCour\" required=\"required\" name = \"lnameNewCour\"/> <br> <br>\r\n");
      out.write("        <label for = \"districtCour\">Choose your working district: </label>\r\n");
      out.write("        <select id=\"districtCour\" name=\"districtsCour\">\r\n");
      out.write("            <option value=\"Didube\">Didube</option>\r\n");
      out.write("            <option value=\"Gldani\">Gldani</option>\r\n");
      out.write("            <option value=\"Saburtalo\">Saburtalo</option>\r\n");
      out.write("            <option value=\"Vake\">Vake</option>\r\n");
      out.write("            <option value=\"Isani\">Isani</option>\r\n");
      out.write("            <option value=\"Varketili\">Varketili</option>\r\n");
      out.write("            <option value=\"Digomi\">Digomi</option>\r\n");
      out.write("        </select> <br> <br>\r\n");
      out.write("        <Label for = \"phonenumberCour\">Phone number:        </Label>\r\n");
      out.write("        <input type = \"tel\" id = \"phonenumberCour\" required=\"required\" name = \"phoneCour\" placeholder=\"555-12-34-56\"\r\n");
      out.write("               pattern=\"[0-9]{3}-[0-9]{3}-[0-9]{3}\"> <br> <br> <br>\r\n");
      out.write("        <input type = \"submit\" id = \"signUpCourBut\" name = \"signUpCourPressed\" value=\"Sign Up\">\r\n");
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
