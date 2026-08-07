package sdk.pendo.io.e1;

import java.util.EnumSet;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements sdk.pendo.io.d1.a.b {
    public static final b b = new b();
    private final sdk.pendo.io.o1.c a = new sdk.pendo.io.o1.a();

    private b() {
    }

    @Override // sdk.pendo.io.d1.a.b
    public sdk.pendo.io.o1.c a() {
        return this.a;
    }

    @Override // sdk.pendo.io.d1.a.b
    public Set<sdk.pendo.io.d1.i> b() {
        return EnumSet.noneOf(sdk.pendo.io.d1.i.class);
    }

    @Override // sdk.pendo.io.d1.a.b
    public sdk.pendo.io.n1.b c() {
        return new sdk.pendo.io.n1.c();
    }
}
