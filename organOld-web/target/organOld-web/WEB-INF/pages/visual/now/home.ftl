<!DOCTYPE html>
<html>
<head>
<#include "../head.ftl" />
<script src="../../../static/js/chart_part.js"></script>

</head>

<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-3">
            <div class="row">
                <div class="col-lg-12" id="news">
                    <#include "news.ftl" />
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12" id="label">
                    <#include "label.ftl" />
                </div>
            </div>
        </div>
        <div class="col-lg-4" style="position: relative;left: -1.5%">
            <div class="row">
                <div class="col-lg-12" id="map">
                    <#include "map.ftl" />
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12" id="table">
                    <#include "table.ftl" />
                </div>
            </div>
        </div>
        <div class="col-lg-5" style="position: relative;left: -1.5%">
            <div class="row">
                <div class="col-lg-6"  id="total" style="margin-top: 1%;margin-bottom: 1%;">
                    <#include "total.ftl" />
                </div>
                <div class="col-lg-6" id="oldman" style="margin-top: 1%;margin-bottom: 1%;position: relative;left: 1%">
                    <#include "oldman.ftl" />
                    <#include "base.ftl" />
                    <#include "family.ftl" />
                    <#include "economic.ftl" />
                    <#include "health.ftl" />
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6" id="organ" >
                    <#include "organ.ftl" />
                    <#include "homeOldman.ftl" />
                    <#include "organOldman.ftl" />
                    <#include "zcdOldman.ftl" />
                    <#include "zzOldman.ftl" />
                    <#include "rzzxOldman.ftl" />
                    <#include "chx.ftl" />
                    <#include "znh.ftl" />
                    <#include "jjys.ftl" />
                    <#include "jjbc.ftl" />
                </div>
                <div class="col-lg-6" id="finish" style="position: relative;left: 1%">
                    <#include "finish.ftl" />
                </div>
            </div>
        </div>
    </div>
</div>

</body>
<script>
    function change(source,des) {
        $("#"+source).hide();
        $("#"+des).show();
    }
</script>
</html>