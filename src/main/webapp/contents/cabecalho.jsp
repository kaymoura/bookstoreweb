<%-- 
    Document   : cabecalho
    Created on : 27 de abr de 2022, 10:15:45
    Author     : Kaylane
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Inicio cabecalho-->
<div class="jumbotron">
    <h1>BookStoreWeb</h1>
    <h3>Olá, <c:out value="${user.fullname}" /></h3>
</div>

<p>
    <a href="<%=request.getContextPath()%>/bstore/new" class="btn btn-primary">
        <span class="glyphicon glyphicon-plus-sign"></span> Adicionar novo Livro</a>

    <a href="<%=request.getContextPath()%>/bstore/list" class="btn btn-default">
        <span class="glyphicon glyphicon-menu-hamburger"></span> Lista todos Livros</a>
        
    <a href="<%=request.getContextPath()%>/logout" class="btn btn-danger">
        <span class="glyphicon glyphicon-remove-sign"></span> Sair</a>      
        
<!--   <a href="<%=request.getContextPath()%>/bsuser/new" class="btn btn-primary">
        <span class="glyphicon glyphicon-user"></span>Adicionar novo Usuario</a>

        <a href="<%=request.getContextPath()%>/bsuser/list" class="btn btn-default">
        <span class="glyphicon glyphicon-list-alt"></span>
        Lista todos Usuarios</a>-->
</p>

<!-- Fim cabecalho-->
