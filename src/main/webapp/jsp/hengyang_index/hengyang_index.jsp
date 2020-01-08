<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../../css/index_hy.css">
    <link rel="stylesheet" href="../../layui/css/layui.css">
    <title>衡阳市数据</title>

</head>
<body>

<ul class="layui-nav" id="index_appbar">
    <li class="layui-nav-item">
        <a href="/gotoIndexPage">湖南省数据</a>
    </li>
    <li class="layui-nav-item">
        <a href="/gotoHengYang">衡阳市数据</a>
    </li>
<%--    <li class="layui-nav-item">--%>
<%--        <a href="/gotoDataManagerPage">数据管理中心</a>--%>
<%--    </li>--%>

    <ul class="layui-nav layui-layout-right" lay-filter="rightNav">
        <li class="layui-nav-item">
            <a href="javascript:;">
                <img src="../../images/index/touxiang.jpg" class="layui-nav-img">
                <span style="color: #F7F7F7"> ${loginUser}</span>
            </a>
            <dl class="layui-nav-child">
                <dd><a onclick="changePassword()">密码修改</a></dd>
                <dd><a onclick="personalPage()">基本资料</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item"><a href="/logout">退出</a></li>
    </ul>
</ul>
    <div class="t_container">
        <header class="t_h_bg">
            <span>衡阳市空气质量数据分析</span>
        </header>
        <main class="t_main">
            <div class="t_box">
                <header class="t_title">
                    <span>2018-2019衡阳市AQI指数走势比较</span>
                </header>
                <div id="chart_1" class="echart" style="width: 100%; height: 2.4rem;"></div>
            </div>
            <div class="t_box">
                <header class="t_title">
                    <span>商品销售统计</span>
                </header>
                <div id="chart_2" class="echart" style="width: 100%; height: 3rem;"></div>
            </div>
            <div class="t_box">
                <header class="t_title">
                    <span>年度销售额走势图</span>
                </header>
                <div id="chart_3" class="echart" style="width: 100%; height: 3rem;"></div>
            </div>
            <div class="t_box">
                <header class="t_title">
                    <span>2019年衡阳市AQI与PM2.5关系图</span>
                </header>
                <div id="chart_4" class="echart" style="width: 100%; height: 3rem;"></div>
            </div>
        </main>
</div>

<!--获取登录后的角色名称-->
<script type="text/javascript">
    var role="${sessionScope.role}";
</script>
<script type="text/javascript" src="../../js/login_access.js"></script>
<script type="text/javascript" src="../../jquery/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="../../js/hengyang/rem.js"></script>
<script type="text/javascript" src="../../layui/layui.js"></script>
<script type="text/javascript" src="../../js/hengyang/echarts.min.js"></script>
<script type="text/javascript" src="../../js/hengyang/index.js"></script>
<script>
    layui.use('element',function () {
        var element=layui.element;
        element.init();
        element.render();
    })
</script>
</body>
</html>