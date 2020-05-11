package kkp2.controlbackend.Controller;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import kkp2.controlbackend.Util.TokenUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TokenAuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //不是映射到方法直接放行
        if (!(handler instanceof HandlerMethod))
            return true;

        Cookie[] cookies = request.getCookies();
        String token = null;
        //获取token
        if (cookies != null){
            for(Cookie cookie : cookies){
                if (cookie.getName().equals("token")){
                    token = cookie.getValue();
                }
            }
        }
        //验证token
        if (token != null && TokenUtil.veryify(token)){
            return true;
        }
        //跳转登录页面
        response.sendRedirect("https://www.baidu.com");
        return false;
    }
}
