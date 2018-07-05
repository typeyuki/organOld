<div class="modal fade" id="selectModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static" data-keyboard="false">
    <div class="modal-dialog" style="width: 80%">
        <div class="modal-content">
            <div class="modal-body">
                <div class="wrapper wrapper-content animated fadeInRight">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="ibox float-e-margins">
                                <div class="ibox-title">
                                    <h5>标签 <small>添加</small></h5>
                                </div>
                                <div class="ibox-content">

                                    <form method="post" class="form-horizontal" action="/oldman/label/add">
                                        <input type="hidden" value="${type}" name="type">
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">一级菜单</label>
                                            <div class="col-sm-2">
                                                <select >

                                                    <option></option>
                                                    <option>老人身份</option>
                                                    <option>老有所养</option>
                                                    <option>老有所医</option>
                                                    <option>老有所为</option>
                                                    <option>老有所乐</option>
                                                    <option>老有所学</option>

                                                    <#if (info.fir)??>
                                                        <#list info.fir as fir>
                                                            <option value="${fir.id!}" name="xq" > <i></i> ${fir.value!}</option>
                                                        </#list>
                                                    </#if>
                                                </select>
                                            </div>
                                            <label class="col-sm-1 control-label">二级菜单</label>
                                            <div class="col-sm-2">
                                                <select name="labelSec.id">
                                                    <option></option>
                                                    <option value="1">小区职位</option>
                                                    <option value="2">养老补贴</option>

                                                <#if (info.sec)??>
                                                    <#list info.sec as sec>
                                                        <option value="${sec.id!}" name="xq" > <i></i> ${sec.value!}</option>
                                                    </#list>
                                                </#if>
                                            </select>
                                            </div>
                                            <label class="col-sm-1 control-label">名称</label>
                                            <div class="col-sm-2">
                                                <input type="text" class="form-control" name="name"/>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">条件</label>
                                            <div class="col-sm-8">

                                                <input type="text" class="form-control" name="rule"/>

                                            </div>
                                        </div>


                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">内容</label>
                                            <div class="col-sm-8">

                                                <input type="text" class="form-control" name="content"/>

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

                <a onclick="$('form').submit()" href="javascript:void(0);" class="btn btn-primary ">添加</a>

                <a data-dismiss="modal" href="javascript:void(0);" class="btn btn-primary ">关闭</a>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>


