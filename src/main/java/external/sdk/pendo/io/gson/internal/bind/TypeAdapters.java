package external.sdk.pendo.io.gson.internal.bind;

import external.sdk.pendo.io.gson.Gson;
import external.sdk.pendo.io.gson.TypeAdapter;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.slf4j.Marker;
import sdk.pendo.io.a0.i;
import sdk.pendo.io.a0.j;
import sdk.pendo.io.a0.k;
import sdk.pendo.io.a0.l;
import sdk.pendo.io.a0.n;
import sdk.pendo.io.a0.q;
import sdk.pendo.io.a0.u;
import sdk.pendo.io.b0.c;
import sdk.pendo.io.c0.f;
import sdk.pendo.io.h0.b;

/* JADX INFO: loaded from: classes4.dex */
public final class TypeAdapters {
    public static final TypeAdapter<BigInteger> A;
    public static final TypeAdapter<f> B;
    public static final u C;
    public static final TypeAdapter<StringBuilder> D;
    public static final u E;
    public static final TypeAdapter<StringBuffer> F;
    public static final u G;
    public static final TypeAdapter<URL> H;
    public static final u I;
    public static final TypeAdapter<URI> J;
    public static final u K;
    public static final TypeAdapter<InetAddress> L;
    public static final u M;
    public static final TypeAdapter<UUID> N;
    public static final u O;
    public static final TypeAdapter<Currency> P;
    public static final u Q;
    public static final TypeAdapter<Calendar> R;
    public static final u S;
    public static final TypeAdapter<Locale> T;
    public static final u U;
    public static final TypeAdapter<i> V;
    public static final u W;
    public static final u X;
    public static final TypeAdapter<Class> a;
    public static final u b;
    public static final TypeAdapter<BitSet> c;
    public static final u d;
    public static final TypeAdapter<Boolean> e;
    public static final TypeAdapter<Boolean> f;
    public static final u g;
    public static final TypeAdapter<Number> h;
    public static final u i;
    public static final TypeAdapter<Number> j;
    public static final u k;
    public static final TypeAdapter<Number> l;
    public static final u m;
    public static final TypeAdapter<AtomicInteger> n;
    public static final u o;
    public static final TypeAdapter<AtomicBoolean> p;
    public static final u q;
    public static final TypeAdapter<AtomicIntegerArray> r;
    public static final u s;
    public static final TypeAdapter<Number> t;
    public static final TypeAdapter<Number> u;
    public static final TypeAdapter<Number> v;
    public static final TypeAdapter<Character> w;
    public static final u x;
    public static final TypeAdapter<String> y;
    public static final TypeAdapter<BigDecimal> z;

    private static final class EnumTypeAdapter<T extends Enum<T>> extends TypeAdapter<T> {
        private final Map<String, T> a = new HashMap();
        private final Map<T, String> b = new HashMap();

        class a implements PrivilegedAction<Field[]> {
            final /* synthetic */ Class a;

            a(Class cls) {
                this.a = cls;
            }

            @Override // java.security.PrivilegedAction
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Field[] run() {
                Field[] declaredFields = this.a.getDeclaredFields();
                ArrayList arrayList = new ArrayList(declaredFields.length);
                for (Field field : declaredFields) {
                    if (field.isEnumConstant()) {
                        arrayList.add(field);
                    }
                }
                Field[] fieldArr = (Field[]) arrayList.toArray(new Field[0]);
                AccessibleObject.setAccessible(fieldArr, true);
                return fieldArr;
            }
        }

        public EnumTypeAdapter(Class<T> cls) {
            try {
                for (Field field : (Field[]) AccessController.doPrivileged(new a(cls))) {
                    Enum r4 = (Enum) field.get(null);
                    String strName = r4.name();
                    c cVar = (c) field.getAnnotation(c.class);
                    if (cVar != null) {
                        strName = cVar.value();
                        for (String str : cVar.alternate()) {
                            this.a.put(str, (T) r4);
                        }
                    }
                    this.a.put(strName, (T) r4);
                    this.b.put((T) r4, strName);
                }
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }

        @Override // external.sdk.pendo.io.gson.TypeAdapter
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public T a(sdk.pendo.io.h0.a aVar) throws IOException {
            if (aVar.t() != b.NULL) {
                return this.a.get(aVar.r());
            }
            aVar.q();
            return null;
        }

        @Override // external.sdk.pendo.io.gson.TypeAdapter
        public void a(sdk.pendo.io.h0.c cVar, T t) throws IOException {
            cVar.d(t == null ? null : this.b.get(t));
        }
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            a = iArr;
            try {
                iArr[b.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[b.BOOLEAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[b.NULL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[b.BEGIN_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[b.BEGIN_OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[b.END_DOCUMENT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[b.NAME.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[b.END_OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[b.END_ARRAY.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    static {
        TypeAdapter<Class> typeAdapterA = new TypeAdapter<Class>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.1
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Class a(sdk.pendo.io.h0.a aVar) {
                throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.h0.c cVar, Class cls) {
                throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
            }
        }.a();
        a = typeAdapterA;
        b = a(Class.class, typeAdapterA);
        TypeAdapter<BitSet> typeAdapterA2 = new TypeAdapter<BitSet>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.2
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public BitSet a(sdk.pendo.io.h0.a aVar) throws IOException {
                BitSet bitSet = new BitSet();
                aVar.a();
                b bVarT = aVar.t();
                int i2 = 0;
                while (bVarT != b.END_ARRAY) {
                    int i3 = a.a[bVarT.ordinal()];
                    boolean zL = true;
                    if (i3 == 1 || i3 == 2) {
                        int iN = aVar.n();
                        if (iN == 0) {
                            zL = false;
                        } else if (iN != 1) {
                            throw new q("Invalid bitset value " + iN + ", expected 0 or 1; at path " + aVar.h());
                        }
                    } else {
                        if (i3 != 3) {
                            throw new q("Invalid bitset value type: " + bVarT + "; at path " + aVar.getPath());
                        }
                        zL = aVar.l();
                    }
                    if (zL) {
                        bitSet.set(i2);
                    }
                    i2++;
                    bVarT = aVar.t();
                }
                aVar.f();
                return bitSet;
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.h0.c cVar, BitSet bitSet) throws IOException {
                cVar.c();
                int length = bitSet.length();
                for (int i2 = 0; i2 < length; i2++) {
                    cVar.a(bitSet.get(i2) ? 1L : 0L);
                }
                cVar.e();
            }
        }.a();
        c = typeAdapterA2;
        d = a(BitSet.class, typeAdapterA2);
        TypeAdapter<Boolean> typeAdapter = new TypeAdapter<Boolean>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.3
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Boolean a(sdk.pendo.io.h0.a aVar) throws IOException {
                b bVarT = aVar.t();
                if (bVarT != b.NULL) {
                    return bVarT == b.STRING ? Boolean.valueOf(Boolean.parseBoolean(aVar.r())) : Boolean.valueOf(aVar.l());
                }
                aVar.q();
                return null;
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.h0.c cVar, Boolean bool) throws IOException {
                cVar.a(bool);
            }
        };
        e = typeAdapter;
        f = new TypeAdapter<Boolean>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.4
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Boolean a(sdk.pendo.io.h0.a aVar) throws IOException {
                if (aVar.t() != b.NULL) {
                    return Boolean.valueOf(aVar.r());
                }
                aVar.q();
                return null;
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.h0.c cVar, Boolean bool) throws IOException {
                cVar.d(bool == null ? AbstractJsonLexerKt.NULL : bool.toString());
            }
        };
        g = a(Boolean.TYPE, Boolean.class, typeAdapter);
        TypeAdapter<Number> typeAdapter2 = new TypeAdapter<Number>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.5
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Number a(sdk.pendo.io.h0.a aVar) throws IOException {
                if (aVar.t() == b.NULL) {
                    aVar.q();
                    return null;
                }
                try {
                    int iN = aVar.n();
                    if (iN > 255 || iN < -128) {
                        throw new q("Lossy conversion from " + iN + " to byte; at path " + aVar.h());
                    }
                    return Byte.valueOf((byte) iN);
                } catch (NumberFormatException e2) {
                    throw new q(e2);
                }
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.h0.c cVar, Number number) throws IOException {
                cVar.a(number);
            }
        };
        h = typeAdapter2;
        i = a(Byte.TYPE, Byte.class, typeAdapter2);
        TypeAdapter<Number> typeAdapter3 = new TypeAdapter<Number>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.6
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Number a(sdk.pendo.io.h0.a aVar) throws IOException {
                if (aVar.t() == b.NULL) {
                    aVar.q();
                    return null;
                }
                try {
                    int iN = aVar.n();
                    if (iN > 65535 || iN < -32768) {
                        throw new q("Lossy conversion from " + iN + " to short; at path " + aVar.h());
                    }
                    return Short.valueOf((short) iN);
                } catch (NumberFormatException e2) {
                    throw new q(e2);
                }
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.h0.c cVar, Number number) throws IOException {
                cVar.a(number);
            }
        };
        j = typeAdapter3;
        k = a(Short.TYPE, Short.class, typeAdapter3);
        TypeAdapter<Number> typeAdapter4 = new TypeAdapter<Number>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.7
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Number a(sdk.pendo.io.h0.a aVar) throws IOException {
                if (aVar.t() == b.NULL) {
                    aVar.q();
                    return null;
                }
                try {
                    return Integer.valueOf(aVar.n());
                } catch (NumberFormatException e2) {
                    throw new q(e2);
                }
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.h0.c cVar, Number number) throws IOException {
                cVar.a(number);
            }
        };
        l = typeAdapter4;
        m = a(Integer.TYPE, Integer.class, typeAdapter4);
        TypeAdapter<AtomicInteger> typeAdapterA3 = new TypeAdapter<AtomicInteger>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.8
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public AtomicInteger a(sdk.pendo.io.h0.a aVar) {
                try {
                    return new AtomicInteger(aVar.n());
                } catch (NumberFormatException e2) {
                    throw new q(e2);
                }
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.h0.c cVar, AtomicInteger atomicInteger) throws IOException {
                cVar.a(atomicInteger.get());
            }
        }.a();
        n = typeAdapterA3;
        o = a(AtomicInteger.class, typeAdapterA3);
        TypeAdapter<AtomicBoolean> typeAdapterA4 = new TypeAdapter<AtomicBoolean>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.9
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public AtomicBoolean a(sdk.pendo.io.h0.a aVar) {
                return new AtomicBoolean(aVar.l());
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.h0.c cVar, AtomicBoolean atomicBoolean) throws IOException {
                cVar.d(atomicBoolean.get());
            }
        }.a();
        p = typeAdapterA4;
        q = a(AtomicBoolean.class, typeAdapterA4);
        TypeAdapter<AtomicIntegerArray> typeAdapterA5 = new TypeAdapter<AtomicIntegerArray>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.10
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public AtomicIntegerArray a(sdk.pendo.io.h0.a aVar) throws IOException {
                ArrayList arrayList = new ArrayList();
                aVar.a();
                while (aVar.i()) {
                    try {
                        arrayList.add(Integer.valueOf(aVar.n()));
                    } catch (NumberFormatException e2) {
                        throw new q(e2);
                    }
                }
                aVar.f();
                int size = arrayList.size();
                AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
                for (int i2 = 0; i2 < size; i2++) {
                    atomicIntegerArray.set(i2, ((Integer) arrayList.get(i2)).intValue());
                }
                return atomicIntegerArray;
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.h0.c cVar, AtomicIntegerArray atomicIntegerArray) throws IOException {
                cVar.c();
                int length = atomicIntegerArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    cVar.a(atomicIntegerArray.get(i2));
                }
                cVar.e();
            }
        }.a();
        r = typeAdapterA5;
        s = a(AtomicIntegerArray.class, typeAdapterA5);
        t = new TypeAdapter<Number>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.11
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Number a(sdk.pendo.io.h0.a aVar) throws IOException {
                if (aVar.t() == b.NULL) {
                    aVar.q();
                    return null;
                }
                try {
                    return Long.valueOf(aVar.o());
                } catch (NumberFormatException e2) {
                    throw new q(e2);
                }
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.h0.c cVar, Number number) throws IOException {
                cVar.a(number);
            }
        };
        u = new TypeAdapter<Number>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.12
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Number a(sdk.pendo.io.h0.a aVar) throws IOException {
                if (aVar.t() != b.NULL) {
                    return Float.valueOf((float) aVar.m());
                }
                aVar.q();
                return null;
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.h0.c cVar, Number number) throws IOException {
                cVar.a(number);
            }
        };
        v = new TypeAdapter<Number>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.13
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Number a(sdk.pendo.io.h0.a aVar) throws IOException {
                if (aVar.t() != b.NULL) {
                    return Double.valueOf(aVar.m());
                }
                aVar.q();
                return null;
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.h0.c cVar, Number number) throws IOException {
                cVar.a(number);
            }
        };
        TypeAdapter<Character> typeAdapter5 = new TypeAdapter<Character>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.14
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Character a(sdk.pendo.io.h0.a aVar) throws IOException {
                if (aVar.t() == b.NULL) {
                    aVar.q();
                    return null;
                }
                String strR = aVar.r();
                if (strR.length() == 1) {
                    return Character.valueOf(strR.charAt(0));
                }
                throw new q("Expecting character, got: " + strR + "; at " + aVar.h());
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.h0.c cVar, Character ch) throws IOException {
                cVar.d(ch == null ? null : String.valueOf(ch));
            }
        };
        w = typeAdapter5;
        x = a(Character.TYPE, Character.class, typeAdapter5);
        TypeAdapter<String> typeAdapter6 = new TypeAdapter<String>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.15
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public String a(sdk.pendo.io.h0.a aVar) throws IOException {
                b bVarT = aVar.t();
                if (bVarT != b.NULL) {
                    return bVarT == b.BOOLEAN ? Boolean.toString(aVar.l()) : aVar.r();
                }
                aVar.q();
                return null;
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.h0.c cVar, String str) throws IOException {
                cVar.d(str);
            }
        };
        y = typeAdapter6;
        z = new TypeAdapter<BigDecimal>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.16
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public BigDecimal a(sdk.pendo.io.h0.a aVar) throws IOException {
                if (aVar.t() == b.NULL) {
                    aVar.q();
                    return null;
                }
                String strR = aVar.r();
                try {
                    return new BigDecimal(strR);
                } catch (NumberFormatException e2) {
                    throw new q("Failed parsing '" + strR + "' as BigDecimal; at path " + aVar.h(), e2);
                }
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.h0.c cVar, BigDecimal bigDecimal) throws IOException {
                cVar.a(bigDecimal);
            }
        };
        A = new TypeAdapter<BigInteger>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.17
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public BigInteger a(sdk.pendo.io.h0.a aVar) throws IOException {
                if (aVar.t() == b.NULL) {
                    aVar.q();
                    return null;
                }
                String strR = aVar.r();
                try {
                    return new BigInteger(strR);
                } catch (NumberFormatException e2) {
                    throw new q("Failed parsing '" + strR + "' as BigInteger; at path " + aVar.h(), e2);
                }
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.h0.c cVar, BigInteger bigInteger) throws IOException {
                cVar.a(bigInteger);
            }
        };
        B = new TypeAdapter<f>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.18
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public f a(sdk.pendo.io.h0.a aVar) throws IOException {
                if (aVar.t() != b.NULL) {
                    return new f(aVar.r());
                }
                aVar.q();
                return null;
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.h0.c cVar, f fVar) throws IOException {
                cVar.a(fVar);
            }
        };
        C = a(String.class, typeAdapter6);
        TypeAdapter<StringBuilder> typeAdapter7 = new TypeAdapter<StringBuilder>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.19
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public StringBuilder a(sdk.pendo.io.h0.a aVar) throws IOException {
                if (aVar.t() != b.NULL) {
                    return new StringBuilder(aVar.r());
                }
                aVar.q();
                return null;
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.h0.c cVar, StringBuilder sb) throws IOException {
                cVar.d(sb == null ? null : sb.toString());
            }
        };
        D = typeAdapter7;
        E = a(StringBuilder.class, typeAdapter7);
        TypeAdapter<StringBuffer> typeAdapter8 = new TypeAdapter<StringBuffer>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.20
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public StringBuffer a(sdk.pendo.io.h0.a aVar) throws IOException {
                if (aVar.t() != b.NULL) {
                    return new StringBuffer(aVar.r());
                }
                aVar.q();
                return null;
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.h0.c cVar, StringBuffer stringBuffer) throws IOException {
                cVar.d(stringBuffer == null ? null : stringBuffer.toString());
            }
        };
        F = typeAdapter8;
        G = a(StringBuffer.class, typeAdapter8);
        TypeAdapter<URL> typeAdapter9 = new TypeAdapter<URL>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.21
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public URL a(sdk.pendo.io.h0.a aVar) throws IOException {
                if (aVar.t() == b.NULL) {
                    aVar.q();
                    return null;
                }
                String strR = aVar.r();
                if (AbstractJsonLexerKt.NULL.equals(strR)) {
                    return null;
                }
                return new URL(strR);
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.h0.c cVar, URL url) throws IOException {
                cVar.d(url == null ? null : url.toExternalForm());
            }
        };
        H = typeAdapter9;
        I = a(URL.class, typeAdapter9);
        TypeAdapter<URI> typeAdapter10 = new TypeAdapter<URI>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.22
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public URI a(sdk.pendo.io.h0.a aVar) throws IOException {
                if (aVar.t() == b.NULL) {
                    aVar.q();
                    return null;
                }
                try {
                    String strR = aVar.r();
                    if (AbstractJsonLexerKt.NULL.equals(strR)) {
                        return null;
                    }
                    return new URI(strR);
                } catch (URISyntaxException e2) {
                    throw new j(e2);
                }
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.h0.c cVar, URI uri) throws IOException {
                cVar.d(uri == null ? null : uri.toASCIIString());
            }
        };
        J = typeAdapter10;
        K = a(URI.class, typeAdapter10);
        TypeAdapter<InetAddress> typeAdapter11 = new TypeAdapter<InetAddress>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.23
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public InetAddress a(sdk.pendo.io.h0.a aVar) throws IOException {
                if (aVar.t() != b.NULL) {
                    return InetAddress.getByName(aVar.r());
                }
                aVar.q();
                return null;
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.h0.c cVar, InetAddress inetAddress) throws IOException {
                cVar.d(inetAddress == null ? null : inetAddress.getHostAddress());
            }
        };
        L = typeAdapter11;
        M = b(InetAddress.class, typeAdapter11);
        TypeAdapter<UUID> typeAdapter12 = new TypeAdapter<UUID>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.24
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public UUID a(sdk.pendo.io.h0.a aVar) throws IOException {
                if (aVar.t() == b.NULL) {
                    aVar.q();
                    return null;
                }
                String strR = aVar.r();
                try {
                    return UUID.fromString(strR);
                } catch (IllegalArgumentException e2) {
                    throw new q("Failed parsing '" + strR + "' as UUID; at path " + aVar.h(), e2);
                }
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.h0.c cVar, UUID uuid) throws IOException {
                cVar.d(uuid == null ? null : uuid.toString());
            }
        };
        N = typeAdapter12;
        O = a(UUID.class, typeAdapter12);
        TypeAdapter<Currency> typeAdapterA6 = new TypeAdapter<Currency>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.25
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Currency a(sdk.pendo.io.h0.a aVar) throws IOException {
                String strR = aVar.r();
                try {
                    return Currency.getInstance(strR);
                } catch (IllegalArgumentException e2) {
                    throw new q("Failed parsing '" + strR + "' as Currency; at path " + aVar.h(), e2);
                }
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.h0.c cVar, Currency currency) throws IOException {
                cVar.d(currency.getCurrencyCode());
            }
        }.a();
        P = typeAdapterA6;
        Q = a(Currency.class, typeAdapterA6);
        TypeAdapter<Calendar> typeAdapter13 = new TypeAdapter<Calendar>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.26
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Calendar a(sdk.pendo.io.h0.a aVar) throws IOException {
                if (aVar.t() == b.NULL) {
                    aVar.q();
                    return null;
                }
                aVar.b();
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (aVar.t() != b.END_OBJECT) {
                    String strP = aVar.p();
                    int iN = aVar.n();
                    if ("year".equals(strP)) {
                        i2 = iN;
                    } else if ("month".equals(strP)) {
                        i3 = iN;
                    } else if ("dayOfMonth".equals(strP)) {
                        i4 = iN;
                    } else if ("hourOfDay".equals(strP)) {
                        i5 = iN;
                    } else if ("minute".equals(strP)) {
                        i6 = iN;
                    } else if ("second".equals(strP)) {
                        i7 = iN;
                    }
                }
                aVar.g();
                return new GregorianCalendar(i2, i3, i4, i5, i6, i7);
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.h0.c cVar, Calendar calendar) throws IOException {
                if (calendar == null) {
                    cVar.k();
                    return;
                }
                cVar.d();
                cVar.a("year");
                cVar.a(calendar.get(1));
                cVar.a("month");
                cVar.a(calendar.get(2));
                cVar.a("dayOfMonth");
                cVar.a(calendar.get(5));
                cVar.a("hourOfDay");
                cVar.a(calendar.get(11));
                cVar.a("minute");
                cVar.a(calendar.get(12));
                cVar.a("second");
                cVar.a(calendar.get(13));
                cVar.f();
            }
        };
        R = typeAdapter13;
        S = b(Calendar.class, GregorianCalendar.class, typeAdapter13);
        TypeAdapter<Locale> typeAdapter14 = new TypeAdapter<Locale>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.27
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Locale a(sdk.pendo.io.h0.a aVar) throws IOException {
                if (aVar.t() == b.NULL) {
                    aVar.q();
                    return null;
                }
                StringTokenizer stringTokenizer = new StringTokenizer(aVar.r(), "_");
                String strNextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                String strNextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                String strNextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                if (strNextToken2 == null && strNextToken3 == null) {
                    return new Locale(strNextToken);
                }
                return strNextToken3 == null ? new Locale(strNextToken, strNextToken2) : new Locale(strNextToken, strNextToken2, strNextToken3);
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.h0.c cVar, Locale locale) throws IOException {
                cVar.d(locale == null ? null : locale.toString());
            }
        };
        T = typeAdapter14;
        U = a(Locale.class, typeAdapter14);
        TypeAdapter<i> typeAdapter15 = new TypeAdapter<i>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.28
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public i a(sdk.pendo.io.h0.a aVar) throws IOException {
                if (aVar instanceof external.sdk.pendo.io.gson.internal.bind.a) {
                    return ((external.sdk.pendo.io.gson.internal.bind.a) aVar).A();
                }
                switch (a.a[aVar.t().ordinal()]) {
                    case 1:
                        return new n(new f(aVar.r()));
                    case 2:
                        return new n(aVar.r());
                    case 3:
                        return new n(Boolean.valueOf(aVar.l()));
                    case 4:
                        aVar.q();
                        return k.a;
                    case 5:
                        sdk.pendo.io.a0.f fVar = new sdk.pendo.io.a0.f();
                        aVar.a();
                        while (aVar.i()) {
                            fVar.a(a(aVar));
                        }
                        aVar.f();
                        return fVar;
                    case 6:
                        l lVar = new l();
                        aVar.b();
                        while (aVar.i()) {
                            lVar.a(aVar.p(), a(aVar));
                        }
                        aVar.g();
                        return lVar;
                    default:
                        throw new IllegalArgumentException();
                }
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(sdk.pendo.io.h0.c cVar, i iVar) throws IOException {
                if (iVar == null || iVar.i()) {
                    cVar.k();
                    return;
                }
                if (iVar.k()) {
                    n nVarF = iVar.f();
                    if (nVarF.p()) {
                        cVar.a(nVarF.n());
                        return;
                    } else if (nVarF.o()) {
                        cVar.d(nVarF.a());
                        return;
                    } else {
                        cVar.d(nVarF.g());
                        return;
                    }
                }
                if (iVar.h()) {
                    cVar.c();
                    Iterator<i> it = iVar.d().iterator();
                    while (it.hasNext()) {
                        a(cVar, it.next());
                    }
                    cVar.e();
                    return;
                }
                if (!iVar.j()) {
                    throw new IllegalArgumentException("Couldn't write " + iVar.getClass());
                }
                cVar.d();
                for (Map.Entry<String, i> entry : iVar.e().l()) {
                    cVar.a(entry.getKey());
                    a(cVar, entry.getValue());
                }
                cVar.f();
            }
        };
        V = typeAdapter15;
        W = b(i.class, typeAdapter15);
        X = new u() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.29
            @Override // sdk.pendo.io.a0.u
            public <T> TypeAdapter<T> a(Gson gson, sdk.pendo.io.g0.a<T> aVar) {
                Class<? super T> clsA = aVar.a();
                if (!Enum.class.isAssignableFrom(clsA) || clsA == Enum.class) {
                    return null;
                }
                if (!clsA.isEnum()) {
                    clsA = clsA.getSuperclass();
                }
                return new EnumTypeAdapter(clsA);
            }
        };
    }

    public static <TT> u a(final Class<TT> cls, final TypeAdapter<TT> typeAdapter) {
        return new u() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.31
            @Override // sdk.pendo.io.a0.u
            public <T> TypeAdapter<T> a(Gson gson, sdk.pendo.io.g0.a<T> aVar) {
                if (aVar.a() == cls) {
                    return typeAdapter;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    public static <TT> u b(final Class<TT> cls, final Class<? extends TT> cls2, final TypeAdapter<? super TT> typeAdapter) {
        return new u() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.33
            @Override // sdk.pendo.io.a0.u
            public <T> TypeAdapter<T> a(Gson gson, sdk.pendo.io.g0.a<T> aVar) {
                Class<? super T> clsA = aVar.a();
                if (clsA == cls || clsA == cls2) {
                    return typeAdapter;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + Marker.ANY_NON_NULL_MARKER + cls2.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    public static <TT> u a(final Class<TT> cls, final Class<TT> cls2, final TypeAdapter<? super TT> typeAdapter) {
        return new u() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.32
            @Override // sdk.pendo.io.a0.u
            public <T> TypeAdapter<T> a(Gson gson, sdk.pendo.io.g0.a<T> aVar) {
                Class<? super T> clsA = aVar.a();
                if (clsA == cls || clsA == cls2) {
                    return typeAdapter;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls2.getName() + Marker.ANY_NON_NULL_MARKER + cls.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    public static <T1> u b(final Class<T1> cls, final TypeAdapter<T1> typeAdapter) {
        return new u() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.34
            @Override // sdk.pendo.io.a0.u
            public <T2> TypeAdapter<T2> a(Gson gson, sdk.pendo.io.g0.a<T2> aVar) {
                final Class<? super T2> clsA = aVar.a();
                if (cls.isAssignableFrom(clsA)) {
                    return (TypeAdapter<T2>) new TypeAdapter<T1>() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.34.1
                        @Override // external.sdk.pendo.io.gson.TypeAdapter
                        public T1 a(sdk.pendo.io.h0.a aVar2) {
                            T1 t1 = (T1) typeAdapter.a(aVar2);
                            if (t1 == null || clsA.isInstance(t1)) {
                                return t1;
                            }
                            throw new q("Expected a " + clsA.getName() + " but was " + t1.getClass().getName() + "; at path " + aVar2.h());
                        }

                        @Override // external.sdk.pendo.io.gson.TypeAdapter
                        public void a(sdk.pendo.io.h0.c cVar, T1 t1) {
                            typeAdapter.a(cVar, t1);
                        }
                    };
                }
                return null;
            }

            public String toString() {
                return "Factory[typeHierarchy=" + cls.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    public static <TT> u a(final sdk.pendo.io.g0.a<TT> aVar, final TypeAdapter<TT> typeAdapter) {
        return new u() { // from class: external.sdk.pendo.io.gson.internal.bind.TypeAdapters.30
            @Override // sdk.pendo.io.a0.u
            public <T> TypeAdapter<T> a(Gson gson, sdk.pendo.io.g0.a<T> aVar2) {
                if (aVar2.equals(aVar)) {
                    return typeAdapter;
                }
                return null;
            }
        };
    }
}
