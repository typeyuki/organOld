/**
 * Created by netlab606 on 2018/4/2.
 */
var label=[];//用于标签页面
var table;

var iDisplayLength=8;

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
                data:"name"
            },{
                data:"sex"
            },{
                data:"age"
            },{
                data:"pid"
            },{
                data:"pq"
            },{
                data:"jw.name"
            }
            ,{
                data:"address"
            }
            ],
            "iDisplayLength" : iDisplayLength,
            "order":[[0,"asc"]],
            "columnDefs": [
                // 列样式
                {
                    "targets": [0], // 目标列位置，下标从0开始
                    "data": "name", // 数据列名
                    "render": function(data, type, full) { // 返回自定义内容
                        if(data!=undefined){
                            return "<span class='name'>" + data + "</span>";
                        }else{
                            return "";
                        }
                    }
                },
                {
                    "targets": [4], // 目标列位置，下标从0开始
                    "data": "pq", // 数据列名
                    "render": function(data, type, full) { // 返回自定义内容
                        return "东兰";
                    }
                },
                //不进行排序的列
                { "bSortable": false, "aTargets": [1,3,4,5] }
            ],
            "sAjaxSource": "/oldman/baseData/visual",//这个是请求的地址
            "fnServerData": retrieveData,
            "fnServerParams": function (aoData) {  //查询条件
                aoData.push(
                    { "name": "name", "value": $('.name').val() },
                    { "name": "sex", "value": $('.sex').val() },
                    { "name": "age", "value": $('.age').val() },
                    { "name": "address", "value": $('.address').val() },
                    { "name": "jw.name", "value": $('.jw').val() },
                    { "name": "label", "value": label}
                );
            }
        });
    function retrieveData(url, aoData, fnCallback) {
        $.ajax({
            url: url,//这个就是请求地址对应sAjaxSource
            data : {
                "aoData" : JSON.stringify(aoData)
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


    $("#DataTables_Table_0").prev().css("display","none");

    $(".dataTables_paginate").css("width","130%");

    var oTable=$("#editable").dataTable();
    oTable.$("td").editable("",{
        "callback":function(sValue,y){var aPos=oTable.fnGetPosition(this);oTable.fnUpdate(sValue,aPos[0],aPos[1])},
        "submitdata":function(value,settings){return{"row_id":this.parentNode.getAttribute("id"),
            "column":oTable.fnGetPosition(this)[2]}},"width":"90%","height":"100%"});
});

function del(id) {
    $.ajax({
        url : "/oldman/base/del",
        type : "post",
        dataType : 'json',
        data:{
            id:id
        },
        success : function(data) {
            if (data.success==true) {
                start = $(".dataTables-example").dataTable().fnSettings()._iDisplayStart;
                total = $(".dataTables-example").dataTable().fnSettings().fnRecordsDisplay();
                window.location.reload();
                if(total-start==1){

                    if(start>0){
                        $(".dataTables-example").dataTable().fnPageChange('previous',true);
                    }
                }

            } else {
                alert('删除失败！');
            }
        }
    });
}
