package io.opentelemetry.api.logs;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class GlobalLoggerProvider {
    private static final AtomicReference<LoggerProvider> instance = new AtomicReference<>(LoggerProvider.noop());

    @Nullable
    private static volatile Throwable setInstanceCaller;

    private GlobalLoggerProvider() {
    }

    public static LoggerProvider get() {
        return instance.get();
    }

    public static void set(LoggerProvider loggerProvider) {
        if (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(instance, LoggerProvider.noop(), loggerProvider) && loggerProvider != LoggerProvider.noop()) {
            throw new IllegalStateException("GlobalLoggerProvider.set has already been called. GlobalLoggerProvider.set must be called only once before any calls to GlobalLoggerProvider.get. Previous invocation set to cause of this exception.", setInstanceCaller);
        }
        setInstanceCaller = new Throwable();
    }

    public static void resetForTest() {
        instance.set(LoggerProvider.noop());
    }
}
