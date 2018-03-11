<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>个人信息</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" type="text/css" href="/common/layui/css/layui.css" media="all">
    <link rel="stylesheet" type="text/css" href="/common/bootstrap/css/bootstrap.min.css" media="all">
    <link rel="stylesheet" type="text/css" href="/common/css/global.css" media="all">
    <link rel="stylesheet" type="text/css" href="/css/common.css" media="all">
    <link rel="stylesheet" type="text/css" href="/css/personal.css" media="all">
</head>
<body>
<section class="larry-grid">
    <div class="larry-personal">
        <header class="larry-personal-tit">
            <span>修改密码</span>
        </header><!-- /header -->
        <div class="larry-personal-body clearfix changepwd">
            <form class="layui-form col-lg-4 col-md-5 col-sm-6 " method="post" action="">
                <div class="layui-form-item">
                    <label class="layui-form-label">用户名</label>
                    <div class="layui-input-block">
                        <input type="text" name="title" autocomplete="off" class="layui-input layui-disabled"
                               value="admin" disabled="disabled">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">旧密码</label>
                    <div class="layui-input-block">
                        <input type="password" name="title" autocomplete="off" class="layui-input" value=""
                               placeholder="请输入旧密码">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">新密码</label>
                    <div class="layui-input-block">
                        <input type="password" name="title" autocomplete="off" class="layui-input" value=""
                               placeholder="请输入新密码">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">确认密码</label>
                    <div class="layui-input-block">
                        <input type="password" name="title" autocomplete="off" class="layui-input" value=""
                               placeholder="请输入确认新密码">
                    </div>
                </div>
                <div class="layui-form-item change-submit">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>
            <div class="col-lg-4 col-md-5 col-sm-6 ">
                <div class="layui-btn" id="add_tab" lay-filter="larry">查看用户列表</div>
            </div>
        </div>
    </div>
</section>
<script type="text/javascript" src="/common/layui/layui.js"></script>
<script type="text/javascript">
    layui.use(['form', 'upload', 'jquery'], function () {
        var $ = layui.jquery,
                form = layui.form();
        // 子页面添加选项卡
        $('#add_tab').click(function () {
            title = $(this).text();
            href = 'http://www.baidu.com';
            icon = 'larry-yonghuliebiao1';
            var data = {
                href: href,
                icon: icon,
                title: title
            }
            parent.navtab.tabAdd(data);
        })
    });
</script>
</body>
</html>