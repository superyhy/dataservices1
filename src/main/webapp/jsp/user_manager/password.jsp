<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>数据分析平台</title>
  <link rel="stylesheet" href="../../layui/css/layui.css">
</head>
<div class="layui-container">  
    <div class="layui-row">
        <div class="layui-col-lg12">
                <div class="layui-field-box">
                    <form class="layui-form" id="edit-form"  lay-filter="show-data" action="">
                        <!--传入隐藏的ID--->
                        <input id="id" type="hidden" name="id">
                        <div class="layui-form-item" pane style="width: 400px">
                            <label class="layui-form-label">原密码</label>
                            <div class="layui-input-block">
                                <input  type="password" id="oldPassword" name="oldPassword"  placeholder="请输入密码"  autocomplete="off" class="layui-input">
                            </div>
                        </div>

                        <div class="layui-form-item" pane style="width: 400px">
                            <label class="layui-form-label">新密码</label>
                            <div class="layui-input-block">
                                <input type="password"  id="newPassword" name="newPassword"  placeholder="请输入密码" autocomplete="off" class="layui-input">
                            </div>
                        </div>

                        <div class="layui-form-item" pane style="width: 400px">
                            <label class="layui-form-label">再次输入</label>
                            <div class="layui-input-block">
                                <input type="password" id="inputPassword" name="inputPassword"  placeholder="请输入密码" autocomplete="off"  class="layui-input">
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <div class="layui-input-block">
                                <button class="layui-btn" id="pwdBtn" type="button" lay-submit lay-filter="edit-form">立即提交</button>
                                <button type="reset" class="layui-btn layui-btn-primary" id="closeBtn">重置</button>
                            </div>
                        </div>

                    </form>
                </div>
        </div>
    </div>
</div>
<!--获取登录后的用户名-->
<script type="text/javascript">
    var password="${sessionScope.password}";
    var id="${sessionScope.id}";
</script>
<script type="text/javascript" src="../../jquery/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="../../layui/layui.all.js"></script>
<script type="text/javascript" src="../../js/user_manager/password.js"></script>
</body>
</html>