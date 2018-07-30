<style>
    @media only screen and (min-width: 6000px){
        #news p{
            font-size: 30px;
        }
        #news img{
            padding-top: 30px;
        }
        .newsp{
            margin-top: 60px;
        }
    }
</style>
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
        <p class="newsp" style="text-indent:2em"> 三伏天里，骄阳似火，热浪袭人。7月27日，古美路街道党工委书记张伟麟、党工委副书记张建刚、总工会主席吴栋等一行走访慰问在高温酷暑下坚守岗位的一线工作者，送上防暑降温用品，代表街道党工委、办事处和总工会对他们表示感谢和敬意。</p>
    </div>
</div>

<script>
    $("#myCarousel").carousel('cycle');
    $("#news").css("height",winHeight/5.2);
    $("#news img").css("height",winHeight/5.7);
    $("#news img").css("width",winWidth/8.8);
</script>