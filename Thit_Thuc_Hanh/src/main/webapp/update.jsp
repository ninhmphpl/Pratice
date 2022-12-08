<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ninhm
  Date: 12/8/2022
  Time: 11:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<form action="ServletManager?action=update&id=${employee.getId()}" method="post">
  <table class="table">
    <tr>
      <td>Name</td>
      <td><input type="text" minlength="1" name="name" value="${employee.getName()}"></td>
    </tr>
    <tr>
      <td>Email</td>
      <td><input type="email" minlength="1" name="email" value="${employee.getEmail()}"></td>
    </tr>
    <tr>
      <td>Address</td>
      <td><input type="text" minlength="1" name="address" value="${employee.getAddress()}"></td>
    </tr>
    <tr>
      <td>Name</td>
      <td><input type="tel" minlength="1" name="phoneNumber" value="${employee.getPhoneNumber()}"></td>
    </tr>
    <tr>
      <td>Salary</td>
      <td><input type="number" minlength="1" name="salary"  value="${employee.getSalary()}"></td>
    </tr>
    <tr>
      <td>Department</td>
      <td>
        <select name="department" id=""  value="${employee.getDepartment().getName()}">
          <c:forEach items="${department}" var="d">
            <option value="${d.getId()}">${d.getName()}</option>
          </c:forEach>
        </select>
      </td>

    </tr>
    <tr>
      <td></td>
      <td><input type="submit" value="Update"></td>
    </tr>
  </table>
</form>
</body>
</html>
