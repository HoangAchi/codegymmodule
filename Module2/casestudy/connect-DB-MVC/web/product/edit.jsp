<%--
  Created by IntelliJ IDEA.
  User: Hai
  Date: 6/21/2019
  Time: 3:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Product</title>
</head>
<body>
<h1>Edit Product</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
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
                <td>Product Name</td>
                <td><input type="text" name="productName" id="productName"
                           value="${requestScope["products"].getProductName()}"></td>
            </tr>
            <tr>
                <td>Description</td>
                <td><input type="text" name="description" id="description"
                           value="${requestScope["products"].getDescription()}"></td>
            </tr>
            <tr>
                <td>Amount</td>
                <td><input type="text" name="amount" id="amount" value="${requestScope["products"].getAmount()}"></td>
            </tr>
            <tr>
                <td>Sell price</td>
                <td><input type="text" name="sellPrice" id="sellPrice"
                           value="${requestScope["products"].getSellPrice()}"></td>
            </tr>
            <tr>
                <td>Cost</td>
                <td><input type="text" name="cost" id="cost" value="${requestScope["products"].getCost()}"></td>
            </tr>
            <tr>
                <td>Type</td>
                <td><input type="text" name="idType" id="idType" value="${requestScope["products"].getIdType()}"></td>
            </tr>
            <tr>
                <td>Species</td>
                <td><input type="text" name="idSpecies" id="idSpecies"
                           value="${requestScope["products"].getIdSpecies()}"></td>
            </tr>
            <tr>
                <td>Producer</td>
                <c:forEach items="${requestScope['producers']}" var="producer">
                    <td>
                        <select>
                            <option value="${producer.getProducerName()}"></option>
                        </select>
                    </td>
                </c:forEach>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update product"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
