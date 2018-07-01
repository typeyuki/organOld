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
                    <h5>老人 <small>基本信息</small></h5>
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
                        <a onclick="" href="javascript:void(0);" class="btn btn-primary ">删除</a>
                    </div>
                    <div>
                        <input class="id" type="text" placeholder="序号">
                        <input class="sex" type="text" placeholder="性别">
                        <input class="sex" type="text" placeholder="户籍">
                        <input class="sex" type="text" placeholder="政治面貌">
                        <input class="age" type="text" placeholder="年龄段">
                        <input class="age" type="text" placeholder="片区">
                        <input class="age" type="text" placeholder="居委">
                        <input class="time" type="text" placeholder="模糊匹配">
                        <button id="search">搜索</button>
                        <form action="/importExcel" method="post" enctype="multipart/form-data">
                            <input type="file" name="file">
                            <input type="hidden" name="pType" value="oldman">
                            <input type="hidden" name="cType" value="base">
                            <input type="submit" value="导入">
                        </form>
                    </div>
                    <table class="table table-striped table-bordered table-hover dataTables-example">
                        <thead>
                        <tr>
                            <th><input type='checkbox' /></th>
                            <th>序号</th>
                            <th>片区</th>
                            <th>居委</th>
                            <th>小区</th>
                            <th>楼号</th>
                            <th>姓名</th>
                            <th>性别</th>
                            <th>年龄</th>
                            <th>政治面貌</th>
                            <th>户籍</th>
                            <th>电话</th>
                            <th>地址</th>
                            <th>身份证号码</th>
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
<script src="/static/js/common.js" ></script>
<script src="/static/js/oldman/base.js" ></script>
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>

</body>

</html>