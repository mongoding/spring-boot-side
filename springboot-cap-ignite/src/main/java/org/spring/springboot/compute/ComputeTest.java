package org.spring.springboot.compute;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.binary.BinaryObject;
import org.apache.ignite.cache.query.QueryCursor;
import org.apache.ignite.cache.query.ScanQuery;
import org.apache.ignite.lang.IgniteCallable;
import org.apache.ignite.lang.IgniteRunnable;
import org.apache.ignite.resources.IgniteInstanceResource;
import org.spring.springboot.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;

import javax.cache.Cache;
import java.util.ArrayList;
import java.util.Collection;

public class ComputeTest {

    @Autowired
    private Ignite ignite;

    public void firstCompute() {
        Collection<IgniteCallable<Integer>> calls = new ArrayList<>();
        // Iterate through all the words in the sentence and create Callable jobs.
        for (final String word : "Count characters using callable".split(" ")) {
            calls.add(word::length);
        }

        // Execute collection of Callables on the grid.
        Collection<Integer> res = ignite.compute().call(calls);
        // Add up all the results.
        int sum = res.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Total number of characters is '" + sum + "'.");
    }

    /**
     * 计算被发送到丹佛及其居民所在的节点，使得可以直接在数据所在的地方执行业务逻辑，避免了昂贵的序列化可网络开销
     */
    public void affinityCompute() {
        long cityId = 2; // Id for Denver
        // Sending the logic to a cluster node that stores Denver and its residents.
        ignite.compute().affinityRun("SQL_PUBLIC_CITY", cityId, new IgniteRunnable() {
            @IgniteInstanceResource
            Ignite ignite;

            @Override
            public void run() {
                // Getting an access to Persons cache.
                IgniteCache<BinaryObject, BinaryObject> people = ignite.cache(
                        "Person").withKeepBinary();
                ScanQuery<BinaryObject, BinaryObject> query =
                        new ScanQuery<BinaryObject, BinaryObject>();
                try (QueryCursor<Cache.Entry<BinaryObject, BinaryObject>> cursor =
                             people.query(query)) {
                    // Iteration over the local cluster node data using the scan query.
                    for (Cache.Entry<BinaryObject, BinaryObject> entry : cursor) {
                        BinaryObject personKey = entry.getKey();
                        // Picking Denver residents only only.
                        if (personKey.<Long>field("CITY_ID") == cityId) {
                            Person person = (Person) entry.getValue();
                            // Sending the warning message to the person.
                        }
                    }
                }
            }
        });
    }


}
