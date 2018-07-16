<div class="modal fade" id="handleModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static" data-keyboard="false">
    <div class="modal-dialog" style="width: 80%">
        <div class="modal-content">
            <div class="modal-body">
                <div class="wrapper wrapper-content animated fadeInRight">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="ibox float-e-margins">
                                <div class="ibox-title">
                                    <h5>重点老人 <small></small></h5>
                                </div>
                                <div class="ibox-content">
                                    <form class="form-horizontal" >
                                        <input type="hidden" name="oldmanId">
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">服务类型</label>
                                            <div class="col-sm-2">
                                                <select name="type" onchange="handleTypeSelect(this)">
                                                    <option selected></option>
                                                    <option value="1">机构养老</option>
                                                    <option value="2">社区养老</option>
                                                    <option value="3">居家养老</option>
                                                    <option value="4">社区居家养老</option>
                                                </select>
                                            </div>

                                        </div>

                                        <div class="form-group" id="organ" style="display: none">
                                            <label class="col-sm-1 control-label">机构</label>
                                            <div class="col-sm-8">
                                                <select name="organIds" class="selectpicker bla bla bli" multiple data-live-search="true">
                                                <#list organ as list>
                                                    <option value="${list.id!}" > ${list.secType!}</option>
                                                </#list>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group" id="home" style="display: none">
                                            <label class="col-sm-1 control-label">居家</label>
                                            <div class="col-sm-8">
                                                <select name="homeFirTypes" class="selectpicker bla bla bli" multiple data-live-search="true">
                                                    <option value="1">家庭服务</option>
                                                    <option value="2">长护险</option>
                                                    <option value="3">智能终端</option>
                                                    <option value="4">家庭医生</option>
                                                    <option value="5">家庭病床</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group" id="no" style="display: none">
                                            <button class="col-sm-2 btn btn-primary" onclick="handleSubmit('delete')">设置为未处理</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
            <div class="modal-footer">

                <a onclick="handleSubmit('add')" href="javascript:void(0);" class="btn btn-primary sub">提交</a>

                <a data-dismiss="modal" href="javascript:void(0);" class="btn btn-primary ">关闭</a>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>

<script>
    $('.selectpicker').selectpicker({
        'selectedText': 'cat'
    });
    function handleTypeSelect(obj) {
        var val=$(obj).val();
        $("#organ").val("");
        $("#home").val("");
        if(val==1 || val==2){
            $("#organ").show();
            $("#home").hide();
        }
        if(val==3){
            $("#organ").hide();
            $("#home").show();
        }
        if(val==4){
            $("#organ").show();
            $("#home").show();
        }
    }

    function handleSubmit(type) {
        $.ajax({
            url: "/oldman/key/handle",
            data : {
                "oldmanId":$("#handleModal input[name='oldmanId']").val(),
                "type":$("#handleModal select[name='type']").val(),
                "organIds_array":$("#handleModal select[name='organIds']").val(),
                "homeFirTypes_array":$("#handleModal select[name='homeFirTypes']").val(),
                "handle":type
            },
            type: 'POST',
            dataType: 'json',
            success: function (result) {
                $("#handleModal").modal('hide');
                if(type=="add"){
                    $(obj).html("已处理");
                    var click=$(obj).attr("onclick");
                    click=click.replace("no","yes");
                    $(obj).attr("onclick",click).attr("class","btn btn-default");
                }else if(type=="delete"){
                    $(obj).html("未处理");
                    var click=$(obj).attr("onclick");
                    click=click.replace("yes","no");
                    $(obj).attr("onclick",click).attr("class","btn btn-primary");
                }
            }
        });
    }
</script>