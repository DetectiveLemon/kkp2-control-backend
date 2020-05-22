package kkp2.controlbackend.Service;

import kkp2.controlbackend.Bean.Log;
import kkp2.controlbackend.Bean.Model;
import kkp2.controlbackend.Bean.ModelDetail;
import kkp2.controlbackend.Mapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class ModelServiceImpl implements ModelService {
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Model> getDisployModel() {
        return modelMapper.getDisployModel();
    }

    @Override
    public List<Model> getUndisployModel() {
        return modelMapper.getNotDisployModel();
    }

    @Override
    public List<Model> getAllModel() {
        return modelMapper.getAllModel();
    }

    @Override
    public ModelDetail getModelDetail(int id) {
        return modelMapper.getModelDetail(id);
    }

    @Override
    public List<Model> getModelCount() { return modelMapper.getModelCount();}

    @Override
    public List<Log> getlog(int id) { return modelMapper.getlog(id); }
}
