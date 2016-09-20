<%--
  Created by IntelliJ IDEA.
  User: yangliangbin
  Date: 2016/9/12
  Time: 17:59
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
<body class="gray-bg">
    <form action="/user/login" method="post" commandName="user" role="form">
        <div class="middle-box text-center loginscreen  animated fadeInDown" >
            <div>
                <div>
                    <h1 class="logo-name" style="font-size:88px;">FreeMvc</h1>
                </div>
                <h3>欢迎使用 FreeMvc内容管理平台</h3>
                <div class="m-t">
                    <div class="form-group">
                        <input id="UserName" name="UserName" type="text" v="admin" class="form-control" required="required">
                    </div>
                    <div class="form-group">
                        <input id="Password" name="Password" type="password" class="form-control" required="required">
                    </div>
                    <button id="btn_login" type="submit" class="btn btn-primary block full-width m-b">登 录</button>
                    <p style="color:red;">${msg}</p>
                    <p class="text-muted text-center">
                        power by 石头小神
                    </p>
                </div>
            </div>
        </div>
    </form>
</body>
</html>