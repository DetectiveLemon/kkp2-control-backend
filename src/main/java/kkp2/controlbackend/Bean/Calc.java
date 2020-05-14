package kkp2.controlbackend.Bean;

public class Calc {
    private int code;
    private int start;
    private int end;
    private int model_id;
    private String mongo_url;
    private String database_name;
    private String source_collection;
    private String result_collection;

    public Calc() {
    }

    public Calc(int code, int start, int end, int model_id, String mongo_url, String database_name, String source_collection, String result_collection) {
        this.code = code;
        this.start = start;
        this.end = end;
        this.model_id = model_id;
        this.mongo_url = mongo_url;
        this.database_name = database_name;
        this.source_collection = source_collection;
        this.result_collection = result_collection;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getModel_id() {
        return model_id;
    }

    public void setModel_id(int model_id) {
        this.model_id = model_id;
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

    @Override
    public String toString() {
        return "Calc{" +
                "code=" + code +
                ", start=" + start +
                ", end=" + end +
                ", model_id=" + model_id +
                ", mongo_url='" + mongo_url + '\'' +
                ", database_name='" + database_name + '\'' +
                ", source_collection='" + source_collection + '\'' +
                ", result_collection='" + result_collection + '\'' +
                '}';
    }
}
