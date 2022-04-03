<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ADTOBIAS
  Date: 02-Mar-22
  Time: 3:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Setting</title>
</head>
<body>

<h1>Settings</h1>
<form:form method="POST" modelAttribute="mail" action="update">
    <table>
        <tr>
                <%--private String language;
                private Integer pageSize;
                private Boolean spamfilter;
                private String Signature;--%>
            <td>LANGUAGE</td>
            <td>
                <form:select path="language">
                    <form:option value="English" label="English"/>
                    <form:option value="Vietnamese" label="Vietnamese"/>
                    <form:option value="Japanese" label="Japanese"/>
                    <form:option value="Chinese" label="Chinese"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>PAGE SIZE</td>
            <td>
                <form:select path="pageSize">
                    <form:option value="5" label="5"/>
                    <form:option value="10" label="10"/>
                    <form:option value="15" label="15"/>
                    <form:option value="25" label="25"/>
                    <form:option value="50" label="50"/>
                    <form:option value="100" label="100"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td><form:label path="spamFilter">SPAMS FILTER</form:label></td>
            <td><form:checkbox path="spamFilter" value="Enable spams filter"/>Enable spams filter</td>
        </tr>
        <tr>
            <td><form:label path="signature">SIGNATURE</form:label></td>
            <td><form:textarea path="signature" rows="5" cols="30"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"></td>
        </tr>
    </table>
</form:form>

</body>
</html>
