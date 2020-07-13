<%--
  Created by IntelliJ IDEA.
  User: Jin
  Date: 25.06.2020
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Нет доступа</title>
    <style>
        <%@include file='/style/input.css' %>
        <%@include file='/style/button.css'%>
        <%@include file="/style/mycont.css"%>
        <%@include file="/style/bootstrap.min.css"%>
    </style>
</head>
<body>
<div class="col">
    <div class="mycont">
            <img src="https://sun1.dataix-by-minsk.userapi.com/7FZeCz388oMsJq8e42jjCwqgCrydNmynGJZtxw/mQx338ichdA.jpg"  alt="">
            <h1>В доступе отказано</h1>
            <a href="<c:url value="/logout"/>">Логин</a>
    </div>
</div>

</body>
</html>