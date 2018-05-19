#!/bin/bash

source /root/.bashrc

#export JAVA_HOME="/usr/lib/jvm/java-7-openjdk-amd64"
#export JAVA_OPTS="-server -Xms256m -Xmx1536m -XX:PermSize=64M -XX:MaxPermSize=192M"
#export CATALINA_HOME="/opt/tomcat"

/bin/bash -c "${CATALINA_HOME}/bin/catalina.sh run"

