package com.hr.api.util;

/**
 * @author echo lovely
 * @date 2020/12/7 15:32
 */
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.hr.ssm.entity.Users;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * @author echo lovely
 * @date 2020/12/4 21:46
 */

public class JwtUtil {

    //密钥（不能泄露 、可多次加盐加密再存在合适的地方）
    public static final String SECRET = "defAu&TJHVhc$%WW^JJG";
    //过期时间:秒 5min
    public static final int EXPIRE = 1800;

    /**
     * JWT 添加至HTTP HEAD中的前缀
     */
    private static final String JWT_SEPARATOR = "Bearer ";

    /**
     * 生成Token
     * @param  user user
     * @return token token
     * @throws Exception create token ex
     */
    public static String createToken(Users user) throws Exception {

        try {
            //日历对象
            //当前时间
            Calendar nowTime = Calendar.getInstance();
            //加30秒
            nowTime.add(Calendar.SECOND, EXPIRE);
            Date expireDate = nowTime.getTime();

            //标头 可以不写，默认值就是下方所定义的map
            Map<String, Object> map = new HashMap<>();
            // 算法
            map.put("alg", "HS256");
            // 类型 jwt加密
            map.put("typ", "JWT");

            return  JWT.create()
                    .withHeader(map)//头 有默认值 可以不写

                    //负载 业务数据
                    .withClaim("uName", user.getUName())
                    .withClaim("uId", user.getUId())
                    .withClaim("uTrueName", user.getUTrueName())
                    .withSubject("subject")//可以不写
                    .withIssuedAt(new Date())//签名时间
                    .withExpiresAt(expireDate)//过期时间
                    .sign(Algorithm.HMAC256(SECRET));//签名
        } catch (Exception e) {
            throw new Exception(e);
        }

    }

    /**
     * 验证Token
     * @param token token
     * @return token map
     * @throws RuntimeException 凭证已过期，请重新登录
     */
    public static Map<String, Claim> verifyToken(String token) throws RuntimeException {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
        DecodedJWT jwt;
        try {
            jwt = verifier.verify(token);
        }catch (Exception e){
            throw new RuntimeException("凭证已过期，请重新登录");
        }
        return jwt.getClaims();
    }

    /**
     * 解析Token
     * @param token token
     * @return claim
     */
    public static Map<String, Claim> parseToken(String token){
        DecodedJWT decodedJWT = JWT.decode(token);
        return decodedJWT.getClaims();
    }

}


