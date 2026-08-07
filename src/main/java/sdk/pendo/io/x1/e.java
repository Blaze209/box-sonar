package sdk.pendo.io.x1;

import com.box.android.data.api.models.MetadataReservedKeys;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public class e {
    private static final ThreadLocal<Set<sdk.pendo.io.c2.b<i, i>>> g = new ThreadLocal<>();
    private boolean a = true;
    private boolean b;
    private boolean c;
    private List<Class<?>> d;
    private Class<?> e;
    private String[] f;

    public e() {
        ArrayList arrayList = new ArrayList();
        this.d = arrayList;
        arrayList.add(String.class);
    }

    private void b(Object obj, Object obj2) {
        if (obj.getClass() != obj2.getClass()) {
            a(false);
            return;
        }
        if (obj instanceof long[]) {
            a((long[]) obj, (long[]) obj2);
            return;
        }
        if (obj instanceof int[]) {
            a((int[]) obj, (int[]) obj2);
            return;
        }
        if (obj instanceof short[]) {
            a((short[]) obj, (short[]) obj2);
            return;
        }
        if (obj instanceof char[]) {
            a((char[]) obj, (char[]) obj2);
            return;
        }
        if (obj instanceof byte[]) {
            a((byte[]) obj, (byte[]) obj2);
            return;
        }
        if (obj instanceof double[]) {
            a((double[]) obj, (double[]) obj2);
            return;
        }
        if (obj instanceof float[]) {
            a((float[]) obj, (float[]) obj2);
        } else if (obj instanceof boolean[]) {
            a((boolean[]) obj, (boolean[]) obj2);
        } else {
            a((Object[]) obj, (Object[]) obj2);
        }
    }

    static sdk.pendo.io.c2.b<i, i> c(Object obj, Object obj2) {
        return sdk.pendo.io.c2.b.a(new i(obj), new i(obj2));
    }

    static boolean d(Object obj, Object obj2) {
        Set<sdk.pendo.io.c2.b<i, i>> setA = a();
        sdk.pendo.io.c2.b<i, i> bVarC = c(obj, obj2);
        sdk.pendo.io.c2.b bVarA = sdk.pendo.io.c2.b.a(bVarC.b(), bVarC.a());
        if (setA != null) {
            return setA.contains(bVarC) || setA.contains(bVarA);
        }
        return false;
    }

    private static void f(Object obj, Object obj2) {
        Set<sdk.pendo.io.c2.b<i, i>> setA = a();
        if (setA == null) {
            setA = new HashSet<>();
            g.set(setA);
        }
        setA.add(c(obj, obj2));
    }

    private static void g(Object obj, Object obj2) {
        Set<sdk.pendo.io.c2.b<i, i>> setA = a();
        if (setA != null) {
            setA.remove(c(obj, obj2));
            if (setA.isEmpty()) {
                g.remove();
            }
        }
    }

    public e a(byte b, byte b2) {
        if (!this.a) {
            return this;
        }
        this.a = b == b2;
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0030  */
    /* JADX WARN: Code duplicated, block: B:21:0x0032  */
    public e e(Object obj, Object obj2) {
        Class<?> superclass;
        if (this.a && obj != obj2) {
            if (obj == null || obj2 == null) {
                this.a = false;
                return this;
            }
            Class<?> cls = obj.getClass();
            Class<?> cls2 = obj2.getClass();
            if (cls.isInstance(obj2)) {
                if (cls2.isInstance(obj)) {
                    superclass = cls;
                } else {
                    superclass = cls2;
                }
            } else {
                if (!cls2.isInstance(obj)) {
                    this.a = false;
                    return this;
                }
                if (cls.isInstance(obj2)) {
                    superclass = cls2;
                } else {
                    superclass = cls;
                }
            }
            try {
                if (superclass.isArray()) {
                    a(obj, obj2);
                    return this;
                }
                List<Class<?>> list = this.d;
                if (list != null && (list.contains(cls) || this.d.contains(cls2))) {
                    this.a = obj.equals(obj2);
                    return this;
                }
                while (true) {
                    a(obj, obj2, superclass);
                    if (superclass.getSuperclass() == null || superclass == this.e) {
                        break;
                    }
                    superclass = superclass.getSuperclass();
                }
            } catch (IllegalArgumentException unused) {
                this.a = false;
                return this;
            }
        }
        return this;
    }

    public e a(char c, char c2) {
        if (!this.a) {
            return this;
        }
        this.a = c == c2;
        return this;
    }

    public boolean b() {
        return this.a;
    }

    public e c(boolean z) {
        this.b = z;
        return this;
    }

    public e a(double d, double d2) {
        return !this.a ? this : a(Double.doubleToLongBits(d), Double.doubleToLongBits(d2));
    }

    public e b(boolean z) {
        this.c = z;
        return this;
    }

    public e a(float f, float f2) {
        return !this.a ? this : a(Float.floatToIntBits(f), Float.floatToIntBits(f2));
    }

    public e a(int i, int i2) {
        if (!this.a) {
            return this;
        }
        this.a = i == i2;
        return this;
    }

    public e a(long j, long j2) {
        if (!this.a) {
            return this;
        }
        this.a = j == j2;
        return this;
    }

    public e a(Object obj, Object obj2) {
        if (!this.a || obj == obj2) {
            return this;
        }
        if (obj == null || obj2 == null) {
            a(false);
            return this;
        }
        Class<?> cls = obj.getClass();
        if (cls.isArray()) {
            b(obj, obj2);
            return this;
        }
        if (!this.c || sdk.pendo.io.w1.d.b(cls)) {
            this.a = obj.equals(obj2);
            return this;
        }
        e(obj, obj2);
        return this;
    }

    public e a(short s, short s2) {
        if (!this.a) {
            return this;
        }
        this.a = s == s2;
        return this;
    }

    public e a(boolean z, boolean z2) {
        if (!this.a) {
            return this;
        }
        this.a = z == z2;
        return this;
    }

    public e a(byte[] bArr, byte[] bArr2) {
        if (this.a && bArr != bArr2) {
            if (bArr == null || bArr2 == null) {
                a(false);
                return this;
            }
            if (bArr.length != bArr2.length) {
                a(false);
                return this;
            }
            for (int i = 0; i < bArr.length && this.a; i++) {
                a(bArr[i], bArr2[i]);
            }
        }
        return this;
    }

    public e a(char[] cArr, char[] cArr2) {
        if (this.a && cArr != cArr2) {
            if (cArr == null || cArr2 == null) {
                a(false);
                return this;
            }
            if (cArr.length != cArr2.length) {
                a(false);
                return this;
            }
            for (int i = 0; i < cArr.length && this.a; i++) {
                a(cArr[i], cArr2[i]);
            }
        }
        return this;
    }

    public e a(double[] dArr, double[] dArr2) {
        if (this.a && dArr != dArr2) {
            if (dArr == null || dArr2 == null) {
                a(false);
                return this;
            }
            if (dArr.length != dArr2.length) {
                a(false);
                return this;
            }
            for (int i = 0; i < dArr.length && this.a; i++) {
                a(dArr[i], dArr2[i]);
            }
        }
        return this;
    }

    public e a(float[] fArr, float[] fArr2) {
        if (this.a && fArr != fArr2) {
            if (fArr == null || fArr2 == null) {
                a(false);
                return this;
            }
            if (fArr.length != fArr2.length) {
                a(false);
                return this;
            }
            for (int i = 0; i < fArr.length && this.a; i++) {
                a(fArr[i], fArr2[i]);
            }
        }
        return this;
    }

    public e a(int[] iArr, int[] iArr2) {
        if (this.a && iArr != iArr2) {
            if (iArr == null || iArr2 == null) {
                a(false);
                return this;
            }
            if (iArr.length != iArr2.length) {
                a(false);
                return this;
            }
            for (int i = 0; i < iArr.length && this.a; i++) {
                a(iArr[i], iArr2[i]);
            }
        }
        return this;
    }

    public e a(long[] jArr, long[] jArr2) {
        if (this.a && jArr != jArr2) {
            if (jArr == null || jArr2 == null) {
                a(false);
                return this;
            }
            if (jArr.length != jArr2.length) {
                a(false);
                return this;
            }
            for (int i = 0; i < jArr.length && this.a; i++) {
                a(jArr[i], jArr2[i]);
            }
        }
        return this;
    }

    public e a(Object[] objArr, Object[] objArr2) {
        if (this.a && objArr != objArr2) {
            if (objArr == null || objArr2 == null) {
                a(false);
                return this;
            }
            if (objArr.length != objArr2.length) {
                a(false);
                return this;
            }
            for (int i = 0; i < objArr.length && this.a; i++) {
                a(objArr[i], objArr2[i]);
            }
        }
        return this;
    }

    public e a(short[] sArr, short[] sArr2) {
        if (this.a && sArr != sArr2) {
            if (sArr == null || sArr2 == null) {
                a(false);
                return this;
            }
            if (sArr.length != sArr2.length) {
                a(false);
                return this;
            }
            for (int i = 0; i < sArr.length && this.a; i++) {
                a(sArr[i], sArr2[i]);
            }
        }
        return this;
    }

    public e a(boolean[] zArr, boolean[] zArr2) {
        if (this.a && zArr != zArr2) {
            if (zArr == null || zArr2 == null) {
                a(false);
                return this;
            }
            if (zArr.length != zArr2.length) {
                a(false);
                return this;
            }
            for (int i = 0; i < zArr.length && this.a; i++) {
                a(zArr[i], zArr2[i]);
            }
        }
        return this;
    }

    static Set<sdk.pendo.io.c2.b<i, i>> a() {
        return g.get();
    }

    private void a(Object obj, Object obj2, Class<?> cls) {
        if (d(obj, obj2)) {
            return;
        }
        try {
            f(obj, obj2);
            Field[] declaredFields = cls.getDeclaredFields();
            AccessibleObject.setAccessible(declaredFields, true);
            for (int i = 0; i < declaredFields.length && this.a; i++) {
                Field field = declaredFields[i];
                if (!sdk.pendo.io.w1.b.b(this.f, field.getName()) && !field.getName().contains(MetadataReservedKeys.PREFIX) && ((this.b || !Modifier.isTransient(field.getModifiers())) && !Modifier.isStatic(field.getModifiers()) && !field.isAnnotationPresent(f.class))) {
                    try {
                        a(field.get(obj), field.get(obj2));
                    } catch (IllegalAccessException unused) {
                        throw new InternalError("Unexpected IllegalAccessException");
                    }
                }
            }
            g(obj, obj2);
        } catch (Throwable th) {
            g(obj, obj2);
            throw th;
        }
    }

    public static boolean a(Object obj, Object obj2, boolean z, Class<?> cls, boolean z2, String... strArr) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        return new e().a(strArr).a(cls).c(z).b(z2).e(obj, obj2).b();
    }

    public static boolean a(Object obj, Object obj2, boolean z, Class<?> cls, String... strArr) {
        return a(obj, obj2, z, cls, false, strArr);
    }

    public static boolean a(Object obj, Object obj2, String... strArr) {
        return a(obj, obj2, false, null, strArr);
    }

    protected void a(boolean z) {
        this.a = z;
    }

    public e a(String... strArr) {
        this.f = strArr;
        return this;
    }

    public e a(Class<?> cls) {
        this.e = cls;
        return this;
    }
}
