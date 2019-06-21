<%--
  Created by IntelliJ IDEA.
  User: PLH
  Date: 6/20/2019
  Time: 5:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View product</title>
</head>
<body>
<h1>Product details</h1>
<p>
    <a href="/products">Back to product list</a>
</p>
<table>
    <tr>
        <td>Name: </td>
        <td>${requestScope["product"].getName()}</td>
    </tr>
    <tr>
        <td>Count: </td>
        <td>${requestScope["product"].getCount()}</td>
    </tr>
    <tr>
        <td>Unit Price: </td>
        <td>${requestScope["product"].getUnitPrice()}</td>
    </tr>
</table>
</body>
</html>
