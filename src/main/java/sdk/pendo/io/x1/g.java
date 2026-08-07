package sdk.pendo.io.x1;

import com.box.android.data.api.models.MetadataReservedKeys;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

/* JADX INFO: loaded from: classes6.dex */
public class g {
    private static final ThreadLocal<Set<i>> c = new ThreadLocal<>();
    private final int a;
    private int b;

    public g(int i, int i2) {
        sdk.pendo.io.w1.h.a(i % 2 != 0, "HashCodeBuilder requires an odd initial value", new Object[0]);
        sdk.pendo.io.w1.h.a(i2 % 2 != 0, "HashCodeBuilder requires an odd multiplier", new Object[0]);
        this.a = i2;
        this.b = i;
    }

    private void b(Object obj) {
        if (obj instanceof long[]) {
            a((long[]) obj);
            return;
        }
        if (obj instanceof int[]) {
            a((int[]) obj);
            return;
        }
        if (obj instanceof short[]) {
            a((short[]) obj);
            return;
        }
        if (obj instanceof char[]) {
            a((char[]) obj);
            return;
        }
        if (obj instanceof byte[]) {
            a((byte[]) obj);
            return;
        }
        if (obj instanceof double[]) {
            a((double[]) obj);
            return;
        }
        if (obj instanceof float[]) {
            a((float[]) obj);
        } else if (obj instanceof boolean[]) {
            a((boolean[]) obj);
        } else {
            a((Object[]) obj);
        }
    }

    static boolean c(Object obj) {
        Set<i> setA = a();
        return setA != null && setA.contains(new i(obj));
    }

    private static void d(Object obj) {
        Set<i> setA = a();
        if (setA == null) {
            setA = new HashSet<>();
            c.set(setA);
        }
        setA.add(new i(obj));
    }

    private static void e(Object obj) {
        Set<i> setA = a();
        if (setA != null) {
            setA.remove(new i(obj));
            if (setA.isEmpty()) {
                c.remove();
            }
        }
    }

    public g a(byte b) {
        this.b = (this.b * this.a) + b;
        return this;
    }

    public int hashCode() {
        return b();
    }

    public g a(char c2) {
        this.b = (this.b * this.a) + c2;
        return this;
    }

    public int b() {
        return this.b;
    }

    public g a(double d) {
        return a(Double.doubleToLongBits(d));
    }

    public g a(float f) {
        this.b = (this.b * this.a) + Float.floatToIntBits(f);
        return this;
    }

    public g a(int i) {
        this.b = (this.b * this.a) + i;
        return this;
    }

    public g a(long j) {
        this.b = (this.b * this.a) + ((int) (j ^ (j >> 32)));
        return this;
    }

    public g a(Object obj) {
        if (obj == null) {
            this.b *= this.a;
            return this;
        }
        if (obj.getClass().isArray()) {
            b(obj);
            return this;
        }
        this.b = (this.b * this.a) + obj.hashCode();
        return this;
    }

    public g a(short s) {
        this.b = (this.b * this.a) + s;
        return this;
    }

    public g a(boolean z) {
        this.b = (this.b * this.a) + (!z ? 1 : 0);
        return this;
    }

    public g a(byte[] bArr) {
        if (bArr == null) {
            this.b *= this.a;
            return this;
        }
        for (byte b : bArr) {
            a(b);
        }
        return this;
    }

    public g a(char[] cArr) {
        if (cArr == null) {
            this.b *= this.a;
            return this;
        }
        for (char c2 : cArr) {
            a(c2);
        }
        return this;
    }

    public g a(double[] dArr) {
        if (dArr == null) {
            this.b *= this.a;
            return this;
        }
        for (double d : dArr) {
            a(d);
        }
        return this;
    }

    public g a(float[] fArr) {
        if (fArr == null) {
            this.b *= this.a;
            return this;
        }
        for (float f : fArr) {
            a(f);
        }
        return this;
    }

    public g a(int[] iArr) {
        if (iArr == null) {
            this.b *= this.a;
            return this;
        }
        for (int i : iArr) {
            a(i);
        }
        return this;
    }

    public g a(long[] jArr) {
        if (jArr == null) {
            this.b *= this.a;
            return this;
        }
        for (long j : jArr) {
            a(j);
        }
        return this;
    }

    public g a(Object[] objArr) {
        if (objArr == null) {
            this.b *= this.a;
            return this;
        }
        for (Object obj : objArr) {
            a(obj);
        }
        return this;
    }

    public g a(short[] sArr) {
        if (sArr == null) {
            this.b *= this.a;
            return this;
        }
        for (short s : sArr) {
            a(s);
        }
        return this;
    }

    public g a(boolean[] zArr) {
        if (zArr == null) {
            this.b *= this.a;
            return this;
        }
        for (boolean z : zArr) {
            a(z);
        }
        return this;
    }

    static Set<i> a() {
        return c.get();
    }

    private static void a(Object obj, Class<?> cls, g gVar, boolean z, String[] strArr) {
        if (c(obj)) {
            return;
        }
        try {
            d(obj);
            Field[] fieldArr = (Field[]) sdk.pendo.io.w1.a.a(cls.getDeclaredFields(), Comparator.comparing(new Function() { // from class: sdk.pendo.io.x1.g$$ExternalSyntheticLambda0
                @Override // java.util.function.Function
                public final Object apply(Object obj2) {
                    return ((Field) obj2).getName();
                }
            }));
            AccessibleObject.setAccessible(fieldArr, true);
            for (Field field : fieldArr) {
                if (!sdk.pendo.io.w1.b.b(strArr, field.getName()) && !field.getName().contains(MetadataReservedKeys.PREFIX) && ((z || !Modifier.isTransient(field.getModifiers())) && !Modifier.isStatic(field.getModifiers()) && !field.isAnnotationPresent(h.class))) {
                    try {
                        gVar.a(field.get(obj));
                    } catch (IllegalAccessException unused) {
                        throw new InternalError("Unexpected IllegalAccessException");
                    }
                }
            }
            e(obj);
        } catch (Throwable th) {
            e(obj);
            throw th;
        }
    }

    public static <T> int a(int i, int i2, T t, boolean z, Class<? super T> cls, String... strArr) {
        sdk.pendo.io.w1.h.a(t, "object", new Object[0]);
        g gVar = new g(i, i2);
        Class<?> superclass = t.getClass();
        while (true) {
            a(t, superclass, gVar, z, strArr);
            if (superclass.getSuperclass() == null || superclass == cls) {
                break;
            }
            superclass = superclass.getSuperclass();
        }
        return gVar.b();
    }
}
