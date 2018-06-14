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
                data:"id"
            },{
                data:"title"
            },{
                data:"author"
            },{
                data:"isTop"
            },{
                data:"time"
            },{
                data:""
            }
            ],
            "order":[[0,"asc"]],
            "columnDefs": [
                // 增加一列，包括删除和修改，同时将我们需要传递的数据传递到链接中
                {
                    "targets": [9], // 目标列位置，下标从0开始
                    "data": "id", // 数据列名
                    "render": function(data, type, full) { // 返回自定义内容
                        return "<span class='look' id='"+data+"'>查看</span><span class='mod' id='"+data+"'>修改</span><span class='del' onclick='del("+data+")'>删除</a>";
                    }
                },
                //不进行排序的列
                { "bSortable": false, "aTargets": [ 2 ,  4, 5,6,8,9] }
            ],
            "sAjaxSource": "/news/getNews",//这个是请求的地址
            "fnServerData": retrieveData,
            "fnServerParams": function (aoData) {  //查询条件
                aoData.push(
                    { "name": "id", "value": $('.id').val() },
                    { "name": "title", "value": $('.title').val() },
                    { "name": "author", "value": $('.author').val() },
                    { "name": "time", "value": $('.time').val() },
                    { "name": "isTop", "value": $('.isTop').val() }
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
                alert("status:"+XMLHttpRequest.status+",readyState:"+XMLHttpRequest.readyState+",textStatus:"+textStatus);
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
