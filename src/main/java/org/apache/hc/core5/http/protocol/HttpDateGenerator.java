package org.apache.hc.core5.http.protocol;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.TimeZone;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.commons.lang3.time.TimeZones;

/* JADX INFO: loaded from: classes5.dex */
public class HttpDateGenerator {

    @Deprecated
    public static final TimeZone GMT = TimeZone.getTimeZone(TimeZones.GMT_ID);
    public static final ZoneId GMT_ID;
    private static final int GRANULARITY_MILLIS = 1000;
    public static final HttpDateGenerator INSTANCE;
    public static final String INTERNET_MESSAGE_FORMAT = "EEE, dd MMM yyyy HH:mm:ss zzz";

    @Deprecated
    public static final String PATTERN_RFC1123 = "EEE, dd MMM yyyy HH:mm:ss zzz";
    private long dateAsMillis;
    private String dateAsText;
    private final DateTimeFormatter dateTimeFormatter;
    private final ReentrantLock lock = new ReentrantLock();
    private ZoneId zoneId;

    static {
        ZoneId zoneIdOf = ZoneId.of(TimeZones.GMT_ID);
        GMT_ID = zoneIdOf;
        INSTANCE = new HttpDateGenerator("EEE, dd MMM yyyy HH:mm:ss zzz", zoneIdOf);
    }

    private HttpDateGenerator(String str, ZoneId zoneId) {
        this.dateTimeFormatter = new DateTimeFormatterBuilder().parseLenient().parseCaseInsensitive().appendPattern(str).toFormatter();
        this.zoneId = zoneId;
    }

    public String getCurrentDate() {
        this.lock.lock();
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.dateAsMillis > 1000) {
                this.dateAsText = this.dateTimeFormatter.format(Instant.now().atZone(this.zoneId));
                this.dateAsMillis = jCurrentTimeMillis;
            }
            return this.dateAsText;
        } finally {
            this.lock.unlock();
        }
    }
}
