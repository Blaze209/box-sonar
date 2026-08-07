package sdk.pendo.io.a0;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes4.dex */
public final class n extends i {
    private final Object a;

    public n(Boolean bool) {
        this.a = sdk.pendo.io.c0.a.a(bool);
    }

    @Override // sdk.pendo.io.a0.i
    public boolean a() {
        return o() ? ((Boolean) this.a).booleanValue() : Boolean.parseBoolean(g());
    }

    @Override // sdk.pendo.io.a0.i
    public float b() {
        return p() ? n().floatValue() : Float.parseFloat(g());
    }

    @Override // sdk.pendo.io.a0.i
    public int c() {
        return p() ? n().intValue() : Integer.parseInt(g());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n.class != obj.getClass()) {
            return false;
        }
        n nVar = (n) obj;
        if (this.a == null) {
            return nVar.a == null;
        }
        if (a(this) && a(nVar)) {
            return n().longValue() == nVar.n().longValue();
        }
        Object obj2 = this.a;
        if (!(obj2 instanceof Number) || !(nVar.a instanceof Number)) {
            return obj2.equals(nVar.a);
        }
        double dDoubleValue = n().doubleValue();
        double dDoubleValue2 = nVar.n().doubleValue();
        return dDoubleValue == dDoubleValue2 || (Double.isNaN(dDoubleValue) && Double.isNaN(dDoubleValue2));
    }

    @Override // sdk.pendo.io.a0.i
    public String g() {
        if (p()) {
            return n().toString();
        }
        boolean zO = o();
        Object obj = this.a;
        return zO ? ((Boolean) obj).toString() : (String) obj;
    }

    public int hashCode() {
        long jDoubleToLongBits;
        if (this.a == null) {
            return 31;
        }
        if (a(this)) {
            jDoubleToLongBits = n().longValue();
        } else {
            Object obj = this.a;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            jDoubleToLongBits = Double.doubleToLongBits(n().doubleValue());
        }
        return (int) ((jDoubleToLongBits >>> 32) ^ jDoubleToLongBits);
    }

    public double l() {
        return p() ? n().doubleValue() : Double.parseDouble(g());
    }

    public long m() {
        return p() ? n().longValue() : Long.parseLong(g());
    }

    public Number n() {
        Object obj = this.a;
        return obj instanceof String ? new sdk.pendo.io.c0.f((String) obj) : (Number) obj;
    }

    public boolean o() {
        return this.a instanceof Boolean;
    }

    public boolean p() {
        return this.a instanceof Number;
    }

    public boolean q() {
        return this.a instanceof String;
    }

    public n(Number number) {
        this.a = sdk.pendo.io.c0.a.a(number);
    }

    private static boolean a(n nVar) {
        Object obj = nVar.a;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    public n(String str) {
        this.a = sdk.pendo.io.c0.a.a(str);
    }
}
