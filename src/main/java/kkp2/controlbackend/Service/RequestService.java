package kkp2.controlbackend.Service;

import kkp2.controlbackend.Bean.Request;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

public interface RequestService {
    int adminpass(int request_id);
    int adminreject(int request_id);
    Request getRequestInfoById(int request_id);
    int lcpass(int request_id);
    int lcreject(int request_id);
    int usercancel(int request_id);
    int inserttask(int request_id,int model_id,int total);
    List<Request> getAllRequest();
    List<Request> getNeedByAdminRequest();
    List<Request> getNeedByLcRequest();
    List<Request> getCanceledRequest();
    List<Request> getAllRejectRequest();
    List<Request> getAdminRejectRequest();
    List<Request> getLcRejectRequest();
    List<Request> findById(int request_id);
    List<Request> findByTime(Timestamp start, Timestamp end);
    List<Request> findByCompany(String company);
    List<Request> findByIdAndTime(int request_id, Timestamp start, Timestamp end);
    List<Request> findByCompanyAndTime(String company, Timestamp start, Timestamp end);
    List<Request> findByIdAndCompany(int request_id, String company);
    List<Request> findByIdAndCompanyAndTime(int request_id,String company, Timestamp start, Timestamp end);
}
