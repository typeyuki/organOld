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
            "columns":[{},{},{
                data:"typeName"
            },{
                data:"content"
            },{},{
                data:"time"
            }
            ],
            "order":[[0,"asc"]],
            "columnDefs": [
                // 列样式
                {
                    "targets": [0], // 目标列位置，下标从0开始
                    "data": "idAndIsRead", // 数据列名
                    "render": function(data, type, full) { // 返回自定义内容
                        var id=data.split("#")[0];
                        var read=data.split("#")[1];
                        if(read=="1")
                        return"<input type='checkbox' class='read' />";
                        else return"<input type='checkbox' class='noRead' />";
                    }
                },
                {
                    "targets": [1], // 目标列位置，下标从0开始
                    "data": "idAndIsRead", // 数据列名
                    "render": function(data, type, full) { // 返回自定义内容
                        return data.split("#")[0];
                    }
                },
                {
                    "targets": [4], // 目标列位置，下标从0开始
                    "data": "organ", // 数据列名
                    "render": function(data, type, full) { // 返回自定义内容
                        if(data!=null) return "<span class='btn btn-primary' onclick=newPage("+data.id+",'"+data.name+"','/organ/"+data.id+"/info?look=true')>"+data.name+"</span>";
                        else return "";
                    }
                },
                //不进行排序的列
                { "bSortable": false, "aTargets": [ 0,1,2,3,4,5] }
            ],
            "sAjaxSource": "/message/data",//这个是请求的地址
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
                "type":$("select[name='type']").val()
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

    $(".noRead").parent().parent().attr("class","odd");
    $(".read").parent().parent().attr("class","even");


    $.ajax({
        url: "/message/read",
        type: 'GET',
        success: function (result) {
        }
    });


    var oTable=$("#editable").dataTable();
    oTable.$("td").editable("",{
        "callback":function(sValue,y){var aPos=oTable.fnGetPosition(this);oTable.fnUpdate(sValue,aPos[0],aPos[1])},
        "submitdata":function(value,settings){return{"row_id":this.parentNode.getAttribute("id"),
            "column":oTable.fnGetPosition(this)[2]}},"width":"90%","height":"100%"});

});

