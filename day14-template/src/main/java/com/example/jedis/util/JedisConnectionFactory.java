package com.example.jedis.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisConnectionFactory {
    private static final JedisPool jedisPool;
    static {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(128);
        poolConfig.setMaxIdle(128);
        poolConfig.setMinIdle(16);
        poolConfig.setMaxWaitMillis(1000);
        jedisPool = new JedisPool(poolConfig,"192.168.227.128",6379,1000,"123456");
    }

    public static Jedis getJedis(){
        return jedisPool.getResource();
    }
}
