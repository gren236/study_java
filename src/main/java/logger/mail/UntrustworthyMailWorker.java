package logger.mail;

public class UntrustworthyMailWorker implements MailService {
    private RealMailService realService = new RealMailService();

    private MailService[] services;

    public UntrustworthyMailWorker(MailService[] services) {
        this.services = services;
    }

    public RealMailService getRealMailService() {
        return realService;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        for (MailService service : services) {
            mail = service.processMail(mail);
        }

        return getRealMailService().processMail(mail);
    }
}
