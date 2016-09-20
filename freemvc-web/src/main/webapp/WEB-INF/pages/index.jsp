<%--
  Created by IntelliJ IDEA.
  User: yangliangbin
  Date: 2016/9/2
  Time: 19:30
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
<body class="fixed-sidebar full-height-layout gray-bg">
<form id="wrapper">
    <!--左侧导航开始-->
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="nav-close">
            <i class="fa fa-times-circle"></i>
        </div>
        <div class="sidebar-collapse">
            <ul class="nav" id="side-menu">
                <li class="nav-header">
                    <div class="dropdown profile-element">
                            <span>
                                <img class="img-circle" src="/res/javascript/Hui_3.2/img/a1.jpg" width="64" height="64" />
                            </span>
                        <a data-toggle="dropdown" class="dropdown-toggle">
                                <span class="clear">
                                    <span class="block m-t-xs"><strong class="font-bold">石头小神</strong></span>
                                    <span class="text-muted text-xs block">超级管理员<b class="caret"></b></span>
                                </span>
                        </a>
                        <ul class="dropdown-menu animated fadeInRight m-t-xs">
                            <li>
                                <a class="J_menuItem" href="">修改头像</a>
                            </li>
                            <li>
                                <a class="J_menuItem" href="">个人资料</a>
                            </li>
                            <li>
                                <a class="J_menuItem" href="">联系我们</a>
                            </li>
                            <li>
                                <a class="J_menuItem" href="">信箱</a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="/user/login">安全退出</a>
                            </li>
                        </ul>
                    </div>
                    <div class="logo-element">石</div>
                </li>
                ${permissin}
                <%--<li>
                    <a><i class="fa fa-home"></i><span class="nav-label">系统管理</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="/user/userList" data-index="0"> 用户管理</a></li>
                        <li><a class="J_menuItem" href="/user/roleList" data-index="0">角色管理</a></li>
                        <li><a class="J_menuItem" href="#" data-index="0"> 权限管理</a></li>
                    </ul>
                </li>--%>
            </ul>
        </div>
    </nav>
    <!--左侧导航结束-->
    <!--右侧部分开始-->
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <div class="row border-bottom">
            <div style="margin:20px;">
                当前时间：<span id="time"></span>
                <script>ShowTime('time');</script>
            </div>
        </div>
        <!--菜单tab-->
        <div class="row content-tabs">
            <button class="roll-nav roll-left J_tabLeft">
                <i class="fa fa-backward"></i>
            </button>
            <nav class="page-tabs J_menuTabs">
                <div class="page-tabs-content">
                    <a href="javascript:;" class="active J_menuTab" data-id="index_v1.html">首页</a>
                </div>
            </nav>
            <button class="roll-nav roll-right J_tabRight">
                <i class="fa fa-forward"></i>
            </button>
            <div class="btn-group roll-nav roll-right">
                <button class="dropdown J_tabClose" data-toggle="dropdown">关闭操作<span class="caret"></span></button>
                <ul role="menu" class="dropdown-menu dropdown-menu-right">
                    <li class="J_tabShowActive"><a>定位当前选项卡</a></li>
                    <li class="divider"></li>
                    <li class="J_tabCloseAll"><a>关闭全部选项卡</a></li>
                    <li class="J_tabCloseOther"><a>关闭其他选项卡</a></li>
                </ul>
            </div>
        </div>
        <!--主内容-->
        <div class="row J_mainContent" id="content-main">
            <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="/welcome" frameborder="0" data-id="/Home/Welcome" seamless></iframe>
        </div>
        <div class="footer">
            <div class="pull-right">
                &copy; 2016-2088 <a href="#" target="_blank">石头小神</a>
            </div>
        </div>
    </div>
    <!--右侧部分结束-->
</form>
<!-- 全局js -->
<script type="text/javascript" src="/res/javascript/Hui_3.2/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script type="text/javascript" src="/res/javascript/Hui_3.2/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<!-- 自定义js -->
<script type="text/javascript" src="/res/javascript/Hui_3.2/js/hplus.min.js?v=3.2.0"></script>
<script type="text/javascript" src="/res/javascript/Hui_3.2/js/contabs.min.js"></script>
</body>
</html>
