package sdk.pendo.io.j1;

/* JADX INFO: loaded from: classes4.dex */
public class f extends a {
    private Double a = Double.valueOf(0.0d);

    @Override // sdk.pendo.io.j1.a
    protected Number a() {
        return this.a;
    }

    @Override // sdk.pendo.io.j1.a
    protected void a(Number number) {
        this.a = Double.valueOf(this.a.doubleValue() + number.doubleValue());
    }
}
