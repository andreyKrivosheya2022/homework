package com.company;

import com.company.levels.LoggingLevel;
import com.company.logger.configuration.FileLoggerConfigurationLoader;
import com.company.logger.configuration.StdOutLoggerConfigurationLoader;
import com.company.logger.fileLogger.FileLogger;
import com.company.logger.stdOutLogger.StdOutLogger;

public class Main {

    public static void main(String[] args) {
        FileLogger logger = new FileLogger(FileLoggerConfigurationLoader.load("Logger", LoggingLevel.DEBUG, 10, ".txt"));
        for (int i = 0; i < 10000; i++) {
            logger.debug("Iteration: " + i);
        }
        logger.close();

        StdOutLogger stdOutLogger = new StdOutLogger(StdOutLoggerConfigurationLoader.load(LoggingLevel.INFO));

        stdOutLogger.info("Testing console");
    }
}
