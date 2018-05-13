package org.spring.springboot.cache;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.transactions.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.locks.Lock;

public class IgniteCacheTest {

    @Autowired
    private Ignite ignite;

    public void cacheTest1() {
        //Put和Get：
        IgniteCache<Integer, String> cache = ignite.getOrCreateCache("myCacheName");
        // Store keys in cache (values will end up on different cache nodes).
        for (int i = 0; i < 10; i++) {
            cache.put(i, Integer.toString(i));
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("Got [key=" + i + ", val=" + cache.get(i) + ']');
        }
        //原子化操作
        //Put-if-absent which returns previous value.
        IgniteCache<String, Integer> myAtomCache = ignite.getOrCreateCache("myAtom");
        Integer oldVal = myAtomCache.getAndPutIfAbsent("hello", 11);
        // Put-if-absent which returns boolean success flag.
        boolean success = myAtomCache.putIfAbsent("World", 22);
        // Replace-if-exists operation (opposite of getAndPutIfAbsent), returns previous value.
        oldVal = myAtomCache.getAndReplace("Hello", 11);
        // Replace-if-exists operation (opposite of putIfAbsent), returns boolean success flag.
        success = myAtomCache.replace("World", 22);
        // Replace-if-matches operation.
        success = myAtomCache.replace("World", 2, 22);
        // Remove-if-matches operation.
        success = myAtomCache.remove("Hello", 1);

        //事务

        try (Transaction tx = ignite.transactions().txStart()) {
            Integer hello = myAtomCache.get("Hello");
            if (hello == 1) {
                myAtomCache.put("Hello", 11);
            }
            myAtomCache.put("World", 22);
            tx.commit();
        }

        //分布式锁
        // Lock cache key "Hello".
        Lock lock = myAtomCache.lock("Hello");
        lock.lock();
        try {
            myAtomCache.put("Hello", 11);
            myAtomCache.put("World", 22);
        } finally {
            lock.unlock();
        }
    }
}
