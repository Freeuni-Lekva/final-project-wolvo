<%@ page import="Models.Courier" %><%--
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
<div class = "divCourierApprove">
<label>First Name: <%= ((Courier) request.getAttribute("courierToApprove")).getFirstName()%></label> <br>
<label>Last Name: <%= ((Courier) request.getAttribute("courierToApprove")).getLastName()%></label> <br>
<label>Email: <%= ((Courier) request.getAttribute("courierToApprove")).getEmail()%></label> <br>
<label>Phone Number: <%= ((Courier) request.getAttribute("courierToApprove")).getPhoneNumber()%> </label> <br>
<label>Working district: <%= ((Courier) request.getAttribute("courierToApprove")).getDistrict()%></label> <br>
<a href="approveCourierConf?id=<%= ((Courier) request.getAttribute("courierToApprove")).getId()%>">Approve</a>
<a href="rejectCourier?id=<%= ((Courier) request.getAttribute("courierToApprove")).getId()%>">Reject</a>

</div>
<body>
</html>
