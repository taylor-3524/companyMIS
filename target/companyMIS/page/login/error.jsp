<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/19
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<link href="../css/style.css" rel="stylesheet" type="text/css" media="all" />
<style>
    h1{

        text-align: center;
    }
</style>
<body>
<br>

<h1>请登录</h1>

<!-- main -->
<%--<div class="main-w3layouts wrapper">--%>
<div class="main-agileinfo">
    <div class="agileits-top">
        <form action="login" method="post">
            <input class="text" type="text" name="Username" placeholder="姓名" required="">
            <input class="text" type="password" name="password" placeholder="密码" required="">
            <input type="submit" value="登录">
        </form>

    </div>
</div>
<%--</div>--%>

</body>
<script>

        alert("用户名或密码错");

</script>
</html>
