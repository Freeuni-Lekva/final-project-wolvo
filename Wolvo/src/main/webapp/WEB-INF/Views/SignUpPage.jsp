<%--
  Created by IntelliJ IDEA.
  User: tsotn
  Date: 8/3/2021
  Time: 1:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel = "stylesheet" href = "../../Resources/style.css" />
    <title>Sign Up on Wolvo</title>
</head>
<body>
<h1>Welcome to Wolvo</h1>
<form action="register" method="post">
    <label for="emailReg">Email: </label>
    <input type = "email" id = "emailReg" required="required" name = "emailNew" /> <br> <br>
    <label for = "passwordReg">Password: </label>
    <input type = "password" id = "passwordReg" required="required" name = "passwordNew" /><br> <br>
    <label for = "passwordRegConf">Confirm Password: </label>
    <input type = "password" id = "passwordRegConf" required="required" name = "passwordNewConf" /><br> <br>
    <label>Choose your user type: </label> <br>
    <input type = "radio" id = "customer" name = "userT" value="Customer" required>
    <label for = "customer">Customer</label> <br>
    <input type = "radio" id = "courier" name = "userT" value="Courier">
    <label for = "courier">Courier</label> <br>
    <input type = "radio" id = "manager" name = "userT" value="Manager">
    <label for = "manager">Restaurant Manager</label> <br> <br>
    <label for = "fnamereg">First Name: </label>
    <input type = "text" id = "fnamereg" required="required" name = "fnameNew"/> <br> <br>
    <label for = "lnamereg">Last Name: </label>
    <input type = "text" id = "lnamereg" required="required" name = "lnameNew"/> <br> <br>
    <label for = "district">Choose your district: </label>
    <select id="district" name="districts">
        <option value="Didube">Didube</option>
        <option value="Gldani">Gldani</option>
        <option value="Saburtalo">Saburtalo</option>
        <option value="Vake">Vake</option>
    </select> <br> <br>
    <label for = "address">Enter your living address: </label>
    <input type = "text" id = "address" required="required" name = "Address"/> <br> <br>
    <label>Please specify your privacy settings: </label> <br>
    <input type = "radio" id = "firstT" name = "privacyT" value="Private" required>
    <label for = "firstT">No one can see my order history</label> <br>
    <input type = "radio" id = "secondT" name = "privacyT" value="Friends">
    <label for = "secondT">Only my friends can see my order history</label> <br>
    <input type = "radio" id = "thirdT" name = "privacyT" value="Public">
    <label for = "thirdT">Anyone can see my order history</label> <br> <br>
    <Label for = "phonenumber">Enter your phone number: </Label>
    <input type = "number" id = "phonenumber" required="required" name = "phone"> <br> <br>
    <button>Sign Up</button>
</form>
</body>
</html>
