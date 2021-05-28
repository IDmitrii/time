<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>



<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Новости</title>
   
</head>
<body>
<div>
<c:set var="contextPath" value="<%=request.getContextPath()%>"></c:set>
    <h2>Новости <br> Только для залогинившихся пользователей.</h2>
    <a href="/">Главная</a>
     <b>contextPath: ${contextPath}   </b>
     <c:out value="${16+64*2}" />
</div>
</body>
</html>