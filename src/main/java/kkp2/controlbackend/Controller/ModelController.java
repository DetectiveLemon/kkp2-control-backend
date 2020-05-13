package kkp2.controlbackend.Controller;

import kkp2.controlbackend.Bean.ModelDetail;
import kkp2.controlbackend.Bean.Result;
import kkp2.controlbackend.Service.ModelServiceImpl;
import kkp2.controlbackend.Util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import kkp2.controlbackend.Bean.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/model")
public class ModelController {
    @Autowired
    private ModelServiceImpl modelServiceImpl;


    @PostMapping("/getallmodel")
    public Result getAllModel(){
        List<Model> res = new ArrayList<>();
        try {
           res.addAll(modelServiceImpl.getAllModel());
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(-1, e.getMessage());
        }
        return ResultUtil.success(res);
    }

    @PostMapping("/getdisploymodel")
    public Result getDesployModel(){
        List<Model> res = new ArrayList<>();
        try {
            res.addAll(modelServiceImpl.getDisployModel());
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(-1, e.getMessage());
        }
        return ResultUtil.success(res);
    }

    @PostMapping("/getundisploymodel")
    public Result getUndisployModel(){
        List<Model> res = new ArrayList<>();
        try {
            res.addAll(modelServiceImpl.getUndisployModel());
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(-1, e.getMessage());
        }
        return ResultUtil.success(res);
    }

    @PostMapping("/getmodeldetail")
    public Result getModelDetail(@RequestParam int id){
        ModelDetail res;
        try {
            res = modelServiceImpl.getModelDetail(id);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(-1, e.getMessage());
        }
        return ResultUtil.success(res);
    }
}
