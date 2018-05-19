<img src="https://cloud.githubusercontent.com/assets/873584/19897669/e6a6f5ce-a093-11e6-8cf3-8e5c2acea033.png">

## 说明

### 简介

[Symphony](https://github.com/b3log/symphony)（[ˈsɪmfəni]，n.交响乐）是一个现代化的社区平台，因为它：

* 实现了面向内容讨论的论坛
* 包含了面向用户分享、交友、游戏的社交网络
* 集成了聚合独立博客的能力，共建共享优质资源
* 并且 `100%` 开源

欢迎到 [Sym 官方讨论区](https://hacpai.com/register?r=88250)了解更多。

### 动机

Sym 的诞生是有如下几点原因：

（正版）

* 很多系统界面上仍然保持着老式风格，远远没有跟上时代发展的脚步，它们没有创新、好玩的特性，缺少现代化的交互元素和用户体验
* 大部分系统是从程序员的角度进行设计的，没有考虑实际的产品、运营需求，这类系统功能过于简陋、细节不够精致、缺乏长期维护 
* 另外，我们正在探索新的社区模式，实现独奏（[Solo](https://github.com/b3log/solo)）与协奏（[Symphony](https://github.com/b3log/symphony)）相结合的[社区新体验](https://hacpai.com/b3log)

（野版）

* 万能的 GitHub 上连个能用的 Java 社区系统都找不到，Sym 填补了这个宇宙级空白
* 做最 NB 的开源社区系统，预计几年以后 82% 的社区都将是 Sym 搭建的
* 作者技痒，炫技之作，Ruby/Python/Node.js/（特别是）PHP 怎么能比得过 Java

### 更多请参见

* [官方中文文档](https://github.com/b3log/symphony/blob/master/README_zh_CN.md)
* [github](https://github.com/b3log/symphony)

## Docker镜像说明

symphony镜像，从官方源码下载源码，进行构建，修改默认mysql连接地址为 `db` ，因为后面使用到的docker-compose中mysql的service名为db，并且密码为*111111*

docker-compose例子:

```
```


