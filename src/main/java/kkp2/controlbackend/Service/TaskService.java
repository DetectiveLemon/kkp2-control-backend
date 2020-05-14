package kkp2.controlbackend.Service;

import kkp2.controlbackend.Bean.Calc;
import kkp2.controlbackend.Bean.Task;
import kkp2.controlbackend.Mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class TaskService {
    @Autowired
    TaskMapper taskMapper;

    private int size = 10;
    private List<Task> runningTasks;
    private List<Task> allTasks;
    private Random random = new Random();

    public Calc getCalcTask(){
        Calc r ;
        try {
            refresh();
            //无任务
            if (runningTasks==null||runningTasks.size()==0){
                r = new Calc();
                r.setCode(0);
                return r;
            }
            //随机选择一个任务
            Task task = runningTasks.get(random.nextInt(runningTasks.size()));
            r = new Calc();
            r.setCode(1);
            r.setMongo_url(task.getMongo_url());
            r.setSource_collection(task.getSource_collection());
            r.setResult_collection(task.getResult_collection());
            r.setModel_id(task.getModel_id());
            r.setDatabase_name(task.getDatabase_name());
            r.setStart(task.getCurrent());

            //判断边界
            //结束设置任务状态为2
            if (task.getCurrent()+size-1>=task.getTotal()){
                r.setEnd(task.getTotal());
                task.setCurrent(task.getTotal());
                task.setStatus(2);
            }

            else{
                r.setEnd(task.getCurrent()+size-1);
                task.setCurrent(task.getCurrent()+size);
            }
            //更新任务
            taskMapper.updateCurrent(task);
            taskMapper.updateStatus(task);
            refresh();

            return r;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void refresh(){
        runningTasks = taskMapper.getRunningTask();
        allTasks = taskMapper.getAllTask();
    }

}
