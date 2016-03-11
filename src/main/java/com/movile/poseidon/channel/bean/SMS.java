package com.movile.poseidon.channel.bean;

import java.util.Arrays;

public class SMS {

    private String id;

    private String destination;

    private String messageText;

    private String correlationId;

    private Long expiresAt;

    private Long expiresInMinutes;

    private String extraInfo;

    private Long[] timeWindow;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public Long getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Long expiresAt) {
        this.expiresAt = expiresAt;
    }

    public Long getExpiresInMinutes() {
        return expiresInMinutes;
    }

    public void setExpiresInMinutes(Long expiresInMinutes) {
        this.expiresInMinutes = expiresInMinutes;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    public Long[] getTimeWindow() {
        return timeWindow;
    }

    public void setTimeWindow(Long[] timeWindow) {
        this.timeWindow = timeWindow;
    }

    @Override
    public String toString() {
        return "SMS [id=" + id + ", destination=" + destination + ", messageText=" + messageText + ", correlationId=" + correlationId + ", expiresAt="
                + expiresAt + ", expiresInMinutes=" + expiresInMinutes + ", extraInfo=" + extraInfo + ", timeWindow=" + Arrays.toString(timeWindow) + "]";
    }

    
}
