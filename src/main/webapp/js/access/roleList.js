// +----------------------------------------------------------------------
// |分页查询操作
// +----------------------------------------------------------------------
function queryRoleList(){
    $.ajax({
        url:"/getRoleList",
        data:$("#queryRoleForm").serialize(),
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

    var roleList = pageInfo.list;
    $("#roleTable").html("");//清空表格中数据并重新填充数据
    for(var i=0,length_1 =roleList.length;i<length_1;i++){
        var index = (pageNum - 1) * pageSize + i + 1;
        var tr = "<tr><td>"+'<input type="radio" name="trainshemeRadio" value="'+roleList[i].id+'"><input type="hidden" value="'+roleList[i].id+'"/></td>'
            +'<td>'+index+'</td>'
            +'<td>'+roleList[i].roleName+'</td>'
            +'<td>'+roleList[i].role+'</td>'
            +'<td>'+roleList[i].roleDescribe+'</td>'
            +'<td>'
            +'<button onclick="editButton('+roleList[i].id+')" type="button" style="background-color: #01AAED" class="layui-btn layui-btn-xs layui-btn-danger"  dw-title="编辑用户"><i class="layui-icon">&#xe642;</i>编辑</button>'
            +'<button onclick="deleteButton('+roleList[i].id+')"  class="layui-btn layui-btn-xs layui-btn-danger " ><i class="layui-icon">&#xe640;</i>删除</button>'
            +'</td></tr>'
        $("#roleTable").append(tr);
    }

    startPage(total,pageNum,pageSize,pages);
}

//先初始化加载首页
queryRoleList();

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
                    $("#roleTable").empty();

                    $("[name='pageNum']").val(obj.curr);//向隐藏域设置当前页的值
                    $("[name='pageSize']").val(obj.limit);//向隐藏域设置当前页的大小
                    //调用加载函数加载数据
                    queryRoleList();
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
    queryRoleList();//分页查询课程信息
}