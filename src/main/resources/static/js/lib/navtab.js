/**
 * @author Larry_qin 2017-05-22 / navtab.js
 * @copyright [copyright]
 * @link      http://www.larrycms.com/
 * @version   [version]
 * @license   [license]
 * @param     {[type]}                 exports){} [description]
 * @return    {[type]}                              [description]
 */
layui.define(['jquery', 'elements', 'layer', 'common'], function (exports) {
    "use strict";
    var $ = layui.jquery,
        layer = parent.layer === undefined ? layui.layer : parent.layer,
        module_name = 'navtab',
        elements = layui.elements(),
        common = layui.common,
        globalTabIdIndex = 0,
        LarryTab = function () {
            this.config = {
                elem: undefined,
                closed: true,
                autoRefresh: false
            };
        };
    var ELEM = {};
    /**
     * @param  {[type]}  options [传入参数配置]
     */
    LarryTab.prototype.set = function (options) {
        var that = this;
        $.extend(true, that.config, options);
        return that;
    };
    /**
     * @return  {[type]} [init 对象初始化]
     */
    LarryTab.prototype.init = function () {
        var that = this;
        var _config = that.config;
        if (typeof(_config.elem) !== 'string' && typeof(_config.elem) !== 'object') {
            common.cmsError('LarryTab error: elem参数未定义或设置出错，具体设置格式请参考文档API.', 'elem参数错误');
        }
        var $container;
        if (typeof(_config.elem) === 'string') {
            $container = $('' + _config.elem + '');
        }
        if (typeof(_config.elem) === 'object') {
            $container = _config.elem;
        }
        if ($container.length === 0) {
            common.cmsError('LarryTab error: 找不到elem参数配置的容器', '容器参数设置错误');
        }
        var filter = $container.attr('lay-filter');
        if (filter === undefined || filter === '') {
            common.cmsError('LarryTab error: 请为elem容器设置一个lay-filter过滤器', 'lay-filter过滤器设置错误');
        }
        _config.elem = $container;
        ELEM.titleBox = $container.find('.larry-title-box').children('ul.layui-tab-title');
        ELEM.contentBox = $container.children('div.layui-tab-content');
        ELEM.tabFilter = filter;
        ELEM.tabCtrlBox = $container.find('#buttonRCtrl');
        return that;
    };

    /**
     *@todo 检查页面是否已打开，如果已打开则返回索引值，否则返回-1
     *@param string title 打开页面的标题
     *@return int tab的索引值，元则返回-1
     */
    LarryTab.prototype.exists = function (title) {
        var that = ELEM.titleBox === undefined ? this.init() : this,
            tabIndex = -1;
        ELEM.titleBox.find('li').each(function (i, e) {
            var $em = $(this).children('em');
            if ($em.text() === title) {
                tabIndex = i;
            }
            ;
        });
        return tabIndex;
    };

    /**
     * @param     {[string]}  data.title  [标题]
     * @return    {[int]}         lay-id  [tabId]
     */
    LarryTab.prototype.getTabId = function (title) {
        var that = ELEM.titleBox === undefined ? this.init() : this,
            tabId = -1;
        ELEM.titleBox.find('li').each(function (i, e) {
            var $em = $(this).children('em');
            if ($em.text() === title) {
                tabId = $(this).attr('lay-id');
            }
        });
        return tabId;
    };

    /**
     * 获取当前获得焦点的tabid
     */
    LarryTab.prototype.getCurrentTabId = function () {
        var that = this;
        var _config = that.config;

        return $(_config.elem).find('ul.layui-tab-title').children('li.layui-this').attr('lay-id');
    };
    /**
     * 删除指定的tab选项卡
     * @param {String} id
     */
    LarryTab.prototype.deleteTab = function (id) {
        var that = this;
        elements.tabDelete(ELEM.tabFilter, id);
        return that;
    };
    /**
     * 添加选择卡，如果选择卡存在则获取焦点
     * @param {Object} data [ title,href,icon ]
     */
    LarryTab.prototype.tabAdd = function (data) {
        var that = this;
        var _config = that.config;
        var tabIndex = that.exists(data.title);
        // 若选项卡不存在
        if (tabIndex === -1) {
            globalTabIdIndex++;
            var content = '<iframe src="' + data.href + '" data-id="' + globalTabIdIndex + '"   name="ifr_' + globalTabIdIndex + '"   id="ifr' + globalTabIdIndex + '" class="larry-iframe"></iframe>';
            var title = '';

            if (data.icon !== undefined) {
                if (data.icon.indexOf('larry-') !== -1) {
                    title += '<i class="larry-icon ' + data.icon + '" aria-hidden="true"></i>';
                } else if (data.icon.indexOf('icon-') !== -1) {
                    title += '<i class="iconfont ' + data.icon + '" aria-hidden="true"></i>';
                } else {
                    title += '<i class="layui-icon">' + data.icon + '</i>';
                }
            }
            title += '<em>' + data.title + '</em>';
            if (_config.closed) {
                title += '<i class="layui-icon layui-unselect layui-tab-close" data-id="' + globalTabIdIndex + '">&#x1006;</i>';
            }

            // 添加tab
            elements.tabAdd(ELEM.tabFilter, {
                title: title,
                content: content,
                id: globalTabIdIndex
            });
            that.tabMove(tabIndex, 0);
            //iframe 自适应
            ELEM.contentBox.find('iframe[data-id=' + globalTabIdIndex + ']').each(function () {
                $(this).height(ELEM.contentBox.height());
                layer.msg('正在加载请稍后...', {
                    icon: 6
                });
            });
            $('#ifr' + globalTabIdIndex).load(function () {
                layer.closeAll();
            });
            if (_config.closed) {
                //监听关闭事件
                ELEM.titleBox.find('li').children('i.layui-tab-close[data-id=' + globalTabIdIndex + ']').on('click', function () {
                    elements.tabDelete(ELEM.tabFilter, $(this).parent('li').attr('lay-id')).init();
                    that.tabMove(tabIndex, 1);
                });
            }
            elements.tabChange(ELEM.tabFilter, that.getTabId(data.title));
            that.tabMove(tabIndex, 0);

        }
        //如果存在
        else {
            elements.tabChange(ELEM.tabFilter, that.getTabId(data.title));
            that.tabMove(tabIndex, 0);
            //自动刷新
            if (_config.autoRefresh) {
                _config.elem.find('div.layui-tab-content > div').eq(tabIndex).children('iframe')[0].contentWindow.location.reload();
            }
        }


    };

    /**
     * @todo 判断菜单选项卡是否已超出了总宽度,若超过则激活左右移动按钮
     * param int index 大于等于0时表示菜单选项卡已经存在，才有移动的需求
     * param int scene 为1时表示删除tab菜单选项卡，为0时表示切换或是添加菜单选项卡
     * [tabMove description]
     * @return {[type]} [description]
     */
    LarryTab.prototype.tabMove = function (index, scene) {
        $(window).on('resize', function () {
            // 获取layui-tab-title的宽度
            var tabWidth = parseInt($('#larry-tab .larry-title-box').width() - $('#titleLeft').width() - $('#titleRbox').width());
            //取得菜单选项卡总宽度
            var $tabNav = ELEM.titleBox.find('li'),
                tab_all_width = 0;
            $tabNav.each(function (i, n) {
                tab_all_width += $(n).outerWidth(true);
            });
            if (!$tabNav[0]) {
                return
            }
            if (tab_all_width > tabWidth + 1) {
                // common.cmsInfo('子选项卡宽度：'+tab_all_width+"超过了ul"+tabWidth+"的宽度",'提示消息');
                var ml = tabWidth - tab_all_width - 1;
                if (ml < 0) {
                    if (index >= 0) {
                        var current_tab_left = parseInt(ELEM.titleBox.find('.layui-this').position().left),
                            curent_tab_ml = parseInt(ELEM.titleBox.css("marginLeft")),
                            curent_ml = current_tab_left + parseInt(curent_tab_ml);

                        if (curent_ml <= 0) {
                            ml = 0 - current_tab_left;
                        } else {
                            var is_show = -(curent_tab_ml - tabWidth + parseInt(ELEM.titleBox.find('.layui-this').outerWidth(true)) + current_tab_left + 1);
                            if (is_show <= 0) {
                                ml = tabWidth - current_tab_left - parseInt(ELEM.titleBox.find('.layui-this').outerWidth(true)) - 1;
                            } else {
                                if (scene == 1 && parseInt(curent_tab_ml) < 0) {
                                    ml = tabWidth - current_tab_left - parseInt(ELEM.titleBox.find('.layui-this').outerWidth(true)) - 1;

                                    if (ml > 0) {
                                        ml = 0;
                                    }
                                } else {
                                    return;
                                }
                            }
                        }

                    }
                    ELEM.titleBox.css({
                        "marginLeft": ml
                    });
                }
            } else {
                ELEM.titleBox.css({
                    "marginLeft": 0
                });
            }

            // 绑定左右移动切换
            $('.pressKey').bind("click", function () {
                if ($(this).attr('id') == 'titleLeft') {
                    if (ml !== undefined && ml < 0) {
                        ELEM.titleBox.css({
                            "marginLeft": ml
                        });
                    }
                }
                if ($(this).attr('id') == 'titleRight') {
                    ELEM.titleBox.css({
                        "marginLeft": 0
                    });
                }
            });
        }).resize();
    };

    /**
     * @author Larry_qin 2017-05-25
     * @copyright [copyright]
     * @link      http://www.larrycms.com/
     * @version   [version]
     * @license   [license]
     * @param     {[type]}                 eventsName [description]
     * @return    {[type]}                            [description]
     */
    LarryTab.prototype.tabCtrl = function (eventsName) {
        var that = this;
        var _config = that.config;
        this.init();
        var currentTabID = that.getCurrentTabId();
        switch (eventsName) {
            case 'closeCurrent': //关闭当前
                if (currentTabID > 0) {
                    elements.tabDelete(ELEM.tabFilter, currentTabID);
                    that.tabMove(currentTabID, 1);
                } else {
                    common.cmsError('LarryCMS 提示您：默认首页不能关闭的哦！', '关闭失败提示');
                }
                break;
            case 'closeOther': //关闭其他
                if (ELEM.titleBox.children('li').length > 2) {
                    ELEM.titleBox.children('li').each(function () {
                        var $t = $(this);
                        var id1 = $t.find('i.layui-tab-close').data('id');
                        if (id1 != currentTabID && id1 !== undefined) {
                            elements.tabDelete(ELEM.tabFilter, $t.attr('lay-id'));
                            that.tabMove(currentTabID, 1);
                        }
                    });
                } else if (ELEM.titleBox.children('li').length == 2) {
                    common.cmsError('LarryCMS 提示您：其他选项卡【默认首页】不能关闭！', '关闭失败提示');
                } else {
                    common.cmsError('LarryCMS 提示您：当前无其他可关闭选项卡！', '关闭失败提示');
                }
                break;
            case 'closeAll': //全部关闭
                if (ELEM.titleBox.children('li').length > 1) {
                    ELEM.titleBox.children('li').each(function () {
                        var $t = $(this);
                        var id1 = $t.find('i.layui-tab-close').data('id');
                        if (id1 > 0) {
                            elements.tabDelete(ELEM.tabFilter, id1);
                            that.tabMove(0, 1);
                        }
                    });
                } else {
                    common.cmsError('LarryCMS 提示您：当前无其他可关闭选项卡！', '关闭失败提示');
                }
                break;
            case 'refreshAdmin': //刷新最外层框架
                layer.confirm('您确定真的要重新加载后台系统界面！', {
                    title: 'LarryCMS友情提示',
                    time: 0,
                    resize: false,
                    btn: ['我很确定', '不,我点错了'],
                    btnAlign: 'c',
                    zIndex: layer.zIndex,
                    anim: Math.ceil(Math.random() * 6)
                }, function () {
                    location.reload();
                }, function () {
                    return;
                });

                break;
        }
    };


    /**
     * navtab事件处理
     * @param  {[type]} events [description]
     * @return {[type]}        [description]
     */
    LarryTab.prototype.on = function (events, callback) {
        var that = this;
        var _config = that.config;
        this.init();
        if (typeof(events) !== 'string') {
            common.cmsError('LarryCMS Nav error:事件名配置出错，请参考API文档.', '事件名配置出错')
        }
        var lIndex = events.indexOf('(');
        var eventName = events.substr(0, lIndex);
        var filter = events.substring(lIndex + 1, events.indexOf(')'));
        if (eventName === 'click') {
            if (ELEM.tabCtrlBox.attr('lay-filter') == 'larryOperate') {


            } else {
                common.cmsInfo('LarryCMS Nav error:当前传入的lay-filter是' + filter + ';而非larryOperate', '常用操作不匹配');
            }
        } else {
            common.cmsInfo('LarryCMS Nav error:当前传入的事件名是' + eventName + ';非点击事件，其他功能稍后续！', '事件名不匹配提示');
        }
    };


    var navtab = new LarryTab();

    exports(module_name, function (options) {
        return navtab.set(options);
    });
})