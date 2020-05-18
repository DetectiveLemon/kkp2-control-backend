package kkp2.controlbackend.Service;

import kkp2.controlbackend.Bean.Request;
import kkp2.controlbackend.Mapper.RequestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class RequestServiceImpl implements  RequestService {
    @Autowired
    RequestMapper requestMapper;
    @Override
    public int adminpass(int request_id) {
        return requestMapper.adminpass(request_id);
    }

    @Override
    public Request getRequestInfoById(int request_id) {
        return requestMapper.getRequestInfoById(request_id);
    }
    @Override
    public int lcpass(int request_id) {
        return requestMapper.lcpass(request_id);
    }

    @Override
    public int adminreject(int request_id) {
        return requestMapper.adminreject(request_id);
    }

    @Override
    public int lcreject(int request_id) {
        return requestMapper.lcreject(request_id);
    }

    @Override
    public int usercancel(int request_id) {
        return requestMapper.usercancel(request_id);
    }

    @Override
    public int inserttask(int request_id, String name, String desc, int model_id, int total) {
        return requestMapper.inserttask(request_id, name, desc, model_id, total);
    }

    @Override
    public List<Request> getAllRequest() {
        return requestMapper.getAllRequest();
    }

    @Override
    public List<Request> getNeedByAdminRequest() {
        return requestMapper.getNeedByAdminRequest();
    }

    @Override
    public List<Request> getNeedByLcRequest() {
        return requestMapper.getNeedByLcRequest();
    }

    @Override
    public List<Request> getCanceledRequest() {
        return requestMapper.getCanceledRequest();
    }

    @Override
    public List<Request> getAllRejectRequest() {
        return requestMapper.getAllRejectRequest();
    }

    @Override
    public List<Request> getAdminRejectRequest() {
        return requestMapper.getAdminRejectRequest();
    }

    @Override
    public List<Request> getLcRejectRequest() {
        return requestMapper.getLcRejectRequest();
    }

    @Override
    public List<Request> findById(int request_id) {
        return requestMapper.findById(request_id);
    }

    @Override
    public List<Request> findByTime(Timestamp start, Timestamp end) {
        return requestMapper.findByTime(start,end);
    }

    @Override
    public List<Request> findByCompany(String company) {
        return requestMapper.findByCompany(company);
    }

    @Override
    public List<Request> findByIdAndTime(int request_id, Timestamp start, Timestamp end) {
        return requestMapper.findByIdAndTime(request_id,start,end);
    }

    @Override
    public List<Request> findByCompanyAndTime(String company, Timestamp start, Timestamp end) {
        return requestMapper.findByCompanyAndTime(company,start,end);
    }

    @Override
    public List<Request> findByIdAndCompany(int request_id, String company) {
        return requestMapper.findByIdAndCompany(request_id,company);
    }

    @Override
    public List<Request> findByIdAndCompanyAndTime(int request_id, String company, Timestamp start, Timestamp end) {
        return requestMapper.findByIdAndCompanyAndTime(request_id, company, start, end);
    }
}
