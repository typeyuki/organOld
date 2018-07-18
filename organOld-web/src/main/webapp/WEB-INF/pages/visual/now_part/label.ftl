 <!DOCTYPE html>
<html>
<head>
<#include "../head.ftl" />
    <style>
        @media only screen and (min-width: 1700px){
            .map_title{
                font-size: 28px;
                color: white;
            }

            .title{
                text-align: center;
                font-size: 20px;
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
                font-size: 18px;
                background-color:#6cbdfc ;
                padding:2px 8px;
                color: white;
                border: none;
                border-radius: 10px;
                margin-bottom: 10px;
                position: fixed;
                bottom: 5%;
                left:3%
            }
            .qk_1{
                font-size: 18px;
                padding:2px 8px;
                color: white;
                border: none;
                border-radius: 10px;
                margin: 10px;
                width: 100%;
            }
            .bl{
                display: inline-block;
                line-height: 1!important;
            }
        }

        @media only screen and (min-width: 1300px) and ( max-width: 1400px){
            .map_title{
                font-size: 28px;
                color: white;
            }

            .title{
                text-align: center;
                font-size: 12px;
                font-weight: bold;
            }
            .secTitle{
                text-align: center;
                font-size: 20px;
                font-weight: bold;
                margin-top: 10px;
            }
            .label{
                font-size: 10px;
                padding:8px!important;
                margin: 3px!important;
                line-height: 3!important;
            }
            .select{
                opacity: 0.5;
            }
            .qk{
                font-size: 11px;
                background-color:#6cbdfc ;
                padding:3px 8px;
                color: white;
                border: none;
                border-radius: 10px;
                margin-bottom: 10px;
                position: fixed;
                bottom: 5%;
                left:3%
            }
            .qk_1{
                font-size: 10px;
                padding:3px 10px;
                color: white;
                border: none;
                border-radius: 10px;
                margin: 5px;
                width: 100%;
            }
            .bl{
                display: inline-block;
                line-height: 1!important;
            }
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
        #label3{
            display: none;
            margin-top: 10%;
        }
    </style>
</head>

<body>



<div class="container-fluid">
    <div class="row" style="position: relative;left: 2%">
        <div class="col-lg-2" id="label1">
            <div class="row">
                <div class="col-lg-10">
                    <div class="row box">
                        <div class="zz"></div>
                        <div class="row" style="border-bottom: 1px solid white;margin: 0!important;">
                            <div class="col-lg-5">
                                <p class="title" style="margin-top: 15%;">老 人 身 份</p>
                            </div>
                            <div class="col-lg-7" >
                                <div class="row">
                                    <div class="col-lg-12">
                                        <button class="qk_1 color_1" onclick="label3Show(1)">基  本  情  况</button>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-12">
                                        <button class="qk_1 color_1" onclick="label3Show(2)">家  庭  结  构</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row" style="border-bottom: 1px solid white;margin: 0!important;">
                            <div class="col-lg-5">
                                <p class="title" style="margin-top: 20%;">老 有 所 养</p>
                            </div>
                            <div class="col-lg-7">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <button class="qk_1 color_2" onclick="label3Show(3)">机 构 养 老</button>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-12">
                                        <button class="qk_1 color_2" onclick="label3Show(4)">社  区 养 老</button>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-12">
                                        <button class="qk_1 color_2" onclick="label3Show(5)">经 济 条 件</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row" style="border-bottom: 1px solid white;margin: 0!important;">
                            <div class="col-lg-5">
                                <p class="title" style="margin-top: 50%;" >老 有 所 医</p>
                            </div>
                            <div class="col-lg-7">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <button class="qk_1 color_4" onclick="label3Show(6)">慢 病</button>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-12">
                                        <button class="qk_1 color_4" onclick="label3Show(7)">长 护 险</button>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-lg-12">
                                        <button class="qk_1 color_4" onclick="label3Show(8)">失 能 情 况</button>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-12">
                                        <button class="qk_1 color_4" onclick="label3Show(9)">智 力</button>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-12">
                                        <button class="qk_1 color_4" onclick="label3Show(10)">视 力</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row" style="border-bottom: 1px solid white;margin: 0!important;">
                            <div class="col-lg-5">
                                <p class="title" style="margin-top: 5%;">老 有 所 为</p>
                            </div>
                            <div class="col-lg-7">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <button class="qk_1 color_5" onclick="label3Show(11)">志 愿 者</button>
                                    </div>
                                </div>

                            </div>
                        </div>
                        <div class="row" style="border-bottom: 1px solid white;margin: 0!important;">
                            <div class="col-lg-5">
                                <p class="title" style="margin-top: 5%;">老 有 所 学</p>
                            </div>
                            <div class="col-lg-7">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <button class="qk_1 color_6" onclick="label3Show(12)">学 校</button>
                                    </div>
                                </div>

                            </div>
                        </div>
                        <div class="row" style="margin: 0!important;">
                            <div class="col-lg-5">
                                <p class="title" style="margin-top: 5%;">老 有 所 乐</p>
                            </div>
                            <div class="col-lg-7">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <button class="qk_1 color_7" onclick="label3Show(13)">俱 乐 部</button>
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
                                    <button class="qk" onclick="butt()">清空</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-2" id="label3"  >
            <div class="row">
                <div class="col-lg-10 box">
                    <div class="zz"></div>
                    <div id="label31" class="aa" style="display: none">
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
                    <div id="label32" class="aa" style="display: none">
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
                    <div id="label33" class="aa" style="display: none">
                        <span class="label color_2">东兰养老院</span>
                        <span class="label color_2">古美养老院</span>
                        <span class="label color_2">平阳养老院</span>
                    </div>
                    <div id="label34" class="aa" style="display: none">
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
                    <div id="label35" class="aa" style="display: none">
                        <span class="label color_2">帮困人员</span>
                        <span class="label color_2">低保</span>
                        <span class="label color_2">城乡居民养老保险</span>
                        <span class="label color_2">医疗救助金</span>
                        <span class="label color_2">城镇居民基本医疗保险</span>
                    </div>
                    <div id="label36" class="aa" style="display: none">
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
                    <div id="label37" class="aa" style="display: none">
                        <span class="label color_4">2-3级</span>
                        <span class="label color_4">4级</span>
                        <span class="label color_4">5级</span>
                        <span class="label color_4">6级</span>
                        <span class="label color_4">7级</span>
                    </div>
                    <div id="label38" class="aa" style="display: none">
                        <span class="label color_4">上厕所</span>
                        <span class="label color_4">洗澡</span>
                        <span class="label color_4">穿衣</span>
                        <span class="label color_4">上下床</span>
                        <span class="label color_4">室内行走</span>
                        <span class="label color_4">吃饭</span>
                    </div>
                    <div id="label39" class="aa" style="display: none">
                        <span class="label color_4">痴呆</span>
                        <span class="label color_4">智障</span>
                        <span class="label color_4">正常</span>
                    </div>
                    <div id="label310" class="aa" style="display: none">
                        <span class="label color_4">失明</span>
                        <span class="label color_4">有光感</span>
                        <span class="label color_4">有障碍</span>
                        <span class="label color_4">正常</span>
                    </div>
                    <div id="label311" class="aa" style="display: none">
                        <span class="label color_5">志愿者</span>
                    </div>
                    <div id="label312" class="aa" style="display: none">
                        <span class="label color_6">老年大学</span>
                        <span class="label color_6">老年培训中心</span>
                    </div>
                    <div id="label313" class="aa" style="display: none">
                        <span class="label color_7">老年俱乐部</span>
                        <span class="label color_7">老年艺术中心</span>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-2">
            <div class="row">
                <div class="col-lg-12 box" align="center">
                    <div class="zz"></div>
                    <div id="ageBar" class="tu"></div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12 box" align="center" >
                    <div class="zz"></div>
                    <div id="sexPie" class="tu"></div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12 box" align="center">
                    <div class="zz"></div>
                    <div id="hjPie" class="tu"></div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12 box" align="center">
                    <div class="zz"></div>
                    <div id="pqBar" class="tu"></div>
                </div>
            </div>
        </div>
        <div class="col-lg-7" style="position: relative;left: 5px">
            <div class="row" align="center">
                <div class="col-lg-12">
                    <#include "map.ftl"/>
                </div>
            </div>

            <div class="row">
            <#include "table.ftl"/>
            </div>
        </div>
    </div>
    <script type="text/javascript">
        var tu_w,tu_h;
        if(winWidth>=1700){
            //家里电脑的分辨率
            tu_w=winWidth/8.2;
            tu_h=winHeight/4.2;
        }else if(winWidth<=1400 && winWidth>=1300){
            tu_w=winWidth/8.2;
            tu_h=winHeight/4.2;
        }
        $(".tu").css('width',tu_w);
        $(".tu").css( 'height', tu_h);

        var ageBar = echarts.init(document.getElementById('ageBar'));
        var sexPie= echarts.init(document.getElementById('sexPie'));
        var pqBar= echarts.init(document.getElementById('pqBar'));
        var hjPie= echarts.init(document.getElementById('hjPie'));
    </script>
</div>

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
     iDisplayLength=4;

     function label3Show(index) {
         $("#label1").hide();
         $(".aa").css("display","none");
         $("#label3").show();
         $("#label3"+index).show();
     }

     function butt() {
         $('.select').each(function() {
             var cl=$(this).attr('class').split(' ')[1];
             $(this).attr('class','label '+cl);
         });$('#selectLabel').html('');ageBar = echarts.init(document.getElementById('ageBar'));
         sexPie= echarts.init(document.getElementById('sexPie'));
         pqBar= echarts.init(document.getElementById('pqBar'));
         hjPie= echarts.init(document.getElementById('hjPie'));
         ageBar.setOption(option_age_bar);
         sexPie.setOption(option_sex_pie);
         pqBar.setOption(option_pq_bar);
         hjPie.setOption(option_hj_pie);
     }

     var la=[];
     $("span.label").click(
         function () {
             if($(this).attr("class").indexOf("select")>0){
                 var cl=$(this).attr("class").split(" ")[1];
                 $(this).attr("class","label "+cl);
                 var laa=$(this).text().trim();
                 $("#selectLabel span").each(function () {
                    if($(this).text().trim()==laa){
                        $("#label3").hide();
                        $("#label1").show();

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
                 $("#label3").hide();
                 $("#label1").show();

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