<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/19
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script type="text/javascript" src="../js/jquery.min.js"></script>
<head>
    <title>主页</title>
</head>
<body>
<input type="button" value="员工信息管理" onclick="staff()">
<input type="button" value="小组信息管理" onclick="team()">
<input type="button" value="项目信息管理" onclick="project()">
</body>
<script>
    function staff() {
        window.location.href="../staff/index"
    }
</script>
<script>
    function team() {
        window.location.href="../team/application"
    }
</script>
<script>
    function project() {
        window.location.href="../project/approval"
    }
</script>

</html>
