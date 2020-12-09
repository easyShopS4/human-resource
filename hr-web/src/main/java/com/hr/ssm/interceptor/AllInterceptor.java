package com.hr.ssm.interceptor;

import com.auth0.jwt.interfaces.Claim;
import com.hr.api.util.JwtUtil;
import com.hr.ssm.entity.Users;
import com.hr.ssm.mapper.UsersMapper;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

/**
 * 全局拦截器，用于jwt认证~
 * @author echo lovely
 * @date 2020/12/8 12:00
 */

public class AllInterceptor implements HandlerInterceptor {

    @Resource
    private UsersMapper usersMapper;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        // 验证token
        String abc = request.getHeader("abc");
        String jwtToken = request.getHeader("jwtToken");

        Map<String, Claim> claimMap;
        try {
            claimMap = JwtUtil.verifyToken(jwtToken);

            // 用户真实姓名~
            String uTrueName = claimMap.get("uTrueName").asString();
            request.setAttribute("uTrueName", uTrueName);
            // 用户id
            Integer uId = claimMap.get("uId").asInt();
            request.setAttribute("uId", uId);

        } catch (RuntimeException e) {

            e.printStackTrace();
            // token无效，不放行~
            return false;
        }

        return true;
    }

    // 用来验证jwtToken是否过期, 过期了生产token
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {


        String jwtToken = request.getHeader("jwtToken");

        // token 快过期~
        Map<String, Claim> res = JwtUtil.verifyToken(jwtToken);
        System.out.println(res);

        // 过期时间
        Date expireDate = res.get("exp").asDate();

        long l1 = expireDate.getTime();
        // 离过期时间还有5分钟的时候 生成token
        if (l1 - System.currentTimeMillis() < 1000 * 60 * 5) {

            // 重新生成token
            Integer uId = (Integer) request.getAttribute("uId");// 上面的id

            Users user = usersMapper.selectById(uId);
            user.setUPassword(null);
            user.setUSalt(null);
            // create~
            jwtToken = JwtUtil.createToken(user);

            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(jwtToken);
        }


    }
}
