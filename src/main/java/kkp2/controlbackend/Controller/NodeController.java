package kkp2.controlbackend.Controller;

import kkp2.controlbackend.Bean.Node;
import kkp2.controlbackend.Bean.Result;
import kkp2.controlbackend.Service.NodeService;
import kkp2.controlbackend.Util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/node")
public class NodeController {
    @Autowired
    NodeService nodeService;

    @PostMapping(value = "/getall")
    public Result getall(){
        try {
            return ResultUtil.success(nodeService.getAllNode());
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(-1, e.getMessage());
        }
    }

    @PostMapping(value = "/heartbeat")
    public Result heartbeat(@RequestBody Node node){
        try {
//            System.out.println(node.toString());
            return ResultUtil.success(nodeService.handleHeartBeat(node));
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.success(node.getNode_status());//发生异常不改变节点状态
        }

    }

    @PostMapping(value = "/operation")
    public Result operation(@RequestParam String uuid, @RequestParam int operation){
        try {
            nodeService.setOperation(uuid, operation);
            return ResultUtil.success(null);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(-1, e.getMessage());
        }
    }

}
