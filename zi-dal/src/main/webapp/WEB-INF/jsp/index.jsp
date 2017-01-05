<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/1/4 0004
  Time: 下午 1:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>财务管理主页</title>
    <link rel="shortcut icon" href="/images/ico/favicon.ico" type="image/x-ico">
    <link href="/js/bootstrap-3.3.0/css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="/css/font-awesome.css" rel="stylesheet" type="text/css"/>
    <!--[if IE 7]>
    <link rel="stylesheet" href="/css/font-awesome-ie7.css">
    <![endif]-->
    <link href="/css/index.css" rel="stylesheet" type="text/css"/>
    <link href="/css/_index.css" rel="stylesheet" type="text/css"/>
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
            <div class="node panel-default">
                <div style="border-bottom:1px solid transparent">
                    <a data-toggle="collapse" href="#collapseOne"><i class="icon-laptop"></i><span>我的工作空间</span></a>
                </div>
                <div id="collapseOne" class="panel-collapse collapse child" role="tabpanel"
                     aria-labelledby="headingOne">
                    <a data-toggle="collapse"><i class="icon-laptop"></i><span>我的工作空间</span></a>
                    <a data-toggle="collapse"><i class="icon-laptop"></i><span>我的工作空间</span></a>
                    <a data-toggle="collapse"><i class="icon-laptop"></i><span>我的工作空间</span></a>
                    <a data-toggle="collapse"><i class="icon-laptop"></i><span>我的工作空间</span></a>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    try {
        (function () {
//            下拉菜单效果
            $(".node a").bind("click", function () {
                if (!$(this).prop("href")) {
                    $(".node a").removeClass("active");
                    $(this).addClass("active");
                }
            })

            $.ajax({
                url: "/menu/findByPage.htm",
                type: "post",
                dataType: "json",
                data: {pageNum: 1, pageSize: 3},
                success: function (data) {
                    console.info(data);
                }
            })
        })();
    } catch (e) {
        window.console && console.log && console.log(e);
        window.Tracker && Tracker.click('onlineServer-error-init-' + e);
    }
</script>
</body>
</html>
