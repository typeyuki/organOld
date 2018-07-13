<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="/css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
    <link href="/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="/css/style.min.css?v=4.0.0" rel="stylesheet">
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>社会涉老服务机构 <small>注册</small></h5>
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
                    <form method="post" action="/organ/reg" class="form-horizontal"  enctype="multipart/form-data">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">申请人信息</label>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">手机号</label>
                            <div class="col-sm-5">
                                <input type="text" class="form-control" name="phone" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">验证码</label>
                            <div class="col-sm-2">
                                <input placeholder="请输入收到的验证码" type="text" class="form-control">
                            </div>
                            <div class="col-xs-1">
                                <input type="button" onclick="" class="btn btn-primary" value="获取验证码" id="sendCode">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">邮箱</label>
                            <div class="col-sm-5">
                                <input type="text" class="form-control" value="" name="email"/>
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">机构信息</label>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">名称</label>
                            <div class="col-sm-5">
                                <input type="text" class="form-control" value="" name="name"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">简介</label>
                            <div class="col-sm-5">
                                <input type="text" class="form-control" value="" name="intro"/>
                            </div>
                        </div>
                        <#--<div class="hr-line-dashed"></div>-->
                        <div class="form-group">
                            <label class="col-sm-2 control-label">席位数</label>
                            <div class="col-sm-5">
                                <input type="text" class="form-control" value="" name="num"/>
                            </div>
                        </div>
                        <#--<div class="hr-line-dashed"></div>-->
                        <div class="form-group">
                            <label class="col-sm-2 control-label">服务时间</label>
                            <div class="col-sm-5">
                                <input type="text" class="form-control" value="" name="serviceTime"/>
                            </div>
                        </div>
                        <#--<div class="hr-line-dashed"></div>-->
                        <div class="form-group">
                            <label class="col-sm-2 control-label">地址</label>
                            <div class="col-sm-5">
                                <input type="text" class="form-control" value="" name="address"/>
                            </div>
                        </div>
                        <#--<div class="hr-line-dashed"></div>-->
                        <div class="form-group">
                            <label class="col-sm-2 control-label">联系方式</label>
                            <div class="col-sm-5">
                                <input type="text" class="form-control" value="" name="orgPhone"/>
                            </div>
                        </div>
                        <#--<div class="hr-line-dashed"></div>-->
                        <div class="form-group">
                            <label class="col-sm-2 control-label">网站</label>
                            <div class="col-sm-5">
                                <input type="text" class="form-control" value="" name="webUrl"/>
                            </div>
                        </div>
                        <#--<div class="hr-line-dashed"></div>-->
                        <div class="form-group">
                            <label class="col-sm-2 control-label">照片</label>
                            <div class="col-sm-5">
                                <input type="file" class="form-control" value="" name="pic"/>
                            </div>
                        </div>
                        <#--<div class="hr-line-dashed"></div>-->
                        <div class="form-group">
                            <label class="col-sm-2 control-label">服务内容</label>
                            <div class="col-sm-5">
                                <input type="text" class="form-control" value="" name="work"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">所属片区</label>
                            <div class="col-sm-5">
                                <select name="districtId">
                                    <option value="">不限</option>
                                    <#list info.district as district>
                                        <option value="${district.id}">${district.value}</option>
                                    </#list>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">类型</label>
                            <div class="col-sm-5">
                                <select name="organTypeId" >
                                    <#list info.organTypeList as list>
                                        <option value="${list.id}">${list.secType}</option>
                                    </#list>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">权限升级</label>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" value="consume"  name="auth"> <i></i> 消费</label>
                                </div>
                            </div>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" value="sign"  name="auth" > <i></i> 签到</label>
                                </div>
                            </div>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" value="product"  name="auth"> <i></i> 商品</label>
                                </div>
                            </div>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" value="info"  name="auth"> <i></i> 老人信息查询</label>
                                </div>
                            </div>
                            <div class="col-sm-1">
                                <div class="checkbox i-checks">
                                    <label>
                                        <input type="checkbox" value="integral"  name="auth"> <i></i> 积分查询</label>
                                </div>
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <div class="col-sm-4 col-sm-offset-2">
                                <button class="btn btn-primary" type="submit">提交</button>
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
<script src="/js/plugins/iCheck/icheck.min.js"></script>
<script>
    $(document).ready(function(){
        $(".i-checks").iCheck({checkboxClass:"icheckbox_square-green",radioClass:"iradio_square-green"})
    });
</script>
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
</body>

</html>