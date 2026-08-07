package com.box.android.common.utilities;

import java.util.Calendar;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DateUtils.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0007H\u0002¨\u0006\u000e"}, d2 = {"Lcom/box/android/common/utilities/DateUtils;", "", "<init>", "()V", "monthsDifference", "", "startMillis", "", "endMillis", "start", "Ljava/util/Calendar;", "end", "newUtcCalendar", "timeInMillis", "common_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DateUtils {
    public static final DateUtils INSTANCE = new DateUtils();

    private DateUtils() {
    }

    public final int monthsDifference(long startMillis, long endMillis) {
        if (endMillis <= startMillis) {
            return 0;
        }
        return monthsDifference(newUtcCalendar(startMillis), newUtcCalendar(endMillis));
    }

    public final int monthsDifference(Calendar start, Calendar end) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(end, "end");
        int i = start.get(1);
        int i2 = start.get(2);
        int i3 = start.get(5);
        int i4 = end.get(1);
        int i5 = end.get(2);
        int i6 = end.get(5);
        if (i4 < i || (i4 == i && (i5 < i2 || (i5 == i2 && i6 <= i3)))) {
            return 0;
        }
        int i7 = ((i4 - i) * 12) + (i5 - i2);
        if (i6 < i3) {
            i7--;
        }
        if (i7 < 0) {
            return 0;
        }
        return i7;
    }

    private final Calendar newUtcCalendar(long timeInMillis) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.setTimeInMillis(timeInMillis);
        Intrinsics.checkNotNullExpressionValue(calendar, "apply(...)");
        return calendar;
    }
}
