package sdk.pendo.io.v1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class a<T> extends sdk.pendo.io.v1.k<T> {
    public static sdk.pendo.io.v1.k<int[]> c = new h(null);
    public static sdk.pendo.io.v1.k<Integer[]> d = new i(null);
    public static sdk.pendo.io.v1.k<short[]> e = new j(null);
    public static sdk.pendo.io.v1.k<Short[]> f = new k(null);
    public static sdk.pendo.io.v1.k<byte[]> g = new l(null);
    public static sdk.pendo.io.v1.k<Byte[]> h = new m(null);
    public static sdk.pendo.io.v1.k<char[]> i = new n(null);
    public static sdk.pendo.io.v1.k<Character[]> j = new o(null);
    public static sdk.pendo.io.v1.k<long[]> k = new p(null);
    public static sdk.pendo.io.v1.k<Long[]> l = new C0500a(null);
    public static sdk.pendo.io.v1.k<float[]> m = new b(null);
    public static sdk.pendo.io.v1.k<Float[]> n = new c(null);
    public static sdk.pendo.io.v1.k<double[]> o = new d(null);
    public static sdk.pendo.io.v1.k<Double[]> p = new e(null);
    public static sdk.pendo.io.v1.k<boolean[]> q = new f(null);
    public static sdk.pendo.io.v1.k<Boolean[]> r = new g(null);

    /* JADX INFO: renamed from: sdk.pendo.io.v1.a$a, reason: collision with other inner class name */
    class C0500a extends a<Long[]> {
        C0500a(sdk.pendo.io.v1.j jVar) {
            super(jVar);
        }

        @Override // sdk.pendo.io.v1.k
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Long[] a(Object obj) {
            List list = (List) obj;
            Long[] lArr = new Long[list.size()];
            int i = 0;
            for (Object obj2 : list) {
                if (obj2 != null) {
                    if (obj2 instanceof Float) {
                        lArr[i] = (Long) obj2;
                    } else {
                        lArr[i] = Long.valueOf(((Number) obj2).longValue());
                    }
                    i++;
                }
            }
            return lArr;
        }
    }

    class b extends a<float[]> {
        b(sdk.pendo.io.v1.j jVar) {
            super(jVar);
        }

        @Override // sdk.pendo.io.v1.k
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public float[] a(Object obj) {
            List list = (List) obj;
            float[] fArr = new float[list.size()];
            Iterator it = list.iterator();
            int i = 0;
            while (it.hasNext()) {
                fArr[i] = ((Number) it.next()).floatValue();
                i++;
            }
            return fArr;
        }
    }

    class c extends a<Float[]> {
        c(sdk.pendo.io.v1.j jVar) {
            super(jVar);
        }

        @Override // sdk.pendo.io.v1.k
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Float[] a(Object obj) {
            List list = (List) obj;
            Float[] fArr = new Float[list.size()];
            int i = 0;
            for (Object obj2 : list) {
                if (obj2 != null) {
                    if (obj2 instanceof Float) {
                        fArr[i] = (Float) obj2;
                    } else {
                        fArr[i] = Float.valueOf(((Number) obj2).floatValue());
                    }
                    i++;
                }
            }
            return fArr;
        }
    }

    class d extends a<double[]> {
        d(sdk.pendo.io.v1.j jVar) {
            super(jVar);
        }

        @Override // sdk.pendo.io.v1.k
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public double[] a(Object obj) {
            List list = (List) obj;
            double[] dArr = new double[list.size()];
            Iterator it = list.iterator();
            int i = 0;
            while (it.hasNext()) {
                dArr[i] = ((Number) it.next()).doubleValue();
                i++;
            }
            return dArr;
        }
    }

    class e extends a<Double[]> {
        e(sdk.pendo.io.v1.j jVar) {
            super(jVar);
        }

        @Override // sdk.pendo.io.v1.k
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Double[] a(Object obj) {
            List list = (List) obj;
            Double[] dArr = new Double[list.size()];
            int i = 0;
            for (Object obj2 : list) {
                if (obj2 != null) {
                    if (obj2 instanceof Double) {
                        dArr[i] = (Double) obj2;
                    } else {
                        dArr[i] = Double.valueOf(((Number) obj2).doubleValue());
                    }
                    i++;
                }
            }
            return dArr;
        }
    }

    class f extends a<boolean[]> {
        f(sdk.pendo.io.v1.j jVar) {
            super(jVar);
        }

        @Override // sdk.pendo.io.v1.k
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean[] a(Object obj) {
            List list = (List) obj;
            boolean[] zArr = new boolean[list.size()];
            Iterator it = list.iterator();
            int i = 0;
            while (it.hasNext()) {
                zArr[i] = ((Boolean) it.next()).booleanValue();
                i++;
            }
            return zArr;
        }
    }

    class g extends a<Boolean[]> {
        g(sdk.pendo.io.v1.j jVar) {
            super(jVar);
        }

        @Override // sdk.pendo.io.v1.k
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean[] a(Object obj) {
            List list = (List) obj;
            Boolean[] boolArr = new Boolean[list.size()];
            int i = 0;
            for (Object obj2 : list) {
                if (obj2 != null) {
                    if (obj2 instanceof Boolean) {
                        boolArr[i] = Boolean.valueOf(((Boolean) obj2).booleanValue());
                    } else {
                        if (!(obj2 instanceof Number)) {
                            throw new RuntimeException("can not convert " + obj2 + " toBoolean");
                        }
                        boolArr[i] = Boolean.valueOf(((Number) obj2).intValue() != 0);
                    }
                    i++;
                }
            }
            return boolArr;
        }
    }

    class h extends a<int[]> {
        h(sdk.pendo.io.v1.j jVar) {
            super(jVar);
        }

        @Override // sdk.pendo.io.v1.k
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int[] a(Object obj) {
            List list = (List) obj;
            int[] iArr = new int[list.size()];
            Iterator it = list.iterator();
            int i = 0;
            while (it.hasNext()) {
                iArr[i] = ((Number) it.next()).intValue();
                i++;
            }
            return iArr;
        }
    }

    class i extends a<Integer[]> {
        i(sdk.pendo.io.v1.j jVar) {
            super(jVar);
        }

        @Override // sdk.pendo.io.v1.k
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Integer[] a(Object obj) {
            List list = (List) obj;
            Integer[] numArr = new Integer[list.size()];
            int i = 0;
            for (Object obj2 : list) {
                if (obj2 != null) {
                    if (obj2 instanceof Integer) {
                        numArr[i] = (Integer) obj2;
                    } else {
                        numArr[i] = Integer.valueOf(((Number) obj2).intValue());
                    }
                    i++;
                }
            }
            return numArr;
        }
    }

    class j extends a<short[]> {
        j(sdk.pendo.io.v1.j jVar) {
            super(jVar);
        }

        @Override // sdk.pendo.io.v1.k
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public short[] a(Object obj) {
            List list = (List) obj;
            short[] sArr = new short[list.size()];
            Iterator it = list.iterator();
            int i = 0;
            while (it.hasNext()) {
                sArr[i] = ((Number) it.next()).shortValue();
                i++;
            }
            return sArr;
        }
    }

    class k extends a<Short[]> {
        k(sdk.pendo.io.v1.j jVar) {
            super(jVar);
        }

        @Override // sdk.pendo.io.v1.k
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Short[] a(Object obj) {
            List list = (List) obj;
            Short[] shArr = new Short[list.size()];
            int i = 0;
            for (Object obj2 : list) {
                if (obj2 != null) {
                    if (obj2 instanceof Short) {
                        shArr[i] = (Short) obj2;
                    } else {
                        shArr[i] = Short.valueOf(((Number) obj2).shortValue());
                    }
                    i++;
                }
            }
            return shArr;
        }
    }

    class l extends a<byte[]> {
        l(sdk.pendo.io.v1.j jVar) {
            super(jVar);
        }

        @Override // sdk.pendo.io.v1.k
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public byte[] a(Object obj) {
            List list = (List) obj;
            byte[] bArr = new byte[list.size()];
            Iterator it = list.iterator();
            int i = 0;
            while (it.hasNext()) {
                bArr[i] = ((Number) it.next()).byteValue();
                i++;
            }
            return bArr;
        }
    }

    class m extends a<Byte[]> {
        m(sdk.pendo.io.v1.j jVar) {
            super(jVar);
        }

        @Override // sdk.pendo.io.v1.k
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Byte[] a(Object obj) {
            List list = (List) obj;
            Byte[] bArr = new Byte[list.size()];
            int i = 0;
            for (Object obj2 : list) {
                if (obj2 != null) {
                    if (obj2 instanceof Byte) {
                        bArr[i] = (Byte) obj2;
                    } else {
                        bArr[i] = Byte.valueOf(((Number) obj2).byteValue());
                    }
                    i++;
                }
            }
            return bArr;
        }
    }

    class n extends a<char[]> {
        n(sdk.pendo.io.v1.j jVar) {
            super(jVar);
        }

        @Override // sdk.pendo.io.v1.k
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public char[] a(Object obj) {
            List list = (List) obj;
            char[] cArr = new char[list.size()];
            Iterator it = list.iterator();
            int i = 0;
            while (it.hasNext()) {
                cArr[i] = it.next().toString().charAt(0);
                i++;
            }
            return cArr;
        }
    }

    class o extends a<Character[]> {
        o(sdk.pendo.io.v1.j jVar) {
            super(jVar);
        }

        @Override // sdk.pendo.io.v1.k
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Character[] a(Object obj) {
            List list = (List) obj;
            Character[] chArr = new Character[list.size()];
            int i = 0;
            for (Object obj2 : list) {
                if (obj2 != null) {
                    chArr[i] = Character.valueOf(obj2.toString().charAt(0));
                    i++;
                }
            }
            return chArr;
        }
    }

    class p extends a<long[]> {
        p(sdk.pendo.io.v1.j jVar) {
            super(jVar);
        }

        @Override // sdk.pendo.io.v1.k
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public long[] a(Object obj) {
            List list = (List) obj;
            long[] jArr = new long[list.size()];
            Iterator it = list.iterator();
            int i = 0;
            while (it.hasNext()) {
                jArr[i] = ((Number) it.next()).intValue();
                i++;
            }
            return jArr;
        }
    }

    public static class q<T> extends a<T> {
        final Class<?> s;
        sdk.pendo.io.v1.k<?> t;

        public q(sdk.pendo.io.v1.j jVar, Class<T> cls) {
            super(jVar);
            this.s = cls.getComponentType();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v3, types: [T, java.lang.Object[]] */
        @Override // sdk.pendo.io.v1.k
        public T a(Object obj) {
            List list = (List) obj;
            ?? r3 = (T) ((Object[]) Array.newInstance(this.s, list.size()));
            Iterator it = list.iterator();
            int i = 0;
            while (it.hasNext()) {
                r3[i] = it.next();
                i++;
            }
            return r3;
        }

        @Override // sdk.pendo.io.v1.k
        public sdk.pendo.io.v1.k<?> b(String str) {
            if (this.t == null) {
                this.t = this.a.a((Class) this.s);
            }
            return this.t;
        }

        @Override // sdk.pendo.io.v1.k
        public sdk.pendo.io.v1.k<?> a(String str) {
            if (this.t == null) {
                this.t = this.a.a((Class) this.s);
            }
            return this.t;
        }
    }

    public a(sdk.pendo.io.v1.j jVar) {
        super(jVar);
    }

    @Override // sdk.pendo.io.v1.k
    public void a(Object obj, Object obj2) {
        ((List) obj).add(obj2);
    }

    @Override // sdk.pendo.io.v1.k
    public Object a() {
        return new ArrayList();
    }
}
