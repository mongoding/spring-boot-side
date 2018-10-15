FROM redis:3.2

ENV HOME /data/redis-cluster

# Only users in China need RUN this cmd
RUN echo "deb http://mirrors.aliyun.com/debian/ jessie main non-free contrib">/etc/apt/sources.list

RUN apt-get update && apt-get -y install ruby curl 
#supervisor
RUN /usr/bin/gem install redis -v 3.2.0

# make dir and redis.conf
# port range [7001..7006], means 3 masters with 1 slave each master.
RUN mkdir -p    ${HOME}/7001/data \
                ${HOME}/7002/data \
                ${HOME}/7003/data \
                ${HOME}/7004/data \
                ${HOME}/7005/data \
                ${HOME}/7006/data

# singleton redis
RUN mkdir -p /data/redis/data
  
ADD conf ${HOME}
RUN ls  ${HOME}
RUN mv ${HOME}/ /data/redis/
    
# get redis-trib.rb
RUN curl https://raw.githubusercontent.com/antirez/redis/3.2/src/redis-trib.rb > ${HOME}/redis-trib.rb
# or ADD from local
#ADD ./redis-trib.rb ${HOME}/redis-trib.rb
RUN chmod a+x ${HOME}/redis-trib.rb


ADD start-redis-cluster.sh ${HOME}/start-redis-cluster.sh
RUN chmod a+x ${HOME}/start-redis-cluster.sh

EXPOSE 7001 7002 7003 7004 7005 7006 6379

ENTRYPOINT ["/bin/sh", "/data/redis-cluster/start-redis-cluster.sh"]
#CMD ["bin/bash", "-D"]

#run with: docker run -h redis-cluster -p 6379:6379 -p 7001:7001 <image hash>
