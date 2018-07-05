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
                        <a onclick=newPage("132","用户添加",'/oldman/add') href="javascript:void(0);" class="btn btn-primary ">添加</a>
                        <a  href="javascript:void(0);" class="btn btn-primary ">删除</a>
                    </div>
                    <div class="row">
                        <div class="col-sm-10">
                            <input class="id" type="text" placeholder="序号">
                            <label >性别</label>
                            <select name="sex">
                                <option></option>
                                <#list (info.sex)?keys as key>
                                    <option  value="${key!}"> ${(info.sex)?values[key_index]!}</option>
                                </#list>
                            </select>
                            <input class="age" name="ageStart" type="text" placeholder="年龄段-起">
                            <input class="age" type="text" placeholder="年龄段-止">
                            <input class="" type="text" placeholder="模糊匹配">
                        </div>
                        <div class="col-sm-2">
                            <button id="search">搜索</button>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-10">
                            <label >户籍：</label>
                            <select  class="selectpicker bla bla bli" multiple data-live-search="true">
                                <#list info.census as census>
                                    <option type="checkbox" value="${census.id!}" >${census.value!}</option>
                                </#list>
                            </select>
                            <label >政治面貌：</label>
                            <select  class="selectpicker bla bla bli" multiple data-live-search="true">
                                <#list info.politicalStatuses as politicalStatuses>
                                    <option value="${politicalStatuses.id!}">${politicalStatuses.value!}</option>
                                </#list>
                            </select>
                            <label>家庭结构：</label>
                            <select  class="selectpicker bla bla bli" multiple data-live-search="true">
                                <#list info.family as family>
                                    <option value="${family.id!}"> <i></i> ${family.value!}</option>
                                </#list>
                            </select>
                            <label >经济条件：</label>
                            <select  class="selectpicker bla bla bli" multiple data-live-search="true">
                                <#list info.economic as economic>
                                    <option type="checkbox" value="${economic.id!}" > <i></i> ${economic.value!}</option>
                                </#list>
                            </select>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-10">
                            <label >健康状况：</label>
                            <select class="selectpicker bla bla bli" multiple data-live-search="true">
                                <option value="1">有慢病</option>
                                <option value="2">有失能情况</option>
                                <option value="3">有药物反应</option>
                                <option value="4">有恶性肿瘤史</option>
                                <option value="5">有骨折史</option>
                                <option value="6">有残疾史</option>
                            </select>
                            <label >智力：</label>
                            <select class="selectpicker bla bla bli" multiple data-live-search="true">
                                <#list info.intelligence as intelligence>
                                    <option value="${intelligence.id!}" > ${intelligence.value!}</option>
                                </#list>
                            </select>
                            <label>视力：</label>
                            <select class="selectpicker bla bla bli" multiple data-live-search="true">
                                <#list info.eyesight as eyesight>
                                    <option value="${eyesight.id!}"> ${eyesight.value!}</option>
                                </#list>
                            </select>
                        </div>
                    </div>
                        <div class="row">
                            <div class="col-sm-10">
                                <label >片区：</label>
                                <select class="selectpicker bla bla bli" multiple data-live-search="true">
                                    <#list info.district as district>
                                        <option  value="${district.id!}" > ${district.value!}</option>
                                    </#list>
                                </select>
                                <label >居委：</label>
                                <select class="selectpicker bla bla bli" multiple data-live-search="true">
                                    <#list info.organ as organ>
                                        <option value="${organ.id!}"> ${organ.name!}</option>
                                    </#list>
                                </select>
                            </div>
                    </div>

                        <form action="/oldman/importExcel" method="post" enctype="multipart/form-data">
                            <input type="file" name="file">
                            <input type="submit" value="导入">
                        </form>
                    <table class="table table-striped table-bordered table-hover dataTables-example">
                        <thead>
                        <tr>
                            <th><input type='checkbox' /></th>
                            <th>序号</th>
                            <th>片区</th>
                            <th>居委</th>
                            <th>小区</th>
                            <th>楼号</th>
                            <th>姓名</th>
                            <th>性别</th>
                            <th>年龄</th>
                            <th>政治面貌</th>
                            <th>户籍</th>
                            <th>电话</th>
                            <th>身份证号码</th>
                            <th>标签</th>
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

<#--<script src="/js/plugins/jeditable/jquery.jeditable.js"></script>-->

<script>
    <#if result??>
        alert("录入数据：${result.data.total}\n其中成功导入数据：${result.data.numSuccess}\n包括添加：${result.data.successAdd}\n更新：${result.data.successUpdate}\n删除：${result.data.successDel}\n失败：${result.data.numFail}");
    </#if>

    $(window).on('load', function () {
        $('.selectpicker').selectpicker({
            'selectedText': 'cat'
        });
    });

</script>


<script src="/js/content.min.js?v=1.0.0"></script>

<script src="/static/js/common.js" ></script>
<script src="/static/js/oldman/base.js" ></script>
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>

</body>

</html>