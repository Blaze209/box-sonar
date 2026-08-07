package org.tinylog.runtime;

import androidx.exifinterface.media.ExifInterface;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public final class PreciseTimestampFormatter implements TimestampFormatter {
    private final DateTimeFormatter formatter;
    private String lastFormat;
    private Instant maxInstant;
    private Instant minInstant;
    private final TemporalUnit truncationUnit;

    public PreciseTimestampFormatter(String str, Locale locale) {
        this.formatter = DateTimeFormatter.ofPattern(str, locale).withZone(ZoneId.systemDefault());
        if (str.contains("n") || str.contains("N") || str.contains("SSSS")) {
            this.truncationUnit = null;
        } else if (str.contains(ExifInterface.LATITUDE_SOUTH)) {
            this.truncationUnit = ChronoUnit.MILLIS;
        } else if (str.contains("s")) {
            this.truncationUnit = ChronoUnit.SECONDS;
        } else {
            this.truncationUnit = ChronoUnit.MINUTES;
        }
        this.minInstant = Instant.MAX;
        this.maxInstant = Instant.MIN;
    }

    @Override // org.tinylog.runtime.TimestampFormatter
    public boolean isValid(String str) {
        try {
            this.formatter.parse(str);
            return true;
        } catch (DateTimeParseException unused) {
            return false;
        }
    }

    @Override // org.tinylog.runtime.TimestampFormatter
    public String format(Timestamp timestamp) {
        Instant instant = timestamp.toInstant();
        return this.truncationUnit == null ? this.formatter.format(instant) : format(instant);
    }

    private String format(Instant instant) {
        String str;
        synchronized (this.formatter) {
            if (!instant.isBefore(this.maxInstant) || instant.isBefore(this.minInstant)) {
                Instant instantTruncatedTo = instant.truncatedTo(this.truncationUnit);
                this.minInstant = instantTruncatedTo;
                this.maxInstant = instantTruncatedTo.plus(1L, this.truncationUnit);
                this.lastFormat = this.formatter.format(instant);
            }
            str = this.lastFormat;
        }
        return str;
    }
}
