package logger;

import java.util.logging.*;

public class Main {
    private static void configureLogging() {
        Logger logger = Logger.getLogger("logger.test");
        Handler handler = new ConsoleHandler();

        handler.setFormatter(new XMLFormatter());
        handler.setLevel(Level.ALL);

        logger.addHandler(handler);
        logger.setUseParentHandlers(false);
    }
}
