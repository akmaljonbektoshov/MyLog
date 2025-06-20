package uz.pdp;

import lombok.SneakyThrows;
import uz.pdp.servise.LogService;

import java.io.*;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.*;

import static uz.pdp.util.Utils.*;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        logMethod();
//        createFileAndPath();
//        log2Method();
    }

    @SneakyThrows
    public static void logMethod() {
        /// bu default ConsoleHandlerni bloklaydi
        logger.setUseParentHandlers(false);
        /// bu logger ni levelini belgilaydi
        logger.setLevel(Level.FINEST);

///         Console Handler
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.FINEST);
//        consoleHandler.setFilter(record -> record.getLevel().intValue() >= Level.FINE.intValue());
        consoleHandler.setFormatter(new SimpleFormatter());
        logger.addHandler(consoleHandler);

///         File Handler
        FileHandler fileHandler = new FileHandler("myLog.log", true);
        fileHandler.setLevel(Level.FINEST);
//        fileHandler.setFilter(record -> record.getLevel().intValue() >= Level.CONFIG.intValue());
        fileHandler.setFormatter(new SimpleFormatter());
        logger.addHandler(fileHandler);

//        for (int i = 0; i < 5; i++) {
            writeInfoLog();
            LogService.logWrite();

            logger.log(Level.CONFIG, "Config write:");
            logger.log(Level.FINE, "Fine write:");
            logger.log(Level.FINER, "Finer write:");
            logger.log(Level.FINEST, "Finest write:");
//        }
//        fileHandler.publish();
//        consoleHandler.publish();
    }

    private static void writeInfoLog() {
        logger.log(Level.SEVERE, "Severe write:");
    }

    private static void log2Method() throws IOException {
        File file = new File("C:/Users/99890/PDP_projects/untitled/myLog.log");
        File file2 = new File("C:/Users/99890/PDP_projects/untitled/test.log");

        BufferedReader reader = new BufferedReader(new FileReader(file2));

        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));

        String line = null;
        while ((line = reader.readLine()) != null) {
            writer.write(line);
            writer.newLine();
//            System.out.println(line);
        }
        writer.close();
    }

    @SneakyThrows
    private static void createFileAndPath() {
        System.out.print("Enter file path: ");
        String text = strSc.nextLine();

        File file = new File(text);

        URI uri = new URI(text);

        Path path = Path.of(uri);
        Path path1 = Paths.get(text);

        Path file1 = Files.createFile(path);
        Path directory = Files.createDirectory(path1);

        File file2 = file1.toFile();
        Path path2 = file2.toPath();
    }
}