<%--
  Created by IntelliJ IDEA.
  User: Jin
  Date: 25.06.2020
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Статистика</title>

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

<div class="col-xs-5 col-xs-offset-1">
    <div class="mycont">
        <div class="margin-top40">
            <table>
                <tr>
                    <td>
                        <a href="<c:url value= "/admin/testStatistic" />" style="text-decoration: none">Статистика по тесту</a>
                    </td>
                </tr>
                <tr>
                    <td>
                    <a href="<c:url value="/admin/questionStatistic"/>" style="text-decoration: none">Статистика по вопросам</a>
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="<c:url value="/admin/userTestStatistic"/>" style="text-decoration: none">Статистика по пользователям</a>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form action="/admin">
                            <input class="myButton"  type="submit" value="Назад">
                        </form>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>


</body>
</html>
