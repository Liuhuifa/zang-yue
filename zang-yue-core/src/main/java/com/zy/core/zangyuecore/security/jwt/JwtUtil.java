package com.zy.core.zangyuecore.security.jwt;


import cn.hutool.core.lang.Assert;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lhf
 * @since 2020/06/06
 */
@Component
public class JwtUtil {


    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";

    public static final String SUBJECT = "congge";

    public static final long EXPIRITION = 60 * 60 * 1000;

    public static final String APPSECRET_KEY = "congge_secret";

    private static final String ROLE_CLAIMS = "rol";


    /**
     * 生成token
     *
     * @param user
     * @return
     */
    public static String generate(UserDetails user) {
        Assert.notNull(user, "参数异常");
        Map<String, Object> params = new HashMap<>();
        params.put("username", user.getUsername());
        params.put("user", user);
        return Jwts
                .builder()
                .setClaims(params)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRITION))
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, APPSECRET_KEY)
                .setSubject(SUBJECT)
                .compact();
    }

    /**
     * 生成token
     *
     * @param claims
     * @return
     */
    public static String generate(Claims claims) {

        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRITION))
                .signWith(SignatureAlgorithm.HS256, APPSECRET_KEY)
                .setSubject(SUBJECT)
                .compact();
    }

    /**
     * 获取文本
     *
     * @param token
     * @param params 要获取的字段
     * @return
     */
    public static Object getInfo(String token, String params) {
        return Jwts.parser()
                .setSigningKey(APPSECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .get(params).toString();
    }

    /**
     * 获取文本
     *
     * @param token
     * @return
     */
    public static String getUsernameFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(APPSECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .get("phone").toString();
    }

    /**
     * 是否过期
     *
     * @param token
     * @return
     */
    public static boolean isExpiration(String token) {
        return Jwts.parser()
                .setSigningKey(APPSECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getExpiration().after(new Date());
    }

    /**
     * 刷新超时时间
     *
     * @param token
     * @return
     */
    public static String refreshToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(APPSECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRITION));
        return generate(claims);
    }

    /**
     * 检验用户
     *
     * @param token
     * @param userDetails
     * @return
     * @throws Exception
     */
    public static Boolean validateToken(String token, UserDetails userDetails) throws Exception {
        String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()));
    }

    /**
     * 获取时间
     * <p>测试使用</p>
     *
     * @param token
     * @return
     */
    public static String getDate(String token) {
        return Jwts.parser()
                .setSigningKey(APPSECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getExpiration()
                .toString();
    }
}
