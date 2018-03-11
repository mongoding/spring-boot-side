<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>LarryCMS后台管理1.09版</title>
    <meta name="keywords" content="LarryCMS后台登录界面"/>
    <meta name="description" content="LarryCMS Version:1.09"/>
    <meta name="Author" content="larry"/>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="Shortcut Icon" href="/favicon.ico"/>
    <!-- load css -->
    <link rel="stylesheet" type="text/css" href="/common/bootstrap/css/bootstrap.min.css" media="all">
    <link rel="stylesheet" type="text/css" href="/common/layui/css/layui.css" media="all">
    <!-- <link rel="stylesheet" type="text/css" href/common/css/larry.css" media="all"> 基于flex布局 未完待续-->
    <link rel="stylesheet" type="text/css" href="/common/css/global.css" media="all">
    <link rel="stylesheet" type="text/css" href="http://at.alicdn.com/t/font_bmgv5kod196q1tt9.css">
    <link rel="stylesheet" type="text/css" href="/css/common.css" media="all">
    <link rel="stylesheet" type="text/css" href="/css/main.css" media="all">
</head>
<body>
<div class="larry-grid larry-wrapper">
    <div class="row" id="infoSwitch">
        <blockquote class="layui-elem-quote col-md-12 head-con">
            <div>尊敬的admin<span id="weather"></span></div>
            <i class="larry-icon larry-guanbi close" id="closeInfo"></i>
        </blockquote>
    </div>
    <div class="row shortcut" id="shortcut">
        <div class="col-xs-12 col-sm-6 col-md-4 col-lg-2 ">
            <section class="panel clearfix">
                <div class="symbol shortcut-bg1"><i class="larry-icon larry-daishenhe1"
                                                    data-icon="larry-daishenhe1"></i></div>
                <div class="value">
                    <a data-href="/temp">
                        <h1 id="count1">10</h1>
                    </a>
                    <p>待审的文章</p>
                </div>
            </section>
        </div>
        <div class="col-xs-12 col-sm-6 col-md-4 col-lg-2 ">
            <section class="panel">
                <div class="symbol shortcut-bg2"><i class="larry-icon larry-fabu2" data-icon="larry-fabu2"></i></div>
                <div class="value">
                    <a data-href="/temp">
                        <h1 id="count2">26</h1>
                    </a>
                    <p>我发布的文章</p>
                </div>
            </section>
        </div>
        <div class="col-xs-12 col-sm-6 col-md-4 col-lg-2 ">
            <section class="panel">
                <div class="symbol shortcut-bg3"><i class="larry-icon larry-lanmuguanli"
                                                    data-icon="larry-lanmuguanli"></i></div>
                <div class="value">
                    <a data-href="/temp">
                        <h1 id="count3">15</h1>
                    </a>
                    <p>网站栏目管理</p>
                </div>
            </section>
        </div>
        <div class="col-xs-12 col-sm-6 col-md-4 col-lg-2 ">
            <section class="panel">
                <div class="symbol shortcut-bg4"><i class="larry-icon larry-kehuliebiao"
                                                    data-icon="larry-kehuliebiao"></i></div>
                <div class="value">
                    <a data-href="/temp">
                        <h1 id="count4">60</h1>
                    </a>
                    <p>会员注册列表</p>
                </div>
            </section>
        </div>
        <div class="col-xs-12 col-sm-6 col-md-4 col-lg-2 ">
            <section class="panel">
                <div class="symbol shortcut-bg5"><i class="larry-icon larry-liuyan" data-icon="larry-liuyan"></i></div>
                <div class="value">
                    <a data-href="/temp">
                        <h1 id="count4">105</h1>
                    </a>
                    <p>会员留言管理</p>
                </div>
            </section>
        </div>
        <div class="col-xs-12 col-sm-6 col-md-4 col-lg-2 ">
            <section class="panel">
                <div class="symbol shortcut-bg6"><i class="larry-icon larry-a157" data-icon="larry-a157"></i></div>
                <div class="value">
                    <a data-href="/temp">
                        <h1 id="count4">10</h1>
                    </a>
                    <p>友链管理</p>
                </div>
            </section>
        </div>
    </div>
    <!-- 首页信息 -->
    <div class="row system">
        <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
            <section class="panel">
                <header class="panel-heading bm0">
                    <span class='span-title'>系统概览</span>
                    <span class="tools pull-right"><a href="javascript:;" class="iconpx-chevron-down"></a></span>
                </header>
                <div class="panel-body">
                    <div class="larry-table">
                        <table class="layui-table larry-table-info">
                            <colgroup>
                                <col width="150">
                                <col>
                            </colgroup>
                            <tbody>
                            <tr>
                                <td><span class="tit">系统名称:</span></td>
                                <td><a href="http://www.larrycms.com" title="LarryCMS官网" class="tit"
                                       target="_blank"><span class="info">LarryCMS</span></a></td>
                            </tr>
                            <tr>
                                <td><span class="tit">版本信息:</span></td>
                                <td><span class="info iframe"> V01_UTF8_1.09 ( iframe版 )</span></td>
                            </tr>
                            <tr>
                                <td><span class="tit">开发作者:</span></td>
                                <td>Larry</td>
                            </tr>
                            <tr>
                                <td><span class="tit">官网地址:</span></td>
                                <td><span class="info"><a href="https://www.larrycms.com" class="official"
                                                          target="_blank">https://www.larrycms.com</a></span></td>
                            </tr>
                            <tr>
                                <td><span class="tit">系统下载:</span></td>
                                <td>
                                    <a href="http://fly.layui.com/case/2017/" target="_blank"
                                       class="layui-btn layui-btn-small layui-btn-danger">去点个赞！</a>
                                    <a href="https://jq.qq.com/?_wv=1027&amp;k=42fC4vT" target="_blank"
                                       class="layui-btn layui-btn-small">QQ群下载</a> <em class='qq-add'>493153642</em>
                                </td>
                            </tr>
                            <tr>
                                <td><span class="tit">网站域名:</span></td>
                                <td>demo.larrycms.com</td>
                            </tr>
                            <tr>
                                <td><span class="tit">当前登陆用户:</span></td>
                                <td>admin</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </section>
            <!-- 日志更新 -->
            <section class="panel">
                <header class="panel-heading bm0">
                    <span class='span-title'>LarryCMS 更新日志</span>
                    <span class="tools pull-right"><a href="javascript:;" class="iconpx-chevron-down"></a></span>
                </header>
                <div class="panel-body">
                    <div class="update-log">
                        <h2>V01_UTF8_1.09 ( iframe版 ) 2017-05-30</h2>
                        <ul>
                            <li>#<p>tab选项卡针对layui 1.09_rls 不能切换关闭的问题修复</p></li>
                            <li>#<p>增加json生成三级菜单tab选项卡切换</p></li>
                            <li>#<p>tab选项卡内页增加添加按钮，增加页面在选项卡面板上打开</p></li>
                            <li>#<p>tab选项卡增加常用操作控制功能（如关闭系列、刷新）</p></li>
                            <li>#<p>tab选项卡溢出左右滑动和自动定位当前选项卡</p></li>
                            <li>#<p>主题设置功能，可选主题（目前提供默认、深蓝、墨绿主题 后期提供自定义配色主题设置）</p></li>
                            <li>#<p>全屏切换配合主题设置，模拟F11全屏</p></li>
                            <li>#<p>tab选项卡内按钮在选项卡面板打开定位</p></li>
                            <li>
                                <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
                                    <legend>未完待续</legend>
                                </fieldset>

                                <fieldset class="layui-elem-field content">
                                    <legend>下个版本更新</legend>
                                    <div class="layui-field-box">
                                        <p>
                                            如：datatable、json数据表格分页、基于flex的grid布局、通用菜单按钮级权限模块等模块功能这些会在后续更新中相继推出（当然有一些后台最常用的功能在layui官方2.0中可能会出现，同时十分期待2.0，有时候不需要重复造轮子，在后期更新中选择性更新，目前只是一个cms后台通用模版，有瑕疵和改进的地方希望大家帮忙多提建议！待LarryCMS整体完成后分享基于ThinkPHP+layim聊天功能的cms系统）</p>
                                    </div>
                                </fieldset>

                            </li>
                        </ul>
                    </div>
                </div>
            </section>
        </div>

        <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
            <section class="panel">
                <header class="panel-heading bm0">
                    <span class='span-title'>系统公告</span>
                    <span class="tools pull-right"><a href="javascript:;" class="iconpx-chevron-down"></a></span>
                </header>
                <div class="panel-body">
                    <table class="table table-hover personal-task">
                        <tr>
                            <td class="top-top">
                                <p class="larry_github">
                                    在这里非常感谢贤心大神2016年精心组织的fly社区案例评选活动，LarryCMS侥幸得到大家的关注和点赞支持；由于今年时间安排和精力有限迟迟没有更新（也是有一定的拖延，实在抱歉！），此次做了一些常用功能更新(目前是iframe版)，一直想完整做一个功能较齐全的cms系统出来，在后面会陆续将完成的页面以静态模版的形式分享到交流群内。<br>限于本人水平，bug在所难免，希望喜欢此套模版的朋友给予建议一起去完善，同时祝愿Layui越来越强大！
                                    <br>
                                    github地址：<a href="https://github.com/larryqin/larrycms" class="githublink"
                                                target="_blank">https://github.com/larryqin/larrycms</a>
                                    (系统整体完成后再上传github)<br>
                                    layui后台交流群：<span>493153642</span><a
                                        href="https://jq.qq.com/?_wv=1027&k=42fC4vT"><img border="0"
                                                                                          src="../images/group.png"
                                                                                          title="LarryCMS官方交流群"></a>
                                </p>
                            </td>
                        </tr>
                    </table>
                </div>
            </section>


            <section class="panel">
                <header class="panel-heading bm0">
                    <span class='span-title'>数据统计</span>
                    <span class="tools pull-right"><a href="javascript:;" class="iconpx-chevron-down"></a></span>
                </header>
                <div class="panel-body larry-seo-box">
                    <div class="larry-seo-stats" id="larry-seo-stats"></div>
                </div>
            </section>

            <section class="panel">
                <header class="panel-heading bm0">
                    <span class='span-title'>最新文档</span>
                    <span class="tools pull-right"><a href="javascript:;" class="iconpx-chevron-down"></a></span>
                </header>
                <div class="panel-body">
                    <form class="layui-form larry-document" action="" method="post">
                        <table class="layui-table">
                            <colgroup>
                                <col>
                                <col width="100">
                                <col width="120">
                                <col width="100">
                            </colgroup>
                            <thead>
                            <tr>
                                <th>文章标题</th>
                                <th>作者</th>
                                <th>发布时间</th>
                                <th>审核</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td><a href="#">网站优化需要分析哪些数据</a></td>
                                <td>larry</td>
                                <td>2017-03-25</td>
                                <td class="layui-form-item">
                                    <input type="checkbox" name="close" lay-skin="switch" lay-text="ON|OFF">
                                </td>
                            </tr>
                            <tr>
                                <td><a href="#">网站优化需要分析哪些数据</a></td>
                                <td>larry</td>
                                <td>2017-03-25</td>
                                <td class="layui-form-item">
                                    <input type="checkbox" name="close" lay-skin="switch" lay-text="ON|OFF">
                                </td>
                            </tr>
                            <tr>
                                <td><a href="#">网站优化需要分析哪些数据</a></td>
                                <td>larry</td>
                                <td>2017-03-25</td>
                                <td class="layui-form-item">
                                    <input type="checkbox" name="close" lay-skin="switch" lay-text="ON|OFF">
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </form>
                </div>
            </section>
        </div>

    </div>

</div>
<!-- 加载js文件 -->
<script type="text/javascript" src="/common/layui/layui.js"></script>
<script type="text/javascript" src="/common/js/jquery-3.2.0.min.js"></script>
<script type="text/javascript" src="/common/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/common/jsplugin/jquery.leoweather.min.js"></script>
<script type="text/javascript" src="/common/jsplugin/echarts.min.js"></script>
<!-- 引入当前页面js文件 -->
<script type="text/javascript" src="/js/common.js"></script>
<script type="text/javascript" src="/js/main.js"></script>
</body>
</html>