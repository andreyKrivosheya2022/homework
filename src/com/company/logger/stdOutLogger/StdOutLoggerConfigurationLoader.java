package com.company.logger.stdOutLogger;

import com.company.levels.LoggingLevel;
import com.company.logger.ConfigurationLoader;

import java.io.FileInputStream;
import java.util.Properties;

public class StdOutLoggerConfigurationLoader extends ConfigurationLoader {

    @Override
    public StdOutLoggerConfiguration load(String path) {
        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            Properties properties = new Properties();
            properties.load(fileInputStream);

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
