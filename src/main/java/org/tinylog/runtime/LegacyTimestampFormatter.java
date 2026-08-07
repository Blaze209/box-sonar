package org.tinylog.runtime;

import androidx.exifinterface.media.ExifInterface;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public final class LegacyTimestampFormatter implements TimestampFormatter {
    private static final int MILLISECOND_PRECISION = 1;
    private static final int MINUTE_PRECISION = 60000;
    private static final int SECOND_PRECISION = 1000;
    private final long divisor;
    private final DateFormat formatter;
    private Date lastDate;
    private String lastFormat;

    public LegacyTimestampFormatter(String str, Locale locale) {
        this.formatter = new SimpleDateFormat(str, locale);
        this.divisor = str.contains(ExifInterface.LATITUDE_SOUTH) ? 1L : str.contains("s") ? 1000L : 60000L;
    }

    @Override // org.tinylog.runtime.TimestampFormatter
    public boolean isValid(String str) {
        try {
            parse(str);
            return true;
        } catch (ParseException unused) {
            return false;
        }
    }

    @Override // org.tinylog.runtime.TimestampFormatter
    public String format(Timestamp timestamp) {
        return format(timestamp.toDate());
    }

    private String format(Date date) {
        String str;
        synchronized (this.formatter) {
            if (this.lastDate == null || date.getTime() / this.divisor != this.lastDate.getTime() / this.divisor) {
                this.lastDate = date;
                this.lastFormat = this.formatter.format(date);
            }
            str = this.lastFormat;
        }
        return str;
    }

    private Date parse(String str) throws ParseException {
        Date date;
        synchronized (this.formatter) {
            date = this.formatter.parse(str);
        }
        return date;
    }
}
