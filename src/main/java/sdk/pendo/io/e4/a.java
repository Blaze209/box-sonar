package sdk.pendo.io.e4;

import sdk.pendo.io.k3.j;
import sdk.pendo.io.o3.b;
import sdk.pendo.io.q3.e;
import sdk.pendo.io.y3.a0;
import sdk.pendo.io.y3.y;
import sdk.pendo.io.y3.z;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a<T> extends j<T> {
    /* JADX WARN: Multi-variable type inference failed */
    private a<T> l() {
        return this instanceof z ? sdk.pendo.io.g4.a.a((a) new y(((z) this).a())) : this;
    }

    public abstract void c(e<? super b> eVar);

    public j<T> m() {
        return sdk.pendo.io.g4.a.a(new a0(l()));
    }
}
