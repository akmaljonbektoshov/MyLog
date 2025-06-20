package uz.pdp.servise;

import lombok.SneakyThrows;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;
import java.util.logging.StreamHandler;

import static uz.pdp.util.Utils.logger;

public class StreamHandlerService {
    public static void main(String[] args) throws FileNotFoundException {
        /// bu default ConsoleHandlerni bloklaydi
        logger.setUseParentHandlers(false);
        /// bu logger ni levelini belgilaydi
        logger.setLevel(Level.FINEST);


///        Stream Handler
        extracted();
//        extracted2();
    }

    @SneakyThrows
    private static void extracted() {
        FileOutputStream fos = new FileOutputStream("myLog.log", true);
        StreamHandler streamHandler = new StreamHandler(fos, new SimpleFormatter());

        streamHandler.setLevel(Level.CONFIG);
//        streamHandler.setFilter(record -> record.getLevel().intValue() >= Level.CONFIG.intValue());
        logger.addHandler(streamHandler);

        logger.log(Level.SEVERE, "Severe write:");
        logger.log(Level.WARNING, "Warning write:");
        logger.log(Level.INFO, "Info write:");
        logger.log(Level.CONFIG, "Config write:");
        logger.log(Level.FINE, "Fine write:");
        logger.log(Level.FINER, "Finer write:");
        logger.log(Level.FINEST, "Finest write:");

        /// atrishlaricha .flush() methodi chaqirilishi majburiy ekan
//        streamHandler.publish();

//        streamHandler.flush();
//        fos.close();
    }

    private static void extracted2() throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("myLog.log", true));
        StreamHandler streamHandler = new StreamHandler(bos, new SimpleFormatter());

        streamHandler.setLevel(Level.FINE);
//        streamHandler.setFilter(record -> record.getLevel().intValue() >= Level.CONFIG.intValue());
        logger.addHandler(streamHandler);

        logger.log(Level.SEVERE, "Severe write:");
        logger.log(Level.WARNING, "Warning write:");
        logger.log(Level.INFO, "Info write:");
        logger.log(Level.CONFIG, "Config write:");
        logger.log(Level.FINE, "Fine write:");
        logger.log(Level.FINER, "Finer write:");
        logger.log(Level.FINEST, "Finest write:");


        /// atrishlaricha .flush() methodi chaqirilishi majburiy ekan
//        streamHandler.publish();

        streamHandler.flush();
        bos.close();
    }
}
