package com.huoli.checkin.design.pattern.cor;

/**
 * Created by baardl on 07.12.15.
 */
public abstract class AbstractEmailHandler implements EmailHandler {

    private volatile EmailHandler next;

    public final void setNext(EmailHandler handler) {
        if (next == null) {
            this.next = handler;
        } else {
            next.setNext(handler);
        }
    }

    public final void handleRequest(Email email) {
        if (this.accept(email)) {
            this.doHandle(email);
        } else {
            if (next != null) {
                next.handleRequest(email);
            }
        }
    }

    protected abstract boolean accept(Email email);

    protected abstract void doHandle(Email email);

}
