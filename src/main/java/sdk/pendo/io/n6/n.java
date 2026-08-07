package sdk.pendo.io.n6;

import java.util.Arrays;
import sdk.pendo.io.logging.PendoLogger;

/* JADX INFO: loaded from: classes4.dex */
public final class n implements sdk.pendo.io.a5.a.InterfaceC0343a {
    @Override // sdk.pendo.io.a5.a.InterfaceC0343a
    public void call(Object... objArr) {
        PendoLogger.d("SocketIO device got terminate: " + (objArr != null ? Arrays.toString(objArr) : "args is null"), new Object[0]);
        sdk.pendo.io.k6.a.a.f();
    }
}
