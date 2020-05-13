package kkp2.controlbackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import kkp2.controlbackend.Bean.Result;
import kkp2.controlbackend.Bean.User;
import kkp2.controlbackend.Service.UserService;
import kkp2.controlbackend.Util.ResultUtil;
import kkp2.controlbackend.Util.TokenUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/login")
    public Result userLogin(@RequestParam String user_name, @RequestParam String password, HttpServletResponse response){
        try {
            User user = userService.checkLogin(user_name, password);
            if (user!=null){
                Cookie cookie = new Cookie("token", TokenUtil.getToken(user));
                cookie.setPath("/");
                response.addCookie(cookie);
                return ResultUtil.success(user);
            }
            else
                return ResultUtil.error(1000, "用户名或密码错误!");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(-1, e.getMessage());
        }
    }

    @PostMapping(value = "/logout")
    public Result userLogout(HttpServletResponse response){
        Cookie cookie = new Cookie("token", "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return ResultUtil.success(null);
    }

    @PostMapping(value = "/getall")
    public Result getAllUser(){
        return ResultUtil.success(userService.getAllUser());
    }
}
