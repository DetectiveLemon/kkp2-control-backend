package kkp2.controlbackend.Mapper;

import kkp2.controlbackend.Bean.Model;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ModelMapper {
    @Select("select * from model")
    Model getAllModel();

    @Select("select * from model where model_status = 1")
    Model getDisployModel();

    @Select("select * from model where model_status = 1")
    Model getNotDisployModel();
}
