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
    <ul class="layui-nav layui-nav-tree"  lay-filter="test">
        <li class="layui-nav-item"><a class="" href="/gotoIndexPage">控制台</a></li>
        <li class="layui-nav-item">
            <a href="javascript:;">数据管理</a>
            <dl class="layui-nav-child">
                <dd><a href="/gotoDataManagerPage">数据列表</a></dd>
            </dl>
        </li>

        <li class="layui-nav-item">
            <a class="" href="javascript:;">系统设置</a>
            <dl class="layui-nav-child">
                <dd><a href="sysConfig.html">系统变量</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item">
            <a href="javascript:;">权限管理</a>
            <dl class="layui-nav-child">
                <dd><a href="rule.html">规则列表</a></dd>
                <dd><a href="role.html">角色列表</a></dd>
                <dd><a href="adminRole.html">用户角色</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item">
            <a href="javascript:;">会员管理</a>
            <dl class="layui-nav-child">
                <dd><a href="member.html">会员列表</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item">
            <a href="javascript:;">开发者工具</a>
            <dl class="layui-nav-child">
                <dd><a href="control.html">一键生成</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item">
            <a href="javascript:;">集成Demo</a>
            <dl class="layui-nav-child">
                <dd><a href="upload.html">文件上传</a></dd>
                <dd><a href="upload.html">Execel导出</a></dd>
            </dl>
        </li>
    </ul>
  </div>
</body>
</html>
