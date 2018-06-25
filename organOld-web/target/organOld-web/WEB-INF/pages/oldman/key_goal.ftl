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
                    <h5>重点老人 <small>分数</small></h5>
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
                    <form method="post" class="form-horizontal" action="/oldman/key/rule/update">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">基线分数</label>
                            <div class="col-sm-5">
                                <input type="text" class="form-control" name="baseGoal" value="${rule.baseGoal!}" />
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <#list rule.keyRuleTypeList as type>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">${type.typeDesc!}</label>
                                <#list type.keyRuleList as rule>
                                    <div class="col-sm-1">
                                        <label>${rule.valueName}
                                            <input type="hidden" name="id" value="${rule.id}">
                                            <input type="text" id="rule_${rule.id}" name="goal" class="form-control" value="${rule.goal}" ></label>
                                    </div>
                                </#list>
                            </div>
                            <div class="hr-line-dashed"></div>
                        </#list>
                        <div class="form-group">
                            <div class="col-sm-4 col-sm-offset-2">
                                <button class="btn btn-primary" type="submit">提交</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>

<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>

</body>

</html>