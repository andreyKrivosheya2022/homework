package com.company.logger.stdOutLogger;

import com.company.levels.LoggingLevel;
import com.company.logger.Logger;
import com.company.logger.configuration.StdOutLoggerConfigurationLoader;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StdOutLogger extends Logger {

    StdOutLoggerConfigurationLoader.StdOutLoggerConfiguration data;

    public StdOutLogger(StdOutLoggerConfigurationLoader.StdOutLoggerConfiguration data) {
        this.data = data;
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

    private String getDateTime() {
        return new SimpleDateFormat("HH:mm:ss").format(new Date(System.currentTimeMillis()));
    }

    private void log(LoggingLevel level, String message) {
        String log_string = String.format("%s\n%s Message: %s\n", getDateTime(), level, message);
        System.out.println(log_string);
    }

}
