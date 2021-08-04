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

    <form action = "login" method = "post">
        <label for="emailField">Email: </label>
        <input type = "email" id = "emailField" required="required" name = "email" /> <br> <br>
        <label for = "passwordField">Password: </label>
        <input type = "password" id = "passwordField" required="required" name = "password" />
        <button>Login</button>
    </form>

    <form action="register" method="get">
        <input type="submit" value="Sign Up" />
    </form>

</body>
</html>