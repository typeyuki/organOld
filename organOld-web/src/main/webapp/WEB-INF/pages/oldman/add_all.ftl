<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <#include "../common/head.ftl" />
    <link href="/css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
    <link href="/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="/css/animate.min.css" rel="stylesheet">
    <link href="/css/style.min.css?v=4.0.0" rel="stylesheet">


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
                    <h5>老人信息 <small>添加</small></h5>
                    <div class="ibox-tools">
                        <a class="collapse-link">
                            <i class="fa fa-chevron-up"></i>
                        </a>
                        <a class="close-link">
                            <i class="fa fa-times"></i>
                        </a>
                    </div>
                </div>
                <div class="ibox-content col-sm-12">
                    <form method="post" action="/oldman/save" class="form-horizontal">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">性别</label>
                            <select class="col-sm-1">
                                <#list (info.sex)?keys as key>
                                    <option  value="${key!}" name="sex" > <i></i> ${(info.sex)?values[key_index]!}</option>
                                </#list>
                            </select>
                            <label class="col-sm-3 control-label">所属片区</label>
                            <select class="col-sm-1">
                                <#list info.district as district>
                                    <option  value="${district.id!}" name="district" > <i></i> ${district.value!}</option>
                                </#list>
                            </select>
                            <label class="col-sm-3 control-label">小区</label>
                            <select class="col-sm-1">
                                <#list info.xq as xq>
                                    <option value="${xq.id!}" name="xq" > <i></i> ${xq.value!}</option>
                                </#list>
                            </select>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">居委</label>
                            <select class="col-sm-1">
                                <#list info.organ as organ>
                                    <option value="${organ.id!}" name="organ" > <i></i> ${organ.name!}</option>
                                </#list>
                            </select>
                            <label class="col-sm-3 control-label">户籍</label>
                            <select class="col-sm-1">
                                <#list info.census as census>
                                    <option type="checkbox" value="${census.id!}" name="census" > <i></i> ${census.value!}</option>
                                </#list>
                            </select>
                            <label class="col-sm-3 control-label">政治面貌
                            </label>
                            <select class="col-sm-1">
                                <#list info.politicalStatuses as politicalStatuses>
                                    <option value="${politicalStatuses.id!}" name="politicalStatus" > <i></i> ${politicalStatuses.value!}</option>
                                </#list>
                            </select>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">经济条件
                            </label>
                            <select  class="col-sm-1">
                                <#list info.economic as economic>
                                    <option type="checkbox" value="${economic.id!}" name="economic" > <i></i> ${economic.value!}</option>
                                </#list>
                            </select>
                            <label class="col-sm-3 control-label">家庭结构
                            </label>
                            <select class="col-sm-1">
                                <#list info.family as family>
                                    <option value="${family.id!}" name="family" > <i></i> ${family.value!}</option>
                                </#list>
                            </select>

                            <label class="col-sm-3 control-label">失智
                            </label>
                            <select  class="col-sm-1">
                                <#list info.intelligence as intelligence>
                                    <option value="${intelligence.id!}" name="intelligence" > <i></i> ${intelligence.value!}</option>
                                </#list>
                            </select>

                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">视力
                            </label>
                            <select class="col-sm-1">
                                <#list info.eyesight as eyesight>
                                    <option value="${eyesight.id!}" name="eyesight" > <i></i> ${eyesight.value!}</option>
                                </#list>
                            </select>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">慢病</label>
                            <#list info.mb as mb>
                                <div class="col-sm-1">
                                    <div class="radio i-checks">
                                        <label>
                                            <input type="checkbox" value="${mb.id!}" name="mb" > <i></i> ${mb.secTypeName!}
                                        </label>
                                    </div>
                                </div>
                            </#list>
                        </div>
                            <#--<select class="col-sm-1">-->
                                 <#--<#list info.mb as mb>-->
                                     <#--<option value="${mb.id!}" name="mb" > <i></i> ${mb.secTypeName!}</option>-->
                                 <#--</#list>-->
                            <#--</select>-->
                        <div class="form-group">
                            <label class="col-sm-3 control-label">失能
                            </label>
                            <#--<select class="col-sm-1">-->
                                <#--<#list info.sn as sn>-->
                                    <#--<option value="${sn.id!}" name="sn" > <i></i> ${sn.value!}</option>-->
                                <#--</#list>-->
                            <#--</select>-->
                           <#list info.sn as sn>
                                <div class="col-sm-1">
                                    <div class="radio i-checks">
                                        <label>
                                            <input type="checkbox" value="${sn.id!}" name="sn" > <i></i> ${sn.secTypeName!}</label>
                                    </div>
                                </div>
                           </#list>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">药物反应
                            </label>
                            <#list info.ywfy as ywfy>
                                <div class="col-sm-1">
                                    <div class="radio i-checks">
                                        <label>
                                            <input type="checkbox" value="${ywfy.id!}" name="mb" > <i></i> ${ywfy.secTypeName!}</label>
                                    </div>
                                </div>
                            </#list>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <div class="col-sm-4 col-sm-offset-2">
                                <button class="btn btn-primary" type="submit">添加</button>
                                <button class="btn btn-white" type="button" onclick="location.reload()">取消</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>


<script src="/js/jquery.min.js?v=2.1.4"></script>
<script src="/js/bootstrap.min.js?v=3.3.5"></script>
<script src="/js/content.min.js?v=1.0.0"></script>
<script src="/js/plugins/iCheck/icheck.min.js"></script>
<script src="/static/js/oldman/add_all.js"></script>
<script>
    $(document).ready(function(){$(".i-checks").iCheck({checkboxClass:"icheckbox_square-green",radioClass:"iradio_square-green",})});
</script>
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
</body>

</html>