package com.company.logger.fileLogger;

import com.company.exception.FileMaxSizeReachedException;
import com.company.levels.LoggingLevel;
import com.company.logger.Logger;
import com.company.logger.configuration.FileLoggerConfigurationLoader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class FileLogger extends Logger {

    private final FileLoggerConfigurationLoader.FileLoggerConfiguration data;
    private FileWriter fileWriter;
    private File file;

    public FileLogger(FileLoggerConfigurationLoader.FileLoggerConfiguration data) {
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
        String wayToFile = data.getFile() + "_" + getDateTime(TypeDataTime.DATA_TIME) + data.getFormat();
        file = new File("src/text/" + wayToFile);
        file.createNewFile();
        fileWriter = new FileWriter(file);
    }

    private void checkSize() throws Exception {
        double size = 0;
        if ((size = file.length() / 8192.) >= data.getMaxSize()) {
            createFile();
            throw new FileMaxSizeReachedException(String.format("You are under size limit.\nSize: %.2f bytes\nFile path: %s\n", size, file.getPath()));
        }
    }

    private String getDateTime(TypeDataTime type) {
        if (type == TypeDataTime.DATA_TIME)
            return new SimpleDateFormat("dd.MM.yyyy-HH.mm.ss.SS").format(new Date(System.currentTimeMillis()));
        else return new SimpleDateFormat("HH:mm:ss.SS").format(new Date(System.currentTimeMillis()));
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
        if (LoggingLevel.INFO.getCount() <= data.getLevel().getCount())
            log(LoggingLevel.INFO, message);
    }

    @Override
    public void debug(String message) {
        if (LoggingLevel.DEBUG.getCount() <= data.getLevel().getCount())
            log(LoggingLevel.DEBUG, message);
    }

    private void log(LoggingLevel level, String message) {
        String log_string = String.format("%s\n%s Message: %s\n", getDateTime(TypeDataTime.TIME), level, message);
        try {
            fileWriter.write(log_string);
            checkSize();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    enum TypeDataTime {
        DATA_TIME, TIME
    }
}