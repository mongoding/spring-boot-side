package org.spring.springboot.base.collection;

import java.util.Map;
import java.util.Random;
import java.util.Iterator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Collection;

/*
 * @desc HashMap测试程序
 *
 * @author skywang
 */
public class HashMapTest {

    public static void main(String[] args) {
        testHashMapAPIs();
    }

    private static void testHashMapAPIs() {
        // 初始化随机种子
        Random r = new Random();
        // 新建HashMap
        HashMap map = new HashMap();
        // 添加操作
        map.put("one", r.nextInt(10));
        map.put("two", r.nextInt(10));
        map.put("three", r.nextInt(10));

        // 打印出map
        System.out.println("map:"+map );

        // 通过Iterator遍历key-value
        Iterator iter = map.entrySet().iterator();
        while(iter.hasNext()) {
            Map.Entry entry = (Map.Entry)iter.next();
            System.out.println("next : "+ entry.getKey() +" - "+entry.getValue());
        }

        // HashMap的键值对个数
        System.out.println("size:"+map.size());

        // containsKey(Object key) :是否包含键key
        System.out.println("contains key two : "+map.containsKey("two"));
        System.out.println("contains key five : "+map.containsKey("five"));

        // containsValue(Object value) :是否包含值value
        System.out.println("contains value 0 : "+map.containsValue(new Integer(0)));

        // remove(Object key) ： 删除键key对应的键值对
        map.remove("three");

        System.out.println("map:"+map );

        // clear() ： 清空HashMap
        map.clear();

        // isEmpty() : HashMap是否为空
        System.out.println((map.isEmpty()?"map is empty":"map is not empty") );
    }
}
