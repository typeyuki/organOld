<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<#include "../head.ftl" />
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=Ww7qXViYG0v5YUnWwOQ6uMMxLYmL5WPf"></script>

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
                </div>
                <div class="col-lg-6" id="oldman">
                    <#include "oldman.ftl" />
                    <#include "base.ftl" />
                    <#include "family.ftl" />
                    <#include "economic.ftl" />
                    <#include "health.ftl" />
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6" id="organ">
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