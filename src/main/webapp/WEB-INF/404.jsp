<%--
  Created by IntelliJ IDEA.
  User: Jin
  Date: 10.07.2020
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Админ</title>
    <style>
        <%@include file='/style/input.css' %>
        <%@include file='/style/button.css'%>
        <%@include file="/style/mycont.css"%>
        <%@include file="/style/bootstrap.min.css"%>
        body{
            background: black;
        }
        p{
            font-size:24px;
            color: white;
        }
        a{
            text-decoration: none;

        }
        a:hover{
            color:mediumseagreen;
        }
    </style>

</head>
<body>
<div class="col">
    <div class="mycont">
            <img src="https://sun1.dataix-by-minsk.userapi.com/hdlGkkRg9wxogWr0a2QldZR_TFiqk-LZW-FROg/EjiM2NPVx-8.jpg" weight="442" height="462" alt="human">
        <p>Упс! Что-то пошло не так</p>
        <a href="<c:url value="/login"/>"><p>Логин</p></a>
    </div>
</div>
</body>
</html>
