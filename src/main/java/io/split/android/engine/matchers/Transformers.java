package io.split.android.engine.matchers;

import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes4.dex */
public class Transformers {
    private static final TimeZone UTC;
    private static final Set<String> VALID_BOOLEAN_STRINGS;

    static {
        HashSet hashSet = new HashSet();
        Collections.addAll(hashSet, TelemetryEventStrings.Value.TRUE, "false");
        VALID_BOOLEAN_STRINGS = hashSet;
        UTC = TimeZone.getTimeZone("UTC");
    }

    public static Long asLong(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).longValue());
        }
        if (obj instanceof Long) {
            return (Long) obj;
        }
        return null;
    }

    public static Long asDate(Object obj) {
        Calendar calendar = toCalendar(obj);
        if (calendar == null) {
            return null;
        }
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return Long.valueOf(calendar.getTimeInMillis());
    }

    public static Long asDateHourMinute(Object obj) {
        Calendar calendar = toCalendar(obj);
        if (calendar == null) {
            return null;
        }
        calendar.set(13, 0);
        calendar.set(14, 0);
        return Long.valueOf(calendar.getTimeInMillis());
    }

    public static Boolean asBoolean(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (VALID_BOOLEAN_STRINGS.contains(str.toLowerCase(Locale.ROOT))) {
                return Boolean.valueOf(Boolean.parseBoolean(str));
            }
        }
        return null;
    }

    private static Calendar toCalendar(Object obj) {
        Long lAsLong = asLong(obj);
        if (lAsLong == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(UTC);
        calendar.setTimeInMillis(lAsLong.longValue());
        return calendar;
    }

    public static Set<String> toSetOfStrings(Collection key) {
        HashSet hashSet = new HashSet(key.size());
        Iterator it = key.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().toString());
        }
        return hashSet;
    }
}
