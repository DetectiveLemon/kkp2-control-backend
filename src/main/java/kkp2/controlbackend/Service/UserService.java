package kkp2.controlbackend.Service;

import kkp2.controlbackend.Bean.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {
    User checkLogin(String user_name, String password);

    List<User> getAllUser();

    User getUserByToken(HttpServletRequest request);
}
