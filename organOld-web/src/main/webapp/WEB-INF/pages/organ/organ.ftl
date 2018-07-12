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
                    <h5 id="title">养老服务机构 <small>人员</small></h5>
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
                        <#if status?? && (status=="1" || status=="3")>
                        <#else >
                            <a onclick="" href="javascript:void(0);" class="btn btn-primary ">添加</a>
                            <a onclick="" href="javascript:void(0);" class="btn btn-primary ">删除</a>
                        </#if>
                    </div>
                    <div>
                        <input class="id" type="text" placeholder="序号">
                        <input class="time" type="text" placeholder="模糊匹配">
                        <button id="search">搜索</button>
                        <#if status?? && status=="1">
                        <#else >
                            <form action="/organ/${type}/importExcel" method="post" enctype="multipart/form-data">
                                <input type="file" name="file">
                                <input type="hidden" name="pType" value="oldman">
                                <input type="submit" value="导入">
                            </form>
                        </#if>
                    </div>
                    <table class="table table-striped table-bordered table-hover dataTables-example">
                        <thead>
                        <tr>
                            <#if status?? && (status=="1" || status=="3")>
                            <#else >
                                <th><input type='checkbox' /></th> <!-- checkbox-->
                            </#if>
                            <th>编号</th>
                            <th>类型</th>
                            <th>名称</th>
                            <th>简介</th>
                            <#if type==21 || type==22 || type==3>
                                <th>床（席）位数</th>
                            </#if>
                            <#if type==21 || type==22 >
                                <th>入住数</th>
                                <th>剩余床数</th>
                            </#if>
                            <th>工作时间</th>
                            <th>地址</th>
                            <th>联系方式</th>
                            <th>所属片区</th>
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
<script>
    var firType=${type};
    var status="${status!}";
    <#if result??>
    alert("录入数据：${result.data.total}\n其中成功导入数据：${result.data.numSuccess}\n包括添加：${result.data.successAdd}\n更新：${result.data.successUpdate}\n删除：${result.data.successDel}\n失败：${result.data.numFail}");
    </#if>

</script>
<script src="/js/content.min.js?v=1.0.0"></script>
<script src="/static/js/common.js"></script>
<script src="/static/js/organ/organ.js" ></script>
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>

</body>

</html>