package com.microsoft.intune.mam.log;

/* JADX INFO: loaded from: classes3.dex */
public final class MAMLoggerProvider {
    public static final String LOGGER_NAME_PREFIX = "MSMAM - ";

    public static MAMLogger getLogger(Class<?> cls) {
        return new MAMLogger(LOGGER_NAME_PREFIX + cls.getName());
    }

    public static MAMLogger getLoggerForPackage(String str) {
        return new MAMLogger(LOGGER_NAME_PREFIX + str);
    }

    private MAMLoggerProvider() {
    }
}
