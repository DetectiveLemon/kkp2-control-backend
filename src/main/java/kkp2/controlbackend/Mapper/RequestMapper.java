package kkp2.controlbackend.Mapper;

import kkp2.controlbackend.Bean.Request;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface RequestMapper {

    @Update("update request set request_status = 1 where request_id = #{id}")
    int adminpass(int request_id);


    @Select("select * from request where request_id = #{request_id} ")
    Request getRequestInfoById(int request_id);
}
