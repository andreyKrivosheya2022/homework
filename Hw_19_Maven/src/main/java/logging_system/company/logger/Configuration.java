package logging_system.company.logger;

import logging_system.company.levels.LoggingLevel;

public abstract class Configuration {

    final String format;
    final LoggingLevel level;

    public Configuration(LoggingLevel level, String format) {
        this.level = level;
        this.format = format;
    }

    public LoggingLevel getLevel() {
        return level;
    }

    public String getFormat() {
        return format;
    }
}
