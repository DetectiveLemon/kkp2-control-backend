package kkp2.controlbackend.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import kkp2.controlbackend.Controller.TokenAuthInterceptor;

@Configuration
public class TokenInterceptorConf implements WebMvcConfigurer {
    //所有的WebMvcConfigurerAdapter组件都会一起起作用
    @Bean //将组件注册在容器中
    public WebMvcConfigurer webMvcConfigurerAdapter() {
        return new WebMvcConfigurer() {

            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //静态资源； *.css,*.js
                //SpringBoot已经做好了静态资源映射
                registry.addInterceptor(new TokenAuthInterceptor())
                        .addPathPatterns("/**")
                        .excludePathPatterns("/user/login");
//                        .excludePathPatterns("/index.html","/","/user/login","/static/**","/webjars/**");
                // /**  表示拦截所有路径下的所有请求
            }
        };
    }
}
