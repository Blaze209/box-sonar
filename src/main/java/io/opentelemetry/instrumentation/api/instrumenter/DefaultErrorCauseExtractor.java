package io.opentelemetry.instrumentation.api.instrumenter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.concurrent.ExecutionException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
final class DefaultErrorCauseExtractor implements ErrorCauseExtractor {
    static final ErrorCauseExtractor INSTANCE = new DefaultErrorCauseExtractor();

    @Nullable
    private static final Class<?> COMPLETION_EXCEPTION_CLASS = getCompletionExceptionClass();

    @Override // io.opentelemetry.instrumentation.api.instrumenter.ErrorCauseExtractor
    public Throwable extract(Throwable th) {
        return (th.getCause() == null || !((th instanceof ExecutionException) || isInstanceOfCompletionException(th) || (th instanceof InvocationTargetException) || (th instanceof UndeclaredThrowableException))) ? th : extract(th.getCause());
    }

    private static boolean isInstanceOfCompletionException(Throwable th) {
        Class<?> cls = COMPLETION_EXCEPTION_CLASS;
        return cls != null && cls.isInstance(th);
    }

    @Nullable
    private static Class<?> getCompletionExceptionClass() {
        try {
            return Class.forName("java.util.concurrent.CompletionException");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private DefaultErrorCauseExtractor() {
    }
}
