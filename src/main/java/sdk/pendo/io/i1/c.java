package sdk.pendo.io.i1;

import sdk.pendo.io.e1.g;

/* JADX INFO: loaded from: classes4.dex */
public class c implements a {
    private final g a;
    private final Object b;
    private final sdk.pendo.io.d1.a c;

    public c(g gVar, Object obj, sdk.pendo.io.d1.a aVar) {
        this.a = gVar;
        this.b = obj;
        this.c = aVar;
    }

    @Override // sdk.pendo.io.i1.a
    public Object get() {
        g gVar = this.a;
        Object obj = this.b;
        return gVar.a(obj, obj, this.c).getValue();
    }
}
