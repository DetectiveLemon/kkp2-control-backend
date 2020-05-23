package kkp2.controlbackend.Controller;

import kkp2.controlbackend.Bean.Result;
import kkp2.controlbackend.Service.MongoDBService;
import kkp2.controlbackend.Util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/db")
public class MongoDBController {
    @Autowired
    MongoDBService mongoDBService;

    @PostMapping(value = "/status")
    public Result getDBStatus(){
        try {
            return ResultUtil.success(mongoDBService.getDBStatus());
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(-1, e.getMessage());
        }

    }

}
