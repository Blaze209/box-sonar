package org.tinylog.pattern;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import org.tinylog.core.LogEntry;
import org.tinylog.core.LogEntryValue;

/* JADX INFO: loaded from: classes5.dex */
final class LoggerTagToken implements Token {
    private static final String DEFAULT_EMPTY_TAG = "";
    private final String empty;

    LoggerTagToken() {
        this.empty = "";
    }

    LoggerTagToken(String str) {
        this.empty = str;
    }

    @Override // org.tinylog.pattern.Token
    public Collection<LogEntryValue> getRequiredLogEntryValues() {
        return Collections.singleton(LogEntryValue.TAG);
    }

    @Override // org.tinylog.pattern.Token
    public void render(LogEntry logEntry, StringBuilder sb) {
        String tag = logEntry.getTag();
        if (tag == null) {
            sb.append(this.empty);
        } else {
            sb.append(tag);
        }
    }

    @Override // org.tinylog.pattern.Token
    public void apply(LogEntry logEntry, PreparedStatement preparedStatement, int i) throws SQLException {
        String tag = logEntry.getTag();
        if (tag == null) {
            preparedStatement.setString(i, "".equals(this.empty) ? null : this.empty);
        } else {
            preparedStatement.setString(i, tag);
        }
    }
}
