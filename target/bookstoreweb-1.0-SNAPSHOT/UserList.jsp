<%-- 
    Document   : UserList
    Created on : 2 de mai de 2022, 15:49:54
    Author     : Kaylane
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="./contents/headerTags.jsp" />
        <title>Aplicação BookStoreWeb</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="./contents/cabecalho.jsp" />
            <div class="table-responsive">
                <table class="table table-hover">
                    <caption><h2>Lista de Usuarios</h2></caption>
                    <tr>
                        <th>ID</th>
                        <th>Email</th>
                        <th>Senha</th>
                        <th>Nome Completo</th>
                        <th>Ações</th>
                    </tr>

                    <c:forEach var="user" items="${listaUsers}">
                        <tr>
                            <td><c:out value="${user.id}" /></td>
                            <td><c:out value="${user.email}" /></td>
                            <td><c:out value="${user.password}" /></td>
                            <td><c:out value="${user.fullname}" /></td>
                            <td>
                                <a href="<%=request.getContextPath()%>/bstore/edit?id=<c:out value='${user.id}' />"><span class="glyphicon glyphicon-pencil"></span></a>
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <a href="<%=request.getContextPath()%>/bstore/delete?id=<c:out value='${user.id}' />"><span class="glyphicon glyphicon-trash"></span></a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <jsp:include page="./contents/rodape.jsp" />
        </div>
    </body>
</html>
