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
        .tu,.tu_big{
            padding-top: 5%;
            padding-bottom: 2%;
        }
        .map_title{
            font-size: 28px;
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
            font-size: 25px;
            font-weight: bold;
        }
        .secTitle{
            text-align: center;
            font-size: 20px;
            font-weight: bold;
            margin-top: 10px;
        }
        .label{
            font-size: 18px;
            padding:10px!important;
            margin: 5px!important;
            line-height: 3!important;
        }
        .select{
            opacity: 0.5;
        }
        .qk{
            font-size: 24px;
            background-color:#6cbdfc ;
            padding:10px 30px;
            color: white;
            border: none;
            border-radius: 10px;
            margin-bottom: 10px;
        }
        .bl{
            display: inline-block;
            line-height: 2!important;
        }
        .color_1{
            background-color:#6cbdfc!important;;
        }
        .color_2{
            background-color:#dc88a9!important;;
        }
        .color_4{
            background-color:#48e8dc!important;;
        }
        .color_5{
            background-color:yellowgreen!important;;
        }
        .color_6{
            background-color:orange!important;;
        }
        .color_7{
            background-color:rgb(139, 182, 93)!important;;
        }
    </style>
</head>

<body>


<div class="container-fluid">
    <div class="row">
        <div class="col-lg-5">
            <div class="row box">
                <div class="zz"></div>
                <div class="row" style="border-bottom: 1px solid white;margin: 0!important;">
                    <div class="col-lg-2">
                        <p class="title" style="margin-top: 50%;">身份标签</p>
                    </div>
                    <div class="col-lg-10" >
                        <div class="row">
                            <div class="col-lg-2">
                                <p class="secTitle">基本情况</p>
                            </div>
                            <div class="col-lg-10">
                                <span class="label color_1">男</span>
                                <span class="label color_1">女</span>
                                <span class="label color_1">60-70岁</span>
                                <span class="label color_1">70-80岁</span>
                                <span class="label color_1">90岁以上</span>
                                <span class="label color_1">东兰</span>
                                <span class="label color_1">平阳</span>
                                <span class="label color_1">古美</span>
                                <span class="label color_1">平吉</span>
                                <span class="label color_1">平南</span>
                                <span class="label color_1">古龙</span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-2">
                                <p class="secTitle">家庭结构</p>
                            </div>
                            <div class="col-lg-10">
                                <span class="label color_1">户籍</span>
                                <span class="label color_1">非户籍</span>
                                <span class="label color_1">纯老</span>
                                <span class="label color_1">独居</span>
                                <span class="label color_1">孤老</span>
                                <span class="label color_1">一老养一老</span>
                                <span class="label color_1">失独家庭</span>
                                <span class="label color_1">三支人员</span>
                                <span class="label color_1">离休干部</span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row" style="border-bottom: 1px solid white;margin: 0!important;">
                    <div class="col-lg-2">
                        <p class="title" style="margin-top: 50%;">老有所养</p>
                    </div>
                    <div class="col-lg-10">
                        <div class="row">
                            <div class="col-lg-2">
                                <p class="secTitle">机构养老</p>
                            </div>
                            <div class="col-lg-10">
                                <span class="label color_2">东兰养老院</span>
                                <span class="label color_2">古美养老院</span>
                                <span class="label color_2">平阳养老院</span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-2">
                                <p class="secTitle">社区养老</p>
                            </div>
                            <div class="col-lg-10">
                                <span class="label color_2">东兰长者照护之家</span>
                                <span class="label color_2">古美长者照护之家</span>
                                <span class="label color_2">平阳长者照护之家</span>
                                <span class="label color_2">东兰日照中心</span>
                                <span class="label color_2">古美日照中心</span>
                                <span class="label color_2">平阳日照中心</span>
                                <span class="label color_2">东兰助餐点</span>
                                <span class="label color_2">古美助餐点</span>
                                <span class="label color_2">平阳助餐点</span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-2">
                                <p class="secTitle">经济条件</p>
                            </div>
                            <div class="col-lg-10">
                                <span class="label color_2">帮困人员</span>
                                <span class="label color_2">低保</span>
                                <span class="label color_2">城乡居民养老保险</span>
                                <span class="label color_2">医疗救助金</span>
                                <span class="label color_2">城镇居民基本医疗保险</span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row" style="border-bottom: 1px solid white;margin: 0!important;">
                    <div class="col-lg-2">
                        <p class="title" style="margin-top: 100%;">老有所医</p>
                    </div>
                    <div class="col-lg-10">
                        <div class="row">
                            <div class="col-lg-2">
                                <p class="secTitle">慢病</p>
                            </div>
                            <div class="col-lg-10">
                                <span class="label color_4">高血压</span>
                                <span class="label color_4">糖尿病</span>
                                <span class="label color_4">脑卒中</span>
                                <span class="label color_4">帕金森</span>
                                <span class="label color_4">癫痫</span>
                                <span class="label color_4">肺炎</span>
                                <span class="label color_4">慢阻肺</span>
                                <span class="label color_4">冠心病</span>
                                <span class="label color_4">慢性肾功能障碍</span>
                                <span class="label color_4">甲亢/甲减</span>
                                <span class="label color_4">肝炎/肝硬化</span>
                                <span class="label color_4">恶性肿瘤</span>
                                <span class="label color_4">骨折</span>
                                <span class="label color_4">其他消化道疾病</span>
                                <span class="label color_4">类风关</span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-2">
                                <p class="secTitle">长护险</p>
                            </div>
                            <div class="col-lg-10">
                                <span class="label color_4">2-3级</span>
                                <span class="label color_4">4级</span>
                                <span class="label color_4">5级</span>
                                <span class="label color_4">6级</span>
                                <span class="label color_4">7级</span>
                            
                            </div>
                        </div>
                    
                        <div class="row">
                            <div class="col-lg-2">
                                <p class="secTitle">失能情况</p>
                            </div>
                            <div class="col-lg-10">
                                <span class="label color_4">上厕所</span>
                                <span class="label color_4">洗澡</span>
                                <span class="label color_4">穿衣</span>
                                <span class="label color_4">上下床</span>
                                <span class="label color_4">室内行走</span>
                                <span class="label color_4">吃饭</span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-2">
                                <p class="secTitle">智力</p>
                            </div>
                            <div class="col-lg-10">
                                <span class="label color_4">痴呆</span>
                                <span class="label color_4">智障</span>
                                <span class="label color_4">正常</span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-2">
                                <p class="secTitle">视力</p>
                            </div>
                            <div class="col-lg-10">
                                <span class="label color_4">失明</span>
                                <span class="label color_4">有光感</span>
                                <span class="label color_4">有障碍</span>
                                <span class="label color_4">正常</span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row" style="border-bottom: 1px solid white;margin: 0!important;">
                    <div class="col-lg-2">
                        <p class="title" style="margin-top: 10%;">老有所为</p>
                    </div>
                    <div class="col-lg-10">
                        <div class="row">
                            <div class="col-lg-2">
                                <p class="secTitle">志愿者</p>
                            </div>
                            <div class="col-lg-10">
                                <span class="label color_5">志愿者</span>
                            </div>
                        </div>

                    </div>
                </div>
                <div class="row" style="border-bottom: 1px solid white;margin: 0!important;">
                    <div class="col-lg-2">
                        <p class="title" style="margin-top: 10%;">老有所学</p>
                    </div>
                    <div class="col-lg-10">
                        <div class="row">
                            <div class="col-lg-2">
                                <p class="secTitle">学校</p>
                            </div>
                            <div class="col-lg-10">
                                <span class="label color_6">老年大学</span>
                        <span class="label color_6">老年培训中心</span>
                            </div>
                        </div>

                    </div>
                </div>
                <div class="row" style="margin: 0!important;">
                    <div class="col-lg-2">
                        <p class="title" style="margin-top: 10%;">老有所乐</p>
                    </div>
                    <div class="col-lg-10">
                        <div class="row">
                            <div class="col-lg-2">
                                <p class="secTitle">俱乐部</p>
                            </div>
                            <div class="col-lg-10">
                               <span class="label color_7">老年俱乐部</span>
                                <span class="label color_7">老年艺术中心</span>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
           <div class="row box" style="margin-top: 5px">
               <div class="zz"></div>
               <div class="col-lg-12">
                   <div class="row">
                       <div class="col-lg-12">
                           <p class="title">所选标签</p>
                       </div>
                   </div>
                   <div class="row">
                       <div class="col-lg-12">
                           <div id="selectLabel"></div>
                       </div>
                   </div>
                   <div class="row" align="center">
                       <div class="col-lg-12">
                           <button class="qk" onclick="$('.select').each(function() {
                             var cl=$(this).attr('class').split(' ')[1];
                             $(this).attr('class','label '+cl);
                           });$('#selectLabel').html('');ageBar = echarts.init(document.getElementById('ageBar'));
                        sexPie= echarts.init(document.getElementById('sexPie'));
                        pqBar= echarts.init(document.getElementById('pqBar'));
                        hjPie= echarts.init(document.getElementById('hjPie'));
                        ageBar.setOption(option_age_bar);
                        sexPie.setOption(option_sex_pie);
                        pqBar.setOption(option_pq_bar);
                        hjPie.setOption(option_hj_pie);">清空</button>
                       </div>
                   </div>
                </div>
           </div>
        </div>
        <div class="col-lg-7" style="position: relative;left: 5px">
            <div class="row">
                <div class="col-lg-6 box" align="center">
                    <div class="zz"></div>
                    <div id="ageBar" class="tu"></div>
                </div>
                <div class="col-lg-6 box" align="center" style="position: relative;left: 5px;margin-bottom: 5px">
                    <div class="zz"></div>
                    <div id="sexPie" class="tu"></div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6 box">
                    <div class="zz"></div>
                    <div id="hjPie" class="tu"></div>
                </div>
                <div class="col-lg-6 box" align="center" style="position: relative;left: 5px;margin-bottom: 5px">
                    <div class="zz"></div>
                    <div id="pqBar" class="tu"></div>
                </div>
            </div>
            <div class="row">
                <div class="wrapper wrapper-content animated fadeInRight box" style="position: relative;left: 2.5px">
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
                                        <tr>
                                            <td>张*三</td>
                                            <td>男</td>
                                            <td>70</td>
                                            <td>15254****2547</td>
                                            <td>东兰</td>
                                            <td>东兰一村</td>
                                            <td>89号48弄</td>
                                        </tr>
                                        <tr>
                                            <td>张*三</td>
                                            <td>男</td>
                                            <td>70</td>
                                            <td>15254****2547</td>
                                            <td>东兰</td>
                                            <td>东兰一村</td>
                                            <td>89号48弄</td>
                                        </tr>
                                         <tr>
                                            <td>张*三</td>
                                            <td>男</td>
                                            <td>70</td>
                                            <td>15254****2547</td>
                                            <td>东兰</td>
                                            <td>东兰一村</td>
                                            <td>89号48弄</td>
                                        </tr>
                                         <tr>
                                            <td>张*三</td>
                                            <td>男</td>
                                            <td>70</td>
                                            <td>15254****2547</td>
                                            <td>东兰</td>
                                            <td>东兰一村</td>
                                            <td>89号48弄</td>
                                        </tr>
                                         <tr>
                                            <td>张*三</td>
                                            <td>男</td>
                                            <td>70</td>
                                            <td>15254****2547</td>
                                            <td>东兰</td>
                                            <td>东兰一村</td>
                                            <td>89号48弄</td>
                                        </tr>
                                         <tr>
                                            <td>张*三</td>
                                            <td>男</td>
                                            <td>70</td>
                                            <td>15254****2547</td>
                                            <td>东兰</td>
                                            <td>东兰一村</td>
                                            <td>89号48弄</td>
                                        </tr>
                                         <tr>
                                            <td>张*三</td>
                                            <td>男</td>
                                            <td>70</td>
                                            <td>15254****2547</td>
                                            <td>东兰</td>
                                            <td>东兰一村</td>
                                            <td>89号48弄</td>
                                        </tr>
                                         <tr>
                                            <td>张*三</td>
                                            <td>男</td>
                                            <td>70</td>
                                            <td>15254****2547</td>
                                            <td>东兰</td>
                                            <td>东兰一村</td>
                                            <td>89号48弄</td>
                                        </tr>
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
        $(".tu").css('width',winWidth/3.7);
        $(".tu").css( 'height', winHeight/3.2);
        var ageBar = echarts.init(document.getElementById('ageBar'));
        var sexPie= echarts.init(document.getElementById('sexPie'));
        var pqBar= echarts.init(document.getElementById('pqBar'));
        var hjPie= echarts.init(document.getElementById('hjPie'));
    </script>
</div>
<#include "../set.ftl" />
</body>
<script>
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
                    fontSize : 20
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
    var option_pq_bar=chartBar(title_text,legend_data,yAxis_data,series);
    title_text="户籍分布饼图";
    legend_data=[{name:'户籍',textStyle:{color:legend_color}},{name:'非户籍',textStyle:{color:legend_color}}];
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
    var option_hj_pie = chartPie(title_text,legend_data,series);
    ageBar.setOption(option_age_bar);
    sexPie.setOption(option_sex_pie);
    pqBar.setOption(option_pq_bar);
    hjPie.setOption(option_hj_pie)
</script>

 <script>
     var la=[];
     $("span.label").click(
         function () {
             if($(this).attr("class").indexOf("select")>0){
                 var cl=$(this).attr("class").split(" ")[1];
                 $(this).attr("class","label "+cl);
                 var laa=$(this).text().trim();
                 $("#selectLabel span").each(function () {
                    if($(this).text().trim()==laa){
                        $(this).remove();
                        ageBar = echarts.init(document.getElementById('ageBar'));
                        sexPie= echarts.init(document.getElementById('sexPie'));
                        pqBar= echarts.init(document.getElementById('pqBar'));
                        hjPie= echarts.init(document.getElementById('hjPie'));
                        ageBar.setOption(option_age_bar);
                        sexPie.setOption(option_sex_pie);
                        pqBar.setOption(option_pq_bar);
                        hjPie.setOption(option_hj_pie);
                        return;
                    }
                 });
             }else {

                 $(this).addClass("select");
                 var text = $(this).text();
                 var cl=$(this).attr("class").split(" ")[1];
                 $("#selectLabel").append($("<span class='bl label "+cl+"'>" + text + "</span>"));
                 la.push(text);
//             table.fnFilter();

                 ageBar = echarts.init(document.getElementById('ageBar'));
                 sexPie = echarts.init(document.getElementById('sexPie'));
                 pqBar = echarts.init(document.getElementById('pqBar'));
                 hjPie = echarts.init(document.getElementById('hjPie'));
                 ageBar.setOption(option_age_bar);
                 sexPie.setOption(option_sex_pie);
                 pqBar.setOption(option_pq_bar);
                 hjPie.setOption(option_hj_pie);
             }
         }
     );
 </script>
</html>