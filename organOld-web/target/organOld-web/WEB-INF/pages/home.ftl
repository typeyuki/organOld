<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title>古美路街道综合为老服务平台</title>
    <#include "common/head.ftl" />
    <!--[if lt IE 8]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->

    <link rel="shortcut icon" href="favicon.ico">
    <#--<link href="/css/bootstrap.min.css?v=3.3.5" rel="stylesheet">-->
    <#--<link href="http://fontawesome.io/assets/font-awesome/css/font-awesome.css" rel="stylesheet">-->
    <link href="/css/animate.min.css" rel="stylesheet">
    <link href="/css/style.min.css?v=4.0.0" rel="stylesheet">
</head>

<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
<div id="wrapper">
    <!--左侧导航开始-->
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="nav-close"><i class="fa fa-times-circle"></i>
        </div>
        <div class="sidebar-collapse">
            <ul class="nav" id="side-menu">
                <li class="nav-header">
                    <div class="dropdown profile-element">
                        <span><img alt="image" class="img-circle" src="img/profile_small.jpg" /></span>
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <span class="clear">
                               <#--<span class="block m-t-xs"><strong class="font-bold">Beaut-zihan</strong></span>-->
                                <span class="text-muted text-xs block">超级管理员</span>
                                </span>
                        </a>
                    </div>
                    <div class="logo-element">H+
                    </div>
                </li>
                <#list menus! as menu>
                    <li>

                            <#if (menu.children)??  && (menu.children)?size gt 0>
                            <a href="#">
                                <i class="fa ${menu.icon}"></i>
                                <span class="nav-label">${menu.name}</span>
                                <span class="fa arrow"></span>
                            </a>
                            <#else >
                            <a class="J_menuItem" href="${menu.url}">
                                <i class="fa ${menu.icon}"></i>
                                <span class="nav-label">${menu.name}</span>
                                <#if menu.url?contains("message")>
                                <span class="label label-warning pull-right">${messageNum!0}</span>
                                </#if>
                            </a>
                            </#if>
                        <#if (menu.children)??  && (menu.children)?size gt 0>
                        <ul class="nav nav-second-level">
                            <#list menu.children as child>
                                <li>
                                    <a ${(((child.url)?contains('visual')) || ((child.children)?? && (child.children)?size>0))?string('','class="J_menuItem"')} href="${((child.children)?? && (child.children)?size>0)?string('#',child.url)}" ${((child_index==0) && !(child.url)?contains('visual'))?string('data-index="0"','')} ${((child.url)?contains('visual'))?string('target="_bank"','')}>${child.name}
                                    <#if (child.children)?? && (child.children)?size gt 0><span class="fa arrow"></span></#if>
                                    </a>
                                    <#if (child.children)?? && (child.children)?size &gt;0>
                                        <ul class="nav nav-third-level">
                                            <#list child.children as grandson>
                                                <li><a class="J_menuItem" href="${grandson.url}">${grandson.name}</a></li>
                                            </#list>
                                        </ul>
                                    </#if>
                                </li>
                            </#list>
                        </ul>
                        </#if>
                    </li>
                </#list>
            </ul>
        </div>
    </nav>
    <!--左侧导航结束-->
    <!--右侧部分开始-->
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <div class="row border-bottom">
            <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header"><a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i> </a>
                    <form role="search" class="navbar-form-custom" method="post" action="search_results.html">
                        <div class="form-group">
                            <input type="text" placeholder="请输入您需要查找的内容 …" class="form-control" name="top-search" id="top-search">
                        </div>
                    </form>
                </div>
            </nav>
        </div>
        <div class="row content-tabs">
            <button class="roll-nav roll-left J_tabLeft"><i class="fa fa-backward"></i>
            </button>
            <nav class="page-tabs J_menuTabs">
                <div class="page-tabs-content">
                    <a href="javascript:0" class="active J_menuTab" data-id="/message">消息中心</a>
                </div>
            </nav>
            <button class="roll-nav roll-right J_tabRight"><i class="fa fa-forward"></i>
            </button>
            <div class="btn-group roll-nav roll-right">
                <button class="dropdown J_tabClose" data-toggle="dropdown">关闭操作<span class="caret"></span>

                </button>
                <ul role="menu" class="dropdown-menu dropdown-menu-right">
                    <li class="J_tabShowActive"><a>定位当前选项卡</a>
                    </li>
                    <li class="divider"></li>
                    <li class="J_tabCloseAll"><a>关闭全部选项卡</a>
                    </li>
                    <li class="J_tabCloseOther"><a>关闭其他选项卡</a>
                    </li>
                </ul>
            </div>
            <a href="login.html" class="roll-nav roll-right J_tabExit"><i class="fa fa fa-sign-out"></i> 退出</a>
        </div>
        <div class="row J_mainContent" id="content-main">
            <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="/message" frameborder="0" data-id="/message" seamless></iframe>
        </div>
        <div class="footer">
        </div>
    </div>
    <!--右侧部分结束-->
    <!--右侧边栏开始-->
    <!--右侧边栏结束-->


</div>

<script src="/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="/js/plugins/layer/layer.min.js"></script>
<script src="/js/hplus.min.js?v=4.0.0"></script>
<script type="text/javascript" src="/js/contabs.min.js"></script>
<script src="/js/plugins/pace/pace.min.js"></script>
</body>

</html>