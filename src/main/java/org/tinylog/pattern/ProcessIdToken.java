package org.tinylog.pattern;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import org.tinylog.core.LogEntry;
import org.tinylog.core.LogEntryValue;
import org.tinylog.runtime.RuntimeProvider;

/* JADX INFO: loaded from: classes5.dex */
final class ProcessIdToken implements Token {
    private final long pid;
    private final String rendered;

    ProcessIdToken() {
        long processId = RuntimeProvider.getProcessId();
        this.pid = processId;
        this.rendered = Long.toString(processId);
    }

    @Override // org.tinylog.pattern.Token
    public Collection<LogEntryValue> getRequiredLogEntryValues() {
        return Collections.emptySet();
    }

    @Override // org.tinylog.pattern.Token
    public void render(LogEntry logEntry, StringBuilder sb) {
        sb.append(this.rendered);
    }

    @Override // org.tinylog.pattern.Token
    public void apply(LogEntry logEntry, PreparedStatement preparedStatement, int i) throws SQLException {
        preparedStatement.setLong(i, this.pid);
    }
}
