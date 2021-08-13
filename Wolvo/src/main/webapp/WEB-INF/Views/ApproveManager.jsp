<%@ page import="Models.Courier" %>
<%@ page import="Models.DAO.ManagerDAO" %>
<%@ page import="Models.Manager" %>
<%@ page import="Models.Restaurant" %>
<%@ page import="Models.DAO.RestaurantDAO" %><%--
  Created by IntelliJ IDEA.
  User: tsotn
  Date: 8/3/2021
  Time: 4:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel = "stylesheet" href = "../../Resources/style.css" />
    <title>Wolvo</title>
</head>
<body>
<div class = "divManagerApprove">
    <label>First Name: <%=((Manager) request.getAttribute("managerToApprove")).getFirstName()%></label> <br>
    <label>Last Name: <%=((Manager) request.getAttribute("managerToApprove")).getLastName()%></label> <br>
    <label>Email: <%=((Manager) request.getAttribute("managerToApprove")).getEmail()%></label> <br>
    <label>Phone Number: <%=((Manager) request.getAttribute("managerToApprove")).getPhoneNumber()%> </label> <br>
    <% Restaurant res = ((RestaurantDAO) application.getAttribute("restaurants")).
            getRestaurantById(((Manager) request.getAttribute("managerToApprove")).getRest_id());%>
    <label>Restaurant name: <%=  res.getName()%></label> <br>
    <label>Restaurant district: <%=res.getDistrict()%></label> <br>
    <label>Restaurant address: <%=res.getAddress()%></label> <br>
    <a href="approveManagerConf?id=<%= ((Manager) request.getAttribute("managerToApprove")).getId()%>">Approve</a>
    <a href="rejectManager?id=<%= ((Manager) request.getAttribute("managerToApprove")).getId()%>">Reject</a>

</div>
<body>
</html>
