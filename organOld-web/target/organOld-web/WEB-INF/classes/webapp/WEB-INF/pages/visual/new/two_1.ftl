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
        .tu{
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
    </style>
</head>

<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-6">
            <div class="row" align="center">
                <div class="col-lg-12">
                    <p class="map_title">古美街道老人分布图</p>
                    <img src="/static/img/map/gumei_9.jpg" style="width: 60%;">
                </div>
            </div>
            <div class="row" style="position: relative;right: 5px;top:5px">
                <div class="wrapper wrapper-content animated fadeInRight box">
                    <div class="zz"></div>
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="ibox float-e-margins">
                                <div class="ibox-content">
                                    <input class="name" type="hidden">
                                    <input class="sex" type="hidden" >
                                    <input class="age" type="hidden" >
                                    <input class="address" type="hidden">
                                    <input class="jw" type="hidden">
                                    <table class="table table-striped table-bordered table-hover dataTables-example">
                                        <thead>
                                        <tr>
                                            <th>姓名</th>
                                            <th>性别</th>
                                            <th>年龄</th>
                                            <th>身份证号</th>
                                            <th>片区</th>
                                            <th>所属居委会</th>
                                            <th>住址</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <div class="col-lg-6">
            <div class="row" style="margin-top: 30px">
                <div class="col-lg-6 box">
                    <div class="zz"></div>
                    <div id="zbPie" class="tu"></div>
                </div>
                <div class="col-lg-6 box line">
                    <div class="zz"></div>
                    <div id="numLine" class="tu"></div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6 box">
                    <div class="zz"></div>
                    <div id="hjPie" class="tu"></div>
                </div>
                <div class="col-lg-6 box line">
                    <div class="zz"></div>
                    <div id="hjLine" class="tu"></div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6 box">
                    <div class="zz"></div>
                    <div id="sexPie" class="tu"></div>
                </div>
                <div class="col-lg-6 box line">
                    <div class="zz"></div>
                    <div id="sexLine" class="tu"></div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6 box">
                    <div class="zz"></div>
                    <div id="ageBar" class="tu"></div>
                </div>
                <div class="col-lg-6 box line">
                    <div class="zz"></div>
                    <div id="ageLine" class="tu"></div>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript">
        $(".tu").css('width',winWidth/4.5);
        $(".tu").css( 'height', winHeight/4.37);

        var numLine = echarts.init(document.getElementById('numLine'));
        var ageBar = echarts.init(document.getElementById('ageBar'));
        var ageLine = echarts.init(document.getElementById('ageLine'));
        var sexLine = echarts.init(document.getElementById('sexLine'));
        var hjLine = echarts.init(document.getElementById('hjLine'));
        var sexPie= echarts.init(document.getElementById('sexPie'));
        var hjPie= echarts.init(document.getElementById('hjPie'));
        var zbPie= echarts.init(document.getElementById('zbPie'));
    </script>
</div>


</body>
<script>
    title_text="老人比例";
    legend_data=[{name:'老人',textStyle:{color:legend_color,fontSize:18}},{name:'非老人',textStyle:{color:legend_color,fontSize:18}}];
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
                        fontWeight : 100,
                        fontSize : 26
                    }
                }
            },
            data:[
                {value:15360, name:'非老人'},
                {value:4310, name:'老人'}
            ]
        }
    ];
    var option_zb_pie = chartPie(title_text,legend_data,series);
    zbPie.setOption(option_zb_pie);

    title_text='老人数量变化趋势';
    legend_data=[{name:'老人',textStyle:{color:legend_color,fontSize:18}},{name:'总人口',textStyle:{color:legend_color,fontSize:18}}];
    xAxis_data=['2月','3月','4月','今天','6月','7月','8月'];
    series=[
        {
            name: '老人',
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
                    color:series_color_1

                },
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
                            coord: [3, 220]
                        }
                    ]
                ]
            },
            symbolSize: 8,//拐点大小
            data: [210,210,215,{

                value : 220,

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
                    }}},225,230,253]
        },
        {
            name: '总人口',
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
                            coord: [3, 420]
                        }
                    ]
                ]
            },
            symbolSize: 8,//拐点大小
            data: [410,410,415,{

                value : 420,

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
                    }}},425,430,453]
        }
    ];
    var option_num_line = chartLine(title_text,legend_data,xAxis_data,series);


    title_text="户籍分布饼图";
    legend_data=[{name:'户籍',textStyle:{color:legend_color,fontSize:18}},{name:'非户籍',textStyle:{color:legend_color,fontSize:18}}];
    series=[{
        name: '老人户籍',
        type: 'pie',
        radius : '55%',
        center: ['48%', '60%'],
        label : {
            normal : {
                formatter: '{d}%\n({c})',
                textStyle : {
                    fontWeight : 100,
                    fontSize : 26
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
    var option_area_pie = chartPie(title_text,legend_data,series);

    title_text='户籍占比趋势图';
    legend_data=[{name:'户籍',textStyle:{color:legend_color,fontSize:18}},{name:'非户籍',textStyle:{color:legend_color,fontSize:18}}];
    xAxis_data=['2月','3月','4月','今天','6月','7月','8月'];
    series=[
        {
            name:'户籍',
            type:'bar',
            stack: '广告',
            data:[80, 79, 80, 74, 78, 80, 81]
        },
        {
            name:'非户籍',
            type:'bar',
            stack: '广告',
            data:[20, 21, 20, 26, 22, 20, 19]
        }
    ];
    var option_area_line=chartBarHei(title_text,legend_data,xAxis_data,series);


    title_text="性别分布饼图";
    legend_data=[{name:'男',textStyle:{color:legend_color,fontSize:18}},{name:'女',textStyle:{color:legend_color,fontSize:18}}];
    series=[{
        name: '老人性别',
        type: 'pie',
        radius : '55%',
        label : {
            normal : {
                formatter: '{d}%\n({c})',
                textStyle : {
                    fontWeight : 100,
                    fontSize : 26
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

    title_text='性别占比趋势图';
    legend_data=[{name:'男',textStyle:{color:legend_color,fontSize:18}},{name:'女',textStyle:{color:legend_color,fontSize:18}}];
    xAxis_data=['2月','3月','4月','今天','6月','7月','8月'];
    series=[
        {
            name:'男',
            type:'bar',
            stack: '广告',
            data:[80, 79, 80, 74, 78, 80, 81]
        },
        {
            name:'女',
            type:'bar',
            stack: '广告',
            data:[20, 21, 20, 26, 22, 20, 19]
        }
    ];
    var option_sex_line=chartBarHei(title_text,legend_data,xAxis_data,series);



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
                    color:series_color_1,
                    fontSize:26
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
                    color:series_color_2,

                }
            },
            data: [7,34,134,234]
        }
    ];
    var option_age_bar=chartBar(title_text,legend_data,yAxis_data,series);

    title_text='年龄占比趋势图';
    legend_data=[{name:'60-70',textStyle:{color:legend_color,fontSize:18}},{name:'70-80',textStyle:{color:legend_color,fontSize:18}},
        {name:'80-90',textStyle:{color:legend_color,fontSize:18}},{name:'90-',textStyle:{color:legend_color,fontSize:18}}];
    xAxis_data=['2月','3月','4月','今天','6月','7月','8月'];
    series=[
        {
            name:'60-70',
            type:'bar',
            stack: '广告',
            data:[40, 37, 40, 22, 34, 40, 43]
        },
        {
            name:'70-80',
            type:'bar',
            stack: '广告',
            data:[20, 21, 20, 26, 22, 20, 19]
        },
        {
            name:'80-90',
            type:'bar',
            stack: '广告',
            data:[20, 21, 20, 26, 22, 20, 19]
        },
        {
            name:'90-',
            type:'bar',
            stack: '广告',
            data:[20, 21, 20, 26, 22, 20, 19]
        }
    ];
    var option_age_line=chartBarHei_1(title_text,legend_data,xAxis_data,series);


    numLine.setOption(option_num_line);
    hjPie.setOption(option_area_pie);
    hjLine.setOption(option_area_line);
    sexPie.setOption(option_sex_pie);
    sexLine.setOption(option_sex_line);
    ageBar.setOption(option_age_bar);
    ageLine.setOption(option_age_line);

</script>
</html>