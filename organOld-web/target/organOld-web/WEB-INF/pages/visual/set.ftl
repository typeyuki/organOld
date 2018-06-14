<style>
    nav ul,nav li{
        float: none!important;
    }
    nav{
        text-align: center;
    }
</style>

<div class="small-chat-box fadeInRight animated">

    <div class="content">
        <nav class="navbar navbar-default" role="navigation">
        <div>
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <ul class="dropdown-menu">
                        <li>
                            <a href="/visual/oldman">老人汇总</a>
                        </li>
                        <li>
                            <a href="/visual/label">标签汇总</a>
                        </li>
                        <li>
                            <a href="/visual/lookOldman">重点老人</a>
                        </li>
                    </ul>
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">导航</a>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">设置</a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="#">老人汇总</a>
                        </li>
                        <#if label??>
                            <li>
                                <a href="#">标签单选or多选</a>
                            </li>
                            <li>
                                <a href="#">重置标签</a>
                            </li>
                        </#if>
                    </ul>
                </li>
            </ul>
        </div>
        </nav>
    </div>

</div>
<div id="small-chat">
    <a class="open-small-chat">
        <i class="fa fa-comments"></i>
    </a>
</div>
<script>
    $(".open-small-chat").click(function(){$(this).children().toggleClass("fa-comments").toggleClass("fa-remove"),$(".small-chat-box").toggleClass("active")})
</script>
<script src="/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="/js/plugins/layer/layer.min.js"></script>
<script src="/js/hplus.min.js?v=4.0.0"></script>
<script type="text/javascript" src="/js/contabs.min.js"></script>
<script src="/js/plugins/pace/pace.min.js"></script>