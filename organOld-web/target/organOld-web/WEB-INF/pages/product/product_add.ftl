


<div class="modal fade" id="productModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static" data-keyboard="false">
    <div class="modal-dialog" style="width: 80%">
        <div class="modal-content">
            <div class="modal-body">
                <div class="wrapper wrapper-content animated fadeInRight">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="ibox float-e-margins">
                                <div class="ibox-title">
                                    <h5>商品 <small>添加</small></h5>
                                </div>
                                <div class="ibox-content">
                                    <form method="post" id="labelType2Add" class="form-horizontal" enctype="multipart/form-data">
                                        <input type="hidden" name="id" value="0">
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">名称</label>
                                            <div class="col-sm-8">
                                                <input type="text" class="form-control" name="name"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">价格</label>
                                            <div class="col-sm-8">
                                                <input type="text" class="form-control" name="price"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">描述</label>
                                            <div class="col-sm-8">
                                                <textarea  class="form-control" name="intro"></textarea>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">图片</label>
                                            <div class="col-sm-4">
                                                <img src="" width='100px'>
                                            </div>
                                            <div class="col-sm-2">
                                                <input type="file" class="form-control" name="pic"/>
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

                <a onclick="$('form').submit()" href="javascript:void(0);" class="btn btn-primary sub">添加</a>

                <a data-dismiss="modal" href="javascript:void(0);" class="btn btn-primary ">关闭</a>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>