package com.movile.poseidon.channel.bean;

public class SendSMSResp {

    private String id;

    private Integer errorCode;

    private String errorMessage;

    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public Integer getErrorCode() {
        return errorCode;
    }

    public SendSMSResp setErrorCode(Integer code) {
        this.errorCode = code;
        return this;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public SendSMSResp setErrorMessage(String message) {
        this.errorMessage = message;
        return this;
    }

    @Override
    public String toString() {
        return "SendSMSResp [id=" + id + ", errorCode=" + errorCode + ", errorMessage=" + errorMessage + "]";
    }
    
    

}
