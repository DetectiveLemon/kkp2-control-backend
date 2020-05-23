package kkp2.controlbackend.Service;

import kkp2.controlbackend.Bean.Log;
import kkp2.controlbackend.Bean.Model;
import kkp2.controlbackend.Bean.ModelDetail;

import java.util.List;
import java.util.Map;

public interface ModelService {
    List<Model> getAllModel();
    List<Model> getDisployModel();
    List<Model> getUndisployModel();
    ModelDetail getModelDetail(int id);
    List<Model> getModelCount();
    List<Log> getlog(int id);
    int addlog(int taskid,int num);
}
