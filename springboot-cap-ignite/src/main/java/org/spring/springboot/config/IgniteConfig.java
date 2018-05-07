package org.spring.springboot.config;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.logger.slf4j.Slf4jLogger;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.TcpDiscoveryIpFinder;
import org.apache.ignite.spi.discovery.tcp.ipfinder.multicast.TcpDiscoveryMulticastIpFinder;
import org.apache.ignite.spi.discovery.tcp.ipfinder.vm.TcpDiscoveryVmIpFinder;
import org.apache.ignite.spi.discovery.tcp.ipfinder.zk.TcpDiscoveryZookeeperIpFinder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.SpringbootIgniteApplication;
import org.spring.springboot.properties.IginteConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

@Configuration
public class IgniteConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringbootIgniteApplication.class);

    @Autowired
    private IginteConfigProperties iginteConfigProperties;


    @Bean
    public IgniteConfiguration IgniteConfiguration(TcpDiscoverySpi tcpDiscoverySpi) {
        IgniteConfiguration cfg = new IgniteConfiguration();
        String zkNodeName = iginteConfigProperties.getZkNodeName();
        cfg.setIgniteInstanceName(zkNodeName);
        cfg.setMetricsLogFrequency(0);
        cfg.setGridLogger(new Slf4jLogger());
        cfg.setDiscoverySpi(tcpDiscoverySpi);

        CacheConfiguration cacheCfg = new CacheConfiguration();
        cacheCfg.setName(zkNodeName);
        cacheCfg.setBackups(0);
        cfg.setCacheConfiguration(cacheCfg);

        return cfg;
    }

    @Bean
    public Ignite igniteInit(IgniteConfiguration igniteConfiguration) {
        Ignite ignite = Ignition.start(igniteConfiguration);
        return ignite;
    }

    @Bean
    public TcpDiscoverySpi tcpDiscoverySpi(TcpDiscoveryIpFinder tcpDiscoveryIpFinder) {
        TcpDiscoverySpi discoSpi = new TcpDiscoverySpi();
        try {
            discoSpi.setLocalAddress(InetAddress.getLocalHost().getHostAddress());
        } catch (UnknownHostException e) {
            LOGGER.warn("Error while getting local address.", e);
        }
        discoSpi.setLocalPort(iginteConfigProperties.getZkPort());

        discoSpi.setIpFinder(tcpDiscoveryIpFinder);
        return discoSpi;
    }

    //基于组播的发现
    @Bean("tcpDiscoveryMulticastIpFinder")
    public TcpDiscoveryIpFinder TcpDiscoveryMulticastIpFinder() {
        TcpDiscoveryMulticastIpFinder ipFinder = new TcpDiscoveryMulticastIpFinder();
        String ip = iginteConfigProperties.getIp();
        ipFinder.setMulticastGroup(ip);
        return ipFinder;
    }

    //基于静态IP的发现
    //@Bean("tcpDiscoveryVmIpFinder")
    public TcpDiscoveryIpFinder TcpDiscoveryVmIpFinder() {
        TcpDiscoveryVmIpFinder ipFinder = new TcpDiscoveryVmIpFinder();
        // Set initial IP addresses.
        // Note that you can optionally specify a port or a port range.
        ipFinder.setAddresses(Arrays.asList("1.2.3.4", "1.2.3.5:47500..47509"));

        return ipFinder;
    }

    //基于组播和静态IP的发现
    //@Bean("tcpDiscoveryVmIpFinder")
    public TcpDiscoveryIpFinder TcpDiscoveryMulticastIpFinder1() {
        TcpDiscoveryMulticastIpFinder ipFinder = new TcpDiscoveryMulticastIpFinder();
        // Set Multicast group.
        ipFinder.setMulticastGroup("228.10.10.157");
        // Set initial IP addresses.
        // Note that you can optionally specify a port or a port range.
        ipFinder.setAddresses(Arrays.asList("1.2.3.4", "1.2.3.5:47500..47509"));

        return ipFinder;
    }


    //基于JDBC的发现
    /*@Bean("tcpDiscoveryVmIpFinder")
    public TcpDiscoveryIpFinder TcpDiscoveryJdbcIpFinder() {
        // Configure your DataSource.
        DataSource someDs = MySampleDataSource(...);
        TcpDiscoveryJdbcIpFinder ipFinder = new TcpDiscoveryJdbcIpFinder();
        ipFinder.setDataSource(someDs);
        return ipFinder;
    }*/


    //基于ZooKeeper的发现
    //@Bean("tcpDiscoveryVmIpFinder")
    public TcpDiscoveryIpFinder TcpDiscoveryZookeeperIpFinder() {
        TcpDiscoveryZookeeperIpFinder ipFinder = new TcpDiscoveryZookeeperIpFinder();
        // Specify ZooKeeper connection string.
        String zkHost = iginteConfigProperties.getZkHost();
        String zkNodeName = iginteConfigProperties.getZkNodeName();

        ipFinder.setZkConnectionString(zkHost);
        ipFinder.setServiceName(zkNodeName);
        ipFinder.setBasePath("/spring-boot");

        return ipFinder;
    }


}
