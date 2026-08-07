package org.tinylog.pattern;

import com.microsoft.identity.client.internal.MsalUtils;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import org.tinylog.core.LogEntry;
import org.tinylog.core.LogEntryValue;

/* JADX INFO: loaded from: classes5.dex */
final class LineNumberToken implements Token {
    LineNumberToken() {
    }

    @Override // org.tinylog.pattern.Token
    public Collection<LogEntryValue> getRequiredLogEntryValues() {
        return Collections.singleton(LogEntryValue.LINE);
    }

    @Override // org.tinylog.pattern.Token
    public void render(LogEntry logEntry, StringBuilder sb) {
        int lineNumber = logEntry.getLineNumber();
        if (lineNumber >= 0) {
            sb.append(lineNumber);
        } else {
            sb.append(MsalUtils.QUERY_STRING_SYMBOL);
        }
    }

    @Override // org.tinylog.pattern.Token
    public void apply(LogEntry logEntry, PreparedStatement preparedStatement, int i) throws SQLException {
        int lineNumber = logEntry.getLineNumber();
        if (lineNumber >= 0) {
            preparedStatement.setInt(i, lineNumber);
        } else {
            preparedStatement.setNull(i, 4);
        }
    }
}
