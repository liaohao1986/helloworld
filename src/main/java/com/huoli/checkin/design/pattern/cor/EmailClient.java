package com.huoli.checkin.design.pattern.cor;

/**
 * Created by baardl on 07.12.15.
 */
public class EmailClient {
    private EmailProcessor processor;

    public EmailClient() {
        createProcessor();
    }

    private void createProcessor() {
        processor = new EmailProcessor();
        processor.addHandler(new BusinessMailHandler());
        processor.addHandler(new GMailHandler());
        processor.addHandler(new GenericMailHandler("bonly","bbbb"));
        processor.addHandler(new GenericMailHandler("bard","bard.lind@+[a-z].+[a-z]"));
    }

    public void addRule(EmailHandler handler) {
        processor.addHandler(handler);
    }

    public void emailReceived(Email email) {
        processor.handleRequest(email);
    }

    public static void main(String[] args) {
        EmailClient client = new EmailClient();
        Email email = new Email("bard.lind@gmail.com");
        client.emailReceived(email);
        email = new Email("dill@businessaddress.com");
        client.emailReceived(email);
        email = new Email("bard.lind@example.com");
        client.emailReceived(email);
        email = new Email("bbbb");
        client.emailReceived(email);
    }
}
