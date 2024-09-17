package com.example.day15template;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.clients.jedis.Jedis;

import java.util.Set;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class Day15TemplateApplicationTests {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Test
    void testRedis(){
//        Jedis jedis = new Jedis("192.168.227.128",6379);
//        jedis.auth("123456");
//        jedis.select(0);
//        jedis.hset("20501","username","xiaozhang");
//        System.out.println(jedis.hget("20501", "username"));
//        stringRedisTemplate.opsForValue().set("city","beijing");
//        stringRedisTemplate.opsForValue().set("code","1234",10l, TimeUnit.SECONDS);
//        jedis.set("username","xiaoming111");
//        System.out.println(jedis.get("username"));
//        jedis.del("username");
//        stringRedisTemplate.opsForHash().put("001","name","yangfan");
//        stringRedisTemplate.opsForHash().put("001","city","yichang");
//        stringRedisTemplate.opsForHash().put("001","age","18");
//        Set keys = stringRedisTemplate.opsForHash().keys("001");
//        for (Object key : keys) {
//            System.out.println(key);
//        }
//        System.out.println(stringRedisTemplate.opsForHash().get("001", "city"));
        SetOperations setOperations = stringRedisTemplate.opsForSet();
        setOperations.add("degree","1","2","3","1");
        Set<String> degreeSet = setOperations.members("degree");
        for (String s : degreeSet) {
            System.out.println(s);
        }


    }

}
