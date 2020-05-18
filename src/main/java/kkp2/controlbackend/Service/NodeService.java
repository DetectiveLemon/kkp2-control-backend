package kkp2.controlbackend.Service;

import kkp2.controlbackend.Bean.Node;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NodeService {
    private Map<String, Node> nodeMap = new HashMap<>();
    private Map<String, Integer> operationMap = new HashMap<>();

    public int handleHeartBeat(Node node){
        //取操作码 如果没有表示 节点第一次请求 则不改变节点状态
//        int operation = operationMap.getOrDefault(node.getUuid(), node.getNode_status());
        int operation;
        Date date = new Date();
        if (operationMap.get(node.getUuid())==null){
            node.setOnline_time(date);
            operation = node.getNode_status();
        }
        else {
            operation = operationMap.get(node.getUuid());
            node.setOnline_time(nodeMap.get(node.getUuid()).getOnline_time());//保持上线时间不变
        }
        //设置心跳时间
        node.setValidate_time(date);
        //设置操作码
        node.setNode_status(operation);
        //放入两个Map中
        nodeMap.put(node.getUuid(), node);
        operationMap.put(node.getUuid(), operation);
        //返回操作码
        return operation;
    }

    public Integer setOperation(String uuid, int operation){
        if (operationMap.get(uuid)==null)
            return null;
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
