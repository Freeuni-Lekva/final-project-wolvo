<%@ page import="Models.User" %>
<%@ page import="java.util.List" %><%--
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
<div class = "usersFound">
    <% List<User> usersByName = (List<User>) request.getAttribute("userList");
       int cnt = 0;
    for (User user : usersByName) {
        if (user.getUserStatus().getStatus().equals("Admin")) continue;
        cnt++;    %>
    <li><a href="userFound?id=<%=user.getId()%>"><%=user.getFirstName()%> <%=user.getLastName()%> <%=user.getEmail()%></a> </li> <br>
   <% }
   if (cnt == 0) { %>
    <label>There is no user with such name.</label>
  <% }
   %>
</div>
</body>
</html>
