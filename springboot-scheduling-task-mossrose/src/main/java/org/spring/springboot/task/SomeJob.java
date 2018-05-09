package org.spring.springboot.task;

import com.jiuxian.boot.mossrose.autoconfigure.Job;
import com.jiuxian.mossrose.job.SimpleJob;

import java.util.UUID;


@Job(group = "spring-boot-test", id = "someJob", cron = "* */2 * * * ?")
public class SomeJob implements SimpleJob {

    @Override
    public Executor executor() {
        return new Executor() {

            @Override
            public void execute() {
                System.out.println(this.getClass());
                System.out.println(Thread.currentThread() + " SimpleJob: " + UUID.randomUUID());
            }
        };
    }

}
