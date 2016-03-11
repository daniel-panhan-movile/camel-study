package com.movile.study.camel;

import javax.xml.namespace.QName;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.cxf.CxfEndpoint;
import org.apache.camel.component.cxf.DataFormat;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.movile.poseidon.channel.SendMessage;
import com.movile.poseidon.channel.bean.SMS;
import com.movile.poseidon.channel.bean.SendSMSResp;

@Component
public class CamelStudyRouter extends RouteBuilder {

    @Autowired
    private CamelContext camelContext;
    
    @Override
    public void configure() throws Exception {

        SMS sms = new SMS();
        sms.setId("1111");
        sms.setCorrelationId("aaaaa");
        sms.setDestination("5519991145117");
        sms.setMessageText("Text");
        
        CxfEndpoint cxfEndpoint = new CxfEndpoint();
        cxfEndpoint.setAddress("http://localhost:8080/WebServiceProject/services/SendMessagePort");
        //cxfEndpoint.setWsdlURL("http://localhost:8080/WebServiceProject/services/SendMessagePort?wsdl");
        cxfEndpoint.setWsdlURL("/home/panhan/workspace/camel-study/src/main/resources/sendmessage.wsdl");
        cxfEndpoint.setCamelContext(camelContext);
        cxfEndpoint.setDataFormat(DataFormat.POJO);
        cxfEndpoint.setServiceName(new QName("http://channel.poseidon.movile.com/", "SendMessageService"));
        cxfEndpoint.setPortName(new QName("http://channel.poseidon.movile.com/", "SendMessagePort"));
        cxfEndpoint.setServiceClass(SendMessage.class);
        
        try {
            camelContext.addEndpoint("myEndpoint", cxfEndpoint);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
//        Expression expression = new Expression() {
//            
//            @SuppressWarnings("unchecked")
//            @Override
//            public <T> T evaluate(Exchange exchange, Class<T> type) {
//                SMS sms = new SMS();
//                sms.setId("1111");
//                return (T) sms; 
//            }
//        };
        
//        from("timer://timer_1?fixedRate=true&period=5000")
//            .setBody(expression)
//            .split(body())
//                .log("Body: ${body}")
//                .aggregate(constant(true)).completionSize(3).groupExchanges()
//                .log("Body: ${body}")
//            .end();
            
        
        from(cxfEndpoint)
            .process(new Processor() {
              
              @Override
              public void process(Exchange exchange) throws Exception {
                  Object o = exchange.getIn().getBody();
                  org.apache.cxf.message.MessageContentsList m = (org.apache.cxf.message.MessageContentsList) o;
                  SMS sms = (SMS) m.get(0);
                  System.out.println(">>>>>>>>>>> Consumer: " + sms);
                  
                  SendSMSResp resp = new SendSMSResp();
                  resp.setId("111111");
                  resp.setErrorCode(0);
                  resp.setErrorMessage("Message OK");
                  exchange.getOut().setBody(resp);
              }
          });
        
        from("timer://timer_2?fixedRate=true&period=5000")
        .setBody(constant(sms))
        .setHeader(CxfConstants.OPERATION_NAME, constant("sendSMS"))
        .setHeader(CxfConstants.OPERATION_NAMESPACE, constant("http://channel.poseidon.movile.com/"))
        .to(cxfEndpoint)
        .process(new Processor() {
            
            @Override
            public void process(Exchange exchange) throws Exception {
                Object o = exchange.getIn().getBody();
                org.apache.cxf.message.MessageContentsList m = (org.apache.cxf.message.MessageContentsList) o;
                SendSMSResp resp = (SendSMSResp) m.get(0);
                System.out.println(">>>>>>>>>>>>>>>> Producer: " + resp);
            }
        });
    }

}