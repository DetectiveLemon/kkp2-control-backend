package kkp2.controlbackend.Service;

import kkp2.controlbackend.Bean.Model;
import kkp2.controlbackend.Mapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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
    public Model getModelDetail(int id) {
        return modelMapper.getModelDetail(id);
    }


}
