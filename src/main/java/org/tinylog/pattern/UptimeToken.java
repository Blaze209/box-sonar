package org.tinylog.pattern;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.tinylog.core.LogEntry;
import org.tinylog.core.LogEntryValue;
import org.tinylog.runtime.RuntimeProvider;

/* JADX INFO: loaded from: classes5.dex */
final class UptimeToken implements Token {
    private static final long DAY_IN_NANOS = 86400000000000L;
    private static final long DECIMAL_BASE = 10;
    private static final String DEFAULT_PATTERN = "HH:mm:ss";
    private static final long HOUR_IN_NANOS = 3600000000000L;
    private static final long MAX_FRACTION_DIGITS = 9;
    private static final long MAX_HOUR = 24;
    private static final long MAX_MINUTE = 60;
    private static final long MAX_SECOND = 60;
    private static final long MINUTE_IN_NANOS = 60000000000L;
    private static final long SECOND_IN_NANOS = 1000000000;
    private final boolean formatted;
    private final List<Segment> segments;

    private interface Segment {
        void render(StringBuilder sb, long j);
    }

    UptimeToken() {
        this.formatted = false;
        this.segments = parse(DEFAULT_PATTERN);
    }

    UptimeToken(String str) {
        this.formatted = true;
        this.segments = parse(str);
    }

    @Override // org.tinylog.pattern.Token
    public Collection<LogEntryValue> getRequiredLogEntryValues() {
        return Collections.singletonList(LogEntryValue.DATE);
    }

    @Override // org.tinylog.pattern.Token
    public void render(LogEntry logEntry, StringBuilder sb) {
        format(sb, logEntry.getTimestamp().calcDifferenceInNanoseconds(RuntimeProvider.getStartTime()));
    }

    @Override // org.tinylog.pattern.Token
    public void apply(LogEntry logEntry, PreparedStatement preparedStatement, int i) throws SQLException {
        long jCalcDifferenceInNanoseconds = logEntry.getTimestamp().calcDifferenceInNanoseconds(RuntimeProvider.getStartTime());
        if (this.formatted) {
            StringBuilder sb = new StringBuilder();
            format(sb, jCalcDifferenceInNanoseconds);
            preparedStatement.setString(i, sb.toString());
            return;
        }
        preparedStatement.setLong(i, jCalcDifferenceInNanoseconds);
    }

    private static List<Segment> parse(String str) {
        ArrayList arrayList = new ArrayList();
        long jMax = 1;
        int i = 0;
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            int iCount = count(str, i, cCharAt);
            if (cCharAt != '\'') {
                if (cCharAt == 'H') {
                    arrayList.add(new TimeSegment(iCount, HOUR_IN_NANOS, MAX_HOUR));
                    jMax = Math.max(jMax, HOUR_IN_NANOS);
                } else if (cCharAt == 'S') {
                    long j = iCount;
                    long jPow = (long) Math.pow(10.0d, Math.max(0L, 9 - j));
                    arrayList.add(new TimeSegment(iCount, jPow, (long) Math.pow(10.0d, Math.min(9L, j))));
                    jMax = Math.max(jMax, jPow);
                } else if (cCharAt == 'd') {
                    arrayList.add(new TimeSegment(iCount, DAY_IN_NANOS, 0L));
                    jMax = Math.max(jMax, DAY_IN_NANOS);
                } else if (cCharAt == 'm') {
                    arrayList.add(new TimeSegment(iCount, MINUTE_IN_NANOS, 60L));
                    jMax = Math.max(jMax, MINUTE_IN_NANOS);
                } else if (cCharAt == 's') {
                    arrayList.add(new TimeSegment(iCount, 1000000000L, 60L));
                    jMax = Math.max(jMax, 1000000000L);
                } else {
                    arrayList.add(new StringSegment(Character.toString(cCharAt)));
                }
                i += iCount - 1;
            } else {
                int i2 = i + 1;
                int iIndexOf = str.indexOf(39, i2);
                if (iIndexOf == -1) {
                    arrayList.add(new StringSegment("'"));
                } else if (iIndexOf == i2) {
                    arrayList.add(new StringSegment("'"));
                    i = i2;
                } else {
                    arrayList.add(new StringSegment(str.substring(i2, iIndexOf)));
                    i = iIndexOf;
                }
            }
            i++;
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            Segment segment = (Segment) arrayList.get(i3);
            if (segment instanceof TimeSegment) {
                TimeSegment timeSegment = (TimeSegment) segment;
                if (timeSegment.divisor == jMax) {
                    arrayList.set(i3, new TimeSegment(timeSegment.digits, timeSegment.divisor, 0L));
                }
            }
        }
        return arrayList;
    }

    private static int count(String str, int i, char c) {
        int i2 = i;
        while (i2 < str.length() && str.charAt(i2) == c) {
            i2++;
        }
        return i2 - i;
    }

    private void format(StringBuilder sb, long j) {
        Iterator<Segment> it = this.segments.iterator();
        while (it.hasNext()) {
            it.next().render(sb, j);
        }
    }

    private static class StringSegment implements Segment {
        private final String text;

        StringSegment(String str) {
            this.text = str;
        }

        @Override // org.tinylog.pattern.UptimeToken.Segment
        public void render(StringBuilder sb, long j) {
            sb.append(this.text);
        }
    }

    private static class TimeSegment implements Segment {
        private final int digits;
        private final long divisor;
        private final long modulus;

        TimeSegment(int i, long j, long j2) {
            this.digits = i;
            this.divisor = j;
            this.modulus = j2;
        }

        @Override // org.tinylog.pattern.UptimeToken.Segment
        public void render(StringBuilder sb, long j) {
            long j2 = j / this.divisor;
            long j3 = this.modulus;
            if (j3 > 0) {
                j2 %= j3;
            }
            String string = Long.toString(j2);
            for (int i = 0; i < this.digits - string.length(); i++) {
                sb.append('0');
            }
            sb.append(string);
        }
    }
}
