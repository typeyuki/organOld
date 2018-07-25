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
                    <h5>${typeName} <small></small></h5>
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
                        <#list autoValue as list>
                            <#if list.index!=9 && list.index!=10>
                                <button onclick=location.href="/autoValue/${list.index}" class="btn btn-primary auto" index="${list.index}" >${list.getName()}</button>

                            </#if>
                        </#list>
                    </div>
                    <div>
                        <a href="javascript:void(0);" class="btn btn-primary " onclick="add()">添加</a>
                        <a onclick="del('/autoValue/del')"  href="javascript:void(0);" class="btn btn-primary ">删除</a>
                    </div>
                    <table class="table table-striped table-bordered table-hover dataTables-example">
                        <thead>
                        <tr>
                            <th><input type="checkbox" onclick="thCheck(this)" ></th>
                            <th>序号</th>
                            <th>名称</th>
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
<#include "add_auto_value.ftl"/>
<script>
    var type=${type!0};
    $(".auto").each(function () {
        if($(this).attr("index")==type){
            $(this).prop("disabled",true);
        }
    });
    $('.search_select').searchableSelect();
</script>
<script src="/js/content.min.js?v=1.0.0"></script>
<script src="/static/js/common.js"></script>
<script src="/static/js/oldman/auto_value.js" ></script>
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>

</body>

</html>