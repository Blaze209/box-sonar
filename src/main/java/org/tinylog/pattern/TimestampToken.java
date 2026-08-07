package org.tinylog.pattern;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import org.tinylog.core.LogEntry;
import org.tinylog.core.LogEntryValue;

/* JADX INFO: loaded from: classes5.dex */
final class TimestampToken implements Token {
    private static final long SECONDS_DIVISOR = 1000;
    private final boolean useMilliseconds;

    TimestampToken() {
        this.useMilliseconds = false;
    }

    TimestampToken(String str) {
        this.useMilliseconds = "milliseconds".equals(str);
    }

    @Override // org.tinylog.pattern.Token
    public Collection<LogEntryValue> getRequiredLogEntryValues() {
        return Collections.singletonList(LogEntryValue.DATE);
    }

    @Override // org.tinylog.pattern.Token
    public void render(LogEntry logEntry, StringBuilder sb) {
        sb.append(getTime(logEntry));
    }

    @Override // org.tinylog.pattern.Token
    public void apply(LogEntry logEntry, PreparedStatement preparedStatement, int i) throws SQLException {
        preparedStatement.setLong(i, getTime(logEntry));
    }

    private long getTime(LogEntry logEntry) {
        long time = logEntry.getTimestamp().toDate().getTime();
        return this.useMilliseconds ? time : time / 1000;
    }
}
