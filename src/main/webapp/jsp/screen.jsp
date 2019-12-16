<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>index</title>
    <script type="text/javascript" src="../jquery/jquery.js"></script>
    <link rel="stylesheet" href="../css/comon0.css">
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
<script type="text/javascript" src="../js/IndexJs/echarts.min.js"></script>
<script language="JavaScript" src="../js/IndexJs/js.js"></script>
<body>

<div class="loading">
    <div class="loadbox"> <img src="../images/index/loading.gif"> 页面加载中... </div>
</div>
<div class="head">
    <h1>湖南省大数据展板</h1>
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
                <div class="alltitle">湖南省当月各市PM2.5平均值</div>
                <div class="allnav" id="echart1"></div>
                <div class="boxfoot"></div>
            </div>
            <div class="boxall" style="height: 3.2rem">
                <div class="alltitle">模块标题样式</div>
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
                        <li class="pulll_left counter">12581189</li>
                        <li class="pulll_left counter">3912410</li>
                    </ul>
                </div>
                <div class="barbox2">
                    <ul class="clearfix">
                        <li class="pulll_left">2018年总收入情况 </li>
                        <li class="pulll_left">2018年总支出情况</li>
                    </ul>
                </div>
            </div>
            <div class="map">
                <div class="map1"><img src="../images/index/lbx.png"></div>
                <div class="map2"><img src="../images/index/jt.png"></div>
                <div class="map3"><img src="../images/index/map.png"></div>
                <div class="map4" id="map_hunan"></div>
            </div>
        </li>
        <li>
            <div class="boxall" style="height:3.4rem">
                <div class="alltitle">模块标题样式</div>
                <div class="allnav" id="echart4"></div>
                <div class="boxfoot"></div>
            </div>
            <div class="boxall" style="height: 3.2rem">
                <div class="alltitle">模块标题样式</div>
                <div class="allnav" id="echart5"></div>
                <div class="boxfoot"></div>
            </div>
            <div class="boxall" style="height: 3rem">
                <div class="alltitle">模块标题样式</div>
                <div class="allnav" id="echart6"></div>
                <div class="boxfoot"></div>
            </div>
        </li>
    </ul>
</div>
<div class="back"></div>


<script type="text/javascript" src="../js/IndexJs/china.js"></script>
<script type="text/javascript" src="../js/IndexJs/hunan_echarts.js"></script>
</body>
</html>
