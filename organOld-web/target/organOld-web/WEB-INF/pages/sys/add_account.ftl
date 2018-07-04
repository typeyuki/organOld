<div class="modal fade" id="selectModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static" data-keyboard="false">
    <div class="modal-dialog" style="width: 80%">
        <div class="modal-content">
            <div class="modal-body">
                <div class="wrapper wrapper-content animated fadeInRight">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="ibox float-e-margins">
                                <div class="ibox-title">
                                    <h5>账号<small>添加</small></h5>
                                </div>
                                <div class="ibox-content">
                                    <form method="post" action="/user/save" class="form-horizontal">
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">用户名</label>
                                            <div class="col-sm-2">
                                                <input type="text" class="form-control" name="username"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">密码</label>
                                            <div class="col-sm-2">
                                                <input type="text" class="form-control" name="password"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">角色</label>
                                            <div class="col-sm-2">
                                                <select class="form-control" name="roleId" onchange="roleSelect()">
                                                    <option></option>
                                                    <#list roles as role>
                                                        <option value="${role.id}" index="${role.typeIndex}" type="${role.type}">${role.desc}</option>
                                                    </#list>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group" id="organ" style="display: none">
                                            <label class="col-sm-3 control-label">对应机构</label>
                                            <div class="col-sm-2">
                                                <select class="form-control" name="organId">
                                                    <option></option>
                                                </select>
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

<script>
    function roleSelect() {
        if($("select[name='roleId']").find("option:selected").attr("type")!="0"){
            $("#organ").show();
            $.ajax({
                url: "/user/getRoleOrgan",
                data : {
                    "type":$("select[name='roleId']").find("option:selected").attr("type"),
                    "typeIndex":$("select[name='roleId']").find("option:selected").attr("index")
                },
                type: 'POST',
                dataType: 'json',
                success: function (result) {
                    if(result.success==true){
                        for(var i=0;i<result.data.length;i++){
                            var op=$("<option value='"+result.data[i].id+"'>"+result.data[i].name+"</option>");
                            $("select[name='organId']").append(op)
                        }
                    }
                }
            });
        }else{
            $("#organ").hide();
        }
    }
</script>

