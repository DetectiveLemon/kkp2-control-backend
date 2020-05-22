package kkp2.controlbackend.Bean;

public class Model {
    private int model_id;
    private String model_name;
    private String model_desc;
    private int model_status;
    private int model_use_count;

    public int getModel_id() {
        return model_id;
    }

    public void setModel_id(int model_id) {
        this.model_id = model_id;
    }

    public String getModel_name() {
        return model_name;
    }

    public void setModel_name(String model_name) {
        this.model_name = model_name;
    }

    public String getModel_desc() {
        return model_desc;
    }

    public void setModel_desc(String model_desc) {
        this.model_desc = model_desc;
    }

    public int getModel_status() {
        return model_status;
    }

    public void setModel_status(int model_status) {
        this.model_status = model_status;
    }

    public int getModel_use_count() {
        return model_use_count;
    }

    public void setModel_use_count(int model_use_count) {
        this.model_use_count = model_use_count;
    }

    @Override
    public String toString() {
        return "Model{" +
                "model_id=" + model_id +
                ", model_name='" + model_name + '\'' +
                ", model_desc='" + model_desc + '\'' +
                ", model_status=" + model_status +
                ", model_use_count=" + model_use_count +
                '}';
    }
}
