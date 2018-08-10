<!DOCTYPE html>
<html>

<head>
<#include "head.ftl" />
</head>

<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-6">
            <div id="jg_pie" class="tu"></div>
        </div>
    </div>
    <script type="text/javascript">
        var tu_w,tu_h;
//        if(winWidth>=1700){
            //家里电脑的分辨率
            tu_w=winWidth/4.5;
            tu_h=winHeight/4.37;
//        }else if(winWidth<=1400 && winWidth>=1300){
//            tu_w=winWidth/4.5;
//            tu_h=winHeight/4.37;
//        }
        $(".tu").css('width',tu_w);
        $(".tu").css( 'height', tu_h);

        var jg_pie = echarts.init(document.getElementById('jg_pie'));
    </script>
</div>


</body>
<script>
    $.ajax({
        url : "/total/data",
        type : "get",
        success : function(data) {
            if (data.success==true) {
                var dataR=data.data;
                title_text="养老状态";
                var data=[
                    {value:dataR.organOldNum, name:'机构养老'},
                    {value:310, name:'社区养老'},
                    {value:400, name:'居家养老'}
                ];
                var option_jg_pie = customizedPie(title_text,data);
                jg_pie.setOption(option_jg_pie);
            }
        }
    });
</script>
</html>