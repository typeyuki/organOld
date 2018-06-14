<!DOCTYPE html>
<html>

<head>
    <#include "head.ftl" />
    <style>
        .chart_left{
            margin-bottom: 1%;
            /*background-color: rgb(16, 58, 68);*/
        }
        .line{
            position: relative;
            left:10px;
        }
        h2,p,td,h3,h1,span{
            color: white!important;
        }
        .tu_left,.tu_right{
            padding-top: 5%;
        }
    </style>
</head>

<body >
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-6" style="margin-top: 3%">
            <div class="row chart_left">
                <div class="col-lg-12 ">
                    <div class="col-md-6 box" align="center">
                        <div class="zz"></div>
                        <div id="ageBar" class="tu_left"></div>
                    </div>
                    <div class="col-md-6 box line" align="center">
                        <div class="zz"></div>
                        <div id="ageLine" class="tu_left"></div>
                    </div>
                </div>
            </div>
            <div class="row chart_left">
                <div class="col-lg-12">
                    <div class="col-lg-6 box" align="center">
                        <div class="zz"></div>
                        <div id="sexPie" class="tu_left"></div>
                    </div>
                    <div class="col-lg-6 box line" align="center">
                        <div class="zz"></div>
                        <div id="sexLine" class="tu_left"></div>
                    </div>
                </div>
            </div>
            <div class="row chart_left">
                <div class="col-lg-12">
                    <div class="col-lg-6 box" align="center">
                        <div class="zz"></div>
                        <div id="areaPie" class="tu_left"></div>
                    </div>
                    <div class="col-lg-6 box line" align="center">
                        <div class="zz"></div>
                        <div id="areaLine" class="tu_left"></div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-6">
            <div class="row chart_left">
                <div class="col-lg-12">
                    <div class="col-lg-6 box"  align="center">
                        <div class="zz"></div>
                        <div id="familyPie" class="tu_right"></div>
                    </div>
                    <div class="col-lg-6 box line">
                        <div class="zz"></div>
                        <div id="familyLine" class="tu_right line"></div>
                    </div>
                </div>
            </div>
            <div class="row chart_left">
                <div class="col-lg-12">
                    <div class="col-lg-6 box" align="center">
                        <div class="zz"></div>
                        <div id="econmicPie" class="tu_right"></div>
                    </div>
                    <div class="col-lg-6 box line">
                        <div class="zz"></div>
                        <div id="econmicLine" class="tu_right line"></div>
                    </div>
                </div>
            </div>
            <div class="row chart_left">
                <div class="col-lg-12">
                    <div class="col-lg-6 box" align="center">
                        <div class="zz"></div>
                        <div id="healthPie" class="tu_right"></div>
                    </div>
                    <div class="col-lg-6 box line" align="center">
                        <div class="zz"></div>
                        <div id="healthLine" class="tu_right line"></div>
                    </div>
                </div>
            </div>
            <div class="row chart_left">
                <div class="col-lg-12">
                    <div class="col-lg-6 box" align="center">
                        <div class="zz"></div>
                        <div id="statusPie" class="tu_right"></div>
                    </div>
                    <div class="col-lg-6 box line">
                        <div class="zz"></div>
                        <div id="statusLine" class="tu_right line"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript">
        $(".tu_left").css('width',winWidth/5);
        $(".tu_left").css( 'height', winHeight/3.7);
        $(".tu_right").css('width',winWidth/5);
        $(".tu_right").css( 'height', winHeight/4);


        var ageBar = echarts.init(document.getElementById('ageBar'));
        var ageLine = echarts.init(document.getElementById('ageLine'));
        var sexLine = echarts.init(document.getElementById('sexLine'));
        var familyLine = echarts.init(document.getElementById('familyLine'));
        var areaLine = echarts.init(document.getElementById('areaLine'));
        var econmicLine = echarts.init(document.getElementById('econmicLine'));
        var statusLine = echarts.init(document.getElementById('statusLine'));
        var healthLine = echarts.init(document.getElementById('healthLine'));
        var sexPie= echarts.init(document.getElementById('sexPie'));
        var familyPie= echarts.init(document.getElementById('familyPie'));
        var econmicPie= echarts.init(document.getElementById('econmicPie'));
        var areaPie= echarts.init(document.getElementById('areaPie'));
        var statusPie= echarts.init(document.getElementById('statusPie'));
        var healthPie= echarts.init(document.getElementById('healthPie'));

    </script>
</div>

<#include "set.ftl" />
</body>

<script type="text/javascript">
//    年龄分布柱状图
    title_text='年龄分布柱状图';
    legend_data=[
        {
            name:'男',
            textStyle:{
                color:'#fff'
            }
        },
        {
            name:'女',
            textStyle:{
                color:'#fff'
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
                    position: 'insideRight'
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
    var option_age_bar=chartBar(title_text,legend_data,yAxis_data,series);
    //年龄分布折线图
    title_text='增长趋势图';
    legend_data=[{name:'60-70',textStyle:{color:legend_color}},{name:'70-80',textStyle:{color:legend_color}},
        {name:'80-90',textStyle:{color:legend_color}},{name:'90-',textStyle:{color:legend_color}}];
    xAxis_data=['1月','2月','3月','4月'];
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
            symbolSize: 8,//拐点大小
            data: [210,210,215,220]
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
            data: [110,110,115,120]
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
            data: [70,80,85,90]
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
            data: [60,70,75,80]
        }
    ];
    var option_age_line = chartLine(title_text,legend_data,xAxis_data,series);
    //性别饼图
    title_text="性别分布饼图";
    legend_data=[{name:'男',textStyle:{color:legend_color}},{name:'女',textStyle:{color:legend_color}}];
    series=[{
        name: '老人性别',
        type: 'pie',
        radius : '55%',
        label : {
            normal : {
                formatter: '{d}%\n({c})',
                textStyle : {
                    fontWeight : 'normal',
                    fontSize : 10
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
    var option_sex_pie = chartPie(title_text,legend_data,series);
    //性别增长趋势图
    title_text='增长趋势图';
    xAxis_data=['1月','2月','3月','4月'];
    series=[
        {
            name: '男',
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
            data: [210,210,215,220]
        },
        {
            name: '女',
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
            data: [110,110,115,120]
        }
    ];
    var option_sex_line = chartLine(title_text,legend_data,xAxis_data,series);
    //户籍
    title_text="户籍分布饼图";
    legend_data=[{name:'本地',textStyle:{color:legend_color}},{name:'外地',textStyle:{color:legend_color}}];
    series=[{
        name: '老人户籍',
        type: 'pie',
        radius : '55%',
        center: ['48%', '60%'],
        label : {
            normal : {
                formatter: '{d}%\n({c})',
                textStyle : {
                    fontWeight : 'normal',
                    fontSize : 10
                }
            }
        },
        data:[
            {value:476, name:'本地'},
            {value:376, name:'外地'}
        ],
        itemStyle: {
            emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
        }
    }];
    var option_area_pie = chartPie(title_text,legend_data,series);
    //户籍增长趋势图
    title_text='增长趋势图';
    xAxis_data=['1月','2月','3月','4月'];
    series=[
        {
            name: '本地',
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
            data: [200,205,210,210]
        },
        {
            name: '外地',
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
            data: [100,105,110,110]
        }
    ];
    var option_area_line = chartLine(title_text,legend_data,xAxis_data,series);
    //家庭结构
    title_text="家庭结构分布饼图";
    legend_data=[{name:'纯老',textStyle:{color:legend_color}},{name:'独居',textStyle:{color:legend_color}}
        ,{name:'失独',textStyle:{color:legend_color}},{name:'一老养一老',textStyle:{color:legend_color}},
        {name:'孤老',textStyle:{color:legend_color}}];
    series=[{
        name: '老人家庭结构',
        type: 'pie',
        radius : '45%',
        label : {
            normal : {
                formatter: '{d}%\n({c})',
                textStyle : {
                    fontWeight : 'normal',
                    fontSize : 10
                }
            }
        },
        center: ['48%', '60%'],
        data:[
            {value:476, name:'纯老'},
            {value:376, name:'独居'},
            {value:376, name:'失独'},
            {value:376, name:'一老养一老'},
            {value:376, name:'孤老'}
        ],
        itemStyle: {
            emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
        }
    }];
    var option_family_pie = chartPie(title_text,legend_data,series);
    //家庭结构增长趋势图
    title_text='家庭结构增长趋势图';
    xAxis_data=['1月','2月','3月','4月'];
    series=[
        {
            name: '纯老',
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
            data: [40,45,50,55]
        },
        {
            name: '独居',
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
            data: [10,15,10,10]
        }
        ,
        {
            name: '失独',
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
            data: [20,15,10,20]
        }
        ,
        {
            name: '一老养一老',
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
            data: [12,15,10,30]
        }
        ,
        {
            name: '孤老',
            type: 'line',
            itemStyle:{
                normal: {
                    lineStyle:{
                        width:1,
                        color:series_color_5
                    }
                }
            },
            symbolSize: 8,
            data: [10,15,30,40]
        }
    ];
    var option_family_line = chartLine(title_text,legend_data,xAxis_data,series);
    //经济条件
    title_text="经济条件分布饼图";
    legend_data=[{name:'帮困人员',textStyle:{color:legend_color}},{name:'低保',textStyle:{color:legend_color}}
        ,{name:'养老保险',textStyle:{color:legend_color}},{name:'医疗救助',textStyle:{color:legend_color}},
        {name:'医保',textStyle:{color:legend_color}}];
    series=[{
        name: '老人经济条件',
        type: 'pie',
        radius : '45%',
        label : {
            normal : {
                formatter: '{d}%\n({c})',
                textStyle : {
                    fontWeight : 'normal',
                    fontSize : 10
                }
            }
        },
        center: ['48%', '60%'],
        data:[
            {value:476, name:'帮困人员'},
            {value:376, name:'低保'},
            {value:376, name:'养老保险'},
            {value:376, name:'医疗救助'},
            {value:376, name:'医保'}
        ],
        itemStyle: {
            emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
        }
    }];
    var option_econmic_pie = chartPie(title_text,legend_data,series);
    //经济条件增长趋势图
    title_text='增长趋势图';
    xAxis_data=['1月','2月','3月','4月'];
    series=[
        {
            name: '帮困人员',
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
            data: [200,205,210,210]
        },
        {
            name: '低保',
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
            data: [100,105,110,110]
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
                    }
                }
            },
            symbolSize: 8,
            data: [100,105,110,110]
        }
        ,
        {
            name: '医疗救助',
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
            data: [100,105,110,110]
        }
        ,
        {
            name: '医保',
            type: 'line',
            itemStyle:{
                normal: {
                    lineStyle:{
                        width:1,
                        color:series_color_5
                    }
                }
            },
            symbolSize: 8,
            data: [100,105,110,110]
        }
    ];
    var option_econmic_line = chartLine(title_text,legend_data,xAxis_data,series);
    //健康状态
    title_text="健康状态分布饼图";
    legend_data=[{name:'良',textStyle:{color:legend_color}},{name:'亚健康',textStyle:{color:legend_color}}
        ,{name:'严重',textStyle:{color:legend_color}}];
    series=[{
        name: '老人健康状态',
        type: 'pie',
        radius : '45%',
        center: ['48%', '60%'],
        label : {
            normal : {
                formatter:'{d}%\n({c})',
                textStyle : {
                    fontWeight : 'normal',
                    fontSize : 10
                }
            }
        },
        data:[
            {value:476, name:'良'},
            {value:376, name:'亚健康'},
            {value:376, name:'严重'}
        ],
        itemStyle: {
            emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
        }
    }];
    var option_health_pie = chartPie(title_text,legend_data,series);
    //健康状态增长趋势图
    title_text='增长趋势图';
    xAxis_data=['1月','2月','3月','4月'];
    series=[
        {
            name: '良',
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
            data: [200,205,210,210]
        },
        {
            name: '亚健康',
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
            data: [100,105,110,110]
        }
        ,
        {
            name: '严重',
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
            data: [100,105,110,110]
        }
    ];
    var option_health_line = chartLine(title_text,legend_data,xAxis_data,series);
    //养老状态
    title_text="养老状态分布饼图";
    legend_data=[{name:'机构养老',textStyle:{color:legend_color}},{name:'社区居家养老',textStyle:{color:legend_color}}];
    series=[{
        name: '老养老状态',
        type: 'pie',
        radius : '45%',
        label : {
            normal : {
                formatter: '{d}%\n({c})',
                textStyle : {
                    fontWeight : 'normal',
                    fontSize : 10
                }
            }
        },
        center: ['48%', '60%'],
        data:[
            {value:476, name:'机构养老'},
            {value:376, name:'社区居家养老'}
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
    //养老状态增长趋势图
    title_text='增长趋势图';
    xAxis_data=['1月','2月','3月','4月'];
    series=[
        {
            name: '机构养老',
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
            data: [200,205,210,210]
        },
        {
            name: '社区居家养老',
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
            data: [100,105,110,110]
        }
    ];
    var option_status_line = chartLine(title_text,legend_data,xAxis_data,series);

        ageBar.setOption(option_age_bar);
        ageLine.setOption(option_age_line);
        sexLine.setOption(option_sex_line);
        areaLine.setOption(option_area_line);
        healthLine.setOption(option_health_line);
        econmicLine.setOption(option_econmic_line);
        statusLine.setOption(option_status_line);
        familyLine.setOption(option_family_line);
        sexPie.setOption(option_sex_pie);
        familyPie.setOption(option_family_pie);
        areaPie.setOption(option_area_pie);
        healthPie.setOption(option_health_pie);
        econmicPie.setOption(option_econmic_pie);
        statusPie.setOption(option_status_pie);
</script>
</html>