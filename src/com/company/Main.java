package com.company;

import com.company.logger.fileLogger.FileLoggerConfigurationLoader;
import com.company.logger.stdOutLogger.StdOutLoggerConfigurationLoader;
import com.company.logger.fileLogger.FileLogger;
import com.company.logger.stdOutLogger.StdOutLogger;

public class Main {

    public static void main(String[] args) {
        FileLogger logger =
                new FileLogger(new FileLoggerConfigurationLoader().load("src/setting/fileLogger.config"));
        for (int i = 0; i < 1000; i++) {
            logger.debug("Iteration: " + i);
        }
        logger.close();

        StdOutLogger stdOutLogger =
                new StdOutLogger(new StdOutLoggerConfigurationLoader().load("src/setting/stdoutLogger.config"));
        stdOutLogger.info("Testing console");
    }
}
