#!/bin/bash

ID=`docker ps|grep activemq|awk '{print $1}'`
echo activemq.ID:$ID
docker exec -it $ID /usr/bin/tail -f /apache-activemq-5.14.5/data/activemq.log
