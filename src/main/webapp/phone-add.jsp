<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 4/17/2021
  Time: 7:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Phone add - Le_Huy_Hai</title>
</head>
<body>
<div class="container">
    <div class="row">
        <h2 class="col-8 offset-2 text-center font-weight-bold my-3">Create Student</h2>
        <a class="col-2 btn btn-primary align-self-center my-3" href="${pageContext.request.contextPath}/">Back</a>
        <form class="col-12" action="${pageContext.request.contextPath}/phone-add" method="post">
            <div class="form-group">
                <label for="name">Name :</label>
                <input id="name" class="form-control" type="text" name="name">
            </div>

            <div class="form-group">
                <label for="brand">Age :</label>
                <select name="brand" id="brand">
                    <c:forEach var="brand" items="${requestScope.brands}">
                        <option value="${brand}">${brand}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group">
                <label for="price">Class :</label>
                <input id="price" class="form-control" type="number" name="price">
            </div>

            <div class="form-group">
                <label for="description">Phone :</label>
                <input id="description" class="form-control" type="text" name="description">
            </div>

            <button type="submit" class="btn btn-primary">Create</button>
            <button type="reset" class="btn btn-white">Reset</button>
        </form>
    </div>
</div>
</body>
</html>
