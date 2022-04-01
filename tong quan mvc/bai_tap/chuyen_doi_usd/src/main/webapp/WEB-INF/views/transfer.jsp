<%--
  Created by IntelliJ IDEA.
  User: ADTOBIAS
  Date: 01-Apr-22
  Time: 3:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Convert USD to VND</title>
</head>
<body>
<form action="convert">
    <div>
        <h3>USD</h3>
        <input type="text" name="usd" placeholder="input usd">
    </div>
    <div>
        <h3>SCALE</h3>
        <input type="text" name="scale" value="23000" placeholder="input scale">
    </div>
    <input type="submit" value="Transfer">
</form>
<h3>VND</h3>
<input type="text" name="vnd" value="${vnd}">
</body>
</html>
