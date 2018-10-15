package org.spring.springboot.base.io;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class FileTest {

    public static void main(String[] args) {
        testFileStaticFields() ;
        testFileDirAPIS() ;
    }

    public static void testFileStaticFields() {
        // 打印 路径分隔符":"
        System.out.printf("File.pathSeparator=\"%s\"\n", File.pathSeparator);
        // 打印 路径分隔符':'
        System.out.printf("File.pathSeparatorChar=\"%c\"\n", File.pathSeparatorChar);
        // 打印 分隔符"/"
        System.out.printf("File.separator=\"%s\"\n", File.separator);
        // 打印 分隔符'/'
        System.out.printf("File.separatorChar=\"%c\"\n", File.separatorChar);
    }

    public static void testFileDirAPIS() {
        try {
            // 新建目录 "dir"
            File dir = new File("dir");
            dir.mkdir();

            // 方法1：新建目录 "dir/sub1"。父目录“dir”必须已经存在！
            File sub1 = new File("dir", "sub1");
            sub1.mkdir();
            // 方法2：新建目录 "dir/sub2"。父目录“dir”必须已经存在！
            File sub2 = new File(dir, "sub2");
            sub2.mkdir();
            // 方法3：新建目录 "dir/sub3"。mkdirs()会自动创建不存在的父目录。
            File sub3 = new File("dir/sub3");
            sub3.mkdirs();
            // 方法4：新建目录 "dir/sub4"。根据“绝对路径”创建，前面3个方法都是根据“相对路径”创建。
            String dirPath = dir.getAbsolutePath();    // 获取“dir”的绝对路径
            String sub4AbsPath = dirPath + File.separator + "sub4";    // File.separator是分隔符"/"
            File sub4 = new File(sub4AbsPath);
            sub4.mkdirs();
            // 方法5：新建目录 "dir/sub5"。根据uri
            String uri_sub5_path = "file:"+ dirPath + File.separator + "sub5";
            URI uri_sub5 = new URI(uri_sub5_path);
            File sub5 = new File(uri_sub5);
            sub5.mkdirs();

            // 方法1：新建文件 "dir/l1_normal.txt"
            File l1_normal = new File(dir, "l1_normal.txt");
            l1_normal.createNewFile();
            // 方法2：新建文件 "dir/.l1_hide.txt"。
            File l1_hide = new File("dir", ".l1_hide.txt"); // 在linux中, "."开头的文件是隐藏文件。
            l1_hide.createNewFile();
            // 方法3：新建文件 "dir/l1_abs.txt"。
            String dirAbsPah =  dir.getAbsolutePath();    // 获取dir的绝对路径
            String l1_abs_path = dirAbsPah+File.separator+"l1_abs.txt";
            File l1_abs = new File(l1_abs_path);
            l1_abs.createNewFile();
            //System.out.printf("l1_abs_path=%s\n", l1_abs_path);
            //System.out.printf("l1_abs path=%s\n", l1_abs.getAbsolutePath());
            // 方法4：新建文件 "dir/l1_uri.txt"。根据URI新建文件
            String uri_path = "file:"+ dirAbsPah + File.separator + "l1_uri.txt";
            URI uri_l1 = new URI(uri_path);
            //System.out.printf("uri_l1=%s\n", l1_abs.getAbsolutePath());
            File l1_uri = new File(uri_l1);
            l1_uri.createNewFile();

            // 新建文件 "dir/sub/s1_normal"
            File s1_normal = new File(sub1, "s1_normal.txt");
            s1_normal.createNewFile();

            System.out.printf("%30s = %s\n", "s1_normal.exists()", s1_normal.exists());
            System.out.printf("%30s = %s\n", "s1_normal.getName()", s1_normal.getName());
            System.out.printf("%30s = %s\n", "s1_normal.getParent()", s1_normal.getParent());
            System.out.printf("%30s = %s\n", "s1_normal.getPath()", s1_normal.getPath());
            System.out.printf("%30s = %s\n", "s1_normal.getAbsolutePath()", s1_normal.getAbsolutePath());
            System.out.printf("%30s = %s\n", "s1_normal.getCanonicalPath()", s1_normal.getCanonicalPath());
            System.out.printf("%30s = %s is \"%s\"\n", "s1_normal.lastModified()", s1_normal.lastModified(), getModifyTime(s1_normal.lastModified()));
            System.out.printf("%30s = %s\n", "s1_normal.toURI()", s1_normal.toURI());


            // 列出“dir”目录下的“文件”和“文件夹”。
            // 注意：dir.listFiles()只会遍历目录dir，而不会遍历dir的子目录！
            System.out.println("---- list files and folders ----");
            File[] fs = dir.listFiles();
            for (File f:fs) {
                String fname = f.getName();
                String absStr = f.isAbsolute() ? "[Absolute]" : "";
                String hidStr = f.isHidden() ? "[Hidden]" : "";
                String dirStr = f.isDirectory() ? "[Directory]" : "";
                String fileStr = f.isFile() ? "[File]" : "";

                System.out.printf("%-30s  %s%s%s%s\n", fname, fileStr, dirStr, absStr, hidStr);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getModifyTime(long millis) {
        // 获取Calendar对象
        Calendar cal = Calendar.getInstance();
        // 设置时间为 millis
        cal.setTimeInMillis(millis);
        // 获取格式化对象，它会按照"yyyy-MM-dd HH:mm:ss"格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //System.out.printf("TIME %s\n", str);
        return sdf.format(cal.getTime());
    }

}