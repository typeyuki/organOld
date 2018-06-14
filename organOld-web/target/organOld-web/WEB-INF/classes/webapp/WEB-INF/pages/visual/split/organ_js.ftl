<!DOCTYPE html>
<html>

<head>
    <#include "head.ftl" />
    <style>
        h2,p,td,h3,h1,span{
            color: white!important;
        }
        .box{
            box-shadow:inset 0px 0px 6px 0px rgba(255, 255, 255, 0.7);
            position: relative;
            border-radius: 5px;

            /*background-color:rgba(255, 255, 255, 0.1) ;*/
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
        .tu,.tu_big,.tu_small{
            padding-top: 5%;
            padding-bottom: 2%;
        }
    </style>
</head>

<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-5">
            <div class="row">
                <div class="col-lg-6 box">
                    <div class="zz"></div>
                    <div id="manPie" class="tu"></div>
                </div>
                <div class="col-lg-6 box" style="position: relative;left: 3px;margin-bottom:3px">
                    <div class="zz"></div>
                    <div id="orgBar" class="tu"></div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12 box" style="position: relative;left: 1.5px;">
                    <div class="zz"></div>
                    <div id="orgLine" class="tu_big"></div>
                </div>
            </div>
        </div>
        <div class="col-lg-7" style="position: relative;left: 6px;">
            <div class="row">
                <div class="col-lg-4 box">
                    <div class="zz"></div>
                    <div id="chxBar" class="tu_small"></div>
                </div>
                <div class="col-lg-4 box" style="position: relative;left: 2px;margin-bottom: 2px">
                    <div class="zz"></div>
                    <div id="zcdBar" class="tu_small"></div>
                </div>
                <div class="col-lg-4 box" style="position: relative;left: 4px;">
                    <div class="zz"></div>
                    <div id="zyzBar" class="tu_small"></div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-4 box">
                    <div class="zz"></div>
                    <div id="znzdBar" class="tu_small"></div>
                </div>
                <div class="col-lg-4 box" style="position: relative;left: 2px;margin-bottom: 2px">
                    <div class="zz"></div>
                    <div id="jtysBar" class="tu_small"></div>
                </div>
                <div class="col-lg-4 box" style="position: relative;left: 4px;">
                    <div class="zz"></div>
                    <div id="jtbcBar" class="tu_small"></div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-4 box">
                    <div class="zz"></div>
                    <div id="cwBar" class="tu_small"></div>
                </div>
                <div class="col-lg-8">
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
    <script type="text/javascript">
        $(".tu").css('width',winWidth/5.5);
        $(".tu").css( 'height', winHeight*0.45);
        $(".tu_big").css('width',winWidth/2.5);
        $(".tu_big").css( 'height', winHeight*0.45);
        $(".tu_small").css('width',winWidth/6);
        $(".tu_small").css( 'height', winHeight*0.3);

        var manPie= echarts.init(document.getElementById('manPie'));
        var orgBar= echarts.init(document.getElementById('orgBar'));
        var orgLine= echarts.init(document.getElementById('orgLine'));

        var chxBar= echarts.init(document.getElementById('chxBar'));
        var zcdBar= echarts.init(document.getElementById('zcdBar'));
        var zyzBar= echarts.init(document.getElementById('zyzBar'));
        var znzdBar= echarts.init(document.getElementById('znzdBar'));
        var jtysBar= echarts.init(document.getElementById('jtysBar'));
        var jtbcBar= echarts.init(document.getElementById('jtbcBar'));
        var cwBar= echarts.init(document.getElementById('cwBar'));

    </script>
</div>

<#include "set.ftl" />
</body>

<script type="text/javascript">
    title_text='各片区服务机构汇总';
    legend_data=[
        {
            name:'长者照护之家',
            textStyle:{
                color:'#fff'
            }
        },
        {
            name:'日照中心',
            textStyle:{
                color:'#fff'
            }},
        {
            name:'助餐点',
            textStyle:{
                color:'#fff'
            }}
    ];
    xAxis_data=['平阳','东兰','古龙','平吉','平南','古美'];
    series=[
        {
            name: '长者照护之家',
            type: 'bar',
            itemStyle:{
                normal: {
                    color:series_color_1
                }
            },
            data: [10,11,12,13,14,15]
        },
        {
            name: '日照中心',
            type: 'bar',
            itemStyle:{
                normal: {
                    color:series_color_2
                }
            },
            data: [7,8,9,10,11,12]
        },
        {
            name: '助餐点',
            type: 'bar',
            itemStyle:{
                normal: {
                    color:series_color_3
                }
            },
            data: [4,5,6,7,8,9]
        }
    ];
    var option_org_bar=chartBarHei(title_text,legend_data,xAxis_data,series);
    //养老院老人身份证分布饼图
    title_text="老人身份证分布饼图";
    legend_data=[{name:'纯老',textStyle:{color:legend_color}},{name:'独居',textStyle:{color:legend_color}}
        ,{name:'失独',textStyle:{color:legend_color}},{name:'一老养一老',textStyle:{color:legend_color}},
        {name:'孤老',textStyle:{color:legend_color}}];
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
                        fontSize : 10
                    }
                }
            },
            data:[
                {value:476, name:'纯老'},
                {value:376, name:'独居'},
                {value:376, name:'失独'},
                {value:376, name:'一老养一老'},
                {value:376, name:'孤老'}
            ]
        }
    ];
    var option_man_pie = chartPie(title_text,legend_data,series);;
    title_text='各片区服务机构数量趋势';
    legend_data=[{name:'平阳',textStyle:{color:legend_color}},{name:'东兰',textStyle:{color:legend_color}},
        {name:'古龙',textStyle:{color:legend_color}},{name:'平吉',textStyle:{color:legend_color}},{name:'平南',textStyle:{color:legend_color}}
        ,{name:'古美',textStyle:{color:legend_color}}];
    xAxis_data=['2013','2014','2015','2016','2017'];
    series=[
        {
            name: '平阳',
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
            data: [200,205,210,210,215]
        },
        {
            name: '东兰',
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
            data: [100,105,110,110,115]
        },
        {
            name: '古龙',
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
            data: [60,65,70,80,85]
        },
        {
            name: '平吉',
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
            data: [50,55,60,70,75]
        },
        {
            name: '平南',
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
            data: [50,55,60,70,75]
        },
        {
            name: '古美',
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
            data: [50,55,60,70,75]
        }
    ];
    var option_org_line = chartLine(title_text,legend_data,xAxis_data,series);


    title_text='各片区长户险对比';
    legend_data=[];
    xAxis_data=['平阳','东兰','古龙','平吉','平南','古美'];
    series=[
        {
            name: '啊啊',
            type: 'bar',
            itemStyle:{
                normal: {
                    color:series_color_1
                }
            },
            data: [10,11,12,13,14,15]
        }
    ];
    var option_chx_bar=chartBarHei(title_text,legend_data,xAxis_data,series);
    title_text='各片区助餐点对比';
//    legend_data=[];
    xAxis_data=['平阳','东兰','古龙','平吉','平南','古美'];
    series=[
        {
            name: '啊啊',
            type: 'bar',
            itemStyle:{
                normal: {
                    color:series_color_1
                }
            },
            data: [10,11,12,13,14,15]
        }
    ];
    var option_zcd_bar=chartBarHei(title_text,legend_data,xAxis_data,series);
    title_text='各片区志愿者对比';
//    legend_data=[];
    xAxis_data=['平阳','东兰','古龙','平吉','平南','古美'];
    series=[
        {
            name: '啊啊',
            type: 'bar',
            itemStyle:{
                normal: {
                    color:series_color_1
                }
            },
            data: [10,11,12,13,14,15]
        }
    ];
    var option_zyz_bar=chartBarHei(title_text,legend_data,xAxis_data,series);
    title_text='各片区智能终端对比';
//    legend_data=[];
    xAxis_data=['平阳','东兰','古龙','平吉','平南','古美'];
    series=[
        {
            name: '啊啊',
            type: 'bar',
            itemStyle:{
                normal: {
                    color:series_color_1
                }
            },
            data: [10,11,12,13,14,15]
        }
    ];
    var option_znzd_bar=chartBarHei(title_text,legend_data,xAxis_data,series);
    title_text='各片区家庭医生对比';
//    legend_data=[];
    xAxis_data=['平阳','东兰','古龙','平吉','平南','古美'];
    series=[
        {
            name: '啊啊',
            type: 'bar',
            itemStyle:{
                normal: {
                    color:series_color_1
                }
            },
            data: [10,11,12,13,14,15]
        }
    ];
    var option_jtys_bar=chartBarHei(title_text,legend_data,xAxis_data,series);
    title_text='各片区家庭病床对比';
//    legend_data=[];
    xAxis_data=['平阳','东兰','古龙','平吉','平南','古美'];
    series=[
        {
            name: '啊啊',
            type: 'bar',
            itemStyle:{
                normal: {
                    color:series_color_1
                }
            },
            data: [10,11,12,13,14,15]
        }
    ];
    var option_jtbc_bar=chartBarHei(title_text,legend_data,xAxis_data,series);
    title_text='各片区床位数对比';
//    legend_data=[];
    xAxis_data=['平阳','东兰','古龙','平吉','平南','古美'];
    series=[
        {
            name: '啊啊',
            type: 'bar',
            itemStyle:{
                normal: {
                    color:series_color_1
                }
            },
            data: [10,11,12,13,14,15]
        }
    ];
    var option_cws_bar=chartBarHei(title_text,legend_data,xAxis_data,series);


        manPie.setOption(option_man_pie);
    orgBar.setOption(option_org_bar);
    orgLine.setOption(option_org_line);

    chxBar.setOption(option_chx_bar);
    cwBar.setOption(option_cws_bar);
    jtbcBar.setOption(option_jtbc_bar);
    jtysBar.setOption(option_jtys_bar);
    zcdBar.setOption(option_zcd_bar);
    znzdBar.setOption(option_znzd_bar);
    zyzBar.setOption(option_zyz_bar);
</script>
</html>