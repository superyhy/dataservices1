<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<meta http-equiv="Pragma" content="no-cache"> 
<meta http-equiv="Cache-Control" content="no-cache"> 
<meta http-equiv="Expires" content="0"> 
<title>登录</title>
<link rel="shortcut icon" href="../favicon.ico">
<link href="/css/login.css" rel="stylesheet" type="text/css" />
<link href="../layui/css/layui.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="login_box">
      <div class="login_l_img"><img src="../images/login/login-img.png" /></div>
      <div class="login">
          <div class="login_logo"><a href="#"><img src="../images/login/login_logo.png" /></a></div>
          <div class="login_name">
               <p>数据分析平台</p>
          </div>
              <div>
                  ${msg}
              </div>
              <input name="username" type="text" id="username"  value="用户名" onfocus="this.value=''" onblur="if(this.value==''){this.value='用户名'}">
              <span id="password_text" onclick="this.style.display='none';document.getElementById('password').style.display='block';document.getElementById('password').focus().select();" >密码</span>
              <input name="password" type="password" id="password" style="display:none;" onblur="if(this.value==''){document.getElementById('password_text').style.display='block';this.style.display='none'};"/>
              <input value="登录" style="width:100%;" type="button" id="button">
      </div>
      <div class="copyright">郁涵艺 版权所有©2016-2020 </div>
</div>
</body>
<script type="text/javascript" src="../jquery/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="../js/user.js"></script>
<script type="text/javascript" src="../layui/layui.all.js"></script>
</html>
