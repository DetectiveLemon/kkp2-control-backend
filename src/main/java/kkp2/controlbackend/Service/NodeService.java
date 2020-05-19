package kkp2.controlbackend.Service;

import kkp2.controlbackend.Bean.Node;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NodeService {
    private Map<String, Node> nodeMap = new HashMap<>();
    private Map<String, Integer> operationMap = new HashMap<>();

    public int handleHeartBeat(Node node){
        int operation = node.getNode_status();
        Date date = new Date();
        if (nodeMap.get(node.getUuid())==null){//节点首次上线
            node.setOnline_time(date);
        }else {//非首次
            if(operationMap.get(node.getUuid())!=null){//需要对节点状态进行改变
                operation = operationMap.get(node.getUuid());
                operationMap.put(node.getUuid(), null);//从map中清除操作码
            }
            node.setOnline_time(nodeMap.get(node.getUuid()).getOnline_time());//保持上线时间不变
        }

        //设置心跳时间
        node.setValidate_time(date);
        //设置操作码
        node.setNode_status(operation);
        //放入Map中
        nodeMap.put(node.getUuid(), node);
        //返回操作码
        return operation;
    }

    public Integer setOperation(String uuid, int operation){
        operationMap.put(uuid, operation);
        return operation;
    }

    public List<Node> getAllNode(){
        validateAllNode();
        List<Node> list = new ArrayList<>();
        for (Map.Entry<String, Node> entry : nodeMap.entrySet()){
            list.add(entry.getValue());
        }
        return list;
    }

    public void validateAllNode(){
        for (Map.Entry<String, Node> entry : nodeMap.entrySet()){//遍历更新节点状态
            Date validate_time = entry.getValue().getValidate_time();
            long time = System.currentTimeMillis() - validate_time.getTime();
            if (time>(1000*60)){//1min未收到心跳包 则标记为离线
                Node node = entry.getValue();
                node.setNode_status(-2);
                entry.setValue(node);
            }

        }

    }

}
