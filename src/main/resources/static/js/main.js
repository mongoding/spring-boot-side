layui.config({
    base: '/js/lib/' //layui自定义layui组件目录
}).extend({
    larry: 'larry',
    navtab: 'navtab',
    elemnts: 'elements',
    common: 'common'
});
layui.use(['layer', 'elements', 'form'], function () {
    var layer = layui.layer,
        elements = layui.elements(),
        form = layui.form();

    // header信息
    $('#weather').leoweather({format: '，{时段}好！<span id="colock">现在时间是：<strong>{年}年{月}月{日}日 星期{周} {时}:{分}:{秒}</strong>，</span> <b>{城市}天气</b> {天气} {夜间气温}℃ ~ {白天气温}℃'});
    $('#closeInfo').on('click', function () {
        $('#infoSwitch').hide();
    });


    $('.panel .tools .iconpx-chevron-down').click(function () {
        var el = $(this).parents(".panel").children(".panel-body");
        if ($(this).hasClass("iconpx-chevron-down")) {
            $(this).removeClass("iconpx-chevron-down").addClass("iconpx-chevron-up");
            el.slideUp(200);
        } else {
            $(this).removeClass("iconpx-chevron-up").addClass("iconpx-chevron-down");
            el.slideDown(200);
        }
    });

    // 快捷方式
    $('#shortcut section').on('click', function () {
        var title = $(this).children('.value').find('p').text();
        var href = $(this).children('.value').find('a').data('href');
        var icon = $(this).children('.symbol').find('i:first').data('icon');
        var data = {
            href: href,
            icon: icon,
            title: title
        };
        parent.navtab.tabAdd(data);
    });


    $(window).on('resize', function () {
        var myChart = echarts.init(document.getElementById('larry-seo-stats'));
        option = {
            title: {
                text: '用户访问来源',
                subtext: '纯属虚构',
                x: 'center'
            },
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                orient: 'vertical',
                left: 'left',
                data: ['直接访问', '邮件营销', '联盟广告', '视频广告', '搜索引擎']
            },
            series: [{
                name: '访问来源',
                type: 'pie',
                radius: '55%',
                center: ['50%', '60%'],
                data: [{
                    value: 335,
                    name: '直接访问'
                }, {
                    value: 310,
                    name: '邮件营销'
                }, {
                    value: 234,
                    name: '联盟广告'
                }, {
                    value: 135,
                    name: '视频广告'
                }, {
                    value: 1548,
                    name: '搜索引擎'
                }],
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }]
        };
        myChart.setOption(option);
    }).resize();


    form.render();
});



