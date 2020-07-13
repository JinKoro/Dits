<%--
  Created by IntelliJ IDEA.
  User: Jin
  Date: 25.06.2020
  Time: 8:13
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Админ</title>
    <style>
        <%@include file='/style/input.css' %>
        <%@include file='/style/button.css'%>
        <%@include file="/style/mycont.css"%>
        <%@include file="/style/bootstrap.min.css"%>
    </style>

</head>
<body>
<div class="somefont">
<h1>Hello ${user}</h1>
</div>
<div class="col-xs-5 col-xs-offset-1">
    <div class="mycont">
        <div class="margin-top58">
            <img src="https://sun1.dataix-by-minsk.userapi.com/7FZeCz388oMsJq8e42jjCwqgCrydNmynGJZtxw/mQx338ichdA.jpg"  alt="">
        </div>
    </div>
</div>

<div class="col-xs-5 col-xs-offset-1">
    <div class="mycont">
        <div class="margin-top185">
            <table>
                <tr>
                    <td>
                        <a href="<c:url value= "/admin/createTest" />" style="text-decoration: none">Создать тест</a>
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="<c:url value="/admin/adminStatistic"/>" style="text-decoration: none">Статистика</a>
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="<c:url value="/admin/createUser"/>" style="text-decoration: none">Создать пользователя</a>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>

</body>
</html>
