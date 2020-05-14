package kkp2.controlbackend.Service;

import kkp2.controlbackend.Bean.Request;
import kkp2.controlbackend.Mapper.RequestMapper;
import org.springframework.beans.factory.annotation.Autowired;

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
}
