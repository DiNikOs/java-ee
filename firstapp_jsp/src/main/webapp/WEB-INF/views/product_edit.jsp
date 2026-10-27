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
    <c:url value="/catalog" var="productPostUrl"/>
    <form action="${productPostUrl}" method="post">
    <table border="1">
        <tr>
            <th>Номер</th>
            <th>Товар</th>
            <th>Описание</th>
            <th>Цена</th>
            <th></th>
        </tr>
        <tr>
            <td><input type="text" class="form-control" id="id" name="id" value="${product.id}" placeholder="Enter product id" readonly></td>
            <td><input type="text" class="form-control" id="name" name="name" value="${product.name}" placeholder="Enter product name"></td>
            <td><input type="text" class="form-control" id="description" name="description" value="${product.description}" placeholder="Enter product description"></td>
            <td><input type="text" class="form-control" id="price" name="price" value="${product.price}" placeholder="Enter product price"></td>
            <td><button type="submit" class="btn btn-primary">Submit</button></td>
        </tr>
    </table>
    </form>

</body>
</html>
