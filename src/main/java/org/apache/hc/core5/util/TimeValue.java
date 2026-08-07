package org.apache.hc.core5.util;

import androidx.collection.SieveCacheKt;
import androidx.exifinterface.media.ExifInterface;
import java.text.ParseException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public class TimeValue implements Comparable<TimeValue> {
    static final int INT_UNDEFINED = -1;
    public static final TimeValue MAX_VALUE = ofDays(Long.MAX_VALUE);
    public static final TimeValue NEG_ONE_MILLISECOND = of(-1, TimeUnit.MILLISECONDS);
    public static final TimeValue NEG_ONE_SECOND = of(-1, TimeUnit.SECONDS);
    public static final TimeValue ZERO_MILLISECONDS = of(0, TimeUnit.MILLISECONDS);
    private final long duration;
    private final TimeUnit timeUnit;

    public static int asBoundInt(long j) {
        if (j > SieveCacheKt.NodeLinkMask) {
            return Integer.MAX_VALUE;
        }
        if (j < SieveCacheKt.NodeMetaAndPreviousMask) {
            return Integer.MIN_VALUE;
        }
        return (int) j;
    }

    public static <T extends TimeValue> T defaultsTo(T t, T t2) {
        return t != null ? t : t2;
    }

    public static TimeValue defaultsToNegativeOneMillisecond(TimeValue timeValue) {
        return defaultsTo(timeValue, NEG_ONE_MILLISECOND);
    }

    public static TimeValue defaultsToNegativeOneSecond(TimeValue timeValue) {
        return defaultsTo(timeValue, NEG_ONE_SECOND);
    }

    public static TimeValue defaultsToZeroMilliseconds(TimeValue timeValue) {
        return defaultsTo(timeValue, ZERO_MILLISECONDS);
    }

    public static boolean isNonNegative(TimeValue timeValue) {
        return timeValue != null && timeValue.getDuration() >= 0;
    }

    public static boolean isPositive(TimeValue timeValue) {
        return timeValue != null && timeValue.getDuration() > 0;
    }

    public static TimeValue of(long j, TimeUnit timeUnit) {
        return new TimeValue(j, timeUnit);
    }

    public static TimeValue of(Duration duration) {
        long seconds = duration.getSeconds();
        long nano = duration.getNano();
        if (seconds == 0) {
            return of(nano, TimeUnit.NANOSECONDS);
        }
        if (nano == 0) {
            return of(seconds, TimeUnit.SECONDS);
        }
        try {
            try {
                return of(duration.toNanos(), TimeUnit.NANOSECONDS);
            } catch (ArithmeticException unused) {
                return of(seconds, TimeUnit.SECONDS);
            }
        } catch (ArithmeticException unused2) {
            return of(duration.toMillis(), TimeUnit.MILLISECONDS);
        }
    }

    public static TimeValue ofDays(long j) {
        return of(j, TimeUnit.DAYS);
    }

    public static TimeValue ofHours(long j) {
        return of(j, TimeUnit.HOURS);
    }

    public static TimeValue ofMicroseconds(long j) {
        return of(j, TimeUnit.MICROSECONDS);
    }

    public static TimeValue ofMilliseconds(long j) {
        return of(j, TimeUnit.MILLISECONDS);
    }

    public static TimeValue ofMinutes(long j) {
        return of(j, TimeUnit.MINUTES);
    }

    public static TimeValue ofNanoseconds(long j) {
        return of(j, TimeUnit.NANOSECONDS);
    }

    public static TimeValue ofSeconds(long j) {
        return of(j, TimeUnit.SECONDS);
    }

    /* JADX INFO: renamed from: org.apache.hc.core5.util.TimeValue$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$util$concurrent$TimeUnit;

        static {
            int[] iArr = new int[TimeUnit.values().length];
            $SwitchMap$java$util$concurrent$TimeUnit = iArr;
            try {
                iArr[TimeUnit.NANOSECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.MICROSECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.MILLISECONDS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    static ChronoUnit toChronoUnit(TimeUnit timeUnit) {
        switch (AnonymousClass1.$SwitchMap$java$util$concurrent$TimeUnit[((TimeUnit) Objects.requireNonNull(timeUnit)).ordinal()]) {
            case 1:
                return ChronoUnit.NANOS;
            case 2:
                return ChronoUnit.MICROS;
            case 3:
                return ChronoUnit.MILLIS;
            case 4:
                return ChronoUnit.SECONDS;
            case 5:
                return ChronoUnit.MINUTES;
            case 6:
                return ChronoUnit.HOURS;
            case 7:
                return ChronoUnit.DAYS;
            default:
                throw new IllegalArgumentException(timeUnit.toString());
        }
    }

    public static TimeValue parse(String str) throws ParseException {
        String[] strArrSplit = str.trim().split("\\s+");
        if (strArrSplit.length < 2) {
            throw new IllegalArgumentException(String.format("Expected format for <Long><SPACE><java.util.concurrent.TimeUnit>: %s", str));
        }
        String strTrim = strArrSplit[0].trim();
        String upperCase = strArrSplit[1].trim().toUpperCase(Locale.ROOT);
        if (!upperCase.endsWith(ExifInterface.LATITUDE_SOUTH)) {
            upperCase = upperCase + ExifInterface.LATITUDE_SOUTH;
        }
        return of(Long.parseLong(strTrim), TimeUnit.valueOf(upperCase));
    }

    TimeValue(long j, TimeUnit timeUnit) {
        this.duration = j;
        this.timeUnit = (TimeUnit) Args.notNull(timeUnit, "timeUnit");
    }

    public long convert(TimeUnit timeUnit) {
        Args.notNull(timeUnit, "timeUnit");
        return timeUnit.convert(this.duration, this.timeUnit);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof TimeValue) && convert(TimeUnit.NANOSECONDS) == ((TimeValue) obj).convert(TimeUnit.NANOSECONDS);
    }

    public TimeValue divide(long j) {
        return of(this.duration / j, this.timeUnit);
    }

    public TimeValue divide(long j, TimeUnit timeUnit) {
        return of(convert(timeUnit) / j, timeUnit);
    }

    public long getDuration() {
        return this.duration;
    }

    public TimeUnit getTimeUnit() {
        return this.timeUnit;
    }

    public int hashCode() {
        return LangUtils.hashCode(17, Long.valueOf(convert(TimeUnit.NANOSECONDS)));
    }

    public TimeValue min(TimeValue timeValue) {
        return compareTo(timeValue) > 0 ? timeValue : this;
    }

    private TimeUnit min(TimeUnit timeUnit) {
        return scale() > scale(timeUnit) ? timeUnit : getTimeUnit();
    }

    private int scale() {
        return scale(this.timeUnit);
    }

    private int scale(TimeUnit timeUnit) {
        switch (AnonymousClass1.$SwitchMap$java$util$concurrent$TimeUnit[timeUnit.ordinal()]) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;
            case 7:
                return 7;
            default:
                throw new IllegalStateException();
        }
    }

    public void sleep() throws InterruptedException {
        this.timeUnit.sleep(this.duration);
    }

    public void timedJoin(Thread thread) throws InterruptedException {
        this.timeUnit.timedJoin(thread, this.duration);
    }

    public void timedWait(Object obj) throws InterruptedException {
        this.timeUnit.timedWait(obj, this.duration);
    }

    public long toDays() {
        return this.timeUnit.toDays(this.duration);
    }

    public Duration toDuration() {
        long j = this.duration;
        return j == 0 ? Duration.ZERO : Duration.of(j, toChronoUnit(this.timeUnit));
    }

    public long toHours() {
        return this.timeUnit.toHours(this.duration);
    }

    public long toMicroseconds() {
        return this.timeUnit.toMicros(this.duration);
    }

    public long toMilliseconds() {
        return this.timeUnit.toMillis(this.duration);
    }

    public int toMillisecondsIntBound() {
        return asBoundInt(toMilliseconds());
    }

    public long toMinutes() {
        return this.timeUnit.toMinutes(this.duration);
    }

    public long toNanoseconds() {
        return this.timeUnit.toNanos(this.duration);
    }

    public long toSeconds() {
        return this.timeUnit.toSeconds(this.duration);
    }

    public int toSecondsIntBound() {
        return asBoundInt(toSeconds());
    }

    @Override // java.lang.Comparable
    public int compareTo(TimeValue timeValue) {
        TimeUnit timeUnitMin = min(timeValue.getTimeUnit());
        return Long.compare(convert(timeUnitMin), timeValue.convert(timeUnitMin));
    }

    public String toString() {
        return String.format("%d %s", Long.valueOf(this.duration), this.timeUnit);
    }

    public Timeout toTimeout() {
        return Timeout.of(this.duration, this.timeUnit);
    }
}
