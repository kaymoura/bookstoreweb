<%-- 
    Document   : loginPage
    Created on : 4 de mai de 2022, 08:14:11
    Author     : Kaylane
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="./contents/headerTags.jsp" />
        <title>Bookstore Website</title>
    </head>
    <body>
        <div class="container">
            <div class="jumbotron">
                <h1>BookStoreWeb</h1>
                <h3>Bem-Vindo</h3>
            </div>
            
            <div style="text-align: center">
                <h1>Admin Login</h1>
                <form action="login" method="post">
                    <label for="email">Email:</label>
                    <input name="email" size="30" />
                    <br><br>
                    <label for="password">Senha:</label>
                    <input type="password" name="password" size="30" />
                    <!-- Esse atributo MESSAGE será utilizado como retorno de 
                   mensagem ao usuário caso login inválido. -->
                    <br>${message}<br><br> 
                    <button type="submit">Login</button>
                </form><br>
            </div><jsp:include page="./contents/rodape.jsp" /></div>
    </body>
</html>

