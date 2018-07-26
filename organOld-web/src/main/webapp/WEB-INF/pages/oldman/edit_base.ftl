

<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static" data-keyboard="false">
    <div class="modal-dialog" style="width: 80%">
        <div class="modal-content">
            <div class="modal-body">
                <div class="wrapper wrapper-content animated fadeInRight">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="ibox float-e-margins">
                                <div class="ibox-title">
                                    <h5></h5>
                                </div>
                                <div class="ibox-content">
                                    <form method="post" id="oldmanEdit" class="form-horizontal" action="/oldman/base/update">
                                        <input type="hidden" name="id">
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">姓名</label>
                                            <div class="col-sm-8">
                                                <input type="text" name="name">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">小区</label>
                                            <div class="col-sm-8">
                                                <select name="xqId"  class="search_select" data-live-search="true">
                                                    <option></option>
                                                    <#list info.xq as list>
                                                        <option type="checkbox" value="${list.id!}" >${list.value!}</option>
                                                    </#list>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">楼号</label>
                                            <div class="col-sm-8">
                                                <input type="text" class="form-control" name="louNum"/>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">性别</label>
                                            <div class="col-sm-8">
                                                <label>
                                                <input type="radio" class="form-control" value="2" name="sex" > <i></i> 男</label>
                                                <label>
                                                    <input type="radio" class="form-control" value="1" name="sex" > <i></i> 女</label>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">出生日期</label>
                                            <div class="col-sm-8">
                                                <input type="date" class="form-control" name="birthdayTime"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">政治面貌</label>
                                            <div class="col-sm-8">
                                                <select class="search_select" name="politicalStatus">
                                                    <option></option>
                                                    <#list info.politicalStatuses as politicalStatuses>
                                                        <option value="${politicalStatuses.id!}">${politicalStatuses.value!}</option>
                                                    </#list>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">户籍</label>
                                            <div class="col-sm-8">
                                                <select class="search_select" name="census">
                                                    <option></option>
                                                    <#list info.census as census>
                                                        <option type="checkbox" value="${census.id!}" >${census.value!}</option>
                                                    </#list>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">职称</label>
                                            <div class="col-sm-8">
                                                <select class="search_select" name="zc">
                                                    <option></option>
                                                <#list info.zc as list>
                                                    <option type="checkbox" value="${list.id!}" >${list.value!}</option>
                                                </#list>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">社区职务</label>
                                            <div class="col-sm-8">
                                                <select  class="selectpicker bla bla bli" multiple data-live-search="true" name="sqzw">
                                                    <option></option>
                                                    <#list info.sqzw as list>
                                                        <option type="checkbox" value="${list.id!}" >${list.value!}</option>
                                                    </#list>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">电话</label>
                                            <div class="col-sm-8">
                                                <input type="text" class="form-control" name="phone"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">身份证号码</label>
                                            <div class="col-sm-8">
                                                <input type="text" class="form-control" name="pid"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">地址</label>
                                            <div class="col-sm-8">
                                                <input type="text" class="form-control" name="address"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">如果住在无电梯楼宇，几楼</label>
                                            <div class="col-sm-8">
                                                <input type="text" class="form-control" name="floor"/>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
            <div class="modal-footer">
                <a onclick="$('#oldmanEdit').submit()" href="javascript:void(0);" class="btn btn-primary ">修改</a>
                <a data-dismiss="modal" href="javascript:void(0);" class="btn btn-primary ">关闭</a>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>


