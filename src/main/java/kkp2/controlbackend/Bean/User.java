package kkp2.controlbackend.Bean;

public class User {
    private int user_id;
    private String user_name;
    private String password;
    private int user_type;
    private String staff_id;
    private String staff_name;

    public User() {
    }

    public User(int user_id, String user_name, String password, int user_type, String staff_id, String staff_name) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.password = password;
        this.user_type = user_type;
        this.staff_id = staff_id;
        this.staff_name = staff_name;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUser_type() {
        return user_type;
    }

    public void setUser_type(int user_type) {
        this.user_type = user_type;
    }

    public String getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name=" + user_name +
                ", password=" + password +
                ", user_type=" + user_type +
                ", staff_id=" + staff_id +
                ", staff_name=" + staff_name+
                '}';
    }
}
