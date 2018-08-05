<div class="modal fade" id="selectModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static" data-keyboard="false">
    <div class="modal-dialog" style="width: 80%">
        <div class="modal-content">
            <div class="modal-body">
                <div class="wrapper wrapper-content animated fadeInRight">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="ibox float-e-margins">
                                <div class="ibox-content">
                                    <div style="display: inline">
                                        <a  href="javascript:void(0);" id="selectSearch" class="btn btn-primary ">搜索</a>
                                    </div>
                                    <div class="row" style="margin-top: 10px;margin-bottom: 10px">
                                        <div class="col-sm-3">
                                            <input class="id form-control inp"  name="id_select" type="text" placeholder="序号">
                                        </div>
                                        <div class="col-sm-3">
                                            <label >性别</label>
                                            <select name="sex_select" class="form-control inp" style="width: 80%">
                                                <option></option>
                                            <#list (info.sex)?keys as key>
                                                <option  value="${key!}"> ${(info.sex)?values[key_index]!}</option>
                                            </#list>
                                            </select>
                                        </div>
                                        <div class="col-sm-3">
                                            <input class="age form-control inp" style="width: 48%" name="ageStart_select" type="text" placeholder="年龄段-起">-
                                            <input class="age form-control inp" style="width: 48%" name="ageEnd_select" type="text" placeholder="年龄段-止">
                                        </div>
                                        <div class="col-sm-3">
                                            <input name="search_select" class="form-control inp"  type="text" placeholder="模糊匹配">
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <label >户<span style="color: white">填充</span>籍：</label>
                                            <select name="census_select"  class="selectpicker bla bla bli" multiple data-live-search="true">
                                            <#list info.census as census>
                                                <option type="checkbox" value="${census.id!}" >${census.value!}</option>
                                            </#list>
                                            </select>
                                        </div>
                                        <div class="col-sm-3">
                                            <label >政治面貌：</label>
                                            <select name="politicalStatuses_select" class="selectpicker bla bla bli" multiple data-live-search="true">
                                            <#list info.politicalStatuses as politicalStatuses>
                                                <option value="${politicalStatuses.id!}">${politicalStatuses.value!}</option>
                                            </#list>
                                            </select>
                                        </div>
                                        <div class="col-sm-3">
                                            <label>家庭结构：</label>
                                            <select name="familyIndex_select"  class="selectpicker bla bla bli" multiple data-live-search="true">
                                            <#list info.family as family>
                                                <option value="${family.id!}"> <i></i> ${family.value!}</option>
                                            </#list>
                                            </select>
                                        </div>
                                        <div class="col-sm-3">
                                            <label >经济条件：</label>
                                            <select name="economicIndex_select" class="selectpicker bla bla bli" multiple data-live-search="true">
                                            <#list info.economic as economic>
                                                <option type="checkbox" value="${economic.id!}" > <i></i> ${economic.value!}</option>
                                            </#list>
                                            </select>
                                        </div>
                                        </div>
                                    <div class="row">
                                        <div class="col-sm-3 pq jw">
                                            <label >片<span style="color: white">填充</span>区：</label>
                                            <select name="district_select" class="selectpicker bla bla bli" multiple data-live-search="true">
                                            <#list info.district as district>
                                                <option  value="${district.id!}" > ${district.value!}</option>
                                            </#list>
                                            </select>
                                        </div>
                                        <div class="col-sm-3 jw">
                                            <label >居<span style="color: white">填充</span>委：</label>
                                            <select  name="jw_select" class="selectpicker bla bla bli" multiple data-live-search="true">
                                            <#list info.organ as organ>
                                                <option value="${organ.id!}"> ${organ.name!}</option>
                                            </#list>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="table-responsive">
                                        <table class="table table-striped table-bordered table-hover dataTables-example-1 text-nowrap">
                                            <thead>
                                            <tr>
                                                <th><input type='checkbox' onclick="thCheckByName(this,'addSelectMan')" /></th>
                                                 <th>序号</th>
                                                <th>片区</th>
                                                <th>居委</th>
                                                <th>小区</th>
                                                <th>姓名</th>
                                                <th>性别</th>
                                                <th>年龄</th>
                                                <th>政治面貌</th>
                                                <th>户籍</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
            <div class="modal-footer">
                <a onclick="addMan()" href="javascript:void(0);" class="btn btn-primary ">添加</a>
                <a data-dismiss="modal" href="javascript:void(0);" class="btn btn-primary ">关闭</a>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>

<script>
    function addMan() {
        var ids=[];
        $("input[name='addSelectMan']:checked").each(function () {
            ids.push($(this).val());
        });
        $.ajax({
            url : "/oldman/label/"+labelId+"/saveMan",
            type : "post",
            dataType : 'json',
            data:{
                oldmanId:ids
            },
            success : function(data) {
                if (data.success==true) {
                    location.reload();
                } else {
                    alert('删除失败！');
                }
            }
        });
    }
</script>