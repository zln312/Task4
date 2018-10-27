<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/23
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>
    <head>
        <title>注册</title>

            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;">
            <meta name="format-detection" content="telephone=no">
            <title>首页</title>
            <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
            <link rel="stylesheet" href="../css/base.css">
            <link rel="stylesheet" href="../css/task-91.css">
            <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
            <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    </head>
    <div style="width:100%;text-align:center">

    <form id="sighupForm" action="/register" method="post" onsubmit="formCheck()">
        设置用户名：<br>
        <input type="text"  name="username" required pattern="^[a-zA-Z0-9]{6,12}$" placeholder="英文或者数字,长度6到12位" style="width: 200px;height: 35px"><br>
        设置密码：<br>
        <input type="text" name="password" required pattern="^[a-zA-Z0-9]{6,12}$" id="pwd1" placeholder="英文或者数字,长度6到12位" style="width: 200px;height: 35px"><br>
        重复密码：<br>
        <input type="text" name="password1" required="required" id="pwd2" placeholder="英文或者数字,长度6到12位" style="width: 200px;height: 35px"><br><br>
        <input class="button" type="submit" value="注册">
        <a href="http://localhost:8080/firstPage" class="btn">去首页</a>
        <a href="http://localhost:8080/test11" class="btn">去登录</a>
    </form>
        <script type="text/javascript">
            function formCheck(){
                var pwd1 = document.getElementById("pwd1").value;
                var pwd2 = document.getElementById("pwd2").value;
                if(pwd1!=pwd2){
                    alert("两次输入的密码不一致！");

                    return false;
                }
                return true;
            }
        </script>

    </div>
    </html>
