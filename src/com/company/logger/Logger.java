package com.company.logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Logger {

    public abstract void info(String massage);
    public abstract void debug(String massage);

    public String getDateTime(TypeDataTime type) {
        if (type == TypeDataTime.DATE_TIME)
            return new SimpleDateFormat("dd.MM.yyyy-HH.mm.ss.SS").format(new Date(System.currentTimeMillis()));
        return new SimpleDateFormat("HH:mm:ss.SS").format(new Date(System.currentTimeMillis()));
    }

    public enum TypeDataTime {
        DATE_TIME,
        TIME
    }
}
