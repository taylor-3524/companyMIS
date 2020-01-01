<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/19
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
</head>
<body>
<input type="button" value="新增项目信息" onclick="add()">
<input type="button" value="查找项目信息" onclick="sel()">
</body>
<script>
    function add() {
        window.location.href="../projectAdd/index"
    }
</script>
<script>
    function sel() {
        window.location.href="../project/index"
    }
</script>


</html>
