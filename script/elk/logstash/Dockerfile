# https://github.com/elastic/logstash-docker
FROM docker.elastic.co/logstash/logstash:5.3.0

USER root

RUN sed -i 's/archive.ubuntu.com/mirrors.163.com/g' /etc/apt/sources.list

RUN \
  apt-get update && \
  apt-get install -y language-pack-zh-hans && \ 
  rm -rf /var/lib/apt/lists/*
RUN locale
ENV LANG=zh_CN.UTF-8\
    LANGUAGE=zh_CN:zh:en_US:en\
    LC_ALL=zh_CN.UTF-8\
    TZ=Asia/Shanghai\
    TERM=xterm

RUN ln -fs /usr/share/zoneinfo/$TZ /etc/localtime && \
        echo $TZ > /etc/timezone && \
        dpkg-reconfigure --frontend noninteractive tzdata

USER logstash

RUN logstash-plugin install logstash-input-gelf


