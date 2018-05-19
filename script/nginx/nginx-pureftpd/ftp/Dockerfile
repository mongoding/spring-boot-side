# Pure ftp-Server
#
# VERSION 0.0.1
# Base image: https://github.com/stilliard/docker-pure-ftpd
# Command format: Instruction [arguments command] ..

# 第一行必须指定基于的基础镜像
FROM registry.alauda.cn/kenny/pure-ftpd

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

RUN apt-get -y update
RUN apt-get -y install vim curl wget

RUN apt-get clean && \
    rm -rf /var/lib/apt/lists/*

VOLUME /etc/pure-ftpd
VOLUME /home/ftpusers

#add base user info
COPY run.sh /run.sh
RUN chmod +x /*.sh

# Define default command.
EXPOSE 21/tcp 30000-30009

CMD ["/run.sh"]
