package logger.mail;

public class Inspector implements MailService {
    @Override
    public Sendable processMail(Sendable mail) {
        if (!(mail instanceof MailPackage)) return mail;
        MailPackage pkg = (MailPackage) mail;

        if (pkg.getContent().getContent().equals(Main.BANNED_SUBSTANCE) || pkg.getContent().getContent().equals(Main.WEAPONS)) {
            throw new IllegalPackageException();
        }

        if (pkg.getContent().getContent().contains("stones")) {
            throw new StolenPackageException();
        }

        return mail;
    }
}
