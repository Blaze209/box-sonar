package org.tinylog.pattern;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import org.tinylog.core.LogEntry;
import org.tinylog.core.LogEntryValue;

/* JADX INFO: loaded from: classes5.dex */
final class MessageToken implements Token {
    private static final String NEW_LINE = System.getProperty("line.separator");

    MessageToken() {
    }

    @Override // org.tinylog.pattern.Token
    public Collection<LogEntryValue> getRequiredLogEntryValues() {
        return Collections.singleton(LogEntryValue.MESSAGE);
    }

    @Override // org.tinylog.pattern.Token
    public void render(LogEntry logEntry, StringBuilder sb) {
        String message = logEntry.getMessage();
        if (message == null) {
            return;
        }
        int iIndexOf = message.indexOf(13);
        int iIndexOf2 = message.indexOf(10);
        int i = 0;
        while (true) {
            if (iIndexOf >= 0 && (iIndexOf2 < 0 || iIndexOf < iIndexOf2)) {
                sb.append((CharSequence) message, i, iIndexOf);
                sb.append(NEW_LINE);
                i = iIndexOf + 1;
                iIndexOf = message.indexOf(13, i);
            } else if (iIndexOf2 >= 0) {
                if (i == 0 || message.charAt(i - 1) != '\r') {
                    sb.append((CharSequence) message, i, iIndexOf2);
                    sb.append(NEW_LINE);
                }
                i = iIndexOf2 + 1;
                iIndexOf2 = message.indexOf(10, i);
            } else {
                sb.append((CharSequence) message, i, message.length());
                return;
            }
        }
    }

    @Override // org.tinylog.pattern.Token
    public void apply(LogEntry logEntry, PreparedStatement preparedStatement, int i) throws SQLException {
        preparedStatement.setString(i, logEntry.getMessage());
    }
}
