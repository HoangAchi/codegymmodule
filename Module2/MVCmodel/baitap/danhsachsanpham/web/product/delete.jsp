<%--
  Created by IntelliJ IDEA.
  User: PLH
  Date: 6/20/2019
  Time: 5:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Deleting customer</title>
</head>
<body>
    <h1>Delete product</h1>
    <p>
        <a href="/products">Back to product list</a>
    </p>
    <form method="post">
        <h3>Are you sure?</h3>
        <fieldset>
            <legend>Product information</legend>
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
                <tr>
                    <td><input type="submit" value="Delete product"></td>
                    <td><a href="/products">Back to product list</a></td>
                </tr>
            </table>
        </fieldset>
    </form>
</body>
</html>
