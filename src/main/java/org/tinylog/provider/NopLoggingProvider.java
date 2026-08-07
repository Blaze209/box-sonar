package org.tinylog.provider;

import org.tinylog.Level;
import org.tinylog.format.MessageFormatter;

/* JADX INFO: loaded from: classes5.dex */
public final class NopLoggingProvider implements LoggingProvider {
    private static final ContextProvider contextProvider = new NopContextProvider();

    @Override // org.tinylog.provider.LoggingProvider
    public boolean isEnabled(int i, String str, Level level) {
        return false;
    }

    @Override // org.tinylog.provider.LoggingProvider
    public boolean isEnabled(String str, String str2, Level level) {
        return false;
    }

    @Override // org.tinylog.provider.LoggingProvider
    public void log(int i, String str, Level level, Throwable th, MessageFormatter messageFormatter, Object obj, Object... objArr) {
    }

    @Override // org.tinylog.provider.LoggingProvider
    public void log(String str, String str2, Level level, Throwable th, MessageFormatter messageFormatter, Object obj, Object... objArr) {
    }

    @Override // org.tinylog.provider.LoggingProvider
    public void shutdown() {
    }

    @Override // org.tinylog.provider.LoggingProvider
    public ContextProvider getContextProvider() {
        return contextProvider;
    }

    @Override // org.tinylog.provider.LoggingProvider
    public Level getMinimumLevel() {
        return Level.OFF;
    }

    @Override // org.tinylog.provider.LoggingProvider
    public Level getMinimumLevel(String str) {
        return Level.OFF;
    }
}
