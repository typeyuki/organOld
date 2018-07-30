/**
 * Created by netlab606 on 2018/4/2.
 */
$(document).ready(function(){
    var table =$(".dataTables-example").dataTable(
        {
            "sPaginationType": "full_numbers",
            "bPaginite": true,
            "bInfo": true,
            "bSort": true,
            "bFilter": false, //搜索栏
            "bStateSave": true,
            "bProcessing": true, //加载数据时显示正在加载信息
            "bServerSide": true, //指定从服务器端获取数据
            "columns":[{},{
                data:"id"
            },{
                data:"username"
            },{
                data:"password"
            },{
                data:"roleDesc"
            },{
              data:"organName"
            },{
                data:"status"
            },{
                data:"time"
            }
            ],
            "order":[[0,"asc"]],
            "columnDefs": [
                // 列样式
                {
                    "targets": [0], // 目标列位置，下标从0开始
                    "data": "id", // 数据列名
                    "render": function(data, type, full) { // 返回自定义内容
                        return"<input type='checkbox' name='id' value='"+data+"'/>"
                    }
                },
                // 增加一列，包括删除和修改，同时将我们需要传递的数据传递到链接中
                {
                    "targets": [8], // 目标列位置，下标从0开始
                    "data": "id", // 数据列名
                    "render": function(data, type, full) { // 返回自定义内容
                        return "<span class='btn btn-primary' onclick='editUser("+data+")'>修改</span>";
                    }
                },
                //不进行排序的列
                { "bSortable": false, "aTargets": [0,1,2,3,4,5,6,7,8] }
            ],
            "sAjaxSource": "/user/data",//这个是请求的地址
            "fnServerData": retrieveData
        });
    function retrieveData(url, aoData, fnCallback) {
        $.ajax({
            url: url,//这个就是请求地址对应sAjaxSource
            data : {
                "iDisplayStart" : aoData.iDisplayStart,
                "iDisplayLength" : aoData.iDisplayLength,
                "iSortCol_0" : aoData.iSortCol_0,
                "sEcho" : aoData.sEcho,
                "sSortDir_0" : aoData.sSortDir_0,
                "search" : $('.search').val(),
                "role":$("select[name='role']").val(),
                "disable":$("select[name='disable']").val()
            },
            type: 'POST',
            dataType: 'json',
            async: false,
            success: function (result) {
                fnCallback(result);//把返回的数据传给这个方法就可以了,datatable会自动绑定数据的
            },
            error:function(XMLHttpRequest, textStatus, errorThrown) {
                // alert("status:"+XMLHttpRequest.status+",readyState:"+XMLHttpRequest.readyState+",textStatus:"+textStatus);
            }
        });
    }

    $('#search').click(function () {
        table.fnFilter();
    });

    var oTable=$("#editable").dataTable();
    oTable.$("td").editable("",{
        "callback":function(sValue,y){var aPos=oTable.fnGetPosition(this);oTable.fnUpdate(sValue,aPos[0],aPos[1])},
        "submitdata":function(value,settings){return{"row_id":this.parentNode.getAttribute("id"),
            "column":oTable.fnGetPosition(this)[2]}},"width":"90%","height":"100%"});

});


function add() {
    $(".organ").hide();
    $("#editModal small").html("添加");
    $("#subBtn").html("添加");
    $("#userForm").attr("action","/user/save");
    $("#editModal").modal();
}

function editUser(id) {
    $(".organ").hide();
    $("#editModal small").html("修改");
    $("#subBtn").html("修改");
    $("#userForm").attr("action","/user/update");
    $("#editModal input[name='id']").val(id);
    $("#editModal").modal();
    $.ajax({
        url: "/user/" + id + "/getById",
        type: "get",
        success: function (result) {
            var data = result.data;
            for(key in data) {
                $("#editModal input[name='" + key + "']").val(data[key]);
                $("#editModal select[name='" + key + "'] option[value='" + data[key] + "']").prop("selected", true);
            }
            if($("select[name='roleId']").find("option:selected").attr("type")!="0"){
                $("select[name='organId']").html("");
                $(".organ").show();

                $.ajax({
                    url: "/user/getRoleOrgan",
                    data : {
                        "type":$("select[name='roleId']").find("option:selected").attr("type"),
                        "typeIndex":$("select[name='roleId']").find("option:selected").attr("index")
                    },
                    type: 'POST',
                    dataType: 'json',
                    success: function (result_2) {
                        if(result_2.success==true){
                            for(var i=0;i<result_2.data.length;i++){
                                var op;
                                if(result_2.data[i].id==data.organId){
                                    op=$("<option value='"+result_2.data[i].id+"' selected>"+result_2.data[i].name+"</option>");
                                }else{
                                    op=$("<option value='"+result_2.data[i].id+"'>"+result_2.data[i].name+"</option>");
                                }
                                $("select[name='organId']").append(op)
                            }
                        }
                    }
                });
                if(data.authProduct==1){
                    $("#editModal input[value='product']").prop("checked",true);
                }
                if(data.authConsume==1){
                    $("#editModal input[value='consume']").prop("checked",true);
                }
                if(data.authSign==1){
                    $("#editModal input[value='sign']").prop("checked",true);
                }
                if(data.authQueryInfo==1){
                    $("#editModal input[value='info']").prop("checked",true);
                }
                if(data.authQueryIntegral==1){
                    $("#editModal input[value='integral']").prop("checked",true);
                }
            }else{

                $(".organ").hide();

            }
        }
    });


}