package com.example.day15template;

import com.example.day15template.utils.HttpUtils;
import org.apache.http.HttpResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

public class test {
    //以精品服务打造精品API产品。
//vip优惠券，技术支持。请直接联系客服（vx同号）  15622205140。
    @Test
    public void testRedis(){
        Jedis jedis = new Jedis("192.168.227.128",6379);
        jedis.auth("123456");
        jedis.select(0);
        jedis.hset("20501","username","xiaozhang");
        System.out.println(jedis.hget("20501", "username"));
//        jedis.set("username","xiaoming111");
//        System.out.println(jedis.get("username"));
//        jedis.del("username");


    }

//    public static void main(String[] args) {
//        String host = "https://dfsns.market.alicloudapi.com";
//        String path = "/data/send_sms";
//        String method = "POST";
//        String appcode = "de877cbf699e4d338b68dc853a752c5c";
//        Map<String, String> headers = new HashMap<String, String>();
//        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
//        headers.put("Authorization", "APPCODE " + appcode);
//        //根据API的要求，定义相对应的Content-Type
//        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
//        Map<String, String> querys = new HashMap<String, String>();
//        Map<String, String> bodys = new HashMap<String, String>();
//        bodys.put("content", "code:1234");
//        bodys.put("template_id", "CST_ptdie100");  //注意，CST_ptdie100该模板ID仅为调试使用，调试结果为"status": "OK" ，即表示接口调用成功，然后联系客服报备自己的专属签名模板ID，以保证短信稳定下发
//        bodys.put("phone_number", "19305696120");
//
//
//        try {
//            /**
//             * 重要提示如下:
//             * HttpUtils请从
//             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
//             * 下载
//             *
//             * 相应的依赖请参照
//             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
//             */
//            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
//            System.out.println(response.toString());
//            //获取response的body
//            //System.out.println(EntityUtils.toString(response.getEntity()));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

//需要赠送身份证OCR识别，vip优惠券,技术支持。请直接联系客服。
//商品说明可以在商品介绍里查看

/**
 *重要提示：
 *如您的返回结果中，没有我们接口的返回报文，或者连header的信息都打印出来了。可能是您的代码环境未能适配该请求示例。
 *那么，以下两个命令行，您可以二选一，选择一个适合你环境的加入到请求示例中。即可打印我们接口的返回报文。
 *或者直接联系客服  VX 15622205140
 *
 *System.out.println(EntityUtils.toString(response.getEntity()));
 *
 *System.out.println(response.body().string());
 */
}
