<%--
  Created by IntelliJ IDEA.
  User: PLH
  Date: 6/21/2019
  Time: 10:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
<h1>Customers</h1>
<table border="1">
    <tr>
        <td>Name</td>
        <td>DayBirth</td>
        <td>Address</td>
        <td>Image</td>
    </tr>
    <c:forEach items='${requestScope["customers"]}' var="customer">
        <tr>
            <td>${customer.getName()}</td>
            <td>${customer.getDaybirth()}</td>
            <td>${customer.getAddress()}</td>
            <td>${customer.getImage()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
