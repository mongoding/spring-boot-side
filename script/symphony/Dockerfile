# ------------------------- WAR builder -------------------------
FROM registry.cn-hangzhou.aliyuncs.com/kennylee/maven:3.5-jdk-8-alpine as builder

# official repository https://github.com/b3log/symphony
ARG SYMPHONY_REPOSITORY=https://gitee.com/kennylee/symphony.git

ENV BUILD_PATH="/tmp" \
    PROJECT_NAME="symphony" \
    DB_PASSWORD="111111" 

ENV CONFIG_FILE=${BUILD_PATH}/${PROJECT_NAME}/src/main/resources/local.properties

RUN cd $BUILD_PATH && \
        git clone $SYMPHONY_REPOSITORY $PROJECT_NAME
RUN sed -i "s/127.0.0.1\:3306/db:3306/g" $CONFIG_FILE && \
    sed -i "s/jdbc\.password=*/jdbc\.password=${DB_PASSWORD}/g" $CONFIG_FILE

# war mus be at ${BUILD_PATH}/${PROJECT_NAME}/target/symphony.war
RUN cd ${BUILD_PATH}/${PROJECT_NAME} && \
        git checkout my && \
        mvn package -Dmaven.test.skip=true

# ------------------------- app container -------------------------
FROM registry.cn-hangzhou.aliyuncs.com/kennylee/tomcat:tomcat9-jre8

ENV APP_DIR=/opt/tomcat/webapps/ROOT

COPY --from=builder /tmp/symphony/target/symphony.war /tmp/symphony.war

EXPOSE 8250

RUN mkdir -p $APP_DIR && cd $APP_DIR && jar -xvf /tmp/symphony.war

RUN rm -rf /opt/tomcat/webapps/manager && \
        rm -rf /opt/tomcat/webapps/host-manager
