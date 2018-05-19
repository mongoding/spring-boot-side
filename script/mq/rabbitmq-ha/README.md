# rabbitmq
依赖官方镜像 `rabbitmq:3.6-management`

在更改主从、节点类型之前，需要先停止服务

```
rabbitmqctl stop_app
```

配置结束后，重新启动

```
rabbitmqctl start_app
```

## 主从配置

假设：01为主节点，02、03为从节点。分别进入02、03，执行

```
rabbitmqctl join_cluster rabbit@rabbitmq01
```

## 更改节点类型（内存型或磁盘型）
```
rabbitmqctl change_cluster_node_type ram

// 默认
rabbitmqctl change_cluster_node_type disk
```

## 查看状态

```
rabbitmqctl cluster_status
```

# 高可用

使用`haproxy`配置了高可用

## 配置故障自动转移
参考 http://www.cnblogs.com/TimeMaster/p/7069073.html
