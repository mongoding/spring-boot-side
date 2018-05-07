# 基础镜像  
FROM frolvlad/alpine-oraclejdk9:slim
  
# VOLUME命令用于让你的容器访问宿主机上的目录。  
VOLUME /tmp  
  
# ADD命令有两个参数，源和目标。它的基本作用是从源系统的文件系统上复制文件到目标容器的文件系统。如果源是一个URL，那该URL的内容将被下载并复制到容器中。  
ADD spring-boot-with-docker-0.0.1.SNAPSHOT.jar app.jar

EXPOSE 8080
  
# RUN命令是Dockerfile执行命令的核心部分。它接受命令作为参数并用于创建镜像。  
RUN sh -c 'touch /app.jar'  
  
#ENV命令用于设置环境变量。这些变量以”key=value”的形式存在，并可以在容器内被脚本或者程序调用。
ENV JAVA_OPTS=""  
  
# ENTRYPOINT 帮助你配置一个容器使之可执行化  
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]  