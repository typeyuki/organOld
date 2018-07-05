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
            "columns":[{},{
                data:"id"
            },{
                data:"organName"
            },{
                data:"fir"
            },{
                data:"sec"
            },{
                data:"name"
            },{
                data:"rule"
            },{},{},{}
            ],
            "order":[[1,"asc"]],
            "columnDefs": [
                {
                    "targets": [0], // 目标列位置，下标从0开始
                    "data": "content", // 数据列名
                    "render": function(data, type, full) { // 返回自定义内容
                        return "<input type='checkbox' />";
                    }
                },
                {
                    "targets": [2], // 目标列位置，下标从0开始
                    "data": "content", // 数据列名
                    "render": function(data, type, full) { // 返回自定义内容
                        if(data==null){
                            return "";
                        }else{
                            return data;
                        }
                    }
                },
                {
                    "targets": [7], // 目标列位置，下标从0开始
                    "data": "content", // 数据列名
                    "render": function(data, type, full) { // 返回自定义内容
                        return data;
                    }
                },
                {
                    "targets": [8], // 目标列位置，下标从0开始
                    "data": "time", // 数据列名
                    "render": function(data, type, full) { // 返回自定义内容
                        return data;
                    }
                },
                // 增加一列，包括删除和修改，同时将我们需要传递的数据传递到链接中
                {
                    "targets": [9], // 目标列位置，下标从0开始
                    "data": "id", // 数据列名
                    "render": function(data, type, full) { // 返回自定义内容
                        if(typeLabel=="1"){
                            //人员绑定
                            return "<span onclick=newPage("+data+",$(this).parent().prev().prev().prev().prev().text(),'/oldman/label/bind/"+typeLabel+"/man') id='"+data+"'>人员</span><span class='edit' id='"+data+"'>修改</span>";
                        }else{
                            //规则指定
                            return "<span onclick=newPage("+data+",$(this).parent().prev().prev().prev().prev().text(),'/oldman/label/rule/"+data+"/man')>人员</span><span onclick=newPage("+data+",$(this).parent().prev().prev().prev().prev().text(),'/oldman/label/rule/"+data+"')>规则</span><span class='edit' id='"+data+"'>修改</span>";
                        }
                    }
                },
                //不进行排序的列
                { "bSortable": false, "aTargets": [0,2,3,4,5,6,7,8,9] }
            ],
            "sAjaxSource": "/oldman/label/data",//这个是请求的地址
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
                "id" : ($('.id').val()==""?"0":$('.id').val()),//参数不能是空 400
                "type":typeLabel
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

