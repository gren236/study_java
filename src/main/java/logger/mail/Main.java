package logger.mail;

import java.util.logging.Logger;

public class Main {
    public static Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static final String AUSTIN_POWERS = "Austin Powers";
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";

    public static void main(String[] args) {
        Sendable mail = new MailMessage("Me", "Her", "Hello World!");

        Spy spy = new Spy(LOGGER);
        spy.processMail(mail);
        Thief thief = new Thief(23);
        thief.processMail(mail);
        Inspector inspector = new Inspector();
        inspector.processMail(mail);

        UntrustworthyMailWorker untrustworthyMailWorker = new UntrustworthyMailWorker(new MailService[]{spy, thief, inspector});
        untrustworthyMailWorker.processMail(mail);
    }
}
