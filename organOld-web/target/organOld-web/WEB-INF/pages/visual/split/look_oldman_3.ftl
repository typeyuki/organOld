<!DOCTYPE html>
<html>

<head>
<#include "head.ftl" />
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
        .tu_small,.tu_big{
            padding-top: 5%;
            padding-bottom: 2%;
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
                    <p class="map_title">未安排重点老人关注热力图</p>
                    <img src="/static/img/map/gumei_9.jpg" style="width:75%;">
                </div>
            </div>
        </div>
        <div class="col-lg-6">
            <div class="row">
                <div class="col-lg-12 box">
                    <div class="zz"></div>
                    <div id="gz_sub_pie" class="tu_big"></div>
                </div>
            </div>
            <div class="row" style="margin-top: 10px">
                <div class="row">
                    <div class="col-lg-4 box" style="position: relative;right: 10px;margin-bottom: 5px">
                        <div class="zz"></div>
                        <div id="gz_py_pie" class="tu_small"></div>
                    </div>
                    <div class="col-lg-4 box" style="position: relative;right: 5px">
                        <div class="zz"></div>
                        <div id="gz_dl_pie" class="tu_small"></div>
                    </div>
                    <div class="col-lg-4 box">
                        <div class="zz"></div>
                        <div id="gz_gl_pie" class="tu_small"></div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-4 box" style="position: relative;right: 10px">
                        <div class="zz"></div>
                        <div id="gz_pj_pie" class="tu_small"></div>
                    </div>
                    <div class="col-lg-4 box" style="position: relative;right: 5px">
                        <div class="zz"></div>
                        <div id="gz_pn_pie" class="tu_small"></div>
                    </div>
                    <div class="col-lg-4 box">
                        <div class="zz"></div>
                        <div id="gz_gm_pie" class="tu_small"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript">
        $(".tu_small").css('width',winWidth/6.8);
        $(".tu_small").css( 'height', winHeight*0.28);
        $(".tu_big").css('width',winWidth/2.5);
        $(".tu_big").css( 'height', winHeight*0.38);


        var gz_sub_pie= echarts.init(document.getElementById('gz_sub_pie'));
        var gz_py_pie= echarts.init(document.getElementById('gz_py_pie'));
        var gz_dl_pie= echarts.init(document.getElementById('gz_dl_pie'));
        var gz_gl_pie= echarts.init(document.getElementById('gz_gl_pie'));
        var gz_pj_pie= echarts.init(document.getElementById('gz_pj_pie'));
        var gz_pn_pie= echarts.init(document.getElementById('gz_pn_pie'));
        var gz_gm_pie= echarts.init(document.getElementById('gz_gm_pie'));


    </script>
</div>
<#include "set.ftl" />

</body>
<script type="text/javascript">
    title_text="古美街道暂未安排重点老人关注程度";
    legend_data=[{name:'已关注',textStyle:{color:legend_color}},{name:'未关注',textStyle:{color:legend_color}}];
    series=[{
        name: '关注度',
        type: 'pie',
        radius : '55%',
        center: ['50%', '60%'],
        label: {
            normal : {
                formatter: '{d}%\n({c})',
                textStyle : {
                    fontWeight : 'normal'
                }
            }
        },
        data:[
            {value:476, name:'已关注'},
            {value:376, name:'未关注'}
        ],
        itemStyle: {
            emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
        }
    }];
    var option_gz_sub_pie = chartPie(title_text,legend_data,series);
    title_text="平阳";
    legend_data=[{name:'已关注',textStyle:{color:legend_color}},{name:'未关注',textStyle:{color:legend_color}}];
    series=[{
        name: '关注度',
        type: 'pie',
        radius : '45%',
        center: ['50%', '60%'],
        label: {
            normal : {
                formatter: '{d}%\n({c})',
                textStyle : {
                    fontWeight : 'normal'
                }
            }
        },
        data:[
            {value:476, name:'已关注'},
            {value:376, name:'未关注'}
        ],
        itemStyle: {
            emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
        }
    }];
    var option_gz_py_pie = chartPie(title_text,legend_data,series);
    title_text="东兰";
    legend_data=[{name:'已关注',textStyle:{color:legend_color}},{name:'未关注',textStyle:{color:legend_color}}];
    series=[{
        name: '关注度',
        type: 'pie',
        radius : '45%',
        center: ['50%', '60%'],
        label: {
            normal : {
                formatter: '{d}%\n({c})',
                textStyle : {
                    fontWeight : 'normal'
                }
            }
        },
        data:[
            {value:476, name:'已关注'},
            {value:376, name:'未关注'}
        ],
        itemStyle: {
            emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
        }
    }];
    var option_gz_dl_pie = chartPie(title_text,legend_data,series);
    title_text="古龙";
    legend_data=[{name:'已关注',textStyle:{color:legend_color}},{name:'未关注',textStyle:{color:legend_color}}];
    series=[{
        name: '关注度',
        type: 'pie',
        radius : '45%',
        center: ['50%', '60%'],
        label: {
            normal : {
                formatter: '{d}%\n({c})',
                textStyle : {
                    fontWeight : 'normal'
                }
            }
        },
        data:[
            {value:476, name:'已关注'},
            {value:376, name:'未关注'}
        ],
        itemStyle: {
            emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
        }
    }];
    var option_gz_gl_pie = chartPie(title_text,legend_data,series);
    title_text="平吉";
    legend_data=[{name:'已关注',textStyle:{color:legend_color}},{name:'未关注',textStyle:{color:legend_color}}];
    series=[{
        name: '关注度',
        type: 'pie',
        radius : '45%',
        center: ['50%', '60%'],
        label: {
            normal : {
                formatter: '{d}%\n({c})',
                textStyle : {
                    fontWeight : 'normal'
                }
            }
        },
        data:[
            {value:476, name:'已关注'},
            {value:376, name:'未关注'}
        ],
        itemStyle: {
            emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
        }
    }];
    var option_gz_pj_pie = chartPie(title_text,legend_data,series);
    title_text="平南";
    legend_data=[{name:'已关注',textStyle:{color:legend_color}},{name:'未关注',textStyle:{color:legend_color}}];
    series=[{
        name: '关注度',
        type: 'pie',
        radius : '45%',
        center: ['50%', '60%'],
        label: {
            normal : {
                formatter: '{d}%\n({c})',
                textStyle : {
                    fontWeight : 'normal'
                }
            }
        },
        data:[
            {value:476, name:'已关注'},
            {value:376, name:'未关注'}
        ],
        itemStyle: {
            emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
        }
    }];
    var option_gz_pn_pie = chartPie(title_text,legend_data,series);
    title_text="古美";
    legend_data=[{name:'已关注',textStyle:{color:legend_color}},{name:'未关注',textStyle:{color:legend_color}}];
    series=[{
        name: '关注度',
        type: 'pie',
        radius : '45%',
        center: ['50%', '60%'],
        label: {
            normal : {
                formatter: '{d}%\n({c})',
                textStyle : {
                    fontWeight : 'normal'
                }
            }
        },
        data:[
            {value:476, name:'已关注'},
            {value:376, name:'未关注'}
        ],
        itemStyle: {
            emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
        }
    }];
    var option_gz_gm_pie = chartPie(title_text,legend_data,series);

    gz_sub_pie.setOption(option_gz_sub_pie);
    gz_py_pie.setOption(option_gz_py_pie);
    gz_dl_pie.setOption(option_gz_dl_pie);
    gz_gl_pie.setOption(option_gz_gl_pie);
    gz_pj_pie.setOption(option_gz_pj_pie);
    gz_pn_pie.setOption(option_gz_pn_pie);
    gz_gm_pie.setOption(option_gz_gm_pie);

</script>
</html>