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
<input type="button" value="新增人员信息" onclick="add()">
<input type="button" value="查找人员信息" onclick="sel()">
<input type="button" value="修改人员信息" onclick="upd()">
</body>
<script>
    function add() {
        window.location.href="../staff/add"
    }
</script>
<script>
    function sel() {
        window.location.href="../staff/sel"
    }
</script>
<script>
    function upd() {
        window.location.href="../staff/upd"
    }
</script>

</html>
