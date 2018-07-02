/**
 * Created by netlab606 on 2018/4/2.
 */
var table;
$(document).ready(function(){
    table =$(".dataTables-example").dataTable(
        {
            "sPaginationType": "full_numbers",
            "bPaginite": true,
            "bInfo": true,
            "bSort": true,
            "bFilter": false, //搜索栏
            "bStateSave": true,
            "bProcessing": true, //加载数据时显示正在加载信息
            "bServerSide": true, //指定从服务器端获取数据
            "columns":[{
                data:"oldmanId"
            },{},{
                data:"goal"
            },{}
            ],
            "order":[[0,"asc"]],
            "columnDefs": [
                {
                    "targets": [1], // 目标列位置，下标从0开始
                    "data": "oldmanNameKeyStatus", // 数据列名
                    "render": function(data, type, full) { // 返回自定义内容
                        var name=data.split("#")[0];
                        var status=data.split("#")[1];
                        if(status=="4"){
                            return "<span style='background-color: red;color: white;padding: 5px'>"+name+"</span>";
                        }else if(status=="3"){
                            return "<span style='background-color: grey;color: white;padding: 5px'>"+name+"</span>";
                        }else {
                            return "<span>"+name+"</span>";
                        }
                    }
                },
                // 增加一列，包括删除和修改，同时将我们需要传递的数据传递到链接中
                {
                    "targets": [3], // 目标列位置，下标从0开始
                    "data": "oldmanId", // 数据列名
                    "render": function(data, type, full) { // 返回自定义内容
                        return "<span class='look' id='"+data+"'>查看</span>";
                    }
                },
                //不进行排序的列
                { "bSortable": false, "aTargets": [0,1,2,3] }
            ],
            "sAjaxSource": "/oldman/key/data",//这个是请求的地址
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
                "future":$("input[name=future]").val()
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


function autoUpdate(open,obj) {
    if(open){
        $.ajax({
            url: "/oldman/key/autoUpdate",
            data : {
                open:true
            },
            type: 'POST',
            dataType: 'json',
            success: function (result) {
               $(obj).attr("onclick","autoUpdate(false,this)").html("关闭自动更新");
            },
            error:function(XMLHttpRequest, textStatus, errorThrown) {

            }
        });
    }else{
        $.ajax({
            url: "/oldman/key/autoUpdate",
            data : {
                open:false
            },
            type: 'POST',
            dataType: 'json',
            success: function (result) {
                $(obj).attr("onclick","autoUpdate(true,this)").html("开启自动更新");
            },
            error:function(XMLHttpRequest, textStatus, errorThrown) {

            }
        });
    }
}

function update(type) {
    var data;
    if(type=="future"){
        data={
            futureTime:$("#futureTime").val()
        };
        $("#goal").html($("#futureTime").val()+" 分数");
    }else{
        data={};
        $("#goal").html("分数");
    }
    $.ajax({
        url: "/oldman/key/update",
        data : data,
        type: 'POST',
        dataType: 'json',
        success: function (result) {
            alert("更新完成");
            if (result.data=="future"){
                $("input[name=future]").val("1");
            }else{
                $("input[name=future]").val("");
            }
            // alert(1);
            table.fnFilter();
        },
        error:function(XMLHttpRequest, textStatus, errorThrown) {

        }
    });
}