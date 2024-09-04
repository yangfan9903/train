package com.example;

import com.example.jedis.util.JedisConnectionFactory;
import com.example.pojo.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class JedisTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
//    private Jedis jedis;
//    @BeforeEach
//    void setUp(){
//        // 建立连接
//        System.out.println("建立连接");
//        jedis = JedisConnectionFactory.getJedis();
////        jedis = new Jedis("192.168.227.128",6379);
//        System.out.println("创建对象");
//        jedis.auth("123456");
//        jedis.select(0);
//    }
//
//    @Test
//    void testString(){
//        String result = jedis.set("name","zhangsan");
//        System.out.println("result=" + result);
//        String name = jedis.get("name");
//        System.out.println("name=" + name);
//    }
//    @Test
//    void testHash(){
//        jedis.hset("heima:user:1", "name","jack");
//        jedis.hset("heima:user:1","age","1");
//        Map<String,String> map = jedis.hgetAll("heima:user:1");
//        System.out.println(map);
//        String name1 = jedis.hget("heima:user:1","name");
////        System.out.println("得到的名字是" + name1);
//    }
//
//    @AfterEach
//    void tearDown() {
//        if (jedis != null){
//            jedis.close();
//        }
//    }

//    @Autowired
//    private RedisTemplate redisTemplate;
//
//    @Test
//    void testString(){
//        redisTemplate.opsForValue().set("name","zhangsan");
//        System.out.println(redisTemplate.opsForValue().get("name"));
//    }
    @Test
    void testString(){
        stringRedisTemplate.opsForValue().set("name","虎哥");
        Object name = stringRedisTemplate.opsForValue().get("name");
        System.out.println("name=" + name);
    }
    private static final ObjectMapper mapper = new ObjectMapper();
    @Test
    void testSaveUser() throws JsonProcessingException {
        // 创建对象
        User user = new User("胡歌",21);
        // 手动序列化
        String json = mapper.writeValueAsString(user);
        // 写入数据
        stringRedisTemplate.opsForValue().set("user:100",json);
        // 获取数据
        String jsonUser = stringRedisTemplate.opsForValue().get("user:100");
        // 手动反序列化
        User user1 = mapper.readValue(jsonUser,User.class);
        System.out.println("user1 =" + user1 );

    }

    @Test
    void testSaveHash(){
        stringRedisTemplate.opsForHash().put("user:200","name","yangfan");
        String readHash = (String) stringRedisTemplate.opsForHash().get("user:200","name");
        System.out.println(readHash);
    }

}
