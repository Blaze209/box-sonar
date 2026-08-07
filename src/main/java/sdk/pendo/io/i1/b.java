package sdk.pendo.io.i1;

/* JADX INFO: loaded from: classes4.dex */
public class b implements a {
    private final sdk.pendo.io.n1.b a;
    private final sdk.pendo.io.g1.b b;

    public b(sdk.pendo.io.n1.b bVar, sdk.pendo.io.g1.b bVar2) {
        this.a = bVar;
        this.b = bVar2;
    }

    @Override // sdk.pendo.io.i1.a
    public Object get() {
        return this.a.a(this.b.a());
    }
}
