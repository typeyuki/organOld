<!DOCTYPE html>
<html>

<head>
<#include "../head.ftl" />
    <link href="/static/css/visual/part/total.css" rel="stylesheet">
     <script type="text/javascript">
        window.onload=function(){
            setInterval(function(){
                var date=new Date();
                // alert(JSON.stringify(date));
                var year=date.getFullYear(); //获取当前年份
                var mon=date.getMonth(); //获取当前月份
                var da=date.getDate(); //获取当前日
                var d=document.getElementById('Date');
                d.innerHTML=year+'年'+mon+'月'+da+'日';},1000)  }
    </script>
</head>

<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-6">
            <div class="row" align="center">
                <div class="col-lg-12">
                    <div class="row">
                        <div class="col-lg-3">
                            <div id="Date" style="color:#ffffff;text-align: center;padding-top: 2%;"></div>
                        </div>
                        <div class="col-lg-8">
                            <p class="map_title">古美路街道老人数量分布热力图</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12">
                        <#include "map.ftl"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-6">
            <div class="row">
                <div class="col-lg-6 box text" style="position: relative;bottom: 0px;">
                    <div class="zz"></div>
                    <p style="text-align: center;" id="ttt"><span class="title">街道人口总数：</span><span class="number"> <font style="font-weight:bold;font-style:italic; font-family: FZShuTi">16万</font></span><span class="title">人</span></p>
                    <p style="text-align: center"><span class="title">60岁及以上老人总数：</span><span class="number"><font style="font-weight:bold;font-style:italic;font-family: FZShuTi">4.1万</font></span><span class="title">人</span></p>
                    <p style="text-align: center"><span class="title">80岁及以上老人总数：</span><span class="number"><font style="font-weight:bold;font-style:italic;font-family: FZShuTi">5300</font></span><span class="title">人</span></p>
                </div>
                <div class="col-lg-6" style="position: relative;left: 5px">
                    <div class="row">
                        <div class="col-lg-12  box" style="margin-bottom: 5px">
                            <div class="zz"></div>
                            <div id="oldmanPie" class="tu"></div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12  box">
                            <div class="zz"></div>
                            <div id="zdPie" class="tu"></div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row" style="margin-top: 10px">
                <div class="col-lg-6 box">
                    <div class="zz"></div>
                    <div id="pqBar" class="tu_big"></div>
                </div>
                <div class="col-lg-6 box" style="position: relative;left: 5px">
                    <div class="zz"></div>
                    <div id="statusPie" class="tu_big"></div>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript">
        var tu_w,tu_h,tu_big_w,tu_big_h,text_h;
        if(winWidth>=1700){
            //家里电脑的分辨率
            tu_w=winWidth/4.5;
            tu_h=winHeight/5;
            tu_big_w=winWidth/4.5;
            tu_big_h=winHeight/2.2;
            text_h=winHeight/2.46;
        }else if(winWidth<=1650 && winWidth>=1300){
            tu_w=winWidth/4.5;
            tu_h=winHeight/4.1;
            tu_big_w=winWidth/4.5;
            tu_big_h=winHeight/2.2;
            text_h=winHeight/2.02;
        }//else if(winWidth<1700 && winWidth>1400){
        //     tu_w=winWidth/4.5;
        //     tu_h=winHeight/4.3;
        //     tu_big_w=winWidth/4.5;
        //     tu_big_h=winHeight/2.2;
        //     text_h=winHeight/2.22;
        // }

        $(".tu").css('width',tu_w);
        $(".tu").css( 'height', tu_h);
        $(".text").css( 'height', text_h);
        $(".tu_big").css('width',tu_big_w);
        $(".tu_big").css( 'height', tu_big_h);
        var pqBar= echarts.init(document.getElementById('pqBar'));
        var statusPie= echarts.init(document.getElementById('statusPie'));
        var oldmanPie=echarts.init(document.getElementById('oldmanPie'));
        var zdPie=echarts.init(document.getElementById('zdPie'));
    </script>
</div>
<#include "../set.ftl" />

</body>
<script>
    //片区人数分布
    // legend_data="";
    // title_text='片区老年人口分布柱状';
    // yAxis_data=['东兰','古龙','平南','平阳','平吉','古美'];
    // series=[
    //     {
    //         name: '',
    //         type: 'bar',
    //         stack: '总量',
    //         label: {
    //             normal: {
    //                 show: true,
    //                 position: 'right',
    //                 textStyle:{
    //                     fontSize:series_lebel_fontSize
    //                 }
    //             }
    //         },
    //         itemStyle:{
    //             normal: {
    //                 color:series_color_1,
    //                 fontSize:series_item_fontSize
    //             }
    //         },
    //         data: [131,163,214,234,334,467]
    //     }
    // ];
    // var option_pq_bar=chartBar(title_text,legend_data,yAxis_data,series);

    //re
    var posList = [
        'left', 'right', 'top', 'bottom',
        'inside',
        'insideTop', 'insideLeft', 'insideRight', 'insideBottom',
        'insideTopLeft', 'insideTopRight', 'insideBottomLeft', 'insideBottomRight'
    ];

    pqBar.configParameters = {
        rotate: {
            min: -90,
            max: 90
        },
        align: {
            options: {
                left: 'left',
                center: 'center',
                right: 'right'
            }
        },
        verticalAlign: {
            options: {
                top: 'top',
                middle: 'middle',
                bottom: 'bottom'
            }
        },
        position: {
            options: echarts.util.reduce(posList, function (map, pos) {
                map[pos] = pos;
                return map;
            }, {})
        },
        distance: {
            min: 0,
            max: 100
        }
    };

    pqBar.config = {
        rotate: 90,
        align: 'left',
        verticalAlign: 'middle',
        position: 'insideBottom',
        distance: 15,
        onChange: function () {
            var labelOption = {
                normal: {
                    rotate: pqBar.config.rotate,
                    align: pqBar.config.align,
                    verticalAlign: pqBar.config.verticalAlign,
                    position: pqBar.config.position,
                    distance: pqBar.config.distance
                }
            };
            pqBar.setOption({
                series: [{
                    label: labelOption
                }, {
                    label: labelOption
                }, {
                    label: labelOption
                }, {
                    label: labelOption
                }]
            });
        }
    };


    var labelOption = {
        normal: {
            show: true,
            position: pqBar.config.position,
            distance: pqBar.config.distance,
            align: pqBar.config.align,
            verticalAlign: pqBar.config.verticalAlign,
            rotate: pqBar.config.rotate,
            formatter: '{c}',
            fontSize: 16,
            rich: {
                name: {
                    textBorderColor: '#fff'
                }
            }
        }
    };

    option = {
        //color: ['#003366', '#006699', '#4cabce', '#e5323e'],
        title: {
            text:'片区老年人口分布柱状',
            textStyle:{
                color:'#fff',
                fontSize:title_fontSize,
                fontWeight:100
            },
            x:'0%',
            y:'0%',
        },
        color: ['#ffd289'],
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'shadow'
            }
        },
        legend: {
            data: ['']
        },
        toolbox: {
            show: true,
            orient: 'vertical',
            left: 'right',
            top: 'center',
            feature: {
                mark: {show: true},
                dataView: {show: true, readOnly: false},
                magicType: {show: true, type: ['line', 'bar', 'stack', 'tiled']},
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
        calculable: true,
        xAxis: [
            {
                type: 'category',
                axisTick: {show: false},
                data: ['东兰','古龙','平南','平阳','平吉','古美'],
                axisLine:{
                    lineStyle:{
                        color:'white',
                        fontSize: 20
                    }
                },
            }
        ],
        yAxis: [
            {
                type: 'value',
                axisLine:{
                    lineStyle:{
                        color:'white',
                        fontSize: 20
                    }
                },
            }
        ],
        series: [
            {
                type: 'bar',
                barGap: 0,
                label: labelOption,
                data: [320, 332, 301, 334, 390,440],
                barWidth: 20,//柱图宽度
                itemStyle: {
                    normal: {
                        barBorderRadius: 20,
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: '#99d9ea'
                        }, {
                            offset: 1,
                            color: 'rgba(0,188,226, 0.5)'
                        }]),
                        shadowColor: 'rgba(0, 0, 0, 0.4)',
                        shadowBlur: 20,
                    }
                }

            },

        ]
    };
    pqBar.setOption(option);

    //养老状态
    title_text="养老状态分布饼图";
    legend_data=[{name:'机构养老',textStyle:{color:legend_color,fontSize:legand_fontSize}},{name:'社区养老',textStyle:{color:legend_color,fontSize:legand_fontSize}},{name:'居家养老',textStyle:{color:legend_color,fontSize:legand_fontSize}}];
    series=[{
        name: '老养老状态',
        type: 'pie',
        radius : '45%',
        label : {
            normal : {
                formatter: '{d}%\n({c})',
                textStyle : {
                    fontWeight : 'normal',
                    fontSize : series_lebel_fontSize
                }
            }
        },
        center: ['48%', '60%'],
        data:[
            {value:476, name:'机构养老'},
            {value:376, name:'社区养老'},
            {value:276, name:'居家养老'}
        ],
        itemStyle: {
            emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
        }
    }];
    var option_status_pie = chartPie(title_text,legend_data,series);


    //60岁老人占比
    title_text="老人\n\n比例";
    legend_data=[{name:'老人',textStyle:{color:legend_color,fontSize:legand_fontSize}},{name:'非老人',textStyle:{color:legend_color,fontSize:legand_fontSize}}];
    series=[
        {
            name:'访问来源',
            type:'pie',
            radius: ['50%', '70%'],
            avoidLabelOverlap: false,
            label: {
                normal : {
                    formatter: '{d}%\n({c})',
                    textStyle : {
                        fontWeight : 'normal',
                        fontSize : series_lebel_fontSize
                    }
                }
            },
            data:[
                {value:15360, name:'非老人'},
                {value:4310, name:'老人'}
            ]
        }
    ];
    var option_oldman_pie = chartPie(title_text,legend_data,series);

    //重点老人占比
    title_text="80岁及\n\n以上\n\n老人比例";
    legend_data=[{name:'80岁及以上',textStyle:{color:legend_color,fontSize:legand_fontSize}},{name:'80岁以下',textStyle:{color:legend_color,fontSize:legand_fontSize}}];
    series=[
        {
            name:'访问来源',
            type:'pie',
            radius: ['50%', '70%'],
            avoidLabelOverlap: false,
            label: {
                normal : {
                    formatter: '{d}%\n({c})',
                    textStyle : {
                        fontWeight : 'normal',
                        fontSize : 15
                    }
                }
            },
            data:[
                {value:1360, name:'80岁以下'},
                {value:234, name:'80岁及以上'}
            ]
        }
    ];
    var option_zd_pie = chartPie(title_text,legend_data,series);


    statusPie.setOption(option_status_pie);
    oldmanPie.setOption(option_oldman_pie);
    zdPie.setOption(option_zd_pie);
</script>
</html>