package com.movile.poseidon.channel.bean;

import java.util.List;

public class BulkSMS {

    private String id;

    private Long scheduledAt;

    private Long delayedInMinutes;

    private List<SMS> messages;

    private SMS defaultValues;

    private String campaignAlias;

    private Long campaignId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getScheduledAt() {
        return scheduledAt;
    }

    public void setScheduledAt(Long scheduledAt) {
        this.scheduledAt = scheduledAt;
    }

    public Long getDelayedInMinutes() {
        return delayedInMinutes;
    }

    public void setDelayedInMinutes(Long delayedInMinutes) {
        this.delayedInMinutes = delayedInMinutes;
    }

    public List<SMS> getMessages() {
        return messages;
    }

    public void setMessages(List<SMS> messages) {
        this.messages = messages;
    }

    public SMS getDefaultValues() {
        return defaultValues;
    }

    public void setDefaultValues(SMS defaultValues) {
        this.defaultValues = defaultValues;
    }

    public String getCampaignAlias() {
        return campaignAlias;
    }

    public void setCampaignAlias(String campaignAlias) {
        this.campaignAlias = campaignAlias;
    }

    public Long getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(Long campaignId) {
        this.campaignId = campaignId;
    }

    @Override
    public String toString() {
        return "BulkSMS [id=" + id + ", scheduledAt=" + scheduledAt + ", delayedInMinutes=" + delayedInMinutes + ", messages=" + messages + ", defaultValues="
                + defaultValues + ", campaignAlias=" + campaignAlias + ", campaignId=" + campaignId + "]";
    }
    
    

}
