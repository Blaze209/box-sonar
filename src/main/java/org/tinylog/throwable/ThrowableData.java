package org.tinylog.throwable;

import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface ThrowableData {
    ThrowableData getCause();

    String getClassName();

    String getMessage();

    List<StackTraceElement> getStackTrace();
}
