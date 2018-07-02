$(function () {

    $.ajax({
        url: "/oldman/label/addLabel",//这个就是请求地址对应sAjaxSource
        data : {},
        type: 'GET',
        dataType: 'json',
        async: false,
        success: function (result) {
            if(result.success==true){
                if(result.data.districtIds!=null && result.data.districtIds.length>0){
                    $("input[name='district']:checkbox").prop("checked",false);
                    $("input[name='district']").each(function () {
                        if(result.data.districtIds.indexOf($(this).val())!=-1){
                            $(this).prop("checked",true);
                        }
                    });
                }



            }
        }
    });
});