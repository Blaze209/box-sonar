package org.tinylog.writers;

import java.util.Collection;
import org.tinylog.core.LogEntry;
import org.tinylog.core.LogEntryValue;

/* JADX INFO: loaded from: classes5.dex */
public interface Writer {
    void close() throws Exception;

    void flush() throws Exception;

    Collection<LogEntryValue> getRequiredLogEntryValues();

    void write(LogEntry logEntry) throws Exception;
}
