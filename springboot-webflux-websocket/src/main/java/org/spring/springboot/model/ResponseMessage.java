package org.spring.springboot.model;

/**
 * ResponseMessage
 *
 * @author mongoding
 * @version 1.0
 * @since 2018/2/28
 */
public class ResponseMessage {
    private String responseMessage;

    public ResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }
}
