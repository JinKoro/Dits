<%--
  Created by IntelliJ IDEA.
  User: Jin
  Date: 25.06.2020
  Time: 8:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User</title>
    <link rel="stylesheet" type="text/css" href="/style/mycont.css">
    <link rel="stylesheet" type="text/css" href="/style/input.css">
    <link rel="stylesheet" type="text/css" href="/style/button.css">
</head>
<body>
    <div class="somefont">
        <h1>Hello ${user}</h1>
        <a href="<c:url value="/logout"/>">Log off</a>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>