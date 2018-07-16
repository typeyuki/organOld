<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <#include "../common/head.ftl" />

    <link href="/css/style.min.css?v=4.0.0" rel="stylesheet">
    <link href="/static/css/common_table.css" rel="stylesheet">
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>养老服务机构 <small>人员</small></h5>
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
                    <#if single??>
                        <div>
                            <a onclick="" href="javascript:void(0);" class="btn btn-primary ">添加</a>
                            <a onclick="" href="javascript:void(0);" class="btn btn-primary ">删除</a>
                        <#if single??>
                            <form action="/organ/man/importExcel" method="post" enctype="multipart/form-data" id="importForm" style="display: inline-block;margin-left: 200px">
                                <input type="file" name="file" style="display:inline">
                                <input type="button" style="display:inline" class="btn btn-primary" onclick="$('.wrapper').hide();$('#process').show();$('#importForm').submit()" value="导入">
                            </form>
                        </#if>
                        </div>
                    </#if>
                    <div>
                        <input class="id" type="text" placeholder="老人序号">
                        <input class="time" type="text" placeholder="模糊匹配">
                        <button id="search">搜索</button>
                    </div>
                    <table class="table table-striped table-bordered table-hover dataTables-example">
                        <thead>
                        <tr>
                            <#if single??>
                                <th><input type="checkbox"></th>
                            </#if>
                            <th>老人编号</th>
                            <th>老人姓名</th>
                            <th>床位号</th>
                            <th>入院时间</th>
                            <th>预计出院时间</th>
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
</div>
<#include  "../spinner.ftl"/>
<script>
    var organId="${organId!'0'}";
    var dataUrl="${dataUrl!}";
    var single="${single!}";
    <#if result??>
    alert("录入数据：${result.data.total}\n其中成功导入数据：${result.data.numSuccess}\n包括添加：${result.data.successAdd}\n更新：${result.data.successUpdate}\n失败：${result.data.numFail}");
    </#if>
</script>
<script src="/js/content.min.js?v=1.0.0"></script>
<script src="/static/js/organ/organOldman.js" ></script>
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>

</body>

</html>