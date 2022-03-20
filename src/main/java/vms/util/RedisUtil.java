package vms.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import freemarker.template.utility.StringUtil;
import redis.clients.jedis.*;

/**
 * 操作redis缓存的工具类
 *
 */
public final class RedisUtil {
    public RedisUtil() {
    }

    private static ShardedJedisPool pool;
    private static String host;// 地址
    private static Integer port;// 端口
    private static String password;// 授权密码
    private static Integer timeout;// 超时时间：单位ms
    private static Integer maxIdle;// 最大空闲数：空闲链接数大于maxIdle时,将进行回收
    private static Integer maxActive;// 最大连接数：能够同时建立的"最大链接个数"
    private static Long maxWait;// 最大等待时间：单位ms
    private static Boolean testOnBorrow;// 在获取连接时，是否验证有效性

    // 静态代码块
    static {
        // 加载properties配置文件
        Properties properties = new Properties();
        InputStream is = RedisUtil.class.getClassLoader().getResourceAsStream(
                "config" + File.separator + "redis.properties");
        try {
            properties.load(is);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        timeout = Integer.parseInt(properties.getProperty("redis.timeout"));
        maxIdle = Integer.parseInt(properties.getProperty("redis.maxIdle"));
        maxActive = Integer.parseInt(properties.getProperty("redis.maxActive"));
        maxWait = Long.parseLong(properties.getProperty("redis.maxWait"));
        testOnBorrow = Boolean.parseBoolean(properties.getProperty("redis.testOnBorrow"));
        host = properties.getProperty("redis.host");
        port = Integer.parseInt(properties.getProperty("redis.port"));
        password = properties.getProperty("redis.password");

        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(maxActive);
        config.setMaxIdle(maxIdle);
        config.setMaxWaitMillis(maxWait);
        config.setTestOnBorrow(testOnBorrow);
        // 集群
        JedisShardInfo jedisShardInfo = new JedisShardInfo(host, port, timeout);
        jedisShardInfo.setPassword(password);
        List<JedisShardInfo> list = new LinkedList<JedisShardInfo>();
        list.add(jedisShardInfo);
        pool = new ShardedJedisPool(config, list);
    }

    public ShardedJedis getPool(){
        return pool.getResource();
    }
    public static void main(String[] args) {
        ShardedJedis jedis = pool.getResource();
         // String value = jedis.set("13231781682", "2234", "NX", "EX", 20);
        // System.out.println(value);

        System.out.println(jedis.get("13231781682"));
    }
}

