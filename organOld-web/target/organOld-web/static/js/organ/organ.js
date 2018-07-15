/**
 * Created by netlab606 on 2018/4/2.
 */
$(document).ready(function(){
    var columns=[];
    var columnDefs=[];
    if(firType==21 || firType==22){
        columns=[{},{
            data:"id"
        },{
            data:"organType"
        },{
            data:"name"
        },{
            data:"intro"
        },{
            data:"num"
        },{
            data:"numIn"
        },{
            data:"numRemain"
        },{
            data:"serviceTime"
        },{
            data:"address"
        },{
            data:"phone"
        },{
            data:"districtName"
        },{},{
            data:"time"
        }
        ];
        columnDefs= [
            // 列样式
            {
                "targets": [0], // 目标列位置，下标从0开始
                "data": "id", // 数据列名
                "render": function(data, type, full) { // 返回自定义内容
                    return"<input type='checkbox' />"
                }
            },
            {
                "targets": [12], // 目标列位置，下标从0开始
                "data": "organ", // 数据列名
                "render": function(data, type, full) { // 返回自定义内容
                    var btn="";
                    if(data.authConsume==1){
                        btn+="<span class='btn btn-primary' onclick=newPage("+data.id+",$(this).parent().prev().prev().prev().prev().prev().prev().prev().prev().prev().text(),'/record/1?organId="+data.id+"')>消费记录</span>";
                    }
                    if(data.authProduct==1){
                        btn+="<span class='btn btn-primary' onclick=newPage("+data.id+",$(this).parent().prev().prev().prev().prev().prev().prev().prev().prev().prev().text(),'/product?organId="+data.id+"')>商品列表</span>";
                    }
                    if(data.authProduct==1){
                        btn+="<span class='btn btn-primary' onclick=newPage("+data.id+",$(this).parent().prev().prev().prev().prev().prev().prev().prev().prev().prev().text(),'/product/book?organId="+data.id+"')>商品预定记录</span>";
                    }
                    if(data.authSign==1){
                        btn+="<span class='btn btn-primary' onclick=newPage("+data.id+",$(this).parent().prev().prev().prev().prev().prev().prev().prev().prev().prev().text(),'/record/2?organId="+data.id+"')>签到记录</span>";
                    }
                    if(data.authQueryInfo==1){
                        btn+="<span class='btn btn-primary' onclick=newPage("+data.id+",$(this).parent().prev().prev().prev().prev().prev().prev().prev().prev().prev().text(),'/record/3?organId="+data.id+"')>老人信息查询记录</span>";
                    }
                    if(data.authQueryIntegral==1){
                        btn+="<span class='btn btn-primary' onclick=newPage("+data.id+",$(this).parent().prev().prev().prev().prev().prev().prev().prev().prev().prev().text(),'/record/4?organId="+data.id+"')>老人积分查询记录</span>";
                    }
                    return btn;
                }
            },
            // 增加一列，包括删除和修改，同时将我们需要传递的数据传递到链接中
            {
                "targets": [14], // 目标列位置，下标从0开始
                "data": "id", // 数据列名
                "render": function(data, type, full) { // 返回自定义内容
                    return "<span class='btn btn-primary' onclick=newPage("+data+",$(this).parent().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().text(),'/organ/oldman/"+data+"/man')>人员</span>" +
                        "<span class='btn btn-primary' onclick=newPage("+data+",$(this).parent().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().text(),'/organ/"+data+"/info')>查看</span>";
                }
            },
            //不进行排序的列
            { "bSortable": false, "aTargets": [ 0,2 ,3, 4, 5,6,7,8,9,10,11,12,13,14] }
        ]
    }else if(firType==1){
        columns=[{},{
            data:"id"
        },{
            data:"organType"
        },{
            data:"name"
        },{
            data:"intro"
        },{
            data:"serviceTime"
        },{
            data:"address"
        },{
            data:"phone"
        },{
            data:"districtName"
        },{},{
            data:"time"
        }
        ];
        columnDefs= [
            // 列样式
            {
                "targets": [0], // 目标列位置，下标从0开始
                "data": "id", // 数据列名
                "render": function(data, type, full) { // 返回自定义内容
                    return"<input type='checkbox' />"
                }
            },
            {
                "targets": [9], // 目标列位置，下标从0开始
                "data": "organ", // 数据列名
                "render": function(data, type, full) { // 返回自定义内容
                    var btn="";
                    if(data.authConsume==1){
                        btn+="<span class='btn btn-primary' onclick=newPage("+data.id+",$(this).parent().prev().prev().prev().prev().prev().text(),'/record/1?organId="+data.id+"')>消费记录</span>";
                    }
                    if(data.authProduct==1){
                        btn+="<span class='btn btn-primary' onclick=newPage("+data.id+",$(this).parent().prev().prev().prev().prev().prev().text(),'/product?organId="+data.id+"')>商品列表</span>";
                    }
                    if(data.authProduct==1){
                        btn+="<span class='btn btn-primary' onclick=newPage("+data.id+",$(this).parent().prev().prev().prev().prev().prev().prev().text(),'/product/book?organId="+data.id+"')>商品预定记录</span>";
                    }
                    if(data.authSign==1){
                        btn+="<span class='btn btn-primary' onclick=newPage("+data.id+",$(this).parent().prev().prev().prev().prev().prev().prev().text(),'/record/2?organId="+data.id+"')>签到记录</span>";
                    }
                    if(data.authQueryInfo==1){
                        btn+="<span class='btn btn-primary' onclick=newPage("+data.id+",$(this).parent().prev().prev().prev().prev().prev().prev().text(),'/record/3?organId="+data.id+"')>老人信息查询记录</span>";
                    }
                    if(data.authQueryIntegral==1){
                        btn+="<span class='btn btn-primary' onclick=newPage("+data.id+",$(this).parent().prev().prev().prev().prev().prev().prev().text(),'/record/4?organId="+data.id+"')>老人积分查询记录</span>";
                    }
                    return btn;
                }
            },
            // 增加一列，包括删除和修改，同时将我们需要传递的数据传递到链接中
            {
                "targets": [11], // 目标列位置，下标从0开始
                "data": "id", // 数据列名
                "render": function(data, type, full) { // 返回自定义内容
                    return "<span class='btn btn-primary' onclick=newPage("+data+",$(this).parent().prev().prev().prev().prev().prev().prev().prev().prev().text(),'/organ/"+data+"/info')>查看</span>";
                }
            },
            //不进行排序的列
            { "bSortable": false, "aTargets": [ 0,2 ,3, 4,5,6,7,8,9,11] }
        ]
    }else if(firType==3 && status=="2"){
        columns=[{},{
            data:"id"
        },{
            data:"organType"
        },{
            data:"name"
        },{
            data:"intro"
        },{
            data:"num"
        },{
            data:"serviceTime"
        },{
            data:"address"
        },{
            data:"phone"
        },{
            data:"districtName"
        },{},{
            data:"time"
        }
        ];
        columnDefs= [
            // 列样式
            {
                "targets": [0], // 目标列位置，下标从0开始
                "data": "id", // 数据列名
                "render": function(data, type, full) { // 返回自定义内容
                    return"<input type='checkbox' />"
                }
            },
            {
                "targets": [10], // 目标列位置，下标从0开始
                "data": "organ", // 数据列名
                "render": function(data, type, full) { // 返回自定义内容
                    var btn="";
                    if(data.authConsume==1){
                        btn+="<span class='btn btn-primary' onclick=newPage("+data.id+",$(this).parent().prev().prev().prev().prev().prev().prev().prev().text(),'/record/1?organId="+data.id+"')>消费记录</span>";
                    }
                    if(data.authProduct==1){
                        btn+="<span class='btn btn-primary' onclick=newPage("+data.id+",$(this).parent().prev().prev().prev().prev().prev().prev().prev().text(),'/product?organId="+data.id+"')>商品列表</span>";
                    }
                    if(data.authProduct==1){
                        btn+="<span class='btn btn-primary' onclick=newPage("+data.id+",$(this).parent().prev().prev().prev().prev().prev().prev().prev().text(),'/product/book?organId="+data.id+"')>商品预定记录</span>";
                    }
                    if(data.authSign==1){
                        btn+="<span class='btn btn-primary' onclick=newPage("+data.id+",$(this).parent().prev().prev().prev().prev().prev().prev().prev().text(),'/record/2?organId="+data.id+"')>签到记录</span>";
                    }
                    if(data.authQueryInfo==1){
                        btn+="<span class='btn btn-primary' onclick=newPage("+data.id+",$(this).parent().prev().prev().prev().prev().prev().prev().prev().text(),'/record/3?organId="+data.id+"')>老人信息查询记录</span>";
                    }
                    if(data.authQueryIntegral==1){
                        btn+="<span class='btn btn-primary' onclick=newPage("+data.id+",$(this).parent().prev().prev().prev().prev().prev().prev().prev().text(),'/record/4?organId="+data.id+"')>老人积分查询记录</span>";
                    }
                    return btn;
                }
            },
            // 增加一列，包括删除和修改，同时将我们需要传递的数据传递到链接中
            {
                "targets": [12], // 目标列位置，下标从0开始
                "data": "id", // 数据列名
                "render": function(data, type, full) { // 返回自定义内容
                    return "<span class='btn btn-primary' onclick=newPage("+data+",$(this).parent().prev().prev().prev().prev().prev().prev().prev().prev().prev().text(),'/organ/"+data+"/info')>查看</span>" +
                        "<span class='btn btn-danger' onclick=location.href='/organ/"+data+"/cancel'>撤销</span>";
                }
            },
            //不进行排序的列
            { "bSortable": false, "aTargets": [ 0,2 ,3, 4,5,6,7,8,9,10,11,12] }
        ]
    }else if(firType==3 && (status=="3")){
        columns=[{
            data:"id"
        },{
            data:"organType"
        },{
            data:"name"
        },{
            data:"intro"
        },{
            data:"num"
        },{
            data:"serviceTime"
        },{
            data:"address"
        },{
            data:"phone"
        },{
            data:"districtName"
        },{
            data:"statusDesc"
        },{}
        ,{
            data:"time"
        }
        ];
        columnDefs= [

            {
                "targets": [10], // 目标列位置，下标从0开始
                "data": "organ", // 数据列名
                "render": function(data, type, full) { // 返回自定义内容
                    var btn="";
                    if(data.authConsume==1){
                        if(data.status=="4"){
                            btn+="<span class='btn btn-primary' onclick=newPage("+data.id+",$(this).parent().prev().prev().prev().prev().prev().prev().prev().prev().text(),'/record/1?organId="+data.id+"')>消费记录</span>";
                        } else{
                            btn+="<span class='noBtn'>消费记录</span>";
                        }

                    }
                    if(data.authProduct==1){
                        if(data.status=="4")
                        btn+="<span class='btn btn-primary' onclick=newPage("+data.id+",$(this).parent().prev().prev().prev().prev().prev().prev().prev().prev().text(),'/product?organId="+data.id+"')>商品列表</span>";
                        else
                            btn+="<span class='noBtn'>商品列表</span>";
                    }
                    if(data.authProduct==1){
                        if(data.status=="4")
                        btn+="<span class='btn btn-primary' onclick=newPage("+data.id+",$(this).parent().prev().prev().prev().prev().prev().prev().prev().prev().text(),'/product/book?organId="+data.id+"')>商品预定记录</span>";
                        else
                            btn+="<span class='noBtn'>商品预定记录</span>";
                    }
                    if(data.authSign==1){
                        if(data.status=="4")
                        btn+="<span class='btn btn-primary' onclick=newPage("+data.id+",$(this).parent().prev().prev().prev().prev().prev().prev().prev().prev().text(),'/record/2?organId="+data.id+"')>签到记录</span>";
                        else
                            btn+="<span class='noBtn'>签到记录</span>";
                    }
                    if(data.authQueryInfo==1){
                        if(data.status=="4")
                        btn+="<span class='btn btn-primary' onclick=newPage("+data.id+",$(this).parent().prev().prev().prev().prev().prev().prev().prev().prev().text(),'/record/3?organId="+data.id+"')>老人信息查询记录</span>";
                        else
                            btn+="<span class='noBtn'>老人信息查询记录</span>";
                    }
                    if(data.authQueryIntegral==1){
                        if(data.status=="4")
                        btn+="<span class='btn btn-primary' onclick=newPage("+data.id+",$(this).parent().prev().prev().prev().prev().prev().prev().prev().prev().text(),'/record/4?organId="+data.id+"')>老人积分查询记录</span>";
                        else
                            btn+="<span class='noBtn'>老人积分查询记录</span>";
                    }
                    return btn;
                }
            },
            // 增加一列，包括删除和修改，同时将我们需要传递的数据传递到链接中
            {
                "targets": [12], // 目标列位置，下标从0开始
                "data": "id", // 数据列名
                "render": function(data, type, full) { // 返回自定义内容
                    return "<span class='btn btn-primary' onclick=newPage("+data+",$(this).parent().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().text(),'/organ/"+data+"/info')>查看</span>";
                }
            },
            //不进行排序的列
            { "bSortable": false, "aTargets": [ 0,2 ,3, 4,5,6,7,8,9,10,12] }
        ]
    }else {
        columns=[{
            data:"id"
        },{
            data:"organType"
        },{
            data:"name"
        },{
            data:"intro"
        },{
            data:"num"
        },{
            data:"serviceTime"
        },{
            data:"address"
        },{
            data:"phone"
        },{
            data:"districtName"
        },{},{
            data:"time"
        }
        ];
        columnDefs= [
            // 列样式
            {
                "targets": [9], // 目标列位置，下标从0开始
                "data": "organ", // 数据列名
                "render": function(data, type, full) { // 返回自定义内容
                    var btn="";
                    if(data.authConsume==1){
                        btn+="<span class='noBtn'>消费记录</span>";
                    }
                    if(data.authProduct==1){
                        btn+="<span  class='noBtn'>商品列表</span>";
                        btn+="<span  class='noBtn'>商品预定列表</span>";
                    }
                    if(data.authSign==1){
                        btn+="<span class='noBtn'>签到记录</span>";
                    }
                    if(data.authQueryInfo==1){
                        btn+="<span class='noBtn'>老人信息查询记录</span>";
                    }
                    if(data.authQueryIntegral==1){
                        btn+="<span class='noBtn'>老人积分查询记录</span>";
                    }
                    return btn;
                }
            },
            // 增加一列，包括删除和修改，同时将我们需要传递的数据传递到链接中
            {
                "targets": [11], // 目标列位置，下标从0开始
                "data": "id", // 数据列名
                "render": function(data, type, full) { // 返回自定义内容
                    return "<span class='btn btn-primary' onclick=newPage("+data+",$(this).parent().prev().prev().prev().prev().prev().prev().prev().prev().prev().text(),'/organ/"+data+"/info')>查看</span>" +
                        "<span class='btn btn-primary' onclick=opera("+data+",'pass') id='"+data+"'>通过</span><span class='btn btn-danger' onclick=opera("+data+",'reject') id='"+data+"'>不通过</span>";
                }
            },
            //不进行排序的列
            { "bSortable": false, "aTargets": [ 1,2 ,3, 4,5,6,7,8,9,10,11] }
        ]
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
            "order":[[1,"asc"]],
            "columnDefs": columnDefs,
            "sAjaxSource": "/organ/data",//这个是请求的地址
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
                "type" : firType,
                "status":status
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

function opera(id,type) {
    $.ajax({
        url: "/organ/"+type,
        data : {
            id:id
        },
        type: 'POST',
        dataType: 'json',
        success: function (result) {
            alert("操作成功");
            start = $(".dataTables-example").dataTable().fnSettings()._iDisplayStart;
            total = $(".dataTables-example").dataTable().fnSettings().fnRecordsDisplay();
            window.location.reload();
            if(total-start==1){
                if(start>0){
                    $(".dataTables-example").dataTable().fnPageChange('previous',true);
                }
            }
        },
        error:function(XMLHttpRequest, textStatus, errorThrown) {

        }
    });
}
