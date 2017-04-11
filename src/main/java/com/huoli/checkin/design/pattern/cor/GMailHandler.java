package com.huoli.checkin.design.pattern.cor;

/**
 * Created by baardl on 07.12.15.
 */
public class GMailHandler extends AbstractEmailHandler {

    protected boolean accept(Email email) {
        return email.getFrom().endsWith("@gmail.com");
    }

    protected void doHandle(Email email) {
        System.out.println("Is Gmail." + email);
    }
}
