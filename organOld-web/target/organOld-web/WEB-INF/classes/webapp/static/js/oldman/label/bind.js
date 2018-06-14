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
                data:"districtName"
            },{
                data:"jwName"
            },{
                data:"name"
            },{
                data:"sex"
            },{
                data:"age"
            },{
                data:"politicalStatus"
            },{
                data:"census"
            },{
                data:"phone"
            },{
                data:"address"
            },{
                data:"pid"
            },{
                data:"time"
            }
            ],
            "order":[[1,"asc"]],
            "columnDefs": [
                // 列样式
                {
                    "targets": [0], // 目标列位置，下标从0开始
                    "data": "id", // 数据列名
                    "render": function(data, type, full) { // 返回自定义内容
                        if(data!=undefined){
                            return '<div class="icheckbox_square-green checked" style="position: relative;">' +
                                '<input type="checkbox" checked="" class="i-checks" name="input[]" style="position: absolute; opacity: 0;">' +
                                '<ins class="iCheck-helper" style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px; opacity: 0;">' +
                                '</ins>' +
                                '</div>';
                        }else{
                            return "";
                        }
                    }
                },
                // 增加一列，包括删除和修改，同时将我们需要传递的数据传递到链接中
                {
                    "targets": [13], // 目标列位置，下标从0开始
                    "data": "id", // 数据列名
                    "render": function(data, type, full) { // 返回自定义内容
                        return "<span class='look' id='"+data+"'>查看</span>";
                    }
                },
                //不进行排序的列
                { "bSortable": false, "aTargets": [ 0,2 ,3, 4, 5,7,8,9,10,11] }
            ],
            "sAjaxSource": "/oldman/label/"+type+"/"+labelId+"/manData",//这个是请求的地址
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
                "id" : ($('.id').val()==""?"0":aoData.id)//参数不能是空 400
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

    var table2 =$(".dataTables-example-1").dataTable(
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
                data:"districtName"
            },{
                data:"jwName"
            },{
                data:"name"
            },{
                data:"sex"
            },{
                data:"age"
            },{
                data:"politicalStatus"
            },{
                data:"census"
            }
            ],
            "order":[[1,"asc"]],
            "columnDefs": [
                {
                    "targets": [0], // 目标列位置，下标从0开始
                    "data": "id", // 数据列名
                    "render": function(data, type, full) { // 返回自定义内容
                        if(data!=undefined){
                            return '<div class="icheckbox_square-green checked" style="position: relative;">' +
                                '<input type="checkbox" checked="" class="i-checks" name="input[]" style="position: absolute; opacity: 0;">' +
                                '<ins class="iCheck-helper" style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px; opacity: 0;">' +
                                '</ins>' +
                                '</div>';
                        }else{
                            return "";
                        }
                    }
                },
                //不进行排序的列
                { "bSortable": false, "aTargets": [ 0,2,3,4,5,6,7,8] }
            ],
            "sAjaxSource": "/oldman/label/bind/"+labelId+"/getNoSelectManData",//这个是请求的地址
            "fnServerData": retrieveData1
        });

    function retrieveData1(url, aoData, fnCallback) {
        $.ajax({
            url: url,//这个就是请求地址对应sAjaxSource
            data : {
                "iDisplayStart" : aoData.iDisplayStart,
                "iDisplayLength" : aoData.iDisplayLength,
                "iSortCol_0" : aoData.iSortCol_0,
                "sEcho" : aoData.sEcho,
                "sSortDir_0" : aoData.sSortDir_0,
                "id" : ($('.sid').val()==""?"0":aoData.id)//参数不能是空 400
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

    $('#selectSearch').click(function () {
        table2.fnFilter();
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
