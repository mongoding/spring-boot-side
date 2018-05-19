#!/bin/bash
STORAGE=/var/local/fdfs/storage/logs/storaged.log
TRACKER=/var/local/fdfs/tracker/logs/trackerd.log
NGINX=/usr/local/nginx/logs/access.log

ID=`docker ps|grep fastdfs|awk '{print $1}'`
echo fastdfs.ID:$ID
echo 'Use param tracker|storage|nginx to see log of each service such as "./log.sh tracker". No param equals to "storage".'
CAT=$1
LOG=""
if [[ "${CAT}" = "tracker" ]];then
    LOG=${TRACKER}
elif [[ "${CAT}" = "nginx" ]]; then
    LOG=${NGINX}
else 
    LOG=${STORAGE}
fi

docker exec -it $ID /usr/bin/tail -f ${LOG}