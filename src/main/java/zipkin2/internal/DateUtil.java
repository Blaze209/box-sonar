package zipkin2.internal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes6.dex */
public final class DateUtil {
    static final TimeZone UTC = TimeZone.getTimeZone("UTC");

    public static long midnightUTC(long j) {
        Calendar calendar = Calendar.getInstance(UTC);
        calendar.setTimeInMillis(j);
        calendar.set(14, 0);
        calendar.set(13, 0);
        calendar.set(12, 0);
        calendar.set(11, 0);
        return calendar.getTimeInMillis();
    }

    public static List<Long> epochDays(long j, long j2) {
        long jMidnightUTC = midnightUTC(j);
        if (j2 == 0) {
            j2 = j;
        }
        long j3 = j - j2;
        ArrayList arrayList = new ArrayList();
        for (long jMidnightUTC2 = j3 > 0 ? midnightUTC(j3) : 0L; jMidnightUTC2 <= jMidnightUTC; jMidnightUTC2 += TimeUnit.DAYS.toMillis(1L)) {
            arrayList.add(Long.valueOf(jMidnightUTC2));
        }
        return arrayList;
    }
}
