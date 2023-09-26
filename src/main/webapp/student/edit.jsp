<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 9/16/2023
  Time: 8:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chỉnh sửa</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <form action="/student" method="post">
        <input type="hidden" value="edit" name="action">
        <input type="hidden" value="${student.id}" name="id">
        <div class="mb-3">
            <label for="name" class="form-label">Tên</label>
            <input type="text" value="${student.name}" class="form-control" id="name" name="name">
        </div>
        <div class="mb-3">
            <label for="score" class="form-label">Điểm</label>
            <input type="text" value="${student.score}"  class="form-control" id="score" name="score">
        </div>
        <button type="submit" class="btn btn-primary">Lưu</button>
    </form>
</div>
</body>
</html>
