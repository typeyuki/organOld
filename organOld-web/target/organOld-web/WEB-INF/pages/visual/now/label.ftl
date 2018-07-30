<style>
    @media only screen and (min-width: 6000px){
        #label .title{
            text-align: center;
            font-size: 35px;
            font-weight: bold;
        }
        #label .secTitle{
            text-align: center;
            font-size: 15px;
            font-weight: bold;
            margin-top: 8px;
        }
        #label .qk_1{
            font-size: 30px;
            padding:10px 30px;
            color: white;
            border: none;
            border-radius: 10px;
            margin: 10px;
            width: 100%;
        }
        #label .label{
            font-size: 30px;
            padding:10px!important;
            margin: 5px!important;
            line-height: 2!important;
        }
    }
        .label_tu{
            padding-top: 5%;
            padding-bottom: 2%;
        }
        h2,p,td,h3,h1,span{
            color: white!important;
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
            position: fixed;
            bottom: 5%;
            left:3%
         }

        .bl{
            display: inline-block;
            line-height: 1!important;
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
            margin-top: 20%;
            padding: 50px;
        }
    </style>
<div class="row">
    <div class="col-lg-1" style="width: 5%"></div>
    <div class="col-lg-5" id="label1" >
        <div class="row box">
            <div class="zz"></div>
            <div class="row" style="border-bottom: 1px solid white;margin: 0!important;">
                <div class="col-lg-5">
                    <p class="title" style="margin-top: 15%;" onclick="showHeatMap()">老 人 身 份</p>
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
                    <p class="title" style="margin-top: 20%;" onclick="picChange(1)">老 有 所 养</p>
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
                    <p class="title" style="margin-top: 50%;" onclick="picChange(2)">老 有 所 医</p>
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
                    <p class="title" style="margin-top: 5%;" onclick="picChange(3)">老 有 所 为</p>
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
                    <p class="title" style="margin-top: 5%;" onclick="picChange(4)">老 有 所 学</p>
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
                    <p class="title" style="margin-top: 5%;" onclick="picChange(5)">老 有 所 乐</p>
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
    <div class="col-lg-5 box" id="label3" >
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
    <div class="col-lg-1" style="width: 5%"></div>
    <div class="col-lg-5">
        <div class="row">
            <div class="col-lg-12 box" align="center">
                <div class="zz"></div>
                <div id="label_ageBar" class="label_tu"></div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12 box" align="center">
                <div class="zz"></div>
                <div id="label_sexPie" class="label_tu"></div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12 box" align="center">
                <div class="zz"></div>
                <div id="label_hjPie" class="label_tu"></div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12 box" align="center">
                <div class="zz"></div>
                <div id="label_pqBar" class="label_tu"></div>
            </div>
        </div>
        <script type="text/javascript">
            var label_tu_w,label_tu_h;
            var label_width=$("#label").width();
            if(winWidth>=1900){
                label_tu_w=label_width/3;
                label_tu_h=winHeight/5.5;
            }else if(winWidth<=1400 && winWidth>=1300){
                label_tu_w=winWidth/3;
                label_tu_h=winHeight/5.5;
            }
            $(".label_tu").css('width',label_tu_w);
            $(".label_tu").css( 'height', label_tu_h);
            var label_ageBar = echarts.init(document.getElementById('label_ageBar'));
            var label_sexPie= echarts.init(document.getElementById('label_sexPie'));
            var label_pqBar= echarts.init(document.getElementById('label_pqBar'));
            var label_hjPie= echarts.init(document.getElementById('label_hjPie'));
        </script>
    </div>
</div>

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
    var label_option_age_bar=chartBar(title_text,legend_data,yAxis_data,series);
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
    var label_option_sex_pie = chartPie(title_text,legend_data,series);
    //片区人数分布
    // legend_data="";
    // title_text='片区人口分布柱状';
    // yAxis_data=['东兰','古龙','平南','平阳','平吉','古美'];
    // series=[
    //     {
    //         name: '',
    //         type: 'bar',
    //         stack: '总量',
    //         label: {
    //             normal: {
    //                 show: true,
    //                 position: 'right',
    //                 textStyle:{
    //                     fontSize:20
    //                 }
    //             }
    //         },
    //         itemStyle:{
    //             normal: {
    //                 color:series_color_1
    //             }
    //         },
    //         data: [67,134,234,534,263,231]
    //     }
    // ];
    // var label_option_pq_bar=chartBar(title_text,legend_data,yAxis_data,series);
    //aa
    var posList = [
        'left', 'right', 'top', 'bottom',
        'inside',
        'insideTop', 'insideLeft', 'insideRight', 'insideBottom',
        'insideTopLeft', 'insideTopRight', 'insideBottomLeft', 'insideBottomRight'
    ];

    label_pqBar.configParameters = {
        rotate: {
            min: -90,
            max: 90
        },
        align: {
            options: {
                left: 'left',
                center: 'center',
                right: 'right'
            }
        },
        verticalAlign: {
            options: {
                top: 'top',
                middle: 'middle',
                bottom: 'bottom'
            }
        },
        position: {
            options: echarts.util.reduce(posList, function (map, pos) {
                map[pos] = pos;
                return map;
            }, {})
        },
        distance: {
            min: 0,
            max: 100
        }
    };

    label_pqBar.config = {
        rotate: 90,
        align: 'left',
        verticalAlign: 'middle',
        position: 'insideBottom',
        distance: 15,
        onChange: function () {
            var labelOption = {
                normal: {
                    rotate: label_pqBar.config.rotate,
                    align: label_pqBar.config.align,
                    verticalAlign: label_pqBar.config.verticalAlign,
                    position: label_pqBar.config.position,
                    distance: label_pqBar.config.distance
                }
            };
            label_pqBar.setOption({
                series: [{
                    label: labelOption
                }, {
                    label: labelOption
                }, {
                    label: labelOption
                }, {
                    label: labelOption
                }]
            });
        }
    };


    var labelOption = {
        normal: {
            show: true,
            position: label_pqBar.config.position,
            distance: label_pqBar.config.distance,
            align: label_pqBar.config.align,
            verticalAlign: label_pqBar.config.verticalAlign,
            rotate: label_pqBar.config.rotate,
            formatter: '{c}',
            fontSize: 16,
            rich: {
                name: {
                    textBorderColor: '#fff'
                }
            }
        }
    };

    option = {
        //color: ['#003366', '#006699', '#4cabce', '#e5323e'],
        title: {
            text:'片区人口分布柱状',
            textStyle:{
                color:'#fff',
                fontSize:title_fontSize,
                fontWeight:100
            },
            x:'0%',
            y:'0%',
        },
        color: ['#ffd289'],
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'shadow'
            }
        },
        legend: {
            data: ['']
        },
        toolbox: {
            show: true,
            orient: 'vertical',
            left: 'right',
            top: 'center',
            feature: {
                mark: {show: true},
                dataView: {show: true, readOnly: false},
                magicType: {show: true, type: ['line', 'bar', 'stack', 'tiled']},
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
        calculable: true,
        xAxis: [
            {
                type: 'category',
                axisTick: {show: false},
                data: ['东兰','古龙','平南','平阳','平吉','古美'],
                axisLine:{
                    lineStyle:{
                        color:'white',
                        fontSize: 20
                    }
                },
            }
        ],
        yAxis: [
            {
                type: 'value',
                axisLine:{
                    lineStyle:{
                        color:'white',
                        fontSize: 20
                    }
                },
            }
        ],
        series: [
            {
                type: 'bar',
                barGap: 0,
                label: labelOption,
                data: [320, 332, 301, 334, 390,440],
                barWidth: 20,//柱图宽度
                itemStyle: {
                    normal: {
                        barBorderRadius: 20,
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: '#99d9ea'
                        }, {
                            offset: 1,
                            color: 'rgba(0,188,226, 0.5)'
                        }]),
                        shadowColor: 'rgba(0, 0, 0, 0.4)',
                        shadowBlur: 20,
                    }
                }

            },

        ]
    };
    //pqBar.setOption(option);
    label_pqBar.setOption(option);


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
    var label_option_hj_pie = chartPie(title_text,legend_data,series);
    label_ageBar.setOption(label_option_age_bar);
    label_sexPie.setOption(label_option_sex_pie);

    label_hjPie.setOption(label_option_hj_pie)
</script>

 <script>



     function picChange(index){
         for(var i=0;i<markerArr.length;i++){
             var json = markerArr[i];
             var p0 = json.point.split("|")[0];
             var p1 = json.point.split("|")[1];
             var point = new BMap.Point(p0,p1);
             var iconImg = createIcon(json.icon);
             var marker = new BMap.Marker(point,{icon:iconImg});
             var iw = createInfoWindow(i);
             var label = new BMap.Label(json.title,{"offset":new BMap.Size(json.icon.lb-json.icon.x+10,-20)});
             marker.setLabel(label);
             map.addOverlay(marker);
             label.setStyle({
                 borderColor:"#808080",
                 color:"#333",
                 cursor:"pointer",
                 maxWidth:"none"
             });

             (function(){
                 var index = i;
                 var _iw = createInfoWindow(i);
                 var _marker = marker;
                 _marker.addEventListener("click",function(){
                     this.openInfoWindow(_iw);
                 });
                 _iw.addEventListener("open",function(){
                     _marker.getLabel().hide();
                 })
                 _iw.addEventListener("close",function(){
                     _marker.getLabel().show();
                 })
                 label.addEventListener("click",function(){
                     _marker.openInfoWindow(_iw);
                 })
                 if(!!json.isOpen){
                     label.hide();
                     _marker.openInfoWindow(_iw);
                 }
             })()
         }
         var allOverlay = map.getOverlays();
         var len = map.getOverlays().length;
         var str = null;
         if(index == 1) str="养老院";//老有所养
         else if(index == 2) str="社区卫生站";//所医
         else if(index == 3) str="助餐点";//所为
         else if(index == 4) str="老年人学校";//所学
         else if(index == 5) str="社区卫生站";//所乐
         for (var i = len; i >0; i--){
             if (allOverlay[i] instanceof BMap.Marker)
                 if(allOverlay[i].getLabel().content.indexOf(str) == -1)
                 {
                     map.removeOverlay(map.getOverlays()[i]);

                 }

         }

     }

     function showHeatMap(){
         document.getElementById("dituContent").style.display="none";
         document.getElementById("container").style.display="";
     }

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
