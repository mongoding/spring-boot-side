# Etcd

![](https://github.com/coreos/etcd/raw/master/logos/etcd-horizontal-color.png)

>etcd is a distributed, consistent key-value store for shared configuration and service discovery, with a focus on being:
>
>* Simple: well-defined, user-facing API (gRPC)
>* Secure: automatic TLS with optional client cert authentication
>* Fast: benchmarked 10,000 writes/sec
>* Reliable: properly distributed using Raft

基于 [quay.io/coreos/etcd](http://quay.io/coreos/etcd) 镜像修改

Github: https://github.com/coreos/etcd

主要修改如下:

* 使用阿里云源
* 安装的基础工具 curl bash tzdata tar unzip 
* 中国时区

更多使用方法可参考 https://github.com/coreos/etcd/releases/

参考构建命令

```
docker build -t kennylee26/etcd .
```

