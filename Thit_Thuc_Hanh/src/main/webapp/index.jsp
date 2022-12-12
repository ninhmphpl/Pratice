<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<body>
<div>
<h5>Add</h5>
    <form action="ServletManager?action=add" method="post">
        <table class="table">
            <tr>
                <td>Name</td>
                <td><input minlength="1" type="text" name="name"></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input minlength="1" type="email" name="email"></td>
            </tr>
            <tr>
                <td>Address</td>
                <td><input minlength="1" type="text" name="address"></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input minlength="1" type="tel" name="phoneNumber"></td>
            </tr>
            <tr>
                <td>Salary</td>
                <td><input minlength="1" type="number" name="salary"></td>
            </tr>
            <tr>
                <td>Department</td>
                <td>
                    <select name="department" id="">
                        <c:forEach items="${department}" var="d">
                            <option value="${d.getId()}">${d.getName()}</option>
                        </c:forEach>
                    </select>
                </td>

            </tr>
            <tr>
                <td></td>
                <td><input class="btn btn-primary" type="submit" value="Add"></td>
            </tr>
        </table>
    </form>


</div>

<div>
    <table>
        <tr>
            <td>Search</td>
            <td>
                <form action="ServletManager?action=search" method="post">
                    <input type="text" name="string">
                    <input class="btn btn-primary" type="submit" value="Search">
                </form>
            </td>
        </tr>
    </table>
</div>

<table class="table">
    <tr>
        <td>Name</td>
        <td>Email</td>
        <td>Address</td>
        <td>Phone Number</td>
        <td>Salary</td>
        <td>Department</td>
        <td>UpDate</td>
        <td>Delete</td>
    </tr>
    <c:forEach items="${employee}" var="e">
        <tr>
            <td>${e.getName()}</td>
            <td>${e.getEmail()}</td>
            <td>${e.getAddress()}</td>
            <td>${e.getPhoneNumber()}</td>
            <td>${e.getSalary()}</td>
            <td>${e.getDepartment().getName()}</td>
            <td><form action="ServletManager?action=updatePage&id=${e.getId()}" method="post"><input class="btn btn-primary" type="submit" value="update"></form></td>
            <td><form action="ServletManager?action=delete&id=${e.getId()}" method="post"><input class="btn btn-primary" type="submit" value="Delete"></form></td>
        </tr>
    </c:forEach>
</table>


</body>
</html>