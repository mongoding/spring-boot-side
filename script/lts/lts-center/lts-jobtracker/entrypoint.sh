#! /bin/bash

BASE_PATH=/data/app/
ORI_APP_FILE=$(find $BASE_PATH -type f -name "*.jar" 2>/dev/null | head -1)
APP_FILE=${BASE_PATH}app.jar

if [ ${#ORI_APP_FILE} -gt 0 ]; then
    echo "create symbolic link for $ORI_APP_FILE"
    if [ -e $APP_FILE ]; then
        #echo "$APP_FILE was existed, remove that."
        rm -f $APP_FILE
    fi
    ln -s $ORI_APP_FILE $APP_FILE
fi

# if $APP_FILE not exist, let it throw error。
java $JAVA_OPTS -jar $APP_FILE "$@"
