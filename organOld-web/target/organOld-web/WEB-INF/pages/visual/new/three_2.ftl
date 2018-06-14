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
        .tu,.tu_big,#num_pie,.tu_pie{
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
            font-size: 20px;
            font-weight: bold;
            margin-top: 10px;
        }
    </style>
</head>

<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-6">
            <div class="row" align="center">
                <div class="col-lg-12">
                    <p class="map_title">长护险</p>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12 box" style="margin-bottom: 5px" align="center">
                    <div class="zz"></div>
                    <div id="num_pie"></div>
                </div>
            </div>
            <div class="row">
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
        <div class="col-lg-6" style="position: relative;left: 7px">
            <div class="row">
                <div class="col-lg-4 box">
                    <div class="zz"></div>
                    <div id="pj_jb_bar" class="tu"></div>
                </div>
                <div class="col-lg-4 box line" >
                    <div class="zz"></div>
                    <div id="pj_age_bar" class="tu"></div>
                </div>
                <div class="col-lg-4 box" style="position: relative;left: 10px">
                    <div class="zz"></div>
                    <div id="pj_pq_bar" class="tu"></div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6 box">
                    <div class="zz"></div>
                    <div id="pj_sex_pie" class="tu_pie"></div>
                </div>
                <div class="col-lg-6 box" style="position: relative;left: 5px;margin-bottom: 5px">
                    <div class="zz"></div>
                    <div id="pj_hj_pie" class="tu_pie"></div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-4 box">
                    <div class="zz"></div>
                    <div id="fw_jb_bar" class="tu"></div>
                </div>
                <div class="col-lg-4 box line">
                    <div class="zz"></div>
                    <div id="fw_age_bar" class="tu"></div>
                </div>
                <div class="col-lg-4 box" style="position: relative;left: 10px;margin-bottom: 5px">
                    <div class="zz"></div>
                    <div id="fw_pq_bar" class="tu"></div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6 box">
                    <div class="zz"></div>
                    <div id="fw_sex_pie" class="tu_pie"></div>
                </div>
                <div class="col-lg-6 box" style="position: relative;left: 5px;">
                    <div class="zz"></div>
                    <div id="fw_hj_pie" class="tu_pie"></div>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript">
        $(".tu").css('width',winWidth/7);
        $(".tu").css( 'height', winHeight/4.35);

        $(".tu_pie").css('width',winWidth/4.5);
        $(".tu_pie").css( 'height', winHeight/4.35);

        $("#num_pie").css('width',winWidth/3);
        $("#num_pie").css( 'height', winHeight/1.65);

        var num_pie=echarts.init(document.getElementById('num_pie'));

        var pj_jb_bar = echarts.init(document.getElementById('pj_jb_bar'));
        var pj_pq_bar = echarts.init(document.getElementById('pj_pq_bar'));
        var pj_age_bar= echarts.init(document.getElementById('pj_age_bar'));
        var pj_sex_pie= echarts.init(document.getElementById('pj_sex_pie'));
        var pj_hj_pie = echarts.init(document.getElementById('pj_hj_pie'));

        var fw_jb_bar = echarts.init(document.getElementById('fw_jb_bar'));
        var fw_pq_bar = echarts.init(document.getElementById('fw_pq_bar'));
        var fw_age_bar= echarts.init(document.getElementById('fw_age_bar'));
        var fw_sex_pie= echarts.init(document.getElementById('fw_sex_pie'));
        var fw_hj_pie = echarts.init(document.getElementById('fw_hj_pie'));
    </script>
</div>

</body>
<script>
    //    级别分布柱状图
    title_text='已经评级老人的级别分布';
    legend_data=[];
    yAxis_data=['2级','3级','4级','5级','6级'];
    series=[
        {
            name: '男',
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
            data: [167,134,24,54,6]
        }
    ];
    var option_pj_jb_bar=chartBar(title_text,legend_data,yAxis_data,series);
    pj_jb_bar.setOption(option_pj_jb_bar);

    //数量饼图
    title_text="";
    legend_data=[{name:'获得服务',textStyle:{color:legend_color,fontSize:18}},{name:'未评级',textStyle:{color:legend_color,fontSize:18}},{name:'已经评级',textStyle:{color:legend_color,fontSize:18}}];
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
                {value:76, name:'获得服务'},
                {value:276, name:'已经评级'},
                {value:576, name:'未评级'}
            ]
        }
        ];
    var option_num_pie = chartPie_1(title_text,legend_data,series);
    num_pie.setOption(option_num_pie);

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
            data: [67,134,234,534,263,231]
        }
    ];
    var option_pj_pq_bar=chartBar(title_text,legend_data,yAxis_data,series);
    pj_pq_bar.setOption(option_pj_pq_bar);

    //    已评级年龄分布柱状图
    title_text='已评级老人的年龄分布';
    legend_data=[];
    yAxis_data=['90-','80-90','70-80','60-70'];
    series=[
        {
            name: '男',
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
            data: [67,134,234,534]
        }
    ];
    var option_pj_age_bar=chartBar(title_text,legend_data,yAxis_data,series);
    pj_age_bar.setOption(option_pj_age_bar);


    title_text="已经评级老人户籍的分布";
    legend_data=[{name:'户籍',textStyle:{color:legend_color,fontSize:18}},{name:'非户籍',textStyle:{color:legend_color,fontSize:18}}];
    series=[{
        name: '老人户籍',
        type: 'pie',
        radius : '55%',
        center: ['48%', '60%'],
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
            {value:476, name:'户籍'},
            {value:376, name:'非户籍'}
        ],
        itemStyle: {
            emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
        }
    }];
    var option_pj_hj_pie = chartPie(title_text,legend_data,series);
    pj_hj_pie.setOption(option_pj_hj_pie);

    //性别饼图
    title_text="已评级老人的性别分布";
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
    var option_pj_sex_pie = chartPie(title_text,legend_data,series);
    pj_sex_pie.setOption(option_pj_sex_pie);


    //    级别分布柱状图
    title_text='获得服务老人的级别分布';
    legend_data=[];
    yAxis_data=['2级','3级','4级','5级','6级'];
    series=[
        {
            name: '男',
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
            data: [167,134,24,54,6]
        }
    ];
    var option_fw_jb_bar=chartBar(title_text,legend_data,yAxis_data,series);
    fw_jb_bar.setOption(option_fw_jb_bar);

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
            data: [67,134,234,534,263,231]
        }
    ];
    var option_fw_pq_bar=chartBar(title_text,legend_data,yAxis_data,series);
    fw_pq_bar.setOption(option_fw_pq_bar);

    //    已评级年龄分布柱状图
    title_text='获得服务老人的年龄分布';
    legend_data=[];
    yAxis_data=['90-','80-90','70-80','60-70'];
    series=[
        {
            name: '男',
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
            data: [67,134,234,534]
        }
    ];
    var option_fw_age_bar=chartBar(title_text,legend_data,yAxis_data,series);
    fw_age_bar.setOption(option_fw_age_bar);


    title_text="获得服务老人户籍的分布";
    legend_data=[{name:'户籍',textStyle:{color:legend_color,fontSize:18}},{name:'非户籍',textStyle:{color:legend_color,fontSize:18}}];
    series=[{
        name: '老人户籍',
        type: 'pie',
        radius : '55%',
        center: ['48%', '60%'],
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
            {value:476, name:'户籍'},
            {value:376, name:'非户籍'}
        ],
        itemStyle: {
            emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
        }
    }];
    var option_fw_hj_pie = chartPie(title_text,legend_data,series);
    fw_hj_pie.setOption(option_fw_hj_pie);

    //性别饼图
    title_text="获得服务老人的性别分布";
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
    var option_fw_sex_pie = chartPie(title_text,legend_data,series);
    fw_sex_pie.setOption(option_fw_sex_pie);


</script>
</html>