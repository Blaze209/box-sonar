package sdk.pendo.io.network.interfaces;

import sdk.pendo.io.e2.c0;
import sdk.pendo.io.e2.e0;
import sdk.pendo.io.k3.j;
import sdk.pendo.io.l4.r;
import sdk.pendo.io.n4.i;
import sdk.pendo.io.n4.o;
import sdk.pendo.io.n4.y;

/* JADX INFO: loaded from: classes4.dex */
public interface AnalyticsData {
    @o
    j<r<e0>> send(@y String str, @sdk.pendo.io.n4.a c0 c0Var);

    @o
    j<r<e0>> send(@y String str, @sdk.pendo.io.n4.a c0 c0Var, @i("X-Pendo-JWT") String str2, @i("X-Pendo-SigningKeyName") String str3);
}
