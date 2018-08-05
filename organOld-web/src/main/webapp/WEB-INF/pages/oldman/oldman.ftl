<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <#include "../common/head.ftl" />

    <link href="/css/style.min.css?v=4.0.0" rel="stylesheet">
    <link href="/static/css/common_table.css" rel="stylesheet">
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
                    <div>
                        <button onclick=newPage(15,"管理","/autoValue/1") class="btn btn-primary" >管理</button>
                        <#--<a onclick=newPage("132","用户添加",'/oldman/add') href="javascript:void(0);" class="btn btn-primary ">添加</a>-->
                        <a  onclick="del('/oldman/base/del')" class="btn btn-primary ">删除</a>
                        <a  href="javascript:void(0);" id="search" class="btn btn-primary ">搜索</a>
                        <a  onclick="$('#exportModal').modal()" class="btn btn-primary ">导出</a>
                        <form action="/oldman/importExcel" method="post" enctype="multipart/form-data" id="importForm" style="display: inline">
                            <input type="button" style="display:inline" class="btn btn-primary" onclick="$('.wrapper').hide();$('#process').show();$('#importForm').submit()" value="导入">
                            <input type="file" name="file" style="display:inline">
                        </form>
                    </div>
                    <form action="/oldman/export" id="exportForm" method="post">
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
                                <input class="age form-control inp" name="ageStart" type="text" placeholder="年龄段-起">-
                                <input class="age form-control inp" name="ageEnd" type="text" placeholder="年龄段-止">
                            </div>
                            <div class="col-sm-4">
                                <input name="search" class="form-control inp"  type="text" placeholder="模糊匹配">
                            </div>
                            <div class="col-sm-2" style="position: relative;bottom: 25px">
                                <label >家庭类别：</label>
                                <select name="familyTypeArray" class="selectpicker bla bla bli" multiple data-live-search="true">
                                <#list info.familyType as list>
                                    <option value="${list.id!}">${list.value!}</option>
                                </#list>
                                </select>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-2">
                                <label >户<span style="color: white">填充</span>籍：</label>
                                <select name="censusArray"  class="selectpicker bla bla bli" multiple data-live-search="true">
                                <#list info.census as census>
                                    <option type="checkbox" value="${census.id!}" >${census.value!}</option>
                                </#list>
                                </select>
                            </div>
                            <div class="col-sm-2">
                                <label >政治面貌：</label>
                                <select name="politicalStatusArray" class="selectpicker bla bla bli" multiple data-live-search="true">
                                <#list info.politicalStatuses as politicalStatuses>
                                    <option value="${politicalStatuses.id!}">${politicalStatuses.value!}</option>
                                </#list>
                                </select>
                            </div>
                            <div class="col-sm-2">
                                <label>家庭结构：</label>
                                <select name="familyArray"  class="selectpicker bla bla bli" multiple data-live-search="true">
                                <#list info.family as family>
                                    <option value="${family.id!}"> <i></i> ${family.value!}</option>
                                </#list>
                                </select>
                            </div>
                            <div class="col-sm-2">
                                <label >经济条件：</label>
                                <select name="economicArray" class="selectpicker bla bla bli" multiple data-live-search="true">
                                <#list info.economic as economic>
                                    <option type="checkbox" value="${economic.id!}" > <i></i> ${economic.value!}</option>
                                </#list>
                                </select>
                            </div>
                            <div class="col-sm-2">
                                <label >健康状况：</label>
                                <select name="isHealth" class="selectpicker bla bla bli" multiple data-live-search="true">
                                    <option value="1">有慢病</option>
                                    <option value="2">有失能情况</option>
                                    <option value="3">有药物反应</option>
                                    <option value="4">有恶性肿瘤史</option>
                                    <option value="5">有骨折史</option>
                                    <option value="6">有残疾史</option>
                                </select>
                            </div>
                            <div class="col-sm-2">
                                <label >职<span style="color: white">填充</span>称：</label>
                                <select name="zcArray" class="selectpicker bla bla bli" multiple data-live-search="true">
                                <#list info.zc as list>
                                    <option value="${list.id!}" > ${list.value!}</option>
                                </#list>
                                </select>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-2">
                                <label >社区职务：</label>
                                <select name="sqzwArray" class="selectpicker bla bla bli" multiple data-live-search="true">
                                <#list info.sqzw as list>
                                    <option value="${list.id!}" > ${list.value!}</option>
                                </#list>
                                </select>
                            </div>
                            <div class="col-sm-2">
                                <label >智<span style="color: white">填充</span>力：</label>
                                <select name="intelligence" class="selectpicker bla bla bli" multiple data-live-search="true">
                                <#list info.intelligence as intelligence>
                                    <option value="${intelligence.id!}" > ${intelligence.value!}</option>
                                </#list>
                                </select>
                            </div>
                            <div class="col-sm-2">
                                <label>视<span style="color: white">填充</span>力：</label>
                                <select name="eyesight" class="selectpicker bla bla bli" multiple data-live-search="true">
                                <#list info.eyesight as eyesight>
                                    <option value="${eyesight.id!}"> ${eyesight.value!}</option>
                                </#list>
                                </select>
                            </div>
                            <div class="col-sm-2">
                                <label>养老状态：</label>
                                <select name="oldStatusArray" class="selectpicker bla bla bli" multiple data-live-search="true">
                                <#list (info.oldStatus)?keys as key>
                                    <option  value="${key!}"> ${(info.oldStatus)?values[key_index]!}</option>
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
                        <script>
                            $.ajax({
                                url: "/user/checkUserOrganType",
                                type: "get",
                                success: function (data) {
                                    if (data.success == true) {
                                        if(data.data=="居委会"){
                                            $(".jw").hide();
                                        }else if(data.data=="片区"){
                                            $(".pq").hide();
                                        }
                                    }
                                }
                            });
                        </script>


                    </form>


                    <div class="table-responsive">
                    <table id="table" class="table table-striped table-bordered table-hover dataTables-example text-nowrap">
                        <thead>
                        <tr>
                            <th style="width:15px;"><input type='checkbox' onclick="thCheck(this)" /></th>
                            <th index="id">序号</th>
                            <th>街道</th>
                            <th>片区</th>
                            <th>居委</th>
                            <th>姓名</th>
                            <th>性别</th>
                            <th>年龄</th>
                            <th>政治面貌</th>
                            <th>户籍</th>
                            <th>家庭结构</th>
                            <th>经济条件</th>
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

</div>
<#include  "../spinner.ftl"/>
<#include  "edit_base.ftl"/>
<#include  "base_export.ftl"/>

<script>
    <#if result??>
        alert("录入数据：${result.data.total}\n其中成功导入数据：${result.data.numSuccess}\n包括添加：${result.data.successAdd}\n更新：${result.data.successUpdate}\n删除：${result.data.successDel}\n失败：${result.data.numFail}");
    </#if>


</script>


<script src="/js/content.min.js?v=1.0.0"></script>

<script src="/static/js/common.js" ></script>
<script src="/static/js/oldman/oldman.js" ></script>
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>

</body>

</html>