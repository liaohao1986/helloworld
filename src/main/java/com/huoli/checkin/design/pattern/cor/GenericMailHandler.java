package com.huoli.checkin.design.pattern.cor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by baardl on 07.12.15.
 */
public class GenericMailHandler extends AbstractEmailHandler {

    private final String name;
    private final String regexp;
    private final Pattern pattern;

    public GenericMailHandler(String name, String regexp) {
        this.name = name;
        this.regexp = regexp;
        pattern = Pattern.compile(regexp);
    }

    @Override
    protected boolean accept(Email email) {

        Matcher m = pattern.matcher(email.getFrom());
        boolean accepted = m.matches();
        return accepted;
    }

    @Override
    protected void doHandle(Email email) {
        System.out.println(name + " handled " + email);

    }
}
