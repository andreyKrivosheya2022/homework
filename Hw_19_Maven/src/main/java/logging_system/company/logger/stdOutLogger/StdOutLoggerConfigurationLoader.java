package logging_system.company.logger.stdOutLogger;

import logging_system.company.levels.LoggingLevel;
import logging_system.company.logger.ConfigurationLoader;

import java.io.InputStream;
import java.util.Properties;

public class StdOutLoggerConfigurationLoader extends ConfigurationLoader {

    @Override
    public StdOutLoggerConfiguration load(InputStream path) {
        try {
            Properties properties = new Properties();
            properties.load(path);

            String format = properties.getProperty("stdout.format");
            LoggingLevel level =
                    LoggingLevel.valueOf(properties.getProperty("stdout.loggingLevel").toUpperCase());

            return new StdOutLoggerConfiguration(level, format);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
