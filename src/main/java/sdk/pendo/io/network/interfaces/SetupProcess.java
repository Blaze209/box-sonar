package sdk.pendo.io.network.interfaces;

import sdk.pendo.io.e2.c0;
import sdk.pendo.io.e2.e0;
import sdk.pendo.io.k3.j;
import sdk.pendo.io.l4.r;
import sdk.pendo.io.n4.o;

/* JADX INFO: loaded from: classes4.dex */
public interface SetupProcess {
    @o("v2/devices/setup")
    j<r<e0>> send(@sdk.pendo.io.n4.a c0 c0Var);

    @o("v2/devices/debugData")
    j<r<e0>> sendDebugData(@sdk.pendo.io.n4.a c0 c0Var);
}
