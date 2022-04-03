<%--
  Created by IntelliJ IDEA.
  User: ADTOBIAS
  Date: 08-Mar-22
  Time: 2:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="action" method="get">
<h3>Sandwich Condiments</h3>
    <div>
        <input type="checkbox" value="lettuce" name="condiment">
        <label>Lettuce</label>
    </div>
    <div>
        <input type="checkbox" value="tomato" name="condiment">
        <label>Tomato</label>
    </div>
    <div>
        <input type="checkbox" value="sprouts" name="condiment">
        <label>Sprouts</label>
    </div>
    <div><input type="submit" value="action"></div>
</form>
<table>
<tr>
    <th>
        <h3>List of condiment</h3>
    </th>
    <p>${message}</p>
</tr>
    <c:forEach var="one" items="${list}">
    <tr>
        <td>
        ${one}
        </td>
    </tr>
    </c:forEach>

</table>

</body>
</html>
