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
<link rel="stylesheet" href="../css/main.css" type="text/css" media="screen" charset="utf-8" />
<head>
    <title>主页</title>
</head>
<style>
    /* General Styles */
    center > h4 { color: #c5c5c5; margin-top: 50px; }
    body { margin: 0; font-family: Arial; background-color: #fff; }
    ul#three-clean-buttons-freebie { display: table; list-style: none; margin: 0 auto; padding: 0; }
    ul#three-clean-buttons-freebie > li {  margin-right: 20px; margin-bottom: 20px; padding: 10px 10px; }
    ul#three-clean-buttons-freebie > li:last-child { margin-right: 0; }
    ul#three-clean-buttons-freebie > li > span { margin-bottom: 10px; }
</style>
<body>
<br>
<br>
<br>
<br>
<br>
<br>
<ul id="three-clean-buttons-freebie">
    <li>
        <div class="three-clean-buttons">
            <div class="clean-button">
                <span class="text" onclick="staff()">员工信息管理系统</span>
            </div>
        </div>
    </li>
    <li>
        <div class="three-clean-buttons">
            <div class="clean-button">
                <span class="text" onclick="team()">小组信息管理系统</span>
            </div>
        </div>
    </li>
    <li>
        <div class="three-clean-buttons">
            <div class="clean-button">
                <span class="text" onclick="project()">项目信息管理系统</span>
            </div>
        </div>
    </li>
</ul>

</body>
<script>
    function staff() {
        window.location.href="../staffAdd/index"
    }
</script>
<script>
    function team() {
        window.location.href="../teamAdd/index"
    }
</script>
<script>
    function project() {
        window.location.href="../projectAdd/index"
    }
</script>

</html>
