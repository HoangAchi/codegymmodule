<%--
  Created by IntelliJ IDEA.
  User: PLH
  Date: 7/16/2019
  Time: 5:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Caculator</title>
</head>
<body>
<h1>Caculator</h1>
<form action="caculator">
    <input type="number" name="nhap">
    <input type="number" name="nhap1">
    <input type="submit" name="tinhtoan" value="Addition">
    <input type="submit" name="tinhtoan" value="Subtraction">
    <input type="submit" name="tinhtoan" value="Multiplication">
    <input type="submit" name="tinhtoan" value="Division">
</form>
<h2>Result ${operator} : ${result}</h2>
</body>
</html>
