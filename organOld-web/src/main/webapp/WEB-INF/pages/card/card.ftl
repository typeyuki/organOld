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
                    <h5>一卡通 <small>信息</small></h5>
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
                        <a onclick="$('#addModal').modal()" href="javascript:void(0);" class="btn btn-primary ">充钱</a>
                        <a onclick="changeStatus('3')" href="javascript:void(0);" class="btn btn-primary ">设置为不可用</a>
                        <a onclick="changeStatus('1')" href="javascript:void(0);" class="btn btn-primary ">设置为可用</a>
                        <a onclick="changeStatus('2')" href="javascript:void(0);" class="btn btn-primary ">挂失</a>
                        <a  href="javascript:void(0);" id="search" class="btn btn-primary ">搜索</a>
                    </div>
                    <div>
                        <input class="id" type="text" placeholder="老人序号">
                        <input class="time" type="text" placeholder="状态">
                        <input class="time" type="text" placeholder="模糊">
                        <button id="search">搜索</button>
                    </div>
                    <table class="table table-striped table-bordered table-hover dataTables-example">
                        <thead>
                        <tr>
                            <th><input type='checkbox' onclick="thCheck(this)"/></th>
                            <th>卡号</th>
                            <th>老人</th>
                            <th>密码</th>
                            <th>金额</th>
                            <th>状态</th>
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

<script src="/js/content.min.js?v=1.0.0"></script>
<script src="/static/js/common.js"></script>

<#include "add_money.ftl"/>
<script src="/static/js/card/card.js" ></script>
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>

</body>

</html>