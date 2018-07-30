<style>
    #table{
        position: relative;
        top:100px;
    }
</style>

    <div class="wrapper wrapper-content animated fadeInRight box">
        <div class="zz"></div>
        <div class="row">
            <div class="col-lg-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-content">
                            <table class="table table-striped table-bordered table-hover dataTables-example text-nowrap">
                                <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>片区</th>
                                    <th>居委</th>
                                    <th>小区</th>
                                    <th>楼号</th>
                                    <th>姓名</th>
                                    <th>性别</th>
                                    <th>年龄</th>
                                    <th>政治面貌</th>
                                    <th>户籍</th>
                                    <th>电话</th>
                                    <th>地址</th>
                                    <th>身份证号码</th>
                                    <th>更新时间</th>
                                    <th></th>
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
                                    <form method="post" id="oldmanEdit" class="form-horizontal" action="/oldman/family/update">
                                        <input type="hidden" name="id">

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

<script>
    var label=[];//用于标签页面

    var iDisplayLength=8;
    $(document).ready(function(){
        var table =$(".dataTables-example").dataTable(
                {
                    "sPaginationType": "full_numbers",
                    "bPaginite": true,
                    "bInfo": true,
                    "bSort": true,
                    "bFilter": false, //搜索栏
                    "bStateSave": true,
                    "bProcessing": true, //加载数据时显示正在加载信息
                    "bServerSide": true, //指定从服务器端获取数据
                    "columns":[{
                        data:"id"
                    },{
                        data:"dName"
                    },{
                        data:"jName"
                    },{
                        data:"xName"
                    },{
                        data:"louNum"
                    },{
                        data:"name"
                    },{
                        data:"sex"
                    },{
                        data:"age"
                    },{
                        data:"politicalStatus"
                    },{
                        data:"census"
                    },{
                        data:"phone"
                    },{
                        data:"address"
                    },{
                        data:"pid"
                    },{
                        data:"time"
                    }
                    ],
                    "iDisplayLength" : iDisplayLength,
                    "columnDefs": [
                        {
                            "targets": [0], // 目标列位置，下标从0开始
                            "data": "id", // 数据列名
                            "render": function(data, type, full) { // 返回自定义内容
                                return "<span class='btn btn-primary'onclick=$('#editModal').modal() id='"+data+"'>"+data+"</span>";
                            }
                        },
                        // 增加一列，包括删除和修改，同时将我们需要传递的数据传递到链接中
                        {
                            "targets": [14], // 目标列位置，下标从0开始
                            "data": "id", // 数据列名
                            "render": function(data, type, full) { // 返回自定义内容
                                return "<span class='look' id='"+data+"'>查看</span><span class='mod' id='"+data+"'>修改</span>";
                            }
                        },
                        //不进行排序的列
                        { "bSortable": false, "aTargets": [ 0,1,2,3 ,4, 5,6, 7,9,10,11,12,13,14] }
                    ],
                    "sAjaxSource": "/oldman/baseData",//这个是请求的地址
                    "fnServerData": retrieveData
                });
        function retrieveData(url, aoData, fnCallback) {
            $.ajax({
                url: url,//这个就是请求地址对应sAjaxSource
                data : {
                    "iDisplayStart" : aoData.iDisplayStart,
                    "iDisplayLength" : aoData.iDisplayLength,
                    "iSortCol_0" : aoData.iSortCol_0,
                    "sEcho" : aoData.sEcho,
                    "sSortDir_0" : aoData.sSortDir_0,
                    "label":label
                },
                type: 'POST',
                dataType: 'json',
                async: false,
                success: function (result) {
                    fnCallback(result);//把返回的数据传给这个方法就可以了,datatable会自动绑定数据的
                },
                error:function(XMLHttpRequest, textStatus, errorThrown) {
//                    alert("status:"+XMLHttpRequest.status+",readyState:"+XMLHttpRequest.readyState+",textStatus:"+textStatus);
                }
            });
        }

        $("#DataTables_Table_0").prev().css("display","none");

        var oTable=$("#editable").dataTable();
        oTable.$("td").editable("",{
            "callback":function(sValue,y){var aPos=oTable.fnGetPosition(this);oTable.fnUpdate(sValue,aPos[0],aPos[1])},
            "submitdata":function(value,settings){return{"row_id":this.parentNode.getAttribute("id"),
                "column":oTable.fnGetPosition(this)[2]}},"width":"90%","height":"100%"});

    });
</script>