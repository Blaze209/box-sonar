package sdk.pendo.io.j1;

/* JADX INFO: loaded from: classes4.dex */
public class d extends a {
    private Double a = Double.valueOf(Double.MAX_VALUE);

    @Override // sdk.pendo.io.j1.a
    protected Number a() {
        return this.a;
    }

    @Override // sdk.pendo.io.j1.a
    protected void a(Number number) {
        if (this.a.doubleValue() > number.doubleValue()) {
            this.a = Double.valueOf(number.doubleValue());
        }
    }
}
