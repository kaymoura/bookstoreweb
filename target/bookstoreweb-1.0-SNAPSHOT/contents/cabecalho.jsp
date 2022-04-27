<%-- 
    Document   : cabecalho
    Created on : 27 de abr de 2022, 10:15:45
    Author     : Kaylane
--%>

<!-- Inicio cabecalho-->
<div class="jumbotron"><h1>BookStoreWeb</h1></div>



<p>
    <a href="<%=request.getContextPath()%>/new" class="btn btn-primary">
        <span class="glyphicon glyphicon-plus"></span>Adicionar novo Livro</a>

        <a href="<%=request.getContextPath()%>/list" class="btn btn-default">
        <span class="glyphicon glyphicon-th-list"></span>
        Lista todos Livros</a>
</p>

<!-- Fim cabecalho-->
