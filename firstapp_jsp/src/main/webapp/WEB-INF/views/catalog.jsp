<%--
  Date: 04.06.2020
  Catalog
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Catalog</title>
    <%@ include file="/WEB-INF/views/head.jspf" %>
</head>
<body>
    <%@ include file="/WEB-INF/views/menu.jspf" %>
    <h1>Каталог</h1>
    <table border="1">
        <tr>
            <th>Номер</th>
            <th>Товар</th>
            <th>Описание</th>
            <th>Цена</th>
            <th></th>
        </tr>
        <c:forEach items="${requestScope.products}" var="prod">
            <tr>
                <c:url value="/product/edit" var="editUrl">
                    <c:param name="id" value="${prod.id}"/>
                </c:url>
                <c:url value="/product/see" var="seeUrl">
                    <c:param name="id" value="${prod.id}"/>
                </c:url>
                <c:url value="/product/del" var="delUrl">
                    <c:param name="id" value="${prod.id}"/>
                </c:url>
                <td>${prod.id}</td>
                <td>${prod.name}</td>
                <td>${prod.description}</td>
                <td>${prod.price}</td>
                <td><a href="${seeUrl}">See</a></td>
                <td><a href="${editUrl}">Edit</a></td>
                <td><a href="${delUrl}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>

    <c:url value="/product/add" var="productAddPostUrl"/>
    <form action="${productAddPostUrl}" method="post">
        <input type="text" class="form-control" id="id" name="id" value="${null}">
        <button type="submit" id="addProduct" class="btn btn-primary">Submit</button>
    </form>

</body>
</html>
