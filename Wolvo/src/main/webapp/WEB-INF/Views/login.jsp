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
    <link rel = "stylesheet" href = "../../Resources/style.css" />
    <title>Welcome</title>
</head>
<body>
<div class = "introduction">
    <h1>Welcome To Wolvo</h1>

    <p>Please Log in</p>

    <form action = "login" method = "post">
        <label for="emailField">Email:      </label>
        <input type = "email" id = "emailField" required="required" name = "email" /> <br> <br>
        <label for = "passwordField">Password: </label>
        <input type = "password" id = "passwordField" required="required" name = "password" /> <br> <br> <br>
        <button id = "loginBut">Login</button>
    </form>

    <div class = "buttonHolder">
    <form action="register" method="get">
        <input type="submit" value="Sign Up as a Customer" id = "signUpCust" name = "custReg"/> <br> <br>
        <input type="submit" value="Sign Up as a Manager" id = "signUpMan" name = "manReg"> <br> <br>
        <input type="submit" value="Sign Up as a Courier" id = "signUpCour" name = "courReg"> <br> <br>
    </form>
    </div>
</div>
</body>
</html>