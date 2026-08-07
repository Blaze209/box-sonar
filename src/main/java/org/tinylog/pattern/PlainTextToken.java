package org.tinylog.pattern;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.regex.Pattern;
import org.tinylog.core.LogEntry;
import org.tinylog.core.LogEntryValue;

/* JADX INFO: loaded from: classes5.dex */
final class PlainTextToken implements Token {
    private final String text;
    private static final Pattern NEW_LINE_PATTERN = Pattern.compile("\r\n|\n|\r");
    private static final String NEW_LINE = System.getProperty("line.separator");

    PlainTextToken(String str) {
        this.text = NEW_LINE_PATTERN.matcher(str).replaceAll(NEW_LINE);
    }

    @Override // org.tinylog.pattern.Token
    public Collection<LogEntryValue> getRequiredLogEntryValues() {
        return Collections.emptyList();
    }

    @Override // org.tinylog.pattern.Token
    public void render(LogEntry logEntry, StringBuilder sb) {
        sb.append(this.text);
    }

    @Override // org.tinylog.pattern.Token
    public void apply(LogEntry logEntry, PreparedStatement preparedStatement, int i) throws SQLException {
        preparedStatement.setString(i, this.text);
    }
}
