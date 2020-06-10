<%--
  Date: 04.06.2020
  Product
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Product</title>
    <%@ include file="/WEB-INF/views/head.jspf" %>
</head>
<body>
    <%@ include file="/WEB-INF/views/menu.jspf" %>
    <h1>Товар</h1>
    <table border="1">
        <tr>
            <th>Номер</th>
            <th>Товар</th>
            <th>Описание</th>
            <th>Цена</th>
            <th></th>
        </tr>
            <tr>
                <c:url value="/product/savecart" var="save_cartUrl">
                    <c:param name="id" value="${product.id}"/>
                    <c:param name="prod" value="${product}"/>
                </c:url>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.description}</td>
                <td>${product.price}</td>
                <td><a href="${save_cartUrl}">Сохранить в конзину</a></td>

            </tr>

    </table>
</body>
</html>
