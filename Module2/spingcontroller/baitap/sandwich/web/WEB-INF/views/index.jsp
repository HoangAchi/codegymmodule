<%--
  Created by IntelliJ IDEA.
  User: PLH
  Date: 7/16/2019
  Time: 4:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form"	uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>SandWich</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="save">
    <input type="checkbox" name="condiment" value="Lettuce">Lettuce
    <input type="checkbox" name="condiment" value="Tomato">Tomato
    <input type="checkbox" name="condiment" value="Mustard">Mustard
    <input type="checkbox" name="condiment" value="Sprouts">Sprouts
    <br><input type="submit" value="Save">
</form>
</body>
</html>
