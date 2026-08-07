package org.apache.hc.core5.util;

import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public final class LangUtils {
    public static final int HASH_OFFSET = 37;
    public static final int HASH_SEED = 17;

    public static int hashCode(int i, int i2) {
        return (i * 37) + i2;
    }

    private LangUtils() {
    }

    public static int hashCode(int i, boolean z) {
        return hashCode(i, z ? 1 : 0);
    }

    public static int hashCode(int i, Object obj) {
        return hashCode(i, obj != null ? obj.hashCode() : 0);
    }

    @Deprecated
    public static boolean equals(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    @Deprecated
    public static boolean equals(Object[] objArr, Object[] objArr2) {
        return Arrays.equals(objArr, objArr2);
    }
}
