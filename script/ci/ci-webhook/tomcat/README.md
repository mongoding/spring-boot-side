# Ci-Webhook-Tomcat

请用 `root` 来启动容器，容器启动成功后，访问 `http://host:7788/deploy/` 网址即可实现自动部署。可在 `ci` 服务器上配置这个webhook地址。

`JAVA_OPTS`, 项目构建的git源码地址以及分支等配置，可参考修改 `supervisord.conf`

常用命令

```
# 启动命令
docker-compose up -d
# 查看superiorctl守护状态
docker exec -i ciwebhook_app_1 supervisorctl status
# 查看tomcat控制台
docker exec -i ciwebhook_app_1 supervisorctl tail -f tomcat
```

在以下环境使用通过:

Docker version 17.03.1-ce, build c6d412e
docker-compose version 1.11.2, build dfed24

