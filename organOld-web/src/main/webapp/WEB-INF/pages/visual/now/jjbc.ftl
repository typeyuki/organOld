<style>
    @media only screen and (min-width: 6000px){
        .jjbc_tu{
            padding-top: 5%;
            padding-bottom: 2%;
        }
    }
</style>
<div id="child_jjbc" style="display: none">
    <div class="row" >
        <div class="col-lg-6 box">
            <div class="zz"></div>
            <div id="jjbc_jt_ys_num_pie" class="jjbc_tu"></div>
        </div>
        <div class="col-lg-6 box" >
            <div class="zz"></div>
            <div id="jjbc_jt_ys_age_bar" class="jjbc_tu"></div>
        </div>
    </div>
    <div class="row" >
        <div class="col-lg-6 box">
            <div class="zz"></div>
            <div id="jjbc_jt_ys_pq_bar" class="jjbc_tu"></div>
        </div>
        <div class="col-lg-6 box" >
            <div class="zz"></div>
            <div id="jjbc_jt_ys_sex_pie" class="jjbc_tu"></div>
        </div>
    </div>
</div>

<script type="text/javascript">
    var jjbc_tu_w,jjbc_tu_h;
    var jjbc_width=$("#organ").width();
    if(winWidth>=1900){
        jjbc_tu_w=jjbc_width/2.2;
        jjbc_tu_h=winHeight/4.4;
    }else if(winWidth<=1400 && winWidth>=1300){
        oldman_tu_w=winWidth/4.5;
        oldman_tu_h=winHeight/4.1;
    }
    $(".jjbc_tu").css('width',jjbc_tu_w);
    $(".jjbc_tu").css( 'height',jjbc_tu_h);

    var jjbc_jt_ys_age_bar = echarts.init(document.getElementById('jjbc_jt_ys_age_bar'));
    var jjbc_jt_ys_pq_bar = echarts.init(document.getElementById('jjbc_jt_ys_pq_bar'));
    var jjbc_jt_ys_sex_pie = echarts.init(document.getElementById('jjbc_jt_ys_sex_pie'));
    var jjbc_jt_ys_num_pie = echarts.init(document.getElementById('jjbc_jt_ys_num_pie'));
</script>

<script>
    title.text="人数占比容";
    title.link="javascript: change('child_jjbc','child_organ')";
//    title_text="人数占比";
    legend_data=[{name:'已参加',textStyle:{color:legend_color,fontSize:18}},{name:'未参加',textStyle:{color:legend_color,fontSize:18}}];
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
                {value:1360, name:'未参加'},
                {value:234, name:'已参加'}
            ]
        }
    ];
    var jjbc_option_jt_ys_num= chartPieClick(title,legend_data,series);
    jjbc_jt_ys_num_pie.setOption(jjbc_option_jt_ys_num);

    title_text="性别分布";
    legend_data=[{name:'男',textStyle:{color:legend_color,fontSize:18}},{name:'女',textStyle:{color:legend_color,fontSize:18}}];
    series=[{
        name: '老人性别',
        type: 'pie',
        radius : '45%',
        label : {
            normal : {
                formatter: '{d}%\n({c})',
                textStyle : {
                    fontWeight : 'normal',
                    fontSize : 8
                }
            }
        },
        center: ['50%', '50%'],
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
    var jjbc_option_jt_ys_sex_pie = chartPie(title_text,legend_data,series);
    jjbc_jt_ys_sex_pie.setOption(jjbc_option_jt_ys_sex_pie);

    title_text='年龄分布';
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
    var jjbc_option_jt_ys_age_bar=chartBar(title_text,legend_data,yAxis_data,series);
    jjbc_jt_ys_age_bar.setOption(jjbc_option_jt_ys_age_bar);

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
    var jjbc_option_jt_ys_pq_bar=chartBar(title_text,legend_data,yAxis_data,series);
    jjbc_jt_ys_pq_bar.setOption(jjbc_option_jt_ys_pq_bar);

</script>