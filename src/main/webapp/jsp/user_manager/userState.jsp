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
                <legend>用户管理 - 编辑状态</legend>
                <div class="layui-field-box">
                    <form class="layui-form" id="add-form" lay-filter="show-data" action="">
                        <!--传入隐藏的ID--->
                        <input id="id" type="hidden" name="id">

                        <div class="layui-form-item" style="width: 200px" >
                            <label class="layui-form-label">状态</label>
                            <div class="layui-input-block">
                                <select name="isAble" lay-verify="required">
                                    <option value=""></option>
                                    <option value="0">禁用</option>
                                    <option value="1">启用</option>
                                </select>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <div class="layui-input-block">
                                <button class="layui-btn" lay-submit lay-filter="edit-form">确认</button>
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
<script type="text/javascript" src="../../js/user_manager/userState.js"></script>
</body>
</html>
