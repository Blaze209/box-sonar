package org.tinylog.pattern;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import org.tinylog.core.LogEntry;
import org.tinylog.core.LogEntryValue;

/* JADX INFO: loaded from: classes5.dex */
final class SimpleClassNameToken implements Token {
    SimpleClassNameToken() {
    }

    @Override // org.tinylog.pattern.Token
    public Collection<LogEntryValue> getRequiredLogEntryValues() {
        return Collections.singleton(LogEntryValue.CLASS);
    }

    @Override // org.tinylog.pattern.Token
    public void render(LogEntry logEntry, StringBuilder sb) {
        sb.append(getSimpleClassName(logEntry.getClassName()));
    }

    @Override // org.tinylog.pattern.Token
    public void apply(LogEntry logEntry, PreparedStatement preparedStatement, int i) throws SQLException {
        preparedStatement.setString(i, getSimpleClassName(logEntry.getClassName()));
    }

    private static String getSimpleClassName(String str) {
        if (str == null) {
            return null;
        }
        int iLastIndexOf = str.lastIndexOf(46);
        return iLastIndexOf < 0 ? str : str.substring(iLastIndexOf + 1);
    }
}
