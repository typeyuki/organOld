<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static" data-keyboard="false">
    <div class="modal-dialog" style="width: 80%">
        <div class="modal-content">
            <div class="modal-body">
                <div class="wrapper wrapper-content animated fadeInRight">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="ibox float-e-margins">
                                <div class="ibox-title">
                                    <h5>
                                        ${title}
                                        <small></small></h5>
                                </div>
                                <div class="ibox-content">
                                    <form method="post" id="homeForm" class="form-horizontal" action="/home/add">
                                        <input type="hidden" value="${type}" name="firType">
                                        <input type="hidden" name="id">
                                    <#if type==1 || type==3>
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">名称</label>
                                            <div class="col-sm-8">
                                                <input type="text" class="form-control" name="secType"/>
                                            </div>
                                        </div>
                                    </#if>
                                    <#if type==2>
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">级别</label>
                                            <div class="col-sm-8">
                                                <input type="text" class="form-control" name="chx.level"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">服务时间</label>
                                            <div class="col-sm-8">
                                                <input type="text" class="form-control" name="chx.serviceTime"/>
                                            </div>
                                        </div>
                                    </#if>
                                    <#if type==4>
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">名称</label>
                                            <div class="col-sm-8">
                                                <input type="text" class="form-control" name="doctor.name"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">医院</label>
                                            <div class="col-sm-8">
                                                <select name="doctor.organId"  class="search_select" data-live-search="true">
                                                    <option></option>
                                                    <#list organ as list>
                                                        <option type="checkbox" value="${list.id!}" >${list.name!}</option>
                                                    </#list>
                                                </select>
                                            </div>
                                        </div>
                                    </#if>
                                    <#if type==5>
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">医院</label>
                                            <div class="col-sm-8">
                                                <select name="secType"  class="search_select" data-live-search="true">
                                                    <option></option>
                                                    <#list organ as list>
                                                        <option type="checkbox" value="${list.id!}" >${list.name!}</option>
                                                    </#list>
                                                </select>
                                            </div>
                                        </div>
                                    </#if>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
            <div class="modal-footer">

                <a onclick="$('#homeForm').submit()" href="javascript:void(0);" class="btn btn-primary " id="subBtn">添加</a>

                <a data-dismiss="modal" href="javascript:void(0);" class="btn btn-primary ">关闭</a>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>


