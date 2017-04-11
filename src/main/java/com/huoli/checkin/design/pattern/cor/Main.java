package com.huoli.checkin.design.pattern.cor;

public class Main {

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
