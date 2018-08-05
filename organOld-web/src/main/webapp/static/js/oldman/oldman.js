/**
 * Created by netlab606 on 2018/4/2.
 */
$(document).ready(function(){
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
                data:"id"
            },{},{
                data:"dName"
            },{
                data:"jName"
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
                data:"family"
            },{
                data:"economic"
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
                    "data": "id", // 数据列名
                    "render": function(data, type, full) { // 返回自定义内容
                        return"古美路街道"
                    }
                },
                // 增加一列，包括删除和修改，同时将我们需要传递的数据传递到链接中
                {
                    "targets": [12], // 目标列位置，下标从0开始
                    "data": "id", // 数据列名
                    "render": function(data, type, full) { // 返回自定义内容
                        return "<button class='btn btn-primary' id='"+data+"' onclick=newPage("+data+",$(this).parent().prev().prev().prev().prev().prev().prev().prev().text(),'/oldman/"+data+"/info')>查看</button><button class='btn btn-primary' onclick=oldman_edit("+data+",'/oldman/base/"+data+"/getById')>修改</button>";
                    }
                }
            ],
            "sAjaxSource": "/oldman/data",//这个是请求的地址
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
                "id" : ($('input[name="id"]').val()==""?"0":$('input[name="id"]').val()),//参数不能是空 400
                "census_array":$("select[name='censusArray']").val(),
                "ageStart":$("input[name='ageStart']").val(),
                "ageEnd":$("input[name='ageEnd']").val(),
                "family_array":$("select[name='family']").val(),
                "familyType_array":$("select[name='familyTypeArray']").val(),
                "economic_array":$("select[name='economic']").val(),
                "sex":$("select[name='sex']").val(),
                "search":$("input[name='search']").val(),
                "politicalStatus_array":$("select[name='politicalStatusArray']").val(),
                "isHealth_array":$("select[name='isHealth']").val(),
                "intelligence_array":$("select[name='intelligence']").val(),
                "eyesight_array":$("select[name='eyesight']").val(),
                "district_array":$("select[name='district']").val(),
                "jw_array":$("select[name='jw']").val(),
                "sqzw_array":$("select[name='sqzwArray']").val(),
                "zc_array":$("select[name='zcArray']").val(),
                "oldStatus_array":$("select[name='oldStatusArray']").val()
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


function exportTable() {
    $("#exportModal input").prop("checked",true);
    $("#exportModal").modal("hide");
    $("#exportModal input:checked").each(function () {
        var $input=$('<input type="hidden" name="th" value="'+$(this).val()+'">');
        $("#exportForm").append($input);
    });
    $("#exportForm").submit();
}
