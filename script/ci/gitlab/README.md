# Gitlab CE

### 使用方法

1. 根据部署环境，修改 _docker-compose.env_ 文件。
2. 执行 _env.sh_ 脚本，生成docker-compose的配置文件(`.env`文件)。
3. 执行 `docker-compose up -d` 命令，启动容器。

### 注意事项

* 容器首次启动可能比较久。
* 由于gitlab默认使用hostname为访问的路径，所以在docker环境下不适合，所以构造容器时指定了`hostname`，并且在相应的在gitlab启动参数中添加该配置。但除非该hostname是有对于的dns作为解析。不然，使用者应当的本地hosts文件中添加使用映射地址和ip。

### 文档参考

* [gitlab官方dockerfile](https://hub.docker.com/r/gitlab/gitlab-ce/~/dockerfile/)
* [git官方帮助文档](https://about.gitlab.com/getting-help/)


