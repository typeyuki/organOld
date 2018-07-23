/**
 * Created by netlab606 on 2018/6/25.
 */
function newPage(id,name,url) {

    var t=url,
        a="1"+id,
        i=name,
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
        var r='<iframe class="J_iframe" name="iframe'+a+'" width="100%" height="100%" src="'+t+'" frameborder="0" data-id="'+t+'" seamless></iframe>';
        jq(".J_mainContent").find("iframe.J_iframe").hide().parents(".J_mainContent").append(r);
        jq(".J_mainContent iframe:visible").load(function(){layer.close(o)});
        jq(".J_menuTabs .page-tabs-content").append(s);
        e(jq(".J_menuTab.active"));
    }
    return!1
}


function oldman_edit(id,url) {

    $(".searchable-select").remove();
    $.ajax({
        url: url,
        type: "get",
        success: function (result) {
            var data=result.data;
            for(key in data){
                if(key=="sex"){
                    $("#editModal input[name='sex']").each(function () {
                        if($(this).val()==data[key]){
                            $(this).prop("checked",true);
                        }
                    });
                }else {
                    $("#editModal input[name='"+key+"']").val(data[key]);
                    $("#editModal select[name='"+key+"'] option[value='"+data[key]+"']").prop("selected",true);
                }
            }

            $('.search_select').searchableSelect();
            $("#editModal").modal();
        }
    });

}

function oldman_edit_oldmanName(id,url,oldmanName){
    $("#editModal h5").html(oldmanName);
    oldman_edit(id,url)
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


$(function () {
    $('.selectpicker').selectpicker({
        'selectedText': 'cat'
    });
});