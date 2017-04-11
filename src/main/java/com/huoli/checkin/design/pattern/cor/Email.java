package com.huoli.checkin.design.pattern.cor;

/**
 * Created by baardl on 07.12.15.
 */
public class Email {
    private String from;

    public Email(String from) {
        this.from = from;
    }

    public String getFrom() {
        return from;
    }

    @Override
    public String toString() {
        return "Email{" +
                "from='" + from + '\'' +
                '}';
    }
}
