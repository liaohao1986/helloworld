package com.huoli.checkin.design.pattern.cor;

/**
 * Created by baardl on 07.12.15.
 */
public interface EmailHandler {
    //reference to the next handler in the chain
    void setNext(EmailHandler handler);
    //handle request
    void handleRequest(Email email);
}