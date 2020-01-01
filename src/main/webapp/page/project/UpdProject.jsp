<%--
  Created by IntelliJ IDEA.
  User: 郑高勇
  Date: 2019/12/28
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改项目信息</title>
</head>
<link type="text/css" rel="stylesheet" href="../css/leader.css"/>
<body>
<ul>
    <li><a class="active" href="../index/index">主页</a></li>
    <li><a href="../projectAdd/index">项目信息管理</a></li>
    <li><a href="../staffAdd/index">员工信息录入</a></li>
    <li><a href="../teamAdd/index">小组信息管理</a></li>

</ul>
<br>
<table>
    <tr>
        <th>项目名称</th>
        <th>项目编号</th>
        <th>项目说明</th>
        <th>项目状态</th>
    </tr>
    <c:forEach var="list" items="${data}" varStatus="status">
        <tr>
            <td>${list.name}</td>
            <td>${list.number}</td>
            <td>${list.status}</td>
            <td>${list.remark}</td>
        </tr>
    </c:forEach>

    <form action="updateProject" method="post">
        <tr>
            <td><input name="name" type="text" placeholder="项目名称" value="${data[0].name}"></td>
            <td><input name="number" type="text" readonly="true" value="${data[0].number}"></td>
            <td><input name="remark" type="text" placeholder="项目说明" value="${data[0].remark}"></td>
            <td>
                <select name="status">
                    <option value="待开发">待开发</option>
                    <option value="正在开发">正在开发</option>
                    <option value="开发暂停">开发暂停</option>
                    <option value="开发完成">开发完成</option>
                </select>
            </td>

        </tr>
        <tr>
            <td><input type="submit" value="提交" onclick="submit_tip()"></td>
        </tr>
    </form>

</table>
</body>
<script>
    function submit_tip() {
        alert("修改完成!");

    }
</script>
</html>
