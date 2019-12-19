<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>数据分析平台</title>
    <link rel="shortcut icon" href="../favicon.ico" />
  <link rel="stylesheet" href="../layui/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
      <%@ include file="public/header.jsp"%>
  </div>

  <div class="layui-side layui-bg-black" id="main-layout">
      <!--导航栏-->
      <%@ include file="public/navigationbar.jsp"%>
  </div>
  
  <div class="layui-body">
    <!-- 内容主体区域 -->
      <%@ include file="screen.jsp"%>
  </div>
  

</div>
</body>
<script type="text/javascript" src="../jquery/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="../layui/layui.js"></script>
<script type="text/javascript" src="../js/IndexJs/index.js"></script>
</html>