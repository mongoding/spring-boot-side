FROM mysql:5.7

# 维护者信息
MAINTAINER kennylee26 <kennylee26@gmail.com>

RUN echo "deb http://mirrors.163.com/debian/ jessie main non-free contrib\n\
    deb http://mirrors.163.com/debian/ jessie-updates main non-free contrib\n\
    deb http://mirrors.163.com/debian/ jessie-backports main non-free contrib\n\
    deb-src http://mirrors.163.com/debian/ jessie main non-free contrib\n\
    deb-src http://mirrors.163.com/debian/ jessie-updates main non-free contrib\n\
    deb-src http://mirrors.163.com/debian/ jessie-backports main non-free contrib\n\
    deb http://mirrors.163.com/debian-security/ jessie/updates main non-free contrib\n\
    deb-src http://mirrors.163.com/debian-security/ jessie/updates main non-free contrib\n\
    deb http://ftp.cn.debian.org/debian jessie main" > /etc/apt/sources.list

RUN apt-get update && \
    apt-get install -y curl git unzip vim wget && \
    apt-get install -y locales kde-l10n-zhcn && \ 
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

RUN sed -i 's/# zh_CN.UTF-8 UTF-8/zh_CN.UTF-8 UTF-8/g' /etc/locale.gen

RUN locale && locale-gen "zh_CN.UTF-8"
       
# Set environment variables.
ENV LANG=zh_CN.UTF-8\
    LANGUAGE=zh_CN:zh:en_US:en\
    LC_ALL=zh_CN.UTF-8\
    TZ=Asia/Shanghai\
    TERM=xterm

RUN ln -fs /usr/share/zoneinfo/$TZ /etc/localtime && \
            echo $TZ > /etc/timezone && \        
            dpkg-reconfigure --frontend noninteractive tzdata && \
            dpkg-reconfigure --frontend noninteractive locales

COPY my.cnf /etc/mysql/my.cnf

EXPOSE 3306
CMD ["mysqld"]
