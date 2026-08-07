package org.tinylog.path;

import java.util.Locale;
import org.tinylog.configuration.Configuration;
import org.tinylog.runtime.RuntimeProvider;
import org.tinylog.runtime.Timestamp;
import org.tinylog.runtime.TimestampFormatter;

/* JADX INFO: loaded from: classes5.dex */
final class DateSegment implements Segment {
    private static final Locale locale = Configuration.getLocale();
    private final TimestampFormatter formatter;

    @Override // org.tinylog.path.Segment
    public String getStaticText() {
        return null;
    }

    DateSegment(String str) {
        this.formatter = RuntimeProvider.createTimestampFormatter(str, locale);
    }

    @Override // org.tinylog.path.Segment
    public boolean validateToken(String str) {
        return this.formatter.isValid(str);
    }

    @Override // org.tinylog.path.Segment
    public String createToken(String str, Timestamp timestamp) {
        return this.formatter.format(timestamp);
    }
}
