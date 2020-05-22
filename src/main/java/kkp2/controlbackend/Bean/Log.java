package kkp2.controlbackend.Bean;

import java.util.Date;

public class Log {
    private int log_id;
    private int model_id;
    private String model_name;
    private int model_use;
    private Date model_use_date;

    public int getLog_id() {
        return log_id;
    }

    public void setLog_id(int log_id) {
        this.log_id = log_id;
    }

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

    public int getModel_use() {
        return model_use;
    }

    public void setModel_use(int model_use) {
        this.model_use = model_use;
    }

    public Date getModel_use_date() {
        return model_use_date;
    }

    public void setModel_use_date(Date model_use_date) {
        this.model_use_date = model_use_date;
    }
}
