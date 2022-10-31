package com.company.logger.stdOutLogger;

import com.company.levels.LoggingLevel;
import com.company.logger.Configuration;

public class StdOutLoggerConfiguration extends Configuration {

    StdOutLoggerConfiguration(LoggingLevel level, String format) {
        super(level, format);
    }
}