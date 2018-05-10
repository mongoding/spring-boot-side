# spring boot 学习教程 spring-boot-side

### 技术背景

- spring 体系庞大，配置复杂，Spring boot 简化了各种整合配置
- Spring cloud 大行其道，是以Spring boot 为基础的
- Spring 官网主推的技术 https://spring.io/

### 版本信息

- jdk：jdk8
- Spring boot ：Spring boot 2.0

### spring boot 2 变动
- @ConditionalOnBean现在的判断条件由OR变为了AND。
- 默认的连接池已经由Tomcat切换到了HikariCP
- Spring Boot现在默认是使用CGLIB代理，同时包含AOP支持
- Spring Boot 2.0 是建立在Spring Framework 5.0之上的（最低要求）。Spring 5最大的亮点就是reactive
- 一个全新的spring-boot-starter-json starter 聚合了很多常用的json工具，可以支持对json的读写
- 基本支持了Java 9。之所以是“基本”，是因为还没得到用户的验证。
- TLS 配置 和 HTTP/2 支持，你现在也可以为你的MVC 或 WebFlux应用配置HTTP/2：使用server.http2.enabled。
- @KafkaListener支持使用@SendTo

- 其他参见 https://mp.weixin.qq.com/s/EWmuzsgHueHcSB0WH-3AQw

### 学习路线（建议按照以下顺序学习）


- springboot-quickstart ：spirng boot 快速开始项目，内容简单
- springboot-base ：spring boot 基础，熟悉Spring boot 的各种配置，及自动配置原理，以及研究思路
- springboot-data-jdbc：与jdbc 整合的例子
- springboot-data-jpa：与jpa 整合的例子
- springboot-data-mybatis：与mybatis 整合的例子
- springboot-data-mybatis-annotation：与mybatis 整合例子，mybatis 使用注解
- springboot-data-mybatis-mutil-datasource：与mybatis 整合例子，多数据源的情况
- springboot-web：与Spring web 常见技术整合例子，包括上传下载，mvc，servlet等
- springboot-web-thymeleaf：web 项目整合thymeleaf 模板（页面模板技术）
- springboot-web-freemarker：web 项目整合freemarker（页面模板技术）
- springboot-test:与常见测试技术的整合例子
- springboot-async-methods：整合Spring异步方法的例子
- springboot-cache-with-spring：与Spring 缓存的整合例子
- springboot-cache-redis：与redis 的整合例子


----------------------

### 内容逐步更新中


- springboot-mq-kafka：与kafka 的整合例子
- springboot-mq-redis:与redis 的整合例子，用redis 实现消息发布订阅
- springboot-mq-rabbitmq：与rabbitmq 的整合
- springboot-doc： 处理接口文档的技术整合例子，如swagger
- springboot-scheduling-tasks:定时任务的整合例子，如Spring 定时任务
- springboot-scheduling-tasks-mossrose:与mossrose整合例子，实现分布式定时任务
- springboot-config-center：与配置中心的整合，实现配置集中管理的例子
- springboot-data-elasticsearch：与搜索的整合例子
- springboot-data-mongodb：与mongodb 的整合例子
- springboot-webflux-quickstart：Spring5 中出现的新模块，响应式编程，快速启动例子
- springboot-webflux-web：webflux 相对完整例子
- springboot-webflux-websocket：webflux与websocket
- springboot-webflux-redis-cache：webflux与redis
- springboot-webflux-mongodb：webflux与mongodb
- springboot-with-docker：用docker 容器技术启动Spring boot
- springboot-jdk：jdk 内容联系模块，如jdk9 等新内容（尚无实质内容）
- springboot-cap-ignite：与ignite 整合的例子
- springboot-cap-zookeeper：与zookeeper 整合的例子
- springboot-dubbo-provider：与dubbo整合的例子，服务提供者（与Spring boot 2.0 整合的待发布，暂无法完成测试）
- springboot-dubbo-consumer：与dubbo整合的例子，服务消费者（与Spring boot 2.0 整合的待发布，暂无法完成测试）

### 资源地址(欢迎加星或fork)

#### github 地址：https://github.com/mongoding/spring-boot-side

#### spring boot 脑图地址：https://github.com/mongoding/brain-map-collection/tree/master/%E5%AD%A6%E4%B9%A0
#### 博客地址：https://mongoding.github.io/

### 推荐学习地址：
#### spring cloud: http://www.spring4all.com/
#### spring boot : https://gitee.com/hengboy/spring-boot-chapter
#### Spring Boot：https://github.com/dyc87112/SpringBoot-Learning

### 官方文档翻译
#### https://github.com/qibaoguang/Spring-Boot-Reference-Guide
#### https://legacy.gitbook.com/book/qbgbook/spring-boot-reference-guide-zh/details


### 最常见基础包

```
<!--自动热部署包-->
<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <optional>true</optional>
</dependency>
```

```
<!--web 项目包-->
<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

```
<!--Spring boot 基础包-->
<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
</dependency>
```

```
<!--测试包-->
<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
</dependency>
```

```
<!--健康监控管理包-->
<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```


```
<parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.0.1.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
</parent>
```





