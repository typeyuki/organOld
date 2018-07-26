/**
 * Created by netlab606 on 2018/4/2.
 */
$(document).ready(function(){
    var columns=[];
    var columnDefs=[];
    if(typeHome==1 || typeHome==3){
        columns=[{},{
            data:"id"
        },{
            data:"secType"
        },{
            data:"time"
        }
        ];
        columnDefs= [
            // 列样式
            {
                "targets": [0], // 目标列位置，下标从0开始
                "data": "id", // 数据列名
                "render": function(data, type, full) { // 返回自定义内容
                    return"<input type='checkbox' name='id' value='"+data+"' />"
                }
            },
            // 增加一列，包括删除和修改，同时将我们需要传递的数据传递到链接中
            {
                "targets": [4], // 目标列位置，下标从0开始
                "data": "id", // 数据列名
                "render": function(data, type, full) { // 返回自定义内容
                    return "<span class='btn btn-primary' onclick=newPage("+data+",$(this).parent().prev().prev().text(),'/home/"+typeHome+"/"+data+"/man')  id='"+data+"'>人员</span><span class='btn btn-primary' onclick='editHome("+data+")'>修改</span>";
                }
            }
        ]
    }else if(typeHome==4){
        columns=[{},{
            data:"id"
        },{
            data:"doctorName"
        },{},{
            data:"time"
        }
        ];
        columnDefs= [
            // 列样式
            {
                "targets": [0], // 目标列位置，下标从0开始
                "data": "id", // 数据列名
                "render": function(data, type, full) { // 返回自定义内容
                    return"<input type='checkbox'name='id' value='"+data+"' />"
                }
            },{
                "targets": [3], // 目标列位置，下标从0开始
                "data": "organ", // 数据列名
                "render": function(data, type, full) { // 返回自定义内容
                    return "<button class='btn btn-primary' onclick=newPage("+data.id+",'"+data.name+"','/organ/"+data.id+"/info?look=true')>"+data.name+"</button>";
                }
            },
            // 增加一列，包括删除和修改，同时将我们需要传递的数据传递到链接中
            {
                "targets": [5], // 目标列位置，下标从0开始
                "data": "id", // 数据列名
                "render": function(data, type, full) { // 返回自定义内容
                    return "<span class='btn btn-primary' onclick=newPage("+data+",$(this).parent().prev().prev().prev().text(),'/home/"+typeHome+"/"+data+"/man') id='"+data+"'>人员</span><span class='btn btn-primary'  onclick='editHome("+data+")'>修改</span>";
                }
            }
        ]
    }else if(typeHome==2){
        columns=[{},{
            data:"id"
        },{
            data:"level"
        },{
            data:"serviceTime"
        },{
            data:"time"
        }
        ];
        columnDefs= [
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
                "targets": [5], // 目标列位置，下标从0开始
                "data": "id", // 数据列名
                "render": function(data, type, full) { // 返回自定义内容
                    return "<span class='btn btn-primary' onclick=newPage("+data+",$(this).parent().prev().prev().prev().text(),'/home/"+typeHome+"/"+data+"/man')  id='"+data+"'>人员</span><span class='btn btn-primary'  onclick='editHome("+data+")'>修改</span>";
                }
            }
        ]
    }else if(typeHome==5){
        columns=[{},{
            data:"id"
        },{},{
            data:"time"
        }
        ];
        columnDefs= [
            // 列样式
            {
                "targets": [0], // 目标列位置，下标从0开始
                "data": "id", // 数据列名
                "render": function(data, type, full) { // 返回自定义内容
                    return"<input type='checkbox' name='id' value='"+data+"' />"
                }
            },{
                "targets": [2], // 目标列位置，下标从0开始
                "data": "organ", // 数据列名
                "render": function(data, type, full) { // 返回自定义内容
                    return "<button class='btn btn-primary' onclick=newPage("+data.id+",'"+data.name+"','/organ/"+data.id+"/info?look=true')>"+data.name+"</button>";
                }
            },
            // 增加一列，包括删除和修改，同时将我们需要传递的数据传递到链接中
            {
                "targets": [4], // 目标列位置，下标从0开始
                "data": "id", // 数据列名
                "render": function(data, type, full) { // 返回自定义内容
                    return "<span class='btn btn-primary' onclick=newPage("+data+",$(this).parent().prev().prev().text(),'/home/"+typeHome+"/"+data+"/man') id='"+data+"'>人员</span><span class='btn btn-primary'  onclick='editHome("+data+")'>修改</span>";
                }
            }
        ]
    }

    var table =$(".dataTables-example").dataTable(
        {
            "sPaginationType": "full_numbers",
            "bPaginite": true,
            "bInfo": true,
            "bSort": false,
            "bFilter": false, //搜索栏
            "bStateSave": true,
            "bProcessing": true, //加载数据时显示正在加载信息
            "bServerSide": true, //指定从服务器端获取数据
            "columns":columns,
            "columnDefs": columnDefs,
            "sAjaxSource": "/home/data",//这个是请求的地址
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
                "firType" : typeHome,
                "status":status
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


function addHome() {
    $("#editModal small").html("添加");
    $("#subBtn").html("添加");
    $("#homeForm").attr("action","/home/add");
    $("#editModal").modal();
}

function editHome(id) {
    $("#editModal small").html("修改");
    $("#subBtn").html("修改");
    $("#homeForm").attr("action","/home/update");
    oldman_edit(id,"/home/"+typeHome+"/"+id+"/getById");
}