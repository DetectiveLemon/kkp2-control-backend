package kkp2.controlbackend.Service;

import kkp2.controlbackend.Bean.User;

import java.util.List;

public interface UserService {
    User checkLogin(String user_name, String password);

    List<User> getAllUser();

}
