<style>
    @media only screen and (min-width: 6000px){
        .finish_tu,.finish_tu_big{
            padding-top: 5%;
            padding-bottom: 2%;
        }
    }
</style>
<div class="row">
    <div class="col-lg-6 box">
        <div class="zz"></div>
        <div id="finish_pq_bar" class="finish_tu"></div>
    </div>
    <div class="col-lg-6 box" >
        <div class="zz"></div>
        <div id="finish_jw_bar" class="finish_tu"></div>
    </div>
</div>
<div class="row">
    <div class="col-lg-12 box">
        <div class="zz"></div>
        <div id="finish_jw_all_bar" class="finish_tu_big"></div>
    </div>
</div>
<script type="text/javascript">
    var finish_tu_w,finish_tu_h,finish_tu_big_w,finish_tu_big_h;
    var finish_width=$("#finish").width();

    if(winWidth>=1900){
        finish_tu_w=finish_width/2.2;
        finish_tu_h=winHeight/4.4;
        finish_tu_big_w=finish_width;
        finish_tu_big_h=winHeight/4.4;
    }else if(winWidth<=1400 && winWidth>=1300){
        total_tu_w=winWidth/4.5;
        total_tu_h=winHeight/4.1;
        total_tu_big_w=winWidth/4.5;
        total_tu_big_h=winHeight/2.2;
    }

    $(".finish_tu_big").css('width',finish_tu_big_w);
    $(".finish_tu_big").css( 'height', finish_tu_big_h );
    $(".finish_tu").css('width',finish_tu_w);
    $(".finish_tu").css( 'height', finish_tu_h);

    var finish_pq_bar=echarts.init(document.getElementById('finish_pq_bar'));
    var finish_jw_bar = echarts.init(document.getElementById('finish_jw_bar'));
    var finish_jw_all_bar = echarts.init(document.getElementById('finish_jw_all_bar'));
</script>
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
    var finish_option_pq_bar=chartBarHei(title_text,legend_data,xAxis_data,series);
    finish_pq_bar.setOption(finish_option_pq_bar);

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
    var finish_option_jw_bar=chartBarHei(title_text,legend_data,xAxis_data,series);
    finish_jw_bar.setOption(finish_option_jw_bar);

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
    var finish_option_jw_all_bar=chartBarHeiSimpleAll(title_text,legend_data,xAxis_data,series);
    finish_jw_all_bar.setOption(finish_option_jw_all_bar);


</script>