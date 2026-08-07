package org.tinylog.pattern;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import org.tinylog.core.LogEntry;
import org.tinylog.core.LogEntryValue;

/* JADX INFO: loaded from: classes5.dex */
public interface Token {
    void apply(LogEntry logEntry, PreparedStatement preparedStatement, int i) throws SQLException;

    Collection<LogEntryValue> getRequiredLogEntryValues();

    void render(LogEntry logEntry, StringBuilder sb);
}
