package com.example.controller;

import com.example.pojo.Result;
import com.example.pojo.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
public class RequestController {

//    @RequestMapping("/simpleParam")
//    public String simpleParam(HttpServletRequest request){
//        String name = request.getParameter("name");
//        String age = request.getParameter("age");
//        int ageInt = Integer.parseInt(age);
//        System.out.println(name + ":" + ageInt);
//        return "OKsdasdddasd";
//
//
//
//    }
//    @RequestMapping("/simpleParam")
//    public String simpleParam(String name, int age){
//        System.out.println(name + ":" + age);
//        return "OKsdasdddasd";
//    }
//    @RequestMapping("/simpleParam")
//    public String simpleParam(@RequestParam(name = "name", required = false) String username, int age){
//        System.out.println(username + ":" + age);
//        return "OKsdasdddasd";
//    }
//    @RequestMapping("/simpleParam")
//    public String simpleParam(User user){
//        System.out.println(user.getName() + ":" + user.getAge());
//        return "OKsdasdddasd";
//    }
//    @RequestMapping("/simpleParam")
//    public String simpleParam(User user){
//        System.out.println(user.getName() + "年龄" + user.getAge()+"是来自"+user.getAddress().getProvince()+user.getAddress().getCity());
//        return "OK";
//    }
//    @RequestMapping("/simpleParam")
//    public String simpleParam(String[] Hobby){
//        System.out.println(Arrays.toString(Hobby));
//        return "OK";
//    }
//    @RequestMapping("/simpleParam")
//    public String simpleParam(@RequestParam List<String> Hobby){
//        System.out.println(Hobby);
//        return "OK";
//    }
//    @RequestMapping("/simpleParam")
//    public String simpleParam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime updateTime){
//        System.out.println(updateTime);
//        return "OK";
//    }
//    @RequestMapping("/simpleParam")
//    public String simpleParam(@RequestBody User user){
//        System.out.println(user.getName() + "年龄" + user.getAge()+"是来自"+user.getAddress().getProvince()+user.getAddress().getCity());
//        return "OK";
//    }
//    @RequestMapping("/simpleParam/path/{id}")
//      public String getPath(@PathVariable Integer id){
//          System.out.println(id);
//          return "OK";
//      }
//    @RequestMapping("/simpleParam/{name}/{id}")
//    public String getPath(@PathVariable Integer id,@PathVariable String name){
//        System.out.println(id+name);
//        return "OK";
//    }
    @RequestMapping("/simpleParam/{id}")
    public Result getPath(@PathVariable Integer id){
        System.out.println(id);
        return Result.success(id);
    }
}
