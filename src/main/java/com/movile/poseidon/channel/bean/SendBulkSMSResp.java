package com.movile.poseidon.channel.bean;

import java.util.List;

public class SendBulkSMSResp {

    private List<String> ids;

    private Integer errorCode;

    private String errorMessage;

    public List<String> getIds() {
        return ids;
    }
    
    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public SendBulkSMSResp setErrorCode(Integer code) {
        this.errorCode = code;
        return this;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public SendBulkSMSResp setErrorMessage(String message) {
        this.errorMessage = message;
        return this;
    }

    @Override
    public String toString() {
        return "SendBulkSMSResp [ids=" + ids + ", errorCode=" + errorCode + ", errorMessage=" + errorMessage + "]";
    }

}
