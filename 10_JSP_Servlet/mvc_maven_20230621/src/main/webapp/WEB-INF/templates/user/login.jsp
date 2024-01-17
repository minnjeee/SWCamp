<%--
  Created by IntelliJ IDEA.
  User: user02
  Date: 2023-06-22
  Time: 오후 3:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/webjars/bootstrap/5.3.0/dist/css/bootstrap.min.css">
    <script src="<%=request.getContextPath()%>/webjars/bootstrap/5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <h1 class="my-4">로그인 페이지</h1>
    <form action="./login.do" method="post" class="m-2">
        <div class="form-floating mb-3">
            <input type="text" name="uId" class="form-control" placeholder="??"> <!--form-control : input을 예쁘게 만들어주는 것-->
            <label>아이디</label>
        </div>
        <div class="form-floating mb-3">
            <input type="text" name="password" class="form-control" placeholder="??">
            <label>비밀번호</label>
        </div>
        <div class="text-end">
            <a href="./signup.do" class="btn btn-outline-success">회원가입</a>
            <button class="btn btn-outline-primary">로그인</button>
        </div>
    </form>
</body>
</html>
