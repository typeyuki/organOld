
<div class="modal fade" id="implementModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static" data-keyboard="false">
    <div class="modal-dialog" style="width: 80%">
        <div class="modal-content">
            <div class="modal-body">
                <div class="wrapper wrapper-content animated fadeInRight">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="ibox float-e-margins">
                                <div class="ibox-title">
                                    <h5> </h5>
                                </div>
                                <div class="ibox-content">
                                    <form  class="form-horizontal" >
                                        <input type="hidden" name="id">
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">是否落实</label>
                                            <div class="col-sm-1">
                                                <label>
                                                    <input type="radio" value="2" name="isImpl" > <i></i> 是</label>
                                            </div>
                                            <div class="col-sm-1">
                                                <label>
                                                    <input type="radio" value="1" name="isImpl" > <i></i> 否</label>
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
                <a onclick="subImple()" href="javascript:void(0);" class="btn btn-primary ">添加</a>
                <a data-dismiss="modal" href="javascript:void(0);" class="btn btn-primary ">关闭</a>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>

