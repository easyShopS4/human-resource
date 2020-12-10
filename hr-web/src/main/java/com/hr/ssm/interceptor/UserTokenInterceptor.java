package com.hr.ssm.interceptor;

import com.auth0.jwt.interfaces.Claim;
import com.hr.api.util.JwtUtil;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 经过第一层拦截器后~
 * 此拦截器用来获取用户token~
 * @author echo lovely
 * @date 2020/12/9 20:56
 */

public class UserTokenInterceptor implements HandlerInterceptor
{

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception
    {

        if (handler instanceof HandlerMethod)
        {
            // 需要ajax提交localStorage 的token信息
            String jwtToken = request.getHeader("jwtToken");

            if (jwtToken != null) {
                Map<String, Claim> claimMap;

                claimMap = JwtUtil.verifyToken(jwtToken);
                // 用户id
                Integer uId = claimMap.get("uId").asInt();
                System.out.println("userTokenInterceptor================>" + uId);
                // 将用户id放进request域中
                request.setAttribute("uId", uId);

            }

        }

        return true;
    }

}
