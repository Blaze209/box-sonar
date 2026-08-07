package sdk.pendo.io.j1;

/* JADX INFO: loaded from: classes4.dex */
public class e extends a {
    private Double a;
    private Double b;
    private Double c;

    public e() {
        Double dValueOf = Double.valueOf(0.0d);
        this.a = dValueOf;
        this.b = dValueOf;
        this.c = dValueOf;
    }

    @Override // sdk.pendo.io.j1.a
    protected Number a() {
        return Double.valueOf(Math.sqrt((this.a.doubleValue() / this.c.doubleValue()) - (((this.b.doubleValue() * this.b.doubleValue()) / this.c.doubleValue()) / this.c.doubleValue())));
    }

    @Override // sdk.pendo.io.j1.a
    protected void a(Number number) {
        this.b = Double.valueOf(this.b.doubleValue() + number.doubleValue());
        this.a = Double.valueOf(this.a.doubleValue() + (number.doubleValue() * number.doubleValue()));
        this.c = Double.valueOf(this.c.doubleValue() + 1.0d);
    }
}
