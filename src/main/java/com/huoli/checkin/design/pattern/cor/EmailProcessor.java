package com.huoli.checkin.design.pattern.cor;

/**
 * Created by baardl on 07.12.15.
 */
public class EmailProcessor {
    //maintain a reference to the previous handler so we can add the next one
    private EmailHandler prevHandler;

    public void addHandler(EmailHandler handler) {
        if (prevHandler == null) {
            prevHandler = handler;
        } else {
            prevHandler.setNext(handler);
        }
    }


    public void handleRequest(Email email) {
        if (prevHandler != null) {
            prevHandler.handleRequest(email);
        } else {
            System.out.println("No handler found for email: " + email);
        }
    }

}
