/**
 * @Author: Larry  2017-04-16 17:20:56
 *+----------------------------------------------------------------------
 *| LarryBlogCMS [ LarryCMS网站内容管理系统 ]
 *| Copyright (c) 2016-2017 http://www.larrycms.com All rights reserved.
 *| Version 1.09
 *| <313492783@qq.com>
 *+----------------------------------------------------------------------
 */
layui.use(['jquery', 'layer', 'form'], function () {
    'use strict';
    var $ = layui.jquery
        , layer = layui.layer
        , form = layui.form();

    $(window).on('resize', function () {
        var w = $(window).width();
        var h = $(window).height();
        $('.larry-canvas').width(w).height(h);
    }).resize();

    //登录链接测试，使用时可删除
    $(".submit_btn").click(function () {
        location.href = "/index";
    });
    $(function () {
        $("#canvas").jParticle({
            background: "#141414",
            color: "#E5E5E5"
        });
    });

});