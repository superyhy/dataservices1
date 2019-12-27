// +----------------------------------------------------------------------
// |分页查询操作
// +----------------------------------------------------------------------
function queryUserAccessList(){
    $.ajax({
        url:"/queryUserAccessList",
        data:$("#queryUserAccessForm").serialize(),
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

    var userAccessList = pageInfo.list;
    $("#userAccessTable").html("");//清空表格中数据并重新填充数据
    for(var i=0,length_1 =userAccessList.length;i<length_1;i++){
        var index = (pageNum - 1) * pageSize + i + 1;
        var tr = "<tr><td>"+'<input type="radio" name="trainshemeRadio" value="'+userAccessList[i].id+'"><input type="hidden" value="'+userAccessList[i].id+'"/></td>'
            +'<td>'+index+'</td>'
            +'<td>'+userAccessList[i].userName+'</td>'
            +'<td>'+userAccessList[i].roleName+'</td>'
            +'<td>'+userAccessList[i].role+'</td>'
            +'<td>'+userAccessList[i].roleDescribe+'</td>'
            +'<td>'
            +'<button onclick="editButton('+userAccessList[i].id+')" type="button" style="background-color: #01AAED" class="layui-btn layui-btn-xs layui-btn-danger"  dw-title="用户权限"><i class="layui-icon">&#xe642;</i>权限</button>'
            +'</td></tr>'
        $("#userAccessTable").append(tr);
    }

    startPage(total,pageNum,pageSize,pages);
}

//先初始化加载首页
queryUserAccessList();

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
                    $("#userAccessTable").empty();

                    $("[name='pageNum']").val(obj.curr);//向隐藏域设置当前页的值
                    $("[name='pageSize']").val(obj.limit);//向隐藏域设置当前页的大小
                    //调用加载函数加载数据
                    queryUserAccessList();
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
    queryUserAccessList();//分页查询课程信息
}

// +----------------------------------------------------------------------
// | 点击编辑，跳转编辑页面（在父页面展示子页面，子页面可关闭）
// +----------------------------------------------------------------------

function editButton(id) {
    // var tr_s = $(obj).parent().parent();//获取到tr元素
    // var data_id = tr_s.find("td:eq(0)").children(":radio").val();//定位到第一个radio的元素获取隐藏的主键
    course_tab_show('用户权限','./gotoUserAccessEdit?role_id='+id);//打开修改的基本信息层
}


function course_tab_show(title,url,w,h){
    if (title == null || title == '') {
        title=false;
    };
    if (url == null || url == '') {
        url="404.html";
    };
    if (w == null || w == '') {
        w=($(window).width()*0.40);
    };
    if (h == null || h == '') {
        h=($(window).height()-200);
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
