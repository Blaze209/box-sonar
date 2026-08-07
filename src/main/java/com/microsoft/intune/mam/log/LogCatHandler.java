package com.microsoft.intune.mam.log;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.MessageFormat;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/* JADX INFO: loaded from: classes3.dex */
public class LogCatHandler extends Handler {
    private static final String ANONYMOUS = "UNKNOWN";
    private static final Formatter FORMATTER = new Formatter() { // from class: com.microsoft.intune.mam.log.LogCatHandler.1
        @Override // java.util.logging.Formatter
        public String format(LogRecord logRecord) {
            Throwable thrown = logRecord.getThrown();
            Object[] parameters = logRecord.getParameters();
            String message = logRecord.getMessage();
            if (parameters != null) {
                message = MessageFormat.format(logRecord.getMessage(), parameters);
            }
            if (thrown == null) {
                return message;
            }
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            stringWriter.write(message);
            stringWriter.write("\n");
            thrown.printStackTrace(printWriter);
            printWriter.flush();
            return stringWriter.toString();
        }
    };
    private static final int MAX_TAG_LENGTH = 23;
    private static final String TAG = "LogCatHandler";

    @Override // java.util.logging.Handler
    public void close() {
    }

    @Override // java.util.logging.Handler
    public void flush() {
    }

    public LogCatHandler() {
        setFormatter(FORMATTER);
    }

    @Override // java.util.logging.Handler
    public void publish(LogRecord logRecord) {
        try {
            int androidLevel = getAndroidLevel(logRecord.getLevel());
            String loggerName = logRecord.getLoggerName();
            if (loggerName == null) {
                loggerName = ANONYMOUS;
            } else {
                int length = loggerName.length();
                if (length > 23) {
                    int iLastIndexOf = loggerName.lastIndexOf(".");
                    if (length - iLastIndexOf < 23) {
                        loggerName = loggerName.substring(iLastIndexOf + 1);
                    } else {
                        loggerName = loggerName.substring(loggerName.length() - 23);
                    }
                }
            }
            Log.println(androidLevel, loggerName, getFormatter().format(logRecord));
        } catch (RuntimeException e) {
            Log.e(TAG, "Error logging message.", e);
        }
    }

    private static int getAndroidLevel(Level level) {
        int iIntValue = level.intValue();
        if (iIntValue >= Level.SEVERE.intValue()) {
            return 6;
        }
        if (iIntValue >= Level.WARNING.intValue()) {
            return 5;
        }
        return iIntValue >= Level.INFO.intValue() ? 4 : 3;
    }
}
