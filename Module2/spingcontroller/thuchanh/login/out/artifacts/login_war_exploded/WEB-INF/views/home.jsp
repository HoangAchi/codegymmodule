<%--
  Created by IntelliJ IDEA.
  User: PLH
  Date: 7/15/2019
  Time: 9:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h3>Home</h3>
<form action="/login" method="post" >
    <fieldset>
        <legend>Login</legend>
        <table>
            <tr>
                <td><label path="account">Account:</label></td>
                <td><input path="account"/></td>
            </tr>
            <tr>
                <td><label path="password">Password:</label></td>
                <td><input path="password"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit"/>Login</td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
