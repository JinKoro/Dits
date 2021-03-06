<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Jin
  Date: 29.06.2020
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Статистика по вопросам</title>
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
                <th>Формулировка вопроса</th>
                <th>Пройдено всего</th>
                <th>Процент правильных вопросов, %</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${statisticListQuestion}" var="statisticList">
                <tr>
                    <td> ${statisticList.getNameQuestion()}</td>
                    <td> ${statisticList.getTotalCompleted()}</td>
                    <td> ${statisticList.getPercentCorrectAnswers()}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <br>
        <form action="/admin">
            <input type="submit" class="myButton" value="На главную">
        </form>
</body>
</html>
