package sdk.pendo.io.n5;

import sdk.pendo.io.l5.h;
import sdk.pendo.io.l5.i;

/* JADX INFO: loaded from: classes4.dex */
public class b extends Exception {
    private h a;
    private sdk.pendo.io.l5.c b;
    private i c;

    public b(h hVar, sdk.pendo.io.l5.c cVar, Exception exc, String str, i iVar) {
        super(str, exc);
        this.a = hVar;
        this.b = cVar;
        this.c = iVar;
    }

    public <C extends i> C a() {
        return (C) this.c;
    }

    public sdk.pendo.io.l5.c b() {
        return this.b;
    }

    public h c() {
        return this.a;
    }
}
