<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static" data-keyboard="false">
    <div class="modal-dialog" style="width: 80%">
        <div class="modal-content">
            <div class="modal-body">
                <div class="wrapper wrapper-content animated fadeInRight">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="ibox float-e-margins">
                                <div class="ibox-title">
                                    <h5>
                                        充钱
                                        <small></small></h5>
                                </div>
                                <div class="ibox-content">
                                    <form class="form-horizontal" >
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">金额</label>
                                            <div class="col-sm-8">
                                                <input type="text" class="form-control" name="money"/>
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

                <a onclick="addMoney()" href="javascript:void(0);" class="btn btn-primary " id="subBtn">添加</a>

                <a data-dismiss="modal" href="javascript:void(0);" class="btn btn-primary ">关闭</a>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>

<script>
    function addMoney() {
        var ids=[];
        $("input[name='id']:checked").each(function () {
            ids.push($(this).val());
        });
        var money=$("#addModal input[name='money']").val();
        $.ajax({
            url : "/card/addMoney",
            type : "post",
            dataType : 'json',
            data:{
                ids:ids,
                money:money
            },
            success : function(data) {
                if (data.success==true) {
                    $("#addModal").modal('hide');
                    tableUpdate();
                } else {
                    alert('充值失败！');
                }
            }
        });
    }
</script>
