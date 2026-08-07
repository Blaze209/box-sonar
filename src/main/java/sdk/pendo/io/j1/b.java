package sdk.pendo.io.j1;

/* JADX INFO: loaded from: classes4.dex */
public class b extends a {
    private Double a;
    private Double b;

    public b() {
        Double dValueOf = Double.valueOf(0.0d);
        this.a = dValueOf;
        this.b = dValueOf;
    }

    @Override // sdk.pendo.io.j1.a
    protected Number a() {
        return this.b.doubleValue() != 0.0d ? Double.valueOf(this.a.doubleValue() / this.b.doubleValue()) : Double.valueOf(0.0d);
    }

    @Override // sdk.pendo.io.j1.a
    protected void a(Number number) {
        this.b = Double.valueOf(this.b.doubleValue() + 1.0d);
        this.a = Double.valueOf(this.a.doubleValue() + number.doubleValue());
    }
}
