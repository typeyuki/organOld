<!DOCTYPE html>
<html>

<head>
    <#include "head.ftl" />
    <style>
        .chart_left{
            margin-bottom: 1;
            /*background-color: rgb(16, 58, 68);*/
        }
        h2,p,td,h3,h1,span{
            color: white!important;
        }
        .box{
            box-shadow:inset 0px 0px 6px 0px rgba(255, 255, 255, 0.7);
            position: relative;
            border-radius: 5px;

            /*background-color:rgba(255, 255, 255, 0.1) ;*/
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
        .tu_right{
            padding-top: 5%;
        }
    </style>
</head>

<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-12">
            <div class="row">
                <div class="col-lg-6" align="center">
                    <div class="row">
                        <div class="col-lg-2">
                            <#--<p>日历</p>-->
                        </div>
                        <div class="col-lg-8">
                            <p style="font-size:50px;text-align: center;padding-bottom: 20px;font-weight: bold">古&nbsp;&nbsp;美&nbsp;&nbsp;街&nbsp;&nbsp;道</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12" style="position: relative">
                            <img src="/static/img/map/gumei_9.jpg" style="width:75%;">
                            <span style="position: absolute;top:700px;left: 180px;color: white;text-align: center">平阳五村<br>532人</span>
                            <span style="position: absolute;top:635px;left: 275px;color: white;text-align: center">平阳四村<br>532人</span>
                            <span style="position: absolute;top:615px;left: 180px;color: white;text-align: center">平阳三村<br>532人</span>
                            <span style="position: absolute;top:535px;left: 290px;color: white;text-align: center">平阳二村<br>532人</span>
                            <span style="position: absolute;top:530px;left: 190px;color: white;text-align: center">平阳一村<br>532人</span>
                            <span style="position: absolute;top:700px;left: 270px;color: white;text-align: center">平阳六村<br>532人</span>
                        </div>
                    </div>
                   <div class="row">
                       <div class="col-lg-12">
                           <div style="margin: 50px">
                               <button style="background-color: #d39693;width: 30px;height: 20px;border: none;border-radius: 5px"></button><span style="position: relative;top: -3px;left:10px;color: white">平阳</span>
                           </div>
                       </div>
                   </div>
                </div>
                <div class="col-lg-6">
                    <div class="row  chart_left">
                        <div class="col-lg-6 box" align="center" style="margin-bottom: 5px">
                            <div class="zz"></div>
                            <div id="gumeiPie" class="tu_right"></div>
                        </div>
                        <div class="col-lg-6 box" align="center" style="position: relative;left: 5px;margin-bottom: 5px">
                            <div class="zz"></div>
                            <div id="hujiPie" class="tu_right"></div>
                        </div>
                    </div>
                    <div class="row chart_left">
                        <div class="col-md-6 box" align="center" style="margin-bottom: 5px">
                            <div class="zz"></div>
                            <div id="pqBar" class="tu_right"></div>
                        </div>
                        <div class="col-md-6 box" align="center" style="position: relative;left: 5px">
                            <div class="zz"></div>
                            <div id="jwBar" class="tu_right"></div>
                        </div>
                    </div>
                    <div class="row" >
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
                                                    <th>住址</th>
                                                    <th>所属居委会</th>
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
        </div>

    </div>
    <script type="text/javascript">
        $(".tu_right").css('width',winWidth/5);
        $(".tu_right").css( 'height', winHeight/(3.7));

        var pqBar= echarts.init(document.getElementById('pqBar'));
        var jwBar= echarts.init(document.getElementById('jwBar'));

        var gumeiPie=echarts.init(document.getElementById('gumeiPie'));
        var hujiPie=echarts.init(document.getElementById('hujiPie'));

    </script>
</div>

<#include "set.ftl" />
</body>
<#--<script src="/js/content.min.js?v=1.0.0"></script>-->
<#--<script src="/static/js/visual/oldman.js" ></script>-->
<#--<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>-->
<script type="text/javascript">
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
                    position: 'right'
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
    //居委人数分布
    legend_data="";
    title_text='居委人口分布柱状';
    yAxis_data=['东兰一村','东兰二村','东兰三村','东兰四村'];
    series=[
        {
            name: '',
            type: 'bar',
            stack: '总量',
            label: {
                normal: {
                    show: true,
                    position: 'right'
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
    var option_jw_bar=chartBar(title_text,legend_data,yAxis_data,series);

    //古美老人分布
    title_text="老人所占比例";
    legend_data=[{name:'非老人',textStyle:{color:legend_color}},{name:'老人',textStyle:{color:legend_color}},{name:'重点老人',textStyle:{color:legend_color}}];
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
                        fontSize : 10
                    }
                }
            },
            data:[
                {value:15360, name:'非老人'},
                {value:4310, name:'老人'},
                {value:234, name:'重点老人'}
            ]
        }
    ];
    var option_gumei_pie = chartPie(title_text,legend_data,series);

    //古美老人户籍分布
    title_text="户籍所占比例";
    legend_data=[{name:'户籍',textStyle:{color:legend_color}},{name:'非户籍',textStyle:{color:legend_color}}];
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
                        fontSize : 10
                    }
                }
            },
            data:[
                {value:5360, name:'户籍'},
                {value:4310, name:'非户籍'}
            ]
        }
    ];
    var option_huji_pie = chartPie(title_text,legend_data,series);

        pqBar.setOption(option_pq_bar);
        jwBar.setOption(option_jw_bar);
        gumeiPie.setOption(option_gumei_pie);
        hujiPie.setOption(option_huji_pie);
</script>
</html>