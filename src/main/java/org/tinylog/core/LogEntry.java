package org.tinylog.core;

import java.util.Map;
import org.tinylog.Level;
import org.tinylog.runtime.Timestamp;

/* JADX INFO: loaded from: classes5.dex */
public final class LogEntry {
    private final String className;
    private final Map<String, String> context;
    private final Throwable exception;
    private final String fileName;
    private final Level level;
    private final int lineNumber;
    private final String message;
    private final String methodName;
    private final String tag;
    private final Thread thread;
    private final Timestamp timestamp;

    public LogEntry(Timestamp timestamp, Thread thread, Map<String, String> map, String str, String str2, String str3, int i, String str4, Level level, String str5, Throwable th) {
        this.timestamp = timestamp;
        this.thread = thread;
        this.context = map;
        this.className = str;
        this.methodName = str2;
        this.fileName = str3;
        this.lineNumber = i;
        this.tag = str4;
        this.level = level;
        this.message = str5;
        this.exception = th;
    }

    public Timestamp getTimestamp() {
        return this.timestamp;
    }

    public Thread getThread() {
        return this.thread;
    }

    public Map<String, String> getContext() {
        return this.context;
    }

    public String getClassName() {
        return this.className;
    }

    public String getMethodName() {
        return this.methodName;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int getLineNumber() {
        return this.lineNumber;
    }

    public String getTag() {
        return this.tag;
    }

    public Level getLevel() {
        return this.level;
    }

    public String getMessage() {
        return this.message;
    }

    public Throwable getException() {
        return this.exception;
    }
}
