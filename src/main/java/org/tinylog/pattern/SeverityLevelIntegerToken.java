package org.tinylog.pattern;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import org.tinylog.Level;
import org.tinylog.core.LogEntry;
import org.tinylog.core.LogEntryValue;

/* JADX INFO: loaded from: classes5.dex */
final class SeverityLevelIntegerToken implements Token {
    private static final int LEVEL_COUNT = Level.OFF.ordinal();

    SeverityLevelIntegerToken() {
    }

    @Override // org.tinylog.pattern.Token
    public Collection<LogEntryValue> getRequiredLogEntryValues() {
        return Collections.singleton(LogEntryValue.LEVEL);
    }

    @Override // org.tinylog.pattern.Token
    public void render(LogEntry logEntry, StringBuilder sb) {
        sb.append(getReverseOfOrdinalAsLevelValue(logEntry));
    }

    @Override // org.tinylog.pattern.Token
    public void apply(LogEntry logEntry, PreparedStatement preparedStatement, int i) throws SQLException {
        preparedStatement.setInt(i, getReverseOfOrdinalAsLevelValue(logEntry));
    }

    private int getReverseOfOrdinalAsLevelValue(LogEntry logEntry) {
        return LEVEL_COUNT - logEntry.getLevel().ordinal();
    }
}
