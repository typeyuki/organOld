
<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static" data-keyboard="false">
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
                                    <form method="post" id="oldmanEdit" class="form-horizontal" action="/home/oldman/add">
                                        <input type="hidden" class="id"/>
                                        <div class="form-group lr">
                                            <label class="col-sm-1 control-label">老人</label>
                                            <div class="col-sm-8">
                                                <select  class="selectpicker bla bla bli" data-live-search="true" name="oldmanId">
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group jj">
                                            <label class="col-sm-1 control-label">居家养老</label>
                                            <div class="col-sm-8">
                                                <select name="homeId"  class="search_select jjyl" data-live-search="true" onchange="alert(1)">
                                                    <option></option>
                                                <#list info.homeList as list>
                                                    <option type="checkbox" value="${list.id!}" firType="${list.firType}">${list.firTypeDesc}:${list.secType}</option>
                                                </#list>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">服务机构</label>
                                            <div class="col-sm-8">
                                                <select name="organId"  class="search_select" data-live-search="true">
                                                    <option></option>
                                                <#list info.organList as list>
                                                    <option type="checkbox" value="${list.id!}" >${list.name!}</option>
                                                </#list>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group nochx">
                                            <label class="col-sm-1 control-label">服务开始时间</label>
                                            <div class="col-sm-8">
                                                <input type="date" class="form-control" name="timeIn"/>
                                            </div>
                                        </div>
                                        <div class="form-group nochx">
                                            <label class="col-sm-1 control-label">服务结束时间</label>
                                            <div class="col-sm-8">
                                                <input type="date" class="form-control" name="timeOut"/>
                                            </div>
                                        </div>
                                        <div class="form-group ischx">
                                            <label class="col-sm-1 control-label">是否获得服务</label>
                                            <div class="col-sm-1">
                                                <label>
                                                    <input type="radio" value="0" class="nocheck" name="isService" checked> <i></i>否</label>
                                            </div>
                                            <div class="col-sm-1">
                                                <label>
                                                    <input type="radio" value="1" name="isService"> <i></i> 是</label>
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
                <a onclick="$('#oldmanEdit').submit()" href="javascript:void(0);" class="btn btn-primary ">保存</a>
                <a data-dismiss="modal" href="javascript:void(0);" class="btn btn-primary ">关闭</a>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
<script>
    $('.selectpicker').selectpicker({
        'selectedText': 'cat'
    });
    $('.search_select').searchableSelect();

        $(".lr .input-block-level").on("keyup",function () {
            var search=$(this).val();
            if(search.trim()!=""){
                $.ajax({
                    url : "/oldman/getBySearch",
                    type : "post",
                    dataType : 'json',
                    data:{
                        search:search
                    },
                    success : function(data) {
                        if (data.success==true) {
                            $("select[name='oldmanId']").empty();
                            for(var i=0;i<data.data.length;i++){
                                var $option=$("<option value='"+data.data[i].id+"'>"+data.data[i].name+"</option>");
                                $("select[name='oldmanId']").append($option);
                            }
                            $(".selectpicker" ).selectpicker('refresh');
                        } else {
                            alert('删除失败！');
                        }
                    }
                });
            }
        });
    $(".ischx").hide();
    $(".nochx").hide();


    $(".jj .searchable-select-item").on('click',
            function () {
                $(".nocheck").prop("checked",true);
                $("input[name='timeIn']").val("");
                $("input[name='timeOut']").val("");
                if($("select[name='homeId']").find("option[value="+$(this).attr('data-value')+"]").attr("firType")=="2"){
                    $(".ischx").show();
                    $(".nochx").hide();
                }else{
                    $(".ischx").hide();
                    $(".nochx").show();
                }
            });

</script>

