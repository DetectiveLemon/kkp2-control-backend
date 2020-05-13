package kkp2.controlbackend.Mapper;

import kkp2.controlbackend.Bean.Model;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ModelMapper {
    @Select("select * from model")
    List<Model> getAllModel();

    @Select("select * from model where model_status = 1")
    List<Model> getDisployModel();

    @Select("select * from model where model_status = 1")
    List<Model> getNotDisployModel();
    @Select("select * from model where model_id=#{id}")
    Model getModelDetail(int id);
}
