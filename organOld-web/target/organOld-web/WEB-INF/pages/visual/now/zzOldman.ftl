<style>
    @media only screen and (min-width: 6000px){
        .zzOldman_tu{
            padding-top: 5%;
            padding-bottom: 2%;
        }
    }
</style>
<div id="child_zzOldman" style="display: none">
    <div class="row box">
        <div class="zz"></div>
        <p class="title" onclick="change('child_zzOldman','child_organ')">长者照护之家床位数总和</p>
        <div class="col-lg-3">
            <div id="zzOldman_jg_sub_pie" class="zzOldman_tu"></div>
        </div>
        <div class="col-lg-3">
            <div id="zzOldman_jg_sub_wl" class="zzOldman_tu"></div>
        </div>
        <div class="col-lg-3">
            <div id="zzOldman_jg_sex_pie" class="zzOldman_tu"></div>
        </div>
        <div class="col-lg-3">
            <div id="zzOldman_jg_age_bar" class="zzOldman_tu"></div>
        </div>
    </div>
    <div class="row box">
        <div class="zz"></div>
        <p class="title">古美长者照护之家</p>
        <div class="col-lg-3">
            <div id="zzOldman_jg_1_pie" class="zzOldman_tu"></div>
        </div>
        <div class="col-lg-3">
            <div id="zzOldman_jg_1_wl" class="zzOldman_tu"></div>
        </div>
        <div class="col-lg-3">
            <div id="zzOldman_jg_1_sex" class="zzOldman_tu"></div>
        </div>
        <div class="col-lg-3">
            <div id="zzOldman_jg_1_age" class="zzOldman_tu"></div>
        </div>
    </div>
    <div class="row box">
        <div class="zz"></div>
        <p class="title">东兰长者照护之家</p>
        <div class="col-lg-3">
            <div id="zzOldman_jg_2_pie" class="zzOldman_tu"></div>
        </div>
        <div class="col-lg-3">
            <div id="zzOldman_jg_2_wl" class="zzOldman_tu"></div>
        </div>
        <div class="col-lg-3">
            <div id="zzOldman_jg_2_sex" class="zzOldman_tu"></div>
        </div>
        <div class="col-lg-3">
            <div id="zzOldman_jg_2_age" class="zzOldman_tu"></div>
        </div>
    </div>
    <div class="row box">
        <div class="zz"></div>
        <p class="title">平阳长者照护之家</p>
        <div class="col-lg-3">
            <div id="zzOldman_jg_3_pie" class="zzOldman_tu"></div>
        </div>
        <div class="col-lg-3">
            <div id="zzOldman_jg_3_wl" class="zzOldman_tu"></div>
        </div>
        <div class="col-lg-3">
            <div id="zzOldman_jg_3_sex" class="zzOldman_tu"></div>
        </div>
        <div class="col-lg-3">
            <div id="zzOldman_jg_3_age" class="zzOldman_tu"></div>
        </div>
    </div>
</div>
<script type="text/javascript">
    var zzOldman_tu_w,zzOldman_tu_h;
    var zzOldman_width=$("#organ").width();
    if(winWidth>=1900){
        zzOldman_tu_w=zzOldman_width/4;
        zzOldman_tu_h=winHeight/10.05;
    }else if(winWidth<=1400 && winWidth>=1300){
        oldman_tu_w=winWidth/4.5;
        oldman_tu_h=winHeight/4.1;
    }

    $(".zzOldman_tu").css('width',zzOldman_tu_w);
    $(".zzOldman_tu").css( 'height', zzOldman_tu_h);

    var zzOldman_jg_sub_pie = echarts.init(document.getElementById('zzOldman_jg_sub_pie'));
    var zzOldman_jg_sub_wl= echarts.init(document.getElementById('zzOldman_jg_sub_wl'));
    var zzOldman_jg_1_pie= echarts.init(document.getElementById('zzOldman_jg_1_pie'));
    var zzOldman_jg_1_wl = echarts.init(document.getElementById('zzOldman_jg_1_wl'));
    var zzOldman_jg_2_pie= echarts.init(document.getElementById('zzOldman_jg_2_pie'));
    var zzOldman_jg_2_wl = echarts.init(document.getElementById('zzOldman_jg_2_wl'));
    var zzOldman_jg_3_pie= echarts.init(document.getElementById('zzOldman_jg_3_pie'));
    var zzOldman_jg_3_wl = echarts.init(document.getElementById('zzOldman_jg_3_wl'));

    var zzOldman_jg_sex_pie = echarts.init(document.getElementById('zzOldman_jg_sex_pie'));
    var zzOldman_jg_age_bar = echarts.init(document.getElementById('zzOldman_jg_age_bar'));
    var zzOldman_jg_1_age = echarts.init(document.getElementById('zzOldman_jg_1_age'));
    var zzOldman_jg_1_sex = echarts.init(document.getElementById('zzOldman_jg_1_sex'));
    var zzOldman_jg_2_age = echarts.init(document.getElementById('zzOldman_jg_2_age'));
    var zzOldman_jg_2_sex = echarts.init(document.getElementById('zzOldman_jg_2_sex'));
    var zzOldman_jg_3_age = echarts.init(document.getElementById('zzOldman_jg_3_age'));
    var zzOldman_jg_3_sex = echarts.init(document.getElementById('zzOldman_jg_3_sex'));
</script>


<script>

    title_text="";
    legend_data=[{name:'已入住',textStyle:{color:legend_color,fontSize:18}},{name:'剩余',textStyle:{color:legend_color,fontSize:18}}];
    series=[{
        name: '老人户籍',
        type: 'pie',
        radius : '55%',
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
            {value:476, name:'已入住'},
            {value:376, name:'剩余'}
        ],
        itemStyle: {
            emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
        }
    }];
    var zzOldman_option_sub_pie = chartPie(title_text,legend_data,series);

    title_text="";
    legend_data=[];
    series=[
        {
            name:'未来空余',
            type:'pie',
            radius: ['50%', '65%'],
            avoidLabelOverlap: false,
            label: {
                normal : {
                    position:"center",
                    formatter: '{a}\n{c}',
                    textStyle : {
                        fontWeight : 'normal',
                        fontSize : 18,
                        color:"#f2f989"
                    }
                }
            },
            data:[
                {value:40, name:'未来空余'}
            ]
        }
    ];
    var zzOldman_option_sub_wl = chartPie(title_text,legend_data,series);
    title_text="";
    legend_data=[{name:'已入住',textStyle:{color:legend_color,fontSize:18}},{name:'剩余',textStyle:{color:legend_color,fontSize:18}}];
    series=[{
        name: '老人户籍',
        type: 'pie',
        radius : '55%',
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
            {value:476, name:'已入住'},
            {value:376, name:'剩余'}
        ],
        itemStyle: {
            emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
        }
    }];
    var zzOldman_option_1_pie = chartPie(title_text,legend_data,series);

    title_text="";
    legend_data=[];
    series=[
        {
            name:'未来空余',
            type:'pie',
            radius: ['50%', '65%'],
            avoidLabelOverlap: false,
            label: {
                normal : {
                    position:"center",
                    formatter: '{a}\n{c}',
                    textStyle : {
                        fontWeight : 'normal',
                        fontSize : 18,
                        color:"#f2f989"
                    }
                }
            },
            data:[
                {value:40, name:'未来空余'}
            ]
        }
    ];
    var zzOldman_option_1_wl = chartPie(title_text,legend_data,series);
    title_text="";
    legend_data=[{name:'已入住',textStyle:{color:legend_color,fontSize:18}},{name:'剩余',textStyle:{color:legend_color,fontSize:18}}];
    series=[{
        name: '老人户籍',
        type: 'pie',
        radius : '55%',
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
            {value:476, name:'已入住'},
            {value:376, name:'剩余'}
        ],
        itemStyle: {
            emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
        }
    }];
    var zzOldman_option_2_pie = chartPie(title_text,legend_data,series);

    title_text="";
    legend_data=[];
    series=[
        {
            name:'未来空余',
            type:'pie',
            radius: ['50%', '65%'],
            avoidLabelOverlap: false,
            label: {
                normal : {
                    position:"center",
                    formatter: '{a}\n{c}',
                    textStyle : {
                        fontWeight : 'normal',
                        fontSize : 18,
                        color:"#f2f989"
                    }
                }
            },
            data:[
                {value:40, name:'未来空余'}
            ]
        }
    ];
    var zzOldman_option_2_wl = chartPie(title_text,legend_data,series);
    title_text="";
    legend_data=[{name:'已入住',textStyle:{color:legend_color,fontSize:18}},{name:'剩余',textStyle:{color:legend_color,fontSize:18}}];
    series=[{
        name: '老人户籍',
        type: 'pie',
        radius : '55%',
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
            {value:476, name:'已入住'},
            {value:376, name:'剩余'}
        ],
        itemStyle: {
            emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
        }
    }];
    var zzOldman_option_3_pie = chartPie(title_text,legend_data,series);

    title_text="";
    legend_data=[];
    series=[
        {
            name:'未来空余',
            type:'pie',
            radius: ['50%', '65%'],
            avoidLabelOverlap: false,
            label: {
                normal : {
                    position:"center",
                    formatter: '{a}\n{c}',
                    textStyle : {
                        fontWeight : 'normal',
                        fontSize : 18,
                        color:"#f2f989"
                    }
                }
            },
            data:[
                {value:40, name:'未来空余'}
            ]
        }
    ];
    var zzOldman_option_3_wl = chartPie(title_text,legend_data,series);

    zzOldman_jg_sub_pie.setOption(zzOldman_option_sub_pie);
    zzOldman_jg_sub_wl.setOption(zzOldman_option_sub_wl);
    zzOldman_jg_1_pie.setOption(zzOldman_option_1_pie);
    zzOldman_jg_1_wl.setOption(zzOldman_option_1_wl);
    zzOldman_jg_2_pie.setOption(zzOldman_option_2_pie);
    zzOldman_jg_2_wl.setOption(zzOldman_option_2_wl);
    zzOldman_jg_3_pie.setOption(zzOldman_option_3_pie);
    zzOldman_jg_3_wl.setOption(zzOldman_option_3_wl);

    //性别饼图
    title_text="性别";
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
        center: ['48%', '50%'],
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
    var zzOldman_option_jg_sex_pie = chartPie(title_text,legend_data,series);
    zzOldman_jg_sex_pie.setOption(zzOldman_option_jg_sex_pie);
    //性别饼图
    title_text="性别";
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
        center: ['48%', '50%'],
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
    var zzOldman_option_jg_1_sex = chartPie(title_text,legend_data,series);
    zzOldman_jg_1_sex.setOption(zzOldman_option_jg_1_sex);
    //性别饼图
    title_text="性别";
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
        center: ['48%', '50%'],
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
    var zzOldman_option_jg_2_sex = chartPie(title_text,legend_data,series);
    zzOldman_jg_2_sex.setOption(zzOldman_option_jg_2_sex);
    //性别饼图
    title_text="性别";
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
        center: ['48%', '50%'],
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
    var zzOldman_option_jg_3_sex = chartPie(title_text,legend_data,series);
    zzOldman_jg_3_sex.setOption(zzOldman_option_jg_3_sex);

    title_text='年龄';
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
    var zzOldman_option_jg_age_bar=chartBar(title_text,legend_data,yAxis_data,series);
    zzOldman_jg_age_bar.setOption(zzOldman_option_jg_age_bar);
    title_text='年龄';
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
    var zzOldman_option_jg_1_age=chartBar(title_text,legend_data,yAxis_data,series);
    zzOldman_jg_1_age.setOption(zzOldman_option_jg_1_age);
    title_text='年龄';
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
    var zzOldman_option_jg_2_age=chartBar(title_text,legend_data,yAxis_data,series);
    zzOldman_jg_2_age.setOption(zzOldman_option_jg_2_age);
    title_text='年龄';
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
    var zzOldman_option_jg_3_age=chartBar(title_text,legend_data,yAxis_data,series);
    zzOldman_jg_3_age.setOption(zzOldman_option_jg_3_age);

</script>