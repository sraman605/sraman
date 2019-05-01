<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 4/14/2019
  Time: 11:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<%@include file="includes/header.jsp"%>
<form method="post" action="/contact/edit?id=${contact.getId()}">
    <h1>Edit Contact</h1>
    <br>Name:<input type="text" name="name" value="${contact.getName()}"><br>
    <br>Email:<input type="email" name="email" value="${contact.getEmail()}"><br>
    <br>Address:<input type="text" name="address" value="${contact.getAddress()}"><br>
    <br>phone no:<input type="number" name="phoneno" value="${contact.getPhoneno()}"><br>
    <br>Mobile no:<input type="number" name="mobno" value="${contact.getMobno()}"><br>


    <input type="submit" value="Save">
</form>

</body>
</html>
<%@include file="includes/footer.jsp"%>