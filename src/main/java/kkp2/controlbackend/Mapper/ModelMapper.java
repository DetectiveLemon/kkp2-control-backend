package kkp2.controlbackend.Mapper;

import kkp2.controlbackend.Bean.Model;
import kkp2.controlbackend.Bean.ModelDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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
}
