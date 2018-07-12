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
                    <h5>老人 <small>重点老人</small></h5>
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
                    <div class="func">

                        <a onclick="update('now')" href="#" class="btn btn-primary ">更新</a>
                        <a onclick="autoUpdate(true,this)" href="#" class="btn btn-primary ">开启自动更新</a>
                        <a onclick="newPage(999,'重点老人规则','/oldman/key/rule')" href="javascript:void(0);" class="btn btn-primary ">规则</a>
                    </div>
                    <script>
                        $.ajax({
                            url: "/user/checkUserOrganType",
                            type: "get",
                            success: function (data) {
                                if (data.success == true) {
                                    $(".func").hide();
                                }
                            }
                        });
                    </script>
                    <div>
                        <input type="date" id="futureTime">
                        <input type="hidden" name="future">
                        <input name="oldmanId" type="text" placeholder="老人序号">
                        <input name="goalStart" type="text" placeholder="最低分">-
                        <input name="goalEnd" type="text" placeholder="最高分">
                        <label >是否主动申请进养老院</label>
                        <select name="isActivity">
                            <option></option>
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>
                        <label >是否处理</label>
                        <select name="isHandle">
                            <option></option>
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>
                        <button id="search">搜索</button>
                    </div>
                    <table class="table table-striped table-bordered table-hover dataTables-example">
                        <thead>
                        <tr>
                            <th>老人序号</th>
                            <th>姓名</th>
                            <th id="goal">分数</th>
                            <th>是否处理</th>
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
<#include "key_handle.ftl" />
<script>
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
</script>
<script src="/js/content.min.js?v=1.0.0"></script>
<script src="/static/js/common.js"></script>
<script src="/static/js/oldman/key.js" ></script>
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>

</body>

</html>