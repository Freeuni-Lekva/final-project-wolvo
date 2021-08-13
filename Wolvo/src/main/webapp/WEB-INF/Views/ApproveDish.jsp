<%@ page import="Models.Courier" %>
<%@ page import="Models.Dish" %>
<%@ page import="Models.DAO.RestaurantDAO" %>
<%@ page import="Models.Restaurant" %>
<%@ page import="Models.DAO.ManagerDAO" %>
<%@ page import="Models.Manager" %><%--
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
<div class = "divDishApprove">
    <label>Dish Name: <%= ((Dish) request.getAttribute("dishToApprove")).getName()%></label> <br>
    <label>Dish Category: <%= ((Dish) request.getAttribute("dishToApprove")).getCategory()%> </label> <br>
    <label>Dish Price: <%= ((Dish) request.getAttribute("dishToApprove")).getPrice()%> </label> <br>
    <% Restaurant res = ((RestaurantDAO) application.getAttribute("restaurants")).
            getRestaurantById(((Dish) request.getAttribute("dishToApprove")).getRest_id());
       Manager man = ((ManagerDAO) application.getAttribute("managers")).getManagerByID(res.getManager_id());
    %>
    <label>Restaurant: <%= res.getId()%></label> <br>
    <label>Restaurant District: <%= res.getDistrict()%></label> <br>
    <label>Restaurant address: <%=res.getAddress()%></label> <br>
    <label>Restaurant Manager: <%=man.getFirstName()%> <%=man.getLastName()%></label> <br>
    <a href="approveDishConf?id=<%= ((Dish) request.getAttribute("dishToApprove")).getDish_id()%>">Approve</a>
    <a href="rejectDish?id=<%= ((Dish) request.getAttribute("dishToApprove")).getDish_id()%>">Reject</a>
</div>
</body>
</html>