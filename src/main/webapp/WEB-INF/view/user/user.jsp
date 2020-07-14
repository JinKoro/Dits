<%--
  Created by IntelliJ IDEA.
  User: Jin
  Date: 25.06.2020
  Time: 8:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>User</title>
    <style>
        <%@include file='/style/input.css' %>
        <%@include file='/style/button.css' %>
        <%@include file="/style/mycont.css" %>
        <%@include file="/style/bootstrap.min.css" %>
    </style>
</head>
<body>

<div class="somefont">
    <h1>Привет ${user}!</h1>
</div>
<div class="col-xs-5 col-xs-offset-1">
    <div class="mycont">
        <div class="margin-top58">
            <img src="https://sun1.dataix-by-minsk.userapi.com/7FZeCz388oMsJq8e42jjCwqgCrydNmynGJZtxw/mQx338ichdA.jpg"
                 alt="">
        </div>
    </div>
</div>

<div class="col-xs-5 col-xs-offset-1">
    <div class="mycont">
        <div class="margin-top185">
            <table>
                <tr>
                    <td>
                        <a href="<c:url value= "" />" style="text-decoration: none">Выбрать тест</a>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form action="/logout">
                            <input class="myButton"  type="submit" value="Выйти">
                        </form>
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