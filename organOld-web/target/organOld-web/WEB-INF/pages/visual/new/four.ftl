<!DOCTYPE html>
<html>

<head>
<#include "../head.ftl" />
    <style>
        .box{
            box-shadow:inset 0px 0px 6px 0px rgba(255, 255, 255, 0.7);
            position: relative;
            border-radius: 5px;
        }
        .zz{
            position: absolute;
            background-color:rgba(146, 134, 134, 0.1);
            z-index: -99;
            width: 100%;
            height: 100%;
            top: 0;
            left: 0;
        }
        .tu,.tu_big{
            padding-top: 5%;
            padding-bottom: 2%;
        }
        .map_title{
            font-size: 50px;
            color: white;
        }

        .line{
            position: relative;
            left:5px;
            margin-bottom: 5px;
        }
        h2,p,td,h3,h1,span{
            color: white!important;
        }
        .a{
            margin-bottom: 5px;
            position: relative;
            right: 5px;
        }
        .title{
            text-align: center;
            font-size: 20px;
            font-weight: bold;
            margin-top: 10px;
        }
    </style>
</head>

<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-6 box">
            <div class="zz"></div>
            <div id="pq_bar" class="tu"></div>
        </div>
        <div class="col-lg-6 box" style="position: relative;left: 5px;margin-bottom: 5px">
            <div class="zz"></div>
            <div id="jw_bar" class="tu"></div>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12 box">
            <div class="zz"></div>
            <div id="jw_all_bar" class="tu_big"></div>
        </div>
    </div>
    <script type="text/javascript">
        $(".tu_big").css('width',winWidth);
        $(".tu_big").css( 'height', winHeight/1.8 );
        $(".tu").css('width',winWidth/2.2);
        $(".tu").css( 'height', winHeight/2.5);
        var pq_bar=echarts.init(document.getElementById('pq_bar'));
        var jw_bar = echarts.init(document.getElementById('jw_bar'));
        var jw_all_bar = echarts.init(document.getElementById('jw_all_bar'));
    </script>
</div>


</body>
<script>
    title_text='各片区完成度对比';
    legend_data=[];
    xAxis_data=['平阳','东兰','古龙','平吉','平南','古美'];
    series=[
        {
            name: '已安排',
            type: 'bar',
            label:{
                normal:{
                    show:true,
                    position:'top',
                    textStyle:{
                        fontSize:20
                    }
                }
            },
            itemStyle:{
                normal: {
                    color:series_color_1,
                    fontSize:20
                },
            },
            data: [56,34,24,74,45,23]
        }
    ];
    var option_pq_bar=chartBarHei(title_text,legend_data,xAxis_data,series);
    pq_bar.setOption(option_pq_bar);

    title_text='平阳片区居委完成度对比';
    legend_data=[];
    xAxis_data=['平阳一村','平阳二村','平阳三村','平阳四村','平阳五村','平阳六村'];
    series=[
        {
            name: '已安排',
            type: 'bar',
            label:{
                normal:{
                    show:true,
                    position:'top',
                    textStyle:{
                        fontSize:20
                    }
                }
            },
            itemStyle:{
                normal: {
                    color:series_color_2
                }
            },
            data: [56,34,24,74,45,23]
        }
    ];
    var option_jw_bar=chartBarHei(title_text,legend_data,xAxis_data,series);
    jw_bar.setOption(option_jw_bar);

    title_text='各个居委完成度对比';
    legend_data=[];
    xAxis_data=['平阳一村','平阳二村','平阳三村','平阳四村','平阳五村','平阳六村','平南一居','平南二居','平南三居','华一新城','华梅花苑','梅莲苑','万源一居','万源二居','万源三居','万源四居','平吉一村'
        ,'平吉二村','平吉一三村','平吉四村','平吉五村','平吉六村','古美一村','古美三村','古美四村','古美七村','古美一八村','古美九村','古美十村','东兰一居','东兰二居','东兰三居','东兰四居','古龙一村','古龙二村','古龙三村','古龙四村','古龙五村','古龙六村'];
    series=[
        {
            name: '已安排',
            type: 'bar',
            label:{
                normal:{
                    show:true,
                    position:'top',
                    textStyle:{
                        fontSize:20
                    }
                }
            },
            itemStyle:{
                normal: {
                    color:series_color_3
                }
            },
            data: [56,34,24,74,45,23,34,24,74,45,23,34,24,74,45,23,34,24,74,45,23,34,24,74,45,23,34,24,74,45,23,34,24,74,45,23,34,24,74]
        }
    ];
    var option_jw_all_bar=chartBarHeiSimpleAll(title_text,legend_data,xAxis_data,series);
    jw_all_bar.setOption(option_jw_all_bar);


</script>
</html>