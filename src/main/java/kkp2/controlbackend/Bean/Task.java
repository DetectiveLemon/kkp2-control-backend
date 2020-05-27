package kkp2.controlbackend.Bean;

import java.sql.Timestamp;
import java.util.Date;

public class Task {
    private int task_id;
    private String task_name;
    private String task_desc;
    private int model_id;
    private int status;
    private int current;
    private int total;
    private String mongo_url;
    private String database_name;
    private String source_collection;
    private String result_collection;
    private String request_company;
    private Date request_time;

    public Task() {
    }

    public Task(int task_id, String task_name, String task_desc, int model_id, int status, int current, int total, String mongo_url, String database_name, String source_collection, String result_collection, String request_company, Date request_time) {
        this.task_id = task_id;
        this.task_name = task_name;
        this.task_desc = task_desc;
        this.model_id = model_id;
        this.status = status;
        this.current = current;
        this.total = total;
        this.mongo_url = mongo_url;
        this.database_name = database_name;
        this.source_collection = source_collection;
        this.result_collection = result_collection;
        this.request_company = request_company;
        this.request_time = request_time;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getTask_desc() {
        return task_desc;
    }

    public void setTask_desc(String task_desc) {
        this.task_desc = task_desc;
    }

    public int getModel_id() {
        return model_id;
    }

    public void setModel_id(int model_id) {
        this.model_id = model_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getMongo_url() {
        return mongo_url;
    }

    public void setMongo_url(String mongo_url) {
        this.mongo_url = mongo_url;
    }

    public String getDatabase_name() {
        return database_name;
    }

    public void setDatabase_name(String database_name) {
        this.database_name = database_name;
    }

    public String getSource_collection() {
        return source_collection;
    }

    public void setSource_collection(String source_collection) {
        this.source_collection = source_collection;
    }

    public String getResult_collection() {
        return result_collection;
    }

    public void setResult_collection(String result_collection) {
        this.result_collection = result_collection;
    }

    public String getRequest_company() {
        return request_company;
    }

    public void setRequest_company(String request_company) {
        this.request_company = request_company;
    }

    public Date getRequest_time() {
        return request_time;
    }

    public void setRequest_time(Date request_time) {
        this.request_time = request_time;
    }

    @Override
    public String toString() {
        return "Task{" +
                "task_id=" + task_id +
                ", task_name='" + task_name + '\'' +
                ", task_desc='" + task_desc + '\'' +
                ", model_id=" + model_id +
                ", status=" + status +
                ", current=" + current +
                ", total=" + total +
                ", mongo_url='" + mongo_url + '\'' +
                ", database_name='" + database_name + '\'' +
                ", source_collection='" + source_collection + '\'' +
                ", result_collection='" + result_collection + '\'' +
                ", request_company='" + request_company + '\'' +
                ", request_time=" + request_time +
                '}';
    }
}
