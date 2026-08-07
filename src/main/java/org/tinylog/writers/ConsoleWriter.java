package org.tinylog.writers;

import androidx.core.app.NotificationCompat;
import com.box.android.data.mappers.annotation.CommentEntityDomainMapper;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import org.tinylog.Level;
import org.tinylog.core.ConfigurationParser;
import org.tinylog.core.LogEntry;
import org.tinylog.core.LogEntryValue;
import org.tinylog.provider.InternalLogger;

/* JADX INFO: loaded from: classes5.dex */
public final class ConsoleWriter extends AbstractFormatPatternWriter {
    private final Level errorLevel;

    @Override // org.tinylog.writers.Writer
    public void close() {
    }

    @Override // org.tinylog.writers.Writer
    public void flush() {
    }

    public ConsoleWriter() {
        this(Collections.emptyMap());
    }

    public ConsoleWriter(Map<String, String> map) {
        super(map);
        Level level = Level.WARN;
        String stringValue = getStringValue("stream");
        if (stringValue != null) {
            String[] strArrSplit = stringValue.split(CommentEntityDomainMapper.MENTIONS_SYMBOL, 2);
            if (strArrSplit.length == 2) {
                level = ConfigurationParser.parse(strArrSplit[1], level);
                if (!strArrSplit[0].equals(NotificationCompat.CATEGORY_ERROR)) {
                    InternalLogger.log(Level.ERROR, "Stream with level must be \"err\", \"" + strArrSplit[0] + "\" is an invalid name");
                }
                stringValue = null;
            }
        }
        if (stringValue == null) {
            this.errorLevel = level;
            return;
        }
        if (NotificationCompat.CATEGORY_ERROR.equalsIgnoreCase(stringValue)) {
            this.errorLevel = Level.TRACE;
        } else if ("out".equalsIgnoreCase(stringValue)) {
            this.errorLevel = Level.OFF;
        } else {
            InternalLogger.log(Level.ERROR, "Stream must be \"out\" or \"err\", \"" + stringValue + "\" is an invalid stream name");
            this.errorLevel = level;
        }
    }

    @Override // org.tinylog.writers.AbstractFormatPatternWriter, org.tinylog.writers.Writer
    public Collection<LogEntryValue> getRequiredLogEntryValues() {
        Collection<LogEntryValue> requiredLogEntryValues = super.getRequiredLogEntryValues();
        requiredLogEntryValues.add(LogEntryValue.LEVEL);
        return requiredLogEntryValues;
    }

    @Override // org.tinylog.writers.Writer
    public void write(LogEntry logEntry) {
        if (logEntry.getLevel().ordinal() < this.errorLevel.ordinal()) {
            System.out.print(render(logEntry));
        } else {
            System.err.print(render(logEntry));
        }
    }
}
