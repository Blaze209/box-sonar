package org.tinylog.writers;

import java.util.Collection;
import java.util.Map;
import org.tinylog.core.LogEntry;
import org.tinylog.core.LogEntryValue;
import org.tinylog.pattern.FormatPatternParser;
import org.tinylog.pattern.Token;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractFormatPatternWriter extends AbstractFileBasedWriter {
    private static final int BUILDER_CAPACITY = 1024;
    private static final String DEFAULT_FORMAT_PATTERN = "{date} [{thread}] {class}.{method}()\n{level}: {message}";
    private static final String NEW_LINE = System.getProperty("line.separator");
    private final StringBuilder builder;
    private final Token token;

    public AbstractFormatPatternWriter(Map<String, String> map) {
        super(map);
        String stringValue = getStringValue("format");
        this.token = new FormatPatternParser(getStringValue("exception")).parse((stringValue == null ? DEFAULT_FORMAT_PATTERN : stringValue) + NEW_LINE);
        this.builder = getBooleanValue("writingthread") ? new StringBuilder(1024) : null;
    }

    @Override // org.tinylog.writers.Writer
    public Collection<LogEntryValue> getRequiredLogEntryValues() {
        return this.token.getRequiredLogEntryValues();
    }

    protected final String render(LogEntry logEntry) {
        StringBuilder sb = this.builder;
        if (sb == null) {
            StringBuilder sb2 = new StringBuilder(1024);
            this.token.render(logEntry, sb2);
            return sb2.toString();
        }
        sb.setLength(0);
        this.token.render(logEntry, this.builder);
        return this.builder.toString();
    }
}
