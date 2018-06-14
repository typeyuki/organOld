<!DOCTYPE html>
<html>

<head>
    <#include "head.ftl" />
    <style>
        .chart_left{
            margin-bottom: 15px;
            background-color: rgb(16, 58, 68);
        }
        .line{
            margin-left: 10px;
        }
        .mr{
            margin-left: -8%;
        }
        .title{
            font-weight: bold;
            font-size: 18px;
            margin-left: -10px;
        }
        h2,p,td,h3,h1,span{
            color: white!important;
        }
    </style>
</head>

<body >
<div class="container-fluid">
    <div class="row">
        <div class="left col-lg-4">
            <div class="row chart_left">
                <div class="col-lg-1" style="margin-top: 5%;">
                    <p class="title">
                        年<br>龄
                    </p>
                </div>
                <div class="col-lg-11 mr">
                    <div class="col-md-6">
                        <div id="ageBar" class="tu"></div>
                    </div>
                    <div class="col-md-6">
                        <div id="ageLine" class="tu line"></div>
                    </div>
                </div>
            </div>
            <div class="row chart_left">
                <div class="col-lg-1" style="margin-top: 5%;">
                    <p class="title">
                        性<br>别
                    </p>
                </div>
                <div class="col-lg-11 mr">
                    <div class="col-lg-6">
                        <div id="sexPie" class="tu"></div>
                    </div>
                    <div class="col-lg-6">
                        <div id="sexLine" class="tu line"></div>
                    </div>
                </div>
            </div>
            <div class="row chart_left">
                <div class="col-lg-1" style="margin-top: 5%;">
                    <p class="title">
                        户<br>籍
                    </p>
                </div>
                <div class="col-lg-11 mr">
                    <div class="col-lg-6">
                        <div id="areaPie" class="tu"></div>
                    </div>
                    <div class="col-lg-6">
                        <div id="areaLine" class="tu line"></div>
                    </div>
                </div>
            </div>
            <div class="row chart_left">
                <div class="col-lg-1" style="margin-top: 5%;">
                    <p class="title">
                        家<br>庭<br>结<br>构
                    </p>
                </div>
                <div class="col-lg-11 mr">
                    <div class="col-lg-6">
                        <div id="familyPie" class="tu"></div>
                    </div>
                    <div class="col-lg-6">
                        <div id="familyLine" class="tu line"></div>
                    </div>
                </div>
            </div>
            <div class="row chart_left">
                <div class="col-lg-1" style="margin-top: 5%;">
                    <p class="title">
                        经<br>济<br>条<br>件
                    </p>
                </div>
                <div class="col-lg-11 mr">
                    <div class="col-lg-6">
                        <div id="econmicPie" class="tu"></div>
                    </div>
                    <div class="col-lg-6">
                        <div id="econmicLine" class="tu line"></div>
                    </div>
                </div>
            </div>
            <div class="row chart_left">
                <div class="col-lg-1" style="margin-top: 5%;">
                    <p class="title">
                        健<br>康<br>状<br>况
                    </p>
                </div>
                <div class="col-lg-11 mr">
                    <div class="col-lg-6">
                        <div id="healthPie" class="tu"></div>
                    </div>
                    <div class="col-lg-6">
                        <div id="healthLine" class="tu line"></div>
                    </div>
                </div>
            </div>
            <div class="row chart_left">
                <div class="col-lg-1" style="margin-top: 5%;">
                    <p class="title">
                        养<br>老<br>状<br>态
                    </p>
                </div>
                <div class="col-lg-11 mr">
                    <div class="col-lg-6">
                        <div id="statusPie" class="tu"></div>
                    </div>
                    <div class="col-lg-6">
                        <div id="statusLine" class="tu line"></div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-8">
            <div class="row">
                <div class="col-lg-8">
                    <p style="font-size:50px;text-align: center;padding-bottom: 20px;font-weight: bold">古&nbsp;&nbsp;美&nbsp;&nbsp;街&nbsp;&nbsp;道</p>
                </div>
                <div class="col-lg-4">
                    日历
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6">
                    <div class="row">
                        <div class="col-lg-12" style="position: relative">
                            <img src="/static/img/map/gumei_9.jpg" style="width:100%;">
                            <span style="position: absolute;top:740px;left: 60px;color: white;text-align: center">平阳五村<br>532人</span>
                            <span style="position: absolute;top:660px;left: 175px;color: white;text-align: center">平阳四村<br>532人</span>
                            <span style="position: absolute;top:650px;left: 60px;color: white;text-align: center">平阳三村<br>532人</span>
                            <span style="position: absolute;top:575px;left: 190px;color: white;text-align: center">平阳二村<br>532人</span>
                            <span style="position: absolute;top:570px;left: 70px;color: white;text-align: center">平阳一村<br>532人</span>
                            <span style="position: absolute;top:750px;left: 160px;color: white;text-align: center">平阳六村<br>532人</span>
                        </div>
                    </div>
                   <div class="row">
                       <div class="col-lg-12">
                           <div style="margin: 50px">
                               <button style="background-color: #d39693;width: 30px;height: 20px;border: none;border-radius: 5px"></button><span style="position: relative;top: -3px;left:10px;color: white">平阳</span>
                           </div>
                       </div>
                   </div>
                </div>
                <div class="col-lg-6">
                    <div class="row  chart_left">
                        <div class="col-lg-6">
                            <div id="gumeiPie" class="tu_right"></div>
                        </div>
                        <div class="col-lg-6">
                            <div id="hujiPie" class="tu_right"></div>
                        </div>
                    </div>
                    <div class="row  chart_left">
                        <div class="col-md-6">
                            <div id="pqBar" class="tu_right"></div>
                        </div>
                        <div class="col-md-6">
                            <div id="jwBar" class="tu_right"></div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="wrapper wrapper-content animated fadeInRight">
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
                                                    <th>住址</th>
                                                    <th>所属居委会</th>
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
            </div>
        </div>

    </div>
    <script type="text/javascript">
        $(".tu").css('width',winWidth/(6.5));
        $(".tu").css( 'height', winHeight/7);
        $(".tu_right").css('width',winWidth/6);
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
        var pqBar= echarts.init(document.getElementById('pqBar'));
        var jwBar= echarts.init(document.getElementById('jwBar'));

        var gumeiPie=echarts.init(document.getElementById('gumeiPie'));
        var hujiPie=echarts.init(document.getElementById('hujiPie'));

    </script>
</div>

<#include "set.ftl" />
</body>
<#--<script src="/js/content.min.js?v=1.0.0"></script>-->
<#--<script src="/static/js/visual/oldman.js" ></script>-->
<#--<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>-->
<script type="text/javascript">
//    年龄分布柱状图
//    title_text='年龄分布柱状';
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
//    title_text='年龄增长趋势图';
    legend_data=[{name:'60-70',textStyle:{color:legend_color}},{name:'70-80',textStyle:{color:legend_color}},
        {name:'80-90',textStyle:{color:legend_color}},{name:'90-',textStyle:{color:legend_color}}];
    xAxis_data=['11月','12月','1月','2月','3月','4月'];
    series=[
        {
            name: '60-70',
            type: 'line',
            stack: '总量',
            itemStyle:{
                normal: {
                    color:series_color_1
                }
            },
            markLine:{
                lineStyle: {
                    width: 3 //default value:2
                }
            },
            data: [200,205,210,210,215,220]
        },
        {
            name: '70-80',
            type: 'line',
            stack: '总量',
            itemStyle:{
                normal: {
                    color:series_color_2
                }
            },
            markLine:{
                lineStyle: {
                    width: 3 //default value:2
                }
            },
            data: [100,105,110,110,115,120]
        },
        {
            name: '80-90',
            type: 'line',
            stack: '总量',
            itemStyle:{
                normal: {
                    color:series_color_3
                }
            },
            data: [60,65,70,80,85,90]
        },
        {
            name: '90-',
            type: 'line',
            stack: '总量',
            itemStyle:{
                normal: {
                    color:series_color_4
                }
            },
            data: [50,55,60,70,75,80]
        }
    ];
    var option_age_line = chartLine(title_text,legend_data,xAxis_data,series);
    //性别饼图
//    title_text="性别分布饼图";
    legend_data=[{name:'男',textStyle:{color:legend_color}},{name:'女',textStyle:{color:legend_color}}];
    series=[{
        name: '老人性别',
        type: 'pie',
        radius : '55%',
        label : {
            normal : {
                formatter: '{b}:{c}\n{d}%',
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
    var option_sex_pie = chartPie(title_text,[],series);
    //性别增长趋势图
//    title_text='性别增长趋势图';
    xAxis_data=['11月','12月','1月','2月','3月','4月'];
    series=[
        {
            name: '男',
            type: 'line',
            stack: '总量',
            itemStyle:{
                normal: {
                    color:series_color_1
                }
            },
            data: [200,205,210,210,215,220]
        },
        {
            name: '女',
            type: 'line',
            stack: '总量',
            itemStyle:{
                normal: {
                    color:series_color_2
                }
            },
            data: [100,105,110,110,115,120]
        }
    ];
    var option_sex_line = chartLine(title_text,legend_data,xAxis_data,series);
    //户籍
//    title_text="户籍分布饼图";
    legend_data=[{name:'本地',textStyle:{color:legend_color}},{name:'外地',textStyle:{color:legend_color}}];
    series=[{
        name: '老人户籍',
        type: 'pie',
        radius : '55%',
        center: ['48%', '60%'],
        label : {
            normal : {
                formatter: '{b}:{c}\n{d}%',
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
    var option_area_pie = chartPie(title_text,[],series);
    //户籍增长趋势图
//    title_text='户籍增长趋势图';
    xAxis_data=['11月','12月','1月','2月','3月','4月'];
    series=[
        {
            name: '男',
            type: 'line',
            stack: '总量',
            itemStyle:{
                normal: {
                    color:series_color_1
                }
            },
            data: [200,205,210,210,215,220]
        },
        {
            name: '女',
            type: 'line',
            stack: '总量',
            itemStyle:{
                normal: {
                    color:series_color_2
                }
            },
            data: [100,105,110,110,115,120]
        }
    ];
    var option_area_line = chartLine(title_text,legend_data,xAxis_data,series);
    //家庭结构
//    title_text="家庭结构分布饼图";
    legend_data=[{name:'纯老',textStyle:{color:legend_color}},{name:'独居',textStyle:{color:legend_color}}
        ,{name:'失独',textStyle:{color:legend_color}},{name:'一老养一老',textStyle:{color:legend_color}},
        {name:'孤老',textStyle:{color:legend_color}}];
    series=[{
        name: '老人家庭结构',
        type: 'pie',
        radius : '55%',
        label : {
            normal : {
                formatter: '{b}:{c}\n{d}%',
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
    var option_family_pie = chartPie(title_text,[],series);
    //家庭结构增长趋势图
//    title_text='家庭结构增长趋势图';
    xAxis_data=['11月','12月','1月','2月','3月','4月'];
    series=[
        {
            name: '纯老',
            type: 'line',
            stack: '总量',
            itemStyle:{
                normal: {
                    color:series_color_1
                }
            },
            data: [200,205,210,210,215,220]
        },
        {
            name: '独居',
            type: 'line',
            stack: '总量',
            itemStyle:{
                normal: {
                    color:series_color_2
                }
            },
            data: [100,105,110,110,115,120]
        }
        ,
        {
            name: '失独',
            type: 'line',
            stack: '总量',
            itemStyle:{
                normal: {
                    color:series_color_3
                }
            },
            data: [100,105,110,110,115,120]
        }
        ,
        {
            name: '一老养一老',
            type: 'line',
            stack: '总量',
            itemStyle:{
                normal: {
                    color:series_color_4
                }
            },
            data: [100,105,110,110,115,120]
        }
        ,
        {
            name: '孤老',
            type: 'line',
            stack: '总量',
            itemStyle:{
                normal: {
                    color:series_color_1
                }
            },
            data: [100,105,110,110,115,120]
        }
    ];
    var option_family_line = chartLine(title_text,legend_data,xAxis_data,series);
    //经济条件
//    title_text="经济条件分布饼图";
    legend_data=[{name:'帮困人员',textStyle:{color:legend_color}},{name:'低保',textStyle:{color:legend_color}}
        ,{name:'城乡居民养老保险',textStyle:{color:legend_color}},{name:'医疗救助金',textStyle:{color:legend_color}},
        {name:'城镇居民基本医疗保险',textStyle:{color:legend_color}}];
    series=[{
        name: '老人经济条件',
        type: 'pie',
        radius : '55%',
        label : {
            normal : {
                formatter: '{b}:{c}\n{d}%',
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
            {value:376, name:'城乡居民养老保险'},
            {value:376, name:'医疗救助金'},
            {value:376, name:'城镇居民基本医疗保险'}
        ],
        itemStyle: {
            emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
        }
    }];
    var option_econmic_pie = chartPie(title_text,[],series);
    //经济条件增长趋势图
//    title_text='经济条件增长趋势图';
    xAxis_data=['11月','12月','1月','2月','3月','4月'];
    series=[
        {
            name: '帮困人员',
            type: 'line',
            stack: '总量',
            itemStyle:{
                normal: {
                    color:series_color_1
                }
            },
            data: [200,205,210,210,215,220]
        },
        {
            name: '低保',
            type: 'line',
            stack: '总量',
            itemStyle:{
                normal: {
                    color:series_color_2
                }
            },
            data: [100,105,110,110,115,120]
        }
        ,
        {
            name: '城乡居民养老保险',
            type: 'line',
            stack: '总量',
            itemStyle:{
                normal: {
                    color:series_color_3
                }
            },
            data: [100,105,110,110,115,120]
        }
        ,
        {
            name: '医疗救助金',
            type: 'line',
            stack: '总量',
            itemStyle:{
                normal: {
                    color:series_color_4
                }
            },
            data: [100,105,110,110,115,120]
        }
        ,
        {
            name: '城镇居民基本医疗保险',
            type: 'line',
            stack: '总量',
            itemStyle:{
                normal: {
                    color:series_color_5
                }
            },
            data: [100,105,110,110,115,120]
        }
    ];
    var option_econmic_line = chartLine(title_text,legend_data,xAxis_data,series);
    //健康状态
//    title_text="健康状态分布饼图";
    legend_data=[{name:'良',textStyle:{color:legend_color}},{name:'亚健康',textStyle:{color:legend_color}}
        ,{name:'严重',textStyle:{color:legend_color}}];
    series=[{
        name: '老人健康状态',
        type: 'pie',
        radius : '55%',
        center: ['48%', '60%'],
        label : {
            normal : {
                formatter: '{b}:{c}\n{d}%',
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
    var option_health_pie = chartPie(title_text,[],series);
    //健康状态增长趋势图
//    title_text='健康状态增长趋势图';
    xAxis_data=['11月','12月','1月','2月','3月','4月'];
    series=[
        {
            name: '良',
            type: 'line',
            stack: '总量',
            itemStyle:{
                normal: {
                    color:series_color_1
                }
            },
            data: [200,205,210,210,215,220]
        },
        {
            name: '亚健康',
            type: 'line',
            stack: '总量',
            itemStyle:{
                normal: {
                    color:series_color_2
                }
            },
            data: [100,105,110,110,115,120]
        }
        ,
        {
            name: '严重',
            type: 'line',
            stack: '总量',
            itemStyle:{
                normal: {
                    color:series_color_3
                }
            },
            data: [100,105,110,110,115,120]
        }
    ];
    var option_health_line = chartLine(title_text,legend_data,xAxis_data,series);
    //养老状态
//    title_text="养老状态分布饼图";
    legend_data=[{name:'机构养老',textStyle:{color:legend_color}},{name:'社区居家养老',textStyle:{color:legend_color}}];
    series=[{
        name: '老养老状态',
        type: 'pie',
        radius : '55%',
        label : {
            normal : {
                formatter: '{b}:{c}\n{d}%',
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
    var option_status_pie = chartPie(title_text,[],series);
    //养老状态增长趋势图
//    title_text='养老状态增长趋势图';
    xAxis_data=['11月','12月','1月','2月','3月','4月'];
    series=[
        {
            name: '机构养老',
            type: 'line',
            stack: '总量',
            itemStyle:{
                normal: {
                    color:series_color_1
                }
            },
            data: [200,205,210,210,215,220]
        },
        {
            name: '社区居家养老',
            type: 'line',
            stack: '总量',
            itemStyle:{
                normal: {
                    color:series_color_2
                }
            },
            data: [100,105,110,110,115,120]
        }
    ];
    var option_status_line = chartLine(title_text,legend_data,xAxis_data,series);
    //片区人数分布
    legend_data="";
    title_text='片区人口分布柱状';
    yAxis_data=['东兰','古龙','平南','平阳','平吉','古美'];
    series=[
        {
            name: '',
            type: 'bar',
            stack: '总量',
            label: {
                normal: {
                    show: true,
                    position: 'insideLeft'
                }
            },
            itemStyle:{
                normal: {
                    color:series_color_1
                }
            },
            data: [67,134,234,534,263,231]
        }
    ];
    var option_pq_bar=chartBar(title_text,legend_data,yAxis_data,series);
    //居委人数分布
    legend_data="";
    title_text='居委人口分布柱状';
    yAxis_data=['东兰一村','东兰二村','东兰三村','东兰四村'];
    series=[
        {
            name: '',
            type: 'bar',
            stack: '总量',
            label: {
                normal: {
                    show: true,
                    position: 'insideLeft'
                }
            },
            itemStyle:{
                normal: {
                    color:series_color_1
                }
            },
            data: [67,134,234,534]
        }
    ];
    var option_jw_bar=chartBar(title_text,legend_data,yAxis_data,series);

    //古美老人分布
    title_text="老人所占比例";
//    legend_data=[{name:'非老人',textStyle:{color:legend_color}},{name:'老人',textStyle:{color:legend_color}},{name:'重点老人',textStyle:{color:legend_color}}];
    legend_data=[];
    series=[
        {
            name:'访问来源',
            type:'pie',
            radius: ['50%', '70%'],
            avoidLabelOverlap: false,
            label: {
                normal : {
                    formatter: '{b}:{c}\n{d}%',
                    textStyle : {
                        fontWeight : 'normal',
                        fontSize : 10
                    }
                }
            },
            data:[
                {value:15360, name:'非老人'},
                {value:4310, name:'老人'},
                {value:234, name:'重点老人'}
            ]
        }
    ];
    var option_gumei_pie = chartPie(title_text,legend_data,series);

    //古美老人户籍分布
    title_text="户籍所占比例";
//    legend_data=[{name:'户籍',textStyle:{color:legend_color}},{name:'非户籍',textStyle:{color:legend_color}}];
    legend_data=[];
    series=[
        {
            name:'访问来源',
            type:'pie',
            radius: ['50%', '70%'],
            avoidLabelOverlap: false,
            label: {
                normal : {
                    formatter: '{b}:{c}\n{d}%',
                    textStyle : {
                        fontWeight : 'normal',
                        fontSize : 10
                    }
                }
            },
            data:[
                {value:5360, name:'户籍'},
                {value:4310, name:'非户籍'}
            ]
        }
    ];
    var option_huji_pie = chartPie(title_text,legend_data,series);


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
        pqBar.setOption(option_pq_bar);
        jwBar.setOption(option_jw_bar);
        gumeiPie.setOption(option_gumei_pie);
        hujiPie.setOption(option_huji_pie);
</script>
</html>