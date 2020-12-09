package com.hr.ssm.interceptor;

import com.auth0.jwt.interfaces.Claim;
import com.hr.api.annotation.AuthCheck;
import com.hr.api.util.JwtUtil;
import com.hr.ssm.entity.Users;
import com.hr.ssm.mapper.UsersMapper;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
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

        // 设置自定义的header信息

        //支持全域名访问，不安全，部署后需要固定限制为客户端网址
        response.setHeader("Access-Control-Allow-Origin", "*");
        //支持的http 动作
        response.setHeader("Access-Control-Allow-Methods", "*"); // POST,GET,OPTIONS,DELETE
        //响应头 请按照自己需求添加。
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, jwtToken, abc");

        // 对方法进行拦截
        if (handler instanceof HandlerMethod) {
            // 方法对象
            HandlerMethod handlerMethod = (HandlerMethod) handler;

            Method methodTarget = handlerMethod.getMethod();

            // 对加了AuthTokenCheck注解 的方法进行token验证~
            boolean isTokenTarget = methodTarget.isAnnotationPresent(AuthCheck.class);

            if (isTokenTarget) {

                // 验证token
                String abc = request.getHeader("abc");
                String jwtToken = request.getHeader("jwtToken");

                System.out.println(request.getAttribute("name"));

                System.out.println(abc + "\t" + jwtToken);

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
                    response.setContentType("text/json;charset=utf-8");
                    response.getWriter().write("bad");
                    return false;
                }

            }

        }


        return true;
    }

    // 用来验证jwtToken是否过期, 过期了生产token
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        if (handler instanceof HandlerMethod) {

            // 方法对象
            HandlerMethod handlerMethod = (HandlerMethod) handler;

            Method methodTarget = handlerMethod.getMethod();

            boolean isTokenTarget = methodTarget.isAnnotationPresent(AuthCheck.class);

            if (isTokenTarget) {

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


    }


}
