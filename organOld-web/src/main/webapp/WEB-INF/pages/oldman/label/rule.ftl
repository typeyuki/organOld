<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="/css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
    <link href="/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="/css/animate.min.css" rel="stylesheet">
    <link href="/css/style.min.css?v=4.0.0" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>规则制定标签 <small>规则</small></h5>
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
                    <form method="get" class="form-horizontal">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">年龄段</label>
                            <div class="col-sm-1">
                                <input type="text" class="form-control" value="" disabled="" />
                            </div>
                            <div class="col-sm-1" align="center">
                                <span class="">至</span>
                            </div>
                            <div class="col-sm-1">
                                <input type="text" class="form-control" value="" disabled=""/>
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">性别
                            </label>
                            <div class="col-sm-1">
                                <div class="radio i-checks">
                                    <label>
                                        <input type="radio"  value="option2" name="sex" disabled=""> <i></i> 不限</label>
                                </div>
                            </div>
                            <#list (rule.sex)?keys as key>
                                <div class="col-sm-1">
                                    <div class="radio i-checks">
                                        <label>
                                            <input type="radio" value="${key}" name="sex" disabled=""> <i></i> ${(rule.sex)?values[key_index]!}</label>
                                    </div>
                                </div>
                            </#list>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">所属片区
                            </label>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" value="" disabled=""> <i></i> 不限</label>
                                </div>
                            </div>
                            <#list rule.district as district>
                                <div class="col-sm-1">
                                    <div class="radio i-checks">
                                        <label>
                                            <input type="radio" value="${district.id}" name="district" disabled=""> <i></i> ${district.value}</label>
                                    </div>
                                </div>
                            </#list>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <#if (rule.organ)?? && (rule.organ)?size &gt;0 >
                            <div class="form-group">
                                <label class="col-sm-2 control-label">所属居委
                                </label>
                                <div class="col-sm-1">
                                    <div class="checkbox i-checks">
                                        <label>
                                            <input type="checkbox" value="" disabled=""> <i></i> 不限</label>
                                    </div>
                                </div>
                                <#list rule.organ as organ>
                                    <div class="col-sm-1">
                                        <div class="radio i-checks">
                                            <label>
                                                <input type="radio" value="${organ.id}" name="organ" disabled=""> <i></i> ${organ.name}</label>
                                        </div>
                                    </div>
                                </#list>
                            </div>
                            <div class="hr-line-dashed"></div>
                        </#if>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">户籍
                            </label>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" value="" name="census" disabled=""> <i></i> 不限</label>
                                </div>
                            </div>
                            <#list rule.census as census>
                                <div class="col-sm-1">
                                    <div class="radio i-checks">
                                        <label>
                                            <input type="radio" value="${census.id}" name="census" disabled=""> <i></i> ${census.value}</label>
                                    </div>
                                </div>
                            </#list>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">政治面貌
                            </label>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" value="" name="politicalStatuses" disabled=""> <i></i> 不限</label>
                                </div>
                            </div>
                            <#list rule.politicalStatuses as politicalStatuses>
                                <div class="col-sm-1">
                                    <div class="radio i-checks">
                                        <label>
                                            <input type="radio" value="${politicalStatuses.id}" name="politicalStatuses" disabled=""> <i></i> ${politicalStatuses.value}</label>
                                    </div>
                                </div>
                            </#list>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">是否是重点老人
                            </label>
                            <div class="col-sm-1">
                                <div class="radio i-checks">
                                    <label>
                                        <input type="radio"  value="option2" name="b" checked> <i></i> 不限</label>
                                </div>
                            </div>
                            <div class="col-sm-1">
                                <div class="radio i-checks">
                                    <label>
                                        <input type="radio" value="option1" name="b"> <i></i> 是</label>
                                </div>
                            </div>
                            <div class="col-sm-1">
                                <div class="radio i-checks">
                                    <label>
                                        <input type="radio"  value="option2" name="b" disabled=""> <i></i> 否</label>
                                </div>
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">经济条件
                            </label>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" value="" checked> <i></i> 不限</label>
                                </div>
                            </div>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" value=""> <i></i> 帮困</label>
                                </div>
                            </div>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" value=""> <i></i> 低保</label>
                                </div>
                            </div>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" value=""> <i></i> 养老保险</label>
                                </div>
                            </div>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" value=""> <i></i> 医疗救助金</label>
                                </div>
                            </div>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" value=""> <i></i> 城镇医保</label>
                                </div>
                            </div>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" value=""> <i></i> 其他</label>
                                </div>
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">家庭结构
                            </label>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" value="" "> <i></i> 不限</label>
                                </div>
                            </div>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" value="" checked=""> <i></i> 纯老</label>
                                </div>
                            </div>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" value="" checked=""> <i></i> 独居</label>
                                </div>
                            </div>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" value=""> <i></i> 失独</label>
                                </div>
                            </div>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" value=""> <i></i> 一老养一老</label>
                                </div>
                            </div>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" value=""> <i></i> 孤老</label>
                                </div>
                            </div>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" value=""> <i></i> 三支人员</label>
                                </div>
                            </div>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" value=""> <i></i> 其他</label>
                                </div>
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">失智
                            </label>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" value="" checked> <i></i> 不限</label>
                                </div>
                            </div>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" value=""> <i></i> 正常</label>
                                </div>
                            </div>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" value=""> <i></i> 有障碍</label>
                                </div>
                            </div>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" value=""> <i></i> 痴呆</label>
                                </div>
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">视力
                            </label>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" value="" checked=""> <i></i> 不限</label>
                                </div>
                            </div>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" value=""> <i></i> 正常</label>
                                </div>
                            </div>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" value=""> <i></i> 有障碍</label>
                                </div>
                            </div>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" value=""> <i></i> 失明</label>
                                </div>
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">是否有以下情况
                            </label>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" value="" checked> <i></i> 不限</label>
                                </div>
                            </div>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" value=""> <i></i> 恶性肿瘤史</label>
                                </div>
                            </div>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" value=""> <i></i> 骨折史</label>
                                </div>
                            </div>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" value=""> <i></i> 残疾情况</label>
                                </div>
                            </div>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" value=""> <i></i> 慢病</label>
                                </div>
                            </div>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" value=""> <i></i> 失能</label>
                                </div>
                            </div>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" value=""> <i></i> 药物反应</label>
                                </div>
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">长护险评级
                            </label>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" value="" checked> <i></i> 不限</label>
                                </div>
                            </div>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" value=""> <i></i> 2级</label>
                                </div>
                            </div>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" value=""> <i></i> 3级</label>
                                </div>
                            </div>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" value=""> <i></i> 4级</label>
                                </div>
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">养老状态
                            </label>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" value="" checked> <i></i> 不限</label>
                                </div>
                            </div>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" value=""> <i></i> 居家养老</label>
                                </div>
                            </div>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" value=""> <i></i> 社区养老</label>
                                </div>
                            </div>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" value=""> <i></i> 机构养老</label>
                                </div>
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <div class="col-sm-4 col-sm-offset-2">
                                <button class="btn btn-primary" type="submit">编辑</button>
                                <button class="btn btn-white" type="submit" style="display: none">取消</button>
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
<script>
    $(document).ready(function(){$(".i-checks").iCheck({checkboxClass:"icheckbox_square-green",radioClass:"iradio_square-green",})});
</script>
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
</body>

</html>