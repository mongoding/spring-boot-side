package org.spring.springboot.base.juc;



import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeTest {

    public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);

        //Unsafe unsafe1 = Unsafe.getUnsafe();

        Integer[] a = new Integer[]{1,2,5,6};
        //int[]首个元素的偏移
        int arrayBaseOffset1 = unsafe.arrayBaseOffset(a.getClass());
        int arrayBaseOffset = unsafe.arrayBaseOffset(a.getClass());
        //数组中元素的增量偏移
        int arrayIndexScale = unsafe.arrayIndexScale(a.getClass());
        System.out.println(arrayBaseOffset);
        System.out.println(arrayIndexScale);
        //通过首地址的偏移+增量偏移，获取数组元素值
        System.out.println(unsafe.getObject(a, arrayBaseOffset));
        System.out.println(unsafe.getObject(a, arrayBaseOffset+arrayIndexScale));
        System.out.println(unsafe.getObject(a, arrayBaseOffset+arrayIndexScale*2));


    }
}
