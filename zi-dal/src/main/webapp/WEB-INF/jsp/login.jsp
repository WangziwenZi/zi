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
    <script type="text/javascript" src="/js/jquery-3.1.0.js"></script>
</head>
<body>
<input type="button" value="登录" id="sigin"/>
<input type="button" value="注册" id="login"/>
<input type="button" value="添加菜单" id="menu_save"/>
<input type="button" value="查看菜单" id="menu_list"/>
<script type="text/javascript">
    $("#sigin").bind("click", function () {
        $.ajax({
            url: "/zi/base/user/sigin.htm",
            type: "post",
            dataType: "json",
            data: {'email': '111', 'password': '111'},
            success: function (data) {
                if (data.success) {
                    alert("登录成功");
                    window.location.href = "/zi/base/index/index.htm"
                } else {
                    alert("登录失败");
                }
            }
        })
    })

    $("#login").bind("click", function () {
        $.ajax({
            url: "/zi/base/user/register.htm",
            type: "post",
            dataType: "json",
            data: {name: '111', email: '111', password: '111', phone: '111'},
            success: function (data) {
                if (data.success) {
                    alert("注册成功");
                } else {
                    alert("注册失败");
                }
            }
        })
    })
    $("#menu_save").bind("click", function () {
        $.ajax({
            url: "/zi/base/menu/saveOrUpdate.htm",
            type: "post",
            dataType: "json",
            data: {title: '111', url: '111', save: 'Y'},
            success: function (data) {
                if (data.success) {
                    alert("保存成功");
                } else {
                    alert("保存失败");
                }
            }
        })
    })
    $("#menu_list").bind("click", function () {
        $.ajax({
            url: "/zi/base/menu/list.htm",
            type: "post",
            dataType: "json",
            success: function (data) {
                if (data.success) {
                    console.log(data);
                    alert("查询菜单成功");
                } else {
                    alert("查询菜单失败");
                }
            }
        })
    })
</script>
</body>
</html>
