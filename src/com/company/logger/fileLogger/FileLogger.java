package com.company.logger.fileLogger;

import com.company.exception.FileMaxSizeReachedException;
import com.company.levels.LoggingLevel;
import com.company.logger.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class FileLogger extends Logger {

    private final FileLoggerConfiguration data;
    private FileWriter fileWriter;
    private File file;

    public FileLogger(FileLoggerConfiguration data) {
        this.data = data;
        try {
            deleteDirectory();
            createFile();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void deleteDirectory() {
        for (File deleteFile : Objects.requireNonNull(new File("src/text").listFiles())) {
            if (deleteFile.isFile()) deleteFile.delete();
        }
    }

    private void createFile() throws Exception {
        String pathToFile = data.getFile() + "_" + getDateTime(TypeDataTime.DATE_TIME) + ".txt";
        file = new File("src/text/" + pathToFile);
        file.createNewFile();
        fileWriter = new FileWriter(file);
    }

    private void checkSize() throws Exception {
        double size;
        if ((size = file.length()) >= data.getMaxSize()) {
            createFile();
            throw new FileMaxSizeReachedException(String.format("You are under size limit.\nSize: %.2f bytes\nFile path: %s\n", size, file.getPath()));
        }
    }

    public void close() {
        try {
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void info(String message) {
        if (data.getLevel() == LoggingLevel.INFO || data.getLevel() == LoggingLevel.DEBUG)
            log(LoggingLevel.INFO, message);
    }

    @Override
    public void debug(String message) {
        if (data.getLevel() == LoggingLevel.DEBUG)
            log(LoggingLevel.DEBUG, message);
    }

    private void log(LoggingLevel level, String message) {
        String log_string = String.format(data.getFormat(), getDateTime(TypeDataTime.TIME), level, message);
        try {
            fileWriter.write(log_string);
            checkSize();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}