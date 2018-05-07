package org.spring.springboot.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("org.spring.springboot.ignite")
@Component
public class IginteConfigProperties {

    /**
     * 基于静态ip 发现的ip配置
     */
    private String ip;

    /**
     * 基于zk 发现的zkip 配置
     */
    private String zkHost;

    private int zkPort;

    private String zkNodeName = "default-node";

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }


    public String getZkNodeName() {
        return zkNodeName;
    }

    public void setZkNodeName(String zkNodeName) {
        this.zkNodeName = zkNodeName;
    }

    public String getZkHost() {
        return zkHost;
    }

    public void setZkHost(String zkHost) {
        this.zkHost = zkHost;
    }

    public int getZkPort() {
        return zkPort;
    }

    public void setZkPort(int zkPort) {
        this.zkPort = zkPort;
    }

    @Override
    public String toString() {
        return "IginteConfigProperties{" +
                "ip='" + ip + '\'' +
                ", zkHost='" + zkHost + '\'' +
                ", zkPort='" + zkPort + '\'' +
                ", zkNodeName='" + zkNodeName + '\'' +
                '}';
    }
}
