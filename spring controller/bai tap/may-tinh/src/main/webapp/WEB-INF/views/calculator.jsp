<%--
  Created by IntelliJ IDEA.
  User: ADTOBIAS
  Date: 08-Mar-22
  Time: 4:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="cal" method="get">
<h3>CALCULATOR</h3>
<table>
    <tr>
        <td colspan="2">
            <input type="text" placeholder="input first number"  name="first">
        </td>
        <td colspan="2">
            <input type="text" placeholder="input second number" name="second">
        </td>
    </tr>
    <tr>
        <input type="submit" value="addition" name="calculate">
    </tr>
    <tr>
        <input type="submit" value="subtraction" name="calculate">
    </tr>
    <tr>
        <input type="submit" value="multiplication" name="calculate">
    </tr>
    <tr>
        <input type="submit" value="division" name="calculate">
    </tr>
</table>
</form>
<h3>Result ${name}: ${result}</h3>
</body>
</html>
