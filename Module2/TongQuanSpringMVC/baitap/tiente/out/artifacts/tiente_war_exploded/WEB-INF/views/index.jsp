<%--
  Created by IntelliJ IDEA.
  User: PLH
  Date: 7/11/2019
  Time: 8:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form method="post" action="/current">
    <table>
      <tr>
        <td>USD</td>
        <td><input type="number" name="usd"></td>
      </tr>
      <tr>
        ${result}
      <tr>
        <td><input type="submit" value="Ok"></td>
      </tr>
    </table>
  </form>
  </body>
</html>
