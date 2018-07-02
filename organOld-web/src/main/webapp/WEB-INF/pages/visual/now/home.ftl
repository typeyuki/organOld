<!DOCTYPE html>
<html>
<head>
<#include "../head.ftl" />

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
        <div class="col-lg-4">
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
        <div class="col-lg-5">
            <div class="row">
                <div class="col-lg-6"  id="total">
                    <#include "total.ftl" />
                    <#include "base.ftl" />
                </div>
                <div class="col-lg-6" id="oldman">
                    <#include "oldman.ftl" />
                    <#include "key.ftl" />
                    <#include "family.ftl" />
                    <#include "economic.ftl" />
                    <#include "health.ftl" />
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6" id="organ">
                    <#include "organ.ftl" />
                </div>
                <div class="col-lg-6" id="finish">
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