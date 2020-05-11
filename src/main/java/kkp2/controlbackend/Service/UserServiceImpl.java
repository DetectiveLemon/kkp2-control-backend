package kkp2.controlbackend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kkp2.controlbackend.Bean.User;
import kkp2.controlbackend.Mapper.UserMapper;

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
}
