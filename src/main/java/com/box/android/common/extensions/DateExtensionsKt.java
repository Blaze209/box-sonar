package com.box.android.common.extensions;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DateExtensions.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0002*\u00020\u0002\u001a\u0016\u0010\u0004\u001a\u00020\u0005*\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0002¨\u0006\u0007"}, d2 = {"toRfc3339", "", "Ljava/util/Date;", "toEndOfDay", "toMidnightMillis", "", "todayDate", "common_prodRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DateExtensionsKt {
    public static final String toRfc3339(Date date) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        String str = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX", Locale.ENGLISH).format(date);
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public static final Date toEndOfDay(Date date) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.setTime(date);
        Calendar calendar2 = Calendar.getInstance(TimeZone.getDefault());
        calendar2.set(calendar.get(1), calendar.get(2), calendar.get(5), 23, 59, 0);
        calendar2.set(14, 0);
        Date time = calendar2.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "getTime(...)");
        return time;
    }

    public static /* synthetic */ long toMidnightMillis$default(Date date, Date date2, int i, Object obj) {
        if ((i & 1) != 0) {
            date2 = new Date();
        }
        return toMidnightMillis(date, date2);
    }

    public static final long toMidnightMillis(Date date, Date todayDate) {
        Intrinsics.checkNotNullParameter(todayDate, "todayDate");
        Calendar calendar = Calendar.getInstance();
        if (date == null) {
            date = todayDate;
        }
        calendar.setTime(date);
        int i = calendar.get(1);
        int i2 = calendar.get(2);
        int i3 = calendar.get(5);
        Calendar calendar2 = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar2.set(i, i2, i3, 0, 0, 0);
        calendar2.set(14, 0);
        return calendar2.getTimeInMillis();
    }
}
