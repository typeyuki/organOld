<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <#include "../common/head.ftl" />
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
                    <h5>机构服务情况<small></small></h5>
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
                        <form action="/organ/record/importExcel" method="post" enctype="multipart/form-data" id="importForm">
                            <input type="hidden" name="organId" value="${organId!0}">
                            <input type="file" name="file" style="display:inline">
                            <input type="button" style="display:inline" class="btn btn-primary" onclick="$('.wrapper').hide();$('#process').show();$('#importForm').submit()" value="导入">
                        </form>
                    </div>
                    <div>
                        <input class="id" type="text" placeholder="序号">
                        <input class="id" type="text" placeholder="模糊搜索">
                        <button id="search">搜索</button>
                    </div>
                    <table class="table table-striped table-bordered table-hover dataTables-example">
                        <thead>
                        <tr>
                            <th>序号</th>
                            <th>老人</th>
                            <th>时间</th>
                            <th>内容</th>
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
<#include  "../spinner.ftl"/>
<#--<#include "add_product.ftl" />-->
<script>
    var organId=${organId!0};
    <#if result??>
    alert("录入数据：${result.data.total}\n其中成功导入数据：${result.data.numSuccess}\n包括添加：${result.data.successAdd}\n更新：${result.data.successUpdate}\n删除：${result.data.successDel}\n失败：${result.data.numFail}");
    </#if>
</script>
<script src="/js/content.min.js?v=1.0.0"></script>
<script src="/static/js/organ/organ_service_record.js" ></script>
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>

</body>

</html>