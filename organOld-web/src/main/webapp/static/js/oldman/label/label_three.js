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
                data:"fir"
            },{
                data:"sec"
            },{
                data:"name"
            },{
                data:"rule"
            },{},{},{}
            ],
            "order":[[0,"asc"]],
            "columnDefs": [
                {
                    "targets": [5], // 目标列位置，下标从0开始
                    "data": "content", // 数据列名
                    "render": function(data, type, full) { // 返回自定义内容
                        return data;
                    }
                },
                {
                    "targets": [6], // 目标列位置，下标从0开始
                    "data": "time", // 数据列名
                    "render": function(data, type, full) { // 返回自定义内容
                        return data;
                    }
                },
                // 增加一列，包括删除和修改，同时将我们需要传递的数据传递到链接中
                {
                    "targets": [7], // 目标列位置，下标从0开始
                    "data": "id", // 数据列名
                    "render": function(data, type, full) { // 返回自定义内容
                        if(typeLabel=="1"){
                            //人员绑定
                            return "<span onclick=look("+data+",this,'/oldman/label/bind/"+typeLabel+"/man') id='"+data+"'>人员</span><span class='edit' id='"+data+"'>修改</span><span class='del' id='"+data+"'>删除</span>";
                        }else{
                            //规则指定
                            return "<span onclick=look("+data+",this,'/oldman/label/rule/"+typeLabel+"/man')>人员</span><span onclick=look("+data+",this,'/oldman/label/rule/"+typeLabel+"')>规则</span><span class='edit' id='"+data+"'>修改</span><span class='del' id='"+data+"'>删除</span>";
                        }
                    }
                },
                //不进行排序的列
                { "bSortable": false, "aTargets": [1,2,3,4,5,6,7] }
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

function look(labelId,obj,url) {

        var t=url,
            a="1"+labelId,
            i=$(obj).parent().prev().prev().prev().prev().text(),
            n=!0;

    var jq=top.jQuery;
        if(void 0==t||0==$.trim(t).length)
            return!1;
        if(
            jq(".J_menuTab").each(
                function(){
                    return $(this).data("id")==t?(
                        $(this).hasClass("active")||
                        (
                            $(this).addClass("active").siblings(".J_menuTab").removeClass("active"),
                                jq(".J_mainContent .J_iframe").each(function(){
                                    return $(this).data("id")==t?
                                        ($(this).show().siblings(".J_iframe").hide(),!1)
                                        :
                                        void 0}))
                            ,n=!1,!1)
                        : void 0
                })
                ,n
        ) {
            var s='<a href="javascript:;" class="active J_menuTab" data-id="'+t+'">'+i+' <i class="fa fa-times-circle"></i></a>';
            jq(".J_menuTab").removeClass("active");
            var r='<iframe class="J_iframe" name="iframe'+a+'" width="100%" height="100%" src="'+t+'?v=4.0" frameborder="0" data-id="'+t+'" seamless></iframe>';
            jq(".J_mainContent").find("iframe.J_iframe").hide().parents(".J_mainContent").append(r);
            jq(".J_mainContent iframe:visible").load(function(){layer.close(o)});
            jq(".J_menuTabs .page-tabs-content").append(s);
            e(jq(".J_menuTab.active"));
        }
        return!1
}
