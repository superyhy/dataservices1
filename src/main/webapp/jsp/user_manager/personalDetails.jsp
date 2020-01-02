<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<!---用户基本资料--->
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>数据分析平台</title>
    <link rel="stylesheet" href="../../layui/css/layui.css">
    <!---设置图片居中-->
    <style type="text/css">
        .image{
            width:150px;
            height: 100px;
            display: table-cell;
            vertical-align: middle;
            text-align: center;
        }
        .image img {
            width: 80px;
            height: 80px;
        }
    </style>
</head>
<div class="layui-container">
    <div class="layui-row">
        <div class="layui-col-lg12">
            <div class="layui-field-box">
                <div class="image" pane style="width: 400px">
                    <img src="../images/index/touxiang.jpg" class="layui-nav-img">
                </div>
                    <div class="layui-form-item" pane style="width: 300px">
                        <label class="layui-form-label">用户名:</label>
                        <div class="layui-input-block">
                            <input value="${loginUser}" autocomplete="off" class="layui-input">
                        </div>
                    </div>

                    <div class="layui-form-item" pane style="width: 300px">
                        <label class="layui-form-label">角色:</label>
                        <div class="layui-input-block">
                            <input value="${role}" autocomplete="off" class="layui-input">
                        </div>
                    </div>

            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="../../jquery/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="../../layui/layui.all.js"></script>
</body>
</html>