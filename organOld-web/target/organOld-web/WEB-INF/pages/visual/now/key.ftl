<style>
    @media only screen and (min-width: 6000px){
        .key_tu,.key_tu_big{
            padding-top: 5%;
            padding-bottom: 2%;
        }
    }
</style>
<div id="child_key" style="display: none">
    <div class="row" >
        <div class="col-lg-12 box">
            <div class="zz"></div>
            <div id="key_zdLine" class="key_tu_big"></div>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-4 box">
            <div class="zz"></div>
            <div id="key_hjPie" class="key_tu"></div>
        </div>
        <div class="col-lg-4 box">
            <div class="zz"></div>
            <div id="key_sexPie" class="key_tu"></div>
        </div>
        <div class="col-lg-4 box">
            <div class="zz"></div>
            <div id="key_ageBar" class="key_tu"></div>
        </div>
    </div>
</div>
<script type="text/javascript">
    var key_tu_w,key_tu_h,key_tu_big_w,key_tu_big_h;
    var key_width=$("#oldman").width();
    if(winWidth>=1900){
        key_tu_w=key_width/3.2;
        key_tu_h=winHeight/4.4;
        key_tu_big_w=key_width;
        key_tu_big_h=winHeight/4.4;
    }else if(winWidth<=1400 && winWidth>=1300){
        oldman_tu_w=winWidth/4.5;
        oldman_tu_h=winHeight/4.1;
    }

    $(".key_tu_big").css('width',key_tu_big_w);
    $(".key_tu_big").css( 'height', key_tu_big_h);
    $(".key_tu").css('width',key_tu_w);
    $(".key_tu").css( 'height', key_tu_h);

    var key_ageBar = echarts.init(document.getElementById('key_ageBar'));
    var key_sexPie= echarts.init(document.getElementById('key_sexPie'));
    var key_hjPie= echarts.init(document.getElementById('key_hjPie'));
    var key_zdLine = echarts.init(document.getElementById('key_zdLine'));
</script>
<script>

    //重点增长趋势图
    title_text='重点老人人数变化趋势图';
    legend_data=[];
    xAxis_data=['2月','3月','4月','今天','6月','7月','8月'];
    series=[
        {
            name: '帮困',
            type: 'line',
            itemStyle:{
                normal: {
                    lineStyle:{
                        width:1,
                        color:series_color_1
                    },
                    label : {
                        show: true
                    },
                    color:"yellow"
                }
            },
            label:{
                normal:{
                    textStyle:{
                        fontSize:20
                    }

                }

            },
            markLine: {
                itemStyle: {
                    normal: {lineStyle: {type: 'solid', color: 'orange'}, label: {show: true, position: 'left', textStyle:{color:'red',fontSize:20}}}
                },
                large: true,
                symbol:"diamond",
                symbolSize: 12,
                effect: {
                    show: false,
                    loop: true,
                    period: 0,
                    scaleSize: 2,
                    color: null,
                    shadowColor: null,
                    shadowBlur: null
                },
                data: [
                    [
                        {
                            coord: [3, 0]
                        },
                        {
                            coord: [3, 55]
                        }
                    ]
                ]
            },
            symbolSize: 8,
            data: [40,45,50,{

                value : 55,

                symbol: 'circle', // 数据级个性化拐点图形

                symbolSize : 20,

                hoverAnimation :true,
                label:{
                    normal : {
                        show:true,
                        textStyle : {
                            fontWeight : 'normal',
                            fontSize : 40
                        }
                    }
                },
                itemStyle:{

                    normal:{
                        color:'white',
                        fontSize : 20
                    }}},55,55,55]
        }
    ];
    var key_option_zd_line = chartLine(title_text,legend_data,xAxis_data,series);

    title_text="户籍分布饼图";
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
    var key_option_area_pie = chartPie(title_text,legend_data,series);

    //性别饼图
    title_text="性别分布饼图";
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
    var key_option_sex_pie = chartPie(title_text,legend_data,series);


    //    年龄分布柱状图
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
    var key_option_age_bar=chartBar(title_text,legend_data,yAxis_data,series);


    key_zdLine.setOption(key_option_zd_line);
    key_hjPie.setOption(key_option_area_pie);
    key_sexPie.setOption(key_option_sex_pie);
    key_ageBar.setOption(key_option_age_bar);

</script>