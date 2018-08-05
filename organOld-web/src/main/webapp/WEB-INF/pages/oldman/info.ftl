<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <#include "../common/head.ftl" />

    <link href="/css/style.min.css?v=4.0.0" rel="stylesheet">
    <link href="/static/css/common_table.css" rel="stylesheet">
    <style>
        .label_title{
            font-size: 20px;
            font-weight: bold;
        }
    </style>
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>老人信息
                        <#if (info.key)??>
                        <small style="color:red;">重点老人(${info.key.goal!})</small>
                        </#if>
                        <#if info.oldman.isVolunteer==1>
                            <small style="color:red;margin-left: 5px">
                                志愿者
                            </small>
                        </#if>
                    </h5>
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
                    <form method="get" class="form-horizontal" >
                        <div class="form-group">
                            <label class="col-sm-2 control-label label_title">基本信息</label>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">编号：${info.oldman.id!}</label>
                            <label class="col-sm-2 control-label">姓名：${info.oldman.name!}</label>
                            <label class="col-sm-2 control-label">性别：${info.oldman.sex!}</label>
                            <label class="col-sm-2 control-label">年龄：${info.oldman.age!}</label>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">电话：${info.oldman.phone!}</label>
                            <label class="col-sm-2 control-label">政治面貌：${info.oldman.politicalStatus!}</label>
                            <label class="col-sm-2 control-label">户籍：${info.oldman.census!}</label>
                            <label class="col-sm-3 control-label">身份证号码：${info.oldman.pid!}</label>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">街道：古美路街道</label>
                            <label class="col-sm-2 control-label">片区：${info.oldman.dName!}</label>
                            <label class="col-sm-2 control-label">居委：${info.oldman.jName!}</label>
                            <label class="col-sm-2 control-label">小区：${info.oldman.xName!}</label>
                            <label class="col-sm-2 control-label">楼号：${info.oldman.louNum!}</label>
                            <label class="col-sm-2 control-label">地址：${info.oldman.address!}</label>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">职称：${info.oldman.zc!"无"}</label>
                            <label class="col-sm-2 control-label">社区职务：
                            <#if info.oldman.sqzw?? && info.oldman.sqzw?size &gt; 0>
                                <#list info.oldman.sqzw as list>
                                    <label>${list}</label>
                                </#list>
                            <#else >
                                无
                            </#if>
                            </label>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label label_title">健康档案</label>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">血型：${info.health.bloodType!"无"}</label>
                            <label class="col-sm-2 control-label">失智情况：${info.health.intelligence!"无"}</label>
                            <label class="col-sm-2 control-label">视力：${info.health.eyesight!"无"}</label>
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
                                <#list info.health.selectSn as list>
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
                            <label class="col-sm-2 control-label">家庭结构：${info.oldman.family!"无"}</label>
                            <label class="col-sm-2 control-label">家庭类别：
                            <#if info.oldman.familyType?? && info.oldman.familyType?size &gt; 0>
                                <#list info.oldman.familyType as list>
                                    <label>${list}</label>
                                </#list>
                            <#else >
                                无
                            </#if></label>
                            <label class="col-sm-2 control-label">经济条件：${info.oldman.economic!"无"}</label>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label label_title">应急联系人</label>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">姓名：${(info.linkman.name)!}</label>
                            <label class="col-sm-2 control-label">电话：${(info.linkman.phone)!}</label>
                            <label class="col-sm-2 control-label">关系：${(info.linkman.relation)!}</label>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label label_title">养老状态&nbsp;&nbsp;&nbsp;${info.oldman.oldStatus!}</label>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">机构养老</label>
                            <#if info.organ??>
                                <label class="col-sm-2 control-label">${info.organ.organName}</label>
                                <#if info.organ.num=="0">
                                    <label class="col-sm-2 control-label">主动申请</label>
                                    <label class="col-sm-2 control-label">申请时间：${info.organ.applyTime}</label>
                                <#else >
                                    <label class="col-sm-2 control-label">床位号：${info.organ.num}</label>
                                    <label class="col-sm-2 control-label">服务时间：${info.organ.timeIn}-${info.organ.timeOut}</label>
                                </#if>
                            <#else >
                                <label class="col-sm-2 control-label">无</label>
                            </#if>
                        </div>
                        <#if info.community?? && info.community?size &gt; 0>
                            <#list info.community as list>
                                <div class="form-group">
                                    <#if list_index==0>
                                        <label class="col-sm-2 control-label">社区养老</label>
                                        <label class="col-sm-2 control-label">${list.organName}</label>
                                        <#if list.num=="0">
                                            <label class="col-sm-2 control-label">主动申请</label>
                                            <label class="col-sm-2 control-label">申请时间：${list.applyTime}</label>
                                        <#else >
                                            <label class="col-sm-2 control-label">床位号：${list.num}</label>
                                            <label class="col-sm-2 control-label">服务时间：${list.timeIn}-${list.timeOut}</label>
                                        </#if>
                                    <#else >
                                        <label class="col-sm-2 control-label"></label>
                                        <label class="col-sm-2 control-label">${list.organName}</label>
                                        <label class="col-sm-2 control-label">床位号：${list.num}</label>
                                        <label class="col-sm-2 control-label">服务时间：${list.timeIn}-${list.timeOut}</label>
                                    </#if>
                                </div>
                            </#list>
                        <#else >
                            <div class="form-group">
                                <label class="col-sm-2 control-label">社区养老</label>
                                <label class="col-sm-2 control-label">无</label>
                            </div>
                        </#if>
                        <#if info.home?? && info.home?size &gt; 0>
                            <#list info.home as list>
                                <div class="form-group">
                                    <#if list_index==0>
                                        <label class="col-sm-2 control-label">居家养老</label>
                                        <label class="col-sm-2 control-label">${list.homeName}</label>
                                        <label class="col-sm-2 control-label">类型：${list.homeType}</label>
                                        <#if list.homeType=="长护险">
                                            <label class="col-sm-2 control-label">是否已获得服务：${list.isService}</label>
                                        <#else >
                                            <label class="col-sm-2 control-label">服务时间：${list.timeIn}-${list.timeOut}</label>
                                        </#if>
                                    <#else >
                                        <label class="col-sm-2 control-label"></label>
                                        <label class="col-sm-2 control-label">${list.homeName}</label>
                                        <label class="col-sm-2 control-label">类型：${list.homeType}</label>
                                        <#if list.homeType=="长护险">
                                            <label class="col-sm-2 control-label">是否已获得服务：${list.isService}</label>
                                        <#else >
                                            <label class="col-sm-2 control-label">服务时间：${list.timeIn}-${list.timeOut}</label>
                                        </#if>
                                    </#if>
                                    <label class="col-sm-2 control-label">服务机构：${(list.organ.name)!"无"}</label>
                                </div>
                            </#list>
                        <#else >
                            <div class="form-group">
                                <label class="col-sm-2 control-label">居家养老</label>
                                <label class="col-sm-2 control-label">无</label>
                            </div>
                        </#if>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label label_title">政策服务</label>
                        </div>
                        <div class="form-group" id="label">
                        </div>
                    <#if (info.key)??>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label label_title">重点老人</label>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label" >状态：${info.key.status}</label>
                                <label class="col-sm-2 control-label">处理情况：${(info.key.oldmanKeyHandleModel.type)!}</label>
                                <label class="col-sm-2 control-label" >
                                    <#if info.key.oldmanKeyHandleModel?? && info.key.oldmanKeyHandleModel.organ??>
                                        <#list info..key.oldmanKeyHandleModel.organ as list>
                                            <label>${list.name}</label>
                                        </#list>
                                    </#if>
                                    <#if info.key.oldmanKeyHandleModel?? && info.key.oldmanKeyHandleModel.homeFirTypes??>
                                        <#list info..key.oldmanKeyHandleModel.homeFirTypes as list>
                                            <label>${list}</label>
                                        </#list>
                                    </#if>
                                </label>
                            </div>
                    </#if>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>

<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
<script>
    $.ajax({
        url: "/oldman/label/${info.oldman.id!}",
        type: 'GET',
        dataType: 'json',
        success: function (result) {
            if(result.success==true){
                for(var i=0;i<result.data.length;i++){
                    var l;
                    if((i+1)%6==0){
                        l=$("<br>"+"<label class='col-sm-2 control-label' style='margin: 5px'>"+result.data[i].labelName+"("+result.data[i].isImplement+")</label>");
                    }else{
                        l=$("<label class='col-sm-2 control-label' style='margin: 5px'>"+result.data[i].labelName+"("+result.data[i].isImplement+")</label>");
                    }
                    $("#label").append(l);
                }
            }
        },
        error:function(XMLHttpRequest, textStatus, errorThrown) {

        }
    });
</script>
</body>

</html>