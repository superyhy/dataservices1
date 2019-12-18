<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>数据分析平台</title>
  <link rel="stylesheet" href="../layui/css/layui.css">
  <link rel="stylesheet" href="../css/global.css">
  <link rel="stylesheet" href="../icheck/minimal/red.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
      <%@ include file="public/header.jsp"%>
  </div>
  
  <div class="layui-side layui-bg-black">
      <!--导航栏-->
      <%@ include file="public/navigationbar.jsp"%>
  </div>
  
  <div class="layui-body">
    <!-- 内容主体区域 -->
    <div style="padding: 15px;">
        <fieldset class="layui-elem-field">
            <legend>数据管理 - 数据列表</legend>
            <div class="layui-field-box">
              <form class="layui-form" action="" id="queryAirQualityForm">
                  <input id="pageNum" type="hidden" name="pageNum">
                  <input id="pageSize" type="hidden" name="pageSize">
                <div class="layui-form-item" style="text-align:center;">
                  <div class="layui-inline">
                    <div class="layui-input-inline">
                      <input id="cityName" autocomplete="off" class="layui-input" placeholder="请输入城市名称" type="text" name="cityName" value="">
                    </div>
                  </div>
                  <div class="layui-inline" style="text-align:left;">
                    <div class="layui-input-inline">
                      <button class="layui-btn" type="button" onclick="queryBtn()"><i class="layui-icon">&#xe615;</i>查询</button>
                    </div>
                  </div>
                </div>
              </form>
              <hr>
              <div class="layui-btn-group">
                  <button type="button" class="layui-btn layui-btn-xs layui-btn-normal dw-dailog" dw-url="/gotoCreatePage" dw-title="新增数据" dw-width="90%" dw-height="90%">
                      <i class="layui-icon">&#xe654;</i>新增
                  </button>
                  <button type="button" class="layui-btn layui-btn-xs layui-btn-danger dw-batch-delete" dw-url="./delete.json">
                      <i class="layui-icon">&#xe640;</i>删除
                  </button>
                  <button type="button" class="layui-btn layui-btn-xs dw-refresh">
                      <i class="layui-icon">&#x1002;</i>刷新
                  </button>
              </div>
              <hr>
              <table class="layui-table">
                  <thead>
                      <tr>
                      <th class="selectAll"><input type="checkbox"></th>
                      <th>序号</th>
                      <th>城市</th>
                      <th>空气质量指数（AQI）</th>
                      <th>PM2.5</th>
                      <th>PM10</th>
                      <th>二氧化硫指数（SO2）</th>
                      <th>二氧化氮指数（NO2）</th>
                      <th style="text-align:center;">操作</th>
                      </tr>
                  </thead>
                  <tbody id="dataTable">

                  </tbody>
              </table>
            </div>

            <!--分页信息-->
            <div id="pageDiv">

            </div>
        </fieldset>
    </div>
  </div>
  
  <div class="layui-footer">
    <!-- 底部固定区域 -->
    © 郁涵艺 -南华大学2016-2020  </div>
</div>
<script type="text/javascript" src="../jquery/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="../layui/layui.js"></script>
<script type="text/javascript" src="../icheck/icheck.js"></script>
<script type="text/javascript" src="../js/IndexJs/dw.js"></script>
<script type="text/javascript" src="../js/datamanager.js"></script>
<script type="text/javascript" src="../js/IndexJs/data_form_submit.js"></script>
</body>
</html>