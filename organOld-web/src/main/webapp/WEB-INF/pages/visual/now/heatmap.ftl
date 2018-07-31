<div id="container" style="display: none;width:1100px;height:1200px;border:#ccc solid 1px;" class="col-lg-15" ></div>
    <script type="text/javascript">
        var hmap = new BMap.Map("container");          // 创建地图实例

        var hpoint = new BMap.Point(121.404295,31.151234);
        hmap.centerAndZoom(hpoint, 16);             // 初始化地图，设置中心点坐标和地图级别
        hmap.enableScrollWheelZoom(); // 允许滚轮缩放

        var hpoints =[

            {"lng":"121.385888","lat":"31.162065","count":"1300"},
            {"lng":"121.388008","lat":"31.157801","count":"275"},
            {"lng":"121.389374","lat":"31.148221","count":"70"},
        ];


        if(!isSupportCanvas()){
            alert('热力图目前只支持有canvas支持的浏览器,您所使用的浏览器不能使用热力图功能~')
        }
        //详细的参数,可以查看heatmap.js的文档 https://github.com/pa7/heatmap.js/blob/master/README.md
        //参数说明如下:
        /* visible 热力图是否显示,默认为true
         * opacity 热力的透明度,1-100
         * radius 势力图的每个点的半径大小
         * gradient  {JSON} 热力图的渐变区间 . gradient如下所示
         *  {
                .2:'rgb(0, 255, 255)',
                .5:'rgb(0, 110, 255)',
                .8:'rgb(100, 0, 255)'
            }
            其中 key 表示插值的位置, 0~1.
                value 为颜色值.
         */
        heatmapOverlay = new BMapLib.HeatmapOverlay({"radius":20});
        hmap.addOverlay(heatmapOverlay);
        heatmapOverlay.setDataSet({data:hpoints,max:100});

        closeHeatmap();

        //判断浏览区是否支持canvas
        function isSupportCanvas(){
            var elem = document.createElement('canvas');
            return !!(elem.getContext && elem.getContext('2d'));
        }

        function setGradient(){
            /*格式如下所示:
            {
                0:'rgb(102, 255, 0)',
                .5:'rgb(255, 170, 0)',
                1:'rgb(255, 0, 0)'
            }*/
            var gradient = {};
            var colors = document.querySelectorAll("input[type='color']");
            colors = [].slice.call(colors,0);
            colors.forEach(function(ele){
                gradient[ele.getAttribute("data-key")] = ele.value;
            });
            heatmapOverlay.setOptions({"gradient":gradient});
        }
        heatmapOverlay.show();

        function setGradient(){
            /*格式如下所示:
            {
                0:'rgb(102, 255, 0)',
                .5:'rgb(255, 170, 0)',
                1:'rgb(255, 0, 0)'
            }*/
            var gradient = {};
            var colors = document.querySelectorAll("input[type='color']");
            colors = [].slice.call(colors,0);
            colors.forEach(function(ele){
                gradient[ele.getAttribute("data-key")] = ele.value;
            });
            heatmapOverlay.setOptions({"gradient":gradient});
        }

        function openHeatmap(){
            heatmapOverlay.show();
        }

        function closeHeatmap(){
            heatmapOverlay.hide();
        }
        addPolygon();//多边形覆盖物
        addPolyline();//向地图中添加线
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
                hmap.addOverlay(line);
            }
        }
        //添加多边形
        function addPolygon(){
            var polygon1 = new BMap.Polygon([
                new BMap.Point(121.383679, 31.163464),
                new BMap.Point(121.388709, 31.162908),
                new BMap.Point(121.391404, 31.162629),
                new BMap.Point(121.393812, 31.162908),

                new BMap.Point(121.397315, 31.164043),
                new BMap.Point(121.397333, 31.164051),
                new BMap.Point(121.401106, 31.16538),
                new BMap.Point(121.405418, 31.166554),
                new BMap.Point(121.409226, 31.168099),
                new BMap.Point(121.414437, 31.155275),
                new BMap.Point(121.416296, 31.150832),
                new BMap.Point(121.416305, 31.150917),

                new BMap.Point(121.415874, 31.15067),
                new BMap.Point(121.415694, 31.150516),
                new BMap.Point(121.416233, 31.149063),
                new BMap.Point(121.416413, 31.14829),
                new BMap.Point(121.416089, 31.147672),
                new BMap.Point(121.414796, 31.146436),
                new BMap.Point(121.410664, 31.144674),
                new BMap.Point(121.408939, 31.143593),
                new BMap.Point(121.406738, 31.149844),
                new BMap.Point(121.408104, 31.145826),
                new BMap.Point(121.406882, 31.149967),
                new BMap.Point(121.402723, 31.147301),
                new BMap.Point(121.397944, 31.146096),
                new BMap.Point(121.399848, 31.138771),

                new BMap.Point(121.399776, 31.138957),
                new BMap.Point(121.399848, 31.13874),
                new BMap.Point(121.400746, 31.135247),
                new BMap.Point(121.399848, 31.135155),
                new BMap.Point(121.396255, 31.134196),
                new BMap.Point(121.396345, 31.134212),
                new BMap.Point(121.396381, 31.134227),
                new BMap.Point(121.391961, 31.13313),
                new BMap.Point(121.391907, 31.133161),
                new BMap.Point(121.390075, 31.136499),
                new BMap.Point(121.38844, 31.139636),
                new BMap.Point(121.388458, 31.139636),
                new BMap.Point(121.388422, 31.139621),
                new BMap.Point(121.388206, 31.140332),
                new BMap.Point(121.388026, 31.143206),
                new BMap.Point(121.387119, 31.153243),

                new BMap.Point(121.387191, 31.152996),
                new BMap.Point(121.385538, 31.159547),
                new BMap.Point(121.383454, 31.163379),
                new BMap.Point(121.383382, 31.163503)


            ], { strokeColor: getRandomColor(), strokeWeight: 3, strokeOpacity: 0.5, fillOpacity: 0.1,fillColor:"#EE00EE" });
            hmap.addOverlay(polygon1);
            //
        }
    </script>