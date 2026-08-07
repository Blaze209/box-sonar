package org.tinylog.pattern;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;
import org.tinylog.core.LogEntry;
import org.tinylog.core.LogEntryValue;
import org.tinylog.throwable.ThrowableFilter;

/* JADX INFO: loaded from: classes5.dex */
final class MessageAndExceptionToken implements Token {
    private final ExceptionToken exceptionToken;
    private final MessageToken messageToken = new MessageToken();

    MessageAndExceptionToken(List<ThrowableFilter> list) {
        this.exceptionToken = new ExceptionToken(list);
    }

    @Override // org.tinylog.pattern.Token
    public Collection<LogEntryValue> getRequiredLogEntryValues() {
        return EnumSet.of(LogEntryValue.MESSAGE, LogEntryValue.EXCEPTION);
    }

    @Override // org.tinylog.pattern.Token
    public void render(LogEntry logEntry, StringBuilder sb) {
        this.messageToken.render(logEntry, sb);
        if (logEntry.getException() != null) {
            if (logEntry.getMessage() != null) {
                sb.append(": ");
            }
            this.exceptionToken.render(logEntry, sb);
        }
    }

    @Override // org.tinylog.pattern.Token
    public void apply(LogEntry logEntry, PreparedStatement preparedStatement, int i) throws SQLException {
        if (logEntry.getException() == null) {
            preparedStatement.setString(i, logEntry.getMessage());
            return;
        }
        StringBuilder sb = new StringBuilder();
        render(logEntry, sb);
        preparedStatement.setString(i, sb.toString());
    }
}
