/**
 * Created by netlab606 on 2018/4/2.
 */
var table;
var obj;
$(document).ready(function(){

    //这个方法用来启动该页面的ReverseAjax功能
    dwr.engine.setActiveReverseAjax(true);
    //设置在页面关闭时，通知服务端销毁会话
    dwr.engine.setNotifyServerOnPageUnload(true);


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
            "columns":[{},{
                data:"oldmanId"
            },{},{
                data:"goal"
            },{},{
                data:"oldStatus"
            },{}
            ,{
                data:"oldmanKeyHandleModel.type"
                },{},{},{},{}
            ],
            "order":[[1,"asc"]],
            "columnDefs": [
                {
                    "targets": [0], // 目标列位置，下标从0开始
                    "data": "oldmanId", // 数据列名
                    "render": function(data, type, full) { // 返回自定义内容
                        return "<input type='checkbox' name='check' value='"+data+"'/>"
                    }
                },
                {
                    "targets": [2], // 目标列位置，下标从0开始
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
                {
                    "targets": [4], // 目标列位置，下标从0开始
                    "data": "status", // 数据列名
                    "render": function(data, type, full) { // 返回自定义内容
                        var id="$(this).parent().prev().prev().prev().text()";
                        var name="$(this).parent().prev().prev().text()";
                        if(data=="未处理"){
                            return "<button class='btn btn-primary' onclick=handle("+id+","+name+",this)>"+data+"</button>";
                        }else{
                            return "<button class='btn btn-default'>"+data+"</button>";
                        }
                    }
                },{
                    "targets": [6], // 目标列位置，下标从0开始
                    "data": "organAndHome", // 数据列名
                    "render": function(data, type, full) { // 返回自定义内容
                        var s="";
                        var i=0;
                        for(var js in data){
                            if(js.indexOf(0)!="0"){
                                s+="<button class='btn btn-primary' onclick=newPage("+js+",'"+data[js]+"','/organ/"+js+"/info?look=true')>"+data[js]+"</button>";
                            }else{
                                s+="<button class='btn btn-default'>"+data[js]+"</button>";
                            }
                            i++;
                        }
                        return s;
                    }
                },{
                    "targets": [8], // 目标列位置，下标从0开始
                    "data": "oldmanKeyHandleModel", // 数据列名
                    "render": function(data, type, full) { // 返回自定义内容
                        var s="";
                        if(data!=null){
                            for(var i=0;i<data.organ.length;i++){
                                s+="<button class='btn btn-primary' onclick=newPage("+data.organ[i].id+",'"+data.organ[i].name+"','/organ/"+data.organ[i].id+"/info?look=true')>"+data.organ[i].name+"</button>";
                            }
                            for(var i=0;i<data.homeFirTypes.length;i++){
                                s+="<button class='btn btn-default'>"+data.homeFirTypes[i]+"</button>";
                            }
                        }
                        return s;
                    }
                },
                {
                    "targets": [9], // 目标列位置，下标从0开始
                    "data": "organActivity", // 数据列名
                    "render": function(data, type, full) { // 返回自定义内容
                        var s="";
                        if(data!=null){
                            for(var i=0;i<data.length;i++){
                                s+="<button class='btn btn-primary'onclick=newPage("+data[i].id+",'"+data[i].name+"','/organ/"+data[i].id+"/info?look=true')>"+data[i].name+"</button><br>";
                            }
                        }
                        return s;
                    }
                },{
                    "targets": [10], // 目标列位置，下标从0开始
                    "data": "organActivity", // 数据列名
                    "render": function(data, type, full) { // 返回自定义内容
                        var s="";
                        if(data!=null){
                            for(var i=0;i<data.length;i++){
                                s+="<span>"+data[i].applyTime+"</span><br>";
                            }
                        }
                        return s;
                    }
                },
                // 增加一列，包括删除和修改，同时将我们需要传递的数据传递到链接中
                {
                    "targets": [11], // 目标列位置，下标从0开始
                    "data": "oldmanId", // 数据列名
                    "render": function(data, type, full) { // 返回自定义内容
                        return "<button class='btn btn-primary' id='"+data+"' onclick=newPage("+data+",$(this).parent().prev().prev().prev().text(),'/oldman/"+data+"/info')>查看</button>";
                    }
                },
                //不进行排序的列
                { "bSortable": false, "aTargets": [0,2,3,4,5,6,7,8,9,10,11] }
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
                "future":$("input[name=future]").val(),
                "goalEnd":$("input[name='goalEnd']").val(),
                "goalStart":$("input[name='goalStart']").val(),
                "oldmanId":$("input[name='oldmanId']").val(),
                "isActivity":$("select[name='isActivity']").val(),
                "isHandle":$("select[name='isHandle']").val()
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
        if($("#futureTime").val()!=null && $("#futureTime").val()!=""){
            update('future');
        }else{
            table.fnFilter();
        }
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
    $(".wrapper").hide();
    $("#process").show();
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
            // alert("更新完成");
            if (result.data=="future"){
                $("input[name=future]").val("1");
            }else{
                $("input[name=future]").val("");
            }
            // alert(1);
            // table.fnFilter();
        },
        error:function(XMLHttpRequest, textStatus, errorThrown) {

        }
    });
}


function finish(data) {
    $("#process").hide();
    $(".wrapper").show();
    alert("更新完成");
    table.fnFilter();
}

function handle(id,name,obje) {
    obj=obje;
    $("#organ").hide();
    $("#home").hide();
    $("select.selectpicker").each(function(){
        $(this).selectpicker('deselectAll');  //重置bootstrap-select显示
    });
        $("#handleModal select[name='type']").find("option").prop("selected", "false");
        $("#handleModal select[name='type']").find("option").first().prop("selected", "true");

        $("#handleModal input[name='oldmanId']").val(id);
        $("#handleModal small").html(name);
        $("#handleModal").modal();

}

function noHandle() {
    var array=[];
    $("input[name='check']:checked").each(function () {
       array.push($(this).val());
    });
    $.ajax({
        url: "/oldman/key/handle/del",
        data : {
            oldmanIds:array
        },
        type: 'POST',
        dataType: 'json',
        success: function (result) {
            table.fnFilter();
        },
        error:function(XMLHttpRequest, textStatus, errorThrown) {

        }
    });
}