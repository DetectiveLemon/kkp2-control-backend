package kkp2.controlbackend.Service;

import kkp2.controlbackend.Bean.Model;
import kkp2.controlbackend.Bean.ModelDetail;

import java.util.List;

public interface ModelService {
    List<Model> getAllModel();
    List<Model> getDisployModel();
    List<Model> getUndisployModel();
    ModelDetail getModelDetail(int id);
}
