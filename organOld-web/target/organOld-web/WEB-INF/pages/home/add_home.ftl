<div class="modal fade" id="selectModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static" data-keyboard="false">
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
                                    <#if type==1 || type==3 || type==4>
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">名称</label>
                                            <div class="col-sm-8">
                                                <input type="text" class="form-control" name="name"/>
                                            </div>
                                        </div>
                                    </#if>
                                    <#if type==2>
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">级别</label>
                                            <div class="col-sm-8">
                                                <input type="text" class="form-control" name="level"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">服务时间</label>
                                            <div class="col-sm-8">
                                                <input type="text" class="form-control" name="serviceTime"/>
                                            </div>
                                        </div>
                                    </#if>
                                    <#if type==4 || type==5>
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">医院</label>
                                            <div class="col-sm-8">
                                                <select name="organId"  class="search_select" data-live-search="true">
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


<div class="modal fade" id="feedbackModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static" data-keyboard="false">
    <div class="modal-dialog" style="width: 80%">
        <div class="modal-content">
            <div class="modal-body">
                <div class="wrapper wrapper-content animated fadeInRight">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="ibox float-e-margins">
                                <div class="ibox-title">
                                    <h5>标签 <small>反馈</small></h5>
                                </div>
                                <div class="ibox-content">

                                    <form method="post" id="feedbackAdd" class="form-horizontal" action="/oldman/label/feedback/add">
                                        <input type="hidden" value="" name="labelId">
                                        <input type="hidden" value="${type}" name="type">
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">是否完成</label>
                                            <div class="col-sm-1">
                                                    <label>
                                                        <input type="radio" value="1" name="isFinish" > <i></i> 是</label>
                                            </div>
                                            <div class="col-sm-1">
                                                    <label>
                                                        <input type="radio" value="0" name="isFinish" > <i></i> 否</label>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">备注</label>
                                            <div class="col-sm-8">
                                                <input type="text" class="form-control" name="remark"/>
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
                <a onclick="$('#feedbackAdd').submit()" href="javascript:void(0);" class="btn btn-primary ">添加</a>
                <a data-dismiss="modal" href="javascript:void(0);" class="btn btn-primary ">关闭</a>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>


<div class="modal fade" id="lookfeedbackModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static" data-keyboard="false">
    <div class="modal-dialog" style="width: 80%">
        <div class="modal-content">
            <div class="modal-body">
                <div class="wrapper wrapper-content animated fadeInRight">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="ibox float-e-margins">
                                <div class="ibox-title">
                                    <h5>标签 <small>反馈</small></h5>
                                </div>
                                <div class="ibox-content">

                                    <form  class="form-horizontal" >
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">是否完成</label>
                                            <div class="col-sm-1">
                                                <label id="isFinish">
                                                     </label>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">备注</label>
                                            <div class="col-sm-8">
                                                <label id="remark"></label>
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
                <a data-dismiss="modal" href="javascript:void(0);" class="btn btn-primary ">关闭</a>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>



<script>
    function firLabelSelect(obj) {
        $("select[name='labelSec.id']").html("");
            $.ajax({
                url: "/oldman/label/"+$(obj).val()+"/getSecLabel",
                type: 'GET',
                success: function (result) {
                    if(result.success==true){
                        for(var i=0;i<result.data.length;i++){
                            var op=$("<option value='"+result.data[i].id+"'>"+result.data[i].secName+"</option>");
                            $("select[name='labelSec.id']").append(op)
                        }
                    }
                }
            });
    }
</script>
