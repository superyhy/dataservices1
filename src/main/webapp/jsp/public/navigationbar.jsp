<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>layout 后台大布局 - Layui</title>

</head>
<body>
<div class="layui-side-scroll">
    <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
    <ul class="layui-nav layui-nav-tree"  lay-filter="leftNav">
        <li class="layui-nav-item">
            <a href="javascript:;" ><i class="layui-icon" style="font-size: 14px; color: #D0D0D0">&#xe857;</i>
                数据分析</a>
            <dl class="layui-nav-child">
                <dd><a href="/gotoIndexPage">湖南省数据</a></dd>
                <dd><a href="/gotoHengYang">衡阳市数据</a></dd>
            </dl>
        </li>

        <li class="layui-nav-item">
            <a href="javascript:;"><i class="layui-icon" style="font-size: 14px; color: #D0D0D0">&#xe63c;</i>
                数据管理</a>
            <dl class="layui-nav-child">
                <dd><a href="/gotoDataManagerPage">数据列表</a></dd>
            </dl>
        </li>

        <li class="layui-nav-item">
            <a class="" href="javascript:;"><i class="layui-icon" style="font-size: 14px; color: #D0D0D0">&#xe620;</i>
                系统设置</a>
            <dl class="layui-nav-child">
                <dd><a href="sysConfig.html">系统变量</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item">
            <a href="javascript:;"><i class="layui-icon" style="font-size: 14px; color: #D0D0D0">&#xe64c;</i>
                权限管理</a>
            <dl class="layui-nav-child">
                <dd><a href="rule.html">规则列表</a></dd>
                <dd><a href="role.html">角色列表</a></dd>
                <dd><a href="adminRole.html">用户角色</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item">
            <a href="javascript:;"><i class="layui-icon" style="font-size: 14px; color: #D0D0D0">&#xe613;</i>
                用户管理</a>
            <dl class="layui-nav-child">
                <dd><a href="member.html">用户列表</a></dd>
            </dl>
        </li>
    </ul>
  </div>
</body>

</html>
