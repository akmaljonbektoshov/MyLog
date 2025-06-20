package uz.pdp.servise;

import java.util.logging.Level;

import static uz.pdp.util.Utils.logger;

public class LogService {
    public static void logWrite() {
        logger.log(Level.WARNING, "Warning write:");
        logWrite2();
    }

    private static void logWrite2() {
        logger.log(Level.INFO, "Info write:");
    }
}
