package logging_system.company.logger.stdOutLogger;


import logging_system.company.levels.LoggingLevel;
import logging_system.company.logger.Configuration;

public class StdOutLoggerConfiguration extends Configuration {

    StdOutLoggerConfiguration(LoggingLevel level, String format) {
        super(level, format);
    }
}