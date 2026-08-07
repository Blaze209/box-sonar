package sdk.pendo.io.o1;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.concurrent.Callable;
import sdk.pendo.io.v1.k;

/* JADX INFO: loaded from: classes4.dex */
public class a implements sdk.pendo.io.o1.c {
    private static sdk.pendo.io.v1.j b;
    private final Callable<sdk.pendo.io.v1.j> a;

    /* JADX INFO: renamed from: sdk.pendo.io.o1.a$a, reason: collision with other inner class name */
    class CallableC0441a implements Callable<sdk.pendo.io.v1.j> {
        final /* synthetic */ sdk.pendo.io.v1.j a;

        CallableC0441a(sdk.pendo.io.v1.j jVar) {
            this.a = jVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public sdk.pendo.io.v1.j call() {
            return this.a;
        }
    }

    private static class b extends k<BigDecimal> {
        public b() {
            super(null);
        }

        @Override // sdk.pendo.io.v1.k
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public BigDecimal a(Object obj) {
            if (obj == null) {
                return null;
            }
            return new BigDecimal(obj.toString());
        }
    }

    private static class c extends k<BigInteger> {
        public c() {
            super(null);
        }

        @Override // sdk.pendo.io.v1.k
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public BigInteger a(Object obj) {
            if (obj == null) {
                return null;
            }
            return new BigInteger(obj.toString());
        }
    }

    private static class d extends k<Boolean> {
        public d() {
            super(null);
        }

        @Override // sdk.pendo.io.v1.k
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean a(Object obj) {
            if (obj == null) {
                return null;
            }
            if (Boolean.class.isAssignableFrom(obj.getClass())) {
                return (Boolean) obj;
            }
            throw new sdk.pendo.io.o1.b("can not map a " + obj.getClass() + " to " + Boolean.class.getName());
        }
    }

    private static class e extends k<Date> {
        public e() {
            super(null);
        }

        @Override // sdk.pendo.io.v1.k
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Date a(Object obj) {
            if (obj == null) {
                return null;
            }
            if (Date.class.isAssignableFrom(obj.getClass())) {
                return (Date) obj;
            }
            if (Long.class.isAssignableFrom(obj.getClass())) {
                return new Date(((Long) obj).longValue());
            }
            if (!String.class.isAssignableFrom(obj.getClass())) {
                throw new sdk.pendo.io.o1.b("can not map a " + obj.getClass() + " to " + Date.class.getName());
            }
            try {
                return DateFormat.getInstance().parse(obj.toString());
            } catch (ParseException e) {
                throw new sdk.pendo.io.o1.b(e);
            }
        }
    }

    private static class f extends k<Double> {
        public f() {
            super(null);
        }

        @Override // sdk.pendo.io.v1.k
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Double a(Object obj) {
            if (obj == null) {
                return null;
            }
            if (Double.class.isAssignableFrom(obj.getClass())) {
                return (Double) obj;
            }
            if (Integer.class.isAssignableFrom(obj.getClass())) {
                return Double.valueOf(((Integer) obj).doubleValue());
            }
            if (Long.class.isAssignableFrom(obj.getClass())) {
                return Double.valueOf(((Long) obj).doubleValue());
            }
            if (BigDecimal.class.isAssignableFrom(obj.getClass())) {
                return Double.valueOf(((BigDecimal) obj).doubleValue());
            }
            if (Float.class.isAssignableFrom(obj.getClass())) {
                return Double.valueOf(((Float) obj).doubleValue());
            }
            if (String.class.isAssignableFrom(obj.getClass())) {
                return Double.valueOf(obj.toString());
            }
            throw new sdk.pendo.io.o1.b("can not map a " + obj.getClass() + " to " + Double.class.getName());
        }
    }

    private static class g extends k<Float> {
        public g() {
            super(null);
        }

        @Override // sdk.pendo.io.v1.k
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Float a(Object obj) {
            if (obj == null) {
                return null;
            }
            if (Float.class.isAssignableFrom(obj.getClass())) {
                return (Float) obj;
            }
            if (Integer.class.isAssignableFrom(obj.getClass())) {
                return Float.valueOf(((Integer) obj).floatValue());
            }
            if (Long.class.isAssignableFrom(obj.getClass())) {
                return Float.valueOf(((Long) obj).floatValue());
            }
            if (BigDecimal.class.isAssignableFrom(obj.getClass())) {
                return Float.valueOf(((BigDecimal) obj).floatValue());
            }
            if (Double.class.isAssignableFrom(obj.getClass())) {
                return Float.valueOf(((Double) obj).floatValue());
            }
            if (String.class.isAssignableFrom(obj.getClass())) {
                return Float.valueOf(obj.toString());
            }
            throw new sdk.pendo.io.o1.b("can not map a " + obj.getClass() + " to " + Float.class.getName());
        }
    }

    private static class h extends k<Integer> {
        public h() {
            super(null);
        }

        @Override // sdk.pendo.io.v1.k
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Integer a(Object obj) {
            if (obj == null) {
                return null;
            }
            if (Integer.class.isAssignableFrom(obj.getClass())) {
                return (Integer) obj;
            }
            if (Long.class.isAssignableFrom(obj.getClass())) {
                return Integer.valueOf(((Long) obj).intValue());
            }
            if (Double.class.isAssignableFrom(obj.getClass())) {
                return Integer.valueOf(((Double) obj).intValue());
            }
            if (BigDecimal.class.isAssignableFrom(obj.getClass())) {
                return Integer.valueOf(((BigDecimal) obj).intValue());
            }
            if (Float.class.isAssignableFrom(obj.getClass())) {
                return Integer.valueOf(((Float) obj).intValue());
            }
            if (String.class.isAssignableFrom(obj.getClass())) {
                return Integer.valueOf(obj.toString());
            }
            throw new sdk.pendo.io.o1.b("can not map a " + obj.getClass() + " to " + Integer.class.getName());
        }
    }

    private static class i extends k<Long> {
        public i() {
            super(null);
        }

        @Override // sdk.pendo.io.v1.k
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Long a(Object obj) {
            if (obj == null) {
                return null;
            }
            if (Long.class.isAssignableFrom(obj.getClass())) {
                return (Long) obj;
            }
            if (Integer.class.isAssignableFrom(obj.getClass())) {
                return Long.valueOf(((Integer) obj).longValue());
            }
            if (Double.class.isAssignableFrom(obj.getClass())) {
                return Long.valueOf(((Double) obj).longValue());
            }
            if (BigDecimal.class.isAssignableFrom(obj.getClass())) {
                return Long.valueOf(((BigDecimal) obj).longValue());
            }
            if (Float.class.isAssignableFrom(obj.getClass())) {
                return Long.valueOf(((Float) obj).longValue());
            }
            if (String.class.isAssignableFrom(obj.getClass())) {
                return Long.valueOf(obj.toString());
            }
            throw new sdk.pendo.io.o1.b("can not map a " + obj.getClass() + " to " + Long.class.getName());
        }
    }

    private static class j extends k<String> {
        public j() {
            super(null);
        }

        @Override // sdk.pendo.io.v1.k
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public String a(Object obj) {
            if (obj == null) {
                return null;
            }
            return obj.toString();
        }
    }

    static {
        sdk.pendo.io.v1.j jVar = new sdk.pendo.io.v1.j();
        b = jVar;
        jVar.a(Long.class, new i());
        b.a(Long.TYPE, new i());
        b.a(Integer.class, new h());
        b.a(Integer.TYPE, new h());
        b.a(Double.class, new f());
        b.a(Double.TYPE, new f());
        b.a(Float.class, new g());
        b.a(Float.TYPE, new g());
        b.a(BigDecimal.class, new b());
        b.a(String.class, new j());
        b.a(Date.class, new e());
        b.a(BigInteger.class, new c());
        b.a(Boolean.TYPE, new d());
    }

    public a() {
        this(b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // sdk.pendo.io.o1.c
    public <T> T a(Object obj, Class<T> cls, sdk.pendo.io.d1.a aVar) {
        if (obj == 0) {
            return null;
        }
        if (cls.isAssignableFrom(obj.getClass())) {
            return obj;
        }
        try {
            return (aVar.f().a(obj) || aVar.f().e(obj)) ? (T) sdk.pendo.io.r1.i.a(aVar.f().b(obj), cls) : this.a.call().a((Class) cls).a(obj);
        } catch (Exception e2) {
            throw new sdk.pendo.io.o1.b(e2);
        }
    }

    public a(Callable<sdk.pendo.io.v1.j> callable) {
        this.a = callable;
    }

    public a(sdk.pendo.io.v1.j jVar) {
        this(new CallableC0441a(jVar));
    }
}
