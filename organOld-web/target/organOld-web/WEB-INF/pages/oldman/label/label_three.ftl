<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <#include "../../common/head.ftl" />

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
                    <h5>标签<small>人员绑定</small></h5>
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
                        <a onclick="$('#selectModal').modal()" href="javascript:void(0);" class="btn btn-primary ">添加</a>
                        <a onclick=newPage("133","一级标签",'/oldman/label/type/1') href="javascript:void(0);" class="btn btn-primary jw">一级标签</a>
                        <a onclick=newPage("133","二级标签",'/oldman/label/type/2') href="javascript:void(0);" class="btn btn-primary jw">二级标签</a>
                        <a onclick="del('/oldman/label/del')"  href="javascript:void(0);" class="btn btn-primary ">删除</a>
                        <a  href="javascript:void(0);" id="search" class="btn btn-primary ">搜索</a>

                        <script>
                            $.ajax({
                                url: "/user/checkUserOrganType",
                                type: "get",
                                success: function (data) {
                                    if (data.success == true) {
                                        if(data.data=="居委会" || data.data=="片区"){
                                            $(".jw").hide();
                                        }
                                    }
                                }
                            });
                        </script>
                    </div>
                    <div>
                        <#if type=="2">
                            <div class="row" >
                                <form class="form-horizontal">
                                    <div class="col-sm-2"><input type="text" name="id" class="form-control inp" placeholder="序号"/></div>
                                    <div class="col-sm-2"><input type="text" name="wh" class="form-control inp" placeholder="文号"/></div>
                                    <div class="col-sm-2">
                                        <input class="age form-control inp" style="width: 48%" name="ageStart" type="text" placeholder="年龄段-起">-
                                        <input class="age form-control inp" style="width: 48%" name="ageEnd" type="text" placeholder="年龄段-止">
                                    </div>
                                    <div class="col-sm-2">
                                        <input type="text" name="search" class="form-control inp" value="" placeholder="模糊搜索"/>
                                    </div>
                                    <div class="col-sm-2">
                                        <label >性别</label>
                                        <select name="sex" class="form-control inp" style="width: 80%">
                                            <option></option>
                                            <#list (rule.sex)?keys as key>
                                                <option  value="${key!}"> ${(rule.sex)?values[key_index]!}</option>
                                            </#list>
                                        </select>
                                    </div>
                                    <div class="col-sm-2">
                                        <label >是否是重点老人</label>
                                        <select name="isKey"  class="form-control inp" style="width: 53%">
                                            <option></option>
                                            <#list (rule.isKey)?keys as key>
                                                <option  value="${key!}"> ${(rule.isKey)?values[key_index]!}</option>
                                            </#list>
                                        </select>
                                    </div>
                                </form>
                            </div>
                            <div class="row">
                                <div class="col-sm-2">
                                    <label >户<span style="color: white">填充</span>籍：</label>
                                    <select name="census_array"  class="selectpicker bla bla bli" multiple data-live-search="true">
                                        <#list rule.census as census>
                                            <option type="checkbox" value="${census.id!}" >${census.value!}</option>
                                        </#list>
                                    </select>
                                </div>
                                <div class="col-sm-2">
                                    <label >政治面貌：</label>
                                    <select name="politicalStatus_array" class="selectpicker bla bla bli" multiple data-live-search="true">
                                        <#list rule.politicalStatuses as politicalStatuses>
                                            <option value="${politicalStatuses.id!}">${politicalStatuses.value!}</option>
                                        </#list>
                                    </select>
                                </div>
                                <div class="col-sm-2">
                                    <label>家庭结构：</label>
                                    <select name="family_array"  class="selectpicker bla bla bli" multiple data-live-search="true">
                                        <#list rule.family as family>
                                            <option value="${family.id!}"> <i></i> ${family.value!}</option>
                                        </#list>
                                    </select>
                                </div>
                                <div class="col-sm-2">
                                    <label >经济条件：</label>
                                    <select name="economic_array" class="selectpicker bla bla bli" multiple data-live-search="true">
                                        <#list rule.economic as economic>
                                            <option type="checkbox" value="${economic.id!}" > <i></i> ${economic.value!}</option>
                                        </#list>
                                    </select>
                                </div>
                                <div class="col-sm-2">
                                    <label >健康状况：</label>
                                    <select name="isHealth_array" class="selectpicker bla bla bli" multiple data-live-search="true">
                                        <option value="1">有慢病</option>
                                        <option value="2">有失能情况</option>
                                        <option value="3">有药物反应</option>
                                        <option value="4">有恶性肿瘤史</option>
                                        <option value="5">有骨折史</option>
                                        <option value="6">有残疾史</option>
                                    </select>
                                </div>
                                <div class="col-sm-2">
                                    <label >智<span style="color: white">填充</span>力：</label>
                                    <select name="intelligence_array" class="selectpicker bla bla bli" multiple data-live-search="true">
                                        <#list rule.intelligence as intelligence>
                                            <option value="${intelligence.id!}" > ${intelligence.value!}</option>
                                        </#list>
                                    </select>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-2">
                                    <label>视<span style="color: white">填充</span>力：</label>
                                    <select name="eyesight_array" class="selectpicker bla bla bli" multiple data-live-search="true">
                                        <#list rule.eyesight as eyesight>
                                            <option value="${eyesight.id!}"> ${eyesight.value!}</option>
                                        </#list>
                                    </select>
                                </div>
                                <div class="col-sm-2">
                                    <label>养老状态：</label>
                                    <select name="oldStatus_array" class="selectpicker bla bla bli" multiple data-live-search="true">
                                        <#list (rule.oldStatus)?keys as key>
                                            <option  value="${key!}"> ${(rule.oldStatus)?values[key_index]!}</option>
                                        </#list>
                                    </select>
                                </div>
                                <div class="col-sm-2">
                                    <label >长护险<span style="color: white">填</span>：</label>
                                    <select name="chx_array" class="selectpicker bla bla bli" multiple data-live-search="true">
                                        <#list rule.chx as list>
                                            <option  value="${list.id!}" > ${list.level!}</option>
                                        </#list>
                                    </select>
                                </div>
                                <div class="col-sm-2">
                                    <label >片<span style="color: white">填充</span>区：</label>
                                    <select name="district_array" class="selectpicker bla bla bli" multiple data-live-search="true">
                                        <#list rule.district as district>
                                            <option  value="${district.id!}" > ${district.value!}</option>
                                        </#list>
                                    </select>
                                </div>
                                <div class="col-sm-2">
                                    <label >居<span style="color: white">填充</span>委：</label>
                                    <select  name="jw_array" class="selectpicker bla bla bli" multiple data-live-search="true">
                                        <#list rule.organ as organ>
                                            <option value="${organ.id!}"> ${organ.name!}</option>
                                        </#list>
                                    </select>
                                </div>
                                <div class="col-sm-2">
                                    <label> 所属机构：</label>
                                    <select  name="belongOrgan" class="search_select" data-live-search="true">
                                        <option></option>
                                        <#list rule.belongOrgan as organ>
                                            <option value="${organ.id!}"> ${organ.name!}</option>
                                        </#list>
                                    </select>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-2">
                                    <label >一级标签：</label>
                                    <select name="fir" class="search_select" data-live-search="true">
                                        <option></option>
                                        <#list rule.firLabel as list>
                                            <option  value="${list.id!}" > ${list.value!}</option>
                                        </#list>
                                    </select>
                                </div>
                                <div class="col-sm-2">
                                    <label >二级标签：</label>
                                    <select  name="sec" class="search_select" data-live-search="true">
                                        <option></option>
                                        <#list rule.secLabel as list>
                                            <option value="${list.id!}"> ${list.secName!}</option>
                                        </#list>
                                    </select>
                                </div>
                            </div>
                            <#else >
                                <div class="row" >
                                    <form class="form-horizontal">
                                        <div class="col-sm-2" style="padding-top: 20px"><input type="text" name="id" class="form-control inp" placeholder="序号"/></div>
                                        <div class="col-sm-2" style="padding-top: 20px"><input type="text" name="wh" class="form-control inp" placeholder="文号"/></div>
                                        <div class="col-sm-2" style="padding-top: 20px">
                                            <input type="text" name="search" class="form-control inp" value="" placeholder="模糊搜索"/>
                                        </div>
                                    </form>
                                    <div class="col-sm-2">
                                        <label> 所属机构：</label>
                                        <select  name="belongOrgan" class="search_select" data-live-search="true">
                                            <option></option>
                                            <#list rule.belongOrgan as organ>
                                                <option value="${organ.id!}"> ${organ.name!}</option>
                                            </#list>
                                        </select>
                                    </div>
                                    <div class="col-sm-2">
                                        <label >一级标签：</label>
                                        <select name="fir" class="search_select" data-live-search="true">
                                            <option></option>
                                            <#list rule.firLabel as list>
                                                <option  value="${list.id!}" > ${list.value!}</option>
                                            </#list>
                                        </select>
                                    </div>
                                    <div class="col-sm-2">
                                        <label >二级标签：</label>
                                        <select  name="sec" class="search_select" data-live-search="true">
                                            <option></option>
                                            <#list rule.secLabel as list>
                                                <option value="${list.id!}"> ${list.secName!}</option>
                                            </#list>
                                        </select>
                                    </div>
                                </div>
                        </#if>
                    </div>
                    <table class="table table-striped table-bordered table-hover dataTables-example">
                        <thead>
                        <tr>
                            <th><input type='checkbox' onclick="thCheck(this)" /></th>
                            <th>序号</th>
                            <th>所属机构</th>
                            <th>一级菜单</th>
                            <th>二级菜单</th>
                            <th>名称</th>
                            <th>条件</th>
                            <th>内容</th>
                            <th>文号</th>
                            <th>开始时间</th>
                            <th>结束时间</th>
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
    var typeLabel="${type}";
    var userType;
    $.ajax({
        url: "/user/checkUserOrganType",
        type: "get",
        async:false,
        success: function (data) {
            if (data.success == true) {
                userType=data.data;
            }
        }
    });

    $('.search_select').searchableSelect();
</script>
<#include "add_label.ftl" />
<#include "edit_label.ftl" />
<script src="/js/content.min.js?v=1.0.0"></script>
<script src="/static/js/common.js"></script>
<script src="/static/js/oldman/label/label_three.js" ></script>
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>

</body>

</html>