package logging_system.company.logger.fileLogger;


import logging_system.company.levels.LoggingLevel;
import logging_system.company.logger.Configuration;

public class FileLoggerConfiguration extends Configuration {

    private final String file;
    private final double maxSize;

    FileLoggerConfiguration(String file, LoggingLevel level, double maxSize, String format) {
        super(level, format);
        this.file = file;
        this.maxSize = maxSize;
    }

    public String getFile() {
        return file;
    }

    public double getMaxSize() {
        return maxSize;
    }
}