package com.company.logger.configuration;

import com.company.levels.LoggingLevel;

public class StdOutLoggerConfigurationLoader {

    public static class StdOutLoggerConfiguration extends Configuration{
        StdOutLoggerConfiguration(LoggingLevel level) {
            super(level);
        }
    }

    public static StdOutLoggerConfiguration load(LoggingLevel level) {
        return new StdOutLoggerConfiguration(level);
    }
}
