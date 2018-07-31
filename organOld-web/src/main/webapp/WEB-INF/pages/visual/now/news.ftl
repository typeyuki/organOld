<style>
    @media only screen and (min-width: 6000px){
        #news p{
            font-size: 38px;
        }
        #news img{
            padding-top: 30px;
        }
        .newsp{
            margin-top: 40px;
        }
        #logo{
            margin-top: 20px;
            width: 100px;
            height: 150px;
            display: inline;
        }
        #logo-title{
            margin-top: 40px;
            width: 250px;
            height: 110px;
            display: inline;
        }
    }
</style>
<div class="row">
    <div class="col-lg-1" style="width: 5%"></div>
    <div class="col-lg-4">
        <img src="/static/img/news/logo.png" id="logo" >
        <img src="/static/img/news/logo_title.png"  id="logo-title">
    </div>
    <#--<div class="col-lg-4">-->
        <#--<img src="/static/img/news/logo_title.png"  id="logo-title">-->
    <#--</div>-->
</div>
<div class="row" id="news">
    <div class="col-lg-1" style="width: 3%"></div>
    <div class="col-lg-6" align="center" id="community">
            <div id="myCarousel" class="carousel slide">
                <!-- 轮播（Carousel）指标 -->
                <ol class="carousel-indicators">
                    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                    <li data-target="#myCarousel" data-slide-to="1"></li>
                    <li data-target="#myCarousel" data-slide-to="2"></li>
                </ol>
                <!-- 轮播（Carousel）项目 -->
                <div class="carousel-inner">
                    <div class="item active">
                        <img src="/static/img/news/1.jpg" alt="First slide" >
                    </div>
                    <div class="item">
                        <img src="/static/img/news/2.jpg" alt="Second slide" >
                    </div>
                    <div class="item">
                        <img src="/static/img/news/3.jpg" alt="Third slide" >
                    </div>
                </div>
                <!-- 轮播（Carousel）导航 -->
                <a class="carousel-control left" href="#myCarousel"
                   data-slide="prev">
                </a>
                <a class="carousel-control right" href="#myCarousel"
                   data-slide="next">
                </a>
            </div>
    </div>
    <div class="col-lg-5">
        <p class="newsp p1" style="text-indent:2em"> 三伏天里，骄阳似火，热浪袭人。7月27日，古美路街道党工委书记张伟麟、党工委副书记张建刚、总工会主席吴栋等一行走访慰问在高温酷暑下坚守岗位的一线工作者，送上防暑降温用品，代表街道党工委、办事处和总工会对他们表示感谢和敬意。</p>
        <p class="newsp p2" style="text-indent:2em;display: none" >张伟麟书记一行来到街道机关值班室、食堂和门岗间，与值班人员、门卫保安和食堂工作人员逐一握手致敬，叮嘱大家一定要劳逸结合，合理调整高温时期的作息时间，注意防暑降温，确保工作安全。</p>
        <p class="newsp p3" style="text-indent:2em;display: none">“天气这么热，大家辛苦了！”在合川路，张伟麟书记一行慰问了坚守一线岗位的环卫工人和公厕管理员，仔细询问了大家的作息安排，叮嘱大家在认真工作的同时一定要保重身体，注意防暑和休息。</p>
    </div>
</div>

<script>
    $("#myCarousel").carousel('cycle');
    $("#news").css("height",winHeight/4);
    $("#news img").css("height",winHeight/4.5);
    $("#news img").css("width",winWidth/8);

    var i=1;
    $('#myCarousel').on('slide.bs.carousel', function () {
        $(".newsp").hide();
        $(".p"+i).show();
        i++;
        if(i==4)
            i=1;
    });
</script>