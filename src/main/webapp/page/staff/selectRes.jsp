<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/24
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script type="text/javascript" src="../js/jquery.min.js"></script>
<head>
    <title>查找/修改员工信息</title>
</head>
<style>
    div{
        text-align: center;
        background-color: #fff;
        border-radius: 20px;
        width: 450px;
        height: 350px;
        position: absolute;
        left: 50%;
        top: 50%;
        transform: translate(-50%,-50%);
    }
</style>
<link type="text/css" rel="stylesheet" href="../css/leader.css"/>
<body>
<ul>
    <li><a class="active" href="../index/index">主页</a></li>
    <li><a href="../staffAdd/index">员工信息录入</a></li>
    <li><a href="../teamAdd/index">小组信息管理</a></li>
    <li><a href="../projectAdd/index">项目信息管理</a></li>
</ul>
<br>
<div>
<label>根据姓名查询</label>
<form action="selectByName" method="post">
    <input type="text" placeholder="请输入员工姓名或部分姓名" name="name" id="name">
    <input type="submit" value="查询">
</form>
<label>根据小组查询</label>
<br>
<form action="selectByTeam" method="post">
    <select name="ofTeam">
        <c:forEach var="list" items="${team}" varStatus="status">
            <option value=${list.number}>${list.name}</option>
        </c:forEach>
    </select>
    <input type="submit" value="查询">
</form>


    <table class="staff_inf">
        <tr id="t_head">
            <th>员工姓名</th>
            <th>员工工号</th>
            <th>员工电话</th>
            <th>任职情况</th>
            <th>操作</th>
        </tr>
        <c:forEach var="list" items="${data}" varStatus="status">
            <tr>
                <td>${list.name}</td>
                <td>${list.number}</td>
                <td>${list.phone}</td>
                <th>${list.tenure}</th>
                <th><input value="修改" type="button" onclick="update(${list.number})"></th>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
<script>
    function update(number) {
        window.location.href="getStaff?number="+number;
    }
</script>
</html>
