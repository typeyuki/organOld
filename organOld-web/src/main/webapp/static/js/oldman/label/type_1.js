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
                data:"value"
            },{
                data:"timeFormat"
            }
            ],
            "order":[[1,"asc"]],
            "columnDefs": [
                // 增加一列，包括删除和修改，同时将我们需要传递的数据传递到链接中
                {
                    "targets": [0], // 目标列位置，下标从0开始
                    "data": "id", // 数据列名
                    "render": function(data, type, full) { // 返回自定义内容
                        return "<input type='checkbox'>";
                    }
                }, {
                    "targets": [4], // 目标列位置，下标从0开始
                    "data": "id", // 数据列名
                    "render": function (data, type, full) { // 返回自定义内容
                        return "<button class='btn btn-primary' onclick=edit('"+data+"',this)>修改</button>";
                    }
                },
                //不进行排序的列
                { "bSortable": false, "aTargets": [ 0,2,3,4] }
            ],
            "sAjaxSource": "/oldman/label/type/1/data",//这个是请求的地址
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
                "sSortDir_0" : aoData.sSortDir_0
            },
            type: 'POST',
            dataType: 'json',
            async: false,
            success: function (result) {
                fnCallback(result);//把返回的数据传给这个方法就可以了,datatable会自动绑定数据的
            },
            error:function(XMLHttpRequest, textStatus, errorThrown) {
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
    $("#firModal form").attr("action","/oldman/label/type/1/add");
    $("#firModal h5").html("一级标签<small>添加</small>");
    $("#firModal .firSub").html("添加");
    $("#firModal").modal();
}

function edit(id,obj) {
    $("#firModal input[name='id']").val(id);
    $("#firModal input[name='value']").val($(obj).parent().prev().prev().text());
    $("#firModal form").attr("action","/oldman/label/type/1/update");
    $("#firModal h5").html("一级标签<small>修改</small>");
    $("#firModal .firSub").html("保存");
    $("#firModal").modal();
}