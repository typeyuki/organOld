//可视化 颜色设置 变量定义
var legend_color='#fff';
var title_color="#fff";
var series_color_1='#6cbdfc',series_color_2='#dc88a9',series_color_3='#ffd289',series_color_4='#48e8dc',series_color_5='#f2f989',series_color_6='orange',series_color_7='rgb(139, 182, 93)';
var  title_text,yAxis_data,xAxis_data,series,legend_data;

var series_lebel_fontSize,title_fontSize,yAxis_axisLabel_fontSize_bar,yAxis_axisLabel_fontSize_line,xAxis_axisLabel_fontSize,
    yAxis_axisLabel_fontSize_barHei,xAxis_axisLabel_fontSize_barHei,series_item_fontSize,legand_fontSize;
if(winWidth>=1900){
    series_lebel_fontSize=20;
    title_fontSize=26;
    yAxis_axisLabel_fontSize_bar=20;
    yAxis_axisLabel_fontSize_line=18;
    xAxis_axisLabel_fontSize=18;
    yAxis_axisLabel_fontSize_barHei=20;
    xAxis_axisLabel_fontSize_barHei=20;
    series_item_fontSize=20;
    legand_fontSize=18;
}else if(winWidth<=1400 && winWidth>=1300){
    series_lebel_fontSize=10;
    title_fontSize=18;
    yAxis_axisLabel_fontSize_bar=16;
    yAxis_axisLabel_fontSize_line=14;
    xAxis_axisLabel_fontSize=14;
    yAxis_axisLabel_fontSize_barHei=16;
    xAxis_axisLabel_fontSize_barHei=16;
    series_item_fontSize=10;
    legand_fontSize=12;
}
//条形图
function chartBar(title_text,legend_data,yAxis_data,series) {
    var option = {
        title: {
            text:title_text,
            textStyle:{
                color:'#fff',
                fontSize:title_fontSize,
                fontWeight:100
            },
            x:'0%',
            y:'0%',
        },
        tooltip:{
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        legend: {
            orient: 'horizontal',
            right:'0',
            data:legend_data
        },
        grid:  {
            top:'25%',
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: {
            show:false
        },
        yAxis: {
            type:'category',
            data: yAxis_data,
            boundaryGap:false,
            axisTick:{
                show:false
            },
            // y 轴线
            axisLine:{
                show:false,

            },
            // 分割线设置
            splitLine:{
                show:false,  //显示分割线
            },
            axisLabel:{
                textStyle: {
                    color: '#fff',
                    fontSize:yAxis_axisLabel_fontSize_bar
                }
            }
        },
        series: series
    };
    return option;
}

//折线图
function chartLine(title_text,legend_data,xAxis_data,series) {
    var option = {
        title: {
            text:title_text,
            textStyle:{
                color:'#fff',
            fontSize:title_fontSize,
            fontWeight:100
            },
            x:'0%',
            y:'0%'
        },
        tooltip:{
            trigger: 'axis'
        },
        legend: {
            right:'0',
            top:'6%',
            data:legend_data
        },
        grid:  {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data:xAxis_data,
            nameTextStyle: {
                color: ['#fff'],
            },
            axisLine:{
                lineStyle:{
                    color:'#fff',
                    width:1//这里是为了突出显示加上的
                }
            },
            axisTrack:{
                length:1
            },
            splitLine:{
                show:false
            },
            axisLabel:{
                textStyle: {
                    color: '#fff',
                    fontSize:xAxis_axisLabel_fontSize,
                    fontWeight:100

                }
            }

        },
        yAxis: {
            type: 'value',
            nameTextStyle: {
                color: ['#fff'],
            },
            splitLine:{
                show:false
            },
            axisLine:{
                lineStyle:{
                    color:'#fff',
                    width:1,//这里是为了突出显示加上的
                }
            },
            axisTrack:{
                length:1
            },
            axisLabel:{
                textStyle: {
                    color: '#fff',
                    fontSize:yAxis_axisLabel_fontSize_line,
                    fontWeight:100
                }
            }
        },
        series: series,
    };
    return option;
}

//饼图
function chartPie(title_text,legend_data,series) {
    var option = {
        title : {
            text: title_text,
            textStyle:{
                color:title_color,
                fontSize:title_fontSize,
                fontWeight:100
            },
            x:'0%',
            y:'0%'
        },
        tooltip : {
            trigger: 'item',
            formatter: ""
        },
        legend: {
            orient: 'vertical',
            right: '0',
            top:"0",
            data: legend_data
        },
        series :series,
        color: [series_color_1,series_color_2,series_color_3,series_color_4,series_color_5,series_color_6,series_color_7]
    };
    return option;
}

function chartPie_1(title_text,legend_data,series) {
    var option = {
        title : {
            text: title_text,
            textStyle:{
                color:title_color,
                fontSize:title_fontSize,
                fontWeight:100
            },
            x:'0%',
            y:'0%'
        },
        graphic:{
            type:'text',
            left:'center',
            top:'center',
            style:{
                text:'总人数:1562',
                textAlign:'center',
                fill:'#fff',
                width:100,
                height:100,
                font: '2em "STHeiti", sans-serif'
            }
        },
        tooltip : {
            trigger: 'item',
            formatter: ""
        },
        legend: {
            orient: 'vertical',
            right: '0',
            top:"0",
            data: legend_data
        },
        series :series,
        color: [series_color_1,series_color_2,series_color_3,series_color_4,series_color_5,series_color_6,series_color_7]
    };
    return option;
}

//横向条形图
function chartBarHei(title_text,legend_data,xAxis_data,series) {
    var option = {
        title: {
            text:title_text,
            textStyle:{
                color:'#fff',
                fontSize:title_fontSize,
                fontWeight:100
            },
            x:'0%',
            y:'0%'
        },
        tooltip:{
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        legend: {
            orient: 'vertical',
            right:'0',
            data:legend_data
        },
        grid:  {
            top:'25%',
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis : [
            {
                type : 'category',
                data : xAxis_data,
                axisLabel:{
                    textStyle: {
                        color: '#fff',
                        fontSize:xAxis_axisLabel_fontSize_barHei,
                        fontWeight:100
                    },
                    show:true,
                    interval: 0//,
                },
                axisLine:{
                    lineStyle: {
                        color: '#fff'
                    }
                }
            }
        ],
        yAxis:[
            {
                type : 'value',
                axisLabel:{
                    textStyle: {
                        color: '#fff',
                        fontSize:yAxis_axisLabel_fontSize_barHei,
                        fontWeight:100
                    }
                },
                axisLine:{
                    lineStyle: {
                        color: '#fff'
                    }
                },
                splitLine:{
                    show:false
                }
            }
        ],
        series: series,
        color: [series_color_1,series_color_2,series_color_3,series_color_4,series_color_5,series_color_6,series_color_7]
    };
    return option;
}
function chartBarHei_1(title_text,legend_data,xAxis_data,series) {
    var option = {
        title: {
            text:title_text,
            textStyle:{
                color:'#fff',
                fontSize:title_fontSize,
                fontWeight:100
            },
            x:'0%',
            y:'0%'
        },
        tooltip:{
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        legend: {
            right:'0',
            data:legend_data
        },
        grid:  {
            top:'25%',
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis : [
            {
                type : 'category',
                data : xAxis_data,
                axisLabel:{
                    textStyle: {
                        color: '#fff',
                        fontSize:xAxis_axisLabel_fontSize_barHei,
                        fontWeight:100
                    },
                    show:true,
                    interval: 0//,
                },
                axisLine:{
                    lineStyle: {
                        color: '#fff'
                    }
                }
            }
        ],
        yAxis:[
            {
                type : 'value',
                axisLabel:{
                    textStyle: {
                        color: '#fff',
                        fontSize:yAxis_axisLabel_fontSize_barHei,
                        fontWeight:100
                    }
                },
                axisLine:{
                    lineStyle: {
                        color: '#fff'
                    }
                },
                splitLine:{
                    show:false
                }
            }
        ],
        series: series,
        color: [series_color_1,series_color_2,series_color_3,series_color_4,series_color_5,series_color_6,series_color_7]
    };
    return option;
}


function chartBarHeiSimpleAll(title_text,legend_data,xAxis_data,series) {
    var option = {
        title: {
            text:title_text,
            textStyle:{
                color:'#fff',
                fontSize:title_fontSize,
                fontWeight:100
            },
            x:'0%',
            y:'0%'
        },
        tooltip:{
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        legend: {
            orient: 'horizontal',
            right:'0',
            data:legend_data
        },
        grid: {
            y2: 140
        },
        xAxis: {
            type: 'category',
            boundaryGap: [0, 0.01],
            data : xAxis_data,
            axisLine:{
                lineStyle: {
                    color: '#fff',
                    fontSize:xAxis_axisLabel_fontSize_barHei,
                    fontWeight:100
                }
            },
            axisLabel:{
                interval:0,//横轴信息全部显示
                rotate:-30,//-30度角倾斜显示
                textStyle: {
                    color: '#fff'
                }
            }
        },
        yAxis:[
            {
                type : 'value',
                axisLabel:{
                    textStyle: {
                        color: '#fff',fontSize:yAxis_axisLabel_fontSize_barHei,
                        fontWeight:100
                    }
                },
                axisLine:{
                    lineStyle: {
                        color: '#fff'
                    }
                },
                splitLine:{
                    show:false
                }
            }
        ],
        series: series
    };
    return option;
}