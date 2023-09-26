<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 9/26/2023
  Time: 8:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Đăng nhập</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h2 class="text-danger">${param.message}</h2>
    <form action="login" method="post">
        <div class="mb-3">
            <label for="username" class="form-label">Tên tài khoản</label>
            <input type="text" class="form-control" id="username" name="username">
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Mật khẩu</label>
            <input type="password" class="form-control" id="password" name="password">
        </div>
        <div class="form-check">
            <input class="form-check-input" type="checkbox" value="on" id="remember-me" name="remember-me" checked>
            <label class="form-check-label" for="remember-me">
                Nhớ
            </label>
        </div>
        <button type="submit" class="btn btn-primary">Đăng nhập</button>
    </form>
</div>
</body>
</html>
