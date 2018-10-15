/usr/local/bin/redis-server /home/redis-cluster/7001/redis.conf
/usr/local/bin/redis-server /home/redis-cluster/7002/redis.conf
/usr/local/bin/redis-server /home/redis-cluster/7003/redis.conf
/usr/local/bin/redis-server /home/redis-cluster/7004/redis.conf
/usr/local/bin/redis-server /home/redis-cluster/7005/redis.conf
/usr/local/bin/redis-server /home/redis-cluster/7006/redis.conf

host=127.0.0.1
echo "yes"|/home/redis-cluster/redis-trib.rb create --replicas 1 ${host}:7001 ${host}:7002 ${host}:7003 ${host}:7004 ${host}:7005 ${host}:7006


/usr/local/bin/redis-server /home/redis/redis.conf