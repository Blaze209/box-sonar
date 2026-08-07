package org.tinylog.provider;

import org.tinylog.Level;
import org.tinylog.format.MessageFormatter;

/* JADX INFO: loaded from: classes5.dex */
public interface LoggingProvider {
    ContextProvider getContextProvider();

    Level getMinimumLevel();

    Level getMinimumLevel(String str);

    boolean isEnabled(int i, String str, Level level);

    boolean isEnabled(String str, String str2, Level level);

    void log(int i, String str, Level level, Throwable th, MessageFormatter messageFormatter, Object obj, Object... objArr);

    void log(String str, String str2, Level level, Throwable th, MessageFormatter messageFormatter, Object obj, Object... objArr);

    void shutdown() throws InterruptedException;
}
