package org.spring.springboot.base.io;

/**
 * ObjectInputStream 和 ObjectOutputStream 测试程序
 *
 * 注意：通过ObjectInputStream, ObjectOutputStream操作的对象，必须是实现了Serializable或Externalizable序列化接口的类的实例。
 *
 * @author skywang
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

public class ObjectStreamTest {
    private static final String TMP_FILE = "box.tmp";

    public static void main(String[] args) {
        testWrite();
        testRead();
    }


    /**
     * ObjectOutputStream 测试函数
     */
    private static void testWrite() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(TMP_FILE));
            out.writeBoolean(true);
            out.writeByte((byte)65);
            out.writeChar('a');
            out.writeInt(20131015);
            out.writeFloat(3.14F);
            out.writeDouble(1.414D);
            // 写入HashMap对象
            HashMap map = new HashMap();
            map.put("one", "red");
            map.put("two", "green");
            map.put("three", "blue");
            out.writeObject(map);
            // 写入自定义的Box对象，Box实现了Serializable接口
            Box box = new Box("desk", 80, 48);
            out.writeObject(box);

            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * ObjectInputStream 测试函数
     */
    private static void testRead() {
        try {
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(TMP_FILE));
            System.out.printf("boolean:%b\n" , in.readBoolean());
            System.out.printf("byte:%d\n" , (in.readByte()&0xff));
            System.out.printf("char:%c\n" , in.readChar());
            System.out.printf("int:%d\n" , in.readInt());
            System.out.printf("float:%f\n" , in.readFloat());
            System.out.printf("double:%f\n" , in.readDouble());
            // 读取HashMap对象
            HashMap map = (HashMap) in.readObject();
            Iterator iter = map.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry)iter.next();
                System.out.printf("%-6s -- %s\n" , entry.getKey(), entry.getValue());
            }
            // 读取Box对象，Box实现了Serializable接口
            Box box = (Box) in.readObject();
            System.out.println("box: " + box);

            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


class Box implements Serializable {
    private int width;
    private int height;
    private String name;

    public Box(String name, int width, int height) {
        this.name = name;
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return "["+name+": ("+width+", "+height+") ]";
    }
}