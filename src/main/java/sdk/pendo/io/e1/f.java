package sdk.pendo.io.e1;

import sdk.pendo.io.d1.j;

/* JADX INFO: loaded from: classes4.dex */
public class f implements j {
    private final sdk.pendo.io.d1.a a;

    public f(sdk.pendo.io.d1.a aVar) {
        this.a = aVar;
    }

    @Override // sdk.pendo.io.d1.j
    public sdk.pendo.io.d1.b a(String str) {
        i.a(str, "json string can not be null or empty", new Object[0]);
        return new e(this.a.f().a(str), this.a);
    }
}
