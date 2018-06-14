<!DOCTYPE html>
<html>

<head>
    <#include "head.ftl" />
    <style>
        .chart_left{
            margin-bottom: 1;
            /*background-color: rgb(16, 58, 68);*/
        }
        h2,p,td,h3,h1{
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
        .tu{
            padding-top: 5%;
            padding-bottom: 2%;
        }
        .texttile{
            font-size: 18px;
            font-weight: bold;
            margin-top: 4%;
            margin-left: 5%;
        }
        /*.text{*/
            /*text-align: center;*/

        /*}*/
        .number{
            color: rgb(230, 155, 58);
            font-size: 38px;
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
                    <p class="map_title">古美街道养老机构</p>
                    <img src="/static/img/map/gumei_9.jpg" style="width:75%;">
                </div>
            </div>
        </div>
        <div class="col-lg-6">
                    <div class="row  chart_left">
                        <div class="col-lg-6 box text"  style="margin-bottom: 5px">
                            <div class="zz"></div>
                            <div>
                                <p class="texttile">养老服务机构数</p>
                                <p class="text" style="text-align: center;margin-top: 8%"><span class="number">3</span>&nbsp;&nbsp;家</p>
                            </div>
                        </div>
                        <div class="col-lg-6 box text"  style="position: relative;left: 5px;margin-bottom: 5px">
                            <div class="zz"></div>
                            <div>
                                <p class="texttile">服务老人总数</p>
                                <p class="text" style="text-align: center;margin-top: 8%"><span class="number">842</span>&nbsp;&nbsp;人</p>
                            </div>
                        </div>
                    </div>
                    <div class="row chart_left">
                        <div class="col-md-6 box" align="center" style="margin-bottom: 5px">
                            <div class="zz"></div>
                            <div id="pie" class="tu"></div>
                        </div>
                        <div class="col-md-6 box" align="center" style="position: relative;left: 5px">
                            <div class="zz"></div>
                            <div id="bar" class="tu"></div>
                        </div>
                    </div>
                    <div class="row" >
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
    <script type="text/javascript">
        $(".tu").css('width',winWidth/5);
        $(".tu").css( 'height', winHeight/(3));
        $(".text").css( 'height', winHeight/(4.5));
        var pie= echarts.init(document.getElementById('pie'));
        var bar= echarts.init(document.getElementById('bar'));

    </script>
</div>

<#include "set.ftl" />
</body>
<#--<script src="/js/content.min.js?v=1.0.0"></script>-->
<#--<script src="/static/js/visual/oldman.js" ></script>-->
<#--<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>-->
<script type="text/javascript">
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
    var option_pie = chartPie(title_text,legend_data,series);

    //
    title_text='各养老院床位供需图';
    legend_data=[
        {
            name:'已入驻',
            textStyle:{
                color:'#fff'
            }
        },
        {
            name:'剩余床位',
            textStyle:{
                color:'#fff'
            }}
    ];
    xAxis_data=['养老院1','养老院2','养老院3'];
    series=[
        {
            name: '已入驻',
            type: 'bar',
            itemStyle:{
                normal: {
                    color:series_color_1
                }
            },
            data: [167,134,234]
        },
        {
            name: '剩余床位',
            type: 'bar',
            itemStyle:{
                normal: {
                    color:series_color_2
                }
            },
            data: [45,45,121]
        }
    ];
    var option_bar=chartBarHei(title_text,legend_data,xAxis_data,series);

        pie.setOption(option_pie);
        bar.setOption(option_bar);
</script>
</html>