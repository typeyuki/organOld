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
                                    <form method="post" id="oldmanEdit" class="form-horizontal" action="/oldman/health/update">
                                        <input type="hidden" name="id">
                                        <input type="hidden" name="oldmanId">
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">血型</label>
                                            <div class="col-sm-8">
                                                <input type="text" class="form-control inp" name="bloodType">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">失智</label>
                                            <div class="col-sm-8">
                                                <select name="intelligence"  class="search_select" data-live-search="true">
                                                    <option></option>
                                                    <#list info.intelligence as list>
                                                        <option type="checkbox" value="${list.id!}" >${list.value!}</option>
                                                    </#list>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">视力</label>
                                            <div class="col-sm-8">
                                                <select name="eyesight"  class="search_select" data-live-search="true">
                                                    <option></option>
                                                <#list info.eyesight as list>
                                                    <option type="checkbox" value="${list.id!}" >${list.value!}</option>
                                                </#list>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">慢病
                                            </label>
                                        <#list info.mb as list>
                                            <div class="col-sm-1">
                                                <div class="radio i-checks">
                                                    <label>
                                                        <input type="checkbox" value="${list.id}" name="healthSelect" > <i></i> ${list.secTypeName}</label>
                                                </div>
                                            </div>
                                        </#list>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">失能
                                            </label>
                                        <#list info.sn as list>
                                            <div class="col-sm-1">
                                                <div class="radio i-checks">
                                                    <label>
                                                        <input type="checkbox" value="${list.id}" name="healthSelect" > <i></i> ${list.secTypeName}</label>
                                                </div>
                                            </div>
                                        </#list>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">药物反应
                                            </label>
                                        <#list info.ywfy as list>
                                            <div class="col-sm-1">
                                                <div class="radio i-checks">
                                                    <label>
                                                        <input type="checkbox" value="${list.id}" name="healthSelect" > <i></i> ${list.secTypeName}</label>
                                                </div>
                                            </div>
                                        </#list>
                                        </div>
                                        <div class="form-group" >
                                            <label class="col-sm-2 control-label">恶性肿瘤史
                                            </label>
                                            <div class="col-sm-8" id="exzl">
                                            </div>
                                        </div>
                                        <div class="form-group" >
                                            <label class="col-sm-2 control-label">骨折史
                                            </label>
                                            <div class="col-sm-8" id="gz">

                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">残疾情况
                                            </label>
                                            <div class="col-sm-8" id="cj">

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
                <a onclick="healthSub()" href="javascript:void(0);" class="btn btn-primary ">保存</a>
                <a data-dismiss="modal" href="javascript:void(0);" class="btn btn-primary ">关闭</a>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>


<script>
    function healthSub() {
        $("input[name='healthSelect']").each(function () {
            $(this).attr("name","healthSelectIds");
        });
        $("#oldmanEdit").submit();
    }
</script>

