package com.company.logger.configuration;

import com.company.levels.LoggingLevel;

public class FileLoggerConfigurationLoader {

    public static class FileLoggerConfiguration extends Configuration {
        FileLoggerConfiguration(String file, LoggingLevel level, double maxSize, String format) {
           super(file, level, maxSize, format);
        }
    }
    public static FileLoggerConfiguration load(String file, LoggingLevel level, double maxSize, String format) {
        return new FileLoggerConfiguration(file, level, maxSize, format);
    }
}
