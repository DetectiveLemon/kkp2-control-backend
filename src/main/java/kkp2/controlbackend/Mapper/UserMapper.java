package kkp2.controlbackend.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import kkp2.controlbackend.Bean.User;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT user_id,user_name,password,user_type,staff_id,staff_name\n" +
            "FROM user\n" +
            "WHERE user_id=#{user_id}")
    User getUserById(int user_id);

    @Select("SELECT user_id,user_name,password,user_type,staff_id,staff_name\n" +
            "FROM user\n" +
            "WHERE user_name=#{user_name}")
    User getUserByName(String user_name);

    @Select("SELECT user_id,user_name,password,user_type,staff_id,staff_name\n" +
            "FROM user")
    List<User> getAllUser();

}
