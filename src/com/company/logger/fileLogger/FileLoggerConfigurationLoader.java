package com.company.logger.fileLogger;

import com.company.levels.LoggingLevel;
import com.company.logger.ConfigurationLoader;

import java.io.FileInputStream;
import java.util.Properties;

public class FileLoggerConfigurationLoader extends ConfigurationLoader {

    @Override
    public FileLoggerConfiguration load(String path) {
        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            Properties properties = new Properties();
            properties.load(fileInputStream);

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
