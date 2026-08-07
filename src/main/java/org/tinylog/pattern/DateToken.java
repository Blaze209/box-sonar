package org.tinylog.pattern;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.Locale;
import org.tinylog.configuration.Configuration;
import org.tinylog.core.LogEntry;
import org.tinylog.core.LogEntryValue;
import org.tinylog.runtime.RuntimeProvider;
import org.tinylog.runtime.TimestampFormatter;

/* JADX INFO: loaded from: classes5.dex */
final class DateToken implements Token {
    private static final String DEFAULT_DATE_FORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private static final Locale locale = Configuration.getLocale();
    private final boolean formatted;
    private final TimestampFormatter formatter;

    DateToken() {
        this.formatted = false;
        this.formatter = RuntimeProvider.createTimestampFormatter("yyyy-MM-dd HH:mm:ss", locale);
    }

    DateToken(String str) {
        this.formatted = true;
        this.formatter = RuntimeProvider.createTimestampFormatter(str, locale);
    }

    @Override // org.tinylog.pattern.Token
    public Collection<LogEntryValue> getRequiredLogEntryValues() {
        return Collections.singletonList(LogEntryValue.DATE);
    }

    @Override // org.tinylog.pattern.Token
    public void render(LogEntry logEntry, StringBuilder sb) {
        sb.append(this.formatter.format(logEntry.getTimestamp()));
    }

    @Override // org.tinylog.pattern.Token
    public void apply(LogEntry logEntry, PreparedStatement preparedStatement, int i) throws SQLException {
        if (this.formatted) {
            preparedStatement.setString(i, this.formatter.format(logEntry.getTimestamp()));
        } else {
            preparedStatement.setTimestamp(i, logEntry.getTimestamp().toSqlTimestamp());
        }
    }
}
