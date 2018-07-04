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
                    <h5>东兰养老院 <small>基本信息</small></h5>
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
                        <input type="hidden" name="id" value="${organ.id!}">
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">类型</label>
                            <div class="col-sm-5">
                                <input type="text" class="form-control" value="${organ.organType!}" />
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">名称</label>
                            <div class="col-sm-5">
                                <input type="text" name="name" class="form-control" value="${organ.name!}" />
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">简介</label>
                            <div class="col-sm-5">
                                <textarea name="intro" class="form-control" value="${organ.intro!}"  ></textarea>
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <#if organ.organTypeId==21 || organ.organTypeId==22 ||organ.organTypeId==3>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">席位数</label>
                                <div class="col-sm-5">
                                    <input type="text" class="form-control" value="${organ.num!}"  />
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                        </#if>
                        <#if organ.organTypeId==21 || organ.organTypeId==22>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">入住数</label>
                                <div class="col-sm-5">
                                    <input type="text" class="form-control" value="${organ.numIn!}"  />
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">剩余床数</label>
                                <div class="col-sm-5">
                                    <input type="text" class="form-control" value="${organ.numRemain!}"  />
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">设施情况</label>
                                <div class="col-sm-5">
                                    <textarea class="form-control" value="${organ.insitution!}"   ></textarea>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">入住要求</label>
                                <div class="col-sm-5">
                                    <textarea class="form-control" value="${organ.require!}" ></textarea>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                        </#if>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">服务内容</label>
                            <div class="col-sm-5">
                                <textarea class="form-control" value="${organ.work!}"  ></textarea>
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">工作时间</label>
                            <div class="col-sm-5">
                                <textarea class="form-control"  value="${organ.serviceTime!}" ></textarea>
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">地址</label>
                            <div class="col-sm-5">
                                <textarea t class="form-control" value="${organ.address!}" ></textarea>
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">联系方式</label>
                            <div class="col-sm-5">
                                <input type="text" class="form-control" value="${organ.phone!}" />
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">网站</label>
                            <div class="col-sm-5">
                                <input type="text" class="form-control" value="${organ.webUrl!}" />
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">照片</label>
                            <div class="col-sm-3">
                            <#if organ.imgUrl??>
                                <img src="${organ.imgUrl}">
                            </#if>
                            </div>
                            <div class="col-sm-2">
                                <input type="file" class="form-control"  />
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">所属片区</label>
                            <div class="col-sm-5">
                                <select name="districtId">
                                    <option value="">无</option>
                                    <#list districts as district>
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
<script type="text/javascript" src="/static/js/organ/organ_simple.js"></script>
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>

</body>

</html>