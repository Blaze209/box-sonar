package org.tinylog.runtime;

import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
interface RuntimeDialect {
    Timestamp createTimestamp();

    TimestampFormatter createTimestampFormatter(String str, Locale locale);

    String getCallerClassName(int i);

    String getCallerClassName(String str);

    StackTraceElement getCallerStackTraceElement(int i);

    StackTraceElement getCallerStackTraceElement(String str);

    String getDefaultWriter();

    long getProcessId();

    Timestamp getStartTime();

    boolean isAndroid();
}
