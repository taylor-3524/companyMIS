<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/24
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改员工信息</title>
</head>
<link type="text/css" rel="stylesheet" href="../css/leader.css"/>
<style>
    div{
        text-align: center;
        background-color: #fff;
        border-radius: 20px;
        width: 600px;
        height: 350px;
        position: absolute;
        left: 50%;
        top: 50%;
        transform: translate(-50%,-50%);
    }
</style>
<body>
<ul>
    <li><a class="active" href="../index/index">主页</a></li>
    <li><a href="../staffAdd/index">员工信息录入</a></li>
    <li><a href="../teamAdd/index">小组信息管理</a></li>
    <li><a href="../projectAdd/index">项目信息管理</a></li>
</ul>
<br>
<div>
<table>
    <tr>
        <th>姓名</th>
        <th>工号</th>
        <th>手机</th>
        <th>任职状态</th>
    </tr>
    <c:forEach var="list" items="${data}" varStatus="status">
        <tr>
            <td>${list.name}</td>
            <td>${list.number}</td>
            <td>${list.phone}</td>
            <td>${list.tenure}</td>
        </tr>
    </c:forEach>

        <form action="update" method="post">
            <tr>
            <td><input name="name" type="text" placeholder="教师姓名" value="${data[0].name}"></td>
            <td><input name="number" type="text" readonly="true" value="${data[0].number}"></td>
            <td><input name="phone" type="text" placeholder="教师手机" value="${data[0].phone}"></td>
                <td>
                    <select name="tenure">
                        <option value="在职">在职</option>
                        <option value="休假">休假</option>
                        <option value="离职">离职</option>
                    </select>
                </td>
        </tr>
            <tr>
                <td><input type="submit" value="提交" onclick="submit_tip()"></td>
            </tr>
        </form>

</table>
</div>
</body>
<script>
    function submit_tip() {
        alert("修改完成!");

    }
</script>
</html>
