# Ci-HTML

前后端分离的开发情况下，为了方便业务人员进行查看前端页面，需要用来持续集成到git上某分支上的html内容到到http服务器上。

## 说明

Dockerfile上有几个重要的环境参数，可以根据实际情况进行修改，建议使用docker-compose来传递这些参数

* local\_repo

    本地保存的路径，一般情况下不用修改

* repo\_remote

    远程分支服务器的下载地址，需要验证时，可把账户密码传递进去。

* repo\_branch

    项目的分支

* www\_for\_repo

    项目下静态文件的相对路径。
