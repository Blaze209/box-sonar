package com.box.android.common.utilities;

import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: NumberUtils.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u0005*\u0004\u0018\u00010\u00012\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\u0007"}, d2 = {"Lcom/box/android/common/utilities/NumberUtils;", "", "<init>", "()V", "toLongOrDefault", "", "defaultValue", "common_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NumberUtils {
    public static final NumberUtils INSTANCE = new NumberUtils();

    private NumberUtils() {
    }

    public final long toLongOrDefault(Object obj, long j) {
        if (obj instanceof Long) {
            return ((Number) obj).longValue();
        }
        if (obj instanceof Integer) {
            return ((Number) obj).intValue();
        }
        if (obj instanceof Float) {
            return (long) ((Number) obj).floatValue();
        }
        if (obj instanceof Double) {
            return (long) ((Number) obj).doubleValue();
        }
        if (obj instanceof String) {
            String str = (String) obj;
            Long longOrNull = StringsKt.toLongOrNull(str);
            if (longOrNull != null) {
                return longOrNull.longValue();
            }
            Double doubleOrNull = StringsKt.toDoubleOrNull(str);
            Long lValueOf = doubleOrNull != null ? Long.valueOf((long) doubleOrNull.doubleValue()) : null;
            if (lValueOf != null) {
                return lValueOf.longValue();
            }
        }
        return j;
    }
}
