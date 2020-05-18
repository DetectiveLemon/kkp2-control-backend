package kkp2.controlbackend.Bean;

import java.util.Date;

public class Node {
    private String uuid;
    private int node_status;// 节点状态 1正常 2暂停 -1错误 -2失联
    private int calc_status;// 计算状态 1计算中 0空闲中 -1错误
    private double cpu_usage;
    private double mem_usage;
    private double mem_total;
    private double mem_available;
    private Date online_time;//上线时间
    private Date validate_time;//上次心跳包时间

    public Node() {
    }

    public Node(String uuid, int node_status, int calc_status, double cpu_usage, double mem_usage, double mem_total, double mem_available) {
        this.uuid = uuid;
        this.node_status = node_status;
        this.calc_status = calc_status;
        this.cpu_usage = cpu_usage;
        this.mem_usage = mem_usage;
        this.mem_total = mem_total;
        this.mem_available = mem_available;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getNode_status() {
        return node_status;
    }

    public void setNode_status(int node_status) {
        this.node_status = node_status;
    }

    public int getCalc_status() {
        return calc_status;
    }

    public void setCalc_status(int calc_status) {
        this.calc_status = calc_status;
    }

    public double getCpu_usage() {
        return cpu_usage;
    }

    public void setCpu_usage(double cpu_usage) {
        this.cpu_usage = cpu_usage;
    }

    public double getMem_usage() {
        return mem_usage;
    }

    public void setMem_usage(double mem_usage) {
        this.mem_usage = mem_usage;
    }

    public double getMem_total() {
        return mem_total;
    }

    public void setMem_total(double mem_total) {
        this.mem_total = mem_total;
    }

    public double getMem_available() {
        return mem_available;
    }

    public void setMem_available(double mem_available) {
        this.mem_available = mem_available;
    }

    public Date getOnline_time() {
        return online_time;
    }

    public void setOnline_time(Date online_time) {
        this.online_time = online_time;
    }

    public Date getValidate_time() {
        return validate_time;
    }

    public void setValidate_time(Date validate_time) {
        this.validate_time = validate_time;
    }

    @Override
    public String toString() {
        return "Node{" +
                "uuid='" + uuid + '\'' +
                ", node_status=" + node_status +
                ", calc_status=" + calc_status +
                ", cpu_usage=" + cpu_usage +
                ", mem_usage=" + mem_usage +
                ", mem_total=" + mem_total +
                ", mem_available=" + mem_available +
                ", online_time=" + online_time +
                ", validate_time=" + validate_time +
                '}';
    }
}
