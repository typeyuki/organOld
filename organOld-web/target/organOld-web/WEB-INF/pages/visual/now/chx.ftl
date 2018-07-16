<style>
    @media only screen and (min-width: 6000px){
        .chx_tu,.chx_tu_big,.chx_tu_mid{
            padding-top: 5%;
            padding-bottom: 2%;
        }
    }
</style>
<div id="child_chx" style="display: none">
    <div class="row" >
        <div class="col-lg-6 box"  align="center">
            <div class="zz"></div>
            <div id="chx_num_pie" class="chx_tu_big"></div>
        </div>
        <div class="col-lg-6">
            <div class="row">
                <div class="col-lg-12 box">
                    <div class="zz"></div>
                    <div id="chx_pj_jb_bar" class="chx_tu_mid"></div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12 box">
                    <div class="zz"></div>
                    <div id="chx_pj_age_bar" class="chx_tu_mid"></div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12 box">
                    <div class="zz"></div>
                    <div id="chx_pj_pq_bar" class="chx_tu_mid"></div>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-6">
            <div class="row">
                <div class="col-lg-6 box">
                    <div class="zz"></div>
                    <div id="chx_pj_sex_pie" class="chx_tu"></div>
                </div>
                <div class="col-lg-6 box">
                    <div class="zz"></div>
                    <div id="chx_pj_hj_pie" class="chx_tu"></div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6 box">
                    <div class="zz"></div>
                    <div id="chx_fw_sex_pie" class="chx_tu"></div>
                </div>
                <div class="col-lg-6 box">
                    <div class="zz"></div>
                    <div id="chx_fw_hj_pie" class="chx_tu"></div>
                </div>
            </div>
        </div>
        <div class="col-lg-6">
            <div class="row">
                <div class="col-lg-12 box">
                    <div class="zz"></div>
                    <div id="chx_fw_jb_bar" class="chx_tu_mid"></div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12 box">
                    <div class="zz"></div>
                    <div id="chx_fw_age_bar" class="chx_tu_mid"></div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12 box">
                    <div class="zz"></div>
                    <div id="chx_fw_pq_bar" class="chx_tu_mid"></div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    var chx_tu_w,chx_tu_h,chx_tu_big_w,chx_tu_big_h,chx_tu_mid_w,chx_tu_mid_h;
    var chx_width=$("#organ").width();
    if(winWidth>=1900){
        chx_tu_w=chx_width/4.4;
        chx_tu_h=winHeight/8.85;
        chx_tu_big_w=chx_width/2.2;
        chx_tu_big_h=winHeight/4.4;
        chx_tu_mid_w=chx_width/2.2;
        chx_tu_mid_h=winHeight/13.26;
    }else if(winWidth<=1400 && winWidth>=1300){
        oldman_tu_w=winWidth/4.5;
        oldman_tu_h=winHeight/4.1;
    }

    $(".chx_tu_big").css('width',chx_tu_big_w);
    $(".chx_tu_big").css( 'height', chx_tu_big_h);
    $(".chx_tu").css('width',chx_tu_w);
    $(".chx_tu").css( 'height', chx_tu_h);
    $(".chx_tu_mid").css('width',chx_tu_mid_w);
    $(".chx_tu_mid").css( 'height', chx_tu_mid_h);

    var chx_num_pie=echarts.init(document.getElementById('chx_num_pie'));

    var chx_pj_jb_bar = echarts.init(document.getElementById('chx_pj_jb_bar'));
    var chx_pj_pq_bar = echarts.init(document.getElementById('chx_pj_pq_bar'));
    var chx_pj_age_bar= echarts.init(document.getElementById('chx_pj_age_bar'));
    var chx_pj_sex_pie= echarts.init(document.getElementById('chx_pj_sex_pie'));
    var chx_pj_hj_pie = echarts.init(document.getElementById('chx_pj_hj_pie'));

    var chx_fw_jb_bar = echarts.init(document.getElementById('chx_fw_jb_bar'));
    var chx_fw_pq_bar = echarts.init(document.getElementById('chx_fw_pq_bar'));
    var chx_fw_age_bar= echarts.init(document.getElementById('chx_fw_age_bar'));
    var chx_fw_sex_pie= echarts.init(document.getElementById('chx_fw_sex_pie'));
    var chx_fw_hj_pie = echarts.init(document.getElementById('chx_fw_hj_pie'));
</script>
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
    var chx_option_pj_jb_bar=chartBar(title_text,legend_data,yAxis_data,series);
    chx_pj_jb_bar.setOption(chx_option_pj_jb_bar);


    var title_chx_1={
        text: "长护险",
        link:"javascript: change('child_chx','child_organ')",
        target: "self",
        textStyle:{
            color:title_color,
            fontSize:title_fontSize,
            fontWeight:100
        },
        x:'0%',
        y:'0%'
    };
    //数量饼图
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
    var chx_option_num_pie = chartPie_1Click(title_chx_1,legend_data,series);
    chx_num_pie.setOption(chx_option_num_pie);

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
    var chx_option_pj_pq_bar=chartBar(title_text,legend_data,yAxis_data,series);
    chx_pj_pq_bar.setOption(chx_option_pj_pq_bar);

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
    var chx_option_pj_age_bar=chartBar(title_text,legend_data,yAxis_data,series);
    chx_pj_age_bar.setOption(chx_option_pj_age_bar);


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
    var chx_option_pj_hj_pie = chartPie(title_text,legend_data,series);
    chx_pj_hj_pie.setOption(chx_option_pj_hj_pie);

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
    var chx_option_pj_sex_pie = chartPie(title_text,legend_data,series);
    chx_pj_sex_pie.setOption(chx_option_pj_sex_pie);


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
    var chx_option_fw_jb_bar=chartBar(title_text,legend_data,yAxis_data,series);
    chx_fw_jb_bar.setOption(chx_option_fw_jb_bar);

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
    var chx_option_fw_pq_bar=chartBar(title_text,legend_data,yAxis_data,series);
    chx_fw_pq_bar.setOption(chx_option_fw_pq_bar);

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
    var chx_option_fw_age_bar=chartBar(title_text,legend_data,yAxis_data,series);
    chx_fw_age_bar.setOption(chx_option_fw_age_bar);


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
    var chx_option_fw_hj_pie = chartPie(title_text,legend_data,series);
    chx_fw_hj_pie.setOption(chx_option_fw_hj_pie);

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
    var chx_option_fw_sex_pie = chartPie(title_text,legend_data,series);
    chx_fw_sex_pie.setOption(chx_option_fw_sex_pie);


</script>