package org.spring.springboot.command;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCompute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class IgniteComputeCommandRunner implements CommandLineRunner {

    @Autowired
    private Ignite ignite;

    @Override
    public void run(String... args) {
        IgniteCompute compute = ignite.compute();
        compute.broadcast(() -> System.out.println("Hello Node: " + ignite.cluster().localNode().id()));

    }
}