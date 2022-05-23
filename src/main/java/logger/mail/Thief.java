package logger.mail;

public class Thief implements MailService {
    private int minPrice;

    private int stolenValue;

    public Thief(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getStolenValue() {
        return stolenValue;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (!(mail instanceof MailPackage)) return mail;
        MailPackage pkg = (MailPackage) mail;

        if (pkg.getContent().getPrice() >= minPrice) {
            // Steal!
            stolenValue += pkg.getContent().getPrice();

            return new MailPackage(
                    pkg.getFrom(),
                    pkg.getTo(),
                    new Package("stones instead of " + pkg.getContent().getContent(), 0)
            );
        }

        return mail;
    }
}
