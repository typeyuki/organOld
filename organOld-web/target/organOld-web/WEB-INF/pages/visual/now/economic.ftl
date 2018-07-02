<style>
    @media only screen and (min-width: 6000px){
        .economic_tu,.economic_tu_big{
            padding-top: 5%;
            padding-bottom: 2%;
        }
    }
</style>
<div id="child_economic" style="display: none">
    <div class="row" >
        <div class="col-lg-6 box"  align="center">
            <div class="zz"></div>
            <div id="economic_economicPie" class="economic_tu_big"></div>
        </div>
        <div class="col-lg-6 box">
            <div class="zz"></div>
            <div id="economic_economicLine" class="economic_tu_big"></div>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-4 box">
            <div class="zz"></div>
            <div id="economic_hjPie" class="economic_tu"></div>
        </div>
        <div class="col-lg-4 box line">
            <div class="zz"></div>
            <div id="economic_sexPie" class="economic_tu"></div>
        </div>
        <div class="col-lg-4 box" >
            <div class="zz"></div>
            <div id="economic_ageBar" class="economic_tu"></div>
        </div>
    </div>
</div>
<script type="text/javascript">
    var economic_tu_w,economic_tu_h,economic_tu_big_w,economic_tu_big_h;
    var economic_width=$("#oldman").width();
    if(winWidth>=1900){
        economic_tu_w=economic_width/3.2;
        economic_tu_h=winHeight/4.4;
        economic_tu_big_w=economic_width/2.2;
        economic_tu_big_h=winHeight/4.4;
    }else if(winWidth<=1400 && winWidth>=1300){
        oldman_tu_w=winWidth/4.5;
        oldman_tu_h=winHeight/4.1;
    }

    $(".economic_tu_big").css('width',economic_tu_big_w);
    $(".economic_tu_big").css( 'height', economic_tu_big_h);
    $(".economic_tu").css('width',economic_tu_w);
    $(".economic_tu").css( 'height', economic_tu_h);

    var economic_ageBar = echarts.init(document.getElementById('economic_ageBar'));
    var economic_sexPie= echarts.init(document.getElementById('economic_sexPie'));
    var economic_hjPie= echarts.init(document.getElementById('economic_hjPie'));
    var economic_economicLine = echarts.init(document.getElementById('economic_economicLine'));
    var economic_economicPie= echarts.init(document.getElementById('economic_economicPie'));
</script>
<script>
    //经济条件
    title_text="经济条件分布饼图";
    legend_data=[{name:'帮困',textStyle:{color:legend_color,fontSize:18}},{name:'低保',textStyle:{color:legend_color,fontSize:18}}
        ,{name:'养老保险',textStyle:{color:legend_color,fontSize:18}},{name:'医疗救助金',textStyle:{color:legend_color,fontSize:18}},
        {name:'城镇医保',textStyle:{color:legend_color,fontSize:18}},{name:'其他',textStyle:{color:legend_color,fontSize:18}}];
    series=[{
        name: '老人经济条件',
        type: 'pie',
        radius : '45%',
        label : {
            normal : {
                formatter: '{d}%\n({c})',
                textStyle : {
                    fontWeight : 'normal',
                    fontSize : 20
                }
            }
        },
        center: ['48%', '60%'],
        data:[
            {value:476, name:'帮困'},
            {value:376, name:'低保'},
            {value:376, name:'养老保险'},
            {value:376, name:'医疗救助金'},
            {value:376, name:'城镇医保'},
            {value:376, name:'其他'}
        ],
        itemStyle: {
            emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
        }
    }];
    var economic_option_economic_pie = chartPie(title_text,legend_data,series);
    //经济条件增长趋势图
    title_text='经济条件变化趋势图';
    legend_data=[{name:'帮困',textStyle:{color:legend_color,fontSize:18}},{name:'低保',textStyle:{color:legend_color,fontSize:18}}
        ,{name:'养老保险',textStyle:{color:legend_color,fontSize:18}},{name:'医疗救助金',textStyle:{color:legend_color,fontSize:18}},
        {name:'城镇医保',textStyle:{color:legend_color,fontSize:18}},{name:'其他',textStyle:{color:legend_color,fontSize:18}}];
    xAxis_data=['2月','3月','4月','今天','6月','7月','8月'];
    series=[
        {
            name: '帮困',
            type: 'line',
            itemStyle:{
                normal: {
                    lineStyle:{
                        width:1,
                        color:series_color_1
                    },
                    label : {
                        show: true
                    },
                    color:"yellow"
                }
            },
            label:{
                normal:{
                    textStyle:{
                        fontSize:20
                    }

                }

            },
            markLine: {
                itemStyle: {
                    normal: {lineStyle: {type: 'solid', color: 'orange'}, label: {show: true, position: 'left', textStyle:{color:'red',fontSize:20}}}
                },
                large: true,
                symbol:"diamond",
                symbolSize: 12,
                effect: {
                    show: false,
                    loop: true,
                    period: 0,
                    scaleSize: 2,
                    color: null,
                    shadowColor: null,
                    shadowBlur: null
                },
                data: [
                    [
                        {
                            coord: [3, 0]
                        },
                        {
                            coord: [3, 55]
                        }
                    ]
                ]
            },
            symbolSize: 8,
            data: [40,45,50,{

                value : 55,

                symbol: 'circle', // 数据级个性化拐点图形

                symbolSize : 20,

                hoverAnimation :true,
                label:{
                    show:true,
                    fontSize:18
                },
                itemStyle:{

                    normal:{
                        color:'white'
                    }}},55,55,55]
        },
        {
            name: '低保',
            type: 'line',
            itemStyle:{
                normal: {
                    lineStyle:{
                        width:1,
                        color:series_color_2
                    },
                    label : {
                        show: true
                    },
                    color:"yellow"
                }
            },
            label:{
                normal:{
                    textStyle:{
                        fontSize:20
                    }

                }

            },

            markLine: {
                itemStyle: {
                    normal: {lineStyle: {type: 'solid', color: 'orange'}, label: {show: true, position: 'left', textStyle:{color:'red',fontSize:20}}}
                },
                large: true,
                symbol:"diamond",
                symbolSize: 12,
                effect: {
                    show: false,
                    loop: true,
                    period: 0,
                    scaleSize: 2,
                    color: null,
                    shadowColor: null,
                    shadowBlur: null
                },
                data: [
                    [
                        {
                            coord: [3, 0]
                        },
                        {
                            coord: [3, 10]
                        }
                    ]
                ]
            },
            symbolSize: 8,
            data: [10,15,10,{

                value : 10,

                symbol: 'circle', // 数据级个性化拐点图形

                symbolSize : 20,

                hoverAnimation :true,
                label:{
                    show:true,
                    fontSize:18
                },
                itemStyle:{

                    normal:{
                        color:'white'
                    }}},10,10,10]
        }
        ,
        {
            name: '养老保险',
            type: 'line',
            itemStyle:{
                normal: {
                    lineStyle:{
                        width:1,
                        color:series_color_3
                    },
                    label : {
                        show: true
                    },
                    color:"yellow"
                }
            },
            label:{
                normal:{
                    textStyle:{
                        fontSize:20
                    }

                }

            },
            markLine: {
                itemStyle: {
                    normal: {lineStyle: {type: 'solid', color: 'orange'}, label: {show: true, position: 'left', textStyle:{color:'red',fontSize:20}}}
                },
                large: true,
                symbol:"diamond",
                symbolSize: 12,
                effect: {
                    show: false,
                    loop: true,
                    period: 0,
                    scaleSize: 2,
                    color: null,
                    shadowColor: null,
                    shadowBlur: null
                },
                data: [
                    [
                        {
                            coord: [3, 0]
                        },
                        {
                            coord: [3, 20]
                        }
                    ]
                ]
            },
            symbolSize: 8,
            data: [20,15,10,{

                value : 20,

                symbol: 'circle', // 数据级个性化拐点图形

                symbolSize : 20,

                hoverAnimation :true,
                label:{
                    show:true,
                    fontSize:18
                },
                itemStyle:{

                    normal:{
                        color:'white'
                    }}},21,20,20]
        }
        ,
        {
            name: '医疗救助金',
            type: 'line',
            itemStyle:{
                normal: {
                    lineStyle:{
                        width:1,
                        color:series_color_4
                    },
                    label : {
                        show: true
                    },
                    color:"yellow"
                }
            },
            label:{
                normal:{
                    textStyle:{
                        fontSize:20
                    }

                }

            },
            markLine: {
                itemStyle: {
                    normal: {lineStyle: {type: 'solid', color: 'orange'}, label: {show: true, position: 'left', textStyle:{color:'red',fontSize:20}}}
                },
                large: true,
                symbol:"diamond",
                symbolSize: 12,
                effect: {
                    show: false,
                    loop: true,
                    period: 0,
                    scaleSize: 2,
                    color: null,
                    shadowColor: null,
                    shadowBlur: null
                },
                data: [
                    [
                        {
                            coord: [3, 0]
                        },
                        {
                            coord: [3, 30]
                        }
                    ]
                ]
            },
            symbolSize: 8,
            data: [12,15,10,{

                value : 30,

                symbol: 'circle', // 数据级个性化拐点图形

                symbolSize : 20,

                hoverAnimation :true,
                label:{
                    show:true,
                    fontSize:18
                },
                itemStyle:{

                    normal:{
                        color:'white'
                    }}},30,30,30]
        }
        ,
        {
            name: '城镇医保',
            type: 'line',
            itemStyle:{
                normal: {
                    lineStyle:{
                        width:1,
                        color:series_color_5
                    },
                    label : {
                        show: true
                    },
                    color:"yellow"
                }
            },
            label:{
                normal:{
                    textStyle:{
                        fontSize:20
                    }

                }

            },
            markLine: {
                itemStyle: {
                    normal: {lineStyle: {type: 'solid', color: 'orange'}, label: {show: true, position: 'left', textStyle:{color:'red',fontSize:20}}}
                },
                large: true,
                symbol:"diamond",
                symbolSize: 12,
                effect: {
                    show: false,
                    loop: true,
                    period: 0,
                    scaleSize: 2,
                    color: null,
                    shadowColor: null,
                    shadowBlur: null
                },
                data: [
                    [
                        {
                            coord: [3, 0]
                        },
                        {
                            coord: [3, 40]
                        }
                    ]
                ]
            },
            symbolSize: 8,
            data: [10,15,30,{

                value : 40,

                symbol: 'circle', // 数据级个性化拐点图形

                symbolSize : 20,

                hoverAnimation :true,
                label:{
                    show:true,
                    fontSize:18
                },
                itemStyle:{

                    normal:{
                        color:'white'
                    }}},40,40,40]
        }
        ,
        {
            name: '其他',
            type: 'line',
            itemStyle:{
                normal: {
                    lineStyle:{
                        width:1,
                        color:series_color_7
                    },
                    label : {
                        show: true
                    },
                    color:"yellow"
                }
            },
            label:{
                normal:{
                    textStyle:{
                        fontSize:20
                    }

                }

            },
            markLine: {
                itemStyle: {
                    normal: {lineStyle: {type: 'solid', color: 'orange'}, label: {show: true, position: 'left', textStyle:{color:'red',fontSize:20}}}
                },
                large: true,
                symbol:"diamond",
                symbolSize: 12,
                effect: {
                    show: false,
                    loop: true,
                    period: 0,
                    scaleSize: 2,
                    color: null,
                    shadowColor: null,
                    shadowBlur: null
                },
                data: [
                    [
                        {
                            coord: [3, 0]
                        },
                        {
                            coord: [3, 40]
                        }
                    ]
                ]
            },
            symbolSize: 8,
            data: [10,15,30,{

                value : 40,

                symbol: 'circle', // 数据级个性化拐点图形

                symbolSize : 20,

                hoverAnimation :true,
                label:{
                    show:true,
                    fontSize:18
                },
                itemStyle:{

                    normal:{
                        color:'white'
                    }}},32,32,32]
        }
    ];
    var economic_option_economic_line = chartLine(title_text,legend_data,xAxis_data,series);

    title_text="户籍分布饼图";
    legend_data=[{name:'户籍',textStyle:{color:legend_color,fontSize:18}},{name:'非户籍',textStyle:{color:legend_color,fontSize:18}}];
    series=[{
        name: '老人户籍',
        type: 'pie',
        radius : '43%',
        center: ['48%', '60%'],
        label : {
            normal : {
                formatter: '{d}%\n({c})',
                textStyle : {
                    fontWeight : 'normal',
                    fontSize : 20
                }
            }
        },
        data:[
            {value:476, name:'户籍'},
            {value:376, name:'非户籍'}
        ],
        itemStyle: {
            emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
        }
    }];
    var economic_option_area_pie = chartPie(title_text,legend_data,series);

    //性别饼图
    title_text="性别分布饼图";
    legend_data=[{name:'男',textStyle:{color:legend_color,fontSize:18}},{name:'女',textStyle:{color:legend_color,fontSize:18}}];
    series=[{
        name: '老人性别',
        type: 'pie',
        radius : '43%',
        label : {
            normal : {
                formatter: '{d}%\n({c})',
                textStyle : {
                    fontWeight : 'normal',
                    fontSize : 20
                }
            }
        },
        center: ['48%', '60%'],
        data:[
            {value:476, name:'男'},
            {value:376, name:'女'}
        ],
        itemStyle: {
            emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
        }
    }];
    var economic_option_sex_pie = chartPie(title_text,legend_data,series);


    //    年龄分布柱状图
    title_text='年龄分布柱状图';
    legend_data=[
        {
            name:'男',
            textStyle:{
                color:'#fff',
                fontSize:18
            }
        },
        {
            name:'女',
            textStyle:{
                color:'#fff',
                fontSize:18
            }}
    ];
    yAxis_data=['90-','80-90','70-80','60-70'];
    series=[
        {
            name: '男',
            type: 'bar',
            stack: '总量',
            label: {
                normal: {
                    show: true,
                    position: 'insideLeft',
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
            data: [67,134,234,534]
        },
        {
            name: '女',
            type: 'bar',
            stack: '总量',
            label: {
                normal: {
                    show: true,
                    position: 'insideRight',
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
            data: [7,34,134,234]
        }
    ];
    var economic_option_age_bar=chartBar(title_text,legend_data,yAxis_data,series);


    economic_economicPie.setOption(economic_option_economic_pie);
    economic_economicLine.setOption(economic_option_economic_line);
    economic_hjPie.setOption(economic_option_area_pie);
    economic_sexPie.setOption(economic_option_sex_pie);
    economic_ageBar.setOption(economic_option_age_bar);

</script>