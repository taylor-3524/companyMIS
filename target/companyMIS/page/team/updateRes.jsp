<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/26
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改小组信息</title>
</head>
<link type="text/css" rel="stylesheet" href="../css/leader.css"/>
<body>
<ul>
    <li><a class="active" href="../index/index">主页</a></li>
    <li><a href="../teamAdd/index">小组信息查询/修改</a></li>
    <li><a href="../staffAdd/index">员工信息管理</a></li>
    <li><a href="../project/index">项目信息管理</a></li>
</ul>
<br>
<table>
    <tr>
        <th>小组名</th>
        <th>小组号</th>
        <th>所属项目</th>
    </tr>
    <c:forEach var="list" items="${data}" varStatus="status">
        <tr>
            <td>${list.name}</td>
            <td>${list.number}</td>
            <td>${list.ofporject}</td>
        </tr>
    </c:forEach>

    <form action="update" method="post">
        <tr>
            <td><input name="name" type="text" placeholder="小组名" value="${data[0].name}"></td>
            <td><input name="number" type="text" readonly="true" value="${data[0].number}"></td>
            <td><select name="ofporject">
                <option value="0">暂无项目</option>
                <c:forEach var="list1" items="${data1}" varStatus="status">
                    <option value=${list1.pnumber}>${list1.ofporject}.${list1.pname}</option>
                </c:forEach>
            </select></td>
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

