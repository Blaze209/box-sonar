package org.apache.hc.core5.util;

import java.text.ParseException;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public class Deadline {
    private static final long INTERNAL_MAX_VALUE = Long.MAX_VALUE;
    private static final long INTERNAL_MIN_VALUE = 0;
    private volatile boolean frozen;
    private volatile long lastCheck;
    private final long value;
    public static Deadline MAX_VALUE = new Deadline(Long.MAX_VALUE);
    public static Deadline MIN_VALUE = new Deadline(0);
    public static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder().parseLenient().parseCaseInsensitive().appendPattern(DATE_FORMAT).toFormatter();

    public static Deadline calculate(long j, TimeValue timeValue) {
        if (TimeValue.isPositive(timeValue)) {
            long milliseconds = j + timeValue.toMilliseconds();
            return milliseconds < 0 ? MAX_VALUE : fromUnixMilliseconds(milliseconds);
        }
        return MAX_VALUE;
    }

    public static Deadline calculate(TimeValue timeValue) {
        return calculate(System.currentTimeMillis(), timeValue);
    }

    public static Deadline fromUnixMilliseconds(long j) {
        if (j == Long.MAX_VALUE) {
            return MAX_VALUE;
        }
        if (j == 0) {
            return MIN_VALUE;
        }
        return new Deadline(j);
    }

    public static Deadline parse(String str) throws ParseException {
        if (str == null) {
            return null;
        }
        return fromUnixMilliseconds(Instant.from(DATE_TIME_FORMATTER.parse(str)).toEpochMilli());
    }

    private Deadline(long j) {
        this.value = j;
        setLastCheck();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.value == ((Deadline) obj).value;
    }

    public int hashCode() {
        return Long.hashCode(this.value);
    }

    public String format(TimeUnit timeUnit) {
        if (this.value == MAX_VALUE.value) {
            return "No deadline (infinite)";
        }
        return String.format("Deadline: %s, %s overdue", formatTarget(), TimeValue.of(remaining(), timeUnit));
    }

    public String formatTarget() {
        long j = this.value;
        if (j == MAX_VALUE.value) {
            return "(infinite)";
        }
        return DATE_TIME_FORMATTER.format(Instant.ofEpochMilli(j).atOffset(ZoneOffset.UTC));
    }

    public Deadline freeze() {
        this.frozen = true;
        return this;
    }

    long getLastCheck() {
        return this.lastCheck;
    }

    public long getValue() {
        return this.value;
    }

    public boolean isBefore(long j) {
        return this.value < j;
    }

    public boolean isExpired() {
        setLastCheck();
        return this.value < this.lastCheck;
    }

    public boolean isMax() {
        return this.value == Long.MAX_VALUE;
    }

    public boolean isMin() {
        return this.value == 0;
    }

    public boolean isNotExpired() {
        setLastCheck();
        return this.value >= this.lastCheck;
    }

    public Deadline min(Deadline deadline) {
        return this.value <= deadline.value ? this : deadline;
    }

    public long remaining() {
        setLastCheck();
        return this.value - this.lastCheck;
    }

    public TimeValue remainingTimeValue() {
        return TimeValue.of(remaining(), TimeUnit.MILLISECONDS);
    }

    private void setLastCheck() {
        if (this.frozen) {
            return;
        }
        this.lastCheck = System.currentTimeMillis();
    }

    public String toString() {
        return formatTarget();
    }
}
