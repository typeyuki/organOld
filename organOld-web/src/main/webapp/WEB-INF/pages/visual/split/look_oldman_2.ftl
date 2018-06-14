<!DOCTYPE html>
<html>

<head>
<#include "head.ftl" />
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
            font-size: 28px;
            color: white;
        }
    </style>
</head>

<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-6">
            <div class="row" align="center">
                <div class="col-lg-12">
                    <p class="map_title">社区居家重点老人供需热力图</p>
                    <img src="/static/img/map/gumei_9.jpg" style="width:75%;">
                </div>
            </div>
        </div>
        <div class="col-lg-6">
            <div class="row">
                <div class="col-lg-6 box">
                    <div class="zz"></div>
                    <div id="js-oldman-ap-pie" class="tu"></div>
                </div>
                <div class="col-lg-6 box" style="position: relative;left: 5px">
                    <div class="zz"></div>
                    <div id="js-oldman-ap-bar" class="tu"></div>
                </div>
            </div>
            <div class="row" style="margin-top: 10px">
                <div class="col-lg-12 box">
                    <div class="zz"></div>
                    <div id="js-oldman-ap-line" class="tu_big"></div>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript">
        $(".tu").css('width',winWidth/4.5);
        $(".tu").css( 'height', winHeight*0.45);
        $(".tu_big").css('width',winWidth/2.1);
        $(".tu_big").css( 'height', winHeight*0.45);


        var js_oldman_ap_bar = echarts.init(document.getElementById('js-oldman-ap-bar'));
        var js_oldman_ap_line= echarts.init(document.getElementById('js-oldman-ap-line'));
        var js_oldman_ap_pie= echarts.init(document.getElementById('js-oldman-ap-pie'));


    </script>
</div>
<#include "set.ftl" />

</body>
<script type="text/javascript">
    title_text='各片区社区居家重点老人安排情况柱状图';
    legend_data=[
        {
            name:'已安排',
            textStyle:{
                color:'#fff'
            }
        },
        {
            name:'未安排',
            textStyle:{
                color:'#fff'
            }}
    ];
    xAxis_data=['平阳','东兰','古龙','平吉','平南','古美'];
    series=[
        {
            name: '已安排',
            type: 'bar',
            itemStyle:{
                normal: {
                    color:series_color_1
                }
            },
            data: [167,134,234,134,145,123]
        },
        {
            name: '未安排',
            type: 'bar',
            itemStyle:{
                normal: {
                    color:series_color_2
                }
            },
            data: [45,45,121,67,34,134]
        }
    ];
    var option_js_oldman_ap_bar=chartBarHei(title_text,legend_data,xAxis_data,series);
    title_text="古美街道社区居家重点老人安排情况饼图";
    legend_data=[{name:'已安排',textStyle:{color:legend_color}},{name:'未安排',textStyle:{color:legend_color}}];
    series=[{
        name: '安排与否',
        type: 'pie',
        radius : '55%',
        center: ['50%', '60%'],
        label: {
            normal : {
                formatter: '{d}%\n({c})',
                textStyle : {
                    fontWeight : 'normal'
                }
            }
        },
        data:[
            {value:1033, name:'已安排'},
            {value:376, name:'未安排'}
        ],
        itemStyle: {
            emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
        }
    }];
    var option_js_oldman_ap_pie = chartPie(title_text,legend_data,series);
    title_text='各片区社区居家重点老人供需趋势';
    legend_data=[{name:'60-70',textStyle:{color:legend_color}},{name:'70-80',textStyle:{color:legend_color}},
        {name:'80-90',textStyle:{color:legend_color}},{name:'90-',textStyle:{color:legend_color}}];
    xAxis_data=['11月','12月','1月','2月','3月','4月'];
    series=[
        {
            name: '60-70',
            type: 'line',
            itemStyle:{
                normal: {
                    lineStyle:{
                        width:1,
                        color:series_color_1
                    }
                }
            },
            symbolSize: 8,
            data: [200,205,210,210,215,220]
        },
        {
            name: '70-80',
            type: 'line',
            itemStyle:{
                normal: {
                    lineStyle:{
                        width:1,
                        color:series_color_2
                    }
                }
            },
            symbolSize: 8,
            data: [100,105,110,110,115,120]
        },
        {
            name: '80-90',
            type: 'line',
            itemStyle:{
                normal: {
                    lineStyle:{
                        width:1,
                        color:series_color_3
                    }
                }
            },
            symbolSize: 8,
            data: [60,65,70,80,85,90]
        },
        {
            name: '90-',
            type: 'line',
            itemStyle:{
                normal: {
                    lineStyle:{
                        width:1,
                        color:series_color_4
                    }
                }
            },
            symbolSize: 8,
            data: [50,55,60,70,75,80]
        }
    ];
    var option_js_oldman_ap_line = chartLine(title_text,legend_data,xAxis_data,series);


    js_oldman_ap_bar.setOption(option_js_oldman_ap_bar);
    js_oldman_ap_line.setOption(option_js_oldman_ap_line);
    js_oldman_ap_pie.setOption(option_js_oldman_ap_pie);

</script>
</html>