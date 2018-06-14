<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<#include "../head.ftl" />
    <link href="/static/css/visual/one.css" rel="stylesheet">
     <script type="text/javascript">
        window.onload=function(){
            setInterval(function(){
                var date=new Date();
                // alert(JSON.stringify(date));
                var year=date.getFullYear(); //获取当前年份
                var mon=date.getMonth(); //获取当前月份
                var da=date.getDate(); //获取当前日
                var d=document.getElementById('Date');
                d.innerHTML=year+'年'+mon+'月'+da+'日';},1000)  }
    </script>
</head>

<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-6">
            <div class="row" align="center">
                <div class="col-lg-12">
                    <div class="row">
                        <div class="col-lg-3">
                            <div id="Date" style="color:#ffffff;text-align: center;padding-top: 2%;"></div>
                        </div>
                        <div class="col-lg-8">
                            <p class="map_title">古美路街道老人数量分布热力图</p>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <style type="text/css">
                            /*html,body{margin:0;padding:0;}*/
                            .iw_poi_title {color:#CC5522;font-size:14px;font-weight:bold;overflow:hidden;padding-right:13px;white-space:nowrap}
                            .iw_poi_content {font:12px arial,sans-serif;overflow:visible;padding-top:4px;white-space:-moz-pre-wrap;word-wrap:break-word}
                        </style>
                        <script type="text/javascript" src="http://api.map.baidu.com/api?key=&v=1.1&services=true"></script>
                        <script type="text/javascript" src="http://api.map.baidu.com/library/GeoUtils/1.2/docs/symbols/BMapLib.html"></script>
                        <script type="text/javascript" src="http://api.map.baidu.com/library/GeoUtils/1.2/docs/symbols/src/BMapLib_GeoUtils.js.html"></script>

                        <script type="text/javascript" src="http://api.map.baidu.com/library/TrafficControl/1.4/src/TrafficControl_min.js"></script>

                        <div class="col-lg-7" style="width:600px;height:700px;border:#ccc solid 1px;margin-left: 300px;margin-top: 50px;" id="dituContent"></div>
                        <script type="text/javascript">
                            //创建和初始化地图函数：
                            function initMap(){
                                createMap();//创建地图
                                setMapEvent();//设置地图事件
                                addMapControl();//向地图添加控件
                                addMarker();//向地图添加标记
                                addPolygon();
                                addPolyline();//向地图中添加线

                            }

                            //创建地图函数：
                            function createMap(){
                                var map = new BMap.Map("dituContent");//在百度地图容器中创建一个地图
                                var point = new BMap.Point(121.404295,31.151234);//定义一个中心点坐标
                                map.centerAndZoom(point,15);//设定地图的中心点和坐标并将地图显示在地图容器中
                                window.map = map;//将map变量存储在全局
                            }

                            //地图事件设置函数：
                            function setMapEvent(){
                                map.enableDragging();//启用地图拖拽事件，默认启用(可不写)
                                map.enableScrollWheelZoom();//启用地图滚轮放大缩小
                                map.enableDoubleClickZoom();//启用鼠标双击放大，默认启用(可不写)
                                map.enableKeyboard();//启用键盘上下左右键移动地图
                            }

                            //地图控件添加函数：
                            function addMapControl(){
                                //向地图中添加缩放控件
                                var ctrl_nav = new BMap.NavigationControl({anchor:BMAP_ANCHOR_TOP_LEFT,type:BMAP_NAVIGATION_CONTROL_LARGE});
                                map.addControl(ctrl_nav);
                                //向地图中添加缩略图控件
                                var ctrl_ove = new BMap.OverviewMapControl({anchor:BMAP_ANCHOR_BOTTOM_RIGHT,isOpen:1});
                                map.addControl(ctrl_ove);
                                //向地图中添加比例尺控件
                                var ctrl_sca = new BMap.ScaleControl({anchor:BMAP_ANCHOR_BOTTOM_LEFT});
                                map.addControl(ctrl_sca);
                            }

                            //标注点数组
                            var markerArr = [{title:"平阳三村\n500号",content:"平阳三村\n500号",point:"121.395096|31.137743",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5},type:1}];
                            //创建marker
                            function addMarker(){
                                for(var i=0;i<markerArr.length;i++){
                                    var json = markerArr[i];
                                    var p0 = json.point.split("|")[0];
                                    var p1 = json.point.split("|")[1];
                                    var point = new BMap.Point(p0,p1);
                                    var type =json.type;
                                    var iconImg = createIcon(json.icon,type);
                                    var marker = new BMap.Marker(point,{icon:iconImg});
                                    var iw = createInfoWindow(i);
                                    var label = new BMap.Label(json.title,{"offset":new BMap.Size(json.icon.lb-json.icon.x+10,-20)});
                                    marker.setLabel(label);
                                    map.addOverlay(marker);
                                    label.setStyle({
                                        borderColor:"#808080",
                                        color:"#146",
                                        cursor:"pointer",
                                        fontWeight:"bold",
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
                            }
                            //创建InfoWindow
                            function createInfoWindow(i){
                                var json = markerArr[i];
                                var iw = new BMap.InfoWindow("<b class='iw_poi_title' title='" + json.title + "'>" + json.title + "</b><div class='iw_poi_content'>"+json.content+"</div>");
                                return iw;
                            }
                            //创建一个Icon
                            function createIcon(json,type){
                                //var icon = BMapLib.MarkerTool.SYS_ICONS[index]; //设置工具样式，使用系统提供的样式BMapLib.MarkerTool.SYS_ICONS[0] -- BMapLib.MarkerTool.SYS_ICONS[23]
                                var icon = new BMap.Icon("http://map.baidu.com/image/us_mk_icon.png", new BMap.Size(json.w,json.h),{imageOffset: new BMap.Size(-json.l,-json.t),infoWindowOffset:new BMap.Size(json.lb+5,1),offset:new BMap.Size(json.x,json.h)})
                                //var icon = new BMap.Icon(url, new BMap.Size(json.w,json.h),{imageOffset: new BMap.Size(-json.l,-json.t),infoWindowOffset:new BMap.Size(json.lb+5,1),offset:new BMap.Size(json.x,json.h)})
                                return icon;
                            }

                            //标注线数组
                            var plPoints = [{style:"solid",weight:4,color:"#f00",opacity:0.6,points:["121.383679|31.163464","121.388709|31.162908","121.391404|31.162629","121.393812|31.162908","121.397315|31.164043"]}
                                ,{style:"solid",weight:4,color:"#f00",opacity:0.6,points:["121.397333|31.164051","121.401106|31.16538","121.405418|31.166554","121.409226|31.168099","121.414437|31.155275","121.416296|31.150832"]}
                                ,{style:"solid",weight:4,color:"#f00",opacity:0.6,points:["121.416305|31.150917","121.415874|31.15067","121.415694|31.150516","121.416233|31.149063","121.416413|31.14829","121.416089|31.147672","121.414796|31.146436","121.410664|31.144674","121.408939|31.143593","121.406738|31.149844","121.408104|31.145826"]}
                                ,{style:"solid",weight:4,color:"#f00",opacity:0.6,points:["121.406882|31.149967","121.402723|31.147301","121.397944|31.146096","121.399848|31.138771","121.399776|31.138957"]}
                                ,{style:"solid",weight:4,color:"#f00",opacity:0.6,points:["121.399848|31.13874","121.400746|31.135247","121.399848|31.135155","121.396255|31.134196","121.396345|31.134212"]}
                                ,{style:"solid",weight:4,color:"#f00",opacity:0.6,points:["121.396381|31.134227","121.391961|31.13313"]}
                                ,{style:"solid",weight:4,color:"#f00",opacity:0.6,points:["121.391907|31.133161","121.390075|31.136499","121.38844|31.139636","121.388458|31.139636"]}
                                ,{style:"solid",weight:4,color:"#f00",opacity:0.6,points:["121.388422|31.139621","121.388206|31.140332","121.388026|31.143206","121.387119|31.153243"]}
                                ,{style:"solid",weight:4,color:"#f00",opacity:0.6,points:["121.387191|31.152996","121.385538|31.159547","121.383454|31.163379","121.383382|31.163503"]}
                            ];
                            //向地图中添加线函数
                            function addPolyline(){
                                for(var i=0;i<plPoints.length;i++){
                                    var json = plPoints[i];
                                    var points = [];
                                    for(var j=0;j<json.points.length;j++){
                                        var p1 = json.points[j].split("|")[0];
                                        var p2 = json.points[j].split("|")[1];
                                        points.push(new BMap.Point(p1,p2));
                                    }
                                    var line = new BMap.Polyline(points,{strokeStyle:json.style,strokeWeight:json.weight,strokeColor:json.color,strokeOpacity:json.opacity});
                                    map.addOverlay(line);
                                }
                            }
                            //向地图㕜添加多边形覆盖层
                            function addPolygon(){
                                var polygon1 = new BMap.Polygon([
                                    new BMap.Point(121.39895, 31.142086),
                                    new BMap.Point(121.400746, 31.135317),
                                    new BMap.Point(121.391763, 31.133091),
                                    new BMap.Point(121.38835, 31.139644)

                                ], { strokeColor: getRandomColor(), strokeWeight: 3, strokeOpacity: 0.8, fillOpacity: 0.1,fillColor:getRandomColor()});
                                map.addOverlay(polygon1);
                                //


                                // var markerArr = [{title:"我的标记",content:"我的备注",point:"121.391763,31.133091",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5}}
                                //     ,{title:"我的标记",content:"我的备注",point:"121.38835|31.139644",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5}}
                                //     ,{title:"我的标记",content:"我的备注",point:"121.38799|31.143137",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5}}
                                //     ,{title:"我的标记",content:"我的备注",point:"121.391009|31.143631",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5}}
                                //     ,{title:"我的标记",content:"我的备注",point:"121.398016|31.14598",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5}}
                                //     ,{title:"我的标记",content:"我的备注",point:"121.391009|31.143631",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5}}
                                // ];
                                // var tagMarkerIcon = new BMap.Icon("http://api.map.baidu.com/img/markers.png", new BMap.Size(23, 25), {
                                //     imageOffset: new BMap.Size(0, 0 - 13 * 25) // 设置图片偏移
                                // });

                                // var marker1 = new BMap.Marker(new BMap.Point(121.38799, 31.160072), { icon: tagMarkerIcon });
                                // var label1 = new BMap.Label("第一区域", { offset: new BMap.Size(-15, 2) });
                                // label1.setStyle({
                                //     color: "red",
                                //     fontSize: "9px",
                                //     backgroundColor: "0.05",
                                //     border: "0",
                                //     fontWeight: "bold"
                                // });
                                // marker1.setLabel(label1);
                            }
                            function getRandomColor() {
                                return "#" + ("00000" + ((Math.random() * 16777215 + 0.5) >> 0).toString(16)).slice(-6);
                            }
                            initMap();//创建和初始化地图
                        </script>
                    <#--<img src="/static/img/map/gumei_9.jpg" id="ditu">-->
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-6">
            <div class="row">
                <div class="col-lg-6 box text">
                    <div class="zz"></div>
                    <p style="text-align: center;" id="ttt"><span class="title">街道人口总数：</span><span class="number">16万</span><span class="title">人</span></p>
                    <p style="text-align: center"><span class="title">60岁及以上老人总数：</span><span class="number">4.1万</span><span class="title">人</span></p>
                    <p style="text-align: center"><span class="title">80岁及以上老人总数：</span><span class="number">5300</span><span class="title">人</span></p>
                </div>
                <div class="col-lg-6" style="position: relative;left: 5px">
                    <div class="row">
                        <div class="col-lg-12  box" style="margin-bottom: 5px">
                            <div class="zz"></div>
                            <div id="oldmanPie" class="tu"></div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12  box">
                            <div class="zz"></div>
                            <div id="zdPie" class="tu"></div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row" style="margin-top: 10px">
                <div class="col-lg-6 box">
                    <div class="zz"></div>
                    <div id="pqBar" class="tu_big"></div>
                </div>
                <div class="col-lg-6 box" style="position: relative;left: 5px">
                    <div class="zz"></div>
                    <div id="statusPie" class="tu_big"></div>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript">
        var tu_w,tu_h,tu_big_w,tu_big_h,text_h;

        if(winWidth>=1900){
            tu_w=winWidth/4.5;
            tu_h=winHeight/5;
            tu_big_w=winWidth/4.5;
            tu_big_h=winHeight/2.2;
            text_h=winHeight/2.46;
        }else if(winWidth<=1400 && winWidth>=1300){
            tu_w=winWidth/4.5;
            tu_h=winHeight/4.1;
            tu_big_w=winWidth/4.5;
            tu_big_h=winHeight/2.2;
            text_h=winHeight/2.02;
        }
        $(".tu").css('width',tu_w);
        $(".tu").css( 'height', tu_h);
        $(".text").css( 'height', text_h);
        $(".tu_big").css('width',tu_big_w);
        $(".tu_big").css( 'height', tu_big_h);
        var pqBar= echarts.init(document.getElementById('pqBar'));
        var statusPie= echarts.init(document.getElementById('statusPie'));
        var oldmanPie=echarts.init(document.getElementById('oldmanPie'));
        var zdPie=echarts.init(document.getElementById('zdPie'));
    </script>
</div>
<#include "../set.ftl" />

</body>
<script>
    //片区人数分布
    legend_data="";
    title_text='片区老年人口分布柱状';
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
                        fontSize:series_lebel_fontSize
                    }
                }
            },
            itemStyle:{
                normal: {
                    color:series_color_1,
                    fontSize:series_item_fontSize
                }
            },
            data: [131,163,214,234,334,467]
        }
    ];
    var option_pq_bar=chartBar(title_text,legend_data,yAxis_data,series);

    //养老状态
    title_text="养老状态分布饼图";
    legend_data=[{name:'机构养老',textStyle:{color:legend_color,fontSize:legand_fontSize}},{name:'社区养老',textStyle:{color:legend_color,fontSize:legand_fontSize}},{name:'居家养老',textStyle:{color:legend_color,fontSize:legand_fontSize}}];
    series=[{
        name: '老养老状态',
        type: 'pie',
        radius : '45%',
        label : {
            normal : {
                formatter: '{d}%\n({c})',
                textStyle : {
                    fontWeight : 'normal',
                    fontSize : series_lebel_fontSize
                }
            }
        },
        center: ['48%', '60%'],
        data:[
            {value:476, name:'机构养老'},
            {value:376, name:'社区养老'},
            {value:276, name:'居家养老'}
        ],
        itemStyle: {
            emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
        }
    }];
    var option_status_pie = chartPie(title_text,legend_data,series);


    //60岁老人占比
    title_text="老人\n\n比例";
    legend_data=[{name:'老人',textStyle:{color:legend_color,fontSize:legand_fontSize}},{name:'非老人',textStyle:{color:legend_color,fontSize:legand_fontSize}}];
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
                        fontSize : series_lebel_fontSize
                    }
                }
            },
            data:[
                {value:15360, name:'非老人'},
                {value:4310, name:'老人'}
            ]
        }
    ];
    var option_oldman_pie = chartPie(title_text,legend_data,series);

    //重点老人占比
    title_text="80岁及\n\n以上\n\n老人比例";
    legend_data=[{name:'80岁及以上',textStyle:{color:legend_color,fontSize:legand_fontSize}},{name:'80岁以下',textStyle:{color:legend_color,fontSize:legand_fontSize}}];
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
                        fontSize : series_lebel_fontSize
                    }
                }
            },
            data:[
                {value:1360, name:'80岁以下'},
                {value:234, name:'80岁及以上'}
            ]
        }
    ];
    var option_zd_pie = chartPie(title_text,legend_data,series);

    pqBar.setOption(option_pq_bar);
    statusPie.setOption(option_status_pie);
    oldmanPie.setOption(option_oldman_pie);
    zdPie.setOption(option_zd_pie);
</script>
</html>