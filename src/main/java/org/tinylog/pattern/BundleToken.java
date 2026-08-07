package org.tinylog.pattern;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.EnumSet;
import org.tinylog.core.LogEntry;
import org.tinylog.core.LogEntryValue;

/* JADX INFO: loaded from: classes5.dex */
final class BundleToken implements Token {
    private final Token[] tokens;

    BundleToken(Collection<Token> collection) {
        this.tokens = (Token[]) collection.toArray(new Token[0]);
    }

    @Override // org.tinylog.pattern.Token
    public Collection<LogEntryValue> getRequiredLogEntryValues() {
        EnumSet enumSetNoneOf = EnumSet.noneOf(LogEntryValue.class);
        for (Token token : this.tokens) {
            enumSetNoneOf.addAll(token.getRequiredLogEntryValues());
        }
        return enumSetNoneOf;
    }

    @Override // org.tinylog.pattern.Token
    public void render(LogEntry logEntry, StringBuilder sb) {
        int i = 0;
        while (true) {
            Token[] tokenArr = this.tokens;
            if (i >= tokenArr.length) {
                return;
            }
            tokenArr[i].render(logEntry, sb);
            i++;
        }
    }

    @Override // org.tinylog.pattern.Token
    public void apply(LogEntry logEntry, PreparedStatement preparedStatement, int i) throws SQLException {
        StringBuilder sb = new StringBuilder();
        render(logEntry, sb);
        preparedStatement.setString(i, sb.toString());
    }
}
