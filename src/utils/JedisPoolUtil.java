package utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JedisPoolUtil {

    private static JedisPool jedisPool ;
    //初始化这个类就加载这个代码块
    static {
        //读取配置文件
        InputStream inputStream = JedisPoolUtil.class.getClassLoader().getResourceAsStream("jedis.properties");
        //创建Properties 对象
        Properties properties = new Properties();
        //关联文件
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取数据，设置到JedisPoolConfig中
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(Integer.parseInt(properties.getProperty("maxTotal")));
       //初始化JedisPool
       jedisPool = new JedisPool(config,properties.getProperty("host"), Integer.parseInt(properties.getProperty("port"))) ;

    }

    //获取连接的方法
    public static Jedis getJedisPool(){
        return jedisPool.getResource();
    }

}
