<%@ page import="java.util.List" %>
<%@ page import="com.example.webcrud.data.Product" %><%--
  Created by IntelliJ IDEA.
  User: ninhm
  Date: 11/25/2022
  Time: 2:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
</head>
<body>
<div>
    <div>
        <form action="ServletCURD" method="post">
            <input type="hidden" name="action" value="add">
            Product Name: <input type="text" name="name"> <br>
            Price: <input type="text" name="price"> <br>
            Description: <textarea name="description" cols="30" rows="10" style="resize: none"></textarea> <br>
            <input type="submit" value="Add">
        </form>

    </div>
    <c:forEach items="${product}" var="p">
        <div style="width: 100px; height: 200px; background: aliceblue; float: left; margin: 5px">
            <p><c:out value="${p.getName()}"/></p>
            <p><c:out value="${p.getPrice()}"/></p>
            <p><c:out value="${p.getDescription()}"/></p>
            <form action="ServletCURD" method="post" onsubmit="return confirm('Delete?')">
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="productCode" value="${p.getProductCode()}">
                <input type="submit" value="Delete">
            </form>
            <button onclick="updateProduct('${p.getProductCode()}','${p.getName()}','${p.getPrice()}','${p.getDescription()}')">Update</button>
        </div>
    </c:forEach>
    <div id="update" style="clear: both"></div>

    <script src="main.js"></script>
</div>
</body>
</html>
