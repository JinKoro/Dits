<%--
  Created by IntelliJ IDEA.
  User: Jin
  Date: 06.07.2020
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>User Test Statistic</title>
    <style>
        <%@include file='/style/input.css' %>
        <%@include file='/style/button.css'%>
        <%@include file="/style/mycont.css"%>
        <%@include file="/style/bootstrap.min.css"%>
        <%@include file="/style/table.css"%>
    </style>
</head>
<body>

<div class="mycont">
    <div class="margin-top10">
        <table  class="blueTable">
            <thead>
            <tr>
                <th>Имя пользователя</th>
                <th>Название Теста</th>
                <th>Пройдено всего раз</th>
                <th>Процент правильных ответов, %</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${statisticListUserTest}" var="statisticList">
                <tr>
                    <td> ${statisticList.getFIO()}</td>
                    <td> ${statisticList.getName()}</td>
                    <td> ${statisticList.getCountCompleted()}</td>
                    <td> ${statisticList.getPercent()}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <br>
        <form action="/admin">
            <input type="submit" class="myButton" value="На главную">
        </form>
    </div>
</div>


</body>
</html>
