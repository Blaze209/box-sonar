package sdk.pendo.io.j4;

import sdk.pendo.io.k3.j;
import sdk.pendo.io.k3.o;

/* JADX INFO: loaded from: classes4.dex */
public abstract class d<T> extends j<T> implements o<T> {
    public final d<T> l() {
        return this instanceof c ? this : new c(this);
    }
}
