/**
 * Created by netlab606 on 2018/4/2.
 */
$(document).ready(function(){
    //这个方法用来启动该页面的ReverseAjax功能
    dwr.engine.setActiveReverseAjax(true);
    //设置在页面关闭时，通知服务端销毁会话
    dwr.engine.setNotifyServerOnPageUnload(true);


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
            "columns":[{},{
                data:"cid"
            },{},{
                data:"password"
            },{
                data:"money"
            },{
              data:"status"
            },{
                data:"isCreate"
            },{
                data:"time"
            }
            ],
            "columnDefs": [
                // 列样式
                {
                    "targets": [0], // 目标列位置，下标从0开始
                    "data": "id", // 数据列名
                    "render": function(data, type, full) { // 返回自定义内容
                        return"<input type='checkbox' name='id' value='"+data+"'/>"
                    }
                },
                {
                    "targets": [2], // 目标列位置，下标从0开始
                    "data": "oldman", // 数据列名
                    "render": function(data, type, full) { // 返回自定义内容
                        return data.name;
                    }
                },
                // 增加一列，包括删除和修改，同时将我们需要传递的数据传递到链接中
                {
                    "targets": [8], // 目标列位置，下标从0开始
                    "data": "id", // 数据列名
                    "render": function(data, type, full) { // 返回自定义内容
                        return "<span class='btn btn-primary' onclick=newPage("+data+",$(this).parent().prev().prev().prev().prev().prev().prev().text(),'/card/"+data+"/record')>查看记录</span>"+
                            "<span class='btn btn-primary' onclick=oldman_edit(753,'/card/"+data+"/getById')>修改</span>";
                    }
                }
            ],
            "sAjaxSource": "/card/data",//这个是请求的地址
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
                "search":$("input[name='search']").val(),
                "status":$("select[name='status']").val(),
                "isCreate":$("select[name='isCreate']").val()
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

function changeStatus(status) {
    var ids=[];
    $("input[name='id']:checked").each(function () {
        ids.push($(this).val());
    });
    $.ajax({
        url : "/card/changeStatus/"+status,
        type : "post",
        dataType : 'json',
        data:{
            ids:ids
        },
        success : function(data) {
            if (data.success==true) {
                tableUpdate();
            } else {
                alert('充值失败！');
            }
        }
    });
}


function createCode() {
    $('.wrapper').hide();$('#process').show();
    $(".f").submit();
    // var ids=[];
    // $("input[name='id']:checked").each(function () {
    //     ids.push($(this).val());
    // });
    // $.ajax({
    //     url : "/card/create",
    //     type : "post",
    //     dataType : 'json',
    //     data:{
    //         ids:ids
    //     },
    //     success : function(data) {
    //         if (data.success==true) {
    //             alert("一共操作："+data.data.total+"个老人\n其中共："+data.data.numSuccess+"个老人未生成二维码\n已生成数："+data.data.successAdd+"\n失败数："+data.data.numFail);
    //             var start = $(".dataTables-example").dataTable().fnSettings()._iDisplayStart;
    //             var total = $(".dataTables-example").dataTable().fnSettings().fnRecordsDisplay();
    //             window.location.reload();
    //             if(total-start==1){
    //                 if(start>0){
    //                     $(".dataTables-example").dataTable().fnPageChange('previous',true);
    //                 }
    //             }
    //         } else {
    //             alert('删除失败！');
    //         }
    //     }
    // });
}

function finishZip(data) {
    $('#process').hide();
    $('.wrapper').show();
    alert("下载成功：\n一共："+data.data.total+"个老人\n生成："+data.data.numSuccess+"张卡");

    var start = $(".dataTables-example").dataTable().fnSettings()._iDisplayStart;
    var total = $(".dataTables-example").dataTable().fnSettings().fnRecordsDisplay();
    window.location.reload();
    if(total-start==1){
        if(start>0){
            $(".dataTables-example").dataTable().fnPageChange('previous',true);
        }
    }
}