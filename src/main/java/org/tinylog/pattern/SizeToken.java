package org.tinylog.pattern;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import org.tinylog.core.LogEntry;
import org.tinylog.core.LogEntryValue;

/* JADX INFO: loaded from: classes5.dex */
class SizeToken implements Token {
    private final int size;
    private final Token token;

    SizeToken(Token token, int i) {
        this.token = token;
        this.size = i;
    }

    @Override // org.tinylog.pattern.Token
    public Collection<LogEntryValue> getRequiredLogEntryValues() {
        return this.token.getRequiredLogEntryValues();
    }

    @Override // org.tinylog.pattern.Token
    public void render(LogEntry logEntry, StringBuilder sb) {
        int length = sb.length();
        this.token.render(logEntry, sb);
        int length2 = sb.length() - length;
        int i = this.size;
        if (length2 > i) {
            sb.delete(length, (length + length2) - i);
        }
        if (length2 < this.size) {
            for (int i2 = 0; i2 < this.size - length2; i2++) {
                sb.append(' ');
            }
        }
    }

    @Override // org.tinylog.pattern.Token
    public void apply(LogEntry logEntry, PreparedStatement preparedStatement, int i) throws SQLException {
        StringBuilder sb = new StringBuilder();
        render(logEntry, sb);
        preparedStatement.setString(i, sb.toString());
    }
}
