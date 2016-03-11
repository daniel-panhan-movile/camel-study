package com.movile.poseidon.channel;

import com.movile.poseidon.channel.bean.BulkSMS;
import com.movile.poseidon.channel.bean.SMS;
import com.movile.poseidon.channel.bean.SendBulkSMSResp;
import com.movile.poseidon.channel.bean.SendSMSResp;

/**
 * @author Daniel Panhan (daniel.panhan@movile.com)
 */
public class SendMessage {

    public SendSMSResp sendSMS(SMS sms) {
        System.out.println(sms);
        SendSMSResp resp = new SendSMSResp();
        resp.setId("111111");
        resp.setErrorCode(0);
        resp.setErrorMessage("Message OK");
        return resp;
    }

    public SendBulkSMSResp sendBulkSMS(BulkSMS bulkSMS) {
        return new SendBulkSMSResp();
    }
}
