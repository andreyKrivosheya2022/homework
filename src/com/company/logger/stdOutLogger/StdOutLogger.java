package com.company.logger.stdOutLogger;

import com.company.levels.LoggingLevel;
import com.company.logger.Logger;

public class StdOutLogger extends Logger {

    StdOutLoggerConfiguration data;

    public StdOutLogger(StdOutLoggerConfiguration data) {
        this.data = data;
    }

    @Override
    public void info(String message) {
        if (data.getLevel() == LoggingLevel.INFO || data.getLevel() == LoggingLevel.DEBUG)
            log(LoggingLevel.INFO, message);
    }

    @Override
    public void debug(String message) {
        if (data.getLevel() == LoggingLevel.DEBUG)
            log(LoggingLevel.DEBUG, message);
    }

    private void log(LoggingLevel level, String message) {
        String log_string = String.format(data.getFormat(), getDateTime(TypeDataTime.TIME), level, message);
        System.out.println(log_string);
    }

}
