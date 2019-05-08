package utils;

import redis.clients.jedis.Jedis;

import java.io.IOException;


public class TestUtils {



    public static void main(String args[]) throws IOException {
        //获取连接
        Jedis jedis =  JedisPoolUtil.getJedisPool();
        //操作
        jedis.set("username","zhangsna");
        //关闭连接
        jedis.close();




    }



}
