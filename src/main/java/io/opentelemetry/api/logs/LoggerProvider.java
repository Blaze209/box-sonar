package io.opentelemetry.api.logs;

/* JADX INFO: loaded from: classes4.dex */
public interface LoggerProvider {
    LoggerBuilder loggerBuilder(String str);

    default Logger get(String str) {
        return loggerBuilder(str).build();
    }

    static LoggerProvider noop() {
        return DefaultLoggerProvider.getInstance();
    }
}
