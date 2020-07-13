<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit</title>
    <style>
        <%@include file='/style/input.css' %>
        <%@include file='/style/button.css'%>
        <%@include file="/style/mycont.css"%>
        <%@include file="/style/bootstrap.min.css"%>
    </style>
</head>
<body>

<div class="col-xs-5 col-xs-offset-1">
    <div class="mycont">
        <div class="margin-top20">
            <img src="https://sun1.dataix-by-minsk.userapi.com/7FZeCz388oMsJq8e42jjCwqgCrydNmynGJZtxw/mQx338ichdA.jpg"
                 alt="">
        </div>
    </div>
</div>


<div class="col-xs-5 col-xs-push-1">
    <div class="mycont">
        <div class="margin-top20">
        <c:url value="/admin/edit" var="var"/>
        <form:form action="${var}" method="POST" modelAttribute="user">
            <table>
                <input class="css-input" type="hidden" name="id" value="${user.id}">
                <tr>
                    <td>
                        <label for="firstName"></label>
                        <input class="css-input" type="text" name="firstName" placeholder="Имя" id="firstName"
                               value="${user.firstName}">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="lastName"></label>
                        <input class="css-input" type="text" name="lastName" id="lastName" placeholder="Фамилия"
                               value="${user.lastName}">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="login"></label>
                        <input class="css-input" type="text" name="login" placeholder="Логин" id="login">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="password"></label>
                        <input class="css-input" type="text" name="password" placeholder="Пароль" id="password">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="nameRole"></label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:select path="nameRole" class="css-input">
                            <form:options class="css-input" items="${allRoles}"/>
                        </form:select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" class="myButton" value="Изменить">
                    </td>
                </tr>
            </table>
        </form:form>
    </div>
</div>
</div>
</body>
</html>