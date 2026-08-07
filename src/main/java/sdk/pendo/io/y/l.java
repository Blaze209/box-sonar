package sdk.pendo.io.y;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import com.google.common.base.Ascii;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

/* JADX INFO: loaded from: classes6.dex */
public final class l {
    private static final char[] a = "0123456789abcdef".toCharArray();
    private static final char[] b = new char[64];
    private static volatile Handler c;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            a = iArr;
            try {
                iArr[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Bitmap.Config.RGBA_F16.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[Bitmap.Config.ARGB_8888.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private l() {
    }

    public static int a(int i, int i2) {
        return (i2 * 31) + i;
    }

    public static void a() {
        if (!d()) {
            throw new IllegalArgumentException("You must call this method on a background thread");
        }
    }

    public static void b() {
        if (!e()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    private static Handler c() {
        if (c == null) {
            synchronized (l.class) {
                if (c == null) {
                    c = new Handler(Looper.getMainLooper());
                }
            }
        }
        return c;
    }

    public static boolean c(int i) {
        return i > 0 || i == Integer.MIN_VALUE;
    }

    public static boolean d() {
        return !e();
    }

    public static boolean e() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static boolean a(external.sdk.pendo.io.glide.request.a<?> aVar, external.sdk.pendo.io.glide.request.a<?> aVar2) {
        if (aVar == null) {
            return aVar2 == null;
        }
        return aVar.isEquivalentTo(aVar2);
    }

    public static boolean b(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj instanceof sdk.pendo.io.l.b ? ((sdk.pendo.io.l.b) obj).a(obj2) : obj.equals(obj2);
    }

    public static int b(int i) {
        return a(i, 17);
    }

    public static void c(Runnable runnable) {
        c().removeCallbacks(runnable);
    }

    private static String a(byte[] bArr, char[] cArr) {
        for (int i = 0; i < bArr.length; i++) {
            byte b2 = bArr[i];
            int i2 = i * 2;
            char[] cArr2 = a;
            cArr[i2] = cArr2[(b2 & 255) >>> 4];
            cArr[i2 + 1] = cArr2[b2 & Ascii.SI];
        }
        return new String(cArr);
    }

    public static boolean b(int i, int i2) {
        return c(i) && c(i2);
    }

    public static <T> Queue<T> a(int i) {
        return new ArrayDeque(i);
    }

    public static void b(Runnable runnable) {
        c().post(runnable);
    }

    public static int a(int i, int i2, Bitmap.Config config) {
        return i * i2 * a(config);
    }

    public static int a(Bitmap bitmap) {
        if (bitmap.isRecycled()) {
            throw new IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig());
        }
        try {
            return bitmap.getAllocationByteCount();
        } catch (NullPointerException unused) {
            return bitmap.getHeight() * bitmap.getRowBytes();
        }
    }

    public static int a(Bitmap.Config config) {
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int i = a.a[config.ordinal()];
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2 && i != 3) {
                return i != 4 ? 4 : 8;
            }
        }
        return i2;
    }

    public static <T> List<T> a(Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (T t : collection) {
            if (t != null) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static int a(float f) {
        return a(f, 17);
    }

    public static int a(float f, int i) {
        return a(Float.floatToIntBits(f), i);
    }

    public static int a(Object obj, int i) {
        return a(obj == null ? 0 : obj.hashCode(), i);
    }

    public static int a(boolean z, int i) {
        return a(z ? 1 : 0, i);
    }

    public static void a(Runnable runnable) {
        c().postAtFrontOfQueue(runnable);
    }

    public static String a(byte[] bArr) {
        String strA;
        char[] cArr = b;
        synchronized (cArr) {
            strA = a(bArr, cArr);
        }
        return strA;
    }
}
