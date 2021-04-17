<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 4/17/2021
  Time: 8:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Phone list - Le_Huy_Hai</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row">
        <h2>Phone list</h2>
        <a class="btn btn-primary align-self-center my-3" href="${pageContext.request.contextPath}/phone-add">Add</a>
        <table class="table">
            <thead class="thead-dark">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Brand</th>
                <th>Price</th>
                <th>Description</th>
                <th>Details</th>
                <th>Update</th>
                <th>Delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="p" items="${requestScope.phones}">
                <tr>
                    <td>${p.id}</td>
                    <td>${p.name}</td>
                    <td>${p.brand}</td>
                    <td>${p.price}</td>
                    <td>${p.description}</td>
                    <td>
                        <c:url var="url" value="phone">
                            <c:param name="id" value="${p.id}"/>
                        </c:url>
                        <a href="${url}" class="button btn btn-primary">Detail</a>
                    </td>
                    <td>
                        <c:url var="url" value="student-update">
                            <c:param name="id" value="${p.id}"/>
                        </c:url>
                        <a href="${url}" class="button btn btn-primary">Update</a>
                    </td>
                    <td>
                        <form class="m-0" action="${pageContext.request.contextPath}/phone-add" method="post">
                            <button name="id" value="${p.id}" class="button btn btn-primary" type="submit">Delete</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
