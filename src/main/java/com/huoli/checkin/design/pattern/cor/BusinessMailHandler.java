package com.huoli.checkin.design.pattern.cor;

/**
 * Created by baardl on 07.12.15.
 */
public class BusinessMailHandler extends AbstractEmailHandler {
    private EmailHandler next;

//    public void setNext(EmailHandler handler) {
//        next = handler;
//    }

//    public void handleRequest(Email email) {
//        if (!) {
//            next.handleRequest(email);
//        }else{    //handle request (move to correct folder)}}}
//
//        }
//    }

    @Override
    protected boolean accept(Email email) {
        return email.getFrom().endsWith("@businessaddress.com");
    }

    @Override
    protected void doHandle(Email email) {
        System.out.println("Handled email as BusinessMail, " + email);

    }
}
