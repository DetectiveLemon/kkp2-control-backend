package kkp2.controlbackend.Bean;


public class Request {

    private int requestId;
    private int requestModel;
    private String requestCompany;
    private java.sql.Timestamp requestTime;
    private int requestData;
    private java.sql.Timestamp govTime;
    private java.sql.Timestamp adminTime;
    private int requestStatus;


    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }


    public int getRequestModel() {
        return requestModel;
    }

    public void setRequestModel(int requestModel) {
        this.requestModel = requestModel;
    }


    public String getRequestCompany() {
        return requestCompany;
    }

    public void setRequestCompany(String requestCompany) {
        this.requestCompany = requestCompany;
    }


    public java.sql.Timestamp getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(java.sql.Timestamp requestTime) {
        this.requestTime = requestTime;
    }


    public int getRequestData() {
        return requestData;
    }

    public void setRequestData(int requestData) {
        this.requestData = requestData;
    }


    public java.sql.Timestamp getGovTime() {
        return govTime;
    }

    public void setGovTime(java.sql.Timestamp govTime) {
        this.govTime = govTime;
    }


    public java.sql.Timestamp getAdminTime() {
        return adminTime;
    }

    public void setAdminTime(java.sql.Timestamp adminTime) {
        this.adminTime = adminTime;
    }


    public int getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(int requestStatus) {
        this.requestStatus = requestStatus;
    }

}
