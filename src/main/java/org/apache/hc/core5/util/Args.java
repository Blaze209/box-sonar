package org.apache.hc.core5.util;

import androidx.collection.SieveCacheKt;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import org.apache.hc.core5.http.EntityDetails;

/* JADX INFO: loaded from: classes5.dex */
public class Args {
    public static void check(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void check(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static void check(boolean z, String str, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, obj));
        }
    }

    @Deprecated
    public static long checkContentLength(EntityDetails entityDetails) {
        return checkRange(entityDetails.getContentLength(), -1L, SieveCacheKt.NodeLinkMask, "HTTP entity too large to be buffered in memory)");
    }

    public static int checkRange(int i, int i2, int i3, String str) {
        if (i < i2 || i > i3) {
            throw illegalArgumentException("%s: %d is out of range [%d, %d]", str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        }
        return i;
    }

    public static long checkRange(long j, long j2, long j3, String str) {
        if (j < j2 || j > j3) {
            throw illegalArgumentException("%s: %d is out of range [%d, %d]", str, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3));
        }
        return j;
    }

    public static <T extends CharSequence> T containsNoBlanks(T t, String str) {
        notNull(t, str);
        if (isEmpty(t)) {
            throw illegalArgumentExceptionNotEmpty(str);
        }
        if (TextUtils.containsBlanks(t)) {
            throw new IllegalArgumentException(str + " must not contain blanks");
        }
        return t;
    }

    private static IllegalArgumentException illegalArgumentException(String str, Object... objArr) {
        return new IllegalArgumentException(String.format(str, objArr));
    }

    private static IllegalArgumentException illegalArgumentExceptionNotEmpty(String str) {
        return new IllegalArgumentException(str + " must not be empty");
    }

    public static <T extends CharSequence> T notBlank(T t, String str) {
        notNull(t, str);
        if (TextUtils.isBlank(t)) {
            throw new IllegalArgumentException(str + " must not be blank");
        }
        return t;
    }

    public static <T extends CharSequence> T notEmpty(T t, String str) {
        notNull(t, str);
        if (isEmpty(t)) {
            throw illegalArgumentExceptionNotEmpty(str);
        }
        return t;
    }

    public static <E, T extends Collection<E>> T notEmpty(T t, String str) {
        notNull(t, str);
        if (isEmpty(t)) {
            throw illegalArgumentExceptionNotEmpty(str);
        }
        return t;
    }

    public static <T> T notEmpty(T t, String str) {
        notNull(t, str);
        if (isEmpty(t)) {
            throw illegalArgumentExceptionNotEmpty(str);
        }
        return t;
    }

    public static int notNegative(int i, String str) {
        if (i >= 0) {
            return i;
        }
        throw illegalArgumentException("%s must not be negative: %d", str, Integer.valueOf(i));
    }

    public static long notNegative(long j, String str) {
        if (j >= 0) {
            return j;
        }
        throw illegalArgumentException("%s must not be negative: %d", str, Long.valueOf(j));
    }

    public static <T> T notNull(T t, String str) {
        return (T) Objects.requireNonNull(t, str);
    }

    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj instanceof CharSequence) {
            return ((CharSequence) obj).length() == 0;
        }
        if (obj.getClass().isArray()) {
            return Array.getLength(obj) == 0;
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).isEmpty();
        }
        if (obj instanceof Map) {
            return ((Map) obj).isEmpty();
        }
        return false;
    }

    public static int positive(int i, String str) {
        if (i > 0) {
            return i;
        }
        throw illegalArgumentException("%s must not be negative or zero: %d", str, Integer.valueOf(i));
    }

    public static long positive(long j, String str) {
        if (j > 0) {
            return j;
        }
        throw illegalArgumentException("%s must not be negative or zero: %d", str, Long.valueOf(j));
    }

    public static <T extends TimeValue> T positive(T t, String str) {
        positive(t.getDuration(), str);
        return t;
    }

    private Args() {
    }
}
