package logger.mail;

import java.util.logging.*;

public class Spy implements MailService {
    private final Logger logger;

    public Spy(Logger logger) {
        this.logger = logger;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (!(mail instanceof MailMessage)) return mail;
        MailMessage mailMessage = (MailMessage) mail;

        if (mail.getFrom().equals(Main.AUSTIN_POWERS) || mail.getTo().equals(Main.AUSTIN_POWERS)) {
            logger.log(
                    Level.WARNING,
                    "Detected target mail correspondence: from {0} to {1} \"{2}\"",
                    new Object[]{mailMessage.getFrom(), mailMessage.getTo(), mailMessage.getMessage()}
            );
        } else {
            logger.log(
                    Level.INFO,
                    "Usual correspondence: from {0} to {1}",
                    new Object[]{mailMessage.getFrom(), mailMessage.getTo()}
            );
        }

        return mail;
    }
}
