<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/1/4 0004
  Time: 下午 1:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link href="/css/index.css" rel="stylesheet" type="text/css"/>
    <link href="/css/_index.css" rel="stylesheet" type="text/css"/>
    <link rel="shortcut icon" href="/images/ico/favicon.ico" type="image/x-ico">
    <link href="/js/bootstrap-3.3.0/css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="/css/font-awesome.css" rel="stylesheet" type="text/css"/>
    <!--[if IE 7]>
    <link rel="stylesheet" href="/css/font-awesome-ie7.css">
    <![endif]-->
    <script type="text/javascript" src="/js/jquery-3.1.0.js"></script>
    <script type="text/javascript" src="/js/index.js"></script>
    <script type="text/javascript" src="/js/bootstrap-3.3.0/js/bootstrap.js"></script>
    <script type="text/javascript" src="/js/layer/layer.js"></script>
</head>
<body>
<div class="panel">
    <div class="menu">
        <div class="logo">
                <span>
                    <i class="icon-cloud icon-3x"></i>
                    <i class="icon-fighter-jet icon-3x blue"></i>
                </span>
        </div>
        <div style="height: 404px;">
            <ul class="nav_tree">
                <li><a href="javascript:void(0)"><i class="icon-laptop icon-large"></i><span class="text"> 我的工作空间</span></a>
                </li>
                <li><a href="javascript:void(0)"><i class="icon-key icon-large"></i><span
                        class="text"> 员工权限管理</span></a></li>
                <li><a href="javascript:void(0)"><i class="icon-cog icon-large"></i><span class="text"> 系统设置</span></a>
                </li>
                <li data-code="node">
                    <a href="javascript:void(0)"><i class="icon-cog icon-large"></i><span class="text"> 空间</span><i
                            class="icon-caret-down floatRight downIco"></i></a>
                    <ul class="nav_tree child" style = "display: none;">
                        <li><a href="index.html"><i class="icon-laptop icon-large"></i><span class="text"> 我的工作空间</span></a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</div>
<script type="text/javascript">
    try {
        (function () {
            methods = {
                active: function () {
                    $(".nav_tree > li").bind("click", function () {
                        if ($(this).data("code") != "node") {
                            $(".nav_tree li").removeClass("active");
                            $(this).addClass("active");
                        }else{
                            $(this).find(".child").show();
                        }
                    })
                }
            }

            methods.active();
        })();
    } catch (e) {
        window.console && console.log && console.log(e);
        window.Tracker && Tracker.click('onlineServer-error-init-' + e);
    }
</script>
</body>
</html>
