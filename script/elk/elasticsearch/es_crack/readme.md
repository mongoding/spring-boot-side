# ElasticSearch破解

简要说明：直接构建即可把破解包传入到容器内，然后把修改后的合法License传入到es服务器即可。

## License问题说明

目前license分为 _OPEN SOURCE(trial)_ 、 _BASIC_ 、 _GOLD_ 、 _PLATINUM_ 和 _ENTERPRISE_ ，其中免费的是前两个。[see also](https://www.elastic.co/subscriptions)

而docker内默认的是 `OPEN SOURCE` 的license，只有一个月的使用时间。在实际使用时肯定是不够的。而 `BASIC` 的license使用时间是一年，也勉强可以，最多一年更新一次。

注册的 [base free license](https://register.elastic.co/)

```
# 查看证书信息
curl 'http://<host>:<port>/_xpack/license'?pretty
# 上传证书
curl -XPUT -u elastic 'http://<host>:<port>/_xpack/license' -H "Content-Type: application/json" -d @license.json
```

## 破解License(docker环境)

大部分情况下，可能还是希望一劳永逸的办法，所以只能破解了。

1. 编写破解的x-pack-5.3.0.jar包

	破解的关键文件是 org.elasticsearch/license/LicenseVerifier.class

	首先，把x-pack的jar包拷贝出来，路径在 `/usr/share/elasticsearch/plugins/x-pack/x-pack-5.3.0.jar`
	
	```sh
	# 编译LicenseVerifier.java
	javac -cp /usr/share/elasticsearch/plugins/x-pack/x-pack-5.3.0.jar LicenseVerifier.java
	# 移动编译好的class文件到目录
	mkdir -p org/elasticsearch/license/ && cp LicenseVerifier.class org/elasticsearch/license/
	# 单个更新jar包的同名文件
	jar uvf /usr/share/elasticsearch/plugins/x-pack/x-pack-5.3.0.jar org/elasticsearch/license/LicenseVerifier.class
	```
	
	包搞定后传回 /usr/share/elasticsearch/plugins/x-pack/x-pack-5.3.0.jar

	*附: LicenseVerifier.java源码*

	```java
	package org.elasticsearch.license;

	public class LicenseVerifier{
		public static boolean verifyLicense(final License license, final byte[] encryptedPublicKeyData) {
			return true;
		}
		public static boolean verifyLicense(final License license) {
			return true;
		}
	}
	```

	*使用破解好的x-pack-5.3.0.jar包可跳过上述步骤*

2. 申请合法的license

	注册的free license https://register.elastic.co/
	
	拿到license后，修改两个地方
	
	①"type":"platinum"
	②"expiry_date_in_millis":2524579200999

3. 上传license

	```sh
	#! /bin/bash
	LICENSE_PATH='license.json'
	curl -XPUT -u elastic:changeme 'http://192.168.3.157:9200/_xpack/license?pretty' -d @$LICENSE_PATH
	```

	参考: [elasticsearch之x-pack破解](http://blog.csdn.net/u013066244/article/details/73927756)


