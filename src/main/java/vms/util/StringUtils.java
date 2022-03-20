package vms.util;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class StringUtils {

	/**
	 * 获取配置问题文件的value值
	 */
	public static String getPropertiesValue(String key, String pathName) {
		Properties props = new Properties();
	    // 使用ClassLoader加载properties配置文件生成对应的输入流
	    InputStream ins = StringUtils.class.getClassLoader().getResourceAsStream("config" + File.separator + pathName);
	    // 使用properties对象加载输入流
	    try {
			props.load(ins);
	    } catch (IOException e) {
            e.printStackTrace();
        }
	    // 获取key对应的value值
        return props.getProperty(key);
	}

	/**
	 * 獲取xml配置文件的數據
	 */
	public static String getXmlValue(String key, String pathName){

		ClassPathXmlApplicationContext ctx =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		String value = (String) ctx.getBean("user");
		return value;
	}
}
