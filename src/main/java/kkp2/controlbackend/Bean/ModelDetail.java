package kkp2.controlbackend.Bean;

public class ModelDetail {
    private int model_id;
    private String encrypt_type;
    private String encrypt_key;
    private String function;

    public int getModel_id() {
        return model_id;
    }

    public void setModel_id(int model_id) {
        this.model_id = model_id;
    }

    public String getEncrypt_type() {
        return encrypt_type;
    }

    public void setEncrypt_type(String encrypt_type) {
        this.encrypt_type = encrypt_type;
    }

    public String getEncrypt_key() {
        return encrypt_key;
    }

    public void setEncrypt_key(String encrypt_key) {
        this.encrypt_key = encrypt_key;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }
}
