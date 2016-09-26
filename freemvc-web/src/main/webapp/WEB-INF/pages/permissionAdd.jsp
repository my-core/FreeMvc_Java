<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.sun.org.apache.bcel.internal.generic.DDIV" %><%--
  Created by IntelliJ IDEA.
  User: yangliangbin
  Date: 2016/9/18
  Time: 14:43
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
    <form id="PermissionAdd" action="/user/permissionAdd" method="post" commandName="user" role="form">
        <div class="ibox">
            <div class="ibox-title">
                <h5>权限添加/编辑</h5>
            </div>
            <div class="ibox-content">
                <input id="id" name="id" value="${role.id}" type="hidden" >
                <!--form-horizontal:水平排列的表单-->
                <table class="form form-horizontal">
                    <tr>
                        <th style="width: 150px;">父节点：</th>
                        <td>
                            <select id="ParentID" name="ParentID" class="form-control">
                                <option value="">根节点</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>类别：</th>
                        <td>
                            <select id="" name="Type" class="form-control">
                                <option value="1" ${permission.type=="1"?"selected=\"selected\"":""}>模块</option>
                                <option value="2" ${permission.type=="2"?"selected=\"selected\"":""}>主菜单</option>
                                <option value="3" ${permission.type=="3"?"selected=\"selected\"":""}>工具栏</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>权限名：</th>
                        <td>
                            <input id="Name" name="Name" type="text" value="${permission.name}" class="form-control" required="required">
                        </td>
                    </tr>
                    <tr>
                        <th>权限编码：</th>
                        <td>
                            <input id="Code" name="Code" type="text" value="${permission.code}" class="form-control" required="required">
                        </td>
                    </tr>
                    <tr>
                        <th>Icon图标：</th>
                        <td>
                            <input id="Icon" name="Icon" type="text" value="${permission.icon}" class="form-control" >
                        </td>
                    </tr>
                    <tr>
                        <th>Url地址：</th>
                        <td>
                            <input id="Url" name="Url" type="text" value="${permission.url}" class="form-control" >
                        </td>
                    </tr>
                    <tr>
                        <th>排序号：</th>
                        <td>
                            <input id="Sort" name="Sort" type="text" value="${permission.sort}" class="form-control" >
                        </td>
                    </tr>
                    <tr>
                        <th></th>
                        <td>
                            <button type="button" class="btn btn-primary" onclick="addPermission()">保 存</button>
                            <a href="/user/permissionList" class="btn btn-success">返回列表</a>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </form>
    <script>
        var validator;
        $(function () {
            validator=$("#PermissionAdd").validate({
                rules: {
                    Name: {
                        required: true
                    },
                    Code: {
                        required: true
                    }
                },
                messages: {
                    Name: "请输入权限名",
                    Code: "请输入权限编码",
                }
            });
        });
        function addPermission() {
            if (validator.form()) {
                DoAjax('/user/permissionAdd', $('#PermissionAdd').serialize());
            }
        }

    </script>
</body>
</html>
