package com.yubico.yubikit.core;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public abstract class Logger {

    @Nullable
    static Logger instance;

    protected void logDebug(String str) {
    }

    protected void logError(String str, Throwable th) {
    }

    public static void setLogger(@Nullable Logger logger) {
        instance = logger;
        com.yubico.yubikit.core.internal.Logger.setLogger(logger);
    }

    public static void d(String str) {
        Logger logger = instance;
        if (logger != null) {
            logger.logDebug(str);
        }
    }

    public static void e(String str, Throwable th) {
        Logger logger = instance;
        if (logger != null) {
            logger.logError(str, th);
        }
    }
}
