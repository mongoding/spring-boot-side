# ElasticSearch+Logstash JDBC同步-实现搜索引擎功能

## 环境部署

由于使用ElasticSearch，先修改下变量。

```
vim /etc/sysctl.conf
# 新增内容
vm.max_map_count=262144
# 读取配置
sysctl -p
# 检查
sysctl -a | grep 'vm.max_map_count'
```

## 说明

* db.ini: 数据库同步的配置文件。
* demo_mysql.sql: mysql数据库的测试库表结构及数据。

## 数据库同步文件

把想要同步的数据库的SQL语句文件放到，`/logstash/db-shipper/sql/` 文件夹下，参考目前已经有的*department.sql*和*user.sql*文件。

*例子是采取增量同步的方式，每个表中必须有一个同名的创建时间的标识。*

文件名将作为导入到ElasticSearch中的 _type_ 标识。 

## 配置生成

1. 修改数据库配置 

	根据部署环境，修改 `/logstash/db-shipper/db.ini` 文件
	
	注意 _schedule_ 一栏，可方便的设置不同数据库脚本生成间隔。
	
2. 生成配置文件

	```
	python generate_logstash_config.py
	```

3. 检查

	打开 pipeline/logstash.conf 文件，确认配置是否正确。

## 使用方法

配置文件生成完后。

```
docker-compose up -d
```

其他请参考docker-compose的使用文档。

