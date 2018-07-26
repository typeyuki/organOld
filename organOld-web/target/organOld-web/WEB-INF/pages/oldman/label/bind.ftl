<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <#include "../../common/head.ftl" />

    <link href="/css/style.min.css?v=4.0.0" rel="stylesheet">
    <link href="/static/css/common_table.css" rel="stylesheet">
    <link href="/css/plugins/iCheck/custom.css" rel="stylesheet">
    <style>
        @media only screen and (min-width: 1401px){
            .age{
                width: 48%;
            }
        }
        @media only screen and ( max-width: 1400px){
            .age{
                width: 45%;
            }
        }
    </style>
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>老人 <small>基本信息</small></h5>
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
                    <#if type=="bind">
                        <div class="noplay" style="display: inline">
                            <a onclick="$('#selectModal').modal()" href="javascript:void(0);" class="btn btn-primary ">添加</a>
                            <#if type=="bind">
                                <a onclick="del('/oldman/label/bind/${labelId}/man/del')" href="javascript:void(0);" class="btn btn-primary ">删除</a>
                            </#if>
                        </div>
                    <script>
                        $.ajax({
                            url: "/oldman/label/${labelId}/checkCanChange",
                            type: "get",
                            success: function (data) {
                                if (data.success ==false) {
                                    $(".noplay").hide();
                                }
                            }
                        });
                    </script>
                    </#if>
                        <div style="display: inline">
                            <a  href="javascript:void(0);" id="search" class="btn btn-primary ">搜索</a>
                        </div>
                    <div class="row" style="margin-top: 10px;margin-bottom: 10px">
                        <div class="col-sm-2">
                            <input class="id form-control inp"  name="id" type="text" placeholder="序号">
                        </div>
                        <div class="col-sm-2">
                            <label >性别</label>
                            <select name="sex" class="form-control inp" style="width: 80%">
                                <option></option>
                            <#list (info.sex)?keys as key>
                                <option  value="${key!}"> ${(info.sex)?values[key_index]!}</option>
                            </#list>
                            </select>
                        </div>
                        <div class="col-sm-2">
                            <input class="age form-control inp"  name="ageStart" type="text" placeholder="年龄段-起">-
                            <input class="age form-control inp"  name="ageEnd" type="text" placeholder="年龄段-止">
                        </div>
                        <div class="col-sm-4">
                            <input name="search" class="form-control inp"  type="text" placeholder="模糊匹配">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-2">
                            <label >户<span style="color: white">填充</span>籍：</label>
                            <select name="census"  class="selectpicker bla bla bli" multiple data-live-search="true">
                            <#list info.census as census>
                                <option type="checkbox" value="${census.id!}" >${census.value!}</option>
                            </#list>
                            </select>
                        </div>
                        <div class="col-sm-2">
                            <label >政治面貌：</label>
                            <select name="politicalStatuses" class="selectpicker bla bla bli" multiple data-live-search="true">
                            <#list info.politicalStatuses as politicalStatuses>
                                <option value="${politicalStatuses.id!}">${politicalStatuses.value!}</option>
                            </#list>
                            </select>
                        </div>
                        <div class="col-sm-2">
                            <label>家庭结构：</label>
                            <select name="familyIndex"  class="selectpicker bla bla bli" multiple data-live-search="true">
                            <#list info.family as family>
                                <option value="${family.id!}"> <i></i> ${family.value!}</option>
                            </#list>
                            </select>
                        </div>
                        <div class="col-sm-2">
                            <label >经济条件：</label>
                            <select name="economicIndex" class="selectpicker bla bla bli" multiple data-live-search="true">
                            <#list info.economic as economic>
                                <option type="checkbox" value="${economic.id!}" > <i></i> ${economic.value!}</option>
                            </#list>
                            </select>
                        </div>
                        <div class="col-sm-2 pq jw">
                            <label >片<span style="color: white">填充</span>区：</label>
                            <select name="district" class="selectpicker bla bla bli" multiple data-live-search="true">
                            <#list info.district as district>
                                <option  value="${district.id!}" > ${district.value!}</option>
                            </#list>
                            </select>
                        </div>
                        <div class="col-sm-2 jw">
                            <label >居<span style="color: white">填充</span>委：</label>
                            <select  name="jw" class="selectpicker bla bla bli" multiple data-live-search="true">
                            <#list info.organ as organ>
                                <option value="${organ.id!}"> ${organ.name!}</option>
                            </#list>
                            </select>
                        </div>
                    </div>
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered table-hover dataTables-example text-nowrap">
                            <thead>
                            <tr>
                                <#if type=="bind">
                                    <th><input type='checkbox' onclick="thCheck(this)" /></th>
                                </#if>
                                 <th>序号</th>
                                <th>片区</th>
                                <th>居委</th>
                                <th>小区</th>
                                <th>姓名</th>
                                <th>性别</th>
                                <th>年龄</th>
                                <th>政治面貌</th>
                                <th>户籍</th>
                                <th>更新时间</th>
                                <th></th>
                                <th>备注</th>
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



<#include "bind_implement.ftl" />
<script>
    var labelId="${labelId}";
    var type="${type}";
</script>

<#include "bind_man_select.ftl" />
<script src="/js/content.min.js?v=1.0.0"></script>
<script src="/static/js/common.js"></script>
<script src="/static/js/oldman/label/bind.js" ></script>
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>

</body>

</html>