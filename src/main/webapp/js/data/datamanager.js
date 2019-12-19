
// +----------------------------------------------------------------------
// |分页查询操作
// +----------------------------------------------------------------------
function queryAirQualityList(){
    $.ajax({
        url:"/queryAirQuality",
        data:$("#queryAirQualityForm").serialize(),
        dataType:'json',
        type:'get',
        success:showTable
    });
}


function showTable(pageInfo) {

    var total = pageInfo.total;//页总数
    var pageNum = pageInfo.pageNum;//页号
    var pageSize = pageInfo.pageSize;//页大小
    var pages=pageInfo.pages;//页数

    var airQualityList = pageInfo.list;
    $("#dataTable").html("");//清空表格中数据并重新填充数据
    for(var i=0,length_1 = airQualityList.length;i<length_1;i++){
        var index = (pageNum - 1) * pageSize + i + 1;
        var tr = "<tr><td>"+'<input type="radio" name="trainshemeRadio" value="'+airQualityList[i].id+'"><input type="hidden" value="'+airQualityList[i].id+'"/></td>'
            +'<td>'+index+'</td>'
            +'<td>'+airQualityList[i].cityName+'</td>'
            +'<td>'+airQualityList[i].aqi+'</td>'
            +'<td>'+airQualityList[i].pm25+'</td>'
            +'<td>'+airQualityList[i].pm10+'</td>'
            +'<td>'+airQualityList[i].so2+'</td>'
            +'<td>'+airQualityList[i].no2+'</td>'
            +'<td>'
            +'<button onclick="editButton('+airQualityList[i].id+')" type="button" style="background-color: #01AAED" class="layui-btn layui-btn-xs layui-btn-danger"  dw-title="编辑用户"><i class="layui-icon">&#xe642;</i>编辑</button>'
            +'<button onclick="deleteButton('+airQualityList[i].id+')"  class="layui-btn layui-btn-xs layui-btn-danger " ><i class="layui-icon">&#xe640;</i>删除</button>'
            +'<a href="/downloadAirQuality/'+airQualityList[i].id+'" style="background-color: #009f95" class="layui-btn layui-btn-xs layui-btn-danger " ><i class="layui-icon">&#xe601;</i>下载</a>'
            +'</td></tr>'
        $("#dataTable").append(tr);
    }

   startPage(total,pageNum,pageSize,pages);
}

//先初始化加载首页
queryAirQualityList();

function startPage(total,pageNum,pageSize,pages){
    //使用layui的分页插件
    layui.use(['laypage', 'jquery'], function(){
        var laypage = layui.laypage,$ = layui.$;

        laypage.render({
            elem: 'pageDiv', //注意，这里的 test1 是 ID，不用加 # 号
            count: total, //数据总数，从服务端得到
            limit: pageSize,//每页显示的条数。laypage将会借助 count 和 limit 计算出分页数。
            curr: pageNum,//当前页号
            pages: pages,
            limits: [6, 10, 15, 20],
            layout: ['limit', 'prev', 'page', 'next', 'skip', 'count'],//显示哪些分页组件

            jump: function (obj, first) {//点击页号的时候执行的函数
                //obj包含了当前分页的所有参数，比如：
                // console.log(obj.curr); //得到当前页，以便向服务端请求对应页的数据。
                // console.log(obj.limit); //得到每页显示的条数

                if (!first) {//首次不执行(点击的时候才执行)
                    //清空以前加载的数据
                    $("#dataTable").empty();

                    $("[name='pageNum']").val(obj.curr);//向隐藏域设置当前页的值
                    $("[name='pageSize']").val(obj.limit);//向隐藏域设置当前页的大小
                    //调用加载函数加载数据
                    queryAirQualityList();
                }
            }
        });
    });

}


/**
 * 点击查询的事件
 */
function queryBtn() {
    $("[name='pageNum']").val("");//清空页号
    queryAirQualityList();//分页查询课程信息
}


// +----------------------------------------------------------------------
// | 删除操作
// +----------------------------------------------------------------------
function deleteButton(id){
                layer.confirm('您确定要删除吗？',{
                    icon: 3 ,
                    title: '提示',
                    btn: ['是','否'] //按钮
                }, function(){
                    $.ajax({
                        url:'/deleteAirQuality/'+id,
                        type:'get', //GET
                        async:true,    //或false,是否异步
                        timeout:5000,    //超时时间
                        dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
                        success:function(data){
                            console.log(data);
                            if (data){
                                var layer=layui.layer;
                                layer.msg("操作成功",{icon: 1}, function (index) {
                                    CloseWin();
                                })
                            }else {
                                var layer=layui.layer;
                                layer.msg("删除失败");
                            }
                        },
                        error:function(xhr,textStatus){
                            console.log('错误')
                            console.log(xhr)
                            console.log(textStatus)
                        },
                        complete:function(){
                            //console.log('结束')
                        }
                    })
                }, function(){
                    // 事务回调
                });


}

//关闭子页面，返回父页面
function CloseWin(){
    parent.location.reload(); // 父页面刷新
    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
    parent.layer.close(index); //再执行关闭
}

// +----------------------------------------------------------------------
// | 点击编辑，跳转编辑页面（在父页面展示子页面，子页面可关闭）
// +----------------------------------------------------------------------

function editButton(id) {
    // var tr_s = $(obj).parent().parent();//获取到tr元素
    // var data_id = tr_s.find("td:eq(0)").children(":radio").val();//定位到第一个radio的元素获取隐藏的主键
    course_tab_show('编辑数据','./gotoEditPage?data_id='+id);//打开修改的基本信息层
}


function course_tab_show(title,url,w,h){
    if (title == null || title == '') {
        title=false;
    };
    if (url == null || url == '') {
        url="404.html";
    };
    if (w == null || w == '') {
        w=($(window).width()*0.90);
    };
    if (h == null || h == '') {
        h=($(window).height()-50);
    };
    layer.open({
        type: 2,
        area: [w+'px', h +'px'],
        fix: false, //不固定
        maxmin: true,
        shadeClose: true,
        shade:0.4,
        title: title,
        content: url
    });
}
