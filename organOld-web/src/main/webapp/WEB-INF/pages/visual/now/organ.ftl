<style>
    @media only screen and (min-width: 6000px){
        .organ_tu,.organ_tu_big{
            padding-top: 5%;
            padding-bottom: 2%;
        }
    }
</style>
<div id="child_organ">
    <div class="row">
        <div class="col-lg-6 box"  align="center">
            <div class="zz"></div>
            <div id="organ_zbPie" class="organ_tu_big"></div>
        </div>
        <div class="col-lg-6 box">
            <div class="zz"></div>
            <div id="organ_sum_pie" class="organ_tu_big"></div>
        </div>
    </div>
    <div class="row">
    <div class="col-lg-4 box">
        <div class="zz"></div>
        <div id="organ_jg_pie" class="organ_tu"></div>
    </div>
    <div class="col-lg-4 box">
        <div class="zz"></div>
        <div id="organ_sq_sub_pie" class="organ_tu"></div>
    </div>
    <div class="col-lg-4 box">
        <div class="zz"></div>
        <div id="organ_jj_pie" class="organ_tu"></div>
    </div>
</div>
</div>
<script type="text/javascript">
    var organ_tu_w,organ_tu_h,organ_tu_big_w,organ_tu_big_h;
    var organ_width=$("#organ").width();

    if(winWidth>=1900){
        organ_tu_w=organ_width/3.2;
        organ_tu_h=winHeight/4.4;
        organ_tu_big_w=organ_width/2.2;
        organ_tu_big_h=winHeight/4.4;
    }else if(winWidth<=1400 && winWidth>=1300){
        organ_tu_w=winWidth/4.5;
        organ_tu_h=winHeight/4.1;
        organ_tu_big_w=winWidth/4.5;
        organ_tu_big_h=winHeight/2.2;
    }

    $(".organ_tu_big").css('width',organ_tu_big_w);
    $(".organ_tu_big").css( 'height', organ_tu_big_h);
    $(".organ_tu").css('width',organ_tu_w);
    $(".organ_tu").css( 'height', organ_tu_h);
    var organ_sq_sub_pie = echarts.init(document.getElementById('organ_sq_sub_pie'));
    var organ_zbPie= echarts.init(document.getElementById('organ_zbPie'));
    var organ_jg_pie = echarts.init(document.getElementById('organ_jg_pie'));
    var organ_jj_pie = echarts.init(document.getElementById('organ_jj_pie'));
    var organ_sum_pie = echarts.init(document.getElementById('organ_sum_pie'));
</script>
<script>
    title_text="养老情况比例";
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
                        fontWeight : 'normal',
                        fontSize : 20
                    }
                }
            },
            data:[
                {value:15360, name:'非老人'},
                {value:4310, name:'老人'}
            ]
        }
    ];
    var organ_option_zb_pie = chartPie(title_text,legend_data,series);
    organ_zbPie.setOption(organ_option_zb_pie);


    var title_organOldman_1={
        text: "机构养老",
        link:"javascript: change('child_organ','child_organOldman')",
        target: "self",
        textStyle:{
            color:title_color,
            fontSize:title_fontSize,
            fontWeight:100
        },
        x:'0%',
        y:'0%'
    };
    legend_data=[{name:'古美养老院',textStyle:{color:legend_color,fontSize:18}},{name:'东兰养老院',textStyle:{color:legend_color,fontSize:18}},{name:'平阳养老院',textStyle:{color:legend_color,fontSize:18}}];
    series=[{
        name: '老人户籍',
        type: 'pie',
        radius : '65%',
        center: ['48%', '50%'],
        label : {
            normal : {
                formatter: '{d}%\n({c})',
                textStyle : {
                    fontWeight : 'normal',
                    fontSize : 14
                }
            }
        },
        data:[
            {value:476, name:'古美养老院'},
            {value:376, name:'东兰养老院'},
            {value:376, name:'平阳养老院'}
        ],
        itemStyle: {
            emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
        }
    }];
    var organ_option_jg_pie = chartPieClick(title_organOldman_1,legend_data,series);
    organ_jg_pie.setOption(organ_option_jg_pie);


    title_text="社区养老";
    legend_data=[{name:'长者照护之家',textStyle:{color:legend_color,fontSize:18}},{name:'日照中心',textStyle:{color:legend_color,fontSize:18}},{name:'助餐点',textStyle:{color:legend_color,fontSize:18}}];
    series=[{
        name: '老人户籍',
        type: 'pie',
        radius : '65%',
        center: ['48%', '50%'],
        label : {
            normal : {
                formatter: '{d}%\n({c})',
                textStyle : {
                    fontWeight : 'normal',
                    fontSize : 14
                }
            }
        },
        data:[
            {value:476, name:'长者照护之家'},
            {value:376, name:'日照中心'},
            {value:376, name:'助餐点'}
        ],
        itemStyle: {
            emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
        }
    }];
    var organ_option_sq_sub_pie = chartPie(title_text,legend_data,series);
    organ_sq_sub_pie.setOption(organ_option_sq_sub_pie);

    //legend 点击事件
    organ_sq_sub_pie.on('legendselectchanged', function (params) {
        var name = params.name;
        if(name=="助餐点"){
            change('child_organ','child_zcdOldman');
        }else if(name=="日照中心"){
            change('child_organ','child_rzzxOldman');
        }else if(name=="长者照护之家"){
            change('child_organ','child_zzOldman');
    }
    });


    title_text="居家养老";
    legend_data=[{name:'家庭养老',textStyle:{color:legend_color,fontSize:18}},
        {name:'长护险',textStyle:{color:legend_color,fontSize:18}},
        {name:'智能化应用',textStyle:{color:legend_color,fontSize:18}},
        {name:'家庭医生',textStyle:{color:legend_color,fontSize:18}},
        {name:'家庭病床',textStyle:{color:legend_color,fontSize:18}}];
    series=[{
        name: '居家养老',
        type: 'pie',
        radius : '65%',
        center: ['48%', '50%'],
        label : {
            normal : {
                formatter: '{d}%\n({c})',
                textStyle : {
                    fontWeight : 'normal',
                    fontSize : 14
                }
            }
        },
        data:[
            {value:476, name:'家庭养老'},
            {value:376, name:'长护险'},
            {value:376, name:'智能化应用'},
            {value:376, name:'家庭医生'},
            {value:376, name:'家庭病床'}
        ],
        itemStyle: {
            emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
        }
    }];


    var organ_option_jj_pie = chartPie(title_text,legend_data,series);
    organ_jj_pie.setOption(organ_option_jj_pie);


    //legend 点击事件
    organ_jj_pie.on('legendselectchanged', function (params) {
        var name = params.name;
        if(name=="家庭养老"){
            change('child_organ','child_homeOldman');
        }else if(name=="长护险"){
            change('child_organ','child_chx');
        }else if(name=="智能化应用"){
            change('child_organ','child_znh');
        }else if(name=="家庭医生"){
            change('child_organ','child_jjys');
        }else if(name=="家庭病床"){
            change('child_organ','child_jjbc');
        }
    });


    title_text="养老服务覆盖率";
    legend_data=[{name:'总人数',textStyle:{color:legend_color,fontSize:18}},{name:'机构养老',textStyle:{color:legend_color,fontSize:18}},{name:'社区居家养老',textStyle:{color:legend_color,fontSize:18}}
        ,{name:'社区养老',textStyle:{color:legend_color,fontSize:18}}
        ,{name:'居家养老',textStyle:{color:legend_color,fontSize:18}}];
    series=[
        {
            name:'访问来源',
            type:'pie',
            selectedMode: 'single',
            radius: [0, '30%'],

            label: {
                normal: {
                    formatter: '{d}%\n({c})',
                    position: 'inner',
                    fontSize : 16
                }
            },
            labelLine: {
                normal: {
                    show: false
                }
            },
            data:[
                {value:1548, name:'总人数'},
                {value:679, name:'机构养老'},
                {value:355, name:'社区居家养老', selected:true}
            ]
        },
        {
            name:'访问来源',
            type:'pie',
            radius: ['40%', '55%'],
            label: {
                normal: {
                    fontSize : 20,
                    formatter: '{d}%\n({c})',
                    backgroundColor: '#eee',
                    borderColor: '#aaa',
                    borderWidth: 1,
                    borderRadius: 4,
                    // shadowBlur:3,
                    // shadowOffsetX: 2,
                    // shadowOffsetY: 2,
                    // shadowColor: '#999',
                    // padding: [0, 7],
                    rich: {
                        a: {
                            color: '#999',
                            lineHeight: 22,
                            align: 'center'
                        },
                        // abg: {
                        //     backgroundColor: '#333',
                        //     width: '100%',
                        //     align: 'right',
                        //     height: 22,
                        //     borderRadius: [4, 4, 0, 0]
                        // },
                        hr: {
                            borderColor: '#aaa',
                            width: '100%',
                            borderWidth: 0.5,
                            height: 0
                        },
                        b: {
                            fontSize: 20,
                            lineHeight: 33
                        },
                        per: {
                            color: '#eee',
                            backgroundColor: '#334455',
                            padding: [2, 4],
                            borderRadius: 2
                        }
                    }
                }
            },
            data:[
                {value:110, name:'社区养老'},
                {value:80, name:'居家养老'}
            ]
        }
    ];
    var organ_option_sum_pie = chartPie(title_text,legend_data,series);
    organ_sum_pie.setOption(organ_option_sum_pie);
</script>