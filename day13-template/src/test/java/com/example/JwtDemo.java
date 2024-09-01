package com.example;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class JwtDemo {
    @Test
    public void testGenJwt(){
        Map<String,Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("name","Tom");
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "itheima")
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))
                .compact();
        System.out.println(jwt);

    }

    @Test
    public void parserJwt(){
        Claims claims = Jwts.parser()
                .setSigningKey("itheima")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiVG9tIiwiaWQiOjEsImV4cCI6MTcyNTExMTkzNn0.PFZOaZWNgZ902xzox05Zwu33m-T2QYtTvBssD0bip_0")
                .getBody();
        System.out.println(claims);
    }
}
