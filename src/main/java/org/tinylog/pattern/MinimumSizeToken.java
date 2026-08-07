package org.tinylog.pattern;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import org.tinylog.core.LogEntry;
import org.tinylog.core.LogEntryValue;

/* JADX INFO: loaded from: classes5.dex */
class MinimumSizeToken implements Token {
    private final int minimumSize;
    private final Token token;

    MinimumSizeToken(Token token, int i) {
        this.token = token;
        this.minimumSize = i;
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
        for (int i = 0; i < this.minimumSize - length2; i++) {
            sb.append(' ');
        }
    }

    @Override // org.tinylog.pattern.Token
    public void apply(LogEntry logEntry, PreparedStatement preparedStatement, int i) throws SQLException {
        StringBuilder sb = new StringBuilder();
        render(logEntry, sb);
        preparedStatement.setString(i, sb.toString());
    }
}
