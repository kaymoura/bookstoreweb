<%-- 
    Document   : home
    Created on : 4 de mai de 2022, 08:49:41
    Author     : Kaylane
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="./contents/headerTags.jsp" />
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container" style="text-align: center">
            <h1>Bem-vindo ao painel de administração do site da livrarua </h1>
            <b>${user.fullname} (${user.email})</b>
            <br><br>
            <a href="/logout">Sair</a>
        </div>
    </body>
</html>
