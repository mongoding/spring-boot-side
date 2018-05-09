package org.spring.springboot.task;

import com.google.common.base.Splitter;
import com.jiuxian.boot.mossrose.autoconfigure.Job;
import com.jiuxian.mossrose.job.DistributedJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Job(group = "spring-boot-test", id = "someDistributedJob", cron = "* */2 * * * ?")
public class SomeDistributedJob implements DistributedJob<String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(SomeDistributedJob.class);

    @Override
    public Slicer<String> slicer() {
        return new Slicer<String>() {

            @Override
            public List<String> slice() {
                return Splitter.on(" ").splitToList("This is a test on the mossrose distributed job, how are you feeling?");
            }
        };
    }

    @Override
    public com.jiuxian.mossrose.job.DistributedJob.Executor<String> executor() {
        return new Executor<String>() {

            @Override
            public void execute(String item) {
                LOGGER.info(Thread.currentThread() + " DistributedJob: " + item);
            }
        };
    }

}
