#!/bin/bash

PROJECT_NAME="${PROJECT_NAME:=gkxt}"
REPO_BRANCH="${REPO_BRANCH:=master}"
CUSTOM_JAVA_OPTS=
BUILD_COMMAND="${BUILD_COMMAND:=./gradlew --no-daemon clean dist -x test}"
LOCAL_REPO_PATH="${LOCAL_REPO_PATH:=/var/source/}"
REPO_URL="${REPO_URL:=}"

if [ -n "${JAVA_OPTS}" ]; then
    CUSTOM_JAVA_OPTS="$JAVA_OPTS"
fi

source /root/.bashrc
TOMCAT_WEBAPPS_PATH=$CATALINA_HOME'/webapps/'

if [ -n "${CUSTOM_JAVA_OPTS}" ]; then
    export JAVA_OPTS=$CUSTOM_JAVA_OPTS
fi

function fetch_repo(){
    cd $LOCAL_REPO_PATH$PROJECT_NAME
    git checkout $REPO_BRANCH
    git fetch origin $REPO_BRANCH
    git reset --hard origin/$REPO_BRANCH
}

function clone_repo(){
    cd $LOCAL_REPO_PATH && git clone $REPO_URL $PROJECT_NAME && cd $PROJECT_NAME
    git checkout $REPO_BRANCH
}

if [ -n "$REPO_URL" ]; then
    ${CATALINA_HOME}/bin/catalina.sh stop
    sleep 3s
    if [ -d $LOCAL_REPO_PATH$PROJECT_NAME ]; then
        fetch_repo    
    else
        clone_repo
    fi
    $BUILD_COMMAND
    /bin/bash -c "rm -rf ${TOMCAT_WEBAPPS_PATH}* && unzip -q $LOCAL_REPO_PATH$PROJECT_NAME/build/dist/*.zip -d $TOMCAT_WEBAPPS_PATH"
fi
${CATALINA_HOME}/bin/catalina.sh run

