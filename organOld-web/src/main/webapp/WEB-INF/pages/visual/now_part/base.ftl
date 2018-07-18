<!DOCTYPE html>
<html>

<head>
<#include "../head.ftl" />
</head>

<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-6">
            <div class="row" align="center">
                <div class="col-lg-12">
                    <div class="row">
                        <div class="col-lg-12">
                            <p class="map_title" onclick="location.href='/visual/now/part/oldman'" style="cursor: pointer">古美路街道老人数量分布热力图</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12">
                            <#include "map.ftl"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row" style="position: relative;right: 5px;top:5px">
                <#include "table.ftl"/>
            </div>
        </div>
        <div class="col-lg-6">
            <div class="row" >
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
        var tu_w,tu_h;
        if(winWidth>=1700){
            //家里电脑的分辨率
            tu_w=winWidth/4.5;
            tu_h=winHeight/4.37;
        }else if(winWidth<=1400 && winWidth>=1300){
            tu_w=winWidth/4.5;
            tu_h=winHeight/4.37;
        }
        $(".tu").css('width',tu_w);
        $(".tu").css( 'height', tu_h);

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