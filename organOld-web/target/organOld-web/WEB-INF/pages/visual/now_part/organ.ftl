<!DOCTYPE html>
<html>

<head>
<#include "../head.ftl" />
<script src="../../../static/js/chart_part.js"></script>
</head>

<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-6">
            <div class="row" align="center">
                <div class="col-lg-12">
                    <div class="row">
                        <div class="col-lg-12">
                            <p class="map_title">古美路街道老人分布图</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12">
                        <#include "map.ftl"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row" style="position: relative;right: 5px;top:5px">
                <#include "table.ftl"/>
            </div>
        </div>
        <div class="col-lg-6">
            <div class="row">
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
        var tu_w,tu_h,tu_big_w,tu_big_h;
        if(winWidth>=1700){
            //家里电脑的分辨率
            tu_w=winWidth/7;
            tu_h=winHeight/2.37;
            tu_big_w=winWidth/4.5;
            tu_big_h=winHeight/2;
        }else if(winWidth<=1400 && winWidth>=1300){
            tu_w=winWidth/7;
            tu_h=winHeight/2.37;
            tu_big_w=winWidth/4.5;
            tu_big_h=winHeight/2;
        }
        $(".tu").css('width',tu_w);
        $(".tu").css( 'height', tu_h);
        $(".tu_big").css('width',tu_big_w);
        $(".tu_big").css( 'height', tu_big_h);

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


    title.text="机构养老";
    title.link="javascript: location.href='/visual/now/part/organOldman'";
    var data=[
        {value:335, name:'东兰养老院'},
        {value:310, name:'平阳养老院'},
        {value:400, name:'古美养老院'},
    ];
    // legend_data=[{name:'古美养老院',textStyle:{color:legend_color,fontSize:18}},{name:'东兰养老院',textStyle:{color:legend_color,fontSize:18}},{name:'平阳养老院',textStyle:{color:legend_color,fontSize:18}}];
    // series=[{
    //     name: '老人户籍',
    //     type: 'pie',
    //     radius : '65%',
    //     center: ['48%', '50%'],
    //     label : {
    //         normal : {
    //             formatter: '{d}%\n({c})',
    //             textStyle : {
    //                 fontWeight : 'normal',
    //                 fontSize : 14
    //             }
    //         }
    //     },
    //     data:[
    //         {value:476, name:'古美养老院'},
    //         {value:376, name:'东兰养老院'},
    //         {value:376, name:'平阳养老院'}
    //     ],
    //     itemStyle: {
    //         emphasis: {
    //             shadowBlur: 10,
    //             shadowOffsetX: 0,
    //             shadowColor: 'rgba(0, 0, 0, 0.5)'
    //         }
    //     }
    // }];
    var option_jg_pie = customizedPieClick(title,data);
    jg_pie.setOption(option_jg_pie);


    title_text="社区养老";
    data=[
        {value:476, name:'长者照护之家'},
        {value:376, name:'日照中心'},
        {value:376, name:'助餐点'},
    ];
    // legend_data=[{name:'长者照护之家',textStyle:{color:legend_color,fontSize:18}},{name:'日照中心',textStyle:{color:legend_color,fontSize:18}},{name:'助餐点',textStyle:{color:legend_color,fontSize:18}}];
    // series=[{
    //     name: '老人户籍',
    //     type: 'pie',
    //     radius : '65%',
    //     center: ['48%', '50%'],
    //     label : {
    //         normal : {
    //             formatter: '{d}%\n({c})',
    //             textStyle : {
    //                 fontWeight : 'normal',
    //                 fontSize : 14
    //             }
    //         }
    //     },
    //     data:[
    //         {value:476, name:'长者照护之家'},
    //         {value:376, name:'日照中心'},
    //         {value:376, name:'助餐点'}
    //     ],
    //     itemStyle: {
    //         emphasis: {
    //             shadowBlur: 10,
    //             shadowOffsetX: 0,
    //             shadowColor: 'rgba(0, 0, 0, 0.5)'
    //         }
    //     }
    // }];
    // var option_sq_sub_pie = chartPie(title_text,legend_data,series);
    // sq_sub_pie.setOption(option_sq_sub_pie);
    var option_sq_sub_pie = customizedPie(title_text,data);
    sq_sub_pie.setOption(option_sq_sub_pie);


    sq_sub_pie.on('legendselectchanged', function (params) {
        var name = params.name;
        if(name=="助餐点"){
            location.href='/visual/now/part/zcdOldman';
        }else if(name=="日照中心"){
            location.href='/visual/now/part/zzzhOldman';
        }else if(name=="长者照护之家"){
            location.href='/visual/now/part/zzzhOldman';
        }
    });
    //re

    title_text="居家养老";
    data=[
        {value:476, name:'家庭养老'},
        {value:676, name:'长护险'},
        {value:576, name:'智能化应用'},
        {value:476, name:'家庭医生'},
        {value:676, name:'家庭病床'}
    ];
    // legend_data=[{name:'家庭养老',textStyle:{color:legend_color,fontSize:18}},{name:'长护险',textStyle:{color:legend_color,fontSize:18}},{name:'智能化应用',textStyle:{color:legend_color,fontSize:18}}
    //     ,{name:'家庭医生',textStyle:{color:legend_color,fontSize:18}}
    //     ,{name:'家庭病床',textStyle:{color:legend_color,fontSize:18}}];
    // series=[{
    //     name: '居家养老',
    //     type: 'pie',
    //     radius : '65%',
    //     center: ['48%', '50%'],
    //     label : {
    //         normal : {
    //             formatter: '{d}%\n({c})',
    //             textStyle : {
    //                 fontWeight : 'normal',
    //                 fontSize : 14
    //             }
    //         }
    //     },
    //     data:[
    //         {value:476, name:'家庭养老'},
    //         {value:376, name:'长护险'},
    //         {value:376, name:'智能化应用'},
    //         {value:376, name:'家庭医生'},
    //         {value:376, name:'家庭病床'}
    //     ],
    //     itemStyle: {
    //         emphasis: {
    //             shadowBlur: 10,
    //             shadowOffsetX: 0,
    //             shadowColor: 'rgba(0, 0, 0, 0.5)'
    //         }
    //     }
    // }];
    var option_jj_pie = customizedPie(title_text,data);
    jj_pie.setOption(option_jj_pie);
    jj_pie.on('legendselectchanged', function (params) {
        var name = params.name;
        if(name=="家庭养老"){
            location.href='/visual/now/part/homeOldman';
        }else if(name=="长护险"){
            location.href='/visual/now/part/chxOldman';
        }else if(name=="智能化应用"){
            location.href='/visual/now/part/otherOldman';
        }else if(name=="家庭医生"){
            location.href='/visual/now/part/otherOldman';
        }else if(name=="家庭病床"){
            location.href='/visual/now/part/otherOldman';
        }
    });

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