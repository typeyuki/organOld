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
                    <h5>${((type!0)==9)?string("积分","一卡通")}<small>记录</small></h5>
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
                        <a  href="javascript:void(0);" id="search" class="btn btn-primary ">搜索</a>
                    </div>
                    <div class="row">
                        <#if type?? && type!=0>
                            <div style="display: none" class="col-sm-2">
                                <label >类型</label>
                                <select name="type" class="form-control inp" style="width: 80%">
                                    <option value="9" selected>积分记录</option>
                                </select>
                            </div>
                            <#else >
                                <div class="col-sm-2">
                                    <label >类型</label>
                                    <select name="type" class="form-control inp" style="width: 80%">
                                        <option></option>
                                        <option value="1">消费记录</option>
                                        <option value="2">签到记录</option>
                                        <option value="3">老人信息查询记录</option>
                                        <option value="4">老人积分查询记录</option>
                                        <option value="5">充钱</option>
                                        <option value="6">卡挂失</option>
                                        <option value="7">卡不可用</option>
                                        <option value="8">卡可用</option>
                                    </select>
                                </div>
                        </#if>
                        <div class="col-sm-5">
                            <label >时间范围</label>
                            <input class="form-control inp" type="date" name="startDate" style="width: 40%">-
                            <input class="form-control inp" type="date" name="endDate" style="width: 40%">
                        </div>
                    </div>
                    <table class="table table-striped table-bordered table-hover dataTables-example">
                        <thead>
                        <tr>
                            <th>序号</th>
                            <th>时间</th>
                            <th>增加方式</th>
                        <#if type?? && type!=0>
                        <#else>

                            <th>机构</th>
                        </#if>
                            <th>${(type?? && type!=0)?string("增加积分","金额")}</th>
                            <th>${(type?? && type!=0)?string("积分变动","金额变动")}</th>
                        <#if type?? && type!=0>
                        <#else>
                            <th>单号</th>
                        </#if>
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
    var id=${id!};
    var type=${type!0};
</script>

<script src="/js/content.min.js?v=1.0.0"></script>
<script src="/static/js/common.js"></script>
<script src="/static/js/card/record.js" ></script>
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>

</body>

</html>