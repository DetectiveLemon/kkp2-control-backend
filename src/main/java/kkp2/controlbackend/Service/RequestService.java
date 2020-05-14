package kkp2.controlbackend.Service;

import kkp2.controlbackend.Bean.Request;
import org.springframework.stereotype.Service;

@Service
public interface RequestService {
    int adminpass(int request_id);
    Request getRequestInfoById(int request_id);
}
