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
<link rel="stylesheet" href="../css/main.css" type="text/css" media="screen" charset="utf-8" />
<link type="text/css" rel="stylesheet" href="../css/leader.css"/>
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
<ul>
    <li><a class="active" href="../index/index">主页</a></li>
    <li><a href="../team/index">小组信息管理</a></li>
    <li><a href="../project/index">项目信息管理</a></li>
</ul>
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
                <span class="text" onclick="add()">新增人员信息</span>
            </div>
        </div>
    </li>
    <li>
        <div class="three-clean-buttons">
            <div class="clean-button">
                <span class="text" onclick="sel()">查找/修改人员信息</span>
            </div>
        </div>
    </li>
</ul>


</body>

<script>
    function add() {
        window.location.href="../staffAdd/index"
    }
</script>
<script>
    function sel() {
        window.location.href="../staffSU/index"
    }
</script>


</html>
