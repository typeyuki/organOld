
        $(".jqcloud span").click(
            function () {
                var text=$(this).text();
                $(".la").append($("<h3 class='"+$(this).attr("class")+"'>"+text+"</h3>"));
                label.push(text);
                table.fnFilter();

                ageBar = echarts.init(document.getElementById('ageBar'));
                sexPie= echarts.init(document.getElementById('sexPie'));
                pqBar= echarts.init(document.getElementById('pqBar'));

                ageBar.setOption(option_age_bar,true);
                sexPie.setOption(option_sex_pie);
                pqBar.setOption(option_pq_bar);
            }
        );
