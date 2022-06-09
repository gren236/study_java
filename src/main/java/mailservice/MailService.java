package mailservice;

import java.util.*;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<Sendable<T>> {
    private final Map<String, List<T>> mailBox;

    public MailService() {
        this.mailBox = new HashMap<String, List<T>>() {
            @Override
            public List<T> get(Object key) {
                List<T> result;

                if ((result = super.get(key)) == null) {
                    return Collections.emptyList();
                }

                return result;
            }
        };
    }

    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }

    @Override
    public void accept(Sendable sendable) {
        if (!mailBox.containsKey(sendable.getTo())) {
            mailBox.put(sendable.getTo(), new ArrayList<>());
        }

        List<T> contents = mailBox.get(sendable.getTo());
        contents.add((T) sendable.getContent());
    }
}
