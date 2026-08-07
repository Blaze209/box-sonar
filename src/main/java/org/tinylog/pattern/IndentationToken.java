package org.tinylog.pattern;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;
import org.tinylog.core.LogEntry;
import org.tinylog.core.LogEntryValue;

/* JADX INFO: loaded from: classes5.dex */
class IndentationToken implements Token {
    private static final int INITIAL_CAPACITY = 1024;
    private static final String NEW_LINE = System.getProperty("line.separator");
    private final char[] spaces;
    private final Token token;

    IndentationToken(Token token, int i) {
        this.token = token;
        char[] cArr = new char[i];
        this.spaces = cArr;
        Arrays.fill(cArr, ' ');
    }

    @Override // org.tinylog.pattern.Token
    public Collection<LogEntryValue> getRequiredLogEntryValues() {
        return this.token.getRequiredLogEntryValues();
    }

    @Override // org.tinylog.pattern.Token
    public void render(LogEntry logEntry, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder(1024);
        this.token.render(logEntry, sb2);
        String str = NEW_LINE;
        int i = 0;
        while (true) {
            int iIndexOf = sb2.indexOf(str, i);
            if (iIndexOf != -1) {
                String str2 = NEW_LINE;
                sb.append((CharSequence) sb2, i, str2.length() + iIndexOf);
                int length = iIndexOf + str2.length();
                if (length < sb2.length()) {
                    sb.append(this.spaces);
                    while (length < sb2.length() && sb2.charAt(length) == '\t') {
                        sb.append(this.spaces);
                        length++;
                    }
                }
                i = length;
                str = NEW_LINE;
            } else {
                sb.append((CharSequence) sb2, i, sb2.length());
                return;
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
