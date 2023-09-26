<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 9/16/2023
  Time: 8:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Tạo mới</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <form action="/student?action=create" method="post">
        <div class="mb-3">
            <label for="name" class="form-label">Tên</label>
            <input type="text" value="${name}" class="form-control" id="name" name="name">
            <p class="text-danger">${messageError.name}</p>
        </div>
        <div class="mb-3">
            <label for="score" class="form-label">Điểm</label>
            <input type="text" value="${score}" class="form-control" id="score" name="score">
            <p class="text-danger">${messageError.score}</p>
        </div>
        <div class="mb-3">
            <label for="clazzId" class="form-label">Lớp</label>
            <select class="form-select" id="clazzId" name="clazzId">
                <option value="">Chọn lớp</option>
                <c:forEach var="clazz" items="${clazzList}">
                    <option value="${clazz.id}">${clazz.name}</option>
                </c:forEach>
            </select>
            <p class="text-danger">${messageError.clazzId}</p>
        </div>
        <button type="submit" class="btn btn-primary">Lưu</button>
    </form>
</div>
</body>
</html>
