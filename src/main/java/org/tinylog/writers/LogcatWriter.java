package org.tinylog.writers;

import android.util.Log;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Map;
import org.tinylog.Level;
import org.tinylog.core.LogEntry;
import org.tinylog.core.LogEntryValue;
import org.tinylog.pattern.FormatPatternParser;
import org.tinylog.pattern.Token;
import org.tinylog.provider.InternalLogger;

/* JADX INFO: loaded from: classes5.dex */
public final class LogcatWriter extends AbstractWriter {
    private static final String DEFAULT_MESSAGE_FORMAT_PATTERN = "{message}";
    private static final String DEFAULT_TAG_FORMAT_PATTERN = "{class-name}";
    private static final String ELLIPSIS = "...";
    private static final int MESSAGE_BUILDER_CAPACITY = 1024;
    private static final int TAG_MAX_LENGTH = 23;
    private final StringBuilder messageBuilder;
    private final Token messageToken;
    private final StringBuilder tagBuilder;
    private final Token tagToken;

    @Override // org.tinylog.writers.Writer
    public void close() {
    }

    @Override // org.tinylog.writers.Writer
    public void flush() {
    }

    public LogcatWriter() {
        this(Collections.emptyMap());
    }

    public LogcatWriter(Map<String, String> map) {
        super(map);
        FormatPatternParser formatPatternParser = new FormatPatternParser(getStringValue("exception"));
        boolean booleanValue = getBooleanValue("writingthread");
        String stringValue = getStringValue("tagname");
        this.tagToken = formatPatternParser.parse(stringValue == null ? DEFAULT_TAG_FORMAT_PATTERN : stringValue);
        this.tagBuilder = booleanValue ? new StringBuilder(23) : null;
        String str = map.get("format");
        this.messageToken = formatPatternParser.parse(str == null ? DEFAULT_MESSAGE_FORMAT_PATTERN : str);
        this.messageBuilder = booleanValue ? new StringBuilder(1024) : null;
    }

    @Override // org.tinylog.writers.Writer
    public Collection<LogEntryValue> getRequiredLogEntryValues() {
        EnumSet enumSetOf = EnumSet.of(LogEntryValue.LEVEL);
        enumSetOf.addAll(this.tagToken.getRequiredLogEntryValues());
        enumSetOf.addAll(this.messageToken.getRequiredLogEntryValues());
        return enumSetOf;
    }

    @Override // org.tinylog.writers.Writer
    public void write(LogEntry logEntry) {
        String strRenderTag = renderTag(logEntry);
        String strRenderMessage = renderMessage(logEntry);
        int i = AnonymousClass1.$SwitchMap$org$tinylog$Level[logEntry.getLevel().ordinal()];
        if (i == 1) {
            Log.println(2, strRenderTag, strRenderMessage);
            return;
        }
        if (i == 2) {
            Log.println(3, strRenderTag, strRenderMessage);
            return;
        }
        if (i == 3) {
            Log.println(4, strRenderTag, strRenderMessage);
            return;
        }
        if (i == 4) {
            Log.println(5, strRenderTag, strRenderMessage);
        } else if (i == 5) {
            Log.println(6, strRenderTag, strRenderMessage);
        } else {
            InternalLogger.log(Level.ERROR, "Unexpected logging level: " + logEntry.getLevel());
        }
    }

    /* JADX INFO: renamed from: org.tinylog.writers.LogcatWriter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$tinylog$Level;

        static {
            int[] iArr = new int[Level.values().length];
            $SwitchMap$org$tinylog$Level = iArr;
            try {
                iArr[Level.TRACE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$tinylog$Level[Level.DEBUG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$tinylog$Level[Level.INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$tinylog$Level[Level.WARN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$tinylog$Level[Level.ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private String renderTag(LogEntry logEntry) {
        StringBuilder sbReuseOrCreate = reuseOrCreate(this.tagBuilder, 23);
        this.tagToken.render(logEntry, sbReuseOrCreate);
        if (sbReuseOrCreate.length() > 23) {
            return sbReuseOrCreate.substring(0, 23 - ELLIPSIS.length()) + ELLIPSIS;
        }
        return sbReuseOrCreate.toString();
    }

    private String renderMessage(LogEntry logEntry) {
        StringBuilder sbReuseOrCreate = reuseOrCreate(this.messageBuilder, 1024);
        this.messageToken.render(logEntry, sbReuseOrCreate);
        return sbReuseOrCreate.toString();
    }

    private static StringBuilder reuseOrCreate(StringBuilder sb, int i) {
        if (sb == null) {
            return new StringBuilder(i);
        }
        sb.setLength(0);
        return sb;
    }
}
