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
                <div class="col-lg-6 box"  align="center">
                    <div class="zz"></div>
                    <div id="zbPie" class="tu_big"></div>
                </div>
                <div class="col-lg-6 box line">
                    <div class="zz"></div>
                    <div id="sum_pie" class="tu_big"></div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-4 box">
                    <div class="zz"></div>
                    <div id="jg_pie" class="tu"></div>
                </div>
                <div class="col-lg-4 box line">
                    <div class="zz"></div>
                    <div id="sq_sub_pie" class="tu"></div>
                </div>
                <div class="col-lg-4 box" style="position: relative;left: 10px">
                    <div class="zz"></div>
                    <div id="jj_pie" class="tu"></div>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript">
        $(".tu_big").css('width',winWidth/4.5);
        $(".tu_big").css( 'height', winHeight/2);
        $(".tu").css('width',winWidth/7);
        $(".tu").css( 'height', winHeight/2.37);
        var sq_sub_pie = echarts.init(document.getElementById('sq_sub_pie'));
        var zbPie= echarts.init(document.getElementById('zbPie'));
        var jg_pie = echarts.init(document.getElementById('jg_pie'));
        var jj_pie = echarts.init(document.getElementById('jj_pie'));
        var sum_pie = echarts.init(document.getElementById('sum_pie'));
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


    title_text="机构养老";
    legend_data=[{name:'古美养老院',textStyle:{color:legend_color,fontSize:18}},{name:'东兰养老院',textStyle:{color:legend_color,fontSize:18}},{name:'平阳养老院',textStyle:{color:legend_color,fontSize:18}}];
    series=[{
        name: '老人户籍',
        type: 'pie',
        radius : '65%',
        center: ['48%', '50%'],
        label : {
            normal : {
                formatter: '{d}%\n({c})',
                textStyle : {
                    fontWeight : 'normal',
                    fontSize : 14
                }
            }
        },
        data:[
            {value:476, name:'古美养老院'},
            {value:376, name:'东兰养老院'},
            {value:376, name:'平阳养老院'}
        ],
        itemStyle: {
            emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
        }
    }];
    var option_jg_pie = chartPie(title_text,legend_data,series);
    jg_pie.setOption(option_jg_pie);


    title_text="社区养老";
    legend_data=[{name:'长者照护之家',textStyle:{color:legend_color,fontSize:18}},{name:'日照中心',textStyle:{color:legend_color,fontSize:18}},{name:'助餐点',textStyle:{color:legend_color,fontSize:18}}];
    series=[{
        name: '老人户籍',
        type: 'pie',
        radius : '65%',
        center: ['48%', '50%'],
        label : {
            normal : {
                formatter: '{d}%\n({c})',
                textStyle : {
                    fontWeight : 'normal',
                    fontSize : 14
                }
            }
        },
        data:[
            {value:476, name:'长者照护之家'},
            {value:376, name:'日照中心'},
            {value:376, name:'助餐点'}
        ],
        itemStyle: {
            emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
        }
    }];
    var option_sq_sub_pie = chartPie(title_text,legend_data,series);
    sq_sub_pie.setOption(option_sq_sub_pie);

    title_text="居家养老";
    legend_data=[{name:'家庭养老',textStyle:{color:legend_color,fontSize:18}},{name:'长护险',textStyle:{color:legend_color,fontSize:18}},{name:'智能化应用',textStyle:{color:legend_color,fontSize:18}}
        ,{name:'家庭医生',textStyle:{color:legend_color,fontSize:18}}
        ,{name:'家庭病床',textStyle:{color:legend_color,fontSize:18}}];
    series=[{
        name: '居家养老',
        type: 'pie',
        radius : '65%',
        center: ['48%', '50%'],
        label : {
            normal : {
                formatter: '{d}%\n({c})',
                textStyle : {
                    fontWeight : 'normal',
                    fontSize : 14
                }
            }
        },
        data:[
            {value:476, name:'家庭养老'},
            {value:376, name:'长护险'},
            {value:376, name:'智能化应用'},
            {value:376, name:'家庭医生'},
            {value:376, name:'家庭病床'}
        ],
        itemStyle: {
            emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
        }
    }];
    var option_jj_pie = chartPie(title_text,legend_data,series);
    jj_pie.setOption(option_jj_pie);


    title_text="养老服务覆盖率";
    legend_data=[{name:'总人数',textStyle:{color:legend_color,fontSize:18}},{name:'机构养老',textStyle:{color:legend_color,fontSize:18}},{name:'社区居家养老',textStyle:{color:legend_color,fontSize:18}}
        ,{name:'社区养老',textStyle:{color:legend_color,fontSize:18}}
        ,{name:'居家养老',textStyle:{color:legend_color,fontSize:18}}];
    series=[
        {
            name:'访问来源',
            type:'pie',
            selectedMode: 'single',
            radius: [0, '30%'],

            label: {
                normal: {
                    formatter: '{d}%\n({c})',
                    position: 'inner',
                    fontSize : 16
                }
            },
            labelLine: {
                normal: {
                    show: false
                }
            },
            data:[
                {value:1548, name:'总人数'},
                {value:679, name:'机构养老'},
                {value:355, name:'社区居家养老', selected:true}
            ]
        },
        {
            name:'访问来源',
            type:'pie',
            radius: ['40%', '55%'],
            label: {
                normal: {
                    fontSize : 20,
                    formatter: '{d}%\n({c})',
                    backgroundColor: '#eee',
                    borderColor: '#aaa',
                    borderWidth: 1,
                    borderRadius: 4,
                    // shadowBlur:3,
                    // shadowOffsetX: 2,
                    // shadowOffsetY: 2,
                    // shadowColor: '#999',
                    // padding: [0, 7],
                    rich: {
                        a: {
                            color: '#999',
                            lineHeight: 22,
                            align: 'center'
                        },
                        // abg: {
                        //     backgroundColor: '#333',
                        //     width: '100%',
                        //     align: 'right',
                        //     height: 22,
                        //     borderRadius: [4, 4, 0, 0]
                        // },
                        hr: {
                            borderColor: '#aaa',
                            width: '100%',
                            borderWidth: 0.5,
                            height: 0
                        },
                        b: {
                            fontSize: 20,
                            lineHeight: 33
                        },
                        per: {
                            color: '#eee',
                            backgroundColor: '#334455',
                            padding: [2, 4],
                            borderRadius: 2
                        }
                    }
                }
            },
            data:[
                {value:110, name:'社区养老'},
                {value:80, name:'居家养老'}
            ]
        }
    ];
    var option_sum_pie = chartPie(title_text,legend_data,series);
    sum_pie.setOption(option_sum_pie);
</script>
</html>