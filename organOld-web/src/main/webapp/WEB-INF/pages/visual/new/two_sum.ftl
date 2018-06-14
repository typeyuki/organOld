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
        .tu,.tu_big{
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
                    <p class="map_title">古美路街道老人分布图</p>
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
                    <div id="familyPie" class="tu"></div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6 box">
                    <div class="zz"></div>
                    <div id="healthPie" class="tu"></div>
                </div>
                <div class="col-lg-6 box line">
                    <div class="zz"></div>
                    <div id="econmicPie" class="tu"></div>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript">
        $(".tu").css('width',winWidth/4.5);
        $(".tu").css( 'height', winHeight/2.17);
        var econmicPie= echarts.init(document.getElementById('econmicPie'));
        var zbPie= echarts.init(document.getElementById('zbPie'));
        var familyPie= echarts.init(document.getElementById('familyPie'));
        var healthPie= echarts.init(document.getElementById('healthPie'));
    </script>
</div>


</body>
<script>
    //家庭结构
    title_text="家庭结构分布饼图";
    legend_data=[{name:'纯老',textStyle:{color:legend_color,fontSize:18}},{name:'独居',textStyle:{color:legend_color,fontSize:18}}
        ,{name:'失独',textStyle:{color:legend_color,fontSize:18}},{name:'一老养一老',textStyle:{color:legend_color,fontSize:18}},
        {name:'孤老',textStyle:{color:legend_color,fontSize:18}},{name:'三支人员',textStyle:{color:legend_color,fontSize:18}},{name:'其他',textStyle:{color:legend_color,fontSize:18}}];
    series=[{
        name: '老人家庭结构',
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
            {value:476, name:'纯老'},
            {value:376, name:'独居'},
            {value:376, name:'失独'},
            {value:376, name:'一老养一老'},
            {value:376, name:'孤老'},
            {value:376, name:'三支人员'},
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
    var option_family_pie = chartPie(title_text,legend_data,series);

    familyPie.setOption(option_family_pie);

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
                        fontWeight : 'normal',
                        fontSize : 20
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

    title_text="健康状态分布饼图";
    legend_data=[{name:'失能',textStyle:{color:legend_color,fontSize:18}},{name:'慢病',textStyle:{color:legend_color,fontSize:18}}
        ,{name:'肿瘤史',textStyle:{color:legend_color,fontSize:18}},{name:'骨折史',textStyle:{color:legend_color,fontSize:18}},
        {name:'失智',textStyle:{color:legend_color,fontSize:18}},{name:'长护险评级',textStyle:{color:legend_color,fontSize:18}},{name:'其他',textStyle:{color:legend_color,fontSize:18}}];
    series=[{
        name: '健康状态',
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
            {value:476, name:'失能'},
            {value:376, name:'慢病'},
            {value:376, name:'肿瘤史'},
            {value:376, name:'骨折史'},
            {value:376, name:'失智'},
            {value:376, name:'长护险评级'},
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
    var option_health_pie = chartPie(title_text,legend_data,series);
    healthPie.setOption(option_health_pie);

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
    var option_econmic_pie = chartPie(title_text,legend_data,series);
    econmicPie.setOption(option_econmic_pie);
</script>
</html>