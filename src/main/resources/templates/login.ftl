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
    <link rel="stylesheet" type="text/css" href="/common/layui/css/layui.css" media="all">
    <link rel="stylesheet" type="text/css" href="/css/login.css" media="all">
</head>
<body>
<div class="larry-canvas" id="canvas"></div>
<div class="layui-layout layui-layout-login">
    <h1>
        <strong>LarryCMS管理系统后台</strong>
        <em>Management System</em>
    </h1>
    <div class="layui-user-icon larry-login">
        <input type="text" placeholder="账号" class="login_txtbx"/>
    </div>
    <div class="layui-pwd-icon larry-login">
        <input type="password" placeholder="密码" class="login_txtbx"/>
    </div>
    <div class="layui-val-icon larry-login">
        <div class="layui-code-box">
            <input type="text" id="code" name="code" placeholder="验证码" maxlength="4" class="login_txtbx">
            <img src="images/verifyimg.png" alt="" class="verifyImg" id="verifyImg"
                 onclick="javascript:this.src='xxx'+Math.random();">
        </div>
    </div>
    <div class="layui-submit larry-login">
        <input type="button" value="立即登陆" class="submit_btn"/>
    </div>
    <div class="layui-login-text">
        <p>© 2016-2017 Larry 版权所有</p>
        <p>鄂ICP <a href="http://www.larrycms.com" title="">larrycms.com</a></p>
    </div>
</div>
<script type="text/javascript" src="/common/layui/layui.js"></script>
<script type="text/javascript" src="/common/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/common/jsplugin/jparticle.jquery.js"></script>
<!-- <script type="text/javascript" src="/common/js/larry-canvs.js"></script> -->
<script type="text/javascript" src="/js/login.js"></script>
</body>
</html>