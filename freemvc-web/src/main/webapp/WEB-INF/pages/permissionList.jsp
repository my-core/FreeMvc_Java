<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yangliangbin
  Date: 2016/9/18
  Time: 14:32
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
    <script>
        function GetType(t) {
            if (t == 1) {
                document.write('模块');
            }
            if (t == 2)
                document.write('主窗体');
            if (t == 3)
                document.write('工具栏');
        }
    </script>
</head>
<body>
<div class="ibox">
    <div class="ibox-title">
        <h5>用户列表</h5>
        <div class="ibox-tools">
            <a href="/user/permissionAdd/0" class="btn btn-primary btn-sm">
                <i class="fa fa-plus"></i>&nbsp;添加
            </a>
        </div>
    </div>
</div>
<table class="table table-hover table-bordered ">
    <thead>
    <tr>
        <th style="width:45px; text-align:center;">#</th>
        <th>权限ID</th>
        <th>权限名</th>
        <th>权限编码</th>
        <th>类型</th>
        <th>Icon图标</th>
        <th>Url地址</th>
        <th>排序号</th>
        <th width="150">操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="p" items="${permissionList}">
        <tr>
            <td style="width:45px; text-align:center;"></td>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td>${p.code}</td>
            <td><script>GetType(${p.type})</script></td>
            <td>${p.icon}</td>
            <td>${p.url}</td>
            <td>${p.sort}</td>
            <td>
                <a class="label label-success" href="/user/permissionAdd/${p.id}"><i class="fa fa-edit"></i>编辑</a>
                <a class="label label-danger" href="javascript:void(0);" onclick="javascript:Delete('/user/permissionDelete/${p.id}');"><i class="fa fa-times"></i>删除</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
