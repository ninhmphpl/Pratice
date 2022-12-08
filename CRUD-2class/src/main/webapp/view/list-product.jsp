<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ninhm
  Date: 11/29/2022
  Time: 8:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<form action="products?action=add" method="post">
    <table class="table table-striped">
        <tr>
            <td>Name</td>
            <td>
                <input type="text" name="name">
            </td>
        </tr>
        <tr>
            <td>Price</td>
            <td>
                <input type="number" name="price">
            </td>
        </tr>
        <tr>
            <td>Description</td>
            <td>
                <input type="text" name="description">
            </td>
        </tr>
        <tr id="select">
            <td>Category</td>
            <td>
                <select name="categoryName">
                    <c:forEach items="${listCategory}" var="c">
                        <option value="${c.getName()}">${c.getName()}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
    </table>
    <input type="submit" value="Add">
</form>


<table class="table table-striped">
    <tr>
        <td>Name</td>
        <td>Price</td>
        <td>Description</td>
        <td>Category</td>
    </tr>
    <c:forEach items="${list}" var="l">
        <tr>
            <td>${l.getName()}</td>
            <td>${l.getPrice()}</td>
            <td>${l.getDescription()}</td>
            <td>${l.getCategory().getName()}</td>
            <td>
                <form action="products?action=delete&id=<c:out value="${l.getId()}"/>" method="post">
                    <input type="submit" value="Delete">
                </form>
            </td>
            <td>
<%--                <!-- Button trigger modal -->--%>
<%--                <button type="button" class="btn btn-primary" data-bs-toggle="modal"--%>
<%--                        data-bs-target="#exampleModal-${l.getId()}">--%>
<%--                    Update--%>
<%--                </button>--%>

<%--                <!-- Modal -->--%>
<%--                <div class="modal fade" id="exampleModal-${l.getId()}" tabindex="-1" aria-labelledby="exampleModalLabel"--%>
<%--                     aria-hidden="true">--%>
<%--                    <div class="modal-dialog">--%>
<%--                        <div class="modal-content">--%>
<%--                            <div class="modal-header">--%>
<%--                                <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>--%>
<%--                                <button type="button" class="btn-close" data-bs-dismiss="modal"--%>
<%--                                        aria-label="Close"></button>--%>
<%--                            </div>--%>
<%--                            <div class="modal-body">--%>
<%--                                <form action="products?action=add" method="post">--%>
<%--                                    <table class="table table-striped">--%>
<%--                                        <tr>--%>
<%--                                            <td>Name</td>--%>
<%--                                            <td>--%>
<%--                                                <input type="text" name="name" value="${l.getName()}">--%>
<%--                                            </td>--%>
<%--                                        </tr>--%>
<%--                                        <tr>--%>
<%--                                            <td>Price</td>--%>
<%--                                            <td>--%>
<%--                                                <input type="number" name="price" value="${l.getPrice()}">--%>
<%--                                            </td>--%>
<%--                                        </tr>--%>
<%--                                        <tr>--%>
<%--                                            <td>Description</td>--%>
<%--                                            <td>--%>
<%--                                                <input type="text" name="description" value="${l.getDescription()}">--%>
<%--                                            </td>--%>
<%--                                        </tr>--%>
<%--                                        <tr>--%>
<%--                                            <td>Category</td>--%>
<%--                                            <td>--%>
<%--                                                <select name="categoryName" value="${l.getCategory().getName()}">--%>
<%--                                                    <c:forEach items="${listCategory}" var="c">--%>
<%--                                                        <option value="${c.getName()}">${c.getName()}</option>--%>
<%--                                                    </c:forEach>--%>
<%--                                                </select>--%>
<%--                                            </td>--%>
<%--                                        </tr>--%>
<%--                                    </table>--%>
<%--                                    <button type="button" class="btn btn-primary">Save changes</button>--%>
<%--                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>--%>
<%--                                </form>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
            </td>
        </tr>
    </c:forEach>
</table>
<div>
    <!-- Button trigger modal -->
    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
        Launch static backdrop modal
    </button>

    <!-- Modal -->
    <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="staticBackdropLabel">Modal title</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    ...
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Understood</button>
                </div>
            </div>
        </div>
    </div></div>
</body>
</html>
