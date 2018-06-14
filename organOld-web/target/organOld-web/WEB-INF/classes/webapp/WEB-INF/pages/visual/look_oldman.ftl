<!DOCTYPE html>
<html>

<head>
<#include "head.ftl" />
</head>

<body>
<div class="container-fluid">
    <div class="row">
        <div class="left col-lg-6">
            <div class="row">
                <div class="col-lg-6">

                </div>
                <div class="col-lg-6">

                </div>
            </div>
            <div class="row">
                <div class="col-lg-6">

                </div>
                <div class="col-lg-6">

                </div>
            </div>
        </div>
        <div class="right col-lg-6">
            <div class="row">
                <div class="col-lg-6">
                    <div id="zd-oldman-gx-bar" class="tu"></div>
                </div>
                <div class="col-lg-6">
                    <div class="row">
                        <#--重点老人供需-->
                        <div id="zd-oldman-gx-pie" class="tu_small"></div>
                    </div>
                    <div class="row">
                        <div id="zd-oldman-gx-line" class="tu_small"></div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6">
                    <#--居家社区老人安排-->
                    <div id="js-oldman-ap-bar" class="tu"></div>
                </div>
                <div class="col-lg-6">
                    <div class="row">
                        <div id="js-oldman-ap-pie" class="tu_small"></div>
                    </div>
                    <div class="row">
                        <div id="js-oldman-ap-line" class="tu_small"></div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-4">
                    <div id="gz_sub_pie" class="tu_big_pie"></div>
                </div>
                <div class="col-lg-8">
                    <div class="row">
                        <div class="col-lg-4">
                            <div id="gz_py_pie" class="tu_small_pie"></div>
                        </div>
                        <div class="col-lg-4">
                            <div id="gz_dl_pie"  class="tu_small_pie"></div>
                        </div>
                        <div class="col-lg-4">
                            <div id="gz_gl_pie"  class="tu_small_pie"></div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-4">
                            <div id="gz_pj_pie"  class="tu_small_pie"></div>
                        </div>
                        <div class="col-lg-4">
                            <div id="gz_pn_pie"  class="tu_small_pie"></div>
                        </div>
                        <div class="col-lg-4">
                            <div id="gz_gm_pie"  class="tu_small_pie"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript">
        $(".tu").css('width',winWidth/6);
        $(".tu").css( 'height', winHeight*0.3);
        $(".tu_small").css('width',winWidth/6);
        $(".tu_small").css( 'height', winHeight*0.15);
        $(".tu_big_pie").css('width',winWidth/6);
        $(".tu_big_pie").css( 'height', winHeight*0.3);
        $(".tu_small_pie").css('width',winWidth/12);
        $(".tu_small_pie").css( 'height', winHeight*0.15);
        var js_oldman_ap_bar = echarts.init(document.getElementById('js-oldman-ap-bar'));
        var js_oldman_ap_line= echarts.init(document.getElementById('js-oldman-ap-line'));
        var js_oldman_ap_pie= echarts.init(document.getElementById('js-oldman-ap-pie'));
        var zd_oldman_gx_bar = echarts.init(document.getElementById('zd-oldman-gx-bar'));
        var zd_oldman_gx_line= echarts.init(document.getElementById('zd-oldman-gx-line'));
        var zd_oldman_gx_pie= echarts.init(document.getElementById('zd-oldman-gx-pie'));

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
    title_text='各片区重点老人安排情况柱状图';
    legend_data=[
        {
            name:'已安排',
            textStyle:{
                color:'#fff'
            }
        },
        {
            name:'未安排',
            textStyle:{
                color:'#fff'
            }}
        ];
    yAxis_data=['平阳','东兰','古龙','平吉','平南','古美'];
    series=[
        {
            name: '已安排',
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
            data: [167,134,234,134,145,123]
        },
        {
            name: '未安排',
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
            data: [45,45,121,67,34,134]
        }
    ];
    var option_zd_oldman_gx_bar=chartBar(title_text,legend_data,yAxis_data,series);
    title_text="古美街道重点老人安排情况饼图";
    legend_data=[{name:'已安排',textStyle:{color:legend_color}},{name:'未安排',textStyle:{color:legend_color}}];
    series=[{
        name: '安排与否',
        type: 'pie',
        radius : '55%',
        center: ['50%', '60%'],
        data:[
            {value:1033, name:'已安排'},
            {value:376, name:'未安排'}
        ],
        itemStyle: {
            emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
        }
    }];
    var option_zd_oldman_gx_pie = chartPie(title_text,legend_data,series);
    title_text='各片区重点老人供需趋势';
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
    var option_zd_oldman_gx_line = chartLine(title_text,legend_data,xAxis_data,series);

    title_text='各片区居家社区养老重点老人服务覆盖度柱状图';
    legend_data=[
        {
            name:'已接受',
            textStyle:{
                color:'#fff'
            }
        },
        {
            name:'未接受',
            textStyle:{
                color:'#fff'
            }}
    ];
    yAxis_data=['平阳','东兰','古龙','平吉','平南','古美'];
    series=[
        {
            name: '已接受',
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
            data: [167,134,234,134,145,123]
        },
        {
            name: '未接受',
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
            data: [45,45,121,67,34,134]
        }
    ];
    var option_js_oldman_ap_bar=chartBar(title_text,legend_data,yAxis_data,series);
    title_text="古美街道居家社区养老重点老人服务覆盖度饼图";
    legend_data=[{name:'已接受',textStyle:{color:legend_color}},{name:'未接受',textStyle:{color:legend_color}}];
    series=[{
        name: '安排与否',
        type: 'pie',
        radius : '55%',
        center: ['50%', '60%'],
        data:[
            {value:1033, name:'已接受'},
            {value:376, name:'未接受'}
        ],
        itemStyle: {
            emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
        }
    }];
    var option_js_oldman_ap_pie = chartPie(title_text,legend_data,series);
    title_text='各片区居家社区养老重点老人服务覆盖度趋势';
    legend_data=[{name:'平阳',textStyle:{color:legend_color}},{name:'东兰',textStyle:{color:legend_color}},
        {name:'古龙',textStyle:{color:legend_color}},{name:'平吉',textStyle:{color:legend_color}},
    {name:'平南',textStyle:{color:legend_color}},{name:'古美',textStyle:{color:legend_color}}];
    xAxis_data=['11月','12月','1月','2月','3月','4月'];
    series=[
        {
            name: '平阳',
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
            name: '东兰',
            type: 'line',
            stack: '总量',
            itemStyle:{
                normal: {
                    color:series_color_2
                }
            },
            data: [100,105,110,110,115,120]
        },
        {
            name: '古龙',
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
            name: '平吉',
            type: 'line',
            stack: '总量',
            itemStyle:{
                normal: {
                    color:series_color_4
                }
            },
            data: [50,55,60,70,75,80]
        },
        {
            name: '平南',
            type: 'line',
            stack: '总量',
            itemStyle:{
                normal: {
                    color:series_color_4
                }
            },
            data: [50,55,60,70,75,80]
        },
        {
            name: '古美',
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
    var option_js_oldman_ap_line = chartLine(title_text,legend_data,xAxis_data,series);

    title_text="古美街道暂未安排重点老人关注程度";
    legend_data=[{name:'已关注',textStyle:{color:legend_color}},{name:'未关注',textStyle:{color:legend_color}}];
    series=[{
        name: '关注度',
        type: 'pie',
        radius : '55%',
        center: ['50%', '60%'],
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
    title_text="平阳片区暂未安排重点老人关注程度";
    legend_data=[{name:'已关注',textStyle:{color:legend_color}},{name:'未关注',textStyle:{color:legend_color}}];
    series=[{
        name: '关注度',
        type: 'pie',
        radius : '55%',
        center: ['50%', '60%'],
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
    title_text="东兰片区暂未安排重点老人关注程度";
    legend_data=[{name:'已关注',textStyle:{color:legend_color}},{name:'未关注',textStyle:{color:legend_color}}];
    series=[{
        name: '关注度',
        type: 'pie',
        radius : '55%',
        center: ['50%', '60%'],
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
    title_text="古龙片区暂未安排重点老人关注程度";
    legend_data=[{name:'已关注',textStyle:{color:legend_color}},{name:'未关注',textStyle:{color:legend_color}}];
    series=[{
        name: '关注度',
        type: 'pie',
        radius : '55%',
        center: ['50%', '60%'],
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
    title_text="平平吉片区暂未安排重点老人关注程度";
    legend_data=[{name:'已关注',textStyle:{color:legend_color}},{name:'未关注',textStyle:{color:legend_color}}];
    series=[{
        name: '关注度',
        type: 'pie',
        radius : '55%',
        center: ['50%', '60%'],
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
    title_text="平南片区暂未安排重点老人关注程度";
    legend_data=[{name:'已关注',textStyle:{color:legend_color}},{name:'未关注',textStyle:{color:legend_color}}];
    series=[{
        name: '关注度',
        type: 'pie',
        radius : '55%',
        center: ['50%', '60%'],
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
    title_text="古美片区暂未安排重点老人关注程度";
    legend_data=[{name:'已关注',textStyle:{color:legend_color}},{name:'未关注',textStyle:{color:legend_color}}];
    series=[{
        name: '关注度',
        type: 'pie',
        radius : '55%',
        center: ['50%', '60%'],
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

    js_oldman_ap_bar.setOption(option_js_oldman_ap_bar);
    js_oldman_ap_line.setOption(option_js_oldman_ap_line);
    js_oldman_ap_pie.setOption(option_js_oldman_ap_pie);
    zd_oldman_gx_bar.setOption(option_zd_oldman_gx_bar);
    zd_oldman_gx_line.setOption(option_zd_oldman_gx_line);
    zd_oldman_gx_pie.setOption(option_zd_oldman_gx_pie);

    gz_sub_pie.setOption(option_gz_sub_pie);
    gz_py_pie.setOption(option_gz_py_pie);
    gz_dl_pie.setOption(option_gz_dl_pie);
    gz_gl_pie.setOption(option_gz_gl_pie);
    gz_pj_pie.setOption(option_gz_pj_pie);
    gz_pn_pie.setOption(option_gz_pn_pie);
    gz_gm_pie.setOption(option_gz_gm_pie);
</script>
</html>