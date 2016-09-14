<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yangliangbin
  Date: 2016/9/13
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title></title>
    <link href="/res/javascript/Hui_3.2/css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
    <link href="/res/javascript/Hui_3.2/css/font-awesome.min.css?v=4.3.0" rel="stylesheet">
    <link href="/res/javascript/Hui_3.2/css/animate.min.css" rel="stylesheet">
    <link href="/res/javascript/Hui_3.2/css/style.min.css?v=3.2.0" rel="stylesheet">
    <!-- 全局js -->
    <script src="/res/javascript/Hui_3.2/js/jquery-2.1.1.min.js"></script>
    <script src="/res/javascript/Hui_3.2/js/bootstrap.min.js"></script>
    <script src="/res/javascript/Hui_3.2/js/content.min.js"></script>
    <script src="/res/javascript/Hui_3.2/js/plugins/validate/jquery.validate.min.js"></script>
    <script src="/res/javascript/Hui_3.2/js/plugins/validate/messages_zh.min.js"></script>
    <script src="/res/javascript/Hui_3.2/js/plugins/layer/layer.min.js"></script>
    <script src="/res/javascript/common.js"></script>
    <!--[if lt IE 8]>
    <script>
        alert('H+已不支持IE6-8，请使用谷歌、火狐等浏览器\n或360、QQ等国产浏览器的极速模式浏览本页面！');
    </script>
    <![endif]-->
</head>
<body>
<div class="ibox">
    <div class="ibox-title">
        <h5>用户列表</h5>
        <div class="ibox-tools">
            <a href="/User/UserAdd" class="btn btn-danger btn-sm">
                <i class="fa fa-plus"></i>&nbsp;添加
            </a>
        </div>
    </div>
    <div class="ibox-content">
        <form action="/user/userList" method="get" commandName="request" role="form">
            <table class="form-group">
                <tr>
                    <th>用户名：</th>
                    <td>
                        <input id="userName" name="userName" type="text" class="form-control">
                    </td>
                    <th>姓名：</th>
                    <td>
                        <input id="name" name="name" type="text" class="form-control">
                    </td>
                    <td>
                        <input type="submit" class="btn btn-primary" value="查询" />
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
<table class="table table-hover table-bordered ">
    <thead>
    <tr>
        <th style="width:45px; text-align:center;">#</th>
        <th>用户ID</th>
        <th>用户名</th>
        <th>姓名</th>
        <th>所属角色</th>
        <th>创建人</th>
        <th>创建时间</th>
        <th width="100">操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${userList}">
        <tr>
            <td></td>
            <td>${user.id}</td>
            <td>${user.userName}</td>
            <td>${user.name}</td>
            <td>${user.roleName}</td>
            <td>${user.createUser}</td>
            <td>${user.createTime}</td>
            <td>
                <span class="label label-primary pull-right">编辑</span>
                <span class="label label-danger pull-right">删除</span>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
