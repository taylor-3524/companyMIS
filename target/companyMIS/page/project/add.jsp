<%--
  Created by IntelliJ IDEA.
  User: 郑高勇
  Date: 2019/12/25
  Time: 22:18
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script type="text/javascript" src="../js/jquery.min.js"></script>
<link type="text/css" rel="stylesheet" href="../css/project/add.css"/>
<script type="text/javascript" src="../js/jquery.ffform.js"></script>
<script type="text/javascript" src="../js/jquery-ui.js"></script>
<link href="../css/demo.css" rel="stylesheet" type="text/css">
<head>
    <title>项目档案录入</title>
</head>

<link type="text/css" rel="stylesheet" href="../css/leader.css"/>
<style>
    #name {
        width: 550px;
    }

    #number {
        width: 550px;
    }

    #subject {
        width: 550px;
    }

    #submit {
        width: 550px;
        height: 40px;

    }

</style>
<body>
<ul>
    <li><a class="active" href="../index/index">主页</a></li>
    <li><a href="../project/index">项目信息查询/修改</a></li>
    <li><a href="../staffAdd/index">员工信息管理</a></li>
    <li><a href="../teamAdd/index">小组信息管理</a></li>
</ul>
<br>

<section id="getintouch" class="fadeInRightBig animated">
    <div class="container" style="border-bottom: 0;">
        <h1>
            <span>项目档案录入</span>
        </h1>
    </div>
    <div class="container">
        <form class="contact" action="addAction1" method="post" id="form">
            <div class="row clearfix">
                <div class="lbl">
                    <label for="name">项目名称</label>
                </div>
                <div class="ctrl">
                    <input type="text" id="name" name="pname" data-required="true" data-validation="text"
                           data-msg="Invalid Name" placeholder="不超过10个中文字符">
                </div>
            </div>
            <br>
            <div class="row clearfix">
                <div class="lbl">
                    <label>项目编号</label>
                </div>
                <div class="ctrl">
                    <input type="text" id="tnumber" name="pnumber" data-required="true" data-validation="email"
                           data-msg="Invalid E-Mail" onkeyup="this.value=this.value.replace(/\D/g,'')"
                           onafterpaste="this.value=this.value.replace(/\D/g,'')">
                    <span id="number_tip" class="number_tip"></span>
                </div>
            </div>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <div class="row clearfix">
                <div class="lbl">
                    <label>项目状态</label>
                </div>
                <select name="status"
                        style="height:40px;-webkit-appearance:none;appearance:none;border:none;font-size:18px;padding:0px 10px;display:block;width:100%;-webkit-box-sizing:border-box;box-sizing:border-box;background-color: #FFFFFF;color:#333333;border-radius:4px;">
                    <option value="0">待分配</option>
                    <option value="待开发">待开发</option>
                    <option value="正在开发">正在开发</option>
                    <option value="开发完成">开发完成</option>
                </select>
            </div>
            <br>
            <div class="row clearfix">
                <div class="lbl">
                    <label for="subject">项目说明</label>
                </div>
                <div class="ctrl">
                    <input type="text" id="subject" name="remark" data-required="true" data-validation="text"
                           data-msg="Invalid Name" >

                </div>
            </div>

<br>
            <label>分配小组</label>
            <br>
            <c:forEach var="list" items="${data}" varStatus="status">
                <input name="tnumbers" type="checkbox" value="${list.tnumber}">${list.tname}<br>
            </c:forEach>
            <c:forEach var="list1" items="${data1}" varStatus="status1">
                <input name="tnumbers" type="checkbox" value="${list1.number}">${list1.name}<br>
            </c:forEach>

            <div class="row  clearfix">
                <div class="span10 offset2">
                    <input type="submit" name="submit" id="submit" value="提交" disabled="true">
                </div>
            </div>
        </form>
    </div>

</section>
</body>
<script>
    $(function () {
        $("#tnumber").blur(function () {
            var number = $(this).val();
            $.ajax({
                type: "post",
                url: "checkNum",
                data: {
                    number: number
                },
                dataType: "json",
                success: function (msg) {
                    if (msg.code != 1) {
                        $("#submit").attr('disabled', true);
                        $("#number_tip").css("color", "red");
                        $("#number_tip").text(msg.tip);
                    } else {
                        $("#number_tip").text(msg.tip);
                        $("#number_tip").css("color", "black");
                        $("#submit").attr('disabled', false);
                    }
                },
                error: function (e) {
                    console.log(e.status);
                    console.log(e.responseText);
                }
            });
        });
    })
</script>
</html>