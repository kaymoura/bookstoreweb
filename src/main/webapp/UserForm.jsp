<%-- 
    Document   : UserForm
    Created on : 2 de mai de 2022, 15:49:39
    Author     : Kaylane
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="./contents/headerTags.jsp" />
        <title>Aplicação Books Store</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="./contents/cabecalho.jsp" />
            
            <div align="left">
                <c:if test="${user != null}">
                    <form action="update" method="post">
                    </c:if>
                    <c:if test="${user == null}">
                        <form action="insert" method="post">
                        </c:if>
                        <div class="table-responsive">
                            <table class="table table-hover">
                                <caption>
                                    <h2>
                                        <c:if test="${user != null}">
                                            Editar Usuario
                                        </c:if>
                                        <c:if test="${user == null}">
                                            Adicionar novo Usuario
                                        </c:if>
                                    </h2>
                                </caption>
                                <c:if test="${user != null}">
                                    <input type="hidden" name="formId" value="<c:out 
                                               value='${user.id}' />" />
                                </c:if> 
                                <tr>
                                    <th>Email: </th>
                                    <td>
                                        <input type="text" name="formTitulo" size="45"
                                               value="<c:out value='${user.email}' />"
                                               />
                                    </td>
                                </tr>
                                <tr>
                                    <th>Senha: </th>
                                    <td>
                                        <input type="text" name="formAutor" size="45"
                                               value="<c:out value='${user.password}' />"
                                               />
                                    </td>
                                </tr>
                                <tr>
                                    <th>Nome Completo: </th>
                                    <td>
                                        <input type="text" name="formPreco" size="24"
                                               value="<c:out value='${user.fullname}' />"
                                               />
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2" align="center">
                                        <input type="submit" value="Enviar" />
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </form>
            </div>
            
            <jsp:include page="./contents/rodape.jsp" />
        </div>
    </body>
</html>
