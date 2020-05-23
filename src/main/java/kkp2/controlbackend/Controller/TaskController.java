package kkp2.controlbackend.Controller;

import kkp2.controlbackend.Bean.Calc;
import kkp2.controlbackend.Bean.Result;
import kkp2.controlbackend.Service.TaskService;
import kkp2.controlbackend.Util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/task")
public class TaskController {
    @Autowired
    TaskService taskService;

    @PostMapping(value = "/getall")
    public Result getAllTask(){
        try {
            return ResultUtil.success(taskService.getAllTasks());
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(-1, e.getMessage());
        }

    }
    @PostMapping(value = "/getrunning")
    public Result getRunningTask(){
        try {
            return ResultUtil.success(taskService.getRunningTasks());
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(-1, e.getMessage());
        }

    }



    @PostMapping(value = "/getcalc")
    public Result getTask(){
        try {
            Calc r = taskService.getCalcTask();
            if (r==null){
                return ResultUtil.error(-1, "Error!");
            }
            return ResultUtil.success(r);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(-1, "Error!");
        }
    }

    @PostMapping("/pausetask")
    public Result pause(@RequestParam int taskid){
        try {
            int code = taskService.pause(taskid);
            if(code == -1) return ResultUtil.error(500,"任务不在进行中");
            return ResultUtil.success(code);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(-1, "Error!");
        }
    }


}
