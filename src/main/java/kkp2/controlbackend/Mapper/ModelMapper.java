package kkp2.controlbackend.Mapper;

import kkp2.controlbackend.Bean.Log;
import kkp2.controlbackend.Bean.Model;
import kkp2.controlbackend.Bean.ModelDetail;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface ModelMapper {
    @Select("select * from model")
    List<Model> getAllModel();

    @Select("select * from model where model_status = 1")
    List<Model> getDisployModel();

    @Select("select * from model where model_status = 0")
    List<Model> getNotDisployModel();


    @Select("select * from model_detail where model_id=#{id}")
    ModelDetail getModelDetail(int id);
    @Select("select * from model ")
    List<Model> getModelCount();

    @Select("select * from log where model_id=#{id} and DATEDIFF(CURDATE(),model_use_date) < 8 order by model_use_date asc")
    List<Log> getlog(int id);

    @Select("select model_id from task where task_id = #{taskid} ")
    int getModelId(int taskid);

    @Select("select model_name from model where model_id = #{modelid} ")
    String getModelName(int modelid);

    @Insert("insert into log(model_id,model_name,model_use,model_use_date) values(#{modelid},#{modelname},#{num},now())")
    int addLog(int modelid,String modelname,int num);
}
