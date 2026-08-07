package sdk.pendo.io.a;

import java.lang.reflect.Method;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
public final class d0 {
    public static final d0 e = new d0(0, "VZCBSIFJD", 0, 1);
    public static final d0 f = new d0(1, "VZCBSIFJD", 1, 2);
    public static final d0 g = new d0(2, "VZCBSIFJD", 2, 3);
    public static final d0 h = new d0(3, "VZCBSIFJD", 3, 4);
    public static final d0 i = new d0(4, "VZCBSIFJD", 4, 5);
    public static final d0 j = new d0(5, "VZCBSIFJD", 5, 6);
    public static final d0 k = new d0(6, "VZCBSIFJD", 6, 7);
    public static final d0 l = new d0(7, "VZCBSIFJD", 7, 8);
    public static final d0 m = new d0(8, "VZCBSIFJD", 8, 9);
    private final int a;
    private final String b;
    private final int c;
    private final int d;

    private d0(int i2, String str, int i3, int i4) {
        this.a = i2;
        this.b = str;
        this.c = i3;
        this.d = i4;
    }

    private static void a(Class<?> cls, StringBuilder sb) {
        char c;
        while (cls.isArray()) {
            sb.append(AbstractJsonLexerKt.BEGIN_LIST);
            cls = cls.getComponentType();
        }
        if (!cls.isPrimitive()) {
            sb.append('L').append(b(cls)).append(';');
            return;
        }
        if (cls == Integer.TYPE) {
            c = 'I';
        } else if (cls == Void.TYPE) {
            c = 'V';
        } else if (cls == Boolean.TYPE) {
            c = 'Z';
        } else if (cls == Byte.TYPE) {
            c = 'B';
        } else if (cls == Character.TYPE) {
            c = 'C';
        } else if (cls == Short.TYPE) {
            c = 'S';
        } else if (cls == Double.TYPE) {
            c = 'D';
        } else if (cls == Float.TYPE) {
            c = 'F';
        } else {
            if (cls != Long.TYPE) {
                throw new AssertionError();
            }
            c = 'J';
        }
        sb.append(c);
    }

    public static int b(String str) {
        char cCharAt = str.charAt(1);
        int i2 = 1;
        int i3 = 1;
        while (cCharAt != ')') {
            if (cCharAt == 'J' || cCharAt == 'D') {
                i2++;
                i3 += 2;
            } else {
                while (str.charAt(i2) == '[') {
                    i2++;
                }
                int iMax = i2 + 1;
                if (str.charAt(i2) == 'L') {
                    iMax = Math.max(iMax, str.indexOf(59, iMax) + 1);
                }
                i3++;
                i2 = iMax;
            }
            cCharAt = str.charAt(i2);
        }
        char cCharAt2 = str.charAt(i2 + 1);
        if (cCharAt2 == 'V') {
            return i3 << 2;
        }
        return (i3 << 2) | ((cCharAt2 == 'J' || cCharAt2 == 'D') ? 2 : 1);
    }

    public static d0 c(String str) {
        return new d0(11, str, 0, str.length());
    }

    public static d0 d(String str) {
        return new d0(str.charAt(0) == '[' ? 9 : 12, str, 0, str.length());
    }

    static int e(String str) {
        int iMax = 1;
        while (str.charAt(iMax) != ')') {
            while (str.charAt(iMax) == '[') {
                iMax++;
            }
            int i2 = iMax + 1;
            iMax = str.charAt(iMax) == 'L' ? Math.max(i2, str.indexOf(59, i2) + 1) : i2;
        }
        return iMax + 1;
    }

    public static d0 f(String str) {
        return a(str, 0, str.length());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) obj;
        int i2 = this.a;
        if (i2 == 12) {
            i2 = 10;
        }
        int i3 = d0Var.a;
        if (i2 != (i3 != 12 ? i3 : 10)) {
            return false;
        }
        int i4 = this.c;
        int i5 = this.d;
        int i6 = d0Var.c;
        if (i5 - i4 != d0Var.d - i6) {
            return false;
        }
        while (i4 < i5) {
            if (this.b.charAt(i4) != d0Var.b.charAt(i6)) {
                return false;
            }
            i4++;
            i6++;
        }
        return true;
    }

    public int hashCode() {
        int i2 = this.a;
        int iCharAt = (i2 == 12 ? 10 : i2) * 13;
        if (i2 >= 9) {
            int i3 = this.d;
            for (int i4 = this.c; i4 < i3; i4++) {
                iCharAt = (iCharAt + this.b.charAt(i4)) * 17;
            }
        }
        return iCharAt;
    }

    public String toString() {
        return a();
    }

    public static d0[] a(String str) {
        int i2 = 0;
        int i3 = 0;
        int iMax = 1;
        while (str.charAt(iMax) != ')') {
            while (str.charAt(iMax) == '[') {
                iMax++;
            }
            int i4 = iMax + 1;
            iMax = str.charAt(iMax) == 'L' ? Math.max(i4, str.indexOf(59, i4) + 1) : i4;
            i3++;
        }
        d0[] d0VarArr = new d0[i3];
        int i5 = 1;
        while (str.charAt(i5) != ')') {
            int i6 = i5;
            while (str.charAt(i6) == '[') {
                i6++;
            }
            int iMax2 = i6 + 1;
            if (str.charAt(i6) == 'L') {
                iMax2 = Math.max(iMax2, str.indexOf(59, iMax2) + 1);
            }
            d0VarArr[i2] = a(str, i5, iMax2);
            i2++;
            i5 = iMax2;
        }
        return d0VarArr;
    }

    public String b() {
        return this.b.substring(this.c, this.d);
    }

    public int c() {
        int i2 = this.a;
        if (i2 == 12) {
            return 10;
        }
        return i2;
    }

    public static String b(Class<?> cls) {
        return cls.getName().replace('.', '/');
    }

    public static d0 c(Class<?> cls) {
        if (!cls.isPrimitive()) {
            return f(a(cls));
        }
        if (cls == Integer.TYPE) {
            return j;
        }
        if (cls == Void.TYPE) {
            return e;
        }
        if (cls == Boolean.TYPE) {
            return f;
        }
        if (cls == Byte.TYPE) {
            return h;
        }
        if (cls == Character.TYPE) {
            return g;
        }
        if (cls == Short.TYPE) {
            return i;
        }
        if (cls == Double.TYPE) {
            return m;
        }
        if (cls == Float.TYPE) {
            return k;
        }
        if (cls == Long.TYPE) {
            return l;
        }
        throw new AssertionError();
    }

    public String a() {
        int i2 = this.a;
        if (i2 == 10) {
            return this.b.substring(this.c - 1, this.d + 1);
        }
        return i2 == 12 ? "L" + this.b.substring(this.c, this.d) + ';' : this.b.substring(this.c, this.d);
    }

    public static String a(Class<?> cls) {
        StringBuilder sb = new StringBuilder();
        a(cls, sb);
        return sb.toString();
    }

    public static String a(Method method) {
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        for (Class<?> cls : method.getParameterTypes()) {
            a(cls, sb);
        }
        sb.append(')');
        a(method.getReturnType(), sb);
        return sb.toString();
    }

    private static d0 a(String str, int i2, int i3) {
        char cCharAt = str.charAt(i2);
        if (cCharAt == '(') {
            return new d0(11, str, i2, i3);
        }
        if (cCharAt == 'F') {
            return k;
        }
        if (cCharAt == 'L') {
            return new d0(10, str, i2 + 1, i3 - 1);
        }
        if (cCharAt == 'S') {
            return i;
        }
        if (cCharAt == 'V') {
            return e;
        }
        if (cCharAt == 'I') {
            return j;
        }
        if (cCharAt == 'J') {
            return l;
        }
        if (cCharAt == 'Z') {
            return f;
        }
        if (cCharAt == '[') {
            return new d0(9, str, i2, i3);
        }
        switch (cCharAt) {
            case 'B':
                return h;
            case 'C':
                return g;
            case 'D':
                return m;
            default:
                throw new IllegalArgumentException();
        }
    }
}
