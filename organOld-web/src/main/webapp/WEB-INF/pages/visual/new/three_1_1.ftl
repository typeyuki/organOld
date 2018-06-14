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
        .tu,.tu_big,#num_pie,.tu_middle{
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
                    <p class="map_title">家庭养老</p>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6 box" style="margin-bottom: 5px" align="center">
                    <div class="zz"></div>
                    <div id="num_pie" class="tu_middle"></div>
                </div>
                <div class="col-lg-6 box" style="margin-bottom: 5px ;position:relative;left:5px" align="center">
                    <div class="zz"></div>
                    <div id="pq_bar" class="tu_middle"></div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12 box" style="margin-bottom: 5px ;position:relative;left:2.5px" align="center">
                    <div class="zz"></div>
                    <div id="jj_pie" class="tu_big"></div>
                </div>
            </div>
        </div>
        <div class="col-lg-6" style="position: relative;left: 7px">
            <div class="row">
                <div class="col-lg-6 box">
                    <div class="zz"></div>
                    <div id="sex_pie" class="tu"></div>
                </div>
                <div class="col-lg-6 box" style="position: relative;left: 5px;margin-bottom: 5px">
                    <div class="zz"></div>
                    <div id="age_bar" class="tu"></div>
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
    </div>
    <script type="text/javascript">
        $(".tu").css('width',winWidth/4.5);
        $(".tu").css( 'height', winHeight/1.485);
        $(".tu_middle").css('width',winWidth/6);
        $(".tu_middle").css( 'height', winHeight/2.3);
        $(".tu_big").css('width',winWidth/3);
        $(".tu_big").css( 'height', winHeight/2.3);

        var num_pie=echarts.init(document.getElementById('num_pie'));
        var pq_bar=echarts.init(document.getElementById('pq_bar'));
        var jj_pie = echarts.init(document.getElementById('jj_pie'));
        var age_bar= echarts.init(document.getElementById('age_bar'));
        var sex_pie= echarts.init(document.getElementById('sex_pie'));

    </script>
</div>


</body>
<script>
    title_text="人数占比";
    legend_data=[{name:'已参加的重点老人',textStyle:{color:legend_color,fontSize:18}},{name:'未参加的重点老人',textStyle:{color:legend_color,fontSize:18}}];
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
                {value:1360, name:'未参加的重点老人'},
                {value:234, name:'已参加的重点老人'}
            ]
        }
    ];
    var option_num= chartPie(title_text,legend_data,series);
    num_pie.setOption(option_num);

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
                    position: 'insideLeft'
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
    var option_pq_bar=chartBar(title_text,legend_data,yAxis_data,series);
    pq_bar.setOption(option_pq_bar);

    //    已评级年龄分布柱状图
    title_text='年龄分布柱状图';
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
    var option_age_bar=chartBar(title_text,legend_data,yAxis_data,series);
    age_bar.setOption(option_age_bar);




    //性别饼图
    title_text="性别分布";
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
    var option_sex_pie = chartPie(title_text,legend_data,series);
    sex_pie.setOption(option_sex_pie);


    title_text="服务内容";
    legend_data=[{name:'助餐',textStyle:{color:legend_color,fontSize:18}},{name:'助洁',textStyle:{color:legend_color,fontSize:18}},{name:'助急',textStyle:{color:legend_color,fontSize:18}}
        ,{name:'助浴',textStyle:{color:legend_color,fontSize:18}},{name:'助行',textStyle:{color:legend_color,fontSize:18}},{name:'助医',textStyle:{color:legend_color,fontSize:18}}
        ,{name:'洗衣服',textStyle:{color:legend_color,fontSize:18}},{name:'相谈',textStyle:{color:legend_color,fontSize:18}},{name:'康复辅助',textStyle:{color:legend_color,fontSize:18}}
        ,{name:'生活护理',textStyle:{color:legend_color,fontSize:18}},{name:'其他',textStyle:{color:legend_color,fontSize:18}}];
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
                    fontSize : 20
                }
            }
        },
        data:[
            {value:476, name:'助餐'},
            {value:376, name:'助洁'},
            {value:376, name:'助浴'},
            {value:476, name:'助行'},
            {value:376, name:'助医'},
            {value:376, name:'洗衣服'},
            {value:476, name:'相谈'},
            {value:376, name:'康复辅助'},
            {value:376, name:'生活护理'},
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
    var option_jj_pie = chartPie(title_text,legend_data,series);
    jj_pie.setOption(option_jj_pie);
</script>
</html>