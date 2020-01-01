<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/24
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/jquery.ffform.js"></script>
<script type="text/javascript" src="../js/jquery-ui.js"></script>
<link href="../css/demo.css" rel="stylesheet" type="text/css">
<link type="text/css" rel="stylesheet" href="../css/staff/add.css"/>
<link type="text/css" rel="stylesheet" href="../css/leader.css"/>
<style>
    #name{
        width: 550px;
    }
    #number{
        width: 550px;
    }
    #subject{
        width: 550px;
    }
    #submit{
        width: 550px;
        height: 40px;

    }

</style>
<head>
    <title>员工档案录入</title>
</head>

<body>
<ul>
    <li><a class="active" href="../index/index">主页</a></li>
    <li><a href="../staffSU/index">员工信息查询/修改</a></li>
    <li><a href="../teamAdd/index">小组信息管理</a></li>
    <li><a href="../projectAdd/index">项目信息管理</a></li>
</ul>
<br>

<section id="getintouch" class="fadeInRightBig animated">
    <div class="container" style="border-bottom: 0;">
        <h1>
            <span>员工档案录入</span>
        </h1>
    </div>

    <div class="container">
        <form class="contact" action="addAction" method="post" id="form">
            <div class="row clearfix">
                <div class="lbl">
                    <label for="name">姓名</label>
                </div>
                <div class="ctrl">
                    <input type="text" id="name" name="name" data-required="true" data-validation="text"
                           data-msg="Invalid Name" placeholder="不超过10个中文字符">
                </div>
            </div>
            <br>
            <div class="row clearfix">
                <div class="lbl">
                    <label >工号</label>
                </div>
                <div class="ctrl">
                    <input type="text" id="number" name="number" data-required="true" data-validation="email"
                           data-msg="Invalid E-Mail" placeholder="11位以内的数字" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')">
                    <span id="number_tip" class="number_tip"></span>
                </div>
            </div>

            <br>
            <div class="row clearfix">
                <div class="lbl">
                    <label for="subject">电话</label>
                </div>
                <div class="ctrl">
                    <input type="text" name="phone" id="subject" placeholder="可不填">
                </div>
            </div>
            <br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <div class="row clearfix">
                <div class="lbl">
                    <label >所属小组</label>
                </div>
                <select name="ofteam" style="height:40px;-webkit-appearance:none;appearance:none;border:none;font-size:18px;padding:0px 10px;display:block;width:100%;-webkit-box-sizing:border-box;box-sizing:border-box;background-color: #FFFFFF;color:#333333;border-radius:4px;">
                    <option value="0">待分配</option>
                    <c:forEach var="list" items="${data}" varStatus="status">
                        <option value=${list.number}>${list.name}</option>
                    </c:forEach>
                </select>
            </div>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <div class="row clearfix">
                <div class="lbl">
                    <label for="message">
                        任职状况</label>
                </div>
                <select name="tenure" id="message" style="height:40px;-webkit-appearance:none;appearance:none;border:none;font-size:18px;padding:0px 10px;display:block;width:100%;-webkit-box-sizing:border-box;box-sizing:border-box;background-color: #FFFFFF;color:#333333;border-radius:4px;">
                    <option value="在职">在职</option>
                    <option value="休假">休假</option>
                    <option value="离职">离职</option>
                </select>
            </div>
            <br>
            <div class="row  clearfix">
                <div class="span10 offset2">
                    <input type="submit" name="submit" id="submit" value="提交" disabled="true">
                </div>
            </div>
        </form>
        </div>
    </div>
</section>
</body>
<script>
    $(function () {
        $("#number").blur(function () {
            var number = $(this).val();
            $.ajax({
                type: "post",
                url: "checkNum",
                data: {
                    number: number
                },
                dataType: "json",
                success: function (msg) {
                    if(msg.code!=1){
                        $("#submit").attr('disabled',true);
                        $("#number_tip").css("color","red");
                        $("#number_tip").text(msg.tip);
                    }else {
                        $("#number_tip").text(msg.tip);
                        $("#number_tip").css("color","black");
                        $("#submit").attr('disabled',false);

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
