package sdk.pendo.io.w1;

import java.util.Objects;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes5.dex */
public class h {
    public static void a(long j, long j2, long j3, String str) {
        if (j3 < j || j3 > j2) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void a(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static <T> T[] b(T[] tArr) {
        return (T[]) b(tArr, "The validated array is empty", new Object[0]);
    }

    public static <T> T[] b(T[] tArr, final String str, final Object... objArr) {
        Objects.requireNonNull(tArr, (Supplier<String>) new Supplier() { // from class: sdk.pendo.io.w1.h$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                return String.format(str, objArr);
            }
        });
        if (tArr.length != 0) {
            return tArr;
        }
        throw new IllegalArgumentException(String.format(str, objArr));
    }

    public static <T> T[] a(T[] tArr) {
        return (T[]) a((Object[]) tArr, "The validated array contains null element at index: %d", new Object[0]);
    }

    public static <T> T[] a(T[] tArr, String str, Object... objArr) {
        a(tArr);
        for (int i = 0; i < tArr.length; i++) {
            if (tArr[i] == null) {
                throw new IllegalArgumentException(String.format(str, b.a((Integer[]) objArr, Integer.valueOf(i))));
            }
        }
        return tArr;
    }

    public static <T> T a(T t) {
        return (T) a(t, "The validated object is null", new Object[0]);
    }

    public static <T> T a(T t, final String str, final Object... objArr) {
        return (T) Objects.requireNonNull(t, (Supplier<String>) new Supplier() { // from class: sdk.pendo.io.w1.h$$ExternalSyntheticLambda1
            @Override // java.util.function.Supplier
            public final Object get() {
                return String.format(str, objArr);
            }
        });
    }
}
