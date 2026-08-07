package org.tinylog.pattern;

import com.microsoft.identity.client.internal.MsalUtils;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import org.tinylog.core.LogEntry;
import org.tinylog.core.LogEntryValue;

/* JADX INFO: loaded from: classes5.dex */
final class ThreadIdToken implements Token {
    ThreadIdToken() {
    }

    @Override // org.tinylog.pattern.Token
    public Collection<LogEntryValue> getRequiredLogEntryValues() {
        return Collections.singleton(LogEntryValue.THREAD);
    }

    @Override // org.tinylog.pattern.Token
    public void render(LogEntry logEntry, StringBuilder sb) {
        Thread thread = logEntry.getThread();
        sb.append(thread == null ? MsalUtils.QUERY_STRING_SYMBOL : Long.valueOf(thread.getId()));
    }

    @Override // org.tinylog.pattern.Token
    public void apply(LogEntry logEntry, PreparedStatement preparedStatement, int i) throws SQLException {
        Thread thread = logEntry.getThread();
        if (thread == null) {
            preparedStatement.setNull(i, -5);
        } else {
            preparedStatement.setLong(i, thread.getId());
        }
    }
}
