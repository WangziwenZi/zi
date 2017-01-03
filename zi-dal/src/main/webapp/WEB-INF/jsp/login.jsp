<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/21
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link href="/js/bootstrap-3.3.0/css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="/css/index.css" rel="stylesheet" type="text/css"/>
    <link href="/css/login.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/js/jquery-3.1.0.js"></script>
    <script type="text/javascript" src="/js/index.js"></script>
    <script type="text/javascript" src="/js/bootstrap-3.3.0/js/bootstrap.js"></script>
</head>
<body>
<div class="panel login">
    <div class="panel-heading title">帐密登录</div>
    <div class="panel-body">
        <form id = "login-form">
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-addon"><span class="glyphicon glyphicon-user"></span></div>
                    <input class="form-control text" type="text" placeholder="账户名" name = "email">
                </div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></div>
                    <input class="form-control text" type="text" placeholder="密码" name = "password">
                </div>
            </div>
            <div>
                <span class="glyphicon glyphicon-question-sign"></span>
                <a href="javascript:void(0)">忘记登录密码？</a>
            </div>
            <a type="button" class="btn btn-primary btn-lg btn-block login-btn" id = "login">登 录</a>
        </form>
    </div>
</div>
<div class="authcenter-background" id="J-authcenter-bg">
    <img id="J-authcenter-bgImg" class="authcenter-bg authcenter-bg-show" smartracker="on"
         src="/images/login.jpg" style="width: 1903px; height: 1189px;">
</div>
<script type="text/javascript">
    try {
        (function () {
            /**
             * 填充整个页面
             */
            function backgroundInit() {
                var bg = $("#J-authcenter-bg");
                bg.height(tools.findByHeight());
                bg.width(tools.findByWidth());
                bg.find("img").height(tools.findByHeight());
                bg.find("img").width(tools.findByWidth());
            };
            $(window).bind("resize",function () {
                backgroundInit();
            })

            function login(){
                $("#login").bind("click",function(){
                    $.ajax({
                        url:"/sigin.htm",
                        type:"post",
                        dataType:"json",
                        success:function (data) {
                            
                        }
                    })
                })
            }
            /**
             * 启动器
             */
            function main() {
                backgroundInit();
            }

            main();
        })();
    } catch (e) {
        window.console && console.log && console.log(e);
        window.Tracker && Tracker.click('onlineServer-error-init-' + e);
    }
</script>
</body>
</html>
