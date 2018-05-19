FROM registry.cn-hangzhou.aliyuncs.com/kennylee/alpine

MAINTAINER kennylee26 <kennylee26@gmail.com>

RUN apk update && apk upgrade && \
    apk add --no-cache git openssh

RUN sed -i 's/dl-cdn.alpinelinux.org/mirrors.aliyun.com/g' /etc/apk/repositories

ENV HOME /root
ENV local_repo=$HOME/html_repo\
    repo_remote=http://sys:11111111@192.168.3.231:10080/zgbj/gkxt.git\
    repo_branch=feature_frontend\
    www_for_repo=common/src/main/webapp

VOLUME /usr/share/nginx/html

RUN git clone $repo_remote $local_repo
RUN cd $local_repo && \
    git checkout $repo_branch

WORKDIR $HOME

COPY run.sh /run.sh
RUN chmod +x /run.sh

CMD ["/run.sh"]
