// +----------------------------------------------------------------------
// |分页查询操作
// +----------------------------------------------------------------------
function queryUserList(){
    $.ajax({
        url:"/getUserList",
        data:$("#queryUserForm").serialize(),
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

    var userList = pageInfo.list;
    $("#userTable").html("");//清空表格中数据并重新填充数据
    for(var i=0,length_1 =userList.length;i<length_1;i++){
        var index = (pageNum - 1) * pageSize + i + 1;
        var tr = "<tr><td>"+'<input type="radio" name="trainshemeRadio" value="'+userList[i].id+'"><input type="hidden" value="'+userList[i].id+'"/></td>'
            +'<td>'+index+'</td>'
            +'<td>'+userList[i].username+'</td>'
            +'<td>'+loadState(userList[i].isAble)+'</td>'
            +'<td>'
            +'<button onclick="editButton('+userList[i].id+')" type="button" style="background-color: #01AAED" class="layui-btn layui-btn-xs layui-btn-danger"  dw-title="账号状态"><i class="layui-icon">&#xe642;</i>状态</button>'
            +'</td></tr>'
        $("#userTable").append(tr);
    }

    startPage(total,pageNum,pageSize,pages);
}

//isAble字段，0/1转中文
function loadState(isAble) {
    switch (isAble) {
        case 0:
            return "禁用";
        case 1:
            return "可用";
        default:
            return "";
    }
}
//先初始化加载首页
queryUserList();

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
                // obj包含了当前分页的所有参数，比如：
                // console.log(obj.curr); //得到当前页，以便向服务端请求对应页的数据。
                // console.log(obj.limit); //得到每页显示的条数

                if (!first) {//首次不执行(点击的时候才执行)
                    //清空以前加载的数据
                    $("#userTable").empty();

                    $("[name='pageNum']").val(obj.curr);//向隐藏域设置当前页的值
                    $("[name='pageSize']").val(obj.limit);//向隐藏域设置当前页的大小
                    //调用加载函数加载数据
                    queryUserList();
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
    queryUserList();//分页查询课程信息
}


/**
 * 前往编辑页面
 * @param id
 */
function editButton(id) {
    course_tab_show('状态编辑','./gotoUserState?user_id='+id);
}

function course_tab_show(title,url){
    layui.use("layer",function() {

        layer.open({
            type: 2,
            area: ['500px', '400px'],  //弹出层页面比例
            fix: false, //不固定
            maxmin: true,
            shadeClose: true,
            shade: 0.4,
            title: title,
            content: url
        });
    });
}