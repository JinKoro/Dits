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
    <title>Question Statistic</title>
</head>
<body>
<table border="1">
    <tr>
        <th>Формулировка вопроса</th>
        <th>Пройдено всего</th>
        <th>Процента правильно пройденыйх вопросов</th>
    </tr>

    <c:forEach items="${statisticList}" var="item">
        <tr>
            <td> ${item.name}</td>
            <td> ${item.countCompleted}</td>
            <td> ${item.percent}</td>
        </tr>
    </c:forEach>
</table>
<br>
<form action="/goHomeAdmin">
    <input type="submit" value="Home page">
</form>
</body>
</html>
