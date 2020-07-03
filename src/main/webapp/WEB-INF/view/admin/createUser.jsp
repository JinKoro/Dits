<%--
  Created by IntelliJ IDEA.
  User: Jin
  Date: 25.06.2020
  Time: 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>CreateUser</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" >
</head>
<body>
<div class="CreateUser">

    <form:form method="post" action="/createUser" name="user"  modelAttribute="user">
        <table>
            <tr>
                <td>
                    <form:select path="nameRole">
                        <form:options items="${allRoles}"/>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>
                    <form:input path="lastName" placeholder="Фамилия" required="true"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:input path="firstName" placeholder="Имя" required="true"/>
                </td>
            </tr>
            <tr>
                <td>
                    <input placeholder="Отчество">
                </td>
            </tr>
            <tr>
                <td>
                    <form:input path="password" placeholder="Пароль" required="true"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:input path="login" placeholder="Логин" required="true"/>
                </td>
            </tr>
            <tr>
                <td>
                    <input placeholder="Почта">
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" placeholder="Сохранить пользователя"/>
                </td>
            </tr>
        </table>
    </form:form>

    <p id="success"><a style="color:green;font-size:120%;">${success}</a> </p>
</div>

<script>
    setTimeout(function () {
        document.getElementById("success").style.display='none';
    },4000)
</script>

<form action="/goHomeAdmin">
    <input type="submit" value="Back">
</form>

<a href="<c:url value="/logout"/>">Log off</a>

</body>
</html>
