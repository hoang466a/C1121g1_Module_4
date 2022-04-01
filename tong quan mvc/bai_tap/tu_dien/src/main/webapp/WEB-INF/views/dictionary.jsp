<%--
  Created by IntelliJ IDEA.
  User: ADTOBIAS
  Date: 01-Apr-22
  Time: 3:36 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Translate</title>
</head>
<body>
<form action="translate">
    <div>
        <h3>English</h3>
        <input type="text" name="english" placeholder="Input english word">
    </div>
    <input type="submit" value="Translate">
</form>
<input type="text" name="vietnamese" value="${vietnamese}">
</body>
</html>
