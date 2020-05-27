package kkp2.controlbackend.Mapper;

import kkp2.controlbackend.Bean.Task;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface TaskMapper {
    @Select("select task.*,request_company,request_time from task,request where task.request_id = request.request_id")
    List<Task> getAllTask();

    @Select("select task.*,request_company,request_time from task,request where task.request_id = request.request_id and task.status = 1")
    List<Task> getRunningTask();

    @Update("update task set current = #{current} where task_id = #{task_id}")
    int updateCurrent(Task task);

    @Update("update task set status = #{status} where task_id = #{task_id}")
    int updateStatus(Task task);

    @Update("update task set status = 0 where task_id = #{task_id}")
    int pause(int taskid);

    @Update("update task set status = 1 where task_id = #{task_id}")
    int start(int taskid);


    @Select("select status from task where task_id=#{taskid}")
    int getstatue(int taskid);


}
