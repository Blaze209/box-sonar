package org.tinylog.throwable;

import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class ThrowableStore implements ThrowableData {
    private ThrowableData cause;
    private String className;
    private String message;
    private List<StackTraceElement> stackTrace;

    public ThrowableStore(String str, String str2, List<StackTraceElement> list, ThrowableData throwableData) {
        this.className = str;
        this.message = str2;
        this.stackTrace = list;
        this.cause = throwableData;
    }

    @Override // org.tinylog.throwable.ThrowableData
    public String getClassName() {
        return this.className;
    }

    @Override // org.tinylog.throwable.ThrowableData
    public String getMessage() {
        return this.message;
    }

    @Override // org.tinylog.throwable.ThrowableData
    public List<StackTraceElement> getStackTrace() {
        return this.stackTrace;
    }

    @Override // org.tinylog.throwable.ThrowableData
    public ThrowableData getCause() {
        return this.cause;
    }
}
