package kkp2.controlbackend.Controller;

import kkp2.controlbackend.Bean.Request;
import kkp2.controlbackend.Bean.Result;
import kkp2.controlbackend.Bean.User;
import kkp2.controlbackend.Service.RequestService;
import kkp2.controlbackend.Service.UserService;
import kkp2.controlbackend.Util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping(value = "/request",produces = { "application/json;charset=UTF-8"})
public class RequestController {
    @Autowired
    UserService userService;

    @Autowired
    RequestService requestService;


    @PostMapping(value = "/pass")
    public Result pass(@RequestParam int request_id,HttpServletRequest request) {
        try {
            Request req = requestService.getRequestInfoById(request_id);
            User user = userService.getUserByToken(request);
            if (user.getUser_type() == 0 && req.getRequest_status() == 0) {
                requestService.adminpass(request_id);
            } else if(user.getUser_type() == 1 && req.getRequest_status() == 1){
                requestService.lcpass(request_id);
                System.out.println(req.getRequest_id());
                System.out.println(req.getRequest_Model());
                System.out.println(req.getRequest_data());
                requestService.inserttask(req.getRequest_id(),req.getRequest_Model(),req.getRequest_data());
            }
            else if (user.getUser_type() == 0 && req.getRequest_status() == 1) {
                return ResultUtil.error(500, "政府已通过");
            } else if(req.getRequest_status() == 2){
                return ResultUtil.error(500, "请求已通过");
            } else {
                return ResultUtil.error(500, "等待政府通过");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(-1, e.getMessage());
        }
        return ResultUtil.success(null);
    }

    @PostMapping("/reject")
    public Result reject(@RequestParam int request_id, HttpServletRequest request){
        try {
            Request req = requestService.getRequestInfoById(request_id);
            User user = userService.getUserByToken(request);
            if (user.getUser_type() == 0 && req.getRequest_status() == 0) {
                requestService.adminreject(request_id);
            } else if (user.getUser_type() == 1 && req.getRequest_status() == 1) {
                requestService.lcreject(request_id);
            } else if (user.getUser_type() == 0 && req.getRequest_status() == 1) {
                return ResultUtil.error(500, "政府已通过");
            } else if(user.getUser_type() == 1 && req.getRequest_status() == 0){
                return ResultUtil.error(500, "等待政府通过");
            } else if(req.getRequest_status() == 2){
                return ResultUtil.error(500, "请求已通过");
            }
            else{
                return ResultUtil.error(500,"用户已取消");
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(-1, e.getMessage());
        }
        return ResultUtil.success(null);
    }


    @PostMapping("/cancel")
    public Result cancel(@RequestParam int request_id, HttpServletRequest request){
        Request req = requestService.getRequestInfoById(request_id);
        User user = userService.getUserByToken(request);
        try {
            if (user.getUser_type() == 2 && (req.getRequest_status() == 0 || req.getRequest_status() == 1)) {
                requestService.usercancel(request_id);
            } else{
                return ResultUtil.error(-1,"请求已通过");
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(-1, e.getMessage());
        }
        return ResultUtil.success(req);
    }


    @PostMapping("/getallrequest")
    public Result getallrequest(){
        return ResultUtil.success(requestService.getAllRequest());
    }
    @PostMapping("/getrequest")
    public Result getrequest(){
        return ResultUtil.success(requestService.getAdminRejectRequest());
    }

    @PostMapping("/getallrejectrequest")
    public Result getallrejectrequest(){
        return ResultUtil.success(requestService.getAllRejectRequest());
    }
    @PostMapping("/getcencelrequest")
    public Result getcencelrequest(){
        return ResultUtil.success(requestService.getCanceledRequest());
    }
    @PostMapping("/getlcrequest")
    public Result getlcrequest(){
        return ResultUtil.success(requestService.getNeedByLcRequest());
    }
    @PostMapping("/getadminrequest")
    public Result getadminrequest(){
        return ResultUtil.success(requestService.getNeedByAdminRequest());
    }
    @PostMapping("/getlcrejectrequest")
    public Result getlcrejectrequest(){
        return ResultUtil.success(requestService.getLcRejectRequest());
    }
    @PostMapping("/findbyid")
    Result findById(int request_id){
        return ResultUtil.success(requestService.findById(request_id));
    }
    @PostMapping("/findbytime")
    Result findByTime(Timestamp start, Timestamp end){
        return ResultUtil.success(requestService.findByTime(start, end));
    }
    @PostMapping("/findbycompany")
    Result findByCompany(String company){
        return ResultUtil.success(requestService.findByCompany(company));
    }
    @PostMapping("/findbyidandtime")
    Result findByIdAndTime(int request_id, Timestamp start, Timestamp end){
        return ResultUtil.success(requestService.findByIdAndTime(request_id, start, end));

    }
    @PostMapping("/findbycompanyandtime")
    Result findByCompanyAndTime(String company, Timestamp start, Timestamp end){
        return ResultUtil.success(requestService.findByCompanyAndTime(company, start, end));
    }
    @PostMapping("/findbyidandcompany")
    Result findByIdAndCompany(int request_id, String company){
        return ResultUtil.success(requestService.findByIdAndCompany(request_id, company));
    }
    @PostMapping("/findbyidandcompanyandtime")
    Result findByIdAndCompanyAndTime(int request_id,String company, Timestamp start, Timestamp end){
        return ResultUtil.success(requestService.findByIdAndCompanyAndTime(request_id, company, start, end));
    }


}
