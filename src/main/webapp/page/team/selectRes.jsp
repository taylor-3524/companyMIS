<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/26
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script type="text/javascript" src="../js/jquery.min.js"></script>
<head>
    <title>查找/修改小组信息</title>
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
    <li><a href="../teamAdd/index">小组信息查询/修改</a></li>
    <li><a href="../staffAdd/index">员工信息管理</a></li>
    <li><a href="../projectAdd/index">项目信息管理</a></li>
</ul>
<br>
<div>

<form action="selectByName" method="post">
    <label>根据姓名查询</label>
    <input type="text" placeholder="请输入小组姓名或部分姓名" name="name" id="name">
    <input type="submit" value="查询">
</form>

<form action="selectByTeam" method="post">
    <label>根据项目查询</label>
    <select name="ofTeam">
        <option value="0">闲置小组</option>
        <c:forEach var="list" items="${team}" varStatus="status">
            <option value=${list.number}>${list.name}</option>
        </c:forEach>
    </select>
    <input type="submit" value="查询">
</form>


    <table class="staff_inf">
        <tr id="t_head">
            <th>小组名</th>
            <th>小组号</th>
            <th>所属项目</th>
            <th>操作</th>
        </tr>
        <c:forEach var="list" items="${data}" varStatus="status">
            <tr>
                <td>${list.name}</td>
                <td>${list.number}</td>
                <td>${list.ofporject}</td>
                <th><input value="修改" type="button" onclick="update(${list.number})"></th>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
<script>
    function update(number) {
        window.location.href="getTeam?number="+number;
    }
</script>
</html>