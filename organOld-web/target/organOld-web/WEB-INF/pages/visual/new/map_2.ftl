<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<#include "../head.ftl" />

<link href="/static/css/visual/five1.css" rel="stylesheet"/>
</head>

<body>
<#include "../set.ftl" />


<div class="container-fluid">
    <div class="row">
        <div class="col-lg-4" id="label1" >
            <div class="row" align="center">
                <div class="block">
                    <div class="row" style="">
                        <div class="col-lg-12">
                            <button class="btn-success btn-lg daohang" onclick="daohang(1)">老 有 所 养</button>
                        </div>
                    </div>
                    <div class="row" style="">
                        <div class="col-lg-12">
                            <button class="btn-success btn-lg daohang" onclick="daohang(2)">老 有 所 医</button>
                        </div>
                    </div>
                    <div class="row" style="">
                        <div class="col-lg-12">
                            <button class="btn-success btn-lg daohang" onclick="daohang(3)">老 有 所 为</button>
                        </div>
                    </div>
                    <div class="row" style="">
                        <div class="col-lg-12">
                            <button class="btn-success btn-lg daohang" onclick="daohang(4)">老 有 所 学</button>
                        </div>
                    </div>
                    <div class="row" style="">
                        <div class="col-lg-12">
                            <button class="btn-success btn-lg daohang" onclick="daohang(5)">老 有 所 乐</button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="row" align="center">
                        <div class="col-lg-12">
                            <button class="qk" onclick=location.href='/visual/new/five2'>切换</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-1"></div>
        <div class="col-lg-7 diturela">
            <div class="row diturow" align="center">
                <div class="col-lg-8">
                    <p class="map_title">古美路街道机构分布图2</p>
                    <style type="text/css">
                        /*html,body{margin:0;padding:0;}*/
                        .iw_poi_title {color:#CC5522;font-size:14px;font-weight:bold;overflow:hidden;padding-right:13px;white-space:nowrap}
                        .iw_poi_content {font:12px arial,sans-serif;overflow:visible;padding-top:4px;white-space:-moz-pre-wrap;word-wrap:break-word}
                    </style>
                    <script type="text/javascript" src="http://api.map.baidu.com/api?key=&v=1.1&services=true"></script>
                    <script type="text/javascript" src="http://api.map.baidu.com/library/GeoUtils/1.2/docs/symbols/BMapLib.html"></script>
                    <script type="text/javascript" src="http://api.map.baidu.com/library/GeoUtils/1.2/docs/symbols/src/BMapLib_GeoUtils.js.html"></script>

                    <div class="col-lg-7" style="width:600px;height:500px;border:#ccc solid 1px;" id="dituContent"></div>
                    <script type="text/javascript">
                        //创建和初始化地图函数：
                        function initMap(){
                            createMap();//创建地图
                            setMapEvent();//设置地图事件
                            addMapControl();//向地图添加控件
                            addPolyline();//向地图中添加线
                            addMarker();//向地图中添加标注
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
                        //标注点数组
                        var markerArr = [{title:"养老院A",content:"养老院A",point:"121.385888|31.162065",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5}}
                            ,{title:"养老院B",content:"养老院B",point:"121.400297|31.162065",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5}}
                            ,{title:"养老院C",content:"养老院C",point:"121.409783|31.158419",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5}}
                            ,{title:"长者照护之家A",content:"长者照护之家A",point:"121.408562|31.166948",isOpen:0,icon:{w:21,h:21,l:6,t:0,x:6,lb:5}}
                            ,{title:"长者照护之家B",content:"长者照护之家B",point:"121.409999|31.152424",isOpen:0,icon:{w:21,h:21,l:6,t:0,x:6,lb:5}}
                            ,{title:"长者照护之家C",content:"长者照护之家C",point:"121.388008|31.157801",isOpen:0,icon:{w:21,h:21,l:6,t:0,x:6,lb:5}}
                            ,{title:"日照中心A",content:"日照中心A",point:"121.388943|31.153227",isOpen:0,icon:{w:21,h:21,l:23,t:0,x:6,lb:5}}
                            ,{title:"日照中心B",content:"日照中心B",point:"121.393973|31.161015",isOpen:0,icon:{w:21,h:21,l:23,t:0,x:6,lb:5}}
                            ,{title:"日照中心C",content:"日照中心C",point:"121.396488|31.157739",isOpen:0,icon:{w:21,h:21,l:23,t:0,x:6,lb:5}}
                            ,{title:"助餐点A",content:"助餐点A",point:"121.396776|31.153567",isOpen:0,icon:{w:21,h:21,l:69,t:0,x:6,lb:5}}
                            ,{title:"助餐点B",content:"助餐点B",point:"121.38923|31.151064",isOpen:0,icon:{w:21,h:21,l:69,t:0,x:6,lb:5}}
                            ,{title:"助餐点C",content:"助餐点C",point:"121.390021|31.141792",isOpen:0,icon:{w:21,h:21,l:69,t:0,x:6,lb:5}}
                            ,{title:"社区卫生站A",content:"社区卫生站A",point:"121.389374|31.148221",isOpen:0,icon:{w:21,h:21,l:92,t:0,x:6,lb:5}}
                            ,{title:"社区卫生站B",content:"社区卫生站B",point:"121.402022|31.147788",isOpen:0,icon:{w:21,h:21,l:92,t:0,x:6,lb:5}}
                            ,{title:"老年人学校A",content:"老年人学校A",point:"121.394836|31.139258",isOpen:0,icon:{w:23,h:25,l:0,t:21,x:9,lb:12}}
                            ,{title:"社区医院A",content:"社区医院A",point:"121.409927|31.146861",isOpen:0,icon:{w:23,h:25,l:46,t:21,x:9,lb:12}}
                        ];
                        //创建marker
                        function addMarker(){
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
                        }
                        //创建InfoWindow
                        function createInfoWindow(i){
                            var json = markerArr[i];
                            var iw = new BMap.InfoWindow("<b class='iw_poi_title' title='" + json.title + "'>" + json.title + "</b><div class='iw_poi_content'>"+json.content+"</div>");
                            return iw;
                        }
                        //创建一个Icon
                        function createIcon(json){
                            var icon = new BMap.Icon("http://map.baidu.com/image/us_mk_icon.png", new BMap.Size(json.w,json.h),{imageOffset: new BMap.Size(-json.l,-json.t),infoWindowOffset:new BMap.Size(json.lb+5,1),offset:new BMap.Size(json.x,json.h)})

                            //var icon = new BMap.Icon("http://app.baidu.com/map/image/us_mk_icon.png", new BMap.Size(json.w,json.h),{imageOffset: new BMap.Size(-json.l,-json.t),infoWindowOffset:new BMap.Size(json.lb+5,1),offset:new BMap.Size(json.x,json.h)})
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

                        initMap();//创建和初始化地图
                    </script>
                    <#--<img src="/static/img/map/gm.jpg" id="ditu" usemap="planetmap">-->
                    <#--<map name="planetmap" id="planetmap">-->
                        <#--<area shape="rect" coords="40,40,120,120" onclick="changeMess('ylg_2')" alt="Venus" />-->
                        <#--<area shape="rect" coords="0,0,230,230" onclick="changeMess('ylg_1')" alt="Mercury" />-->
                    <#--</map>-->
                </div>
                <div class="col-lg-2">
                    <div>
                        <button class="ditulabel" style="border-radius: 100%;background-color: #0d8ddb;border: none"></button><span class="dituspan">养老院</span>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-1"></div>
                <div class="col-lg-10 box ditumess">
                    <div class="zz"></div>
                    <div class="col-lg-1"></div>
                    <div class="col-lg-4" align="left">
                        <img src="/static/img/map/timg.jpg" id="messimg">
                    </div>
                    <div class="col-lg-6">
                        <p class="mt"><span class="title">名称：</span><span class="number" id="messName">养老院</span></p>
                        <p ><span class="title">地址：</span><span class="number" id="messAddress">东426号</span></p>
                        <p ><span class="title">联系方式：</span><span class="number" id="messPhone">1543563421  王主任</span></p>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>

</body>

<script>
    function daohang(index) {
        if(index==2)
            $("#ditu").attr("src","/static/img/map/gm_"+index+".jpg");
        else
            $("#ditu").attr("src","/static/img/map/gm.jpg");
    }
    function changeMess(data) {
        //alert("1");
        var type=data.split("_")[0];
        var index=data.split("_")[1];
        if(type=="ylg"){
            if(1==index){
                $("#messName").text("B养老院");
                $("#messAddress").text("东兰路426号");
                $("#messPhone").text("15874562121  李主任");
                $("#messimg").attr("src","/static/img/map/timg.jpg");
            }
            if(2==index){
                $("#messName").text("A养老院");
                $("#messAddress").text("古美路426号");
                $("#messPhone").text("15874562121  李主任");
                $("#messimg").attr("src","/static/img/map/timg_1.jpg");
            }
        }
    }
</script>
</html>