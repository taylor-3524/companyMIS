<%--
  Created by IntelliJ IDEA.
  User: 郑高勇
  Date: 2019/12/28
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script type="text/javascript" src="../js/jquery.min.js"></script>
<head>
    <title>查找/修改项目信息</title>
</head>
<style>
    div{
        text-align: center;
        background-color: #fff;
        border-radius: 20px;
        width: 900px;
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
    <li><a href="../projectAdd/index">项目信息管理</a></li>
    <li><a href="../staffAdd/index">员工信息录入</a></li>
    <li><a href="../teamAdd/index">小组信息管理</a></li>

</ul>
<br>
<div>


<label>根据项目名称查询</label>
<form action="selByName1" method="post">
    <input type="text" placeholder="请输入员工姓名或部分姓名" name="name" id="name">
    <input type="submit" value="查询">
</form>


    <table class="staff_inf">
        <tr id="t_head">
            <th>项目名称</th>
            <th>项目编号</th>
            <th>项目状态</th>
            <th>详细说明</th>
            <th>所属小组</th>
            <th>操作</th>
        </tr>
        <c:forEach var="list" items="${data}" varStatus="status1">
            <tr>
                <td>${list.pname}</td>
                <td>${list.pnumber}</td>
                <td>${list.status}</td>
                <td>${list.remark}</td>
                <td>${list.tname}</td>
                <td><input value="修改" type="button" onclick="update(${list.pnumber})"></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
<script>
    function update(number) {
        window.location.href="../projectUpd/getProjectNum?number="+number;
    }
</script>
</html>
