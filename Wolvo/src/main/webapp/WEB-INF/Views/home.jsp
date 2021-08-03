<%--
  Created by IntelliJ IDEA.
  User: tsotn
  Date: 8/3/2021
  Time: 3:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <h1>Welcome To Wolvo</h1>

    <p>Please Log in</p>

    <form action = "home" method = "post">
        <label for="emailField">Email: </label>
        <input type = "text" id = "emailField" name = "email" /> <br> <br>
        <label for = "passwordField">Password: </label>
        <input type = "password" id = "passwordField" name = "password" />
        <button>Login</button>
    </form>
</body>
</html>