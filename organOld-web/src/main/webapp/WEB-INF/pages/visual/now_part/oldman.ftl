<!DOCTYPE html>
<html>

<head>
<#include "../head.ftl" />
</head>

<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-6">
            <div class="row" align="center">
                <div class="col-lg-12">
                    <p class="map_title">古美路街道老人分布图</p>
                <#include "map.ftl"/>
                </div>
            </div>
            <div class="row" style="position: relative;right: 5px;top:5px">
            <#include "table.ftl"/>
            </div>
        </div>
        <div class="col-lg-6">
            <div class="row" >
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
        var tu_w,tu_h;
        if(winWidth>=1700){
            //家里电脑的分辨率
            tu_w=winWidth/4.5;
            tu_h=winHeight/2.17;
        }else if(winWidth<=1400 && winWidth>=1300){
            tu_w=winWidth/4.5;
            tu_h=winHeight/2.17;
        }
        $(".tu").css('width',tu_w);
        $(".tu").css( 'height', tu_h);
        var econmicPie= echarts.init(document.getElementById('econmicPie'));
        var zbPie= echarts.init(document.getElementById('zbPie'));
        var familyPie= echarts.init(document.getElementById('familyPie'));
        var healthPie= echarts.init(document.getElementById('healthPie'));
    </script>
</div>


</body>
<script>
    //家庭结构
    title.text="家庭结构";
    title.link="javascript: location.href='/visual/now/part/family'";
    legend_data=[{name:'纯老',textStyle:{color:legend_color,fontSize:legand_fontSize}},{name:'独居',textStyle:{color:legend_color,fontSize:legand_fontSize}}
        ,{name:'失独',textStyle:{color:legend_color,fontSize:legand_fontSize}},{name:'一老养一老',textStyle:{color:legend_color,fontSize:legand_fontSize}},
        {name:'孤老',textStyle:{color:legend_color,fontSize:legand_fontSize}},{name:'三支人员',textStyle:{color:legend_color,fontSize:legand_fontSize}},{name:'其他',textStyle:{color:legend_color,fontSize:legand_fontSize}}];
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
    var option_family_pie = chartPieClick(title,legend_data,series);

    familyPie.setOption(option_family_pie);

    title.text="老人比例";
    title.link="javascript: location.href='/visual/now/part/base'";
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
    var option_zb_pie = chartPieClick(title,legend_data,series);
    zbPie.setOption(option_zb_pie);

    title.text="健康状态";
    title.link="javascript: location.href='/visual/now/part/health'";
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
    var option_health_pie = chartPieClick(title,legend_data,series);
    healthPie.setOption(option_health_pie);

    title.text="经济条件";
    title.link="javascript: location.href='/visual/now/part/economic'";
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
    var option_econmic_pie = chartPieClick(title,legend_data,series);
    econmicPie.setOption(option_econmic_pie);
</script>
</html>