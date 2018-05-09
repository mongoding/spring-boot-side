package org.spring.springboot.task;

import com.google.common.collect.Lists;
import com.jiuxian.boot.mossrose.autoconfigure.Job;
import com.jiuxian.mossrose.job.StreamingJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Job(group = "spring-boot-test", id = "someStreamingJob", cron = "* */2 * * * ?")
public class SomeStreamingJob implements StreamingJob<String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(SomeStreamingJob.class);

    @Override
    public Streamer<String> streamer() {
        return new Streamer<String>() {

            private List<String> list = Lists.newArrayList("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday");

            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < list.size() - 1;
            }

            @Override
            public String next() {
                return list.get(index++);
            }
        };
    }

    @Override
    public Executor<String> executor() {
        return new Executor<String>() {

            @Override
            public void execute(String item) {
                LOGGER.info(Thread.currentThread() + " StreamingJob: " + item);
            }
        };
    }

}
