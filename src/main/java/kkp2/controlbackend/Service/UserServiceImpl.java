package kkp2.controlbackend.Service;

import kkp2.controlbackend.Util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kkp2.controlbackend.Bean.User;
import kkp2.controlbackend.Mapper.UserMapper;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public User checkLogin(String user_name, String password) {
        User user = userMapper.getUserByName(user_name);
        if (user!=null){
            System.out.println("UserServiceImpl:" + " checkLogin:"+" user_name:"+user_name+" password:"+password+" user:"+user.toString());
            if (password.equals(user.getPassword()))
                return user;
        }
        return null;
    }

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public User getUserByToken(HttpServletRequest request) {
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
        return userMapper.getUserById(TokenUtil.getUser_Id(token));
    }
}
