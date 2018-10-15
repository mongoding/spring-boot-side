package org.spring.springboot.base.collection;

import java.util.Map;
import java.util.Random;
import java.util.Iterator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Collection;

/*
 * @desc 遍历HashMap的测试程序。
 *   (01) 通过entrySet()去遍历key、value，参考实现函数：
 *        iteratorHashMapByEntryset()
 *   (02) 通过keySet()去遍历key、value，参考实现函数：
 *        iteratorHashMapByKeyset()
 *   (03) 通过values()去遍历value，参考实现函数：
 *        iteratorHashMapJustValues()
 *
 * @author skywang
 */
public class HashMapIteratorTest {

    public static void main(String[] args) {
        int val = 0;
        String key = null;
        Integer value = null;
        Random r = new Random();
        HashMap map = new HashMap();

        for (int i=0; i<12; i++) {
            // 随机获取一个[0,100)之间的数字
            val = r.nextInt(100);

            key = String.valueOf(val);
            value = r.nextInt(5);
            // 添加到HashMap中
            map.put(key, value);
            System.out.println(" key:"+key+" value:"+value);
        }
        // 通过entrySet()遍历HashMap的key-value
        iteratorHashMapByEntryset(map) ;

        // 通过keySet()遍历HashMap的key-value
        iteratorHashMapByKeyset(map) ;

        // 单单遍历HashMap的value
        iteratorHashMapJustValues(map);
    }

    /*
     * 通过entry set遍历HashMap
     * 效率高!
     */
    private static void iteratorHashMapByEntryset(HashMap map) {
        if (map == null)
            return ;

        System.out.println("\niterator HashMap By entryset");
        String key = null;
        Integer integ = null;
        Iterator iter = map.entrySet().iterator();
        while(iter.hasNext()) {
            Map.Entry entry = (Map.Entry)iter.next();

            key = (String)entry.getKey();
            integ = (Integer)entry.getValue();
            System.out.println(key+" -- "+integ.intValue());
        }
    }

    /*
     * 通过keyset来遍历HashMap
     * 效率低!
     */
    private static void iteratorHashMapByKeyset(HashMap map) {
        if (map == null)
            return ;

        System.out.println("\niterator HashMap By keyset");
        String key = null;
        Integer integ = null;
        Iterator iter = map.keySet().iterator();
        while (iter.hasNext()) {
            key = (String)iter.next();
            integ = (Integer)map.get(key);
            System.out.println(key+" -- "+integ.intValue());
        }
    }


    /*
     * 遍历HashMap的values
     */
    private static void iteratorHashMapJustValues(HashMap map) {
        if (map == null)
            return ;

        Collection c = map.values();
        Iterator iter= c.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
