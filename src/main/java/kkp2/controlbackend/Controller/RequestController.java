package kkp2.controlbackend.Controller;

import kkp2.controlbackend.Bean.Request;
import kkp2.controlbackend.Bean.User;
import kkp2.controlbackend.Service.RequestService;
import kkp2.controlbackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/request")
public class RequestController {
    @Autowired
    UserService userService;
    @Autowired
    RequestService requestService;
    @RequestMapping
    public void pass(@RequestParam int request_id, HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        int user_id = -3;
        Request req = requestService.getRequestInfoById(request_id);
        User user = userService.getUserById(1);
        if(user.getUser_type() == 0){
            requestService.adminpass(request_id);
        }

    }
}
