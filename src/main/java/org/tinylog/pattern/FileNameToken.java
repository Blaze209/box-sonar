package org.tinylog.pattern;

import androidx.camera.core.CameraInfo;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import org.tinylog.core.LogEntry;
import org.tinylog.core.LogEntryValue;

/* JADX INFO: loaded from: classes5.dex */
final class FileNameToken implements Token {
    FileNameToken() {
    }

    @Override // org.tinylog.pattern.Token
    public Collection<LogEntryValue> getRequiredLogEntryValues() {
        return Collections.singleton(LogEntryValue.FILE);
    }

    @Override // org.tinylog.pattern.Token
    public void render(LogEntry logEntry, StringBuilder sb) {
        String fileName = logEntry.getFileName();
        if (fileName == null) {
            sb.append(CameraInfo.IMPLEMENTATION_TYPE_UNKNOWN);
        } else {
            sb.append(fileName);
        }
    }

    @Override // org.tinylog.pattern.Token
    public void apply(LogEntry logEntry, PreparedStatement preparedStatement, int i) throws SQLException {
        preparedStatement.setString(i, logEntry.getFileName());
    }
}
