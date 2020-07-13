<%--
  Created by IntelliJ IDEA.
  User: Jin
  Date: 25.06.2020
  Time: 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Создание пользователя</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <style>
        <%@include file='/style/input.css' %>
        <%@include file='/style/button.css'%>
        <%@include file="/style/mycont.css"%>
        <%@include file="/style/bootstrap.min.css"%>
        <%@include file="/style/table.css"%>
    </style>
</head>
<body>

<div class="row">
<div class="col-xs-5 col-xs-offset-1">
    <div class="mycont">
        <div class="margin-top20">
            <img src="https://sun1.dataix-by-minsk.userapi.com/7FZeCz388oMsJq8e42jjCwqgCrydNmynGJZtxw/mQx338ichdA.jpg"
                 alt="человечек">
        </div>
    </div>
</div>

<div class="col-xs-5  col-xs-push-1">
    <div class="mycont">
        <div class="margin-top10">
            <form:form method="post" action="/admin/createUser" name="user" modelAttribute="user">
                <table>
                    <tr>
                        <td>
                            <form:select path="nameRole" class="css-input">
                                <form:options items="${allRoles}"/>
                            </form:select>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:input path="lastName" class="css-input" placeholder="Фамилия" required="true"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:input path="firstName" class="css-input" placeholder="Имя" required="true"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input class="css-input" placeholder="Отчество">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:input path="password" class="css-input" placeholder="Пароль" required="true"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:input path="login" class="css-input" placeholder="Логин" required="true"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:input path="email" type="email" class="css-input" placeholder="address@gmail.com"
                                        required="true"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" class="myButton" placeholder="Сохранить пользователя"/>
                        </td>
                    </tr>
                </table>
            </form:form>
        </div>
    </div>
</div>
</div>

<div class="row">
<table class="blueTable">
    <thead>
    <tr>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>Роли</th>
        <th>Действие</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${userList}" var="user">
        <tr>
            <td>${user.getFirstName()}</td>
            <td>${user.getLastName()}</td>
            <td>${user.getNameRole()}</td>
            <td>
                <a href="/admin/edit/${user.id}">Изменить</a>
                <a href="/admin/delete/${user.id}">Удалить</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>

<div class="mycont">
    <p id="success"><a style="color:green;font-size:120%;">${success}</a></p>

    <form action="/admin">
        <input type="submit" class="myButton" value="Назад">
    </form>
</div>

<script>
    setTimeout(function () {
        document.getElementById("success").style.display = 'none';
    }, 6000)
</script>
</body>
</html>
