<%--
  Created by IntelliJ IDEA.
  User: Jin
  Date: 25.06.2020
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CreateTest</title>
        <style>
            <%@include file='/style/input.css' %>
            <%@include file='/style/button.css'%>
            <%@include file="/style/mycont.css"%>
            <%@include file="/style/bootstrap.min.css"%>
        </style>
</head>
<body>

<%--    <div class="margin-top8">
        <div class="mycont">
            <img src="/images/human.png">
        </div>
    </div>--%>
    <div class="col">
        <div class="margin-top20">
            <div class="mycont somefont">
<form action="saveNewQuestion">
    <p>
        <input type="text" class="css-input" required list="topics" placeholder="Название темы"
               id="topic" name="topic">
        <datalist id="topics" name="nameTopic">
            <c:forEach items="${topics}" var="topic">
                <option value="${topic}"/>
            </c:forEach>
        </datalist>
    </p>
    <p>
        <input type="text" class="css-input" required list="tests" placeholder="Название теста"
               id="test" name="test">
        <datalist id="tests">
            <c:forEach items="${tests}" var="test">
                <option value="${test}"/>
            </c:forEach>
        </datalist>
    </p>
    <p>
        <input type="text" class="css-input" required list="questions" placeholder="Название вопроса"
               id="question" name="question">
        <datalist id="questions">
            <c:forEach items="${questions}" var="question">
                <option value="${question}"/>
            </c:forEach>
        </datalist>
    </p>
    <input type="submit" class="myButton" value="Создать">

    <p id="success"><a style="color:green;font-size:120%;">${success}</a> </p>
</form>

<script>
    setTimeout(function () {
        document.getElementById("success").style.display='none';
    },4000)
</script>
            </div>
        </div>
    </div>

<%--<div class="row">
    <div class="col">
        <div class="mycont somefont">
            <a href="<c:url var="/goHomeAdmin"/>">Назад</a>
        </div>
    </div>
</div>

<a href="<c:url value="/logout"/>">Log off</a>--%>
</body>
</html>