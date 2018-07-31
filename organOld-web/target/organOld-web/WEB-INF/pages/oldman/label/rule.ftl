<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="/js/jquery.min.js?v=2.1.4"></script>
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
                    <form method="post" action="/oldman/label/rule/save" class="form-horizontal">
                        <input type="hidden" name="labelId" value="${labelId}">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">年龄段</label>
                            <div class="col-sm-1">
                                <input type="text" name="ageStart" class="form-control" value=""  />
                            </div>
                            <div class="col-sm-1" align="center">
                                <span class="">至</span>
                            </div>
                            <div class="col-sm-1">
                                <input type="text" name="ageEnd" class="form-control" value="" />
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">性别
                            </label>
                            <div class="col-sm-1">
                                <div class="radio i-checks">
                                    <label>
                                        <input type="radio"  value="" name="sex"  checked> <i></i> 不限</label>
                                </div>
                            </div>
                            <#list (rule.sex)?keys as key>
                                <div class="col-sm-1">
                                    <div class="radio i-checks">
                                        <label>
                                            <input type="radio" value="${key}" name="sex" > <i></i> ${(rule.sex)?values[key_index]!}</label>
                                    </div>
                                </div>
                            </#list>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group jw pq">
                            <label class="col-sm-2 control-label">所属片区
                            </label>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" value=""  name="district" checked> <i></i> 不限</label>
                                </div>
                            </div>
                            <#list rule.district as district>
                                <div class="col-sm-1">
                                    <div class="radio i-checks">
                                        <label>
                                            <input type="checkbox" value="${district.id}" name="district" > <i></i> ${district.value}</label>
                                    </div>
                                </div>
                            </#list>
                        </div>
                        <div class="hr-line-dashed jw pq"></div>
                        <#if (rule.organ)?? && (rule.organ)?size &gt;0 >
                            <div class="form-group jw">
                                <label class="col-sm-2 control-label">所属居委
                                </label>
                                <div class="col-sm-1">
                                    <div class="checkbox i-checks">
                                        <label>
                                            <input type="checkbox" value="" name="organ"  checked> <i></i> 不限</label>
                                    </div>
                                </div>
                                <#list rule.organ as organ>
                                    <div class="col-sm-1">
                                        <div class="radio i-checks">
                                            <label>
                                                <input type="checkbox" value="${organ.id}" name="organ" > <i></i> ${organ.name}</label>
                                        </div>
                                    </div>
                                </#list>
                            </div>
                            <div class="hr-line-dashed jw"></div>
                        </#if>
                        <script>
//                            居委的发布的话 不显示片区和居委   管理员发布的话 居委看的话  不能更改
                            $.ajax({
                                url: "/user/checkUserOrganType",
                                type: "get",
                                success: function (data) {
                                    if (data.success == true) {
                                        $.ajax({
                                            url: "/oldman/label/${labelId}/checkCanChange",
                                            type: "get",
                                            dataType:"json",
                                            success: function (data2) {
                                                if (data2.success == false) {
                                                    $("input").prop("disabled",true);
                                                }else{
                                                    if(data.data=="居委会"){
                                                        $(".jw").hide();
                                                    }else if(data.data=="片区"){
                                                        $(".pq").hide();
                                                    }
                                                }
                                            }
                                        });
                                    }
                                }
                            });
                        </script>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">户籍
                            </label>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" value="" name="census"  checked> <i></i> 不限</label>
                                </div>
                            </div>
                            <#list rule.census as census>
                                <div class="col-sm-1">
                                    <div class="radio i-checks">
                                        <label>
                                            <input type="checkbox" value="${census.id}" name="census" > <i></i> ${census.value}</label>
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
                                        <input type="checkbox" value="" name="politicalStatus"  checked> <i></i> 不限</label>
                                </div>
                            </div>
                            <#list rule.politicalStatuses as politicalStatuses>
                                <div class="col-sm-1">
                                    <div class="radio i-checks">
                                        <label>
                                            <input type="checkbox" value="${politicalStatuses.id}" name="politicalStatus" > <i></i> ${politicalStatuses.value}</label>
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
                                        <input type="radio"  value="" name="isKey"  checked> <i></i> 不限</label>
                                </div>
                            </div>
                            <#list (rule.isKey)?keys as key>
                                <div class="col-sm-1">
                                    <div class="radio i-checks">
                                        <label>
                                            <input type="radio" value="${key}" name="isKey" > <i></i> ${(rule.isKey)?values[key_index]!}</label>
                                    </div>
                                </div>
                            </#list>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">经济条件
                            </label>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" name="economic" value=""  checked> <i></i> 不限</label>
                                </div>
                            </div>
                            <#list rule.economic as economic>
                                <div class="col-sm-1">
                                    <div class="radio i-checks">
                                        <label>
                                            <input type="checkbox" value="${economic.id}" name="economic" > <i></i> ${economic.value}</label>
                                    </div>
                                </div>
                            </#list>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">家庭结构
                            </label>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" name="family" value=""  checked> <i></i> 不限</label>
                                </div>
                            </div>
                            <#list rule.family as family>
                                <div class="col-sm-1">
                                    <div class="radio i-checks">
                                        <label>
                                            <input type="checkbox" value="${family.id}" name="family" > <i></i> ${family.value}</label>
                                    </div>
                                </div>
                            </#list>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">家庭类别
                            </label>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" name="familyType" value="" checked> <i></i> 不限</label>
                                </div>
                            </div>
                        <#list rule.familyType as list>
                            <div class="col-sm-1">
                                <div class="radio i-checks">
                                    <label>
                                        <input type="checkbox" value="${list.id}" name="familyType" > <i></i> ${list.value}</label>
                                </div>
                            </div>
                        </#list>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">职称
                            </label>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" name="zc" value=""  checked> <i></i> 不限</label>
                                </div>
                            </div>
                        <#list rule.zc as list>
                            <div class="col-sm-1">
                                <div class="radio i-checks">
                                    <label>
                                        <input type="checkbox" value="${list.id}" name="zc" > <i></i> ${list.value}</label>
                                </div>
                            </div>
                        </#list>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">社区职务(其中之一)
                            </label>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" name="sqzw" value=""  checked> <i></i> 不限</label>
                                </div>
                            </div>
                        <#list rule.sqzw as list>
                            <div class="col-sm-1">
                                <div class="radio i-checks">
                                    <label>
                                        <input type="checkbox" value="${list.id}" name="sqzw" > <i></i> ${list.value}</label>
                                </div>
                            </div>
                        </#list>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">失智
                            </label>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" value="" name="intelligence"  checked> <i></i> 不限</label>
                                </div>
                            </div>
                            <#list rule.intelligence as intelligence>
                                <div class="col-sm-1">
                                    <div class="radio i-checks">
                                        <label>
                                            <input type="checkbox" value="${intelligence.id}" name="intelligence" > <i></i> ${intelligence.value}</label>
                                    </div>
                                </div>
                            </#list>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">视力
                            </label>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" value="" name="eyesight"  checked> <i></i> 不限</label>
                                </div>
                            </div>
                            <#list rule.eyesight as eyesight>
                                <div class="col-sm-1">
                                    <div class="radio i-checks">
                                        <label>
                                            <input type="checkbox" value="${eyesight.id}" name="eyesight" > <i></i> ${eyesight.value}</label>
                                    </div>
                                </div>
                            </#list>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">是否有以下情况(其中之一)
                            </label>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" value="" name="isHealth"  checked> <i></i> 不限</label>
                                </div>
                            </div>
                            <#list (rule.isHealth)?keys as key>
                                <div class="col-sm-1">
                                    <div class="radio i-checks">
                                        <label>
                                            <input type="checkbox" value="${key}" name="isHealth" > <i></i> ${(rule.isHealth)?values[key_index]!}</label>
                                    </div>
                                </div>
                            </#list>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">长护险评级
                            </label>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" name="chx" value=""  checked> <i></i> 不限</label>
                                </div>
                            </div>
                            <#list rule.chx as chx>
                                <div class="col-sm-1">
                                    <div class="radio i-checks">
                                        <label>
                                            <input type="checkbox" value="${chx.id}" name="chx" > <i></i> ${chx.level}级</label>
                                    </div>
                                </div>
                            </#list>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">养老状态
                            </label>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" value="" name="oldStatus"  checked> <i></i> 不限</label>
                                </div>
                            </div>
                            <#list (rule.oldStatus)?keys as key>
                                <div class="col-sm-1">
                                    <div class="radio i-checks">
                                        <label>
                                            <input type="checkbox" value="${key}" name="oldStatus" > <i></i> ${(rule.oldStatus)?values[key_index]!}</label>
                                    </div>
                                </div>
                            </#list>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <div class="col-sm-4 col-sm-offset-2">
                                <button class="btn btn-primary" type="submit">保存</button>
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
<script>
    var labelId="${labelId}";
</script>
<script src="/static/js/oldman/label/rule.js"></script>
<script>
    $.ajax({
        url: "/oldman/label/${labelId}/checkCanChange",
        type: "get",
        success: function (data) {
            if (data.success ==false) {
                $("input").prop("disabled",true);
                $("select").prop("disabled",true);
                $("textarea").prop("disabled",true);
                $("button").hide();
                $("input[type='file']").hide();
            }
        }
    });
    $(document).ready(function(){$(".i-checks").iCheck({checkboxClass:"icheckbox_square-green",radioClass:"iradio_square-green"})});
</script>
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
</body>

</html>