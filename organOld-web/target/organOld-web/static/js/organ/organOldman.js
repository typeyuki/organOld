/**
 * Created by netlab606 on 2018/4/2.
 */
$(document).ready(function(){
    var columns=[];
    var order=[];
    var columnDefs=[];
    if(single=="single"){
        columns=[{},{
            data:"oldmanId"
        },{
            data:"oldmanName"
        },{
            data:"num"
        },{
            data:"timeIn"
        },{
            data:"timeOut"
        },{
            data:"applyTime"
        },{
            data:"time"
        }
        ];
        order=[[1,"asc"]];
        columnDefs=[
            // 列样式
            {
                "targets": [0], // 目标列位置，下标从0开始
                "data": "id", // 数据列名
                "render": function(data, type, full) { // 返回自定义内容
                    return"<input type='checkbox' name='id' value='"+data+"' />"
                }
            },
            {
                "targets": [3], // 目标列位置，下标从0开始
                "data": "num", // 数据列名
                "render": function(data, type, full) { // 返回自定义内容
                    if(data=="0"){
                        return "排队中";
                    }else{
                        return data;
                    }
                }
            },
            // 增加一列，包括删除和修改，同时将我们需要传递的数据传递到链接中
            {
                "targets": [8], // 目标列位id置，下标从0开始
                "data": "", // 数据列名
                "render": function(data, type, full) { // 返回自定义内容
                    return "<span class='btn btn-primary' onclick='edit("+data+")'>修改</span>";
                }
            },
            //不进行排序的列
            { "bSortable": false, "aTargets": [ 0,2 ,3, 4,5,6,7,8] }
        ];
    }else{
        columns=[{
            data:"oldmanId"
        },{
            data:"oldmanName"
        },{
            data:"num"
        },{
            data:"timeIn"
        },{
            data:"timeOut"
        },{
            data:"applyTime"
        },{
            data:"time"
        }
        ];
        order=[[0,"asc"]];
        columnDefs=[
            // 列样式
            {
                "targets": [2], // 目标列位置，下标从0开始
                "data": "num", // 数据列名
                "render": function(data, type, full) { // 返回自定义内容
                    if(data=="0"){
                        return "排队中";
                    }else{
                        return data;
                    }
                }
            },
            // 增加一列，包括删除和修改，同时将我们需要传递的数据传递到链接中
            {
                "targets": [7], // 目标列位置，下标从0开始
                "data": "oldmanId", // 数据列名
                "render": function(data, type, full) { // 返回自定义内容
                    return "<button class='btn btn-primary'  onclick=newPage("+data+",$(this).parent().prev().prev().prev().prev().prev().prev().text(),'/oldman/"+data+"/info')>查看</button>";
                }
            },
            //不进行排序的列
            { "bSortable": false, "aTargets": [ 1,2 ,3, 4,5,6,7] }
        ];
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
            "order":order,
            "columnDefs": columnDefs,
            "sAjaxSource": dataUrl,//这个是请求的地址
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
                "organId" : organId,
                "search" : $('.search').val(),
                "isPd":$("select[name='isPd']").val(),
                "isExist":$("select[name='isExist']").val()
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
    $(".searchable-select").show();
    $(".searchable-select").attr("name","oldmanId");
    $(".oldmanId").attr("name","");
    $(".id").attr("name","");
    $('#addModal').modal();
    $('#addModal form').attr("action","/organ/oldman/add");
}

function edit(id) {
    $(".searchable-select").hide();
    $(".searchable-select").attr("name","");
    $(".id").attr("name","id");
    $(".oldmanId").attr("name","oldmanId");
    $('#addModal form').attr("action","/organ/oldman/update");
    $.ajax({
        url: "/organ/oldman/"+id+"/getById",
        type: "get",
        async:false,
        success: function (result) {
            var data=result.data;
            for(key in data){
                $("#editModal input[name='"+key+"']").val(data[key]);
            }

            $("#addModal").modal();
        }
    });
}

function thCheck(obj) {
    thCheckByName(obj,"id");
}


function thCheckByName(obj,name) {
    if($(obj).is(':checked')){
        $("input[name="+name+"]").prop("checked",true);
    }else{
        $("input[name="+name+"]").prop("checked",false);
    }
}

function del(url) {
    var ids=[];
    $("input[name='id']:checked").each(function () {
        ids.push($(this).val());
    });

    $.ajax({
        url : url,
        type : "post",
        dataType : 'json',
        data:{
            ids:ids
        },
        success : function(data) {
            if (data.success==true) {
                var start = $(".dataTables-example").dataTable().fnSettings()._iDisplayStart;
                var total = $(".dataTables-example").dataTable().fnSettings().fnRecordsDisplay();
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