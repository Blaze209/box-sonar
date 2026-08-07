package org.apache.hc.core5.util;

import java.text.ParseException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public class Timeout extends TimeValue {
    public static final Timeout DISABLED;
    public static final Timeout INFINITE;
    public static final Timeout ONE_MILLISECOND;
    public static final Timeout ZERO_MILLISECONDS;

    static {
        Timeout timeoutOf = of(0L, TimeUnit.MILLISECONDS);
        ZERO_MILLISECONDS = timeoutOf;
        ONE_MILLISECOND = of(1L, TimeUnit.MILLISECONDS);
        DISABLED = timeoutOf;
        INFINITE = timeoutOf;
    }

    public static Timeout defaultsToDisabled(Timeout timeout) {
        return (Timeout) defaultsTo(timeout, DISABLED);
    }

    public static Timeout defaultsToInfinite(Timeout timeout) {
        return (Timeout) defaultsTo(timeout, DISABLED);
    }

    public static Timeout of(Duration duration) {
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

    public static Timeout of(long j, TimeUnit timeUnit) {
        return new Timeout(j, timeUnit);
    }

    public static Timeout ofDays(long j) {
        return of(j, TimeUnit.DAYS);
    }

    public static Timeout ofHours(long j) {
        return of(j, TimeUnit.HOURS);
    }

    public static Timeout ofMicroseconds(long j) {
        return of(j, TimeUnit.MICROSECONDS);
    }

    public static Timeout ofMilliseconds(long j) {
        return of(j, TimeUnit.MILLISECONDS);
    }

    public static Timeout ofMinutes(long j) {
        return of(j, TimeUnit.MINUTES);
    }

    public static Timeout ofNanoseconds(long j) {
        return of(j, TimeUnit.NANOSECONDS);
    }

    public static Timeout ofSeconds(long j) {
        return of(j, TimeUnit.SECONDS);
    }

    public static Timeout parse(String str) throws ParseException {
        return TimeValue.parse(str).toTimeout();
    }

    Timeout(long j, TimeUnit timeUnit) {
        super(Args.notNegative(j, "duration"), (TimeUnit) Args.notNull(timeUnit, "timeUnit"));
    }

    public boolean isDisabled() {
        return getDuration() == 0;
    }

    public boolean isEnabled() {
        return !isDisabled();
    }
}
