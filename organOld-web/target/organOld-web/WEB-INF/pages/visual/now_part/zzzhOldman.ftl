<!DOCTYPE html>
<html>

<head>
<#include "../head.ftl" />
    <style>
        @media only screen and (min-width: 1700px){
            .title{
                text-align: center;
                font-size: 28px;
                font-weight: bold;
                margin-top: 10px;
            }
        }

        @media only screen and (min-width: 1300px) and ( max-width: 1400px){
            .title{
                text-align: center;
                font-size: 15px;
                font-weight: bold;
                margin-top: 5px;
            }

        }
    </style>
</head>

<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-6">
            <div class="row" align="center">
                <div class="col-lg-12">
                    <div class="row">
                        <div class="col-lg-12">
                            <p class="map_title" onclick="location.href='/visual/now/part/organ'" style="cursor: pointer">长者照护</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12">
                        <#include "map.ftl"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row" style="position: relative;right: 10px">
                <#include "table.ftl"/>
            </div>
        </div>
        <div class="col-lg-6">
            <div class="row box a">
                <div class="zz"></div>
                <p class="title">养老院床位数总和</p>
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
                <p class="title">古美养老院</p>
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
                <p class="title">东兰养老院</p>
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
                <p class="title">平阳养老院</p>
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
        var tu_big_w,tu_big_h;
        if(winWidth>=1700){
            //家里电脑的分辨率
            tu_big_w=winWidth/8.8;
            tu_big_h=winHeight/5.5;
        }else if(winWidth<=1400 && winWidth>=1300){
            tu_big_w=winWidth/8.8;
            tu_big_h=winHeight/5.5;
        }
        $(".tu_big").css('width',tu_big_w);
        $(".tu_big").css( 'height', tu_big_h);


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
                    fontSize : 20
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
                    fontSize : 20
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
                    fontSize : 20
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
                    fontSize : 20
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