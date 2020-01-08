<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>湖南省数据</title>
    <script type="text/javascript" src="../jquery/jquery.js"></script>
    <link rel="stylesheet" href="../../css/comon0.css">
    <link rel="stylesheet" href="../../layui/css/layui.css">
</head>
<script>
    $(window).load(function(){
        $(".loading").fadeOut()
    })

    /****/
    $(document).ready(function(){
        var whei=$(window).width()
        $("html").css({fontSize:whei/20})
        $(window).resize(function(){
            var whei=$(window).width()
            $("html").css({fontSize:whei/20})
        });
    });
</script>
<script type="text/javascript" src="../../js/IndexJs/echarts.min.js"></script>
<script language="JavaScript" src="../../js/IndexJs/js.js"></script>
<body>
<div class="loading">
    <div class="loadbox"> <img src="../../images/index/loading.gif"> 页面加载中... </div>
</div>

<ul class="layui-nav" id="index_appbar">

    <li class="layui-nav-item ">
        <a href="/gotoIndexPage">湖南省数据</a>
    </li>
    <li class="layui-nav-item">
        <a href="/gotoHengYang">衡阳市数据</a>
    </li>

<%--    <li class="layui-nav-item" id="">--%>
<%--        <a href="/gotoDataManagerPage">数据管理中心</a>--%>
<%--    </li>--%>

    <ul class="layui-nav layui-layout-right" lay-filter="rightNav">
    <li class="layui-nav-item" lay-unselect="">
        <a href="javascript:;">
            <img src="../../images/index/touxiang.jpg" class="layui-nav-img">
            <span style="color: #F7F7F7"> ${loginUser}</span>
        </a>
        <dl class="layui-nav-child" style="z-index: 9999">
            <dd><a onclick="changePassword();" >密码修改</a></dd>
            <dd><a onclick="personalPage();">基本资料</a></dd>
        </dl>
    </li>
    <li class="layui-nav-item"><a href="/logout">退出</a></li>
    </ul>
</ul>
<div class="head">
    <h1>湖南省空气质量数据分析</h1>
    <div class="weather"><!--<img src="picture/weather.png"><span>多云转小雨</span>--><span id="showTime"></span></div>

    <script>
        var t = null;
        t = setTimeout(time,1000);//開始运行
        function time()
        {
            clearTimeout(t);//清除定时器
            dt = new Date();
            var y=dt.getFullYear();
            var mt=dt.getMonth()+1;
            var day=dt.getDate();
            var h=dt.getHours();//获取时
            var m=dt.getMinutes();//获取分
            var s=dt.getSeconds();//获取秒
            document.getElementById("showTime").innerHTML = y+"年"+mt+"月"+day+"-"+h+"时"+m+"分"+s+"秒";
            t = setTimeout(time,1000); //设定定时器，循环运行
        }

    </script>


</div>
<div class="mainbox">
    <ul class="clearfix">
        <li>
            <div class="boxall" style="height: 3.2rem">
                <div class="alltitle">2019湖南省各市PM2.5平均值</div>
                <div class="allnav" id="echart1"></div>
                <div class="boxfoot"></div>
            </div>
            <div class="boxall" style="height: 3.2rem">
                <div class="alltitle">2019湖南省各市AQI平均值</div>
                <div class="allnav" id="echart2"></div>
                <div class="boxfoot"></div>
            </div>
            <div class="boxall" style="height: 3.2rem">
                <div style="height:100%; width: 100%;">
                    <div class="sy" id="fb1"></div>
                    <div class="sy" id="fb2"></div>
                    <div class="sy" id="fb3"></div>
                </div>
                <div class="boxfoot">

                </div>
            </div>
        </li>
        <li>
            <div class="bar">
                <div class="barbox">
                    <ul class="clearfix">
                        <li class="pulll_left counter">0-50</li>
                        <li class="pulll_left counter">51-100</li>
                    </ul>
                </div>
                <div class="barbox2">
                    <ul class="clearfix">
                        <li class="pulll_left">优（AQI范围）</li>
                        <li class="pulll_left">良（AQI范围）</li>
                    </ul>
                </div>
            </div>
            <div class="map">
                <div class="map1"><img src="../../images/index/lbx.png"></div>
                <div class="map2"><img src="../../images/index/jt.png"></div>
                <div class="map3"><img src="../../images/index/map.png"></div>
                <div class="map4" id="map_hunan"></div>
            </div>
        </li>
        <li>
            <div class="boxall" style="height:3.4rem">
                <div class="alltitle">2019年长沙及株洲两市AQI走势比较</div>
                <div class="allnav" id="echart4"></div>
                <div class="boxfoot"></div>
            </div>
            <div class="boxall" style="height: 3.2rem">
                <div class="alltitle">2019年衡阳,岳阳及郴州三市PM2.5比较</div>
                <div class="allnav" id="echart5"></div>
                <div class="boxfoot"></div>
            </div>
            <div class="boxall" style="height: 3rem">
                <div class="alltitle">2019年湖南省各市PM10平均值</div>
                <div class="allnav" id="echart6"></div>
                <div class="boxfoot"></div>
            </div>
        </li>
    </ul>
</div>
<!--获取登录后的角色名称-->
<script type="text/javascript">
    var role="${sessionScope.role}";
</script>
<script type="text/javascript" src="../../js/IndexJs/china.js"></script>
<script type="text/javascript" src="../../js/IndexJs/hunan_echarts.js"></script>
<script type="text/javascript" src="../../layui/layui.js"></script>
<script type="text/javascript" src="../../js/login_access.js"></script>
<script>
    layui.use('element',function () {
        var element=layui.element;
        element.init();
        element.render();
    });
</script>
</body>
</html>
