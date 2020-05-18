package kkp2.controlbackend.Bean;


import java.sql.Timestamp;

public class Request {

    private int request_id;
    private int request_Model;
    private String request_company;
    private java.sql.Timestamp request_time;
    private int request_data;
    private java.sql.Timestamp gov_time;
    private java.sql.Timestamp admin_time;
    private int request_status;

    public int getRequest_id() {
        return request_id;
    }

    public void setRequest_id(int request_id) {
        this.request_id = request_id;
    }


    public int getRequest_Model() {
        return request_Model;
    }

    public void setRequest_Model(int request_Model) {
        this.request_Model = request_Model;
    }

    public String getRequest_company() {
        return request_company;
    }

    public void setRequest_company(String request_company) {
        this.request_company = request_company;
    }

    public Timestamp getRequest_time() {
        return request_time;
    }

    public void setRequest_time(Timestamp request_time) {
        this.request_time = request_time;
    }

    public int getRequest_data() {
        return request_data;
    }

    public void setRequest_data(int request_data) {
        this.request_data = request_data;
    }

    public Timestamp getGov_time() {
        return gov_time;
    }

    public void setGov_time(Timestamp gov_time) {
        this.gov_time = gov_time;
    }

    public Timestamp getAdmin_time() {
        return admin_time;
    }

    public void setAdmin_time(Timestamp admin_time) {
        this.admin_time = admin_time;
    }

    public int getRequest_status() {
        return request_status;
    }

    public void setRequest_status(int request_status) {
        this.request_status = request_status;
    }
}
