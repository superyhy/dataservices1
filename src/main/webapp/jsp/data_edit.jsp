<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>数据分析平台</title>
  <link rel="stylesheet" href="../layui/css/layui.css">
</head>
<div class="layui-container">  
    <div class="layui-row">
        <div class="layui-col-lg12">
            <fieldset class="layui-elem-field">
                <legend>数据管理 - 编辑数据</legend>
                <div class="layui-field-box">
                    <form class="layui-form" id="edit-form"  lay-filter="show-data" action="">
                        <!--传入隐藏的ID--->
                        <input id="id" type="hidden" name="id">
                        <div class="layui-form-item" style="width: 500px" >
                            <label class="layui-form-label">城市名称</label>
                            <div class="layui-input-block">
                                <select name="cityName" lay-verify="required">
                                    <option value=""></option>
                                    <option value="长沙">长沙</option>
                                    <option value="衡阳">衡阳</option>
                                    <option value="株洲">株洲</option>
                                    <option value="湘潭">湘潭</option>
                                    <option value="岳阳">岳阳</option>
                                    <option value="郴州">郴州</option>
                                </select>
                            </div>
                        </div>

                        <div class="layui-form-item" style="width: 500px" >
                            <label  class="layui-form-label">空气质量指数（AQI）</label>
                            <div class="layui-input-block">
                                <input type="text" name="aqi" required  lay-verify="required" placeholder="请输入AQI值" autocomplete="off" class="layui-input">
                            </div>
                        </div>

                        <div class="layui-form-item" style="width: 500px">
                            <label class="layui-form-label">可入肺颗粒物（PM2.5值）</label>
                            <div class="layui-input-block">
                            <input type="text" name="pm25" required  lay-verify="required" placeholder="请输入PM2.5值" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item" style="width: 500px">
                            <label class="layui-form-label" style="">可吸入颗粒物（PM10值）</label>
                            <div class="layui-input-block">
                                <input type="text" name="pm10" required  lay-verify="required" placeholder="请输入PM10值" autocomplete="off" class="layui-input">
                            </div>
                        </div>

                        <div class="layui-form-item" style="width: 500px">
                            <label class="layui-form-label">二氧化硫指数（SO2）</label>
                            <div class="layui-input-block">
                                <input type="text" name="so2" required  lay-verify="required" placeholder="请输入SO2值" autocomplete="off" class="layui-input">
                            </div>
                        </div>

                        <div class="layui-form-item" style="width: 500px">
                            <label class="layui-form-label">二氧化氮指数（NO2）</label>
                            <div class="layui-input-block">
                                <input type="text" name="no2" required  lay-verify="required" placeholder="请输入NO2值" autocomplete="off" class="layui-input">
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <div class="layui-input-block">
                                <button class="layui-btn" lay-submit lay-filter="edit-form">立即提交</button>
                                <button type="reset" class="layui-btn layui-btn-primary" id="closeBtn">重置</button>
                            </div>
                        </div>

                    </form>
                </div>
            </fieldset>
        </div>
    </div>
</div>
<script type="text/javascript" src="../jquery/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="../layui/layui.js"></script>
<script type="text/javascript" src="../js/data/data_edit.js"></script>
</body>
</html>