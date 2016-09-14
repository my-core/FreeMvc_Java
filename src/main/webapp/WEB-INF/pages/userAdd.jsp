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
    <form id="userAdd" action="/user/userAdd" method="post" commandName="user" role="form">
        <div class="ibox">
            <div class="ibox-title">
                <h5>用户添加/编辑</h5>
            </div>
            <div class="ibox-content">
                <input id="id" name="id" value="${user.id}" type="hidden" >
                <!--form-horizontal:水平排列的表单-->
                <table class="form form-horizontal">
                    <tr>
                        <th style="width: 150px;">用户名：</th>
                        <td>
                            <input id="UserName" name="UserName" type="text" value="${user.userName}" class="form-control" required="required">
                        </td>
                    </tr>
                    <tr>
                        <th>登录密码：</th>
                        <td>
                            <input id="Password" name="Password" type="password" value="" class="form-control" required="required">
                        </td>
                    </tr>
                    <tr>
                        <th>确认密码：</th>
                        <td>
                            <input id="Password0" name="Password0" type="password" value="" class="form-control" required="required">
                        </td>
                    </tr>
                    <tr>
                        <th>姓名：</th>
                        <td>
                            <input id="Name" name="Name" type="text" value="${user.name}" class="form-control" required="required">
                        </td>
                    </tr>
                    <tr>
                        <th>所属角色:</th>
                        <td>

                        </td>
                    </tr>
                    <tr>
                        <th></th>
                        <td>
                            <button type="submit" class="btn btn-primary">保 存</button>
                            <a href="/user/userList" class="btn btn-success">返回列表</a>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </form>
    <script>
        $(function () {
            $("#UserAdd").validate({
                rules: {
                    UserName: "required",
                    Password: {
                        required: true,
                        minlength: 3
                    },
                    Password0: {
                        required: true,
                        minlength: 3,
                        equalTo: "#Password"
                    },
                    Name: {
                        required: true
                    }
                },
                messages: {
                    UserName: "请输入用户名",
                    Password: {
                        required: "请输入登录密码",
                        minlength: $.validator.format("密码不能小于{0}个字 符")
                    },
                    Password0: {
                        required: "请输入确认密码",
                        minlength: "确认密码不能小于3个字符",
                        equalTo: "两次输入密码不一致不一致"
                    },
                    Name: "请输入姓名"
                }
            });
        });
    </script>
</body>
</html>
