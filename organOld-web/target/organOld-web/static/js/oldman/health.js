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
                                s+="<p class='add'>" +(i+1)+"."+ data[i].desc + "</p>";
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
                                s+="<p class='add'>" +(i+1)+"."+ data[i].desc + "</p>";
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
                                s+="<p class='add'>" +(i+1)+"."+ data[i].desc + "</p>";
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
                        return "<button class='btn btn-primary' id='"+data+"' onclick=newPage("+data+",$(this).parent().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().text(),'/oldman/"+data+"/info')>查看</button><button onclick='edit_health("+data+")' class='btn btn-primary' id='"+data+"'>修改</button>";
                    }
                },
                //不进行排序的列
                { "bSortable": false, "aTargets": [ 0,1,2 ,3, 4,5, 6,7,8,9,10,12] }
            ],
            "sAjaxSource": "/oldman/healthData",//这个是请求的地址
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

function edit_health(id) {
    $(".searchable-select").remove();
    $("#editModal input[type='checkbox']").prop("checked",false);
    $("#exzl").find("input").remove();
    $("#gz").find("input").remove();
    $("#cj").find("input").remove();
    var url="/oldman/health/"+id+"/getById";
    $.ajax({
        url: url,
        type: "get",
        async:false,
        success: function (result) {
            var data=result.data;
            for(key in data){
                if(key=="oldman"){
                    $("#editModal input[name='oldman.id']").val(data[key].id);
                }else if(key=="healthSelect"){
                    if(data[key]!=null && data[key].length>0){
                        for(var i=0;i<data[key].length;i++){
                            $("#editModal input[name='"+key+"'][type='checkbox'][value='"+data[key][i].id+"']").prop("checked",true);
                        }
                    }
                }else if(key=="healthAdd"){
                    if(data[key]!=null && data[key].length>0){
                        for(var i=0;i<data[key].length;i++){
                            var $input
                            if(data[key][i].type==4){
                                $input=$("<input name='healthAdd_exzl'  class='form-control inp healthAdd' db='"+data[key][i].id+"' value='"+data[key][i].desc+"'/>");
                                $("#exzl").append($input);
                            }else if(data[key][i].type==5){
                                $input=$("<input name='healthAdd_gz'  class='form-control inp healthAdd' db='"+data[key][i].id+"' value='"+data[key][i].desc+"'/>");
                                $("#gz").append($input);
                            }else{
                                $input=$("<input name='healthAdd_cj'  class='form-control inp healthAdd' db='"+data[key][i].id+"' value='"+data[key][i].desc+"'/>");
                                $("#cj").append($input);
                            }
                            $("#editModal input[name='"+key+"'][type='checkbox'][value='"+data[key][i].id+"']").prop("checked",true);
                        }
                    }
                }else{
                    if(data[key]!=null){
                        $("#editModal input[name='"+key+"'][type='hidden']").val(data[key]);
                        $("#editModal input[name='"+key+"'][type='text']").val(data[key]);
                        $("#editModal select[name='"+key+"'] option[value='"+data[key]+"']").prop("selected",true);
                    }else{
                        $("#editModal select[name='"+key+"'] option:first-child").prop("selected",true);
                    }
                }
            }

            $('.search_select').searchableSelect();
            $("#editModal").modal();
        }
    });
}