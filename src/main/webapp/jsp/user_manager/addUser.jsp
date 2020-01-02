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
            <fieldset class="layui-elem-field">
                <legend>用户管理 - 新增用户</legend>
                <div class="layui-field-box">
                    <form class="layui-form" id="add-form" action="">

                        <div class="layui-form-item" style="width: 300px" >
                            <label  class="layui-form-label">用户名</label>
                            <div class="layui-input-block">
                                <input type="text" name="username" required  lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
                            </div>
                        </div>

                        <div class="layui-form-item" pane style="width: 300px">
                            <label class="layui-form-label">密码</label>
                            <div class="layui-input-block">
                                <input  type="password" id="oldPassword" name="password"  placeholder="请输入密码"  autocomplete="off" class="layui-input">
                            </div>
                        </div>

                        <div class="layui-form-item" style="width: 300px" >
                            <label class="layui-form-label">角色名称</label>
                            <div class="layui-input-block">
                                <select name="roleId" id="roleNameList" lay-verify="required">
                                    <option value=""></option>
                                </select>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <div class="layui-input-block">
                                <button class="layui-btn" lay-submit lay-filter="addForm">立即提交</button>
                                <button type="reset" class="layui-btn layui-btn-primary" id="closeBtn">重置</button>
                            </div>
                        </div>

                    </form>
                </div>
            </fieldset>
        </div>
    </div>
</div>
<script type="text/javascript" src="../../jquery/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="../../layui/layui.all.js"></script>
<script type="text/javascript" src="../../js/user_manager/addUser.js"></script>
</body>
</html>