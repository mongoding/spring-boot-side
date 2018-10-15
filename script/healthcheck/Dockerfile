FROM registry.docker:5000/timekey/python

MAINTAINER kennylee26 <kennylee26@gmail.com>

COPY docker-entrypoint.py /
COPY heath_check.py /
COPY network_tool.py /
COPY entrypoint.sh /
RUN chmod +x /entrypoint.sh

ENTRYPOINT ["/entrypoint.sh"]
