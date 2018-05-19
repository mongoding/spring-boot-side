# Docker ELK stack

参考的两个项目

* [deviantony/docker-elk](https://github.com/deviantony/docker-elk)
* [HackerWilson/docker-elk-deployment](https://github.com/HackerWilson/docker-elk-deployment)

## 使用

**注：要使用跨主机网络的话，记得先弄个好overlay的network的支持。**

开发环境下，默认使用 `bridge` 方式，集群环境请改成 `overlay` 。

### 一. ElasticSearch机

1. 调整操作系统vm.max_map_count值

	```
	sudo sysctl -w vm.max_map_count=262144
	```

2. 创建本地data目录

	根据配置，新建和赋予本地目录访问权限。如默认本地目录 `./data/` ，可参考命令 `chmod 777 -R ./data/`，特别是 `./data/elasticsearch` 目录如果没读写权限将启动失败。
	
3. 启动

	```
	docker-compose up -d
	```

### 二 集群的logstash-shipper

建议每台docker容器上跑，在需要采集日志的集群机器上启动 `logstash-shipper` 容器。

```
docker-compose -f elk-logstash-shipper.yml up -d
```

### 三 初始化

初始化kibana，这货启动稍慢..要耐心一点..
	
第一次启动时，需要建立索引，但没数据的话是无法创建，所以要先添加一些数据。

```
docker run --rm --log-driver gelf --log-opt gelf-address=udp://127.0.0.1:9500 -d registry.cn-hangzhou.aliyuncs.com/kennylee/alpine echo hello world
```

