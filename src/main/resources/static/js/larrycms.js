var navtab;
layui.config({
    base: '/js/lib/' //layui自定义layui组件目录
}).extend({
    larry: 'larry',
    navtab: 'navtab',
    elemnts: 'elements',
    common: 'common'
});
layui.use(['elements', 'jquery', 'layer', 'larry', 'navtab', 'form', 'common'], function () {
    var $ = layui.jquery,
        layer = layui.layer,
        device = layui.device(),
        elements = layui.elements(),
        larry = layui.larry(),
        form = layui.form(),
        common = layui.common;
    navtab = layui.navtab({
        elem: '#larry-tab'
    });

    // 页面禁止双击选中
    $('body').bind("selectstart", function () {
        return false;
    });

    $(document).ready(function () {
        // 浏览器兼容检查
        if (device.ie && device.ie < 9) {
            layer.alert('最低支持ie9，您当前使用的是古老的 IE' + device.ie + '！');
        }
        // 001界面初始化
        AdminInit();
        //绑定导航数据
        /*$.ajaxSettings.async = false;
        $.getJSON('../backstage/datas/top_menu.json?t=' + new Date(), {
            Param: 'index_menu'
        }, function (result) {
            larry.set({
                elem: '#menu',
                data: result,
                cached: false
            });
            larry.render();
        });*/

        var result = [
            {
                "title": "系统管理",
                "icon": "larry-xitongshezhi1",
                "pid": "0"
            },
            {
                "title": "内容管理",
                "icon": "larry-neirongguanli",
                "pid": "35"
            },
            {
                "title": "微信公众",
                "icon": "larry-weixingongzhongpingtai",
                "pid": "40"
            },
            {
                "title": "扩展模块",
                "icon": "larry-ht_expand",
                "pid": "46"
            }
        ]
        larry.set({
            elem: '#menu',
            data: result,
            cached: false
        });
        larry.render();

        var $menu = $('#menu');
        $menu.find('li.layui-nav-item').each(function () {
            var $that = $(this);
            //绑定一级导航的点击事件
            $that.on('click', function () {
                var id = $that.data('pid');
                /*$.ajaxSettings.async = false;

                $.getJSON('../backstage/datas/pid_' + id + '.json?t=' + new Date(), {
                    pid: id,
                    Param: 'index_menu'
                }, function (result) {
                    larry.set({
                        elem: '#larrySideNav',
                        data: result,
                        spreadOne: true
                    });
                    larry.render();
                    //监听左侧导航点击事件
                    larry.on('click(side)', function (data) {
                        navtab.tabAdd(data.field);
                    });
                });*/

                var pid_0 = [{
                    "pid": "100",
                    "title": "后台首页",
                    "icon": "larry-houtaishouye",
                    "href": "html/main.php"
                }, {
                    "pid": "101",
                    "title": "我的面板",
                    "icon": "larry-gerenxinxi5",
                    "spread": "true",
                    "children": [{
                        "title": "个人信息",
                        "icon": "larry-gerenxinxi1",
                        "href": "/personInfo"
                    }, {"title": "修改密码", "icon": "larry-xiugaimima2", "href": "/changepwd"}, {
                        "title": "日志信息",
                        "icon": "larry-rizhi2",
                        "href": "/myloginfo"
                    }]
                }, {
                    "pid": "102",
                    "title": "用户管理",
                    "icon": "larry-10103",
                    "spread": "true",
                    "children": [{"title": "用户列表", "icon": "larry-yonghuliebiao1", "href": "/main"}, {
                        "title": "角色列表",
                        "icon": "larry-jiaoseguanli1",
                        "href": "/temp"
                    }, {"title": "菜单管理", "icon": "larry-caidanguanli", "href": "/temp"}]
                }, {
                    "pid": "103",
                    "title": "会员管理",
                    "icon": "larry-huiyuanguanli2",
                    "spread": "true",
                    "children": [{
                        "title": "会员注册列表",
                        "icon": "larry-kehuliebiao",
                        "href": "html/temp.ftl"
                    }, {"title": "会员留言管理", "icon": "larry-liuyan", "href": "html/temp.ftl"}, {
                        "title": "会员等级管理",
                        "icon": "larry-fengxianbaozhang",
                        "href": "html/temp.ftl"
                    }]
                }, {
                    "pid": "104",
                    "title": "系统设置",
                    "icon": "larry-xitongshezhi1",
                    "spread": "true",
                    "children": [{
                        "title": "系统基本参数",
                        "icon": "larry-circularxiangxi",
                        "href": "html/temp.ftl"
                    }, {"title": "SQL命令行工具", "icon": "larry-sql2", "href": "html/temp.ftl"}, {
                        "title": "系统日志管理",
                        "icon": "larry-xitongrizhi1",
                        "href": "html/temp.ftl"
                    }, {"title": "验证安全管理", "icon": "larry-yanzheng", "href": "html/temp.ftl"}, {
                        "title": "图片水印设置",
                        "icon": "larry-shuiyin",
                        "href": "html/temp.ftl"
                    }, {"title": "安全字典设置", "icon": "larry-zidian", "href": "html/temp.ftl"}, {
                        "title": "短信接口配置",
                        "icon": "larry-duanxin1",
                        "href": "html/temp.ftl"
                    }, {"title": "系统错误修复", "icon": "larry-xiufu", "href": "html/temp.ftl"}, {
                        "title": "数据库管理",
                        "icon": "larry-sql1",
                        "href": "html/temp.ftl"
                    }]
                }, {"pid": "105", "title": "友链管理", "icon": "larry-a157", "href": "html/temp.ftl"}];
                var pid_35 = [{
                    "title": "网站管理",
                    "icon": "larry-30wangzhanguanli",
                    "spread": "true",
                    "children": [{"title": "网站栏目管理", "icon": "larry-lanmuguanli", "href": "/temp"}, {
                        "title": "所有文章列表",
                        "icon": "larry-iconfontfilesfill",
                        "href": "/temp"
                    }, {"title": "待审核的文章", "icon": "larry-daishenhe1", "href": "/temp"}, {
                        "title": "我发布的文章",
                        "icon": "larry-fabu2",
                        "href": "/temp"
                    }, {"title": "Tags管理", "icon": "larry-tags", "href": "/temp"}, {
                        "title": "内容回收站",
                        "icon": "larry-iconfonthuishouzhan",
                        "href": "/temp"
                    }]
                }, {
                    "title": "模型管理",
                    "icon": "larry-moxingguanli",
                    "spread": "true",
                    "children": [{"title": "内容模型管理", "icon": "larry-moxing1", "href": "/temp"}, {
                        "title": "单页文档管理",
                        "icon": "larry-danye",
                        "href": "/temp"
                    }, {"title": "联动类别管理", "icon": "larry-liandong", "href": "/temp"}, {
                        "title": "自由列表管理",
                        "icon": "larry-zidingyicaidan1",
                        "href": "html/temp.ftl"
                    }, {"title": "自定义表单", "icon": "larry-iconzidingyibiaodan", "href": "html/temp.ftl"}]
                }, {
                    "title": "附件管理",
                    "icon": "larry-fujianguanli",
                    "spread": "true",
                    "children": [{
                        "title": "上传新文件",
                        "icon": "larry-shangchuanfujian",
                        "href": "html/temp.ftl"
                    }, {"title": "附件数据管理", "icon": "larry-fujian", "href": "html/temp.ftl"}, {
                        "title": "文件管理器",
                        "icon": "larry-wenjianguanli2",
                        "href": "html/temp.ftl"
                    }]
                }, {
                    "title": "采集管理",
                    "icon": "larry-eee",
                    "spread": "true",
                    "children": [{
                        "title": "采集节点管理",
                        "icon": "larry-shujucaiji",
                        "href": "html/temp.ftl"
                    }, {"title": "临时内容管理", "icon": "larry-linshi1", "href": "html/temp.ftl"}, {
                        "title": "导入采集规则",
                        "icon": "larry-guize",
                        "href": "html/temp.ftl"
                    }, {"title": "监控采集模式", "icon": "larry-jiankong1", "href": "html/temp.ftl"}, {
                        "title": "采集未下载内容",
                        "icon": "larry-xiazai2",
                        "href": "html/temp.ftl"
                    }]
                }, {
                    "title": "广告管理",
                    "icon": "larry-iconguanggaoguanli",
                    "spread": "true",
                    "children": [{
                        "title": "自定义广告",
                        "icon": "larry-zidingyiguanggaolan",
                        "href": "html/temp.ftl"
                    }, {"title": "网盟广告", "icon": "larry-guanggaolianmeng", "href": "html/temp.ftl"}]
                }, {
                    "title": "批量维护",
                    "icon": "larry-piliang",
                    "spread": "true",
                    "children": [{
                        "title": "一键更新网站",
                        "icon": "larry-yijian",
                        "href": "html/temp.ftl"
                    }, {
                        "title": "更新系统缓存",
                        "icon": "larry-xitonghuancun",
                        "href": "html/temp.ftl"
                    }, {
                        "title": "更新主页HTML",
                        "icon": "larry-tubiaozitimoban",
                        "href": "html/temp.ftl"
                    }, {"title": "更新栏目HTML", "icon": "larry-lanmu1", "href": "html/temp.ftl"}, {
                        "title": "更新文档HTML",
                        "icon": "larry-wendang",
                        "href": "html/temp.ftl"
                    }, {"title": "更新网站地图", "icon": "larry-wangzhanditu", "href": "html/temp.ftl"}, {
                        "title": "重复文档检测",
                        "icon": "larry-zhongfu",
                        "href": "html/temp.ftl"
                    }, {"title": "数据库内容替换", "icon": "larry-tihuan1", "href": "html/temp.ftl"}, {
                        "title": "自动摘要",
                        "icon": "larry-zhaiyao",
                        "href": "html/temp.ftl"
                    }, {"title": "搜索关键词维护", "icon": "larry-guanjianci", "href": "html/temp.ftl"}]
                }]
                var pid_40 = [{
                    "title": "微信配置",
                    "icon": "larry-weixinguanli",
                    "spread": "true",
                    "children": [{"title": "微信接口设置", "icon": "larry-api1", "href": "/temp"}, {
                        "title": "微信支付配置",
                        "icon": "larry-iconzfb",
                        "href": "/temp"
                    }]
                }]
                var pid_46 = [{"title": "支付宝支付配置", "icon": "larry-zhifubao", "href": "html/temp.ftl"}]
                var result;
                if (id == 0)
                    result = pid_0;
                if (id == 35)
                    result = pid_35;
                if (id == 40)
                    result = pid_40;
                if (id == 46)
                    result = pid_46;

                larry.set({
                    elem: '#larrySideNav',
                    data: result,
                    spreadOne: true
                });
                larry.render();
                //监听左侧导航点击事件
                larry.on('click(side)', function (data) {
                    navtab.tabAdd(data.field);
                });

            });

        });
        // 左侧导航点击事件
        $menu.find('li[data-pid=0]').click();
        $("#larrySideNav").find("li").eq(0).addClass('layui-this');
        $.ajaxSettings.async = true;


    });

    $('#larry-tab').bind("contextmenu", function () {
        return false;
    });

    // 常用操作
    $('#buttonRCtrl').find('dd').each(function () {
        $(this).on('click', function () {
            var eName = $(this).children('a').attr('data-eName');
            navtab.tabCtrl(eName);
        });
    });
    // 窗口自适应    
    $(window).on('resize', function () {
        AdminInit();
        // iframe窗口自适应
        var $content = $('#larry-tab .layui-tab-content');
        $content.height($(this).height() - 153);
        $content.find('iframe').each(function () {
            $(this).height($content.height());
        });
    }).resize();

    // 刷新iframe
    $("#refresh_iframe").click(function () {
        $(".layui-tab-content .layui-tab-item").each(function () {
            if ($(this).hasClass('layui-show')) {
                $(this).children('iframe')[0].contentWindow.location.reload(true);
            }
        });
    });

    function AdminInit() {
        $('.layui-layout-admin').height($(window).height());
        $('body').height($(window).height());
        $('#larry-body').width($('.layui-layout-admin').width() - $('#larry-side').width());
        $('#larry-footer').width($('.layui-layout-admin').width() - $('#larry-side').width());
    }

    //清除缓存
    $('#clearCached').on('click', function () {
        larry.cleanCached();
        layer.alert('缓存清除完成!本地存储数据也清理成功！', {icon: 1, title: '系统提示'}, function () {
            location.reload();//刷新
        });
    });

    // 设置主题
    var fScreen = localStorage.getItem("fullscreen_info");
    var themeName = localStorage.getItem('themeName');
    if (themeName) {
        $("body").attr("class", "");
        $("body").addClass("larryTheme-" + themeName);
    }
    if (fScreen && fScreen != 'false') {
        var fScreenIndex = layer.alert('按ESC退出全屏', {
            title: '进入全屏提示信息',
            skin: 'layui-layer-lan',
            closeBtn: 0,
            anim: 4,
            offset: '100px'
        }, function () {
            entryFullScreen();
            $('#FullScreen').html('<i class="larry-icon larry-quanping"></i>退出全屏');
            layer.close(fScreenIndex);
        });
    }
    $('#larryTheme').on('click', function () {
        var fScreen = localStorage.getItem('fullscreen_info');
        var themeName = localStorage.getItem('themeName');
        layer.open({
            type: 1,
            title: false,
            closeBtn: true,
            shadeClose: false,
            shade: 0.35,
            area: ['450px', '300px'],
            isOutAnim: true,
            resize: false,
            anim: Math.ceil(Math.random() * 6),
            content: $('#LarryThemeSet').html(),
            success: function (layero, index) {
                if (fScreen && fScreen != 'false') {
                    $("input[lay-filter='fullscreen']").attr("checked", "checked");
                }
                if (themeName) {
                    $("#themeName option[value='" + themeName + "']").attr("selected", "selected");
                }
                form.render();
            }
        });

        // 全屏开启
        form.on('switch(fullscreen)', function (data) {
            var fValue = data.elem.checked;
            localStorage.setItem('fullscreen_info', fValue); //fullscreen_info:fValue

        });
        // 主题设置
        form.on('select(larryTheme)', function (data) {
            var themeValue = data.value;
            localStorage.setItem('themeName', themeValue);//themeName:themeValue
            if (themeName) {
                $("body").attr("class", "");
                $("body").addClass("larryTheme-" + themeName);
            }
            form.render('select');
        });

        // form.on('submit(submitlocal)',function(data){

        // })
    });


    // 全屏切换
    $('#FullScreen').bind('click', function () {
        var fullscreenElement =
            document.fullscreenElement ||
            document.mozFullScreenElement ||
            document.webkitFullscreenElement;
        if (fullscreenElement == null) {
            entryFullScreen();
            $(this).html('<i class="larry-icon larry-quanping"></i>退出全屏');
        } else {
            exitFullScreen();
            $(this).html('<i class="larry-icon larry-quanping"></i>全屏');
        }
    });

    // 进入全屏：
    function entryFullScreen() {
        var docE = document.documentElement;
        if (docE.requestFullScreen) {
            docE.requestFullScreen();
        } else if (docE.mozRequestFullScreen) {
            docE.mozRequestFullScreen();
        } else if (docE.webkitRequestFullScreen) {
            docE.webkitRequestFullScreen();
        }
    }

    // 退出全屏
    function exitFullScreen() {
        var docE = document;
        if (docE.exitFullscreen) {
            docE.exitFullscreen();
        } else if (docE.mozCancelFullScreen) {
            docE.mozCancelFullScreen();
        } else if (docE.webkitCancelFullScreen) {
            docE.webkitCancelFullScreen();
        }
    }

    // 顶部左侧导航控制开关
    $('#toggle').click(function () {
        var sideWidth = $('#larry-side').width();
        var bodyW = $('#larry-body').width();
        if (sideWidth === 200) {
            bodyW += 203;
            $('#larry-body').animate({
                left: '0',
                width: bodyW
            });
            $('#larry-footer').animate({
                left: '0',
                width: bodyW
            });
            $('#larry-side').animate({
                width: '0'
            });
        } else {
            bodyW -= 203;
            $('#larry-body').animate({
                left: '203px',
                width: bodyW
            });
            $('#larry-footer').animate({
                left: '203px',
                width: bodyW
            });
            $('#larry-side').animate({
                width: '200px'
            });
        }
    });
    // 锁屏控制
    $('#lock').mouseover(function () {
        layer.tips('请按Alt+L快速锁屏！', '#lock', {
            tips: [1, '#FF5722'],
            time: 2000
        });
    });
    // 快捷键锁屏设置
    $(document).keydown(function (e) {
        if (e.altKey && e.which == 76) {
            lockSystem();
        }
    });
    checkLockStatus('0');

    // 锁定屏幕
    function lockSystem() {
        /*var url = '../backstage/datas/lock.json';
        $.get(
            url,
            function (data) {
                if (data == '1') {
                    checkLockStatus(1);
                } else {
                    layer.alert('锁屏失败，请稍后再试！');
                }
            });*/
        checkLockStatus(1);
        startTimer();
    }

    //解锁屏幕
    function unlockSystem() {
        // 与后台交互代码已移除，根据需求定义或删除此功能

        checkLockStatus(0);
    }

    // 点击锁屏
    $('#lock').click(function () {
        lockSystem();
    });
    // 解锁进入系统
    $('#unlock').click(function () {
        unlockSystem();
    });
    // 监控lock_password 键盘事件
    $('#lock_password').keypress(function (e) {
        var key = e.which;
        if (key == 13) {
            unlockSystem();
        }
    });

    function startTimer() {
        var today = new Date();
        var h = today.getHours();
        var m = today.getMinutes();
        var s = today.getSeconds();
        m = m < 10 ? '0' + m : m;
        s = s < 10 ? '0' + s : s;
        $('#time').html(h + ":" + m + ":" + s);
        t = setTimeout(function () {
            startTimer()
        }, 500);
    }

    // 锁屏状态检测
    function checkLockStatus(locked) {
        // 锁屏
        if (locked == 1) {
            $('.lock-screen').show();
            $('#locker').show();
            $('#layui_layout').hide();
            $('#lock_password').val('');
        } else {
            $('.lock-screen').hide();
            $('#locker').hide();
            $('#layui_layout').show();
        }
    }


    $('#dianzhan').click(function (event) {
        layer.open({
            type: 1,
            title: false,
            closeBtn: true,
            shadeClose: false,
            shade: 0.15,
            area: ['505px', '288px'],
            content: '<img src="images/dianzhan.jpg"/>'
        })
    });

    // 登出系统
    $('#logout').on('click', function () {
        var url = 'login.ftl';
        common.logOut('退出登陆提示！', '你真的确定要退出系统吗？', url);
    })
    // 左侧导航菜单控制
    // $('#larrySideNav').on('click', function() {
    // 	if($('#larrySideNav .layui-this').length>0){
    //     $('.sys-public-menu .layui-nav li').removeClass('layui-this');
    // 	}
    // });
    // $('.sys-public-menu .layui-nav li').on('click',function(){
    //     $('#larrySideNav .layui-this').removeClass('layui-this');
    // });
})