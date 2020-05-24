package kkp2.controlbackend.Mapper;

import kkp2.controlbackend.Bean.Task;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface TaskMapper {
    @Select("select * from task")
    List<Task> getAllTask();

    @Select("select * from task where status = 1")
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
