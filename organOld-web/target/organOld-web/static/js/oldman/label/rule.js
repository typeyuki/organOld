$(function () {

    $.ajax({
        url: "/oldman/label/rule/"+labelId+"/getRule",//这个就是请求地址对应sAjaxSource
        data : {},
        type: 'GET',
        dataType: 'json',
        async: false,
        success: function (result) {
            if(result.success==true){
                $("input[name='ageStart']").val(result.data.ageStart==0?"":result.data.ageStart);
                $("input[name='ageEnd']").val(result.data.ageEnd==0?"":result.data.endStart);

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
                if(result.data.isHealths!=null && result.data.isHealths.length>0){
                    $("input[name='isHealthy']:checkbox").prop("checked",false);
                    $("input[name='isHealth']").each(function () {
                        if(result.data.isHealths.indexOf($(this).val())!=-1){
                            $(this).prop("checked",true);
                        }
                    });
                }
            }
        }
    });
});