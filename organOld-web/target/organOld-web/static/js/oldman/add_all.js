$(function () {

    $.ajax({
        url: "/oldman/add_all",//这个就是请求地址对应sAjaxSource
        data : {},
        type: 'GET',
        dataType: 'json',
        async: false,
        success: function (result) {
            if(result.success==true){
                if(result.data.sex!=null && result.data.sex!=0){
                    $("input[name='sex']:checkbox").prop("checked",false);
                    $("input[name='sex']").each(function () {
                       if(result.data.sex==$(this).val()){
                           $(this).prop("checked",true);
                       }
                    });
                }
                if(result.data.isKey!=null && result.data.isKey!=0){
                    $("input[name='isKey']:checkbox").prop("checked",false);
                    $("input[name='isKey']").each(function () {
                        if(result.data.isKey==$(this).val()){
                            $(this).prop("checked",true);
                        }
                    });
                }

                if(result.data.families!=null && result.data.families.length>0){
                    $("input[name='family']:checkbox").prop("checked",false);
                    $("input[name='family']").each(function () {
                        if(result.data.families.indexOf($(this).val())!=-1){
                            $(this).prop("checked",true);
                        }
                    });
                }
                if(result.data.censuses!=null && result.data.censuses.length>0){
                    $("input[name='census']:checkbox").prop("checked",false);
                    $("input[name='census']").each(function () {
                        if(result.data.censuses.indexOf($(this).val())!=-1){
                            $(this).prop("checked",true);
                        }
                    });
                }
                if(result.data.politicalStatuses!=null && result.data.politicalStatuses.length>0){
                    $("input[name='politicalStatus']:checkbox").prop("checked",false);
                    $("input[name='politicalStatus']").each(function () {
                        if(result.data.politicalStatuses.indexOf($(this).val())!=-1){
                            $(this).prop("checked",true);
                        }
                    });
                }
                if(result.data.econmics!=null && result.data.econmics.length>0){
                    $("input[name='economic']:checkbox").prop("checked",false);
                    $("input[name='economic']").each(function () {
                        if(result.data.econmics.indexOf($(this).val())!=-1){
                            $(this).prop("checked",true);
                        }
                    });
                }
                if(result.data.intelligences!=null && result.data.intelligences.length>0){
                    $("input[name='intelligence']:checkbox").prop("checked",false);
                    $("input[name='intelligence']").each(function () {
                        if(result.data.intelligences.indexOf($(this).val())!=-1){
                            $(this).prop("checked",true);
                        }
                    });
                }
                if(result.data.eyesights!=null && result.data.eyesights.length>0){
                    $("input[name='eyesight']:checkbox").prop("checked",false);
                    $("input[name='eyesight']").each(function () {
                        if(result.data.eyesights.indexOf($(this).val())!=-1){
                            $(this).prop("checked",true);
                        }
                    });
                }

                if(result.data.districtIds!=null && result.data.districtIds.length>0){
                    $("input[name='district']:checkbox").prop("checked",false);
                    $("input[name='district']").each(function () {
                        if(result.data.districtIds.indexOf($(this).val())!=-1){
                            $(this).prop("checked",true);
                        }
                    });
                }

                if(result.data.jwIds!=null && result.data.jwIds.length>0){
                    $("input[name='organ']:checkbox").prop("checked",false);
                    $("input[name='organ']").each(function () {
                        if(result.data.jwIds.indexOf($(this).val())!=-1){
                            $(this).prop("checked",true);
                        }
                    });
                }


            }
        }
    });
});