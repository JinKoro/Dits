<%--
  Created by IntelliJ IDEA.
  User: Jin
  Date: 25.06.2020
  Time: 8:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Логин</title>
    <meta charset="UTF-8">
        <style>
            <%@include file='/style/input.css' %>
            <%@include file='/style/button.css'%>
            <%@include file="/style/mycont.css"%>
            <%@include file="/style/bootstrap.min.css"%>
        </style>
</head>
<body>
<div class="mycont">
    <div class="margin-top8">
        <c:url var="loginUrl" value="/login"/>
        <form action="${loginUrl}" method="post" class="form-signin">
            <c:if test="${param.error!=null}" >
                <div class="alert alert-danger">
                    <p>Неверный логин или пароль</p>
                </div>
            </c:if>
            <c:if test="${param.logout!=null}">
                <div class="alert alert-success">
                    <p>Вы успешно вышли из системы</p>
                </div>
            </c:if>
            <div>
                <input type="text" class="css-input" id="username" name="ssoId" placeholder="Логин" value="" required>
            </div>
            <div>
                <input type="password" class="css-input" id="password" name="password" placeholder="Пароль" value="" required>
            </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <button class="myButton" type="submit">Войти</button>

        </form>
    </div>
</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>

</body>
</html>
