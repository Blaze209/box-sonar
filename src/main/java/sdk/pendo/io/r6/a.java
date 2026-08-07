package sdk.pendo.io.r6;

import sdk.pendo.io.q3.j;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements j<Object> {
    private sdk.pendo.io.t4.a a;

    public a(sdk.pendo.io.t4.a aVar) {
        this.a = aVar;
    }

    @Override // sdk.pendo.io.q3.j
    public boolean test(Object obj) {
        sdk.pendo.io.t4.a aVar = (sdk.pendo.io.t4.a) obj;
        return aVar != null && aVar.equals(this.a);
    }
}
