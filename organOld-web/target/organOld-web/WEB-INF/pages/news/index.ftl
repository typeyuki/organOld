<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <#include "../common/head.ftl" />
    <#--<link href="/css/animate.min.css" rel="stylesheet">-->
    <link href="/css/style.min.css?v=4.0.0" rel="stylesheet"><base target="_blank">
    <link href="/static/css/common_table.css" rel="stylesheet">
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>资讯 <small>新闻动态</small></h5>
                    <div class="ibox-tools">
                        <a class="collapse-link">
                            <i class="fa fa-chevron-up"></i>
                        </a>
                        <a class="close-link">
                            <i class="fa fa-times"></i>
                        </a>
                    </div>
                </div>
                <div class="ibox-content">
                    <div>
                        <input class="id" type="text" placeholder="序号">
                        <input class="title" type="text" placeholder="标题">
                        <input class="author" type="text" placeholder="作者">
                        <input class="isTop" type="text" placeholder="是否置顶">
                        <input class="time" type="text" placeholder="发布时间">
                        <button id="search">搜索</button>
                    </div>
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered table-hover dataTables-example text-nowrap">
                            <thead>
                            <tr>
                                <th>序号</th>
                                <th>标题</th>
                                <th>作者</th>
                                <th>是否置顶</th>
                                <th>发布时间</th>
                                <th></th>
                            </tr>
                            </thead>
                            <tbody>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

<#--<script src="/js/plugins/jeditable/jquery.jeditable.js"></script>-->

<script src="/js/content.min.js?v=1.0.0"></script>
<script src="/static/js/news/index.js" ></script>
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>

</body>

</html>