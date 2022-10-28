package com.company.logger.configuration;

import com.company.levels.LoggingLevel;

public class Configuration {
    String file, format;
    double maxSize;
    LoggingLevel level;

    {
        file = "";
        format = "";
        maxSize = 0;
    }
    Configuration(String file, LoggingLevel level, double maxSize, String format) {
        this.file = file;
        this.level = level;
        this.maxSize = maxSize;
        this.format = format;
    }
    Configuration(LoggingLevel level) {
        this.level = level;
    }

    public String getFile() {
        return file;
    }

    public String getFormat() {
        return format;
    }

    public double getMaxSize() {
        return maxSize;
    }

    public LoggingLevel getLevel() {
        return level;
    }
}
