package logging_system.company.logger.fileLogger;

import logging_system.company.levels.LoggingLevel;
import logging_system.company.logger.ConfigurationLoader;

import java.io.InputStream;
import java.util.Properties;

public class FileLoggerConfigurationLoader extends ConfigurationLoader {

    @Override
    public FileLoggerConfiguration load(InputStream path) {
        try {
            Properties properties = new Properties();
            properties.load(path);

            String file = properties.getProperty("file.name");
            double maxSize = Double.parseDouble(properties.getProperty("file.maxSize"));
            String format = properties.getProperty("file.format");
            LoggingLevel level =
                    LoggingLevel.valueOf(properties.getProperty("file.loggingLevel").toUpperCase());

            return new FileLoggerConfiguration(file, level, maxSize, format);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
