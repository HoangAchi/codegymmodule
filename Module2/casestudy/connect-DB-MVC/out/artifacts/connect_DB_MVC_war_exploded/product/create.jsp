<%--
  Created by IntelliJ IDEA.
  User: Hai
  Date: 6/21/2019
  Time: 10:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new product</title>
</head>
<body>
<h1>Create new product</h1>
<p>
    <c:if test="${requestScope['message'] != null}">
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/products">Back to product list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Product Name </td>
                <td><input type="text" name="productName" id="productName"></td>
            </tr>
            <tr>
                <td>Description </td>
                <td><input type="text" name="description" id="description"></td>
            </tr>
            <tr>
                <td>Amount </td>
                <td><input type="text" name="amount" id="amount"></td>
            </tr>
            <tr>
                <td>Sell price </td>
                <td><input type="text" name="sellPrice" id="sellPrice"></td>
            </tr>
            <tr>
                <td>Cost </td>
                <td><input type="text" name="cost" id="cost"></td>
            </tr>
            <tr>
                <td>Type </td>
                <td>
                    <select name="idType" id="idType">
                        <option value="4">male</option>
                        <option value="5">female</option>
                        <option value="6">kid</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Species </td>
                <td>
                    <select name="idSpecies" id="idSpecies">
                        <option value="5">shirt</option>
                        <option value="6">dress</option>
                        <option value="7">suit</option>
                        <option value="8">pants</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Producer </td>
                <td>
                    <select name="idProducer" id="idProducer">
                        <option value="4">H&M</option>
                        <option value="5">Blue Exchange</option>
                        <option value="6">Gucci</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Create product"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
