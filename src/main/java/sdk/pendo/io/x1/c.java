package sdk.pendo.io.x1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class c<T> {
    private final List<sdk.pendo.io.x1.b<?>> a;
    private final boolean b;
    private final T c;
    private final T d;
    private final sdk.pendo.io.x1.k e;

    class a extends sdk.pendo.io.x1.b<Float[]> {
        final /* synthetic */ float[] d;
        final /* synthetic */ float[] e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, float[] fArr, float[] fArr2) {
            super(str);
            this.d = fArr;
            this.e = fArr2;
        }

        @Override // sdk.pendo.io.c2.b
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Float[] a() {
            return sdk.pendo.io.w1.b.a(this.d);
        }

        @Override // sdk.pendo.io.c2.b
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Float[] b() {
            return sdk.pendo.io.w1.b.a(this.e);
        }
    }

    class b extends sdk.pendo.io.x1.b<Integer> {
        final /* synthetic */ int d;
        final /* synthetic */ int e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, int i, int i2) {
            super(str);
            this.d = i;
            this.e = i2;
        }

        @Override // sdk.pendo.io.c2.b
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Integer a() {
            return Integer.valueOf(this.d);
        }

        @Override // sdk.pendo.io.c2.b
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Integer b() {
            return Integer.valueOf(this.e);
        }
    }

    /* JADX INFO: renamed from: sdk.pendo.io.x1.c$c, reason: collision with other inner class name */
    class C0517c extends sdk.pendo.io.x1.b<Integer[]> {
        final /* synthetic */ int[] d;
        final /* synthetic */ int[] e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0517c(String str, int[] iArr, int[] iArr2) {
            super(str);
            this.d = iArr;
            this.e = iArr2;
        }

        @Override // sdk.pendo.io.c2.b
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Integer[] a() {
            return sdk.pendo.io.w1.b.d(this.d);
        }

        @Override // sdk.pendo.io.c2.b
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Integer[] b() {
            return sdk.pendo.io.w1.b.d(this.e);
        }
    }

    class d extends sdk.pendo.io.x1.b<Long[]> {
        final /* synthetic */ long[] d;
        final /* synthetic */ long[] e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, long[] jArr, long[] jArr2) {
            super(str);
            this.d = jArr;
            this.e = jArr2;
        }

        @Override // sdk.pendo.io.c2.b
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Long[] a() {
            return sdk.pendo.io.w1.b.a(this.d);
        }

        @Override // sdk.pendo.io.c2.b
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Long[] b() {
            return sdk.pendo.io.w1.b.a(this.e);
        }
    }

    class e extends sdk.pendo.io.x1.b<Short[]> {
        final /* synthetic */ short[] d;
        final /* synthetic */ short[] e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(String str, short[] sArr, short[] sArr2) {
            super(str);
            this.d = sArr;
            this.e = sArr2;
        }

        @Override // sdk.pendo.io.c2.b
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Short[] a() {
            return sdk.pendo.io.w1.b.a(this.d);
        }

        @Override // sdk.pendo.io.c2.b
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Short[] b() {
            return sdk.pendo.io.w1.b.a(this.e);
        }
    }

    class f extends sdk.pendo.io.x1.b<Object> {
        final /* synthetic */ Object d;
        final /* synthetic */ Object e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(String str, Object obj, Object obj2) {
            super(str);
            this.d = obj;
            this.e = obj2;
        }

        @Override // sdk.pendo.io.c2.b
        public Object a() {
            return this.d;
        }

        @Override // sdk.pendo.io.c2.b
        public Object b() {
            return this.e;
        }
    }

    class g extends sdk.pendo.io.x1.b<Object[]> {
        final /* synthetic */ Object[] d;
        final /* synthetic */ Object[] e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(String str, Object[] objArr, Object[] objArr2) {
            super(str);
            this.d = objArr;
            this.e = objArr2;
        }

        @Override // sdk.pendo.io.c2.b
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Object[] a() {
            return this.d;
        }

        @Override // sdk.pendo.io.c2.b
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Object[] b() {
            return this.e;
        }
    }

    class h extends sdk.pendo.io.x1.b<Boolean[]> {
        final /* synthetic */ boolean[] d;
        final /* synthetic */ boolean[] e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(String str, boolean[] zArr, boolean[] zArr2) {
            super(str);
            this.d = zArr;
            this.e = zArr2;
        }

        @Override // sdk.pendo.io.c2.b
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Boolean[] a() {
            return sdk.pendo.io.w1.b.a(this.d);
        }

        @Override // sdk.pendo.io.c2.b
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Boolean[] b() {
            return sdk.pendo.io.w1.b.a(this.e);
        }
    }

    class i extends sdk.pendo.io.x1.b<Byte[]> {
        final /* synthetic */ byte[] d;
        final /* synthetic */ byte[] e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(String str, byte[] bArr, byte[] bArr2) {
            super(str);
            this.d = bArr;
            this.e = bArr2;
        }

        @Override // sdk.pendo.io.c2.b
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Byte[] a() {
            return sdk.pendo.io.w1.b.a(this.d);
        }

        @Override // sdk.pendo.io.c2.b
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Byte[] b() {
            return sdk.pendo.io.w1.b.a(this.e);
        }
    }

    class j extends sdk.pendo.io.x1.b<Character[]> {
        final /* synthetic */ char[] d;
        final /* synthetic */ char[] e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(String str, char[] cArr, char[] cArr2) {
            super(str);
            this.d = cArr;
            this.e = cArr2;
        }

        @Override // sdk.pendo.io.c2.b
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Character[] a() {
            return sdk.pendo.io.w1.b.b(this.d);
        }

        @Override // sdk.pendo.io.c2.b
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Character[] b() {
            return sdk.pendo.io.w1.b.b(this.e);
        }
    }

    class k extends sdk.pendo.io.x1.b<Double[]> {
        final /* synthetic */ double[] d;
        final /* synthetic */ double[] e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(String str, double[] dArr, double[] dArr2) {
            super(str);
            this.d = dArr;
            this.e = dArr2;
        }

        @Override // sdk.pendo.io.c2.b
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Double[] a() {
            return sdk.pendo.io.w1.b.a(this.d);
        }

        @Override // sdk.pendo.io.c2.b
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Double[] b() {
            return sdk.pendo.io.w1.b.a(this.e);
        }
    }

    public c(T t, T t2, sdk.pendo.io.x1.k kVar, boolean z) {
        boolean z2 = false;
        sdk.pendo.io.w1.h.a(t, "lhs", new Object[0]);
        sdk.pendo.io.w1.h.a(t2, "rhs", new Object[0]);
        this.a = new ArrayList();
        this.c = t;
        this.d = t2;
        this.e = kVar;
        if (z && (t == t2 || t.equals(t2))) {
            z2 = true;
        }
        this.b = z2;
    }

    public c<T> a(String str, int i2, int i3) {
        a(str);
        if (!this.b && i2 != i3) {
            this.a.add(new b(str, i2, i3));
        }
        return this;
    }

    public c<T> a(String str, Object obj, Object obj2) {
        a(str);
        if (!this.b && obj != obj2) {
            Object obj3 = obj != null ? obj : obj2;
            if (obj3.getClass().isArray()) {
                if (obj3 instanceof boolean[]) {
                    return a(str, (boolean[]) obj, (boolean[]) obj2);
                }
                if (obj3 instanceof byte[]) {
                    return a(str, (byte[]) obj, (byte[]) obj2);
                }
                if (obj3 instanceof char[]) {
                    return a(str, (char[]) obj, (char[]) obj2);
                }
                if (obj3 instanceof double[]) {
                    return a(str, (double[]) obj, (double[]) obj2);
                }
                if (obj3 instanceof float[]) {
                    return a(str, (float[]) obj, (float[]) obj2);
                }
                if (obj3 instanceof int[]) {
                    return a(str, (int[]) obj, (int[]) obj2);
                }
                if (obj3 instanceof long[]) {
                    return a(str, (long[]) obj, (long[]) obj2);
                }
                return obj3 instanceof short[] ? a(str, (short[]) obj, (short[]) obj2) : a(str, (Object[]) obj, (Object[]) obj2);
            }
            if (obj == null || !obj.equals(obj2)) {
                this.a.add(new f(str, obj, obj2));
                return this;
            }
        }
        return this;
    }

    public c<T> a(String str, byte[] bArr, byte[] bArr2) {
        a(str);
        if (!this.b && !Arrays.equals(bArr, bArr2)) {
            this.a.add(new i(str, bArr, bArr2));
        }
        return this;
    }

    public c<T> a(String str, char[] cArr, char[] cArr2) {
        a(str);
        if (!this.b && !Arrays.equals(cArr, cArr2)) {
            this.a.add(new j(str, cArr, cArr2));
        }
        return this;
    }

    public c<T> a(String str, double[] dArr, double[] dArr2) {
        a(str);
        if (!this.b && !Arrays.equals(dArr, dArr2)) {
            this.a.add(new k(str, dArr, dArr2));
        }
        return this;
    }

    public c<T> a(String str, float[] fArr, float[] fArr2) {
        a(str);
        if (!this.b && !Arrays.equals(fArr, fArr2)) {
            this.a.add(new a(str, fArr, fArr2));
        }
        return this;
    }

    public c<T> a(String str, int[] iArr, int[] iArr2) {
        a(str);
        if (!this.b && !Arrays.equals(iArr, iArr2)) {
            this.a.add(new C0517c(str, iArr, iArr2));
        }
        return this;
    }

    public c<T> a(String str, long[] jArr, long[] jArr2) {
        a(str);
        if (!this.b && !Arrays.equals(jArr, jArr2)) {
            this.a.add(new d(str, jArr, jArr2));
        }
        return this;
    }

    public c<T> a(String str, Object[] objArr, Object[] objArr2) {
        a(str);
        if (!this.b && !Arrays.equals(objArr, objArr2)) {
            this.a.add(new g(str, objArr, objArr2));
        }
        return this;
    }

    public c<T> a(String str, short[] sArr, short[] sArr2) {
        a(str);
        if (!this.b && !Arrays.equals(sArr, sArr2)) {
            this.a.add(new e(str, sArr, sArr2));
        }
        return this;
    }

    public c<T> a(String str, boolean[] zArr, boolean[] zArr2) {
        a(str);
        if (!this.b && !Arrays.equals(zArr, zArr2)) {
            this.a.add(new h(str, zArr, zArr2));
        }
        return this;
    }

    public sdk.pendo.io.x1.d<T> a() {
        return new sdk.pendo.io.x1.d<>(this.c, this.d, this.a, this.e);
    }

    private void a(String str) {
        sdk.pendo.io.w1.h.a(str, "fieldName", new Object[0]);
    }
}
