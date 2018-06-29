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
                    <h5>老人信息 <small>
                        <#if info.oldman.keyStatus==2 || info.oldman.keyStatus==4>
                            重点老人
                        </#if>
                    </small></h5>
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
                        <div class="form-group">
                            <label class="col-sm-2 control-label">基本信息</label>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">编号：${info.oldman.id!}</label>
                            <label class="col-sm-2 control-label">${info.oldman.name!}</label>
                            <label class="col-sm-2 control-label">${info.oldman.sex!}</label>
                            <label class="col-sm-2 control-label">${info.oldman.age!}</label>
                            <label class="col-sm-2 control-label">${info.oldman.politicalStatus!}</label>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">电话：${info.oldman.phone!}</label>
                            <label class="col-sm-2 control-label">政治面貌：${info.oldman.politicalStatus!}</label>
                            <label class="col-sm-2 control-label">户籍：${info.oldman.census!}</label>
                            <label class="col-sm-2 control-label">身份证号码：${info.oldman.pid!}</label>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">片区：${info.oldman.dName!}</label>
                            <label class="col-sm-2 control-label">居委：${info.oldman.jName!}</label>
                            <label class="col-sm-2 control-label">小区：${info.oldman.xName!}</label>
                            <label class="col-sm-2 control-label">楼号：${info.oldman.louNum!}</label>
                            <label class="col-sm-2 control-label">地址：${info.oldman.address!}</label>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">健康档案</label>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">血型：${info.health.bloodType!}</label>
                            <label class="col-sm-2 control-label">失智情况：${info.health.intelligence!}</label>
                            <label class="col-sm-2 control-label">视力：${info.health.eyesight!}</label>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">慢病</label>
                            <label class="col-sm-2 control-label">
                                <#if info.health.selectMb?? && info.health.selectMb?size &gt; 0>
                                    <#list info.health.selectMb as list>
                                        <label>${list.secTypeName}</label>
                                    </#list>
                                <#else >
                                    无
                                </#if>
                            </label>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">失能情况</label>
                            <label class="col-sm-2 control-label">
                            <#if info.health.selectSn?? && info.health.selectSn?size &gt; 0>
                                <#list selectSn as list>
                                    <label>${list.secTypeName}</label>
                                </#list>
                            <#else >
                                无
                            </#if>
                            </label>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">药物反应</label>
                            <label class="col-sm-2 control-label">
                            <#if info.health.selectYwfy?? && info.health.selectYwfy?size &gt; 0>
                                <#list info.health.selectYwfy as list>
                                    <label>${list.secTypeName}</label>
                                </#list>
                            <#else >
                                无
                            </#if>
                            </label>
                        </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">恶性肿瘤史</label>
                        <label class="col-sm-2 control-label">
                        <#if info.health.addExzl?? && info.health.addExzl?size &gt; 0>
                            <#list info.health.addExzl as list>
                                <p>${list.desc}</p>
                            </#list>
                        <#else >
                            无
                        </#if>
                        </label>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">骨折史</label>
                        <label class="col-sm-2 control-label">
                        <#if info.health.addGz?? && info.health.addGz?size &gt; 0>
                            <#list info.health.addGz as list>
                                <p>${list.desc}</p>
                            </#list>
                        <#else >
                            无
                        </#if>
                        </label>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">残疾情况</label>
                        <label class="col-sm-2 control-label">
                        <#if info.health.addCj?? && info.health.addCj?size &gt; 0>
                            <#list info.health.addCj as list>
                                <p>${list.desc}</p>
                            </#list>
                        <#else >
                            无
                        </#if>
                        </label>
                    </div>
                    <div class="hr-line-dashed"></div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">家庭结构：${info.family!}</label>
                        <label class="col-sm-2 control-label">经济条件：${info.economic!}</label>
                    </div>
                    <div class="hr-line-dashed"></div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">应急联系人</label>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">姓名：${info.linkman.name!}</label>
                        <label class="col-sm-2 control-label">电话：${info.linkman.phone!}</label>
                        <label class="col-sm-2 control-label">关系：${info.linkman.relation!}</label>
                    </div>
                    <div class="hr-line-dashed"></div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">养老状态</label>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">机构养老</label>
                        <label class="col-sm-2 control-label">
                        </label>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">社区养老</label>
                        <label class="col-sm-2 control-label">
                            <#if info.community?? && info.community?size &gt; 0>
                                <#list info.community as list>

                                </#list>
                            </#if>
                        </label>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">居家养老</label>
                        <label class="col-sm-2 control-label"></label>
                    </div>
                    <div class="hr-line-dashed"></div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">标签</label>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>

</body>

</html>