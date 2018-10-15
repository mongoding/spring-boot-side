# https://github.com/elastic/elasticsearch-docker
FROM registry.cn-hangzhou.aliyuncs.com/kennylee/elasticsearch:5.3.0

# Add your elasticsearch plugins setup here
# Example: RUN elasticsearch-plugin install analysis-icu

COPY x-pack-5.3.0.jar /usr/share/elasticsearch/plugins/x-pack/
# 创建备份的目录，可通过外部挂载出来
RUN mkdir -p /usr/share/elasticsearch/backups/
