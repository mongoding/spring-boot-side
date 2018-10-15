FROM registry.cn-hangzhou.aliyuncs.com/kennylee/java:ubuntu-serverjre8

MAINTAINER kennylee26 <kennylee26@gmail.com>

RUN apt-get update && \
    apt-get install -yq --no-install-recommends wget pwgen ca-certificates && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

ENV TOMCAT_MAJOR_VERSION '9'
ENV CATALINA_HOME /opt/tomcat
ENV JAVA_OPTS="-Djava.security.egd=file:///dev/urandom -server -Xms128m -Xmx1024m"

# INSTALL TOMCAT
RUN curl -sSL http://git.oschina.net/kennylee/shell/raw/master/tomcat_download.sh | bash -s ${TOMCAT_MAJOR_VERSION} && \
    tar zxf apache-tomcat-*.tar.gz && \
    rm apache-tomcat-*.tar.gz && \
    mv apache-tomcat* ${CATALINA_HOME}

# Add service
COPY tomcat /etc/init.d/
RUN chmod +x /etc/init.d/tomcat

# Remove garbage
RUN rm -rf ${CATALINA_HOME}/webapps/examples && \
    rm -rf ${CATALINA_HOME}/webapps/docs && \
    rm -rf ${CATALINA_HOME}/webapps/ROOT

WORKDIR ${CATALINA_HOME}

COPY run.sh /run.sh
RUN chmod +x /*.sh

EXPOSE 8080

CMD ["/run.sh"]
