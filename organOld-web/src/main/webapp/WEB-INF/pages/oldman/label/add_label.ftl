<div class="modal fade" id="selectModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static" data-keyboard="false">
    <div class="modal-dialog" style="width: 80%">
        <div class="modal-content">
            <div class="modal-body">
                <div class="wrapper wrapper-content animated fadeInRight">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="ibox float-e-margins">
                                <div class="ibox-title">
                                    <h5>标签 <small>添加</small></h5>
                                </div>
                                <div class="ibox-content">
                                    <form method="get" class="form-horizontal">
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">一级菜单</label>
                                            <select class="col-sm-1">
                                                <#list info.fir as fir>
                                                    <option value="${fir.id!}" name="xq" > <i></i> ${fir.value!}</option>
                                                </#list>
                                            </select>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">二级菜单</label>
                                            <select class="col-sm-1">
                                                <#list info.sec as sec>
                                                    <option value="${sec.id!}" name="xq" > <i></i> ${sec.value!}</option>
                                                </#list>
                                            </select>
                                            <label class="col-sm-3 control-label">名称</label>
                                            <select class="col-sm-1">
                                                <#list info.name as name>
                                                    <option value="${name.id!}" name="xq" > <i></i> ${name.value!}</option>
                                                </#list>
                                            </select>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">条件</label>
                                            <select class="col-sm-1">
                                                <#list info.rule as rule>
                                                    <option value="${rule.id!}" name="rule" > <i></i> ${rule.value!}</option>
                                                </#list>
                                            </select>
                                            <label class="col-sm-3 control-label">内容</label>
                                            <select class="col-sm-1">
                                                <#list info.content as content>
                                                    <option value="${content.id!}" name="content" > <i></i> ${content.value!}</option>
                                                </#list>
                                            </select>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">更新时间</label>
                                            <div class="col-sm-3">
                                                <input type="text" class="form-control" value="" />
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
                <a onclick="" href="javascript:void(0);" class="btn btn-primary ">添加</a>
                <a data-dismiss="modal" href="javascript:void(0);" class="btn btn-primary ">关闭</a>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>


