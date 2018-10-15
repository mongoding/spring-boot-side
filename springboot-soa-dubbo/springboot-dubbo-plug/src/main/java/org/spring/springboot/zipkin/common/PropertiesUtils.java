
package org.spring.springboot.zipkin.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * 加载配置文件.
 */
public class PropertiesUtils {

    private static Properties props = new Properties();

    /**
     * 默认查找
     */
    static {
        try {
            InputStream confStream = PropertiesUtils.class.getClassLoader()
                    .getResourceAsStream("config.properties");
            InputStream appStream = PropertiesUtils.class.getClassLoader()
                    .getResourceAsStream("application.properties");
            if (confStream != null) {
                props.load(confStream);
            }
            if (appStream != null) {
                props.load(appStream);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 手动添加路径加载Properties文件
     *
     * @param confName 文件名称
     */
    public static void initProper(String confName) {
        InputStream defStream = PropertiesUtils.class.getClassLoader()
                .getResourceAsStream(confName);
        if (defStream != null) {
            try {
                props.load(defStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static String getProperty(String key) {
        String code = "";
        try {
            code = props.getProperty(key);
            if (code != null && code.trim().length() > 0) {
                code = new String(code.getBytes("ISO-8859-1"), "utf-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return code;
    }


}
