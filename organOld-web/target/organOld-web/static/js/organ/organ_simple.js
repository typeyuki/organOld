$(function () {
    $.ajax({
        url: url,//这个就是请求地址对应sAjaxSource
        data : {
            "iDisplayStart" : aoData.iDisplayStart,
            "iDisplayLength" : aoData.iDisplayLength,
            "iSortCol_0" : aoData.iSortCol_0,
            "sEcho" : aoData.sEcho,
            "sSortDir_0" : aoData.sSortDir_0,
            "organId" : organId
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
});