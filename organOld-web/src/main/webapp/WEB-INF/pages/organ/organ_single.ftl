<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="/css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
    <link href="/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="/css/style.min.css?v=4.0.0" rel="stylesheet">
    <style>
        .star-content{
            font-size: 1.5em;
            color: red;
        }
    </style>
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>${organ.name!} <small>基本信息</small></h5>
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
                    <form method="post" action="/organ/${(organ.id??)?string("update","add")}"  class="form-horizontal" enctype="multipart/form-data">
                        <input type="hidden" name="id" value="${organ.id!0}">

                        <input type="hidden" name="organFirType" value="${organ.organFirTypeId!}">
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">类型<span  class="control-label star-content">*</span></label>
                            <div class="col-sm-5">
                                <select class="form-control" name="organTypeId">
                                    <#list organ.organTypeList as list>
                                        <option value="${list.id}">${list.secType}</option>
                                    </#list>
                                </select>
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">名称<span  class="control-label star-content">*</span></label>
                            <div class="col-sm-5">
                                <input type="text" name="name" class="form-control" value="${organ.name!}" />
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">简介</label>
                            <div class="col-sm-5">
                                <textarea name="intro"  class="form-control" >${organ.intro!}</textarea>
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <#if organ.organTypeId==21 || organ.organTypeId==22 ||organ.organTypeId==3>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">席位数</label>
                                <div class="col-sm-5">
                                    <input type="text" name="num" class="form-control" value="${organ.num!}"  />
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                        </#if>
                        <#if organ.organTypeId==21 || organ.organTypeId==22>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">入住数</label>
                                <div class="col-sm-5">
                                    <input type="text" name="numIn" class="form-control" value="${organ.numIn!}"  />
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">剩余床数</label>
                                <div class="col-sm-5">
                                    <input type="text" name="numRemain" class="form-control" value="${organ.numRemain!}"  />
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">设施情况</label>
                                <div class="col-sm-5">
                                    <textarea class="form-control" name="insitution">${organ.insitution!}</textarea>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">入住要求</label>
                                <div class="col-sm-5">
                                    <textarea class="form-control" name="require" >${organ.require!}</textarea>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                        </#if>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">服务内容</label>
                            <div class="col-sm-5">
                                <textarea class="form-control" name="work">${organ.work!}</textarea>
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">工作时间</label>
                            <div class="col-sm-5">
                                <textarea class="form-control" name="serviceTime" >${organ.serviceTime!}</textarea>
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">地址</label>
                            <div class="col-sm-5">
                                <textarea class="form-control" name="address" >${organ.address!}</textarea>
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">联系方式</label>
                            <div class="col-sm-5">
                                <input type="text" class="form-control" name="phone" value="${organ.phone!}" />
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">网站</label>
                            <div class="col-sm-5">
                                <input type="text" class="form-control" name="webUrl" value="${organ.webUrl!}" />
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">照片</label>
                            <div class="col-sm-3">
                            <#if organ.imgUrl??>
                                <img width="200" src="/${organ.imgUrl}">
                            </#if>
                            </div>
                            <div class="col-sm-2">
                                <input type="file" name="pic" class="form-control"  />
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">所属片区</label>
                            <div class="col-sm-5">
                                <select name="districtId">
                                    <option value="">无</option>
                                    <#list organ.districtList as district>
                                        <#if organ.districtName?? && organ.districtName==district.value>
                                            <option value="${district.id}" selected>${district.value}</option>
                                        <#else >
                                            <option value="${district.id}">${district.value}</option>
                                        </#if>
                                    </#list>
                                </select>
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <#if organ.organType?? && organ.organType!="居委会">
                        <#else >

                            <div class="form-group">
                                <label class="col-sm-2 control-label">父机构（居委会必选）</label>
                                <div class="col-sm-5">
                                    <select name="parent">
                                        <option value="">无</option>
                                        <#if organ.parentOrganList??>
                                            <#list organ.parentOrganList as list>
                                                    <option value="${list.id}" >${list.name}</option>
                                            </#list>
                                        </#if>
                                    </select>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                        </#if>
                        <#--<div class="form-group">-->
                            <#--<label class="col-sm-2 control-label">权限升级</label>-->
                            <#--<div class="col-sm-1">-->
                                <#--<div class="checkbox i-checks">-->
                                    <#--<label>-->
                                        <#--<input type="checkbox" value="consume"  name="auth" ${(organ.authConsume?? && organ.authConsume==1)?string("checked","")}> <i></i> 消费</label>-->

                                <#--</div>-->
                            <#--</div>-->
                            <#--<div class="col-sm-1">-->
                                <#--<div class="checkbox i-checks">-->
                                    <#--<label>-->
                                        <#--<input type="checkbox" value="sign"  name="auth" ${(organ.authSign?? && organ.authSign==1)?string("checked","")}> <i></i> 签到</label>-->

                                <#--</div>-->
                            <#--</div>-->
                            <#--<div class="col-sm-1">-->
                                <#--<div class="checkbox i-checks">-->
                                    <#--<label>-->
                                        <#--<input type="checkbox" value="product"  name="auth" ${(organ.authProduct?? && organ.authProduct==1)?string("checked","")}> <i></i> 商品</label>-->

                                <#--</div>-->
                            <#--</div>-->
                            <#--<div class="col-sm-1">-->
                                <#--<div class="checkbox i-checks">-->
                                    <#--<label>-->
                                        <#--<input type="checkbox" value="info"  name="auth" ${(organ.authQueryInfo?? && organ.authQueryInfo==1)?string("checked","")}> <i></i> 老人信息查询</label>-->

                                <#--</div>-->
                            <#--</div>-->
                            <#--<div class="col-sm-1">-->
                                <#--<div class="checkbox i-checks">-->
                                    <#--<label>-->
                                        <#--<input type="checkbox" value="integral"  name="auth" ${(organ.authQueryIntegral?? &&organ.authQueryIntegral==1)?string("checked","")}> <i></i> 积分查询</label>-->

                                <#--</div>-->
                            <#--</div>-->
                        <#--</div>-->
                        <#--<div class="hr-line-dashed"></div>-->
                        <div class="form-group">
                            <div class="col-sm-4 col-sm-offset-2">
                                <button class="btn btn-primary" type="submit">保存</button>
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

<script>
    $("select[name='organTypeId'] option").each(function () {
        if($(this).val()==${organ.organTypeId!}){
            $(this).prop("selected",true);
            return;
        }
                });

<#if organ.parentOrganList??>
$("select[name='parent'] option").each(function () {
    if($(this).val()==${organ.parent!}){
        $(this).prop("selected",true);
        return;
    }
});
</#if>
    <#if look??>
        $("input").prop("disabled",true);
        $("select").prop("disabled",true);
        $("textarea").prop("disabled",true);
        $("button").hide();
        $("input[type='file']").hide();
    </#if>
</script>

<script src="/js/plugins/iCheck/icheck.min.js"></script>
<script type="text/javascript" src="/static/js/organ/organ_simple.js"></script>
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>

</body>

</html>