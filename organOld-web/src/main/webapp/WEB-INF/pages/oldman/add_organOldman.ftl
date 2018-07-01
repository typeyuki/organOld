<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <#include "../common/head.ftl" />
    <link href="/css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
    <link href="/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="/css/animate.min.css" rel="stylesheet">
    <link href="/css/style.min.css?v=4.0.0" rel="stylesheet">


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
                    <h5>老人信息 <small>添加</small></h5>
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
                        <div class="form-group">
                            <#list info.oldmanName as oldmanName>
                                <div class="col-sm-1">
                                    <div class="radio i-checks">
                                        <label>
                                            <input type="checkbox" value="${oldmanName.id}" name="district" > <i></i> ${oldmanName.value}</label>
                                    </div>
                                </div>
                            </#list>
                            <label class="col-sm-2 control-label">床位号</label>
                            <div class="col-sm-1">
                                <input value=""  name="num" > </input>
                            </div>
                            <label class="col-sm-2 control-label">入院时间</label>
                            <div class="col-sm-1">
                                <input value=""  name="timeIn" > </input>
                            </div>
                            <label class="col-sm-2 control-label">出院时间</label>
                            <div class="col-sm-1">
                                <input value=""  name="timeOut" > </input>
                            </div>
                        </div>

                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <div class="col-sm-4 col-sm-offset-2">
                                <button class="btn btn-primary" type="submit">添加</button>
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
<script src="/static/js/oldman/add_organ.js"></script>
<script>
    $(document).ready(function(){$(".i-checks").iCheck({checkboxClass:"icheckbox_square-green",radioClass:"iradio_square-green",})});
</script>
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
</body>

</html>