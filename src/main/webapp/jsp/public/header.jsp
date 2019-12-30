<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>数据分析平台</title>

</head>
<body>
    <div class="layui-logo">管理中心</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <ul class="layui-nav layui-layout-left" lay-filter="leftNav">
        <li class="layui-nav-item"><a href="/gotoIndexPage">湖南省数据</a></li>
        <li class="layui-nav-item"><a href="/gotoHengYang">衡阳市数据</a></li>
        <li class="layui-nav-item"><a href="/gotoDataManagerPage">数据管理中心</a></li>
    </ul>
    <ul class="layui-nav layui-layout-right" lay-filter="rightNav">
        <li class="layui-nav-item">
            <a href="javascript:;">
                <img src="../images/index/touxiang.jpg" class="layui-nav-img">
                <span style="color: #F7F7F7"> ${loginUser}</span>
            </a>
            <dl class="layui-nav-child">
                <dd><a onclick="changePassword();">密码修改</a></dd>
                <dd><a onclick="personalPage()">基本资料</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item"><a href="/logout">退出</a></li>
    </ul>

<script type="text/javascript" src="../../js/login_access.js"></script>
</body>
</html>
