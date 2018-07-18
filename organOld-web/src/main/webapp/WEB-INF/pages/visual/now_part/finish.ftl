<!DOCTYPE html>
<html>

<head>
<#include "../head.ftl" />
</head>

<body>
<div class="container-fluid">
    <div class="row" align="center"  style="margin-top: 10px">
        <div class="col-lg-12">
            <p class="map_title" >完成情况</p>
        </div>
    </div>
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
        var tu_w,tu_h,tu_big_w,tu_big_h;
        if(winWidth>=1700){
            //家里电脑的分辨率
            tu_w=winWidth/2.2;
            tu_h=winHeight/2.7;
            tu_big_w=winWidth;
            tu_big_h=winHeight/2;
        }else if(winWidth<=1400 && winWidth>=1300){
            tu_w=winWidth/4.5;
            tu_h=winHeight/4.1;
            tu_big_w=winWidth/4.5;
            tu_big_h=winHeight/2.2;
        }
        $(".tu").css('width',tu_w);
        $(".tu").css( 'height', tu_h);
        $(".tu_big").css('width',tu_big_w);
        $(".tu_big").css( 'height', tu_big_h);


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
                }
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