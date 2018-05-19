# ElasticSearch

[elasticsearch](https://github.com/elastic/elasticsearch-docker) 的本地化镜像，主要是为了国内加速和一些修改。

修改如下:

* 默认阿里云镜像源。
* 安装 curl bash tzdata tar unzip 包。
* 中国时区。

部署时，注意配置修改部署机的 _vm.max_map_count_ 配置，方法参考下面：

```
vim /etc/sysctl.conf
# 新增内容
vm.max_map_count=262144
# 读取配置
sysctl -p
# 检查
sysctl -a | grep 'vm.max_map_count'
```


