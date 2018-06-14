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
        .a{
            margin-bottom: 5px;
            position: relative;
            right: 5px;
        }
        .title{
            text-align: center;
            font-size: 28px;
            font-weight: bold;
            margin-top: 10px;
        }
        .tu_big{
            position: relative;
            right: 5px;
        }
    </style>
</head>

<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-6">
            <div class="row" align="center">
                <div class="col-lg-12">
                    <p class="map_title">长者照护之家</p>
                    <img src="/static/img/map/gumei_9.jpg" style="width:60%;">
                </div>
            </div>
            <div class="row" style="position: relative;right: 10px">
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
            <div class="row box a">
                <div class="zz"></div>
                <p class="title">长者照护之家床位数总和</p>
                <div class="col-lg-3">
                    <div id="jg_sub_pie" class="tu_big"></div>
                </div>
                <div class="col-lg-3">
                    <div id="jg_sub_wl" class="tu_big"></div>
                </div>
                <div class="col-lg-3">
                    <div id="jg_sex_pie" class="tu_big"></div>
                </div>
                <div class="col-lg-3">
                    <div id="jg_age_bar" class="tu_big"></div>
                </div>
            </div>
            <div class="row box a">
                <div class="zz"></div>
                <p class="title">古美长者照护之家</p>
                <div class="col-lg-3">
                    <div id="jg_1_pie" class="tu_big"></div>
                </div>
                <div class="col-lg-3">
                    <div id="jg_1_wl" class="tu_big"></div>
                </div>
                <div class="col-lg-3">
                    <div id="jg_1_sex" class="tu_big"></div>
                </div>
                <div class="col-lg-3">
                    <div id="jg_1_age" class="tu_big"></div>
                </div>
            </div>
            <div class="row box a">
                <div class="zz"></div>
                <p class="title">东兰长者照护之家</p>
                <div class="col-lg-3">
                    <div id="jg_2_pie" class="tu_big"></div>
                </div>
                <div class="col-lg-3">
                    <div id="jg_2_wl" class="tu_big"></div>
                </div>
                <div class="col-lg-3">
                    <div id="jg_2_sex" class="tu_big"></div>
                </div>
                <div class="col-lg-3">
                    <div id="jg_2_age" class="tu_big"></div>
                </div>
            </div>
            <div class="row box a">
                <div class="zz"></div>
                <p class="title">平阳长者照护之家</p>
                <div class="col-lg-3">
                    <div id="jg_3_pie" class="tu_big"></div>
                </div>
                <div class="col-lg-3">
                    <div id="jg_3_wl" class="tu_big"></div>
                </div>
                <div class="col-lg-3">
                    <div id="jg_3_sex" class="tu_big"></div>
                </div>
                <div class="col-lg-3">
                    <div id="jg_3_age" class="tu_big"></div>
                </div>
            </div>
        </div>

    </div>
    <script type="text/javascript">
        $(".tu_big").css('width',winWidth/8.5);
        $(".tu_big").css( 'height', winHeight/5.35);
        $(".tu").css('width',winWidth/4.5);
        $(".tu").css( 'height', winHeight/3.6);
        $(".tu_jj").css('width',winWidth/3);
        $(".tu_jj").css( 'height', winHeight/2.8);
        var jg_sub_pie = echarts.init(document.getElementById('jg_sub_pie'));
        var jg_sub_wl= echarts.init(document.getElementById('jg_sub_wl'));
        var jg_1_pie= echarts.init(document.getElementById('jg_1_pie'));
        var jg_1_wl = echarts.init(document.getElementById('jg_1_wl'));
        var jg_2_pie= echarts.init(document.getElementById('jg_2_pie'));
        var jg_2_wl = echarts.init(document.getElementById('jg_2_wl'));
        var jg_3_pie= echarts.init(document.getElementById('jg_3_pie'));
        var jg_3_wl = echarts.init(document.getElementById('jg_3_wl'));

        var jg_sex_pie = echarts.init(document.getElementById('jg_sex_pie'));
        var jg_age_bar = echarts.init(document.getElementById('jg_age_bar'));
        var jg_1_age = echarts.init(document.getElementById('jg_1_age'));
        var jg_1_sex = echarts.init(document.getElementById('jg_1_sex'));
        var jg_2_age = echarts.init(document.getElementById('jg_2_age'));
        var jg_2_sex = echarts.init(document.getElementById('jg_2_sex'));
        var jg_3_age = echarts.init(document.getElementById('jg_3_age'));
        var jg_3_sex = echarts.init(document.getElementById('jg_3_sex'));
    </script>
</div>


</body>
<script>

    title_text="";
    legend_data=[{name:'已入住',textStyle:{color:legend_color,fontSize:18}},{name:'剩余',textStyle:{color:legend_color,fontSize:18}}];
    series=[{
        name: '老人户籍',
        type: 'pie',
        radius : '55%',
        center: ['48%', '50%'],
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
            {value:476, name:'已入住'},
            {value:376, name:'剩余'}
        ],
        itemStyle: {
            emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
        }
    }];
    var option_sub_pie = chartPie(title_text,legend_data,series);

        title_text="";
        legend_data=[];
        series=[
            {
                name:'未来空余',
                type:'pie',
                radius: ['50%', '65%'],
                avoidLabelOverlap: false,
                label: {
                    normal : {
                        position:"center",
                        formatter: '{a}\n{c}',
                        textStyle : {
                            fontWeight : 'normal',
                            fontSize : 18,
                            color:"#f2f989"
                        }
                    }
                },
                data:[
                    {value:40, name:'未来空余'}
                ]
            }
        ];
        var option_sub_wl = chartPie(title_text,legend_data,series);
    title_text="";
    legend_data=[{name:'已入住',textStyle:{color:legend_color,fontSize:18}},{name:'剩余',textStyle:{color:legend_color,fontSize:18}}];
    series=[{
        name: '老人户籍',
        type: 'pie',
        radius : '55%',
        center: ['48%', '50%'],
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
            {value:476, name:'已入住'},
            {value:376, name:'剩余'}
        ],
        itemStyle: {
            emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
        }
    }];
    var option_1_pie = chartPie(title_text,legend_data,series);

    title_text="";
    legend_data=[];
    series=[
        {
            name:'未来空余',
            type:'pie',
            radius: ['50%', '65%'],
            avoidLabelOverlap: false,
            label: {
                normal : {
                    position:"center",
                    formatter: '{a}\n{c}',
                    textStyle : {
                        fontWeight : 'normal',
                        fontSize : 18,
                        color:"#f2f989"
                    }
                }
            },
            data:[
                {value:40, name:'未来空余'}
            ]
        }
    ];
    var option_1_wl = chartPie(title_text,legend_data,series);
    title_text="";
    legend_data=[{name:'已入住',textStyle:{color:legend_color,fontSize:18}},{name:'剩余',textStyle:{color:legend_color,fontSize:18}}];
    series=[{
        name: '老人户籍',
        type: 'pie',
        radius : '55%',
        center: ['48%', '50%'],
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
            {value:476, name:'已入住'},
            {value:376, name:'剩余'}
        ],
        itemStyle: {
            emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
        }
    }];
    var option_2_pie = chartPie(title_text,legend_data,series);

    title_text="";
    legend_data=[];
    series=[
        {
            name:'未来空余',
            type:'pie',
            radius: ['50%', '65%'],
            avoidLabelOverlap: false,
            label: {
                normal : {
                    position:"center",
                    formatter: '{a}\n{c}',
                    textStyle : {
                        fontWeight : 'normal',
                        fontSize : 18,
                        color:"#f2f989"
                    }
                }
            },
            data:[
                {value:40, name:'未来空余'}
            ]
        }
    ];
    var option_2_wl = chartPie(title_text,legend_data,series);
    title_text="";
    legend_data=[{name:'已入住',textStyle:{color:legend_color,fontSize:18}},{name:'剩余',textStyle:{color:legend_color,fontSize:18}}];
    series=[{
        name: '老人户籍',
        type: 'pie',
        radius : '55%',
        center: ['48%', '50%'],
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
            {value:476, name:'已入住'},
            {value:376, name:'剩余'}
        ],
        itemStyle: {
            emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
        }
    }];
    var option_3_pie = chartPie(title_text,legend_data,series);

    title_text="";
    legend_data=[];
    series=[
        {
            name:'未来空余',
            type:'pie',
            radius: ['50%', '65%'],
            avoidLabelOverlap: false,
            label: {
                normal : {
                    position:"center",
                    formatter: '{a}\n{c}',
                    textStyle : {
                        fontWeight : 'normal',
                        fontSize : 18,
                        color:"#f2f989"
                    }
                }
            },
            data:[
                {value:40, name:'未来空余'}
            ]
        }
    ];
    var option_3_wl = chartPie(title_text,legend_data,series);

    jg_sub_pie.setOption(option_sub_pie);
    jg_sub_wl.setOption(option_sub_wl);
    jg_1_pie.setOption(option_1_pie);
    jg_1_wl.setOption(option_1_wl);
    jg_2_pie.setOption(option_2_pie);
    jg_2_wl.setOption(option_2_wl);
    jg_3_pie.setOption(option_3_pie);
    jg_3_wl.setOption(option_3_wl);

    //性别饼图
    title_text="性别";
    legend_data=[{name:'男',textStyle:{color:legend_color,fontSize:18}},{name:'女',textStyle:{color:legend_color,fontSize:18}}];
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
        center: ['48%', '50%'],
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
    var option_jg_sex_pie = chartPie(title_text,legend_data,series);
    jg_sex_pie.setOption(option_jg_sex_pie);
    //性别饼图
    title_text="性别";
    legend_data=[{name:'男',textStyle:{color:legend_color,fontSize:18}},{name:'女',textStyle:{color:legend_color,fontSize:18}}];
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
        center: ['48%', '50%'],
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
    var option_jg_1_sex = chartPie(title_text,legend_data,series);
    jg_1_sex.setOption(option_jg_1_sex);
    //性别饼图
    title_text="性别";
    legend_data=[{name:'男',textStyle:{color:legend_color,fontSize:18}},{name:'女',textStyle:{color:legend_color,fontSize:18}}];
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
        center: ['48%', '50%'],
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
    var option_jg_2_sex = chartPie(title_text,legend_data,series);
    jg_2_sex.setOption(option_jg_2_sex);
    //性别饼图
    title_text="性别";
    legend_data=[{name:'男',textStyle:{color:legend_color,fontSize:18}},{name:'女',textStyle:{color:legend_color,fontSize:18}}];
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
        center: ['48%', '50%'],
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
    var option_jg_3_sex = chartPie(title_text,legend_data,series);
    jg_3_sex.setOption(option_jg_3_sex);

    title_text='年龄';
    legend_data=[
        {
            name:'男',
            textStyle:{
                color:'#fff',
                fontSize:20
            }
        },
        {
            name:'女',
            textStyle:{
                color:'#fff',
                fontSize:20
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
    var option_jg_age_bar=chartBar(title_text,legend_data,yAxis_data,series);
    jg_age_bar.setOption(option_jg_age_bar);
    title_text='年龄';
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
    var option_jg_1_age=chartBar(title_text,legend_data,yAxis_data,series);
    jg_1_age.setOption(option_jg_1_age);
    title_text='年龄';
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
    var option_jg_2_age=chartBar(title_text,legend_data,yAxis_data,series);
    jg_2_age.setOption(option_jg_2_age);
    title_text='年龄';
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
    var option_jg_3_age=chartBar(title_text,legend_data,yAxis_data,series);
    jg_3_age.setOption(option_jg_3_age);

</script>
</html>