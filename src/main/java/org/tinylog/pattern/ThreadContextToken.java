package org.tinylog.pattern;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import org.tinylog.core.LogEntry;
import org.tinylog.core.LogEntryValue;

/* JADX INFO: loaded from: classes5.dex */
final class ThreadContextToken implements Token {
    private static final String DEFAULT_EMPTY_VALUE = "";
    private final String defaultValue;
    private final String key;

    ThreadContextToken(String str) {
        this.key = str;
        this.defaultValue = "";
    }

    ThreadContextToken(String str, String str2) {
        this.key = str;
        this.defaultValue = str2;
    }

    @Override // org.tinylog.pattern.Token
    public Collection<LogEntryValue> getRequiredLogEntryValues() {
        return Collections.singletonList(LogEntryValue.CONTEXT);
    }

    @Override // org.tinylog.pattern.Token
    public void render(LogEntry logEntry, StringBuilder sb) {
        String str = logEntry.getContext().get(this.key);
        if (str == null) {
            sb.append(this.defaultValue);
        } else {
            sb.append(str);
        }
    }

    @Override // org.tinylog.pattern.Token
    public void apply(LogEntry logEntry, PreparedStatement preparedStatement, int i) throws SQLException {
        String str = logEntry.getContext().get(this.key);
        if (str == null && !"".equals(this.defaultValue)) {
            preparedStatement.setString(i, this.defaultValue);
        } else {
            preparedStatement.setString(i, str);
        }
    }
}
