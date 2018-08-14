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
                                    <form  class="form-horizontal" action="">
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">方式</label>
                                            <div class="col-sm-1">
                                                <label>
                                                    <input type="radio" value="add" name="type" > <i></i> 增加</label>
                                            </div>
                                            <div class="col-sm-1">
                                                <label>
                                                    <input type="radio" value="update" name="type" checked> <i></i> 更新</label>
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

                <a onclick="sub()" href="javascript:void(0);" class="btn btn-primary firSub">导入</a>

                <a data-dismiss="modal" href="javascript:void(0);" class="btn btn-primary ">关闭</a>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
