package kkp2.controlbackend.Mapper;

import com.sun.tools.corba.se.idl.constExpr.Times;
import kkp2.controlbackend.Bean.Request;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface RequestMapper {

    @Update("update request set request_status = 1,admin_time=now() where request_id = #{request_id}")
    int adminpass(int request_id);

    @Update("update request set request_status = -1 where request_id = #{request_id}")
    int adminreject(int request_id);

    @Select("select * from request where request_id = #{request_id} ")
    Request getRequestInfoById(int request_id);

    @Update("update request set request_status = 2,gov_time = now() where request_id = #{request_id}")
    int lcpass(int request_id);

    @Update("update request set request_status = -2 where request_id = #{request_id}")
    int lcreject(int request_id);

    @Update("update request set request_status = -3 where request_id = #{request_id}")
    int usercancel(int request_id);

    @Select("select * from request")
    List<Request> getAllRequest();

    @Select("select * from request where request_status = 0")
    List<Request> getNeedByAdminRequest();

    @Select("select * from request where request_status = 1")
    List<Request> getNeedByLcRequest();

    @Select("select * from request where request_status = -3")
    List<Request> getCanceledRequest();

    @Select("select * from request where request_status = -1 or request_status = -2")
    List<Request> getAllRejectRequest();

    @Select("select * from request where request_status = -1")
    List<Request> getAdminRejectRequest();

    @Select("select * from request where request_status = -2")
    List<Request> getLcRejectRequest();

    @Select("select * from request where request_id = #{request_id} ")
    List<Request> findById(int request_id);

    @Select("select * from request where request_time >= #{start} and request_time<=#{end}")
    List<Request> findByTime(Timestamp start, Timestamp end);

    @Select("select * from request where request_company = #{company} ")
    List<Request> findByCompany(String company);

    @Select("select * from request where request_id = #{request_id} and request_time >= #{start} and request_time<=#{end}")
    List<Request> findByIdAndTime(int request_id, Timestamp start, Timestamp end);

    @Select("select * from request where request_company = #{company} and request_time >= #{start} and request_time<=#{end}")
    List<Request> findByCompanyAndTime(String company, Timestamp start, Timestamp end);

    @Select("select * from request where request_id = #{request_id} and request_company = #{company}")
    List<Request> findByIdAndCompany(int request_id, String company);

    @Select("select * from request where request_id = #{request_id} and request_company = #{company} and  request_time >= #{start} and request_time<=#{end}")
    List<Request> findByIdAndCompanyAndTime(int request_id,String company, Timestamp start, Timestamp end);
}
