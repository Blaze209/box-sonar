package sdk.pendo.io.t4;

import javax.annotation.ParametersAreNonnullByDefault;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import sdk.pendo.io.k3.j;
import sdk.pendo.io.k3.m;
import sdk.pendo.io.k3.n;

/* JADX INFO: loaded from: classes5.dex */
@ParametersAreNonnullByDefault
public final class d<T> implements n<T, T>, sdk.pendo.io.k3.f<T, T> {
    final j<?> a;

    d(j<?> jVar) {
        sdk.pendo.io.u4.a.a(jVar, "observable == null");
        this.a = jVar;
    }

    @Override // sdk.pendo.io.k3.f
    public sdk.pendo.io.j3.a<T> a(sdk.pendo.io.k3.d<T> dVar) {
        return dVar.b(this.a.a(sdk.pendo.io.k3.a.LATEST));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        return this.a.equals(((d) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "LifecycleTransformer{observable=" + this.a + AbstractJsonLexerKt.END_OBJ;
    }

    @Override // sdk.pendo.io.k3.n
    public m<T> a(j<T> jVar) {
        return jVar.d(this.a);
    }
}
