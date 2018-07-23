<!DOCTYPE html>
<html>

<head>
<#include "../head.ftl" />
    <style>
        @media only screen and (min-width: 1700px){
            .zn_big,.zn,.jt{
                padding-top: 5%;
                padding-bottom: 2%;
            }
        }

        @media only screen and (min-width: 1300px) and ( max-width: 1400px){
            .zn_big,.zn,.jt{
                padding-top: 5%;
                padding-bottom: 2%;
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
                    <p class="map_title" onclick="location.href='/visual/now/part/organ'" style="cursor: pointer">智能化应用配置</p>
                </div>
            </div>
            <div class="row"  >
                <div class="col-lg-6 box">
                    <div class="zz"></div>
                    <div id="zn_num_pie" class="zn_big"></div>
                </div>
                <div class="col-lg-6 box"  >
                    <div class="zz"></div>
                    <div id="zn_pie" class="zn_big"></div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-4 box">
                    <div class="zz"></div>
                    <div id="zn_age_bar" class="zn"></div>
                </div>
                <div class="col-lg-4 box line">
                    <div class="zz"></div>
                    <div id="zn_sex_pie" class="zn"></div>
                </div>
                <div class="col-lg-4 box"  >
                    <div class="zz"></div>
                    <div id="zn_pq_bar" class="zn"></div>
                </div>
            </div>
            <div class="row" >
                <#include "table.ftl" />
            </div>
        </div>
        <div class="col-lg-6" >
            <div class="row" align="center">
                <div class="col-lg-12">
                    <p class="map_title" onclick="location.href='/visual/now/part/organ'" style="cursor: pointer">家庭医生</p>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-3 box" align="center">
                    <div class="zz"></div>
                    <div id="jt_ys_num_pie" class="jt"></div>
                </div>
                <div class="col-lg-3 box" align="center" >
                    <div class="zz"></div>
                    <div id="jt_ys_age_bar" class="jt"></div>
                </div>
                <div class="col-lg-3 box" align="center">
                    <div class="zz"></div>
                    <div id="jt_ys_pq_bar" class="jt"></div>
                </div>
                <div class="col-lg-3 box" align="center" >
                    <div class="zz"></div>
                    <div id="jt_ys_sex_pie" class="jt"></div>
                </div>
            </div>
            <div class="row" align="center"  style="margin-top: 20px">
                <div class="col-lg-12">
                    <p class="map_title" onclick="location.href='/visual/now/part/organ'" style="cursor: pointer">家庭病床</p>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-3 box" align="center">
                    <div class="zz"></div>
                    <div id="jt_bc_num_pie" class="jt"></div>
                </div>
                <div class="col-lg-3 box" align="center">
                    <div class="zz"></div>
                    <div id="jt_bc_age_bar" class="jt"></div>
                </div>
                <div class="col-lg-3 box" align="center" >
                    <div class="zz"></div>
                    <div id="jt_bc_pq_bar" class="jt"></div>
                </div>
                <div class="col-lg-3 box" align="center" >
                    <div class="zz"></div>
                    <div id="jt_bc_sex_pie" class="jt"></div>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript">
        var zn_w,zn_h,zn_big_w,zn_big_h,jt_w,jt_h;
        if(winWidth>=1700){
            //家里电脑的分辨率
            zn_w=winWidth/7;
            zn_h=winHeight/3.37;
            zn_big_w=winWidth/4.5;
            zn_big_h=winHeight/3.37;
            jt_w=winWidth/10;
            jt_h=winHeight/2.55;
        }else if(winWidth<=1400 && winWidth>=1300){
            zn_w=winWidth/7;
            zn_h=winHeight/3.37;
            zn_big_w=winWidth/4.5;
            zn_big_h=winHeight/3.37;
            jt_w=winWidth/10;
            jt_h=winHeight/2.55;
        }


        $(".zn").css('width',zn_w);
        $(".zn").css( 'height', zn_h);
        $(".zn_big").css('width',zn_big_w);
        $(".zn_big").css( 'height',zn_big_h);
        $(".jt").css('width',jt_w);
        $(".jt").css( 'height', jt_h);

        var zn_num_pie = echarts.init(document.getElementById('zn_num_pie'));
        var zn_pie = echarts.init(document.getElementById('zn_pie'));
        var zn_age_bar= echarts.init(document.getElementById('zn_age_bar'));
        var zn_pq_bar= echarts.init(document.getElementById('zn_pq_bar'));
        var zn_sex_pie= echarts.init(document.getElementById('zn_sex_pie'));
        var jt_ys_age_bar = echarts.init(document.getElementById('jt_ys_age_bar'));
        var jt_ys_pq_bar = echarts.init(document.getElementById('jt_ys_pq_bar'));
        var jt_ys_sex_pie = echarts.init(document.getElementById('jt_ys_sex_pie'));
        var jt_bc_age_bar = echarts.init(document.getElementById('jt_bc_age_bar'));
        var jt_bc_pq_bar = echarts.init(document.getElementById('jt_bc_pq_bar'));
        var jt_bc_sex_pie = echarts.init(document.getElementById('jt_bc_sex_pie'));

        var jt_bc_num_pie = echarts.init(document.getElementById('jt_bc_num_pie'));
        var jt_ys_num_pie = echarts.init(document.getElementById('jt_ys_num_pie'));
    </script>
</div>

</body>
<script>
    title_text="人数占比";
    legend_data=[{name:'已使用的重点老人',textStyle:{color:legend_color,fontSize:18}},{name:'未使用的重点老人',textStyle:{color:legend_color,fontSize:18}}];
    series=[
        {
            name:'访问来源',
            type:'pie',
            radius: ['40%', '60%'],
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
                {value:1360, name:'未使用的重点老人'},
                {value:234, name:'已使用的重点老人'}
            ]
        }
    ];
    var option_zn_num_pie = chartPie(title_text,legend_data,series);
    zn_num_pie.setOption(option_zn_num_pie);

    title_text="人数占比";
    legend_data=[{name:'已参加',textStyle:{color:legend_color,fontSize:18}},{name:'未参加',textStyle:{color:legend_color,fontSize:18}}];
    series=[
        {
            name:'访问来源',
            type:'pie',
            radius: ['40%', '60%'],
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
                {value:1360, name:'未参加'},
                {value:234, name:'已参加'}
            ]
        }
    ];
    var option_jt_ys_num= chartPie(title_text,legend_data,series);
    jt_ys_num_pie.setOption(option_jt_ys_num);

    title_text="人数占比";
    legend_data=[{name:'已参加',textStyle:{color:legend_color,fontSize:18}},{name:'未参加',textStyle:{color:legend_color,fontSize:18}}];
    series=[
        {
            name:'访问来源',
            type:'pie',
            radius: ['40%', '60%'],
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
                {value:1360, name:'未参加'},
                {value:234, name:'已参加'}
            ]
        }
    ];
    var option_jt_bc_num= chartPie(title_text,legend_data,series);
    jt_bc_num_pie.setOption(option_jt_bc_num);


    title_text="各类产品服务人数分布";
    legend_data=[{name:'智能设备1',textStyle:{color:legend_color,fontSize:18}},{name:'智能设备2',textStyle:{color:legend_color,fontSize:18}},{name:'智能设备3',textStyle:{color:legend_color,fontSize:18}}];
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
        center: ['48%', '60%'],
        data:[
            {value:476, name:'智能设备1'},
            {value:376, name:'智能设备2'},
            {value:376, name:'智能设备3'}
        ],
        itemStyle: {
            emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
        }
    }];
    var option_zn_pie = chartPie(title_text,legend_data,series);
    zn_pie.setOption(option_zn_pie);

    title_text="总服务人数性别分布";
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
    var option_zn_sex_pie = chartPie(title_text,legend_data,series);
    zn_sex_pie.setOption(option_zn_sex_pie);

    title_text='总服务人数年龄分布';
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
                    fontSize:18
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
                    fontSize:18
                }
            },
            data: [7,34,134,234]
        }
    ];
    var option_zn_age_bar=chartBar(title_text,legend_data,yAxis_data,series);
    zn_age_bar.setOption(option_zn_age_bar);

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
                    position: 'right',
                    position: 'right',
                    textStyle:{
                        fontSize:20
                    }
                }
            },
            itemStyle:{
                normal: {
                    color:series_color_1,
                    fontSize:18
                }
            },
            data: [67,134,234,534,263,231]
        }
    ];
    var option_zn_pq_bar=chartBar(title_text,legend_data,yAxis_data,series);
    zn_pq_bar.setOption(option_zn_pq_bar);

    title_text="性别分布";
    legend_data=[{name:'男',textStyle:{color:legend_color,fontSize:18}},{name:'女',textStyle:{color:legend_color,fontSize:18}}];
    series=[{
        name: '老人性别',
        type: 'pie',
        radius : '45%',
        label : {
            normal : {
                formatter: '{d}%\n({c})',
                textStyle : {
                    fontWeight : 'normal',
                    fontSize : 8
                }
            }
        },
        center: ['50%', '50%'],
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
    var option_jt_ys_sex_pie = chartPie(title_text,legend_data,series);
    jt_ys_sex_pie.setOption(option_jt_ys_sex_pie);

    title_text='年龄分布';
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
    var option_jt_ys_age_bar=chartBar(title_text,legend_data,yAxis_data,series);
    jt_ys_age_bar.setOption(option_jt_ys_age_bar);


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
                    position: 'right',
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
            data: [67,134,234,534,263,231]
        }
    ];
    var option_jt_ys_pq_bar=chartBar(title_text,legend_data,yAxis_data,series);
    jt_ys_pq_bar.setOption(option_jt_ys_pq_bar);

    title_text="性别分布";
    legend_data=[{name:'男',textStyle:{color:legend_color,fontSize:18}},{name:'女',textStyle:{color:legend_color,fontSize:18}}];
    series=[{
        name: '老人性别',
        type: 'pie',
        radius : '45%',
        label : {
            normal : {
                formatter: '{d}%\n{c}',
                textStyle : {
                    fontWeight : 'normal',
                    fontSize : 8
                }
            }
        },
        center: ['50%', '50%'],
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
    var option_jt_bc_sex_pie = chartPie(title_text,legend_data,series);
    jt_bc_sex_pie.setOption(option_jt_bc_sex_pie);

    title_text='年龄分布';
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
    var option_jt_bc_age_bar=chartBar(title_text,legend_data,yAxis_data,series);
    jt_bc_age_bar.setOption(option_jt_bc_age_bar);

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
                    position: 'right',
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
            data: [67,134,234,534,263,231]
        }
    ];
    var option_jt_bc_pq_bar=chartBar(title_text,legend_data,yAxis_data,series);
    jt_bc_pq_bar.setOption(option_jt_bc_pq_bar);
</script>
</html>