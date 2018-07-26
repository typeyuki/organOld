

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
                                    <form method="post" id="oldmanEdit" class="form-horizontal" action="/oldman/integral/rule/update">
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">签到</label>
                                            <div class="col-sm-2">
                                                <input type="text" class="form-control" name="sign">
                                            </div>
                                            <label class="col-sm-1 control-label">分</label>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">消费</label>
                                            <div class="col-sm-2">
                                                <input type="text" class="form-control" name="consume">
                                            </div>
                                            <label class="col-sm-1 control-label">%</label>
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


