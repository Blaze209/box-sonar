package sdk.pendo.io.w1;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes5.dex */
public class b {
    public static final boolean[] a = new boolean[0];
    public static final Boolean[] b = new Boolean[0];
    public static final byte[] c = new byte[0];
    public static final Byte[] d = new Byte[0];
    public static final char[] e = new char[0];
    public static final Character[] f = new Character[0];
    public static final Class<?>[] g = new Class[0];
    public static final double[] h = new double[0];
    public static final Double[] i = new Double[0];
    public static final Field[] j = new Field[0];
    public static final float[] k = new float[0];
    public static final Float[] l = new Float[0];
    public static final int[] m = new int[0];
    public static final Integer[] n = new Integer[0];
    public static final long[] o = new long[0];
    public static final Long[] p = new Long[0];
    public static final Method[] q = new Method[0];
    public static final Object[] r = new Object[0];
    public static final short[] s = new short[0];
    public static final Short[] t = new Short[0];
    public static final String[] u = new String[0];
    public static final Throwable[] v = new Throwable[0];
    public static final Type[] w = new Type[0];

    public static int[] a(int[] iArr, int i2) {
        int[] iArr2 = (int[]) a(iArr, (Class<?>) Integer.TYPE);
        iArr2[iArr2.length - 1] = i2;
        return iArr2;
    }

    public static boolean b(Object[] objArr, Object obj) {
        return c(objArr, obj) != -1;
    }

    public static int c(Object[] objArr, Object obj) {
        return a(objArr, obj, 0);
    }

    public static Integer[] d(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        if (iArr.length == 0) {
            return n;
        }
        Integer[] numArr = new Integer[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            numArr[i2] = Integer.valueOf(iArr[i2]);
        }
        return numArr;
    }

    public static <T> T[] a(T[] tArr, T t2) {
        Class<?> componentType;
        if (tArr != null) {
            componentType = tArr.getClass().getComponentType();
        } else {
            if (t2 == null) {
                throw new IllegalArgumentException("Arguments cannot both be null");
            }
            componentType = t2.getClass();
        }
        T[] tArr2 = (T[]) ((Object[]) a((Object) tArr, componentType));
        tArr2[tArr2.length - 1] = t2;
        return tArr2;
    }

    public static boolean b(int[] iArr) {
        return a((Object) iArr) == 0;
    }

    public static boolean c(int[] iArr) {
        return !b(iArr);
    }

    public static int[] a(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        return (int[]) iArr.clone();
    }

    public static Character[] b(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        if (cArr.length == 0) {
            return f;
        }
        Character[] chArr = new Character[cArr.length];
        for (int i2 = 0; i2 < cArr.length; i2++) {
            chArr[i2] = Character.valueOf(cArr[i2]);
        }
        return chArr;
    }

    public static <T> T[] a(T[] tArr) {
        if (tArr == null) {
            return null;
        }
        return (T[]) ((Object[]) tArr.clone());
    }

    private static Object a(Object obj, Class<?> cls) {
        if (obj == null) {
            return Array.newInstance(cls, 1);
        }
        int length = Array.getLength(obj);
        Object objNewInstance = Array.newInstance(obj.getClass().getComponentType(), length + 1);
        System.arraycopy(obj, 0, objNewInstance, 0, length);
        return objNewInstance;
    }

    public static int a(Object obj) {
        if (obj == null) {
            return 0;
        }
        return Array.getLength(obj);
    }

    public static int a(Object[] objArr, Object obj, int i2) {
        if (objArr == null) {
            return -1;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (obj == null) {
            while (i2 < objArr.length) {
                if (objArr[i2] == null) {
                    return i2;
                }
                i2++;
            }
        } else {
            while (i2 < objArr.length) {
                if (obj.equals(objArr[i2])) {
                    return i2;
                }
                i2++;
            }
        }
        return -1;
    }

    public static boolean a(char[] cArr) {
        return a((Object) cArr) == 0;
    }

    static Object a(Object obj, int... iArr) {
        int i2;
        int iA = a(obj);
        int[] iArrA = a.a(a(iArr));
        if (c(iArrA)) {
            int length = iArrA.length;
            int i3 = iA;
            i2 = 0;
            while (true) {
                length--;
                if (length < 0) {
                    break;
                }
                int i4 = iArrA[length];
                if (i4 < 0 || i4 >= iA) {
                    throw new IndexOutOfBoundsException("Index: " + i4 + ", Length: " + iA);
                }
                if (i4 < i3) {
                    i2++;
                    i3 = i4;
                }
            }
        } else {
            i2 = 0;
        }
        int i5 = iA - i2;
        Object objNewInstance = Array.newInstance(obj.getClass().getComponentType(), i5);
        if (i2 < iA) {
            int length2 = iArrA.length - 1;
            while (length2 >= 0) {
                int i6 = iArrA[length2];
                int i7 = iA - i6;
                if (i7 > 1) {
                    int i8 = i7 - 1;
                    i5 -= i8;
                    System.arraycopy(obj, i6 + 1, objNewInstance, i5, i8);
                }
                length2--;
                iA = i6;
            }
            if (iA > 0) {
                System.arraycopy(obj, 0, objNewInstance, 0, iA);
            }
        }
        return objNewInstance;
    }

    public static <T> T[] a(T[] tArr, int... iArr) {
        return (T[]) ((Object[]) a((Object) tArr, iArr));
    }

    public static Boolean[] a(boolean[] zArr) {
        if (zArr == null) {
            return null;
        }
        if (zArr.length == 0) {
            return b;
        }
        Boolean[] boolArr = new Boolean[zArr.length];
        for (int i2 = 0; i2 < zArr.length; i2++) {
            boolArr[i2] = zArr[i2] ? Boolean.TRUE : Boolean.FALSE;
        }
        return boolArr;
    }

    public static Byte[] a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return d;
        }
        Byte[] bArr2 = new Byte[bArr.length];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr2[i2] = Byte.valueOf(bArr[i2]);
        }
        return bArr2;
    }

    public static Double[] a(double[] dArr) {
        if (dArr == null) {
            return null;
        }
        if (dArr.length == 0) {
            return i;
        }
        Double[] dArr2 = new Double[dArr.length];
        for (int i2 = 0; i2 < dArr.length; i2++) {
            dArr2[i2] = Double.valueOf(dArr[i2]);
        }
        return dArr2;
    }

    public static Float[] a(float[] fArr) {
        if (fArr == null) {
            return null;
        }
        if (fArr.length == 0) {
            return l;
        }
        Float[] fArr2 = new Float[fArr.length];
        for (int i2 = 0; i2 < fArr.length; i2++) {
            fArr2[i2] = Float.valueOf(fArr[i2]);
        }
        return fArr2;
    }

    public static Long[] a(long[] jArr) {
        if (jArr == null) {
            return null;
        }
        if (jArr.length == 0) {
            return p;
        }
        Long[] lArr = new Long[jArr.length];
        for (int i2 = 0; i2 < jArr.length; i2++) {
            lArr[i2] = Long.valueOf(jArr[i2]);
        }
        return lArr;
    }

    public static Short[] a(short[] sArr) {
        if (sArr == null) {
            return null;
        }
        if (sArr.length == 0) {
            return t;
        }
        Short[] shArr = new Short[sArr.length];
        for (int i2 = 0; i2 < sArr.length; i2++) {
            shArr[i2] = Short.valueOf(sArr[i2]);
        }
        return shArr;
    }
}
