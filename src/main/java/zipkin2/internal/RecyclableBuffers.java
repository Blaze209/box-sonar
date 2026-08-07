package zipkin2.internal;

/* JADX INFO: loaded from: classes6.dex */
public final class RecyclableBuffers {
    static final ThreadLocal<char[]> SHORT_STRING_BUFFER = new ThreadLocal<>();
    public static final int SHORT_STRING_LENGTH = 256;

    RecyclableBuffers() {
    }

    public static char[] shortStringBuffer() {
        ThreadLocal<char[]> threadLocal = SHORT_STRING_BUFFER;
        char[] cArr = threadLocal.get();
        if (cArr != null) {
            return cArr;
        }
        char[] cArr2 = new char[256];
        threadLocal.set(cArr2);
        return cArr2;
    }
}
