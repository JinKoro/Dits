<%--
  Created by IntelliJ IDEA.
  User: Jin
  Date: 05.07.2020
  Time: 23:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Test Statistic</title>
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
        <table class="blueTable" >
            <thead>
            <tr>
                <th>Название теста</th>
                <th>Пройдено всего</th>
                <th>Процент правильных ответов, %</th>
            </tr>
            </thead>
            <c:forEach items="${statisticListTest}" var="statisticList">
                <tr>
                    <td> ${statisticList.getNameQuestion()}</td>
                    <td> ${statisticList.getTotalCompleted()}</td>
                    <td> ${statisticList.getPercentCorrectAnswers()}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table
        <br>
        <form action="/admin">
            <input type="submit" class="myButton" value="На главную">
        </form>
    </div>
</div>

</body>
</html>
