package org.tinylog.throwable;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class ThrowableWrapper implements ThrowableData {
    private final Throwable throwable;

    public ThrowableWrapper(Throwable th) {
        this.throwable = th;
    }

    @Override // org.tinylog.throwable.ThrowableData
    public String getClassName() {
        return this.throwable.getClass().getName();
    }

    @Override // org.tinylog.throwable.ThrowableData
    public String getMessage() {
        return this.throwable.getMessage();
    }

    @Override // org.tinylog.throwable.ThrowableData
    public List<StackTraceElement> getStackTrace() {
        return Arrays.asList(this.throwable.getStackTrace());
    }

    @Override // org.tinylog.throwable.ThrowableData
    public ThrowableWrapper getCause() {
        if (this.throwable.getCause() == null) {
            return null;
        }
        return new ThrowableWrapper(this.throwable.getCause());
    }
}
