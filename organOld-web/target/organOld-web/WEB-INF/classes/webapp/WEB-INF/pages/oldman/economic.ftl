<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <#include "../common/head.ftl" />

<#--<link href="/css/animate.min.css" rel="stylesheet">-->
    <link href="/css/style.min.css?v=4.0.0" rel="stylesheet">
    <link href="/static/css/common_table.css" rel="stylesheet">
    <link href="/static/css/oldman/base.css" rel="stylesheet">
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>经济条件 <small>信息</small></h5>
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
                        <a onclick="" href="javascript:void(0);" class="btn btn-primary ">添加</a>
                    </div>
                    <div>
                        <input class="id" type="text" placeholder="序号">
                        <input class="id" type="text" placeholder="老人序号">
                        <input class="id" type="text" placeholder="经济索引号">
                        <input class="time" type="text" placeholder="模糊匹配">
                        <button id="search">搜索</button>
                        <#--<form action="/importExcel" method="post" enctype="multipart/form-data">-->
                            <#--<input type="file" name="file">-->
                            <#--<input type="hidden" name="pType" value="oldman">-->
                            <#--<input type="hidden" name="cType" value="base">-->
                            <#--<input type="submit" value="导入">-->
                        <#--</form>-->
                    </div>
                    <table class="table table-striped table-bordered table-hover dataTables-example">
                        <thead>
                        <tr>
                            <th>序号</th>
                            <th>老人序号</th>
                            <th>经济索引号</th>
                            <th>更新时间</th>
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

<#--<script src="/js/plugins/jeditable/jquery.jeditable.js"></script>-->

<script src="/js/content.min.js?v=1.0.0"></script>
<script src="/static/js/oldman/economic.js" ></script>
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>

</body>

</html>