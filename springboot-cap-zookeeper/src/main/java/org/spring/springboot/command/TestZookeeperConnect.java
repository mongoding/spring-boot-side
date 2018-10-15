package org.spring.springboot.command;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.api.GetChildrenBuilder;
import org.apache.zookeeper.CreateMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestZookeeperConnect implements CommandLineRunner {

    @Autowired
    private CuratorFramework client;

    @Override
    public void run(String... args) throws Exception {
        //client.start();


        //持久化节点
        byte[] data = { 1, 2, 3 };

        client.create().withMode(CreateMode.PERSISTENT).forPath("/zktest/p1", data);

        //临时节点
        client.create().withMode(CreateMode.EPHEMERAL).forPath("/zktest/e1", data);

        //持久化时序节点

        client.create().withMode(CreateMode.PERSISTENT_SEQUENTIAL).forPath("/zktest/ps1", data);
        //临时时序节点

        client.create().withMode(CreateMode.EPHEMERAL_SEQUENTIAL).forPath("/zktest/es1", data);

        //设置和获取节点数据
        //设置节点数据
        client.setData().forPath("/zktest/ps1", data);
        //获取节点数据
        byte[] data2 = client.getData().forPath("/zktest/ps1");

        String namespace = client.getNamespace();

    }
}
