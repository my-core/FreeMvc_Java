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
    <form id="RoleAdd" action="/user/roleAdd" method="post" commandName="user" role="form">
        <div class="ibox">
            <div class="ibox-title">
                <h5>角色添加/编辑</h5>
            </div>
            <div class="ibox-content">
                <input id="id" name="id" value="${role.id}" type="hidden" >
                <!--form-horizontal:水平排列的表单-->
                <table class="form form-horizontal">
                    <tr>
                        <th style="width: 150px;">角色名称：</th>
                        <td>
                            <input id="Name" name="Name" type="text" value="${role.name}" class="form-control" required="required">
                        </td>
                    </tr>

                    <tr>
                        <th>备注：</th>
                        <td>
                            <input id="Remark" name="Remark" type="text" value="${role.remark}" class="form-control" required="required">
                        </td>
                    </tr>
                    <tr>
                        <th></th>
                        <td>
                            <button type="button" class="btn btn-primary" onclick="addRole()">保 存</button>
                            <a href="/user/roleList" class="btn btn-success">返回列表</a>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </form>
    <script>
        var validator;
        $(function () {
            validator= $("#RoleAdd").validate({
                rules: {
                    Name: {
                        required: true
                    }
                },
                messages: {
                    Name: "请输入角色名"
                }
            });
        });
        function addRole() {
            if (validator.form()) {
                DoAjax('/user/roleAdd', $('#RoleAdd').serialize());
            }
        }

    </script>
</body>
</html>
