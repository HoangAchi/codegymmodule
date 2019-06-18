<%--
  Created by IntelliJ IDEA.
  User: PLH
  Date: 6/18/2019
  Time: 2:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Cải thiện hiệu quả với services</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
  </head>
  <body>
  <div id="content">
    <h1>Product Discount Calculator</h1>
    <form method="post" action="/display_discount">
      <div id="data">
        <label>Product Description:</label>
        <input type="text" name="description"><br>
        <label>List Price:</label>
        <input type="text" name="price"><br>
        <label>Discount Percent:</label>
        <input type="text" name="percent">(%)<br>
      </div>
      <div id="buttons">
        <label>&nbsp;</label>
        <input type="submit" value="Calculate Discount">
      </div>
    </form>
  </div>
  </body>
</html>
