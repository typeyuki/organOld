<!DOCTYPE html>
<html>

<head>
<#include "head.ftl" />

    <link href="//cdn.bootcss.com/jqcloud/1.0.4/jqcloud.min.css" rel="stylesheet">

    <script src="//cdn.bootcss.com/jqcloud/1.0.4/jqcloud-1.0.4.min.js"></script>

    <style>
        .label-title{
            text-align: center;
            font-size: 20px;
            font-weight: bold;
            padding-top: 10px;
        }
        h2,p,td,h1{
            color: white!important;
        }
        .ibox-content,.wrapper-content{
            padding-top: 0!important;
        }
        .jqcloud{
            margin:0 auto;
        }
        div.jqcloud span.w10 {
            font-size: 4em;
        }
        div.jqcloud span.w10,h3.w10 {
            color: red;
        }
        div.jqcloud span.w9 {
            font-size: 3.7em;
        }
        div.jqcloud span.w9,h3.w9 {
            color: rgb(172, 185, 51);
        }
        div.jqcloud span.w8 {
            font-size: 3.4em;
        }
        div.jqcloud span.w8,h3.w8 {
            color: rgb(100, 181, 206);
        }
        div.jqcloud span.w7 ,h3.w7{
            color: rgb(230, 155, 58);
        }
        div.jqcloud span.w7 {
            font-size: 3.1em;
        }
        div.jqcloud span.w6 ,h3.w6{
            color: rgb(139, 182, 93);
        }
        div.jqcloud span.w6 {
            font-size: 2.8em;
        }
        div.jqcloud span.w5 ,h3.w5{
            color: rgb(240, 196, 28);
        }
        div.jqcloud span.w5 {
            font-size: 2.5em;
        }
        div.jqcloud span.w4 ,h3.w4{
            color: rgb(239, 125, 94);
        }
        div.jqcloud span.w4 {
             font-size: 2.2em;
         }
        div.jqcloud span.w3 ,h3.w3{
            color: rgb(46, 104, 111);
        }
        div.jqcloud span.w3 {
             font-size: 1.9em;
         }
        div.jqcloud span.w2 ,h3.w2{
            color: rgb(129, 110, 75);
        }
        div.jqcloud span.w2 {
            font-size: 1.6em;
        }
        div.jqcloud span.w1 ,h3.w1{
            color: rgb(140, 171, 161);
        }
        div.jqcloud span.w1 {
            font-size: 1.3em;
        }
        .tu{
            padding-top: 5%;
            padding-bottom: 2%;
        }
    </style>
</head>

<body>

<div class="container-fluid" style="height: 100%">
<div class="row" >
    <div class="left col-lg-4 box" align="center">
        <div class="zz"></div>
        <p class="label-title">身份标签</p>
        <div id="cloud" style="width: 400px;height: 650px"  align="center"></div>
    </div>
    <div class="mid col-lg-4 box" align="center">
        <div class="zz"></div>
        <p class="label-title">健康标签</p>
        <div id="cloud_health" style="width: 400px;height: 650px"></div>
        <script>
            var array = [
                {text: "免疫接种", weight: 13},
                {text: "糖尿病高危人群", weight: 10.5},
                {text: "慢性肾病高危人群", weight: 9.4},
                {text: "脑卒中", weight: 9.4},
                {text: "高血压", weight: 8.4},
                {text: "恶性肿瘤", weight: 7.4},
                {text: "残疾人", weight: 7.6},
                {text: "重度残疾", weight: 6.4},
                {text: "语言残疾", weight: 6.4},
                {text: "多重残疾", weight: 5.4},
                {text: "视力残疾", weight: 5.4},
                {text: "智力残疾", weight: 4.4},
                {text: "听力残疾", weight: 4.4}
            ];
            $("#cloud_health").jQCloud(array);
        </script>
    </div>
    <div class="right col-lg-4 box" align="center">
        <div class="zz"></div>
        <p class="label-title">服务标签</p>
        <div id="cloud_service" style="width: 400px;height: 650px"></div>
        <script>
            var array = [
                {text: "参与社区服务", weight: 13},
                {text: "重点优抚对象社会化服务", weight: 10.5},
                {text: "失业丧劳特困人员医疗补助", weight: 9.4},
                {text: "生活困难人员临时生活补助", weight: 9.4},
                {text: "重点优抚对象优抚金", weight: 8.4},
                {text: "医疗救助金", weight: 7.4},
                {text: "残疾人交通补助", weight: 7.6},
                {text: "残疾人生活困难补助", weight: 6.4},
                {text: "残疾人护理补助", weight: 5.4},
                {text: "残疾人居家养老服务", weight: 4.4},
                {text: "低保人员居民医疗保险减免", weight: 3.4}
            ];
            $("#cloud_service").jQCloud(array);
        </script>
    </div>
</div>
<div class="row" style="margin-top: 10px!important;">
    <div class="col-lg-8">
        <div class="row">
            <div class="col-lg-2">
                <div class="col-lg-6 box la" align="center" style="width: 100%">
                    <div class="zz"></div>
                    <p class="label-title">所选标签</p>

                </div>
            </div>
            <div class="col-lg-10">
                <div class="col-lg-4 box" align="center">
                    <div class="zz"></div>
                    <div id="pqBar" class="tu"></div>
                </div>
                <div class="col-lg-4 box" align="center" style="position: relative;left: 5px">
                    <div class="zz"></div>
                    <div id="ageBar" class="tu"></div>
                </div>
                <div class="col-lg-4 box" align="center" style="position: relative;left: 10px">
                    <div class="zz"></div>
                    <div id="sexPie" class="tu"></div>
                </div>
            </div>
        </div>
    </div>
    <div class="col-lg-4">
        <div class="wrapper wrapper-content animated fadeInRight">
            <div class="row box" align="center">
                <div class="zz"></div
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
    <script>
        var label=[];//标签页面 存储所选标签
        var array = [
            {text: "老干部", weight: 13},
            {text: "楼组长", weight: 10},
            {text: "党员", weight: 9.4},
            {text: "支外回沪定居人员", weight: 8.4},
            {text: "军属", weight: 7.4},
            {text: "烈士家庭", weight: 6.4},
            {text: "病故军人遗属", weight: 6.6},
            {text: "伤残公务员", weight: 5},
            {text: "廉租住房家庭", weight: 4}
        ];
        $("#cloud").jQCloud(array);
    </script>
<script type="text/javascript">

    $(".tu").css('width',winWidth/8);
    $(".tu").css( 'height', winHeight*0.3);
    $(".jqcloud").css('width','100%');
    $(".jqcloud").css( 'height', winHeight*0.51);
    $(".jqcloud").css('bottom',winHeight/13);
    $(".jqcloud").css('left',winWidth/22);
    $(".la").css( 'height', winHeight*0.3);

    var ageBar = echarts.init(document.getElementById('ageBar'));
    var sexPie= echarts.init(document.getElementById('sexPie'));
    var pqBar= echarts.init(document.getElementById('pqBar'));

</script>
</div>
<#include "set.ftl" />

<script type="text/javascript">
    function downloadJSAtOnload() {
        var element = document.createElement("script");
        element.src = "/static/js/visual/yanchi.js";
        document.body.appendChild(element);
    }
    if (window.addEventListener) window.addEventListener("load", downloadJSAtOnload, false);
    else if (window.attachEvent) window.attachEvent("onload", downloadJSAtOnload);
    else window.onload = downloadJSAtOnload;
</script>
</body>


<script type="text/javascript">
    //    年龄分布柱状图
    title_text='年龄分布柱状';
    legend_data=[
        {
            name:'男',
            textStyle:{
                color:'#fff'
            }
        },
        {
            name:'女',
            textStyle:{
                color:'#fff'
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
                    position: 'insideLeft'
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
                    position: 'insideRight'
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
    //性别饼图
    title_text="性别分布饼图";
    legend_data=[{name:'男',textStyle:{color:legend_color}},{name:'女',textStyle:{color:legend_color}}];
    series=[{
        name: '老人性别',
        type: 'pie',
        radius : '45%',
        center: ['50%', '60%'],
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
    ageBar.setOption(option_age_bar);
    sexPie.setOption(option_sex_pie);
    pqBar.setOption(option_pq_bar);
</script>

</html>