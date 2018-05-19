FROM  registry.cn-hangzhou.aliyuncs.com/kennylee/java-nodejs:java8-nodejs7

MAINTAINER kennylee26 <kennylee26@gmail.com>

RUN apt-get update && \
    apt-get install -yq --no-install-recommends wget pwgen ca-certificates && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

ENV TOMCAT_MAJOR_VERSION '8'
ENV CATALINA_HOME /opt/tomcat

# INSTALL TOMCAT
RUN curl -sSL http://git.oschina.net/kennylee/shell/raw/master/tomcat_download.sh | bash -s ${TOMCAT_MAJOR_VERSION} && \
    tar zxf apache-tomcat-*.tar.gz && \
    rm apache-tomcat-*.tar.gz && \
    mv apache-tomcat* ${CATALINA_HOME}

# Add service
COPY tomcat /etc/init.d/
RUN chmod +x /etc/init.d/tomcat

# Add User
#RUN useradd -b "${CATALINA_HOME}" -M -s /bin/bash tomcat \
#    && echo tomcat:tomcat | chpasswd \
#    && chown tomcat:tomcat -R $CATALINA_HOME

# Remove garbage
RUN rm -rf ${CATALINA_HOME}/webapps/examples && \
    rm -rf ${CATALINA_HOME}/webapps/docs && \
    rm -rf ${CATALINA_HOME}/webapps/ROOT

WORKDIR ${CATALINA_HOME}

EXPOSE 8080

RUN sed -i "s@\/usr\/lib\/jvm\/java-7-oracle@${JAVA_HOME}@" /etc/init.d/tomcat
RUN sed -i "s@-server -Xms128m -Xmx1024m -XX\:PermSize=64M -XX\:MaxPermSize=192M@${JAVA_OPTS}@" /etc/init.d/tomcat

COPY supervisord.conf /etc/supervisor/conf.d/supervisord.conf
COPY supervisord_wrapper.sh /supervisord_wrapper.sh

RUN chmod +x /*.sh

# Define default command.
CMD ["/usr/bin/supervisord", "-c", "/etc/supervisor/supervisord.conf"]

