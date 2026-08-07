package sdk.pendo.io.s3;

import sdk.pendo.io.q3.c;

/* JADX INFO: loaded from: classes5.dex */
public final class b {
    static final c<Object, Object> a = new a();

    static final class a implements c<Object, Object> {
        a() {
        }

        @Override // sdk.pendo.io.q3.c
        public boolean a(Object obj, Object obj2) {
            return b.a(obj, obj2);
        }
    }

    public static int a(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i > i2 ? 1 : 0;
    }

    public static int a(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j > j2 ? 1 : 0;
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static <T> c<T, T> a() {
        return (c<T, T>) a;
    }

    public static <T> T a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static int a(int i, String str) {
        if (i > 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + i);
    }
}
