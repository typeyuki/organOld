<!DOCTYPE html>
<html>

<head>
<#include "../head.ftl" />
<script type="text/javascript" src="../../../static/js/echarts.js"></script>
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
    // title_text='各片区完成度对比';
    // legend_data=[];
    // xAxis_data=['平阳','东兰','古龙','平吉','平南','古美'];
    // series=[
    //     {
    //         name: '已安排',
    //         type: 'bar',
    //         label:{
    //             normal:{
    //                 show:true,
    //                 position:'top',
    //                 textStyle:{
    //                     fontSize:20
    //                 }
    //             }
    //         },
    //         itemStyle:{
    //             normal: {
    //                 color:series_color_1,
    //                 fontSize:20
    //             }
    //         },
    //         data: [56,34,24,74,45,23]
    //     }
    // ];
    // var option_pq_bar=chartBarHei(title_text,legend_data,xAxis_data,series);
    // pq_bar.setOption(option_pq_bar);
    option = {
        title: {
            text: '各片区完成度对比',
            textStyle: {
                fontWeight: 'normal',      //标题颜色
                color: '#FFFFFF',
                fontSize: 26
            },
            x: 'center',
            textAlign:'right'
        },
        angleAxis: {
            type: 'category',
            data: ['平阳','东兰','古龙','平吉','平南','古美'],
            z: 10,
            //textSize:20,
            axisLine:{
                lineStyle:{
                    color:'white',
                    fontSize: 80
                }
            },
        },
        radiusAxis: {
        },
        polar: {
        },
        series: [{
            type: 'bar',
            data: [1, 2, 3, 4, 3, 5, 1],
            coordinateSystem: 'polar',
            name: '已完成',
            fontSize: 40,
            color:series_color_5,
            stack: 'a'
        }],
        legend: {
            show: true,
            data: ['已完成'],
            x: 'right',
            textStyle:{
                color:'white',
            },

        }
    };
    //使用制定的配置项和数据显示图表
    var pq_bar=echarts.init(document.getElementById('pq_bar'));
    pq_bar.setOption(option);

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
                    color:series_color_1
                }
            },
            data: [56,34,24,74,45,23],
            barWidth : 60,//柱图宽度
        }
    ];
    var option_jw_bar=chartBarHei(title_text,legend_data,xAxis_data,series);
    jw_bar.setOption(option_jw_bar);
    // option = {
    //     title: {
    //         text: '平阳片区居委完成度对比',
    //         textStyle: {
    //             fontWeight: 'normal',      //标题颜色
    //             color: '#FFFFFF',
    //             fontSize: 26
    //         },
    //         x: 'center',
    //         textAlign:'right'
    //     },
    //     angleAxis: {
    //         type: 'category',
    //         data: ['平阳一村','平阳二村','平阳三村','平阳四村','平阳五村','平阳六村'],
    //         z: 10,
    //         //textSize:20,
    //         axisLine:{
    //             lineStyle:{
    //                 color:'white',
    //                 fontSize: 80
    //             }
    //         },
    //     },
    //     radiusAxis: {
    //     },
    //     polar: {
    //     },
    //     series: [{
    //         type: 'bar',
    //         data: [1, 2, 3, 4, 3, 5, 1],
    //         coordinateSystem: 'polar',
    //         name: '已完成',
    //         fontSize: 40,
    //         color:'#6cbdfc',
    //         stack: 'a'
    //     }],
    //     legend: {
    //         show: true,
    //         data: ['已完成'],
    //         x: 'right',
    //         textStyle:{
    //             color:'white',
    //         },
    //
    //     }
    // };
    // //使用制定的配置项和数据显示图表
    // //var pq_bar=echarts.init(document.getElementById('pq_bar'));
    // jw_bar.setOption(option);

    // title_text='各个居委完成度对比';
    // legend_data=[];
    // xAxis_data=['平阳一村','平阳二村','平阳三村','平阳四村','平阳五村','平阳六村','平南一居','平南二居','平南三居','华一新城','华梅花苑','梅莲苑','万源一居','万源二居','万源三居','万源四居','平吉一村'
    //     ,'平吉二村','平吉一三村','平吉四村','平吉五村','平吉六村','古美一村','古美三村','古美四村','古美七村','古美一八村','古美九村','古美十村','东兰一居','东兰二居','东兰三居','东兰四居','古龙一村','古龙二村','古龙三村','古龙四村','古龙五村','古龙六村'];
    // series=[
    //     {
    //         name: '已安排',
    //         type: 'bar',
    //         label:{
    //             normal:{
    //                 show:true,
    //                 position:'top',
    //                 textStyle:{
    //                     fontSize:20
    //                 }
    //             }
    //         },
    //         itemStyle:{
    //             normal: {
    //                 color:series_color_3
    //             }
    //         },
    //         data: [56,34,24,74,45,23,34,24,74,45,23,34,24,74,45,23,34,24,74,45,23,34,24,74,45,23,34,24,74,45,23,34,24,74,45,23,34,24,74]
    //     }
    // ];

    //re2
    // var option_jw_all_bar=option = {
    //     title: {
    //         text: 'Step Line'
    //
    //     },
    //     tooltip: {
    //         trigger: 'axis'
    //     },
    //     legend: {
    //         data:[{name:'本次',textStyle:{color:legend_color,fontSize:18}},{name:'上次',textStyle:{color:legend_color,fontSize:18}}]
    //     },
    //     grid: {
    //         left: '3%',
    //         right: '4%',
    //         bottom: '3%',
    //         containLabel: true
    //     },
    //     toolbox: {
    //         feature: {
    //             saveAsImage: {}
    //         }
    //     },
    //     xAxis: {
    //         type: 'category',
    //         boundaryGap: [0, 0.01],
    //         data:['平阳一村','平阳二村','平阳三村','平阳四村','平阳五村','平阳六村','平南一居','平南二居','平南三居','华一新城','华梅花苑','梅莲苑','万源一居','万源二居','万源三居','万源四居','平吉一村'
    //             ,'平吉二村','平吉一三村','平吉四村','平吉五村','平吉六村','古美一村','古美三村','古美四村','古美七村','古美一八村','古美九村','古美十村','东兰一居','东兰二居','东兰三居','东兰四居','古龙一村','古龙二村','古龙三村','古龙四村','古龙五村','古龙六村'],
    //         axisLine:{
    //             lineStyle: {
    //                 color: '#fff',
    //                 fontSize:18,
    //                 fontWeight:100
    //             }
    //         },
    //         axisLabel:{
    //             interval:0,//横轴信息全部显示
    //             rotate:-30,//-30度角倾斜显示
    //             textStyle: {
    //                 color: '#fff'
    //             }
    //         }
    //
    //     },
    //     yAxis:[
    //         {
    //             type : 'value',
    //             axisLabel:{
    //                 textStyle: {
    //                     color: '#fff',fontSize:18,
    //                     fontWeight:100
    //                 }
    //             },
    //             axisLine:{
    //                 lineStyle: {
    //                     color: '#fff'
    //                 }
    //             },
    //             splitLine:{
    //                 show:false
    //             }
    //         }
    //     ],
    //     series: [
    //         {
    //             name:'本次',
    //             type:'line',
    //             step: 'start',
    //             data:[80, 79, 78,77,76,75,74,73,72,71,70,69,68,67,66,65,64,63,62,61,60,59,58,57,56,55,55,55,55,55,55,55,55,55,55,55,55,55,55,55,55],
    //             itemStyle:{
    //                 normal: {
    //                     lineStyle:{
    //                         width:1,
    //                         color:series_color_1
    //                     },
    //                     label : {
    //                         show: true
    //                     },
    //                     color:series_color_1
    //
    //                 },
    //             }
    //         },
    //         {
    //             name:'上次',
    //             type:'line',
    //             step: 'middle',
    //             data:[32,12,77,45,14,78,21,57,16,82,32,57,34,12,6,93,23,63,3,5,67,23,11,2,54,23,12,11,6,23,72,23,12,73,14,27,88,11,88],
    //             itemStyle:{
    //                 normal: {
    //                     lineStyle:{
    //                         width:1,
    //                         color:series_color_2
    //                     },
    //                     label : {
    //                         show: true
    //                     },
    //                     color:series_color_2
    //
    //                 },
    //             },
    //         }
    //     ]
    // };

    //re3
    var colors = ['#5793f3', '#d14a61', '#675bba'];


    option = {
        // title: {
        //     text: '标题',
        //     left:'center',
        //     textStyle: {
        //         fontWeight: 'normal',      //标题颜色
        //         color: '#FFFFFF',
        //         fontSize: 26
        //     },
        //     x: 'center',
        //     y:'top',
        // },
        title: {
                    text: 'Step Line'

                },
        color: colors,

        tooltip: {
            trigger: 'none',
            axisPointer: {
                type: 'cross'
            }
        },
        legend: {
            data:[{name:'本次',textStyle:{color:legend_color,fontSize:18}},{name:'上次',textStyle:{color:legend_color,fontSize:18}}],
            // x:'right',
            // y:'top'


        },
        grid: {
            top: 70,
            bottom: 50
        },
        xAxis: [
            {
                type: 'category',
                axisTick: {
                    alignWithLabel: true
                },
                axisLine: {
                    onZero: false,
                    lineStyle: {
                        color: colors[1]
                    }
                },
                axisPointer: {
                    label: {
                        formatter: function (params) {
                            return '降水量  ' + params.value
                                    + (params.seriesData.length ? '：' + params.seriesData[0].data : '');
                        }
                    }
                },
                data: ['平阳一村', '平阳二村', '平阳三村', '平阳四村', '平阳五村', '平阳六村', '平南一居', '平南二居', '平南三居', '华一新城', '华梅花苑', '梅莲苑', '万源一居', '万源二居', '万源三居', '万源四居', '平吉一村', '平吉二村', '平吉一三村', '平吉四村', '平吉五村', '平吉六村', '古美一村', '古美三村', '古美四村', '古美七村', '古美一八村', '古美九村', '古美十村', '东兰一居', '东兰二居', '东兰三居', '东兰四居', '古龙一村', '古龙二村', '古龙三村', '古龙四村', '古龙五村', '古龙六村'],
            },
            {
                type: 'category',
                axisTick: {
                    alignWithLabel: true
                },
                axisLine: {
                    onZero: false,
                    lineStyle: {
                        color: colors[0]
                    }
                },
                axisPointer: {
                    label: {
                        formatter: function (params) {
                            return '降水量  ' + params.value
                                    + (params.seriesData.length ? '：' + params.seriesData[0].data : '');
                        }
                    }
                },
                data:['平阳一村','平阳二村','平阳三村','平阳四村','平阳五村','平阳六村','平南一居','平南二居','平南三居','华一新城','华梅花苑','梅莲苑','万源一居','万源二居','万源三居','万源四居','平吉一村','平吉二村','平吉一三村','平吉四村','平吉五村','平吉六村','古美一村','古美三村','古美四村','古美七村','古美一八村','古美九村','古美十村','东兰一居','东兰二居','东兰三居','东兰四居','古龙一村','古龙二村','古龙三村','古龙四村','古龙五村','古龙六村'],

            }
        ],
        yAxis: [
            {
                type: 'value',
                axisLabel:{
                    textStyle: {
                        color: '#fff',
                        fontSize:14,
                        fontWeight:100
                    }
                },
                max:100
            }
        ],
        series: [
            {
                name:'本次',
                type:'line',
                xAxisIndex: 1,
                smooth: true,
                data:[32,12,77,45,14,78,21,57,16,82,32,57,34,12,6,93,23,63,3,5,67,23,11,2,54,23,12,11,6,23,72,23,12,73,14,27,88,11,88]
            },
            {
                name:'上次',
                type:'line',
                smooth: true,
                data: [82,32,57,73,14,27,88,11,88,5,67,23,11,2,54,23,34,12,6,32,12,77,45,14,78,21,57,16,93,23,63,312,11,6,23,72,23,12]
            }
        ]
    };
    jw_all_bar.setOption(option);


</script>
</html>