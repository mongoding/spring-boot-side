# Light-Task-Scheduler

[LTS(light-task-scheduler)](http://git.oschina.net/hugui/light-task-scheduler)主要用于解决分布式任务调度问题，支持实时任务，定时任务和Cron任务。

是一个比较简单的实现分布式任务调度的解决方案，至少比起在项目中实现任务调度来，执行调度工作分离出来好处多多，并且也提供管理界面。

在容器内的应用，除了admin外，均使用springboot作为运行环境，均可参考 [lts-springboot](http://git.oschina.net/kennylee/lts-springboot)

## Docker环境

创建 `lts` 的网络

```
docker network create --driver bridge --subnet 172.19.1.0/16 lts
```

注意mysql的data目录的权限，建议 `777` 需要启动一次后，再设置。

### 高可用

保证至少一个 `tasktracker` 和 `jobtracker`，并且他们关联的 `mysql` 也是正常的情况下，调度程序可以正常使用！

#### HA测试环境

* 先启用 `lts-center` 的 docker-compose.yml
* 然后 `docker-compose-ha-task.yml` 两个 `jobtracker`

	```
	docker-compose -p lts -f docker-compose-ha-task.yml up -d
	```

## 项目说明

综合自身实际和LTS的结构，目前比较常用的部署方式一个管理服务器和一个跑任务的服务器。所以目前也分为两个docker-compose目录。

* [lts-center](./lts-center)

    管理系统，包括 `zookeeper`、`mysql`、`jobtracker` 和 `admin` (尝试了好久把admin迁移到springboot...无奈没成功，暂时放弃。)

    命令参考

    ```
    // 启用
    docker-compose up -d
    // 查看控制台
    docker-compose logs -f
    ```

    目录说明

    ```
    ├── docker-compose.yml
    ├── lts-admin
    │   ├── Dockerfile
    │   ├── app
    │   │   └── lts-admin           // lts-admin项目包，lts-admin 1.7.0 SNAPSHOT，jdk1.8编译
    │   ├── config
    │   │   ├── lts-admin.cfg       // lts-admin 配置文件
    │   │   ├── lts-monitor.cfg     // lts-monitor 配置文件
    │   │   └── server.xml          // tomcat配置文件
    │   └── docker-compose.yml
    ├── lts-jobtracker
    │   ├── Dockerfile
    │   ├── app
    │   │   └── lts-jobtracker.jar  // lts-1.6.9版本，springboot环境，jdk1.8编译
    │   ├── config
    │   │   └── application.yml     // jobtracker 配置文件
    │   └── docker-compose.yml
    └── lts-mysql
        └── database
            └── schema.sql
    ```

    配置说明

    * 基本配置信息参考 [LTS](http://git.oschina.net/hugui/light-task-scheduler)，而配置文件都可以在宿主目录找到。
    * docker的network配置为 `host`

    	由于 `jobtrack` 等应用在docker环境。而外部启动 `tasktrack` 可能不在docker的同一个network中，而lts默认绑定的是容器内的ip，还好lts支持手动指定 `bind-ip`，暂时使用host模式。
    	
    	故此，`admin`，`jobtrack`和`tasktrack`等节点需要配置各自部署的服务器宿主的IP，影响的文件有 `lts-admin/config/lts-monitor.cfg`、`lts-jobtracker/config/application.yml `，以及**不在lts-center中，另外跑的tasktracker节点**。*（有空再找办法解决，至少让修改简单点，也许采取类似host的解决方案也可以）*

* [lts-tasktracker](./lts-tasktracker)

	调度程序具体跑业务的节点，使用 `springboot` 作为节点运行环境。 
	
	描述见 [/lts-tasktracker/README.md](./lts-tasktracker/README.md)


