<style>
    @media only screen and (min-width: 6000px){
        .oldman_tu{
            padding-top: 5%;
            padding-bottom: 2%;
        }
    }
</style>
<div id="child_oldman">
    <div class="row" >
        <div class="col-lg-6 box">
            <div class="zz"></div>
            <div id="oldman_zbPie" class="oldman_tu"></div>
        </div>
        <div class="col-lg-6 box" >
            <div class="zz"></div>
            <div id="oldman_familyPie" class="oldman_tu"></div>
        </div>
    </div>
    <div class="row" >
        <div class="col-lg-6 box">
            <div class="zz"></div>
            <div id="oldman_healthPie" class="oldman_tu"></div>
        </div>
        <div class="col-lg-6 box" >
            <div class="zz"></div>
            <div id="oldman_econmicPie" class="oldman_tu"></div>
        </div>
    </div>
</div>

<script type="text/javascript">
    var oldman_tu_w,oldman_tu_h;
    var oldman_width=$("#oldman").width();
    if(winWidth>=1900){
        oldman_tu_w=oldman_width/2.2;
        oldman_tu_h=winHeight/4.4;
    }else if(winWidth<=1400 && winWidth>=1300){
        oldman_tu_w=winWidth/4.5;
        oldman_tu_h=winHeight/4.1;
    }
    $(".oldman_tu").css('width',oldman_tu_w);
    $(".oldman_tu").css( 'height', oldman_tu_h);

    var oldman_zbPie= echarts.init(document.getElementById('oldman_zbPie'));
    var oldman_familyPie= echarts.init(document.getElementById('oldman_familyPie'));
    var oldman_healthPie= echarts.init(document.getElementById('oldman_healthPie'));
    var oldman_econmicPie= echarts.init(document.getElementById('oldman_econmicPie'));
</script>


<script>

    title.text="重点老人比例";
    title.link="javascript: change('child_oldman','child_key')";
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
                        fontWeight : 100,
                        fontSize : 26
                    }
                }
            },
            data:[
                {value:15360, name:'非老人'},
                {value:4310, name:'老人'}
            ]
        }
    ];
    var oldman_option_zb_pie = chartPieClick(title,legend_data,series);
    oldman_zbPie.setOption(oldman_option_zb_pie);

    //家庭结构
    title.text="家庭结构分布饼图";
    title.link="javascript: change('child_oldman','child_family')";
    legend_data=[{name:'纯老',textStyle:{color:legend_color,fontSize:18}},{name:'独居',textStyle:{color:legend_color,fontSize:18}}
        ,{name:'失独',textStyle:{color:legend_color,fontSize:18}},{name:'一老养一老',textStyle:{color:legend_color,fontSize:18}},
        {name:'孤老',textStyle:{color:legend_color,fontSize:18}},{name:'三支人员',textStyle:{color:legend_color,fontSize:18}},{name:'其他',textStyle:{color:legend_color,fontSize:18}}];
    series=[{
        name: '老人家庭结构',
        type: 'pie',
        radius : '45%',
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
            {value:476, name:'纯老'},
            {value:376, name:'独居'},
            {value:376, name:'失独'},
            {value:376, name:'一老养一老'},
            {value:376, name:'孤老'},
            {value:376, name:'三支人员'},
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
    var oldman_option_family_pie = chartPieClick(title,legend_data,series);
    oldman_familyPie.setOption(oldman_option_family_pie);

    //健康状态
    title.text="健康状态分布饼图";
    title.link="javascript: change('child_oldman','child_health')";
    legend_data=[{name:'失能',textStyle:{color:legend_color,fontSize:18}},{name:'慢病',textStyle:{color:legend_color,fontSize:18}}
        ,{name:'肿瘤史',textStyle:{color:legend_color,fontSize:18}},{name:'骨折史',textStyle:{color:legend_color,fontSize:18}},
        {name:'失智',textStyle:{color:legend_color,fontSize:18}},{name:'长护险评级',textStyle:{color:legend_color,fontSize:18}},{name:'其他',textStyle:{color:legend_color,fontSize:18}}];
    series=[{
        name: '健康状态',
        type: 'pie',
        radius : '45%',
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
            {value:476, name:'失能'},
            {value:376, name:'慢病'},
            {value:376, name:'肿瘤史'},
            {value:376, name:'骨折史'},
            {value:376, name:'失智'},
            {value:376, name:'长护险评级'},
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
    var oldman_option_health_pie = chartPieClick(title,legend_data,series);
    oldman_healthPie.setOption(oldman_option_health_pie);


    //经济条件
    title.text="经济条件分布饼图";
    title.link="javascript: change('child_oldman','child_economic')";
    legend_data=[{name:'帮困',textStyle:{color:legend_color,fontSize:18}},{name:'低保',textStyle:{color:legend_color,fontSize:18}}
        ,{name:'养老保险',textStyle:{color:legend_color,fontSize:18}},{name:'医疗救助金',textStyle:{color:legend_color,fontSize:18}},
        {name:'城镇医保',textStyle:{color:legend_color,fontSize:18}},{name:'其他',textStyle:{color:legend_color,fontSize:18}}];
    series=[{
        name: '老人经济条件',
        type: 'pie',
        radius : '45%',
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
            {value:476, name:'帮困'},
            {value:376, name:'低保'},
            {value:376, name:'养老保险'},
            {value:376, name:'医疗救助金'},
            {value:376, name:'城镇医保'},
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
    var oldman_option_econmic_pie = chartPieClick(title,legend_data,series);
    oldman_econmicPie.setOption(oldman_option_econmic_pie);
</script>