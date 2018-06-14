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
            "columns":[{
                data:"oldmanId"
            },{
                data:"name"
            },{
                data:"bloodType"
            },{
                data:"intelligence"
            },{
                data:"eyesight"
            },{},{},{},{},{},{},{
                data:"time"
            }
            ],
            "order":[[0,"asc"]],
            "columnDefs": [
                // 列样式
                {
                    "targets": [5], // 目标列位置，下标从0开始
                    "data": "selectMb", // 数据列名
                    "render": function(data, type, full) { // 返回自定义内容
                        if(data!=undefined && data.length>0){
                            var s="";
                            for(var i=0;i<data.length;i++){
                                s+="<span class='select'>" + data[i].secTypeName + "</span>";
                            }
                            return s;
                        }else{
                            return "无";
                        }
                    }
                },
                {
                    "targets": [6], // 目标列位置，下标从0开始
                    "data": "selectSn", // 数据列名
                    "render": function(data, type, full) { // 返回自定义内容
                        if(data!=undefined && data.length>0){
                            var s="";
                            for(var i=0;i<data.length;i++){
                                s+="<span class='select'>" + data[i].secTypeName + "</span>";
                            }
                            return s;
                        }else{
                            return "无";
                        }
                    }
                },
                {
                    "targets": [7], // 目标列位置，下标从0开始
                    "data": "selectYwfy", // 数据列名
                    "render": function(data, type, full) { // 返回自定义内容
                        if(data!=undefined && data.length>0){
                            var s="";
                            for(var i=0;i<data.length;i++){
                                s+="<span class='select'>" + data[i].secTypeName + "</span>";
                            }
                            return s;
                        }else{
                            return "无";
                        }
                    }
                },
                {
                    "targets": [8], // 目标列位置，下标从0开始
                    "data": "addExzl", // 数据列名
                    "render": function(data, type, full) { // 返回自定义内容
                        if(data!=undefined && data.length>0){
                            var s="";
                            for(var i=0;i<data.length;i++){
                                s+="<p class='add'>" + data[i].desc + "</p>";
                            }
                            return s;
                        }else{
                            return "无";
                        }
                    }
                },{
                    "targets": [9], // 目标列位置，下标从0开始
                    "data": "addGz", // 数据列名
                    "render": function(data, type, full) { // 返回自定义内容
                        if(data!=undefined && data.length>0){
                            var s="";
                            for(var i=0;i<data.length;i++){
                                s+="<p class='add'>" + data[i].desc + "</p>";
                            }
                            return s;
                        }else{
                            return "无";
                        }
                    }
                },{
                    "targets": [10], // 目标列位置，下标从0开始
                    "data": "addCj", // 数据列名
                    "render": function(data, type, full) { // 返回自定义内容
                        if(data!=undefined && data.length>0){
                            var s="";
                            for(var i=0;i<data.length;i++){
                                s+="<p class='add'>" + data[i].desc + "</p>";
                            }
                            return s;
                        }else{
                            return "无";
                        }
                    }
                },
                // 增加一列，包括删除和修改，同时将我们需要传递的数据传递到链接中
                {
                    "targets": [12], // 目标列位置，下标从0开始
                    "data": "oldmanId", // 数据列名
                    "render": function(data, type, full) { // 返回自定义内容
                        return "<span class='mod' id='"+data+"'>修改</span>";
                    }
                },
                //不进行排序的列
                { "bSortable": false, "aTargets": [ 0,1,2 ,3, 4,5, 6,7,8,9,10,12] }
            ],
            "sAjaxSource": "/oldman/healthData",//这个是请求的地址
            "fnServerData": retrieveData
            // "fnServerParams": function (aoData) {  //查询条件
            //     aoData.push(
            //         { "name": "id", "value": $('.id').val() },
            //         { "name": "sex", "value": $('.sex').val() },
            //         { "name": "age", "value": $('.age').val() },
            //         { "name": "time", "value": $('.time').val() }
            //     );
            // }
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
                "oldmanId" : ($('.oldmanId').val()==""?"0":$('.oldmanId').val()),//参数不能是空 400
                "search" : $('.search').val()
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
