/**
 * Created by netlab606 on 2018/4/2.
 */
$(document).ready(function(){
    var columns;
    var columnDefs;
    if(type==1){
        columns=[{
            data:"id"
        },{},{
            data:"time"
        },{
            data:"data"
        }
        ];
        columnDefs=[
            // 列样式
            {
                "targets": [1], // 目标列位置，下标从0开始
                "data": "oldman", // 数据列名
                "render": function(data, type, full) { // 返回自定义内容
                    return data.name
                }
            }
        ];
    }else{
        columns=[{
            data:"id"
        },{},{
            data:"time"
        }
        ];
        columnDefs=[
            // 列样式
            {
                "targets": [1], // 目标列位置，下标从0开始
                "data": "oldman", // 数据列名
                "render": function(data, type, full) { // 返回自定义内容
                    return data.name
                }
            }

        ];
    }
    //全部的
    if(organId==0){
        columns.push({});
        if(type==1){
            columnDefs.push({
                "targets": [4], // 目标列位置，下标从0开始
                "data": "organ", // 数据列名
                "render": function(data, type, full) { // 返回自定义内容
                    return data.name
                }
            });
            columnDefs.push({ "bSortable": false, "aTargets": [1,2,3,4] });
        }else{
            columnDefs.push({
                "targets": [3], // 目标列位置，下标从0开始
                "data": "organ", // 数据列名
                "render": function(data, type, full) { // 返回自定义内容
                    return data.name
                }
            });
            columnDefs.push(columnDefs.push({ "bSortable": false, "aTargets": [1,2,3] }));
        }
    }else{
        if(type==1){
            columnDefs.push({ "bSortable": false, "aTargets": [1,2,3] });
        }else{
            columnDefs.push(columnDefs.push({ "bSortable": false, "aTargets": [1,2] }));
        }
    }


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
            "columns":columns,
            "order":[[0,"asc"]],
            "columnDefs":columnDefs ,
            "sAjaxSource": "/record/data",//这个是请求的地址
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
                "organId":organId,
                "type":type
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
