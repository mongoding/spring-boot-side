nginx+ftp功能服务(本例用来上传gitbook的静态页面)

=====

1. 在宿主机器执行以下命令，存放相关数据文件

	执行命令

	```
	docker-compose up -d
	```

2. FTP设置

	```
	# 创建密码
	docker exec -it gitbook-ftp /bin/bash
	pure-pw useradd ftp -u ftpuser -d /usr/share/nginx/html
	# 创建库
	pure-pw mkdb
	```

	其中，用户名为 `ftp` ，密码输入后，重启服务。

	注意，ftp连接时不要选择被动模式！

3. Nginx

	默认是不开放文档列表功能，如果目录中没索引文件，会报 `403 Forbidden`

--------

FTP配置信息，参见：http://download.pureftpd.org/pub/pure-ftpd/doc/README


