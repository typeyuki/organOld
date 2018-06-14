 <!DOCTYPE html>
<html>

<head>
<#include "../head.ftl" />
<link href="/static/css/visual/five1.css" rel="stylesheet">
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
                    <p class="map_title">古美路街道机构分布图</p>
                    <img src="/static/img/map/gm.jpg" id="ditu" usemap="planetmap">
                    <map name="planetmap" id="planetmap">
                        <area shape="rect" coords="40,40,120,120" onclick="changeMess('ylg_2')" alt="Venus" />
                        <area shape="rect" coords="0,0,230,230" onclick="changeMess('ylg_1')" alt="Mercury" />
                    </map>
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